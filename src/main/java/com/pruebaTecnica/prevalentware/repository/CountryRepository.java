package com.pruebaTecnica.prevalentware.repository;

import com.pruebaTecnica.prevalentware.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, String> {
}
