package personal.tmBackend.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import personal.tmBackend.dtos.TransferenceDataDto;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferenceDataListResponse {
    private List<TransferenceDataDto> transferencesDatasResponse;
}
