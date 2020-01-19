package com.example.passenger08.model;

public class LoginResponse {
    private String message;
    private boolean isUserRight;
    private String passengerID;
    private String passengerFirstName;
    private String passengerLastName;/*Funtion getters setters tynne 2nd name kiyla*/
    private String passengerMail;
    private String passengerContact;
    private boolean passengerIsVirtify;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isUserRight() {
        return isUserRight;
    }

    public void setUserRight(boolean userRight) {
        isUserRight = userRight;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerSecondName() {
        return passengerLastName;
    }

    public void setPassengerSecondName(String passengerSecondName) {
        this.passengerLastName = passengerSecondName;
    }

    public String getPassengerMail() {
        return passengerMail;
    }

    public void setPassengerMail(String passengerMail) {
        this.passengerMail = passengerMail;
    }

    public String getPassengerContact() {
        return passengerContact;
    }

    public void setPassengerContact(String passengerContact) {
        this.passengerContact = passengerContact;
    }

    public boolean isPassengerIsVirtify() {
        return passengerIsVirtify;
    }

    public void setPassengerIsVirtify(boolean passengerIsVirtify) {
        this.passengerIsVirtify = passengerIsVirtify;
    }
}
