package lk.ijse.dep10.app.api;

import lk.ijse.dep10.app.dto.DetailDTO;
import lk.ijse.dep10.app.service.DetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/details")
@CrossOrigin
public class DetailRestController {

    private final DetailService detailService;

    public DetailRestController(DetailService detailService) {

        this.detailService = detailService;
    }

    @GetMapping("/{invoiceId}")
    public List<DetailDTO> getAllDetails(@PathVariable Integer invoiceId){
        return detailService.findDetailByInvoiceIdWithSort(invoiceId);
    }

}
