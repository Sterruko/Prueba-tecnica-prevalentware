package com.pruebaTecnica.prevalentware.repository;

import com.pruebaTecnica.prevalentware.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);

    @Query(value = "select u.* from \"UserMonitoring\" um\n" +
            "inner join \"User\" u on u.id = um.\"userId\" \n" +
            "where um.\"createdAt\" between :startDate and :endDate \n" +
            "GROUP BY u.id\n" +
            "order BY Count(u) desc\n" +
            "limit 3;", nativeQuery = true)
    List<UserEntity> findTop3UserMonitoring(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    @Query(value = "select u.id as \"userId\", u.\"name\", u.email , um.description , c.id as \"countryId\", c.\"name\" as country, um.\"createdAt\" from \"UserMonitoring\" um " +
            "inner join \"User\" u on u.id = um.\"userId\"  " +
            "inner join \"_CountryToUser\" ctu on u.id = ctu.\"B\"  " +
            "inner join \"Country\" c on c.id = ctu.\"A\"  " +
            "where um.\"createdAt\" between :startDate and :endDate and c.id = :countryId and um.description = :monitoringType " +
            "group by  u.id, u.\"name\", u.email, um.description, c.id, c.\"name\", um.\"createdAt\" " +
            "order by Count(u) desc;", nativeQuery = true)
    Page<Object[]> getUserMonitoringResults(@Param("startDate") LocalDate startDate,
                                            @Param("endDate") LocalDate endDate,
                                            @Param("countryId") String countryId,
                                            @Param("monitoringType") String monitoringType, Pageable pageable);
}