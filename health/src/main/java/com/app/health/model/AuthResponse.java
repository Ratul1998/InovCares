package com.app.health.model;

import com.google.gson.annotations.SerializedName;

public class AuthResponse {

    @SerializedName("data")
    private AuthData data;

    @SerializedName("message")
    private String message;


    public AuthData getData(){
        return  data;
    }

    public String getMessage(){
        return  message;
    }

    public void setData(AuthData data){
        this.data = data;
    }

    public void setMessage(String message){
        this.message = message;
    }

}
