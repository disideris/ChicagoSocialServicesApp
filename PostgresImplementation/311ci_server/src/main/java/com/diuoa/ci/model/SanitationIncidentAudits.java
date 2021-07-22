package com.diuoa.ci.model;

import com.diuoa.ci.model.audit.UserDateAudit;

import javax.persistence.*;


@Entity
@Table(name = "sanitation_incident_audits")
public class SanitationIncidentAudits extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @JoinColumn(name = "audit_id")
    @OneToOne(cascade = CascadeType.ALL)
    private IncidentAudits incidentAudits;

    @Column(name = "code_violation_nature")
    private String codeVialationNature;
}
