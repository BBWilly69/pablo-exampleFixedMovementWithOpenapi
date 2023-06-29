package de.imunixx.backend.controller;

import de.imunixx.api.entity.Movement;
import de.imunixx.backend.service.MovementService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movement")
@CrossOrigin

public class MovementController {

    public final MovementService movementService;

    public MovementController(MovementService movementService) { this.movementService = movementService; }

    @GetMapping("/{profileId}/all")
    public ResponseEntity<List<Movement>> getAllProfileMovements(@PathVariable("profileId") Long profileId) {
        List<Movement> movements = movementService.findAllProfileMovements(profileId);
        return new ResponseEntity<>(movements, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Movement> addMovement(@RequestBody Movement movement) {
        Movement newMovement = movementService.addMovement(movement);
        return new ResponseEntity<>(newMovement, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Movement> updateMovement(@RequestBody Movement movement) {
        Movement updateMovement = movementService.updateMovement(movement);
        return new ResponseEntity<>(updateMovement, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovement(@PathVariable("id") Long id) {
        movementService.deleteMovement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
