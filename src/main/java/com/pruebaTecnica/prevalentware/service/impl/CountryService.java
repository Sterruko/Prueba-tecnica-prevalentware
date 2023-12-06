package com.pruebaTecnica.prevalentware.service.impl;

import com.pruebaTecnica.prevalentware.Mapper.CountryMapper;
import com.pruebaTecnica.prevalentware.dto.CountryDto;
import com.pruebaTecnica.prevalentware.dto.RoleDto;
import com.pruebaTecnica.prevalentware.dto.SessionDto;
import com.pruebaTecnica.prevalentware.dto.UserDto;
import com.pruebaTecnica.prevalentware.entity.CountryEntity;
import com.pruebaTecnica.prevalentware.exception.GenericException;
import com.pruebaTecnica.prevalentware.repository.CountryRepository;
import com.pruebaTecnica.prevalentware.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements ICountryService {

    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
/*
    @Override
    public List<CountryDto> findAll(String token) throws GenericException {
        SessionDto response = sessionService.findSessionToken(token);
        UserDto user = userService.findById(response.getUserId());
        RoleDto roleUser = roleService.findById(user.getRoleId());

        if (roleUser.getName().equals("User")) {
            throw new GenericException(String.format("El usuario no cuenta con permisos para realizar esta búsqueda."));
        }

        List<CountryEntity> result = countryRepository.findAll();
        return countryMapper.toListDto(result);
    }

 */

    public Page<CountryDto> findAll(String token, int page, int size) throws GenericException {
        SessionDto response = sessionService.findSessionToken(token);
        UserDto user = userService.findById(response.getUserId());
        RoleDto roleUser = roleService.findById(user.getRoleId());

        if (roleUser.getName().equals("User")) {
            throw new GenericException(String.format("El usuario no cuenta con permisos para realizar esta búsqueda."));
        }
        Pageable pageable = PageRequest.of(page, size);

        Page<CountryEntity> countryPage = countryRepository.findAll(pageable);


        return countryPage.map(countryMapper::toCountryDto);
    }
}
