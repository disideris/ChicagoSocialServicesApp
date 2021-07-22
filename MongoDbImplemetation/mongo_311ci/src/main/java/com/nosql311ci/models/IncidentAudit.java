package com.nosql311ci.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="incidents_audit")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncidentAudit  {

    @Id
    private String _id;

    @Field("incident_id")
    private String incidentId;

    @Field("audit_msg")
    private String auditMsg;

    @Field("service_request_number")
    private String serviceRequestNumber;

    @Field("service_request_type")
    private String serviceRequestType;

    @Field("status")
    private String status;

    @Field("creation_date")
    private String CreationDate;

    @Field("completion_date")
    private String completionDate;

    @Field("street_address")
    private String streetAddress;

    @Field("zip_code")
    private String zipCode;

    @Field("ward")
    private int ward;

    @Field("police_district")
    private int policeDistrict;

    @Field("community_area")
    private int communityArea;

    @Field("x_coordinate")
    private Float xCoordinate;

    @Field("y_coordinate")
    private Float yCoordinate;

    @Field("latitude")
    private Float latitude;

    @Field("longitude")
    private Float longitude;

    @Field("location")
    private String location;

    @Field("ssa")
    private String ssa;

    @Field("most_recent_action")
    private String mostRecentAction;

    @Field("current_activity")
    private String currentActivity;

    @Field("black_carts_delivered")
    private Float blackCartsDelivered;

    @Field("graffiti_surface")
    private String graffitiSurface;

    @Field("graffiti_location")
    private String graffitiLocation;

    @Field("potholes_filled")
    private Float potholesFilled;

    @Field("baited_premises")
    private Float baitedPremises;

    @Field("garbage_premises")
    private Float garbagePremises;

    @Field("rat_premises")
    private Float ratPremises;

    @Field("code_violation_nature")
    private String codeVialationNature;

    @Field("debris_location")
    private String debrisLocation;

    @Field("trees_location")
    private String treesLocation;

    @Field("license_plate")
    private String licensePlate;

    @Field("vehicle_model")
    private String vehicleModel;

    @Field("vehicle_color")
    private String vehicleColor;

    @Field("days_parked")
    private Float daysParked;

    public IncidentAudit(Incident incident) {
        this.incidentId = incident.get_id();
        this.baitedPremises = incident.getBaitedPremises();
        this.blackCartsDelivered = incident.getBlackCartsDelivered();
        this.codeVialationNature = incident.getCodeVialationNature();
        this.communityArea = incident.getCommunityArea();
        this.CreationDate = incident.getCreationDate();
        this.completionDate = incident.getCompletionDate();
        this.currentActivity = incident.getCurrentActivity();
        this.daysParked = incident.getDaysParked();
        this.debrisLocation = incident.getDebrisLocation();
        this.garbagePremises = incident.getGarbagePremises();
        this.graffitiLocation = incident.getGraffitiLocation();
        this.graffitiSurface = incident.getGraffitiSurface();
        this.latitude = incident.getLatitude();
        this.licensePlate = incident.getLicensePlate();
        this.location = incident.getLocation();
        this.longitude = incident.getLongitude();
        this.mostRecentAction = incident.getMostRecentAction();
        this.policeDistrict = incident.getPoliceDistrict();
        this.potholesFilled = incident.getPotholesFilled();
        this.ratPremises = incident.getRatPremises();
        this.serviceRequestNumber = incident.getServiceRequestNumber();
        this.serviceRequestType = incident.getServiceRequestType();
        this.ssa = incident.getSsa();
        this.status = incident.getStatus();
        this.streetAddress = incident.getStreetAddress();
        this.treesLocation = incident.getTreesLocation();
        this.vehicleColor = incident.getVehicleColor();
        this.vehicleModel = incident.getVehicleModel();
        this.ward = incident.getWard();
        this.xCoordinate = incident.getxCoordinate();
        this.yCoordinate = incident.getyCoordinate();
        this.zipCode = incident.getZipCode();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getAuditMsg() {
        return auditMsg;
    }

    public void setAuditMsg(String auditMsg) {
        this.auditMsg = auditMsg;
    }

    public String getServiceRequestNumber() {
        return serviceRequestNumber;
    }

    public void setServiceRequestNumber(String serviceRequestNumber) {
        this.serviceRequestNumber = serviceRequestNumber;
    }

    public String getServiceRequestType() {
        return serviceRequestType;
    }

    public void setServiceRequestType(String serviceRequestType) {
        this.serviceRequestType = serviceRequestType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
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

    public Float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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

    public Float getBlackCartsDelivered() {
        return blackCartsDelivered;
    }

    public void setBlackCartsDelivered(Float blackCartsDelivered) {
        this.blackCartsDelivered = blackCartsDelivered;
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

    public Float getPotholesFilled() {
        return potholesFilled;
    }

    public void setPotholesFilled(Float potholesFilled) {
        this.potholesFilled = potholesFilled;
    }

    public Float getBaitedPremises() {
        return baitedPremises;
    }

    public void setBaitedPremises(Float baitedPremises) {
        this.baitedPremises = baitedPremises;
    }

    public Float getGarbagePremises() {
        return garbagePremises;
    }

    public void setGarbagePremises(Float garbagePremises) {
        this.garbagePremises = garbagePremises;
    }

    public Float getRatPremises() {
        return ratPremises;
    }

    public void setRatPremises(Float ratPremises) {
        this.ratPremises = ratPremises;
    }

    public String getCodeVialationNature() {
        return codeVialationNature;
    }

    public void setCodeVialationNature(String codeVialationNature) {
        this.codeVialationNature = codeVialationNature;
    }

    public String getDebrisLocation() {
        return debrisLocation;
    }

    public void setDebrisLocation(String debrisLocation) {
        this.debrisLocation = debrisLocation;
    }

    public String getTreesLocation() {
        return treesLocation;
    }

    public void setTreesLocation(String treesLocation) {
        this.treesLocation = treesLocation;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public Float getDaysParked() {
        return daysParked;
    }

    public void setDaysParked(Float daysParked) {
        this.daysParked = daysParked;
    }
}