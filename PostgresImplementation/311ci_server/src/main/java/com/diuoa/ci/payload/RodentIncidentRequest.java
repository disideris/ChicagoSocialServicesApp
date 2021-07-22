package com.diuoa.ci.payload;


public class RodentIncidentRequest extends IncidentRequest {

    private String mostRecentAction;
    private String currentActivity;
    private float baitedPremises;
    private float ratPremises;
    private float garbagePremises;

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

    public float getBaitedPremises() {
        return baitedPremises;
    }

    public void setBaitedPremises(float baitedPremises) {
        this.baitedPremises = baitedPremises;
    }

    public float getRatPremises() {
        return ratPremises;
    }

    public void setRatPremises(float ratPremises) {
        this.ratPremises = ratPremises;
    }

    public float getGarbagePremises() {
        return garbagePremises;
    }

    public void setGarbagePremises(float garbagePremises) {
        this.garbagePremises = garbagePremises;
    }
}
