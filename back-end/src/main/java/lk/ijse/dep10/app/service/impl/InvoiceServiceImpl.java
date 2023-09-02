package lk.ijse.dep10.app.service.impl;

import lk.ijse.dep10.app.dto.DetailDTO2;
import lk.ijse.dep10.app.dto.InvoiceDTO;
import lk.ijse.dep10.app.repository.DetailRepository;
import lk.ijse.dep10.app.repository.InvoiceRepository;
import lk.ijse.dep10.app.repository.QueryRepository;
import lk.ijse.dep10.app.service.InvoiceService;
import lk.ijse.dep10.app.service.exception.BOException;
import lk.ijse.dep10.app.service.exception.RecordNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final DetailRepository detailRepository;


    private final QueryRepository queryRepository;

    private final ModelMapper mapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, DetailRepository detailRepository, QueryRepository queryRepository, ModelMapper mapper) {
        this.invoiceRepository = invoiceRepository;
        this.detailRepository = detailRepository;
        this.queryRepository = queryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<InvoiceDTO> findAllInvoicesWithPaging(int page,int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<InvoiceDTO> invoiceDTOList = invoiceRepository.findAllInvoicesWithPaging(pageable).stream().
                map(elm -> mapper.map(elm, InvoiceDTO.class)).collect(Collectors.toList());

        invoiceDTOList.stream().forEach(elm->{
            BigDecimal totalPaidAmount = null;
            try {
                totalPaidAmount = findTotalPaidAmountByQuery(elm.getId()).getTotalPaidAmount();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            elm.setTotalPaidAmount(totalPaidAmount);

        });

        return invoiceDTOList;

    }
    @Override
    public List<InvoiceDTO> findAllInvoicesWithSortingAndPaging(int page,int size,String sortValue) {
        Sort id = Sort.by(Sort.Direction.ASC,sortValue);
        Pageable pageable = PageRequest.of(page, size,id);
        return invoiceRepository.findAllInvoicesWithSortingAndPaging(pageable).stream().map(elm->mapper.map(elm,InvoiceDTO.class)).collect(Collectors.toList());
    }


    @Override
    public DetailDTO2 findTotalPaidAmountByQuery(Integer invoiceId) throws Exception {
        return queryRepository.findTotalPaidAmountByQuery(invoiceId)
                .orElseThrow(() -> new RecordNotFoundException("No invoiceId Not found: " + invoiceId));
    }




}
