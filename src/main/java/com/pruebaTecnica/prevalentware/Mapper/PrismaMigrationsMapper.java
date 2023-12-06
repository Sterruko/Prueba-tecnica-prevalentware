package com.pruebaTecnica.prevalentware.Mapper;

import com.pruebaTecnica.prevalentware.dto.PrismaMigrationsDto;
import com.pruebaTecnica.prevalentware.entity.PrismaMigrationsEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrismaMigrationsMapper {

    PrismaMigrationsDto toPrismaMigrationsDto(PrismaMigrationsEntity prismaMigrationsEntity);

    @InheritInverseConfiguration
    PrismaMigrationsEntity toPrismaMigrationsEntity(PrismaMigrationsDto prismaMigrationsDto);

    List<PrismaMigrationsDto> toListDto(List<PrismaMigrationsEntity> prismaMigrationsEntity);

    @InheritInverseConfiguration
    List<PrismaMigrationsEntity> toListEntity(List<PrismaMigrationsDto> prismaMigrationsDto);
}
