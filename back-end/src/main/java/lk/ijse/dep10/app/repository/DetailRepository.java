package lk.ijse.dep10.app.repository;

import lk.ijse.dep10.app.dto.DetailDTO2;
import lk.ijse.dep10.app.entity.Detail;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail,Integer> {

    List<Detail> findDetailByInvoiceId(Integer invoiceId, Sort DetailId);

    List<Detail> findDetailByInvoiceId(Integer invoiceId);


}