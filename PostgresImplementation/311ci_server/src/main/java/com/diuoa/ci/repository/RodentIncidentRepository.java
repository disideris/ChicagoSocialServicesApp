package com.diuoa.ci.repository;

import com.diuoa.ci.model.RodentIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RodentIncidentRepository extends JpaRepository<RodentIncident, Long> {

}
