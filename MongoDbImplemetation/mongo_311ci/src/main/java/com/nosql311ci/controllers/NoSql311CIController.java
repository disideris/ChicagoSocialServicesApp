package com.nosql311ci.controllers;

import javax.validation.Valid;

import com.mongodb.DBObject;
import com.nosql311ci.models.*;
import com.nosql311ci.repositories.CitizensAuditRepository;
import com.nosql311ci.repositories.CitizensRepository;
import com.nosql311ci.repositories.IncidentsAuditRepository;
import com.nosql311ci.repositories.IncidentsRepository;
import com.nosql311ci.services.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NoSql311CIController {

    @Autowired
    QueryService queryService;

    @Autowired
    CitizensRepository citizensRepository;

    @Autowired
    CitizensAuditRepository citizensAuditRepository;

    @Autowired
    IncidentsRepository incidentsRepository;

    @Autowired
    IncidentsAuditRepository incidentsAuditRepository;


    @GetMapping("/query1")
    public List<Object> getResultsFromQuery1(@RequestParam(value = "start_date") String startDate,
                                                   @RequestParam(value = "end_date") String endDate){

        return queryService.getResultsFromQuery1(startDate, endDate);
    }

    @GetMapping("/query2")
    public List<Object> getResultsFromQuery2(@RequestParam(value = "request_type") String requestType,
                                                   @RequestParam(value = "start_date") String startDate,
                                                   @RequestParam(value = "end_date") String endDate){

        return queryService.getResultsFromQuery2(requestType, startDate, endDate);
    }

    @GetMapping("/query3")
    public List<Object> getResultsFromQuery3(@RequestParam(value = "some_day") String someDay){

        return queryService.getResultsFromQuery3(someDay);
    }

    @GetMapping("/query4")
    public List<Object> getResultsFromQuery4(@RequestParam(value = "request_type") String requestType){

        return queryService.getResultsFromQuery4(requestType);
    }

    @GetMapping("/query5")
    public List<Object> getResultsFromQuery5(@RequestParam(value = "start_date") String startDate,
                                               @RequestParam(value = "end_date") String endDate) {

        return queryService.getResultsFromQuery5(startDate, endDate);
    }

    @GetMapping("/query6")
    public List<Object> getResultsFromQuery6(@RequestParam(value = "lat1") float lat1,
                                                   @RequestParam(value = "lon1") float lon1,
                                                   @RequestParam(value = "lat2") float lat2,
                                                   @RequestParam(value = "lon2") float lon2){

        return queryService.getResultsFromQuery6(lat1, lon1, lat2, lon2);
    }

    @GetMapping("/query7")
    public List<Object> getResultsFromQuery7(@RequestParam(value = "some_day") String someDay){

        return queryService.getResultsFromQuery7(someDay);
    }

    @GetMapping("/query8")
    public List<Object> getResultsFromQuery8(){

        return queryService.getResultsFromQuery8();
    }

    @GetMapping("/query9")
    public List<Query9Result> getResultsFromQuery9(){

        return queryService.getResultsFromQuery9();
    }

    @GetMapping("/query10")
    public List<Query10Result> getResultsFromQuery10(){

        return queryService.getResultsFromQuery10();
    }

    @GetMapping("/query11")
    public List<Object> getResultsFromQuery11(@RequestParam(value = "name") String name){

        return queryService.getResultsFromQuery11(name);
    }

    @GetMapping("/citizen/{id}")
    public Citizen getCitizenById(@PathVariable("id") String id){

        return citizensRepository.findCitizenBy_id(id);
    }

    @GetMapping("/incident/{id}")
    public Incident getIncidentById(@PathVariable("id") String id){

        return incidentsRepository.findIncidentBy_id(id);

    }

    @PostMapping("/newIncident")
    public Incident createNewIncident(@Valid @RequestBody Incident incident) {
        return incidentsRepository.save(incident);
    }

    @PutMapping("/updateIncident/{id}")
    public Incident updateIncident(@PathVariable("id") String id,
                                   @Valid @RequestBody Incident incident) {

        Incident oldIncident = incidentsRepository.findIncidentBy_id(id);
        IncidentAudit incidentAudit = new IncidentAudit(oldIncident);
        incidentAudit.setAuditMsg("Audit from Update at: "+ new Date().toString());
        incidentsAuditRepository.insert(incidentAudit);

        List<Citizen> citizens = queryService.getCitizensByVotedIncident(id);
        for (Citizen citizen : citizens) {
            CitizenAudit citizenAudit = new CitizenAudit(citizen);
            citizenAudit.setAuditMsg("Audit from Update at: "+ new Date().toString());
            citizensAuditRepository.insert(citizenAudit);
            List<Incident> incidents = citizen.getUpvotes();
            int index = 0;
            for (int i=0; i< incidents.size(); i++) {
                Incident incident1 = incidents.get(i);
                if (incident1.get_id().equals(incident.get_id())) {
                    index = i;
                }
            }
            incidents.remove(index);
            incidents.add(incident);
            citizen.setUpvotes(incidents);
            citizensRepository.save(citizen);
        }
       return incidentsRepository.save(incident);
    }


    @PutMapping(value="/votes/citizen/{id}")
    public ResponseEntity<String> updateCitizenVotes(@PathVariable("id") String citizenId,
                                                     @Valid @RequestBody IncidentRequest body) {
        Citizen citizen = citizensRepository.findCitizenBy_id(citizenId);

        List<Incident> votedIncidents = citizen.getUpvotes();
        boolean idExists = false;
        for (Incident votedIncident : votedIncidents) {
            if (votedIncident != null && votedIncident.get_id().equals(body.getIncidentId())) {
                idExists = true;
            }
        }
        if (idExists)  {
            return ResponseEntity.badRequest().body("Bad request: Citizen has already voted for this incident");
        } else if (votedIncidents.size() >= 1000 ) {
            return ResponseEntity.badRequest().body("Bad request: Citizen has exceeded the maximum vote limit (1000)");
        } else {
            Incident incident = incidentsRepository.findIncidentBy_id(body.getIncidentId());
            votedIncidents.add(incident);
            citizen.setUpvotes(votedIncidents);
            citizensRepository.save(citizen);
            return ResponseEntity.ok().body("Citizen's votes updated");
        }
    }
}