package com.pruebaTecnica.prevalentware.Mapper;


import com.pruebaTecnica.prevalentware.dto.SessionDto;
import com.pruebaTecnica.prevalentware.entity.SessionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    SessionDto toSessionDto(SessionEntity sessionEntity);

    @InheritInverseConfiguration
    SessionEntity toSessionEntity(SessionDto sessionDto);

    List<SessionDto> toListDto(List<SessionEntity> sessionEntity);

    @InheritInverseConfiguration
    List<SessionEntity> toListEntity(List<SessionDto> sessionDto);
}
