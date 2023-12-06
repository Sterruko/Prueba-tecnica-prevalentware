package com.pruebaTecnica.prevalentware.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"UserMonitoring\"")
public class UserMonitoringEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private int usage;
    private String description;
    @Column(name = "\"userId\"")
    private String userId;
    @Column(name = "\"createdAt\"")
    private LocalDate createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}