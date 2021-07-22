package com.diuoa.ci.repository;

import com.diuoa.ci.model.GarbageCartIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarbageCartIncidentRepository extends JpaRepository<GarbageCartIncident, Long> {

}
