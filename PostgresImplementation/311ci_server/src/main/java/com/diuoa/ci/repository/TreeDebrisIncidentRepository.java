package com.diuoa.ci.repository;

import com.diuoa.ci.model.TreeDebrisIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeDebrisIncidentRepository extends JpaRepository<TreeDebrisIncident, Long> {

}
