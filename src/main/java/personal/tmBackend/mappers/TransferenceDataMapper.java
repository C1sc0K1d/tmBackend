package personal.tmBackend.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import personal.tmBackend.dtos.TransferenceDataDto;
import personal.tmBackend.entities.TransferenceData;
import personal.tmBackend.requests.TransferenceDataRequest;
import personal.tmBackend.responses.TransferenceDataListResponse;
import personal.tmBackend.responses.TransferenceDataResponse;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TransferenceDataMapper {

    public TransferenceData toTransferenceData(@Valid TransferenceDataRequest transferenceDataRequest, String tax) {
        return TransferenceData.builder()
                .accountOrigin(transferenceDataRequest.getAccountOrigin())
                .destiniAccount(transferenceDataRequest.getDestiniAccount())
                .transferValue(transferenceDataRequest.getTransferValue())
                .tax(tax)
                .transferDate(LocalDate.parse(transferenceDataRequest.getTransferDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .transferAppointmentDate(LocalDate.now()).build();

    }

    public TransferenceDataDto toTransferenceDataDto(TransferenceData transferenceData) {
        return TransferenceDataDto.builder()
                .id(transferenceData.getId())
                .accountOrigin(transferenceData.getAccountOrigin())
                .destiniAccount(transferenceData.getDestiniAccount())
                .transferValue(transferenceData.getTransferValue())
                .tax(transferenceData.getTax())
                .transferDate(transferenceData.getTransferDate())
                .transferAppointmentDate(transferenceData.getTransferAppointmentDate()).build();
    }

    public List<TransferenceDataDto> toListTransferenceDataDto(List<TransferenceData> transferenceData) {
        return transferenceData.stream().map(this::toTransferenceDataDto).collect(Collectors.toList());
    }

    public TransferenceDataResponse toSingleResult(TransferenceData transferenceData) {
        return TransferenceDataResponse.builder().transferenceDataResponse(this.toTransferenceDataDto(transferenceData)).build();
    }

    public TransferenceDataListResponse toListResult(List<TransferenceData> transferenceData) {
        return TransferenceDataListResponse.builder().transferencesDatasResponse(this.toListTransferenceDataDto(transferenceData)).build();
    }
}
