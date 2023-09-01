package lk.ijse.dep10.app.repository;

import lk.ijse.dep10.app.entity.Detail;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail,Integer> {

    public List<Detail> findDetailByInvoiceId(Integer invoiceId, Sort DetailId);
}
