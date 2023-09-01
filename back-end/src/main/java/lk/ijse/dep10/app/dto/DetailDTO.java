package lk.ijse.dep10.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDTO implements Serializable {

    private Integer detailId;

    private BigDecimal paidAmount;

    public DetailDTO(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }
}
