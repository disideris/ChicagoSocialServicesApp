package com.nosql311ci.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection="citizens")
//@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Citizen {
    @Id
    private String _id;

    @Field("name")
    private String name;

    @Field("address")
    private String address;

    @Field("phone")
    private String phone;

    @Field("upvotes")
    private List<Incident> upvotes;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Incident> getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(List<Incident> upvotes) {
        this.upvotes = upvotes;
    }
}