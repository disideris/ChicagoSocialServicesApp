package com.diuoa.ci.repository;

import com.diuoa.ci.model.VehicleIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleIncidentRepository extends JpaRepository<VehicleIncident, Long> {

}
