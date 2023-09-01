package lk.ijse.dep10.app.service;

import lk.ijse.dep10.app.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceService {

    public List<InvoiceDTO> findAllInvoicesWithSortingAndPaging(int page,int size,String sortValue);

    public List<InvoiceDTO> findAllInvoicesWithPaging(int page,int size);
}
