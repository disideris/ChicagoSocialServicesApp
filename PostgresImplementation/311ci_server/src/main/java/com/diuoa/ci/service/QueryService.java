package com.diuoa.ci.service;

import com.diuoa.ci.exception.BadRequestException;
import com.diuoa.ci.exception.ResourceNotFoundException;
import com.diuoa.ci.model.*;
import com.diuoa.ci.payload.*;
import com.diuoa.ci.repository.*;
import com.diuoa.ci.security.UserPrincipal;
import com.diuoa.ci.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.sql.Timestamp;
import java.util.*;

@Service
public class QueryService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private GarbageCartIncidentRepository garbageCartIncidentRepository;

    @Autowired
    private GraffitiIncidentRepository graffitiIncidentRepository;

    @Autowired
    private PotholeIncidentRepository potholeIncidentRepository;

    @Autowired
    private RodentIncidentRepository rodentIncidentRepository;

    @Autowired
    private SanitationIncidentRepository sanitationIncidentRepository;

    @Autowired
    private TreeDebrisIncidentRepository treeDebrisIncidentRepository;

    @Autowired
    private TreeTrimsIncidentRepository treeTrimsIncidentRepository;

    @Autowired
    private VehicleIncidentRepository vehicleIncidentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserQueryDataRepository userQueryDataRepository;

    @PersistenceContext
    private EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(QueryService.class);

    public PagedResponse<Incident> getIncidentsByStreetAddress(UserPrincipal currentUser, String streetAddress, int page, int size) {
        validatePageNumberAndSize(page, size);

        String username = currentUser.getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        String queryDataString = "Address Query for street address: "+streetAddress;
        if (page == 0) {
            saveUserQueryData(currentUser.getUsername(), queryDataString);
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<Incident> incidents = incidentRepository.findDistinctByStreetAddress(streetAddress, pageable);

        return new PagedResponse<>(incidents.getContent(), incidents.getNumber(), incidents.getSize(),
                incidents.getTotalElements(), incidents.getTotalPages(), incidents.isLast());
    }

    public PagedResponse<Incident> getIncidentsByZipCode(UserPrincipal currentUser, int zipCode, int page, int size) {
        validatePageNumberAndSize(page, size);

        String username = currentUser.getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        String queryDataString = "Address Query for zip code: "+String.valueOf(zipCode);
        if (page == 0) {
            saveUserQueryData(currentUser.getUsername(), queryDataString);
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "zipCode");
        Page<Incident> incidents = incidentRepository.findDistinctByZipCode(zipCode, pageable);

        return new PagedResponse<>(incidents.getContent(), incidents.getNumber(), incidents.getSize(),
                incidents.getTotalElements(), incidents.getTotalPages(), incidents.isLast());
    }

    public PagedResponse<Object> getIncidentsFromFunc1(UserPrincipal currentUser, Timestamp startDate, Timestamp endDate, int page, int size) {
        validatePageNumberAndSize(page, size);

        String username = currentUser.getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        Query query = em.createNamedStoredProcedureQuery("func1");
        query.setParameter("start_date", startDate);
        query.setParameter("end_date", endDate);
        ((StoredProcedureQuery) query).execute();

        List<Object> resultList = query.getResultList();
        List<Object> pagedResultList;
        int startElement = page * size;

        if (resultList.size() < startElement) {
            pagedResultList = Collections.emptyList();
        } else {
            int toIndex = Math.min(startElement + size, resultList.size());
            pagedResultList = resultList.subList(startElement, toIndex);
        }

        String queryDataString = "Func1 Query for start Date: "+startDate+ ", end Date: "+endDate;
        if (page == 0) {
            saveUserQueryData(currentUser.getUsername(), queryDataString);
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "creationDate");
        Page<Object> resultObjects = new PageImpl<>(pagedResultList, pageable, resultList.size());

        return new PagedResponse<>(resultObjects.getContent(), resultObjects.getNumber(), resultObjects.getSize(),
                resultObjects.getTotalElements(), resultObjects.getTotalPages(), resultObjects.isLast());
    }

    public PagedResponse<Object> getIncidentsFromFunc2(UserPrincipal currentUser, String type, Timestamp startDate, Timestamp endDate, int page, int size) {
        validatePageNumberAndSize(page, size);

        String username = currentUser.getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        Query query = em.createNamedStoredProcedureQuery("func2");
        query.setParameter("start_date", startDate);
        query.setParameter("end_date", endDate);
        query.setParameter("service_type", type);
        ((StoredProcedureQuery) query).execute();

        List<Object> resultList = query.getResultList();
        List<Object> pagedResultList;
        int startElement = page * size;

        if (resultList.size() < startElement) {
            pagedResultList = Collections.emptyList();
        } else {
            int toIndex = Math.min(startElement + size, resultList.size());
            pagedResultList = resultList.subList(startElement, toIndex);
        }

        String queryDataString = "Func2 Query for request type: "+type+", start Date: "+startDate+ ", end Date: "+endDate;
        if (page == 0) {
            saveUserQueryData(currentUser.getUsername(), queryDataString);
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "creationDate");
        Page<Object> resultObjects = new PageImpl<>(pagedResultList, pageable, resultList.size());

        return new PagedResponse<>(resultObjects.getContent(), resultObjects.getNumber(), resultObjects.getSize(),
                resultObjects.getTotalElements(), resultObjects.getTotalPages(), resultObjects.isLast());
    }

    public PagedResponse<Object> getIncidentsFromFunc3(UserPrincipal currentUser, Timestamp someDay, int page, int size) {
        validatePageNumberAndSize(page, size);

        String username = currentUser.getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        Query query = em.createNamedStoredProcedureQuery("func3");
        query.setParameter("some_day", someDay);
        ((StoredProcedureQuery) query).execute();

        List<Object> resultList = query.getResultList();
        List<Object> pagedResultList;
        int startElement = page * size;

        if (resultList.size() < startElement) {
            pagedResultList = Collections.emptyList();
        } else {
            int toIndex = Math.min(startElement + size, resultList.size());
            pagedResultList = resultList.subList(startElement, toIndex);
        }

        String queryDataString = "Func3 Query for date: "+someDay;
        if (page == 0) {
            saveUserQueryData(currentUser.getUsername(), queryDataString);
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "creationDate");
        Page<Object> resultObjects = new PageImpl<>(pagedResultList, pageable, resultList.size());

        return new PagedResponse<>(resultObjects.getContent(), resultObjects.getNumber(), resultObjects.getSize(),
                resultObjects.getTotalElements(), resultObjects.getTotalPages(), resultObjects.isLast());
    }

    public PagedResponse<Incident> getAllIncidents(String username, UserPrincipal currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "requestId");
        Page<Incident> incidents = incidentRepository.findAll(pageable);

        return new PagedResponse<>(incidents.getContent(), incidents.getNumber(), incidents.getSize(),
                incidents.getTotalElements(), incidents.getTotalPages(), incidents.isLast());
    }

    public PagedResponse<UserQueryData> getUserQueryData(String username, UserPrincipal currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);

        User user = userRepository.findByUsername(currentUser.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<UserQueryData> userQueryData = userQueryDataRepository.findByUsername(username, pageable);

        return new PagedResponse<>(userQueryData.getContent(), userQueryData.getNumber(), userQueryData.getSize(),
                userQueryData.getTotalElements(), userQueryData.getTotalPages(), userQueryData.isLast());
    }

    public PagedResponse<Incident> getUserInsertions(String username, UserPrincipal currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);

        User user = userRepository.findByUsername(currentUser.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Incident> userQueryData = incidentRepository.findByCreatedBy(currentUser.getId(), pageable);

        return new PagedResponse<>(userQueryData.getContent(), userQueryData.getNumber(), userQueryData.getSize(),
                userQueryData.getTotalElements(), userQueryData.getTotalPages(), userQueryData.isLast());
    }

    public Incident createGarbageCartIncident(GarbageCartIncidentRequest req) {

        Incident incident = createGenericIncident(req);

        GarbageCartIncident garbageCartIncident= new GarbageCartIncident();
        garbageCartIncident.setSsa(req.getSsa());
        garbageCartIncident.setMostRecentAction(req.getMostRecentAction());
        garbageCartIncident.setCurrentActivity(req.getCurrentActivity());
        garbageCartIncident.setBlackCartsDelivered(req.getBlackCartsDelivered());
        garbageCartIncident.setIncident(incident);

        garbageCartIncidentRepository.save(garbageCartIncident);

        return incident;
    }

    public Incident createGraffitiIncident(GraffitiIncidentRequest req) {

        Incident incident = createGenericIncident(req);

        GraffitiIncident graffitiIncident= new GraffitiIncident();
        graffitiIncident.setSsa(req.getSsa());
        graffitiIncident.setGraffitiSurface(req.getGraffitiSurface());
        graffitiIncident.setGraffitiLocation(req.getGraffitiLocation());
        graffitiIncident.setIncident(incident);

        graffitiIncidentRepository.save(graffitiIncident);

        return incident;
    }

    public Incident createPotholeIncident(PotholeIncidentRequest req) {

        Incident incident = createGenericIncident(req);

        PotholeIncident potholeIncident= new PotholeIncident();
        potholeIncident.setSsa(req.getSsa());
        potholeIncident.setMostRecentAction(req.getMostRecentAction());
        potholeIncident.setCurrentActivity(req.getCurrentActivity());
        potholeIncident.setPotholesFilled(req.getPotholesFilled());
        potholeIncident.setIncident(incident);

        potholeIncidentRepository.save(potholeIncident);

        return incident;
    }

    public Incident createRodentIncident(RodentIncidentRequest req) {

        Incident incident = createGenericIncident(req);

        RodentIncident rodentIncident= new RodentIncident();
        rodentIncident.setMostRecentAction(req.getMostRecentAction());
        rodentIncident.setCurrentActivity(req.getCurrentActivity());
        rodentIncident.setBaitedPremises(req.getBaitedPremises());
        rodentIncident.setGarbagePremises(req.getGarbagePremises());
        rodentIncident.setRatPremises(req.getRatPremises());
        rodentIncident.setIncident(incident);

        rodentIncidentRepository.save(rodentIncident);

        return incident;
    }

    public Incident createSanitationIncident(SanitationIncidentRequest req) {

        Incident incident = createGenericIncident(req);

        SanitationIncident sanitationIncident= new SanitationIncident();
        sanitationIncident.setCodeVialationNature(req.getCodeViolationNature());
        sanitationIncident.setIncident(incident);

        sanitationIncidentRepository.save(sanitationIncident);

        return incident;
    }

    public Incident createTreeDebrisIncident(TreeDebrisIncidentRequest req) {

        Incident incident = createGenericIncident(req);

        TreeDebrisIncident treeDebrisIncident= new TreeDebrisIncident();
        treeDebrisIncident.setMostRecentAction(req.getMostRecentAction());
        treeDebrisIncident.setCurrentActivity(req.getCurrentActivity());
        treeDebrisIncident.setDebrisLocation(req.getDebrisLocation());
        treeDebrisIncident.setIncident(incident);

        treeDebrisIncidentRepository.save(treeDebrisIncident);

        return incident;
    }

    public Incident createTreeTrimsIncident(TreeTrimsIncidentRequest req) {

        Incident incident = createGenericIncident(req);

        TreeTrimsIncident treeTrimsIncident= new TreeTrimsIncident();
        treeTrimsIncident.setTreesLocation(req.getTreesLocation());
        treeTrimsIncident.setIncident(incident);

        treeTrimsIncidentRepository.save(treeTrimsIncident);

        return incident;
    }

    public Incident createVehicleIncident(VehicleIncidentRequest req) {

       Incident incident = createGenericIncident(req);

        VehicleIncident vehicleIncident = new VehicleIncident();
        vehicleIncident.setSsa(req.getSsa());
        vehicleIncident.setMostRecentAction(req.getMostRecentAction());
        vehicleIncident.setCurrentActivity(req.getCurrentActivity());
        vehicleIncident.setLicensePlate(req.getLicensePlate());
        vehicleIncident.setVehicleColor(req.getVehicleColor());
        vehicleIncident.setVehicleModel(req.getVehicleModel());
        vehicleIncident.setDaysParked(req.getDaysParked());
        vehicleIncident.setIncident(incident);

        vehicleIncidentRepository.save(vehicleIncident);

        return incident;
    }

    public Incident createGenericIncident(IncidentRequest req) {

        Incident incident = new Incident();
        incident.setServiceRequestNumber(req.getRequestNumber());
        incident.setServiceRequestType(req.getRequestType());
        incident.setStatus(req.getStatus());
        incident.setCreationDate(req.getCreationDate());
        incident.setCompletionDate(req.getCompletionDate());
        incident.setStreetAddress(req.getStreetAddress());
        incident.setZipCode(req.getZipCode());
        incident.setWard(req.getWard());
        incident.setPoliceDistrict(req.getPoliceDistrict());
        incident.setCommunityArea(req.getCommunityArea());
        incident.setxCoordinate(req.getxCoordinate());
        incident.setyCoordinate(req.getyCoordinate());
        incident.setLatitude(req.getLatitude());
        incident.setLongitude(req.getLongitude());
        incident.setLocation(req.getLocation());

        return incidentRepository.save(incident);
    }

    private void saveUserQueryData(String username, String queryData){

        UserQueryData userQueryData = new UserQueryData();
        userQueryData.setUsername(username);
        userQueryData.setUserQuery(queryData);

        userQueryDataRepository.save(userQueryData);

    }

    private void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }
}
