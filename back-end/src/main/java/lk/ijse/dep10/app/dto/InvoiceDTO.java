package lk.ijse.dep10.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO implements Serializable {

    private Integer id;

    private String sender;

    private String receiver;

    private BigDecimal totalAmount;

    private BigDecimal totalPaidAmount;

    private long totalPages;




}
