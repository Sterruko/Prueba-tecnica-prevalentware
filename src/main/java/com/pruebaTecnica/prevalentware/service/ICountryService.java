package com.pruebaTecnica.prevalentware.service;

import com.pruebaTecnica.prevalentware.dto.CountryDto;
import com.pruebaTecnica.prevalentware.exception.GenericException;
import org.springframework.data.domain.Page;

public interface ICountryService {

    Page<CountryDto> findAll(String token, int page, int size) throws GenericException;
}
