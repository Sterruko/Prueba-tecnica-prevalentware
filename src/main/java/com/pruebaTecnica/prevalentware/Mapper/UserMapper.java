package com.pruebaTecnica.prevalentware.Mapper;


import com.pruebaTecnica.prevalentware.dto.UserDto;
import com.pruebaTecnica.prevalentware.dto.UsersMonitoringCountryDto;
import com.pruebaTecnica.prevalentware.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(UserEntity userEntity);

    @InheritInverseConfiguration
    UserEntity toUserEntity(UserDto userDto);

    default Page<UserDto> toDtoPage(Page<UserEntity> userPage) {
        return userPage.map(this::toUserDto);
    }

    List<UserDto> toListDto(List<UserEntity> userEntity);

    @InheritInverseConfiguration
    List<UserEntity> toListEntity(List<UserDto> userDto);

    default UsersMonitoringCountryDto mapToDto(Object[] result) {
        return new UsersMonitoringCountryDto(
                (String) result[0],   // userId
                (String) result[1],   // name
                (String) result[2],   // email
                (String) result[3],   // description
                (String) result[4],   // countryId
                (String) result[5],   // country
                result[6] != null ? mapTimestampToLocalDateTime((Timestamp) result[6]) : null // createdAt
        );
    }

    List<UsersMonitoringCountryDto> mapToDtoList(List<Object[]> results);

    @Named("timestampToLocalDateTime")
    default LocalDateTime mapTimestampToLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
