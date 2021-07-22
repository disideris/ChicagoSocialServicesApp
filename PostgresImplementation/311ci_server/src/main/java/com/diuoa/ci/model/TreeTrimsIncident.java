package com.diuoa.ci.model;

import com.diuoa.ci.model.audit.UserDateAudit;

import javax.persistence.*;


@Entity
@Table(name = "tree_trims_incident")
public class TreeTrimsIncident extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @JoinColumn(name = "request_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Incident incident;

    @Column(name = "trees_location")
    private String treesLocation;

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

    public String getTreesLocation() {
        return treesLocation;
    }

    public void setTreesLocation(String treesLocation) {
        this.treesLocation = treesLocation;
    }
}
