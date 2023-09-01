package lk.ijse.dep10.app.service.impl;

import lk.ijse.dep10.app.dto.InvoiceDTO;
import lk.ijse.dep10.app.repository.InvoiceRepository;
import lk.ijse.dep10.app.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final ModelMapper mapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, ModelMapper mapper) {
        this.invoiceRepository = invoiceRepository;
        this.mapper = mapper;
    }

    @Override
    public List<InvoiceDTO> findAllInvoicesWithPaging(int page,int size) {
        Pageable pageable = PageRequest.of(page, size);
        return invoiceRepository.findAll(pageable).stream().map(elm->mapper.map(elm,InvoiceDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDTO> findAllInvoicesWithSortingAndPaging(int page,int size,String sortValue) {
        Sort id = Sort.by(Sort.Direction.DESC,sortValue);
        Pageable pageable = PageRequest.of(page, size,id);
        return invoiceRepository.findAll(pageable).stream().map(elm->mapper.map(elm,InvoiceDTO.class)).collect(Collectors.toList());
    }
}
