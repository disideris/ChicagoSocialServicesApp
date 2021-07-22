package com.nosql311ci.models;

public class Query3Result {
    private long total;
    private String service_request_type;
    private String zip_code;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getService_request_type() {
        return service_request_type;
    }

    public void setService_request_type(String service_request_type) {
        this.service_request_type = service_request_type;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
}