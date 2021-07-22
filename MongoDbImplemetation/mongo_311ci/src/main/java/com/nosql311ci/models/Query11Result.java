package com.nosql311ci.models;

import java.util.List;

public class Query11Result {

    private String name;
    private List<Integer> wards;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getWards() {
        return wards;
    }

    public void setWards(List<Integer> wards) {
        this.wards = wards;
    }
}