package com.pruebaTecnica.prevalentware.Mapper;

import com.pruebaTecnica.prevalentware.dto.RoleDto;
import com.pruebaTecnica.prevalentware.entity.RoleEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-05T16:49:09-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDto toRoleDto(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( roleEntity.getId() );
        roleDto.setName( roleEntity.getName() );
        roleDto.setCreatedAt( roleEntity.getCreatedAt() );

        return roleDto;
    }

    @Override
    public RoleEntity toRoleEntity(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( roleDto.getId() );
        roleEntity.setName( roleDto.getName() );
        roleEntity.setCreatedAt( roleDto.getCreatedAt() );

        return roleEntity;
    }

    @Override
    public List<RoleDto> toListDto(List<RoleEntity> roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( roleEntity.size() );
        for ( RoleEntity roleEntity1 : roleEntity ) {
            list.add( toRoleDto( roleEntity1 ) );
        }

        return list;
    }

    @Override
    public List<RoleEntity> toListEntity(List<RoleDto> roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        List<RoleEntity> list = new ArrayList<RoleEntity>( roleDto.size() );
        for ( RoleDto roleDto1 : roleDto ) {
            list.add( toRoleEntity( roleDto1 ) );
        }

        return list;
    }
}
