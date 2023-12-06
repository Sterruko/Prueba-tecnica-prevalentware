package com.pruebaTecnica.prevalentware.Mapper;

import com.pruebaTecnica.prevalentware.dto.PrismaMigrationsDto;
import com.pruebaTecnica.prevalentware.entity.PrismaMigrationsEntity;
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
public class PrismaMigrationsMapperImpl implements PrismaMigrationsMapper {

    @Override
    public PrismaMigrationsDto toPrismaMigrationsDto(PrismaMigrationsEntity prismaMigrationsEntity) {
        if ( prismaMigrationsEntity == null ) {
            return null;
        }

        PrismaMigrationsDto prismaMigrationsDto = new PrismaMigrationsDto();

        prismaMigrationsDto.setId( prismaMigrationsEntity.getId() );
        prismaMigrationsDto.setChecksum( prismaMigrationsEntity.getChecksum() );
        prismaMigrationsDto.setFinishedAt( prismaMigrationsEntity.getFinishedAt() );
        prismaMigrationsDto.setMigrationName( prismaMigrationsEntity.getMigrationName() );
        prismaMigrationsDto.setLogs( prismaMigrationsEntity.getLogs() );
        prismaMigrationsDto.setRollledBackAt( prismaMigrationsEntity.getRollledBackAt() );
        prismaMigrationsDto.setStartedAt( prismaMigrationsEntity.getStartedAt() );
        prismaMigrationsDto.setAppliedStepsCount( prismaMigrationsEntity.getAppliedStepsCount() );

        return prismaMigrationsDto;
    }

    @Override
    public PrismaMigrationsEntity toPrismaMigrationsEntity(PrismaMigrationsDto prismaMigrationsDto) {
        if ( prismaMigrationsDto == null ) {
            return null;
        }

        PrismaMigrationsEntity prismaMigrationsEntity = new PrismaMigrationsEntity();

        prismaMigrationsEntity.setId( prismaMigrationsDto.getId() );
        prismaMigrationsEntity.setChecksum( prismaMigrationsDto.getChecksum() );
        prismaMigrationsEntity.setFinishedAt( prismaMigrationsDto.getFinishedAt() );
        prismaMigrationsEntity.setMigrationName( prismaMigrationsDto.getMigrationName() );
        prismaMigrationsEntity.setLogs( prismaMigrationsDto.getLogs() );
        prismaMigrationsEntity.setRollledBackAt( prismaMigrationsDto.getRollledBackAt() );
        prismaMigrationsEntity.setStartedAt( prismaMigrationsDto.getStartedAt() );
        prismaMigrationsEntity.setAppliedStepsCount( prismaMigrationsDto.getAppliedStepsCount() );

        return prismaMigrationsEntity;
    }

    @Override
    public List<PrismaMigrationsDto> toListDto(List<PrismaMigrationsEntity> prismaMigrationsEntity) {
        if ( prismaMigrationsEntity == null ) {
            return null;
        }

        List<PrismaMigrationsDto> list = new ArrayList<PrismaMigrationsDto>( prismaMigrationsEntity.size() );
        for ( PrismaMigrationsEntity prismaMigrationsEntity1 : prismaMigrationsEntity ) {
            list.add( toPrismaMigrationsDto( prismaMigrationsEntity1 ) );
        }

        return list;
    }

    @Override
    public List<PrismaMigrationsEntity> toListEntity(List<PrismaMigrationsDto> prismaMigrationsDto) {
        if ( prismaMigrationsDto == null ) {
            return null;
        }

        List<PrismaMigrationsEntity> list = new ArrayList<PrismaMigrationsEntity>( prismaMigrationsDto.size() );
        for ( PrismaMigrationsDto prismaMigrationsDto1 : prismaMigrationsDto ) {
            list.add( toPrismaMigrationsEntity( prismaMigrationsDto1 ) );
        }

        return list;
    }
}
