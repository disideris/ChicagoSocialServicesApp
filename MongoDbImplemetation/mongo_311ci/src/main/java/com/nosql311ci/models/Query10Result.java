package com.nosql311ci.models;

import java.util.List;

public class Query10Result {

   private String phone;
    private List<String> incident_ids;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getIncident_ids() {
        return incident_ids;
    }

    public void setIncident_ids(List<String> incident_ids) {
        this.incident_ids = incident_ids;
    }
}