package lk.ijse.dep10.app.service;

import lk.ijse.dep10.app.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceService {

    public List<InvoiceDTO> findAllInvoices();
}
