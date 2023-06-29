package de.imunixx.backend.service;

import de.imunixx.backend.exception.MovementNotFoundException;
import de.imunixx.api.entity.Movement;
import de.imunixx.backend.repository.MovementRepo;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovementService {

    private final MovementRepo movementRepo;

    @Autowired
    public MovementService(MovementRepo movementRepo) { this.movementRepo = movementRepo; }

    public Movement addMovement(Movement movement) { return movementRepo.save(movement); }

    public List<Movement> findAllProfileMovements(Long profileId) { return movementRepo.findByProfile_Id(profileId); }

    public Movement findMovementById(Long id) {
        return movementRepo.findMovementById(id)
                .orElseThrow(()-> new MovementNotFoundException("Movement by id" + id + "was not found"));
    }

    public Movement updateMovement(Movement movement) { return movementRepo.save(movement); }

    public void deleteMovement(Long id) { movementRepo.deleteMovementById(id); }

}
