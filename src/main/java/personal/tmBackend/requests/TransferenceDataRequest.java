package personal.tmBackend.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferenceDataRequest {

    private String accountOrigin;

    private String destiniAccount;

    private Double transferValue;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private String transferDate;

}
