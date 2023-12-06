package com.pruebaTecnica.prevalentware.service.impl;

import com.pruebaTecnica.prevalentware.Mapper.UserMonitoringMapper;
import com.pruebaTecnica.prevalentware.dto.RoleDto;
import com.pruebaTecnica.prevalentware.dto.UserDto;
import com.pruebaTecnica.prevalentware.dto.UserMonitoringDto;
import com.pruebaTecnica.prevalentware.entity.UserMonitoringEntity;
import com.pruebaTecnica.prevalentware.exception.GenericException;
import com.pruebaTecnica.prevalentware.repository.UserMonitoringRepository;
import com.pruebaTecnica.prevalentware.service.IUserMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMonitoringService implements IUserMonitoringService {

    @Autowired
    private UserMonitoringMapper userMonitoringMapper;
    @Autowired
    private UserMonitoringRepository userMonitoringRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private SessionService sessionService;

    @Override
    public List<UserMonitoringDto> findUserMonitoring(String token, String email, LocalDate dateStart, LocalDate dateEnd) throws GenericException {
        UserDto user = userService.findByEmail(token, email);
        RoleDto roleUser = roleService.findById(user.getRoleId());

        if (roleUser.getName().equals("Manager")) {
            throw new GenericException(String.format("El usuario no cuenta con permisos para realizar esta búsqueda."));
        }

        List<UserMonitoringEntity> userMonitoring = userMonitoringRepository.findByUserIdAndCreatedAtBetween(user.getId(), dateStart, dateEnd);
        return userMonitoring.stream()
                .map(userMonitoringMapper::toUserMonitoringDto)
                .collect(Collectors.toList());
    }

}

