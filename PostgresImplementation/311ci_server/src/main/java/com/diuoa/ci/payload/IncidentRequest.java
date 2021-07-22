package com.diuoa.ci.payload;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class IncidentRequest {

    private String requestNumber;
    private String requestType;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp creationDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp completionDate;
    private String streetAddress;
    private int zipCode;
    private int ward;
    private int policeDistrict;
    private int communityArea;
    private float xCoordinate;
    private float yCoordinate;
    private float latitude;
    private float longitude;
    private String location;

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Timestamp completionDate) {
        this.completionDate = completionDate;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public int getPoliceDistrict() {
        return policeDistrict;
    }

    public void setPoliceDistrict(int policeDistrict) {
        this.policeDistrict = policeDistrict;
    }

    public int getCommunityArea() {
        return communityArea;
    }

    public void setCommunityArea(int communityArea) {
        this.communityArea = communityArea;
    }

    public float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
