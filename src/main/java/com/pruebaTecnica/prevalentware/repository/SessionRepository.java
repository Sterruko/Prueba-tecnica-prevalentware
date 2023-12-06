package com.pruebaTecnica.prevalentware.repository;

import com.pruebaTecnica.prevalentware.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<SessionEntity, String> {

    SessionEntity findBySessionToken(String sessionToken);
}
