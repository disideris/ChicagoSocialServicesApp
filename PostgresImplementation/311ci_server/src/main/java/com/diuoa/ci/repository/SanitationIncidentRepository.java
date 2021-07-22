package com.diuoa.ci.repository;

import com.diuoa.ci.model.SanitationIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanitationIncidentRepository extends JpaRepository<SanitationIncident, Long> {

}
