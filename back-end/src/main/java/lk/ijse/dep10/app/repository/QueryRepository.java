package lk.ijse.dep10.app.repository;

import lk.ijse.dep10.app.dto.DetailDTO2;

import java.util.List;

public interface QueryRepository {

    DetailDTO2 findOrdersByQuery(Integer invoiceId);
}
