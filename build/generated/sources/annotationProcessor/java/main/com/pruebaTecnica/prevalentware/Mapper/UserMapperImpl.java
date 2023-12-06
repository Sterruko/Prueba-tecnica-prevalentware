package com.pruebaTecnica.prevalentware.Mapper;

import com.pruebaTecnica.prevalentware.dto.UserDto;
import com.pruebaTecnica.prevalentware.dto.UsersMonitoringCountryDto;
import com.pruebaTecnica.prevalentware.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-05T17:11:31-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( userEntity.getId() );
        userDto.setEmail( userEntity.getEmail() );
        userDto.setEmailVerified( userEntity.getEmailVerified() );
        userDto.setTermsAndConditionsAccepted( userEntity.getTermsAndConditionsAccepted() );
        userDto.setName( userEntity.getName() );
        userDto.setImage( userEntity.getImage() );
        userDto.setPosition( userEntity.getPosition() );
        userDto.setCreatedAt( userEntity.getCreatedAt() );
        userDto.setUpdatedAt( userEntity.getUpdatedAt() );
        userDto.setRoleId( userEntity.getRoleId() );

        return userDto;
    }

    @Override
    public UserEntity toUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDto.getId() );
        userEntity.setEmail( userDto.getEmail() );
        userEntity.setEmailVerified( userDto.getEmailVerified() );
        userEntity.setTermsAndConditionsAccepted( userDto.getTermsAndConditionsAccepted() );
        userEntity.setName( userDto.getName() );
        userEntity.setImage( userDto.getImage() );
        userEntity.setPosition( userDto.getPosition() );
        userEntity.setCreatedAt( userDto.getCreatedAt() );
        userEntity.setUpdatedAt( userDto.getUpdatedAt() );
        userEntity.setRoleId( userDto.getRoleId() );

        return userEntity;
    }

    @Override
    public List<UserDto> toListDto(List<UserEntity> userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userEntity.size() );
        for ( UserEntity userEntity1 : userEntity ) {
            list.add( toUserDto( userEntity1 ) );
        }

        return list;
    }

    @Override
    public List<UserEntity> toListEntity(List<UserDto> userDto) {
        if ( userDto == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( userDto.size() );
        for ( UserDto userDto1 : userDto ) {
            list.add( toUserEntity( userDto1 ) );
        }

        return list;
    }

    @Override
    public List<UsersMonitoringCountryDto> mapToDtoList(List<Object[]> results) {
        if ( results == null ) {
            return null;
        }

        List<UsersMonitoringCountryDto> list = new ArrayList<UsersMonitoringCountryDto>( results.size() );
        for ( Object[] objectArray : results ) {
            list.add( mapToDto( objectArray ) );
        }

        return list;
    }
}
