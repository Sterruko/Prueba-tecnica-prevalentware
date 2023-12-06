package com.pruebaTecnica.prevalentware.Mapper;

import com.pruebaTecnica.prevalentware.dto.SessionDto;
import com.pruebaTecnica.prevalentware.entity.SessionEntity;
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
public class SessionMapperImpl implements SessionMapper {

    @Override
    public SessionDto toSessionDto(SessionEntity sessionEntity) {
        if ( sessionEntity == null ) {
            return null;
        }

        SessionDto sessionDto = new SessionDto();

        sessionDto.setId( sessionEntity.getId() );
        sessionDto.setSessionToken( sessionEntity.getSessionToken() );
        sessionDto.setUserId( sessionEntity.getUserId() );
        sessionDto.setExpiresAt( sessionEntity.getExpiresAt() );
        sessionDto.setCreatedAt( sessionEntity.getCreatedAt() );

        return sessionDto;
    }

    @Override
    public SessionEntity toSessionEntity(SessionDto sessionDto) {
        if ( sessionDto == null ) {
            return null;
        }

        SessionEntity sessionEntity = new SessionEntity();

        sessionEntity.setId( sessionDto.getId() );
        sessionEntity.setSessionToken( sessionDto.getSessionToken() );
        sessionEntity.setUserId( sessionDto.getUserId() );
        sessionEntity.setExpiresAt( sessionDto.getExpiresAt() );
        sessionEntity.setCreatedAt( sessionDto.getCreatedAt() );

        return sessionEntity;
    }

    @Override
    public List<SessionDto> toListDto(List<SessionEntity> sessionEntity) {
        if ( sessionEntity == null ) {
            return null;
        }

        List<SessionDto> list = new ArrayList<SessionDto>( sessionEntity.size() );
        for ( SessionEntity sessionEntity1 : sessionEntity ) {
            list.add( toSessionDto( sessionEntity1 ) );
        }

        return list;
    }

    @Override
    public List<SessionEntity> toListEntity(List<SessionDto> sessionDto) {
        if ( sessionDto == null ) {
            return null;
        }

        List<SessionEntity> list = new ArrayList<SessionEntity>( sessionDto.size() );
        for ( SessionDto sessionDto1 : sessionDto ) {
            list.add( toSessionEntity( sessionDto1 ) );
        }

        return list;
    }
}
