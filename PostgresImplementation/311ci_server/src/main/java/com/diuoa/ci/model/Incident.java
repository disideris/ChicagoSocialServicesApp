package com.diuoa.ci.model;

import com.diuoa.ci.model.audit.UserDateAudit;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "func1",
                procedureName = "func1",
                parameters = {
                        @StoredProcedureParameter(name = "start_date", mode = ParameterMode.IN, type = Timestamp.class),
                        @StoredProcedureParameter(name = "end_date", mode = ParameterMode.IN, type = Timestamp.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "func2",
                procedureName = "func2",
                parameters = {
                        @StoredProcedureParameter(name = "service_type", mode = ParameterMode.IN, type = String.class),
                        @StoredProcedureParameter(name = "start_date", mode = ParameterMode.IN, type = Timestamp.class),
                        @StoredProcedureParameter(name = "end_date", mode = ParameterMode.IN, type = Timestamp.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "func3",
                procedureName = "func3",
                parameters = {
                        @StoredProcedureParameter(name = "some_day", mode = ParameterMode.IN, type = Timestamp.class),
                }
        )
})

@Table(name = "incident")
public class Incident extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id", updatable = false, nullable = false, unique = true)
    private Long requestId;

    @Column(name = "service_request_number")
    private String serviceRequestNumber;

    @Column(name = "service_request_type")
    private String serviceRequestType;

    @Column(name = "status")
    private String status;

    @Column(name = "creation_date")
    private Timestamp CreationDate;

    @Column(name = "completion_date")
    private Timestamp completionDate;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "zip_code")
    private int zipCode;

    @Column(name = "ward")
    private int ward;

    @Column(name = "police_district")
    private int policeDistrict;

    @Column(name = "community_area")
    private int communityArea;

    @Column(name = "x_coordinate")
    private Float xCoordinate;

    @Column(name = "y_coordinate")
    private Float yCoordinate;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "location")
    private String location;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getServiceRequestNumber() {
        return serviceRequestNumber;
    }

    public void setServiceRequestNumber(String serviceRequestNumber) {
        this.serviceRequestNumber = serviceRequestNumber;
    }

    public String getServiceRequestType() {
        return serviceRequestType;
    }

    public void setServiceRequestType(String serviceRequestType) {
        this.serviceRequestType = serviceRequestType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        CreationDate = creationDate;
    }

    public Timestamp getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Timestamp completionDate) {
        this.completionDate = completionDate;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public int getPoliceDistrict() {
        return policeDistrict;
    }

    public void setPoliceDistrict(int policeDistrict) {
        this.policeDistrict = policeDistrict;
    }

    public int getCommunityArea() {
        return communityArea;
    }

    public void setCommunityArea(int communityArea) {
        this.communityArea = communityArea;
    }

    public Float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
