package lk.ijse.dep10.app.service;

import lk.ijse.dep10.app.dto.DetailDTO;
import lk.ijse.dep10.app.dto.DetailDTO2;
import lk.ijse.dep10.app.entity.Detail;

import java.util.List;

public interface DetailService {
    public List<DetailDTO> findDetailByInvoiceIdWithSort(Integer invoiceId);




}
