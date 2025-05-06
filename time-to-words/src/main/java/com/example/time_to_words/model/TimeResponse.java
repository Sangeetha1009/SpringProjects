package com.example.time_to_words.model;

public class TimeResponse {
    private String message;

    public TimeResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

