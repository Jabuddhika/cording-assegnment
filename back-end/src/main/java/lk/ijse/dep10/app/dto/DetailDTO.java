package lk.ijse.dep10.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDTO {

    private Integer detailId;

    private BigDecimal paidAmount;

    public DetailDTO(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }
}
