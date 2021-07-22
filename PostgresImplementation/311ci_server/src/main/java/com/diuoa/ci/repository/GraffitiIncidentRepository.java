package com.diuoa.ci.repository;

import com.diuoa.ci.model.GraffitiIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraffitiIncidentRepository extends JpaRepository<GraffitiIncident, Long> {

}
