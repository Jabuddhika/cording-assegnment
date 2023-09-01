package lk.ijse.dep10.app.service.impl;

import lk.ijse.dep10.app.dto.InvoiceDTO;
import lk.ijse.dep10.app.repository.InvoiceRepository;
import lk.ijse.dep10.app.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<InvoiceDTO> findAllInvoices() {
        return invoiceRepository.findAll().stream().map(elm->mapper.map(elm,InvoiceDTO.class)).collect(Collectors.toList());
    }
}
