package com.nosql311ci.repositories;

import com.nosql311ci.models.Citizen;
import com.nosql311ci.models.Incident;
import org.springframework.data.geo.Box;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizensRepository extends MongoRepository<Citizen, String> {

    Citizen findCitizenBy_id(String id);
    List<Citizen> findCitizensByUpvotesContaining(String id);
}