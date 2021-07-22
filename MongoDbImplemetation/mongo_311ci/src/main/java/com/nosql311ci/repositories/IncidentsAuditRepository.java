package com.nosql311ci.repositories;

import com.nosql311ci.models.IncidentAudit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentsAuditRepository extends MongoRepository<IncidentAudit, String> {

}