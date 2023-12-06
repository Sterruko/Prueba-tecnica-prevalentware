package com.pruebaTecnica.prevalentware.controller;

import com.pruebaTecnica.prevalentware.dto.ErrorResponse;
import com.pruebaTecnica.prevalentware.dto.UserMonitoringDto;
import com.pruebaTecnica.prevalentware.exception.GenericException;
import com.pruebaTecnica.prevalentware.service.impl.UserMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("UserMonitoring")
public class UserMonitoringController {

    @Autowired
    private UserMonitoringService userMonitoringService;

    @GetMapping("/find")
    public ResponseEntity<Object> findAll(@RequestParam(name = "Token") String token,
                                          @RequestParam(name = "email") String email,
                                          @RequestParam(name = "dateStart") LocalDate dateStart,
                                          @RequestParam(name = "dateEnd") LocalDate dateEnd) {
        List<UserMonitoringDto> response;
        try {
            response = userMonitoringService.findUserMonitoring(token, email, dateStart, dateEnd);
        } catch (GenericException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
