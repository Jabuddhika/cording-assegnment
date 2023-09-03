package lk.ijse.dep10.app.repository;
import lk.ijse.dep10.app.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

}
