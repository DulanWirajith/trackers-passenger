package com.example.passenger08.model;

public class LoginResponse {
    private String message;
    private boolean isUserRight;

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
}
