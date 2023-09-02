package lk.ijse.dep10.app.repository;

import lk.ijse.dep10.app.dto.DetailDTO2;

import java.util.List;
import java.util.Optional;

public interface QueryRepository {

    Optional<DetailDTO2> findTotalPaidAmountByQuery(Integer invoiceId) throws Exception;
}
