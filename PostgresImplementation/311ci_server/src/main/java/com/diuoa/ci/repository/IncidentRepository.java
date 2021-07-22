package com.diuoa.ci.repository;

import com.diuoa.ci.model.Incident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

    Page<Incident> findDistinctByStreetAddress(String streetAddress, Pageable pageable);
    Page<Incident> findDistinctByZipCode(int zipCode, Pageable pageable);
    Page<Incident> findByCreatedBy(Long userId, Pageable pageable);
}
