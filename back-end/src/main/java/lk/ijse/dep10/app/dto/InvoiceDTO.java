package lk.ijse.dep10.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
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


    public InvoiceDTO(String sender, String receiver, BigDecimal totalAmount) {
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
    }
}
