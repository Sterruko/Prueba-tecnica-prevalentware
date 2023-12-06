package com.pruebaTecnica.prevalentware.Mapper;

import com.pruebaTecnica.prevalentware.dto.UserMonitoringDto;
import com.pruebaTecnica.prevalentware.entity.UserMonitoringEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-05T16:49:10-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMonitoringMapperImpl implements UserMonitoringMapper {

    @Override
    public UserMonitoringDto toUserMonitoringDto(UserMonitoringEntity userMonitoringEntity) {
        if ( userMonitoringEntity == null ) {
            return null;
        }

        UserMonitoringDto userMonitoringDto = new UserMonitoringDto();

        userMonitoringDto.setId( userMonitoringEntity.getId() );
        userMonitoringDto.setUsage( userMonitoringEntity.getUsage() );
        userMonitoringDto.setDescription( userMonitoringEntity.getDescription() );
        userMonitoringDto.setUserId( userMonitoringEntity.getUserId() );
        userMonitoringDto.setCreatedAt( userMonitoringEntity.getCreatedAt() );

        return userMonitoringDto;
    }

    @Override
    public UserMonitoringEntity toUserMonitoringEntity(UserMonitoringDto userMonitoringDto) {
        if ( userMonitoringDto == null ) {
            return null;
        }

        UserMonitoringEntity userMonitoringEntity = new UserMonitoringEntity();

        userMonitoringEntity.setId( userMonitoringDto.getId() );
        userMonitoringEntity.setUsage( userMonitoringDto.getUsage() );
        userMonitoringEntity.setDescription( userMonitoringDto.getDescription() );
        userMonitoringEntity.setUserId( userMonitoringDto.getUserId() );
        userMonitoringEntity.setCreatedAt( userMonitoringDto.getCreatedAt() );

        return userMonitoringEntity;
    }

    @Override
    public List<UserMonitoringDto> toListDto(List<UserMonitoringEntity> userMonitoringEntity) {
        if ( userMonitoringEntity == null ) {
            return null;
        }

        List<UserMonitoringDto> list = new ArrayList<UserMonitoringDto>( userMonitoringEntity.size() );
        for ( UserMonitoringEntity userMonitoringEntity1 : userMonitoringEntity ) {
            list.add( toUserMonitoringDto( userMonitoringEntity1 ) );
        }

        return list;
    }

    @Override
    public List<UserMonitoringEntity> toListEntity(List<UserMonitoringDto> userMonitoringDto) {
        if ( userMonitoringDto == null ) {
            return null;
        }

        List<UserMonitoringEntity> list = new ArrayList<UserMonitoringEntity>( userMonitoringDto.size() );
        for ( UserMonitoringDto userMonitoringDto1 : userMonitoringDto ) {
            list.add( toUserMonitoringEntity( userMonitoringDto1 ) );
        }

        return list;
    }
}
