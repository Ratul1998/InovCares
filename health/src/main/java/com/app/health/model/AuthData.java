package com.app.health.model;

import com.google.gson.annotations.SerializedName;

public class AuthData {

    @SerializedName("accessToken")
    private String accessToken;

    public String getAccessToken(){
        return accessToken;
    }

    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

}
