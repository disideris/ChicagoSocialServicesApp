package com.diuoa.ci.model;

import com.diuoa.ci.model.audit.UserDateAudit;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "incident_audits")
public class IncidentAudits extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "request_id", nullable = false)
    private Long requestId;

    @Column(name = "service_request_number")
    private String serviceRequestNubmer;

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
}
