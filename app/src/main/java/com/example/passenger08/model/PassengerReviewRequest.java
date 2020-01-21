package com.example.passenger08.model;

import java.util.Date;

public class PassengerReviewRequest {
    private String passenger_mail;
    private float  driver_discipline;
    private float  driver_arrival_time;
    private float  bus_condition;
    private Date reviewed_date;
    private String bus_number;
    private String passenger_comment;

    public String getPassenger_comment() {
        return passenger_comment;
    }

    public void setPassenger_comment(String passenger_comment) {
        this.passenger_comment = passenger_comment;
    }

    public String getPassenger_mail() {
        return passenger_mail;
    }

    public void setPassenger_mail(String passenger_mail) {
        this.passenger_mail = passenger_mail;
    }

    public float getDriver_discipline() {
        return driver_discipline;
    }

    public void setDriver_discipline(float driver_discipline) {
        this.driver_discipline = driver_discipline;
    }

    public float getDriver_arrival_time() {
        return driver_arrival_time;
    }

    public void setDriver_arrival_time(float driver_arrival_time) {
        this.driver_arrival_time = driver_arrival_time;
    }

    public float getBus_condition() {
        return bus_condition;
    }

    public void setBus_condition(float bus_condition) {
        this.bus_condition = bus_condition;
    }

    public Date getReviewed_date() {
        return reviewed_date;
    }

    public void setReviewed_date(Date reviewed_date) {
        this.reviewed_date = reviewed_date;
    }

    public String getBus_number() {
        return bus_number;
    }

    public void setBus_number(String bus_number) {
        this.bus_number = bus_number;
    }
}
