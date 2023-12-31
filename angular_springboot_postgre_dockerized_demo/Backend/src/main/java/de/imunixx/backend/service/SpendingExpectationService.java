package de.imunixx.backend.service;

import de.imunixx.backend.exception.SpendingExpectationNotFound;
import de.imunixx.api.entity.SpendingExpectation;
import de.imunixx.backend.repository.SpendingExpectationRepo;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SpendingExpectationService {

    private final SpendingExpectationRepo spendingExpectationRepo;

    @Autowired
    public SpendingExpectationService(SpendingExpectationRepo spendingExpectationRepo) { this.spendingExpectationRepo = spendingExpectationRepo; }
    public SpendingExpectation addSpendingExpectation(SpendingExpectation spendingExpectation) { return spendingExpectationRepo.save(spendingExpectation); }
    public List<SpendingExpectation> findAllProfileSpendingExpectations(Long profileId) { return spendingExpectationRepo.findByProfileId(profileId); }
    public SpendingExpectation findSpendingExpectationById(long id){
        return spendingExpectationRepo.findSpendingExpectationById(id)
                .orElseThrow(()-> new SpendingExpectationNotFound("Spending Expectation by id" + id + "was not found"));
    }
    public SpendingExpectation updateSpendingExpectation(SpendingExpectation spendingExpectation) { return spendingExpectationRepo.save(spendingExpectation); }
    public void deleteSpendingExpectation (Long id) {spendingExpectationRepo.deleteSpendingExpectationById(id); }
}
