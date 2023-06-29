/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.imunixx.api.mapper;

import de.imunixx.api.entity.FixedMovement;
import de.imunixx.api.model.FixedMovementDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author uli.baehr@imunixx.de
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BackendMapper{
    
    BackendMapper MAPPER_INSTANCE = Mappers.getMapper(BackendMapper.class);
    
    FixedMovement toEntity(FixedMovementDto dto);
    FixedMovementDto toDto(FixedMovement entity);
    
    List<FixedMovement> toFixedMovementList(List<FixedMovementDto> dtoList);
    List<FixedMovementDto> toFixedMovementDtoList(List<FixedMovement> entityList); 
    
}
