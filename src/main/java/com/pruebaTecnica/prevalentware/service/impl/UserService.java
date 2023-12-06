package com.pruebaTecnica.prevalentware.service.impl;

import com.pruebaTecnica.prevalentware.Mapper.UserMapper;
import com.pruebaTecnica.prevalentware.dto.RoleDto;
import com.pruebaTecnica.prevalentware.dto.SessionDto;
import com.pruebaTecnica.prevalentware.dto.UserDto;
import com.pruebaTecnica.prevalentware.dto.UsersMonitoringCountryDto;
import com.pruebaTecnica.prevalentware.entity.UserEntity;
import com.pruebaTecnica.prevalentware.exception.GenericException;
import com.pruebaTecnica.prevalentware.repository.UserRepository;
import com.pruebaTecnica.prevalentware.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private RoleService roleService;

    @Override
    public Page<UserDto> getAll(String token, int page, int size) throws GenericException {
        RoleDto roleUser = getRoleDto(token);

        if (roleUser.getName().equals("User")) {
            throw new GenericException("El usuario no cuenta con permisos para realizar esta búsqueda.");
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<UserEntity> userPage = userRepository.findAll(pageable);
        return userPage.map(userMapper::toUserDto);
    }

    @Override
    public UserDto findById(String id) {
        Optional<UserEntity> result = userRepository.findById(id);
        return result.map(userMapper::toUserDto).orElse(null);
    }

    @Override
    public UserDto findByEmail(String token, String email) throws GenericException {
        SessionDto response = sessionService.findSessionToken(token);
        UserDto user = findById(response.getUserId());
        RoleDto roleUser = roleService.findById(user.getRoleId());

        if (roleUser.getName().equals("User") && !email.equals(user.getEmail())) {
            throw new GenericException(String.format("El usuario no cuenta con permisos para realizar la consulta a otros usuarios."));
        }

        Optional<UserEntity> result = userRepository.findByEmail(email);
        if (result.isPresent()) {
            return userMapper.toUserDto(result.get());
        } else {
            throw new GenericException("Usuario no encontrado para el correo electrónico: " + email);
        }

    }

    @Override
    public List<UserDto> findTop3UserMonitoring(String token, LocalDate dateStart, LocalDate dateEnd)
            throws GenericException {
        RoleDto roleUser = getRoleDto(token);

        if (roleUser.getName().equals("Manager") || roleUser.getName().equals("User")) {
            throw new GenericException(String.format("El usuario %s no cuenta con permisos para realizar esta búsqueda.", roleUser.getId()));
        }

        List<UserEntity> result = userRepository.findTop3UserMonitoring(dateStart, dateEnd);
        return userMapper.toListDto(result);
    }

    private RoleDto getRoleDto(String token) throws GenericException {
        SessionDto response = sessionService.findSessionToken(token);
        UserDto user = findById(response.getUserId());
        return roleService.findById(user.getRoleId());
    }

    public Page<UsersMonitoringCountryDto> getUserMonitoringResults(String token, LocalDate startDate,
                                                                    LocalDate endDate, String countryId,
                                                                    String monitoringType, int page, int size) throws GenericException {
        RoleDto roleUser = getRoleDto(token);

        if (roleUser.getName().equals("Manager") || roleUser.getName().equals("User")) {
            throw new GenericException(String.format("El usuario %s no cuenta con permisos para realizar esta búsqueda.", roleUser.getId()));
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<Object[]> resultsPage = userRepository.getUserMonitoringResults(startDate, endDate, countryId, monitoringType, pageable);

        return resultsPage.map(userMapper::mapToDto);
    }
}
