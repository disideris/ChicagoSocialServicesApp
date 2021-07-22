package com.diuoa.ci.model;

import com.diuoa.ci.model.audit.UserDateAudit;

import javax.persistence.*;


@Entity
@Table(name = "vehicle_incident_audits")
public class VehicleIncidentAudits extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @JoinColumn(name = "audit_id")
    @OneToOne(cascade = CascadeType.ALL)
    private IncidentAudits incidentAudits;

    @Column(name = "ssa")
    private String ssa;

    @Column(name = "most_recent_action")
    private String mostRecentAction;

    @Column(name = "current_activity")
    private String currentActivity;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "vehicle_model")
    private String vehicleModel;

    @Column(name = "vehicle_color")
    private String vehicleColor;

    @Column(name = "days_parked")
    private Float daysParked;

}
