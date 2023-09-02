package lk.ijse.dep10.app.repository;

import lk.ijse.dep10.app.dto.InvoiceDTO;
import lk.ijse.dep10.app.entity.Invoice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    @Query(nativeQuery = true,value = "SELECT i.id,i.receiver,i.sender,i.total_amount," +
            "sum(d.paid_amount) as totalPaidAmount FROM code_app.invoice as i LEFT JOIN code_app.detail d " +
            "on i.id = d.invoice_id group by i.id",countQuery = "SELECT COUNT(*) FROM code_app.invoice")

    public List<Invoice> findAllInvoicesWithPaging(Pageable pageable);



    @Query(nativeQuery = true,value = "SELECT i.id,i.receiver,i.sender,i.total_amount,sum(d.paid_amount) as totalPaidAmount  " +
            "  FROM code_app.invoice as i LEFT JOIN code_app.detail d on i.id = d.invoice_id " +
            "group by i.id",countQuery = "SELECT COUNT(*) FROM code_app.invoice")

    public List<Invoice> findAllInvoicesWithSortingAndPaging(Pageable pageable);


}
