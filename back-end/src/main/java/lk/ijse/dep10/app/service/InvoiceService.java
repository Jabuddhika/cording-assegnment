package lk.ijse.dep10.app.service;

import lk.ijse.dep10.app.dto.DetailDTO;
import lk.ijse.dep10.app.dto.DetailDTO2;
import lk.ijse.dep10.app.dto.InvoiceDTO;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

     List<InvoiceDTO> findAllInvoicesWithSortingDesAndPaging(int page,int size,String sortValue);

     List<InvoiceDTO> findAllInvoicesWithSortingAseAndPaging(Integer page, Integer size, String sortParam);


     List<InvoiceDTO> findAllInvoicesWithPaging(int page,int size);

     Optional<DetailDTO2> findTotalPaidAmountByQuery(Integer invoiceId) throws Exception;

     long getInvoicesCount();


}
