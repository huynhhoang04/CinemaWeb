package main.java.model.entity;

import main.java.model.enums.TheatreStatus;

public class Theatre {
    private int theatre_id;
    private String theatre_name;
    private String location;
    private String preview_url;
    private String info;
    private TheatreStatus theatre_status;
    private String city;
    private String coodinates;

    public Theatre(int theatre_id, String theatre_name, String location, String preview_url, String info, TheatreStatus theatre_status, String city, String coodinates) {
        this.theatre_id = theatre_id;
        this.theatre_name = theatre_name;
        this.location = location;
        this.preview_url = preview_url;
        this.info = info;
        this.theatre_status = theatre_status;
        this.city = city;
        this.coodinates = coodinates;
    }

    public Theatre() {}

    public int getTheatre_id() {
        return theatre_id;
    }

    public String getTheatre_name() {
        return theatre_name;
    }

    public String getLocation() {
        return location;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public String getInfo() {
        return info;
    }

    public TheatreStatus getTheatre_status() {
        return theatre_status;
    }

    public String getCity() {
        return city;
    }

    public String getCoodinates() {
        return coodinates;
    }

    public void setTheatre_id(int theatre_id) {
        this.theatre_id = theatre_id;
    }

    public void setTheatre_name(String theatre_name) {
        this.theatre_name = theatre_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setTheatre_status(TheatreStatus theatre_status) {
        this.theatre_status = theatre_status;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCoodinates(String coodinates) {
        this.coodinates = coodinates;
    }
}
