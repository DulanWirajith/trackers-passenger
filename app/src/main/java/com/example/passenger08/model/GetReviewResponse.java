package com.example.passenger08.model;

public class GetReviewResponse {
    private String driver_discipline;
    private String driver_arrival_time;
    private String bus_condition;
    private String bus_number;
    private String passenger_comment;
    private String passenger_mail;
    private String reviewed_date;


    public String getDriver_discipline() {
        return driver_discipline;
    }

    public void setDriver_discipline(String driver_discipline) {
        this.driver_discipline = driver_discipline;
    }

    public String getDriver_arrival_time() {
        return driver_arrival_time;
    }

    public void setDriver_arrival_time(String driver_arrival_time) {
        this.driver_arrival_time = driver_arrival_time;
    }

    public String getBus_condition() {
        return bus_condition;
    }

    public void setBus_condition(String bus_condition) {
        this.bus_condition = bus_condition;
    }

    public String getBus_number() {
        return bus_number;
    }

    public void setBus_number(String bus_number) {
        this.bus_number = bus_number;
    }

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

    public String getReviewed_date() {
        return reviewed_date;
    }

    public void setReviewed_date(String reviewed_date) {
        this.reviewed_date = reviewed_date;
    }
}
