package com.diuoa.ci.model;

import com.diuoa.ci.model.audit.UserDateAudit;

import javax.persistence.*;


@Entity
@Table(name = "tree_trims_incident_audits")
public class TreeTrimsIncidentAudits extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @JoinColumn(name = "audit_id")
    @OneToOne(cascade = CascadeType.ALL)
    private IncidentAudits incidentAudits;

    @Column(name = "trees_location")
    private String treesLocation;
}
