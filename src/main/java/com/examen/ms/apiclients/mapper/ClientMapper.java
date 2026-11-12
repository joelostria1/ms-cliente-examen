package com.examen.ms.apiclients.mapper;

import com.examen.ms.apiclients.entities.ClientEntity;
import com.examen.ms.apiclients.models.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientEntity toEntity(ClientDto dto);

    ClientDto toDTO(ClientEntity entity);
}
