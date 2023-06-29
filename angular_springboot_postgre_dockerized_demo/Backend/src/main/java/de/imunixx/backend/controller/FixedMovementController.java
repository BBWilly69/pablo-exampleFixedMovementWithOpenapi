package de.imunixx.backend.controller;

import de.imunixx.api.controller.FixedMovementApi;
import de.imunixx.api.model.FixedMovementDto;
import de.imunixx.backend.service.FixedMovementService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class FixedMovementController implements FixedMovementApi{
    
    @Autowired
    public final FixedMovementService fixedMovementService;


    //@GetMapping("/{profileId}/all")
    @Override
    public ResponseEntity<List<FixedMovementDto>> getFixedMovementListByProfileId(@PathVariable("profileId") Long profileId) {
        return ResponseEntity.ok(fixedMovementService.findAllProfileFixedMovements(profileId));
    }

    //@PostMapping("/add")
    @Override
    public  ResponseEntity<FixedMovementDto> createFixedMovement(FixedMovementDto fixedMovementDto) {
        return ResponseEntity.ok(fixedMovementService.addFixedMovement(fixedMovementDto));
    }

    //@PutMapping("/update")
    @Override
    public  ResponseEntity<FixedMovementDto> updateFixedMovement(@RequestBody FixedMovementDto fixedMovementDto) {
        return ResponseEntity.ok(fixedMovementService.updateFixedMovement(fixedMovementDto));
    }

    @Override
    public ResponseEntity<Void> deleteFixedMovementById(Long id) {
        //TODO: validate id
        fixedMovementService.deleteFixedMovement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
