package com.pruebaTecnica.prevalentware.repository;

import com.pruebaTecnica.prevalentware.entity.UserMonitoringEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface UserMonitoringRepository extends JpaRepository<UserMonitoringEntity, String> {
    List<UserMonitoringEntity> findByUserIdAndCreatedAtBetween(String userId, LocalDate startDate, LocalDate endDate);
}
