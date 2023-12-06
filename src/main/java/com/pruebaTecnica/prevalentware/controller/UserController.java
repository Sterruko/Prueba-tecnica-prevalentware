package com.pruebaTecnica.prevalentware.controller;

import com.pruebaTecnica.prevalentware.dto.ErrorResponse;
import com.pruebaTecnica.prevalentware.dto.UserDto;
import com.pruebaTecnica.prevalentware.dto.UsersMonitoringCountryDto;
import com.pruebaTecnica.prevalentware.exception.GenericException;
import com.pruebaTecnica.prevalentware.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "token") String token) {
        try {
            Page<UserDto> userPage = userService.getAll(token, page, size);
            return ResponseEntity.ok(userPage);
        } catch (GenericException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error:", "Unauthorized");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(403).body(errorResponse);
        }
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<Object> findByEmail(@RequestParam(name = "token") String token, @RequestParam(name = "email") String email) {
        UserDto response;
        try {
            response = userService.findByEmail(token, email);
        } catch (GenericException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findTopUserMonitoring")
    public ResponseEntity<Object> findTop3UserMonitoringfindTop3UserMonitoring(@RequestParam(name = "token") String token,
                                                                               @RequestParam(name = "dateStart") LocalDate dateStart,
                                                                               @RequestParam(name = "dateEnd") LocalDate dateEnd) {
        List<UserDto> response;
        try {
            response = userService.findTop3UserMonitoring(token, dateStart, dateEnd);
        } catch (GenericException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/userMonitoringResults")
    public ResponseEntity<Object> getUserMonitoringResults(@RequestParam(name = "token") String token,
                                                           @RequestParam(name = "dateStart") LocalDate dateStart,
                                                           @RequestParam(name = "dateEnd") LocalDate dateEnd,
                                                           @RequestParam(name = "countryId") String countryId,
                                                           @RequestParam(name = "monitoringType") String monitoringType,
                                                           @RequestParam(name = "page", defaultValue = "0") int page,
                                                           @RequestParam(name = "size", defaultValue = "10") int size) {

        try {
            Page<UsersMonitoringCountryDto> response = userService.getUserMonitoringResults(token, dateStart, dateEnd, countryId, monitoringType, page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (GenericException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
