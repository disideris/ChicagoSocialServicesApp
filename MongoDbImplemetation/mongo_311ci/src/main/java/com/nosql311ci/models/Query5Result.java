package com.nosql311ci.models;

public class Query5Result {
    private String service_request_type;
    private long total;
    private String creationDate;
    private String complDate;

    public String getService_request_type() {
        return service_request_type;
    }

    public void setService_request_type(String service_request_type) {
        this.service_request_type = service_request_type;
    }

        public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getComplDate() {
        return complDate;
    }

    public void setComplDate(String complDate) {
        this.complDate = complDate;
    }
}