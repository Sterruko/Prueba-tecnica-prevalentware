package com.pruebaTecnica.prevalentware.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsersMonitoringCountryDto{

    private String userId;
    private String name;
    private String email;
    private String description;
    private String countryId;
    private String country;
    private LocalDateTime createdAt;

    public UsersMonitoringCountryDto(String userId, String name, String email, String description, String countryId, String country, LocalDateTime createdAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.description = description;
        this.countryId = countryId;
        this.country = country;
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
