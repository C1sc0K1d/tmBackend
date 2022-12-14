package personal.tmBackend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_TRANFERENCE_DATA")
public class TransferenceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_origin")
    private String accountOrigin;

    @Column(name = "destini_account")
    private String destiniAccount;

    @Column(name = "transfer_value")
    private Double transferValue;

    @Column(name = "tax")
    private String tax;

    @Column(name = "transfer_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate transferDate;

    @Column(name = "transfer_appointment_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate transferAppointmentDate;

}
