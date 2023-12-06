package com.pruebaTecnica.prevalentware.Mapper;

import com.pruebaTecnica.prevalentware.dto.UserMonitoringDto;
import com.pruebaTecnica.prevalentware.entity.UserMonitoringEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMonitoringMapper {

    UserMonitoringDto toUserMonitoringDto(UserMonitoringEntity userMonitoringEntity);

    @InheritInverseConfiguration
    UserMonitoringEntity toUserMonitoringEntity(UserMonitoringDto userMonitoringDto);

    List<UserMonitoringDto> toListDto(List<UserMonitoringEntity> userMonitoringEntity);

    @InheritInverseConfiguration
    List<UserMonitoringEntity> toListEntity(List<UserMonitoringDto> userMonitoringDto);


}
