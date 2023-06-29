package de.imunixx.backend.repository;

import de.imunixx.api.entity.SpendingExpectation;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpendingExpectationRepo extends JpaRepository<SpendingExpectation, Long> {

    List<SpendingExpectation> findByProfileId(Long profileId);
    Optional<SpendingExpectation> findSpendingExpectationById(Long id);
    void deleteSpendingExpectationById(Long id);
}
