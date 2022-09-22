package personal.tmBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.tmBackend.entities.TransferenceData;

public interface TransferenceDataRepository extends JpaRepository<TransferenceData, Long> {
}
