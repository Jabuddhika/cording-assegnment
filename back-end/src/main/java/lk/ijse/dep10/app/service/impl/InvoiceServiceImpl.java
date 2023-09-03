package lk.ijse.dep10.app.service.impl;

import lk.ijse.dep10.app.dto.DetailDTO2;
import lk.ijse.dep10.app.dto.InvoiceDTO;
import lk.ijse.dep10.app.repository.DetailRepository;
import lk.ijse.dep10.app.repository.InvoiceRepository;
import lk.ijse.dep10.app.repository.QueryRepository;
import lk.ijse.dep10.app.service.InvoiceService;
import lk.ijse.dep10.app.service.exception.RecordNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final QueryRepository queryRepository;

    private final ModelMapper mapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,QueryRepository queryRepository, ModelMapper mapper) {
        this.invoiceRepository = invoiceRepository;
        this.queryRepository = queryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<InvoiceDTO> findAllInvoicesWithPaging(int page,int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<InvoiceDTO> invoiceDTOList = invoiceRepository.findAll(pageable).stream().
                map(elm -> mapper.map(elm, InvoiceDTO.class)).collect(Collectors.toList());

      return setTotalPaidAmountWithFullCount(invoiceDTOList);

    }
    @Override
    public List<InvoiceDTO> findAllInvoicesWithSortingAndPaging(int page,int size,String sortValue) {
        Sort id = Sort.by(Sort.Direction.DESC,sortValue);
        Pageable pageable = PageRequest.of(page, size,id);
        List<InvoiceDTO> invoiceDTOList = invoiceRepository.findAll(pageable).stream().
                map(elm -> mapper.map(elm, InvoiceDTO.class)).collect(Collectors.toList());

      return setTotalPaidAmountWithFullCount(invoiceDTOList);

    }


    @Override
    public Optional<DetailDTO2> findTotalPaidAmountByQuery(Integer invoiceId)   {
        try {
            return Optional.of(queryRepository.findTotalPaidAmountByQuery(invoiceId));
        } catch (Exception e) {
           return Optional.empty();
        }
    }

    @Override
    public long getInvoicesCount() {

        return invoiceRepository.count();
    }


    private List<InvoiceDTO> setTotalPaidAmountWithFullCount(List<InvoiceDTO> invoiceDTOList){
        invoiceDTOList.stream().forEach(elm->{


            if(findTotalPaidAmountByQuery(elm.getId()).isPresent()){
                elm.setTotalPaidAmount(findTotalPaidAmountByQuery(elm.getId()).get().getTotalPaidAmount());
            }else {
                elm.setTotalPaidAmount(new BigDecimal(0));
            }

        });
        return invoiceDTOList;

    }




}
