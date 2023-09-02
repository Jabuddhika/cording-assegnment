package lk.ijse.dep10.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@SqlResultSetMapping(
        name = "InvoiceDTO",
        classes = @ConstructorResult(
                targetClass = InvoiceDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "receiver", type = String.class),
                        @ColumnResult(name = "sender", type = String.class),
                        @ColumnResult(name = "total_amount", type = BigDecimal.class),
                        @ColumnResult(name = "totalPaidAmount", type = BigDecimal.class)
                }
        )
)
@NamedNativeQuery(
        name = "Invoice.findAllInvoicesWithSortingAndPaging",
        query = "SELECT i.id, i.receiver, i.sender, i.total_amount, sum(d.paid_amount) as totalPaidAmount " +
                "FROM code_app.invoice as i " +
                "LEFT JOIN code_app.detail d on i.id = d.invoice_id " +
                "GROUP BY i.id",
        resultSetMapping = "InvoiceDTO"
)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO implements Serializable {

    private Integer id;

    private String sender;

    private String receiver;

    private BigDecimal totalAmount;

    private BigDecimal totalPaidAmount;



}
