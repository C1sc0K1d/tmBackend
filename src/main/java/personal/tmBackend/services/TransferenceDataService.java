package personal.tmBackend.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import personal.tmBackend.dtos.TransferenceDataDto;
import personal.tmBackend.entities.TransferenceData;
import personal.tmBackend.mappers.TransferenceDataMapper;
import personal.tmBackend.repositories.TransferenceDataRepository;
import personal.tmBackend.requests.TransferenceDataRequest;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class TransferenceDataService {

    private final TransferenceDataRepository repository;
    private final TransferenceDataMapper mapper;

    @Transactional(readOnly = true)
    public List<TransferenceDataDto> findAll() {
        List<TransferenceData> transferesncesData = repository.findAll();
        return this.mapper.toListTransferenceDataDto(transferesncesData);
    }

    public TransferenceData transfer(TransferenceDataRequest request) {

        var tax = calculateTax(request.getTransferValue(), request.getTransferDate());

        if (tax.isBlank() || tax.isEmpty()){
            TransferenceData data = mapper.toTransferenceData(request, tax);
            return data;
        }

        TransferenceData data = mapper.toTransferenceData(request, tax);
        this.repository.save(data);
        return data;
    }

    private String calculateTax(Double value, String transferDate) {
        LocalDate transfDate = LocalDate.parse(transferDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Period period = Period.between(LocalDate.now(), transfDate);
        String taxes;

        if(period.getDays() == 0 && value <= 1000) taxes = "3%, $3";
        else if((period.getDays() > 0 && period.getDays() < 10) && (value > 1000 && value <= 2000)) taxes = "$12";
        else if((period.getDays() > 10 && period.getDays() < 20) && (value > 2000)) taxes = "8.2%";
        else if((period.getDays() > 20 && period.getDays() < 30) && (value > 2000)) taxes = "6.4%";
        else if((period.getDays() > 30 && period.getDays() < 40) && (value > 2000)) taxes = "4.7%";
        else if(period.getDays() > 40 && value > 2000) taxes = "1.7%";
        else return taxes = "";

        return taxes;

    }
}
