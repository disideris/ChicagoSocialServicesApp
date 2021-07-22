package com.diuoa.ci.payload;


public class GraffitiIncidentRequest extends IncidentRequest {

    private String ssa;
    private String graffitiSurface;
    private String graffitiLocation;


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
