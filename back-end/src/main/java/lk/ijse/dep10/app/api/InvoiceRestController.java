package lk.ijse.dep10.app.api;

import lk.ijse.dep10.app.dto.InvoiceDTO;
import lk.ijse.dep10.app.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
@CrossOrigin
public class InvoiceRestController {

    private final InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    @GetMapping("/{page}/{size}")
    public List<InvoiceDTO> getAllInvoicesWithPaging(@PathVariable Integer page, @PathVariable Integer size){
        return invoiceService.findAllInvoicesWithPaging(page,size);
    }

    @GetMapping("/{page}/{size}/{id}")
    public List<InvoiceDTO> getAllInvoicesWithSortingAndPaging(@PathVariable Integer page, @PathVariable Integer size, @PathVariable(value = "id") String sortParam){
        return invoiceService.findAllInvoicesWithSortingAndPaging(page,size,sortParam);
    }


}
