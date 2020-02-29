package com.example.passenger08.model;

public class Review {
    private String driver_discipline;
    private String driver_arrival_time;
    private String bus_condition;
    private String bus_number;
    private String passenger_comment;
    private String passenger_mail;
    private String reviewed_date;
    private String _id;
    private String __v;


    public Review(String driver_discipline, String driver_arrival_time, String bus_condition, String bus_number, String passenger_comment, String passenger_mail, String reviewed_date, String _id, String __v) {
        this.driver_discipline = driver_discipline;
        this.driver_arrival_time = driver_arrival_time;
        this.bus_condition = bus_condition;
        this.bus_number = bus_number;
        this.passenger_comment = passenger_comment;
        this.passenger_mail = passenger_mail;
        this.reviewed_date = reviewed_date;
        this._id = _id;
        this.__v = __v;
    }

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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }
}
