package com.diuoa.ci.model;

import com.diuoa.ci.model.audit.UserDateAudit;

import javax.persistence.*;


@Entity
@Table(name = "tree_debris_incident")
public class TreeDebrisIncident extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @JoinColumn(name = "request_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Incident incident;

    @Column(name = "most_recent_action")
    private String mostRecentAction;

    @Column(name = "current_activity")
    private String currentActivity;

    @Column(name = "debris_location")
    private String debrisLocation;

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

    public String getMostRecentAction() {
        return mostRecentAction;
    }

    public void setMostRecentAction(String mostRecentAction) {
        this.mostRecentAction = mostRecentAction;
    }

    public String getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(String currentActivity) {
        this.currentActivity = currentActivity;
    }

    public String getDebrisLocation() {
        return debrisLocation;
    }

    public void setDebrisLocation(String debrisLocation) {
        this.debrisLocation = debrisLocation;
    }
}
