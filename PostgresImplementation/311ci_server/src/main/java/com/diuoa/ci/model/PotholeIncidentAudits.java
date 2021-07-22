package com.diuoa.ci.model;

import com.diuoa.ci.model.audit.UserDateAudit;

import javax.persistence.*;


@Entity
@Table(name = "pothole_incident_audits")
public class PotholeIncidentAudits extends UserDateAudit {
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

    @Column(name = "potholes_filled")
    private Float potholesFilled;
}
