package de.imunixx.backend.repository;

import de.imunixx.api.entity.FixedMovement;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedMovementRepo extends JpaRepository<FixedMovement, Long> {
    List<FixedMovement> findByProfileId(Long profileId);
    Optional<FixedMovement> findFixedMovementById(Long id);
    void deleteFixedMovementById(Long id);
}
