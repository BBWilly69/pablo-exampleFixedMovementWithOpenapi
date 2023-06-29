package de.imunixx.backend.service;

import de.imunixx.api.entity.FixedMovement;
import de.imunixx.api.mapper.BackendMapper;
import de.imunixx.api.model.FixedMovementDto;
import de.imunixx.backend.exception.FixedMovementNotFoundException;
import de.imunixx.backend.repository.FixedMovementRepo;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Slf4j
@AllArgsConstructor
@Transactional
public class FixedMovementService {

    private final FixedMovementRepo fixedMovementRepo;
    private final BackendMapper mapper;


    public FixedMovementDto addFixedMovement(FixedMovementDto fixedMovementDto) {
        FixedMovement entity = mapper.toEntity(fixedMovementDto);
        //TODO: validation
        return mapper.toDto(fixedMovementRepo.save(entity)); 
    }

    public List<FixedMovementDto> findAllProfileFixedMovements(Long profileId) { 
        return mapper.toFixedMovementDtoList(fixedMovementRepo.findByProfileId(profileId)); 
    }

    public FixedMovementDto findFixedMovementById(Long id) {
        //TODO validate id notNull, id exists
        Optional<FixedMovement> entity = fixedMovementRepo.findFixedMovementById(id);
        if(entity.isPresent()){
            return mapper.toDto(entity.get());
        }        
        throw new FixedMovementNotFoundException("Movement by id" + id + "was not found");
    }

    public FixedMovementDto updateFixedMovement(FixedMovementDto fixedMovementDto) { 
        //TODO: validate
        return mapper.toDto(
                fixedMovementRepo.save(
                        mapper.toEntity(fixedMovementDto))); 
    }

    public void deleteFixedMovement(Long id) {
        //TODO: validate id
        fixedMovementRepo.deleteFixedMovementById(id);
        if (fixedMovementRepo.existsById(id)) {
            throw new FixedMovementNotFoundException("FixedMovement with id" + id + "could not be deleted");
        }
    }
}
