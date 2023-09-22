package com.app.health.model;

import com.google.gson.annotations.SerializedName;

public class ReportResponse {

    @SerializedName("message")
    private final String message;

    public ReportResponse(String message) {
        this.message = message;
    }

    public final String getMessage(){
        return message;
    }

}
