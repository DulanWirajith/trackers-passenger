package com.example.passenger08.model;


public class BackgroundTask {
    private static BackgroundTask backgroundTask;
    private static String passengerId;
    private static String passengerFirstName;
    private static String passengerSecondName;
    private static String passengerMail;
    private static String passengerContact;
    private static boolean passengerIsVertify;


    private BackgroundTask(String passengerId, String passengerFirstName, String passengerSecondName, String passengerMail, String passengerContact, boolean passengerIsVertify) {
        this.passengerId = passengerId;
        this.passengerFirstName = passengerFirstName;
        this.passengerSecondName = passengerSecondName;
        this.passengerMail = passengerMail;
        this.passengerContact = passengerContact;
        this.passengerIsVertify = passengerIsVertify;
    }

    public static String getPassengerId() {
        return passengerId;
    }

    public static String getPassengerFirstName() {
        return passengerFirstName;
    }

    public static String getPassengerSecondName() {
        return passengerSecondName;
    }

    public static String getPassengerMail() {
        return passengerMail;
    }

    public static String getPassengerContact() {
        return passengerContact;
    }

    public static boolean isPassengerIsVertify() {
        return passengerIsVertify;
    }

    public static BackgroundTask setBackgroundTask(String passengerId, String passengerFirstName, String passengerSecondName, String passengerMail, String passengerContact, boolean passengerIsVertify) {
        if (backgroundTask == null) {
            backgroundTask = new BackgroundTask(passengerId, passengerFirstName, passengerSecondName, passengerMail, passengerContact, passengerIsVertify);
        }
        return backgroundTask;
    }

    public static BackgroundTask getBackgroundTask() {
        return backgroundTask;
    }
}