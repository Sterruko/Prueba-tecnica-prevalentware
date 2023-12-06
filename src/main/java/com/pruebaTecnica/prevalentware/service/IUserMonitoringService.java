package com.pruebaTecnica.prevalentware.service;

import com.pruebaTecnica.prevalentware.dto.UserDto;
import com.pruebaTecnica.prevalentware.dto.UserMonitoringDto;
import com.pruebaTecnica.prevalentware.exception.GenericException;

import java.time.LocalDate;
import java.util.List;

public interface IUserMonitoringService {

    List<UserMonitoringDto> findUserMonitoring(String token, String email, LocalDate dateStart, LocalDate dateEnd) throws GenericException;
}
