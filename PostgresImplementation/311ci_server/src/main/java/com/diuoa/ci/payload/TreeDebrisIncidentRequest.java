package com.diuoa.ci.payload;


public class TreeDebrisIncidentRequest extends IncidentRequest{

    private String mostRecentAction;
    private String currentActivity;
    private String debrisLocation;

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
