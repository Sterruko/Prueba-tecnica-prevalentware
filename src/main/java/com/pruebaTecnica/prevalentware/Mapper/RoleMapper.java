package com.pruebaTecnica.prevalentware.Mapper;


import com.pruebaTecnica.prevalentware.dto.RoleDto;
import com.pruebaTecnica.prevalentware.entity.RoleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toRoleDto(RoleEntity roleEntity);

    @InheritInverseConfiguration
    RoleEntity toRoleEntity(RoleDto roleDto);

    List<RoleDto> toListDto(List<RoleEntity> roleEntity);

    @InheritInverseConfiguration
    List<RoleEntity> toListEntity(List<RoleDto> roleDto);
}
