package com.diuoa.ci.controller;

import com.diuoa.ci.model.Incident;
import com.diuoa.ci.repository.IncidentRepository;
import com.diuoa.ci.service.QueryService;
import com.diuoa.ci.payload.*;
import com.diuoa.ci.repository.UserRepository;
import com.diuoa.ci.security.CurrentUser;
import com.diuoa.ci.security.UserPrincipal;
import com.diuoa.ci.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.sql.Timestamp;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    @Autowired
    private QueryService queryService;

    private static final Logger logger = LoggerFactory.getLogger(IncidentController.class);

    @GetMapping("/addressIncidents")
    public PagedResponse<Incident> getIncidentsByStreetAddress(@CurrentUser UserPrincipal currentUser,
                                                               @RequestParam(value = "address") String streetAddress,
                                                               @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                               @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){

        return queryService.getIncidentsByStreetAddress(currentUser, streetAddress, page, size);
    }
    @GetMapping("/zipIncidents")
    public PagedResponse<Incident> getIncidentsByZipCode(@CurrentUser UserPrincipal currentUser,
                                                         @RequestParam(value = "zip") int zipCode,
                                                         @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                         @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){

        return queryService.getIncidentsByZipCode(currentUser, zipCode, page, size);
    }
    @GetMapping("/func1")
    public PagedResponse<Object> getIncidentsFromFunc1(@CurrentUser UserPrincipal currentUser,
                                                         @RequestParam(value = "start_date") Timestamp startDate,
                                                         @RequestParam(value = "end_date") Timestamp endDate,
                                                         @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                         @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){

        System.out.println("Start date: "+startDate);
        System.out.println("End date: "+endDate);
        return queryService.getIncidentsFromFunc1(currentUser, startDate, endDate, page, size);
    }
    @GetMapping("/func2")
    public PagedResponse<Object> getIncidentsFromFunc2(@CurrentUser UserPrincipal currentUser,
                                              @RequestParam(value = "service_type") String type,
                                              @RequestParam(value = "start_date") Timestamp startDate,
                                              @RequestParam(value = "end_date") Timestamp endDate,
                                              @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                              @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){


        return queryService.getIncidentsFromFunc2(currentUser, type, startDate, endDate, page, size);
    }

    @GetMapping("/func3")
    public PagedResponse<Object> getIncidentsFromFunc3(@CurrentUser UserPrincipal currentUser,
                                              @RequestParam(value = "some_day") Timestamp someDay,
                                              @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                              @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){

        return queryService.getIncidentsFromFunc3(currentUser, someDay, page, size);
    }

    @PostMapping("/newGraffitiIncident")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createGraffitiIncident(@Valid @RequestBody GraffitiIncidentRequest req) {

        Incident newIncident = queryService.createGraffitiIncident(req);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/incidents")
                .buildAndExpand(newIncident.getRequestId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Incident Submitted Successfully"));
    }

    @PostMapping("/newGarbageCartIncident")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createGarbageCartIncident(@Valid @RequestBody GarbageCartIncidentRequest req) {

        Incident newIncident = queryService.createGarbageCartIncident(req);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/incidents")
                .buildAndExpand(newIncident.getRequestId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Incident Submitted Successfully"));
    }

    @PostMapping("/newPotholeIncident")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createPotholeIncident(@Valid @RequestBody PotholeIncidentRequest req) {

        Incident newIncident = queryService.createPotholeIncident(req);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/incidents")
                .buildAndExpand(newIncident.getRequestId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Incident Submitted Successfully"));
    }

    @PostMapping("/newRodentIncident")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createRodentIncident(@Valid @RequestBody RodentIncidentRequest req) {

        Incident newIncident = queryService.createRodentIncident(req);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/incidents")
                .buildAndExpand(newIncident.getRequestId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Incident Submitted Successfully"));
    }

    @PostMapping("/newSanitationIncident")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createSanitationIncident(@Valid @RequestBody SanitationIncidentRequest req) {

        Incident newIncident = queryService.createSanitationIncident(req);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/incidents")
                .buildAndExpand(newIncident.getRequestId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Incident Submitted Successfully"));
    }

    @PostMapping("/newTreeDebrisIncident")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createTreeDebrisIncident(@Valid @RequestBody TreeDebrisIncidentRequest req) {

        Incident newIncident = queryService.createTreeDebrisIncident(req);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/incidents")
                .buildAndExpand(newIncident.getRequestId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Incident Submitted Successfully"));
    }

    @PostMapping("/newTreeTrimsIncident")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createTreeTrimsIncident(@Valid @RequestBody TreeTrimsIncidentRequest req) {

        Incident newIncident = queryService.createTreeTrimsIncident(req);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/incidents")
                .buildAndExpand(newIncident.getRequestId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Incident Submitted Successfully"));
    }

    @PostMapping("/newVehicleIncident")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createVehicleIncident(@Valid @RequestBody VehicleIncidentRequest req) {

        Incident newIncident = queryService.createVehicleIncident(req);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/incidents")
                .buildAndExpand(newIncident.getRequestId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Incident Submitted Successfully"));
    }

    @PostMapping("/newGenericIncident")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createGenericIncident(@Valid @RequestBody IncidentRequest req) {

        Incident newIncident = queryService.createGenericIncident(req);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/incidents")
                .buildAndExpand(newIncident.getRequestId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Incident Submitted Successfully"));
    }

}