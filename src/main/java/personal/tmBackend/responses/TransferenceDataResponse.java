package personal.tmBackend.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import personal.tmBackend.dtos.TransferenceDataDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferenceDataResponse {
    private TransferenceDataDto transferenceDataResponse;
}
