package de.imunixx.backend.repository;

import de.imunixx.api.entity.Movement;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepo extends JpaRepository<Movement, Long> {

    List<Movement> findByProfile_Id(Long profileId);
    Optional<Movement> findMovementById(Long id);
    void deleteMovementById(Long id);
}
