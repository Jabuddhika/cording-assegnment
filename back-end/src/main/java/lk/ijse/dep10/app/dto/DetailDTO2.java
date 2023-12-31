package lk.ijse.dep10.app.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailDTO2 implements Serializable{

    private Integer invoiceId;

    private BigDecimal totalPaidAmount;

}
