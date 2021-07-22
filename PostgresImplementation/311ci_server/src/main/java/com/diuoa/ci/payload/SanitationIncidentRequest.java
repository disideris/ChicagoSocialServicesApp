package com.diuoa.ci.payload;


public class SanitationIncidentRequest extends IncidentRequest {

    private String codeViolationNature;

    public String getCodeViolationNature() {
        return codeViolationNature;
    }

    public void setCodeViolationNature(String codeViolationNature) {
        this.codeViolationNature = codeViolationNature;
    }
}
