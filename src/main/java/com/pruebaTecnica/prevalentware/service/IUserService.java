package com.pruebaTecnica.prevalentware.service;

import com.pruebaTecnica.prevalentware.dto.UserDto;
import com.pruebaTecnica.prevalentware.exception.GenericException;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface IUserService {
    //List<UserDto> getAll(String token) throws GenericException;
    Page<UserDto> getAll(String token, int page, int size) throws GenericException;

    UserDto findById(String id) throws GenericException;

    UserDto findByEmail(String token, String email) throws GenericException;

    List<UserDto> findTop3UserMonitoring(String token, LocalDate dateStart, LocalDate dateEnd) throws GenericException;
}
