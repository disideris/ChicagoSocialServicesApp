package com.diuoa.ci.repository;

import com.diuoa.ci.model.PotholeIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotholeIncidentRepository extends JpaRepository<PotholeIncident, Long> {

}
