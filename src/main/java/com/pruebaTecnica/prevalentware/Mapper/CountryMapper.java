package com.pruebaTecnica.prevalentware.Mapper;

import com.pruebaTecnica.prevalentware.dto.CountryDto;
import com.pruebaTecnica.prevalentware.dto.UserDto;
import com.pruebaTecnica.prevalentware.entity.CountryEntity;
import com.pruebaTecnica.prevalentware.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDto toCountryDto(CountryEntity countryEntity);

    @InheritInverseConfiguration
    CountryEntity toCountryEntity(CountryDto countryDto);

    default Page<CountryDto> toDtoPage(Page<CountryEntity> countryPage) {
        return countryPage.map(this::toCountryDto);
    }

    List<CountryDto> toListDto(List<CountryEntity> countryEntity);

    @InheritInverseConfiguration
    List<CountryEntity> toListEntity(List<CountryDto> contryDto);
}
