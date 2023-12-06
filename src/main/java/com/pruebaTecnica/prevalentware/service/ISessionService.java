package com.pruebaTecnica.prevalentware.service;

import com.pruebaTecnica.prevalentware.dto.SessionDto;
import com.pruebaTecnica.prevalentware.exception.GenericException;

public interface ISessionService {

    SessionDto findSessionToken(String sessionToken) throws GenericException;
}
