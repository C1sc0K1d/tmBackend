package personal.tmBackend.dtos;

import lombok.*;

import javax.persistence.Entity;
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

    private Double tax;

    private LocalDateTime transferDate;

    private LocalDateTime transferAppointmentDate;
}
