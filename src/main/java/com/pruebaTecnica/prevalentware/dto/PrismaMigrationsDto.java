package com.pruebaTecnica.prevalentware.dto;

import java.util.Date;

public class PrismaMigrationsDto {
    private String id;
    private String checksum;
    private Date finishedAt;
    private String migrationName;
    private String logs;
    private Date rollledBackAt;
    private Date startedAt;
    private Integer appliedStepsCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public Date getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
    }

    public String getMigrationName() {
        return migrationName;
    }

    public void setMigrationName(String migrationName) {
        this.migrationName = migrationName;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public Date getRollledBackAt() {
        return rollledBackAt;
    }

    public void setRollledBackAt(Date rollledBackAt) {
        this.rollledBackAt = rollledBackAt;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Integer getAppliedStepsCount() {
        return appliedStepsCount;
    }

    public void setAppliedStepsCount(Integer appliedStepsCount) {
        this.appliedStepsCount = appliedStepsCount;
    }
}
