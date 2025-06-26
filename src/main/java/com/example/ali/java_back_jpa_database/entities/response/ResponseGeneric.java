package com.example.ali.java_back_jpa_database.entities.response;

public class ResponseGeneric {
    private String error;

    private int statusCode;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
