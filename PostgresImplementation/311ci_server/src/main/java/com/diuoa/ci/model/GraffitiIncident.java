package com.diuoa.ci.model;

import com.diuoa.ci.model.audit.UserDateAudit;

import javax.persistence.*;


@Entity
@Table(name = "graffiti_incident")
public class GraffitiIncident extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @JoinColumn(name = "request_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Incident incident;

    @Column(name = "ssa")
    private String ssa;

    @Column(name = "graffiti_surface")
    private String graffitiSurface;

    @Column(name = "graffiti_location")
    private String graffitiLocation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public String getSsa() {
        return ssa;
    }

    public void setSsa(String ssa) {
        this.ssa = ssa;
    }

    public String getGraffitiSurface() {
        return graffitiSurface;
    }

    public void setGraffitiSurface(String graffitiSurface) {
        this.graffitiSurface = graffitiSurface;
    }

    public String getGraffitiLocation() {
        return graffitiLocation;
    }

    public void setGraffitiLocation(String graffitiLocation) {
        this.graffitiLocation = graffitiLocation;
    }
}
