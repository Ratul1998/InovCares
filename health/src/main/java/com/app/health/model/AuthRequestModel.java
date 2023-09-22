package com.app.health.model;

import com.google.gson.annotations.SerializedName;

public class AuthRequestModel {
   @SerializedName("apiKey")
    private final String apiKey = "pB3EFWLbFhapWTzdPeK79nt8G8I/nxuWhJfskE4nnpFyisHT3tusyXDbxO+z4Iyilca4G73fO6cvF7bYv6fiPx/221HeoZPZq9odrOTIYhnyvQ/6LrjDAEk89UD8nqbFqe9PG3rKGOUynrhWtsVfGiVVgQfXa57wPTFbz8l2d90=";
    @SerializedName("businessUniqueId")
    private final String businessUniqueId = "waybee_technologies";
    @SerializedName("appUniqueId")
    private final String appUniqueId = "social_fleet";
    @SerializedName("callbackUrl")
    private final String callbackUrl = "https://www.waybeetech.com/";

    public AuthRequestModel(){}

}
