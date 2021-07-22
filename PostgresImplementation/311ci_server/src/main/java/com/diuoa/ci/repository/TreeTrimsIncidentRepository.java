package com.diuoa.ci.repository;

import com.diuoa.ci.model.TreeTrimsIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeTrimsIncidentRepository extends JpaRepository<TreeTrimsIncident, Long> {

}
