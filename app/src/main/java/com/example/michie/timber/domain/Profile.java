package com.example.michie.timber.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("length")
    @Expose
    private String length;

    @SerializedName("location")
    @Expose
    private String location;

    public String getLength() {
        return length;
    }
    public String getLocation() {
        return location;
    }
    public String getUrl() {
        return url;
    }
    public String getName() {
        return name;
    }
    public void setLength(String length) {
        this.length = length;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
