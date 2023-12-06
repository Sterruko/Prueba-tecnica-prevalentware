package com.pruebaTecnica.prevalentware.repository;

import com.pruebaTecnica.prevalentware.entity.PrismaMigrationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrismaMigrationsRepository extends JpaRepository<PrismaMigrationsEntity, String> {
}
