package com.pruebaTecnica.prevalentware.controller;

import com.pruebaTecnica.prevalentware.dto.ErrorResponse;
import com.pruebaTecnica.prevalentware.dto.SessionDto;
import com.pruebaTecnica.prevalentware.exception.GenericException;
import com.pruebaTecnica.prevalentware.service.impl.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/findByToken")
    public ResponseEntity<Object> findToken(@RequestParam(name = "Token") String token) {
        SessionDto response;
        try {
            response = sessionService.findSessionToken(token);
        } catch (GenericException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
