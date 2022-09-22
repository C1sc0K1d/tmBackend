package personal.tmBackend.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferenceDataDto {

    private Long id;

    private String accountOrigin;

    private String destiniAccount;

    private Double transferValue;

    private String tax;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate transferDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate transferAppointmentDate;
}
