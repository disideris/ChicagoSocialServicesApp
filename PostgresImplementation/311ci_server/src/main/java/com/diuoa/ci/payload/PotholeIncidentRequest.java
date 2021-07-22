package com.diuoa.ci.payload;


public class PotholeIncidentRequest extends IncidentRequest {

    private String ssa;
    private String mostRecentAction;
    private String currentActivity;
    private float potholesFilled;

    public String getSsa() {
        return ssa;
    }

    public void setSsa(String ssa) {
        this.ssa = ssa;
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

    public float getPotholesFilled() {
        return potholesFilled;
    }

    public void setPotholesFilled(float potholesFilled) {
        this.potholesFilled = potholesFilled;
    }
}
