package com.pruebaTecnica.prevalentware.Mapper;

import com.pruebaTecnica.prevalentware.dto.CountryDto;
import com.pruebaTecnica.prevalentware.entity.CountryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-05T17:44:57-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryDto toCountryDto(CountryEntity countryEntity) {
        if ( countryEntity == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setId( countryEntity.getId() );
        countryDto.setName( countryEntity.getName() );
        countryDto.setCreatedAt( countryEntity.getCreatedAt() );
        countryDto.setUpdatedAt( countryEntity.getUpdatedAt() );

        return countryDto;
    }

    @Override
    public CountryEntity toCountryEntity(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setId( countryDto.getId() );
        countryEntity.setName( countryDto.getName() );
        countryEntity.setCreatedAt( countryDto.getCreatedAt() );
        countryEntity.setUpdatedAt( countryDto.getUpdatedAt() );

        return countryEntity;
    }

    @Override
    public List<CountryDto> toListDto(List<CountryEntity> countryEntity) {
        if ( countryEntity == null ) {
            return null;
        }

        List<CountryDto> list = new ArrayList<CountryDto>( countryEntity.size() );
        for ( CountryEntity countryEntity1 : countryEntity ) {
            list.add( toCountryDto( countryEntity1 ) );
        }

        return list;
    }

    @Override
    public List<CountryEntity> toListEntity(List<CountryDto> contryDto) {
        if ( contryDto == null ) {
            return null;
        }

        List<CountryEntity> list = new ArrayList<CountryEntity>( contryDto.size() );
        for ( CountryDto countryDto : contryDto ) {
            list.add( toCountryEntity( countryDto ) );
        }

        return list;
    }
}
