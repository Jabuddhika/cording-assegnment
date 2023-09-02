package lk.ijse.dep10.app.repository.impl;

import lk.ijse.dep10.app.dto.DetailDTO2;
import lk.ijse.dep10.app.repository.QueryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class QueryRepositoryImpl implements QueryRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public DetailDTO2 findOrdersByQuery(Integer invoiceId) {

        String query = "SELECT invoice_id as invoiceId,SUM(paid_amount) as totalPaidAmount FROM code_app.detail WHERE invoice_id=? GROUP BY invoice_id";

        try {
            Tuple tuple = (Tuple) entityManager.createNativeQuery(query, Tuple.class).setParameter(1, invoiceId).getSingleResult();
            return new DetailDTO2(tuple.get("invoiceId", Integer.class), tuple.get("totalPaidAmount", BigDecimal.class));

        } catch (NoResultException ex) {
            return null;
        }


    }

}
