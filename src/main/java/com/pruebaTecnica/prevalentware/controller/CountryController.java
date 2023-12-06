package com.pruebaTecnica.prevalentware.controller;

import com.pruebaTecnica.prevalentware.dto.CountryDto;
import com.pruebaTecnica.prevalentware.exception.GenericException;
import com.pruebaTecnica.prevalentware.service.impl.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("Country")
public class CountryController {

    @Autowired
    private CountryService countryService;
/*
    @GetMapping("/findAll")
    public ResponseEntity<Object> findAll(@RequestParam(name = "Token") String token) {
        List<CountryDto> response;
        try {
            response = countryService.findAll(token);
        } catch (GenericException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

 */

    @GetMapping("/findAll")
    public ResponseEntity<Object> findAll(@RequestParam(name = "token") String token,
                                          @RequestParam(name = "page", defaultValue = "0") int page,
                                          @RequestParam(name = "size", defaultValue = "10") int size) {

        try {
            Page<CountryDto> response = countryService.findAll(token, page, size);
            return ResponseEntity.ok(response);
        } catch (GenericException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error:", "Unauthorized");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(403).body(errorResponse);
        }
    }

}
