package com.pruebaTecnica.prevalentware.service.impl;

import com.pruebaTecnica.prevalentware.Mapper.SessionMapper;
import com.pruebaTecnica.prevalentware.dto.SessionDto;
import com.pruebaTecnica.prevalentware.entity.SessionEntity;
import com.pruebaTecnica.prevalentware.exception.GenericException;
import com.pruebaTecnica.prevalentware.repository.SessionRepository;
import com.pruebaTecnica.prevalentware.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService implements ISessionService {

    @Autowired
    private SessionMapper sessionMapper;
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public SessionDto findSessionToken(String sessionToken) throws GenericException {
        SessionEntity result = sessionRepository.findBySessionToken(sessionToken);
        if (result == null) {
            throw new GenericException("Sesión no encontrada para el token: " + sessionToken);
        }
        return sessionMapper.toSessionDto(result);
    }


}
