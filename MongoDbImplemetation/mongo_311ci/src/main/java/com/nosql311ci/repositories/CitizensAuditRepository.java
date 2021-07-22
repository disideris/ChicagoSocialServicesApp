package com.nosql311ci.repositories;

import com.nosql311ci.models.Citizen;
import com.nosql311ci.models.CitizenAudit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizensAuditRepository extends MongoRepository<CitizenAudit, String> {

}