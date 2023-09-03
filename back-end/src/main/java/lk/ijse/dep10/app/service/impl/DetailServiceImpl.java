package lk.ijse.dep10.app.service.impl;

import lk.ijse.dep10.app.dto.DetailDTO;
import lk.ijse.dep10.app.repository.DetailRepository;
import lk.ijse.dep10.app.repository.InvoiceRepository;
import lk.ijse.dep10.app.service.DetailService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DetailServiceImpl implements DetailService {

    private final DetailRepository detailRepository;
    private final ModelMapper mapper;

    public DetailServiceImpl(DetailRepository detailRepository,ModelMapper mapper) {
        this.detailRepository = detailRepository;
        this.mapper = mapper;
    }

    //find the detail using invoice id
    @Override
    public List<DetailDTO> findDetailByInvoiceIdWithSort(Integer invoiceId) {
        Sort id = Sort.by(Sort.Direction.ASC,"id");
        return detailRepository.findDetailByInvoiceId(invoiceId,id).stream().map(elm->mapper.map(elm, DetailDTO.class)).collect(Collectors.toList());
    }



}
