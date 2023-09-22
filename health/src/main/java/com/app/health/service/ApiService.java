package com.app.health.service;

import com.app.health.model.AuthRequestModel;
import com.app.health.model.AuthResponse;
import com.app.health.model.ReportRequestModel;
import com.app.health.model.ReportResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    @POST("access-token/generate")
    Call<AuthResponse> generateAuthToken(@Body AuthRequestModel request);

    @POST("healthreport/generate")
    Call<ReportResponse> generateReport(@Body ReportRequestModel request , @Header("Authorization") String accessToken);

}
