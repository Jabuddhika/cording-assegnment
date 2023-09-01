package lk.ijse.dep10.app.api;

import lk.ijse.dep10.app.dto.InvoiceDTO;
import lk.ijse.dep10.app.service.InvoiceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
@CrossOrigin
public class InvoiceRestController {

    private final InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<InvoiceDTO> getAllInvoices(){
       return invoiceService.findAllInvoices();
    }


}
