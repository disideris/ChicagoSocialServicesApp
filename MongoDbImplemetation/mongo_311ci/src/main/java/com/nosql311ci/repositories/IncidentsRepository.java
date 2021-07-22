package com.nosql311ci.repositories;

import com.nosql311ci.models.Incident;
import com.nosql311ci.models.Query6Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.geo.Box;


import java.util.List;

@Repository
public interface IncidentsRepository extends MongoRepository<Incident, String> {

    Incident findIncidentBy_id(String id);
}