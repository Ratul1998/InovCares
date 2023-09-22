package com.app.health.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReportRequestModel {
    @SerializedName("reportType")
    private final String reportType;

    @SerializedName("userReferenceID")
    private final String userReferenceID;

    @SerializedName("activityLevel")
    private final int activityLevel;

    @SerializedName("dob")
    private final long dob;

    @SerializedName("gender")
    private final String gender;

    @SerializedName("height")
    private final double height;

    @SerializedName("weight")
    private final double weight;


    @SerializedName("waist")
    private final double waist;


    @SerializedName("bodyFatPercentage")
    private final double bodyFatPercentage;

    @SerializedName("selfHealthReadiness")
    private final List<MentalQuestionModel> selfHealthReadiness;


    public ReportRequestModel(String reportType, String userReferenceID, int activityLevel, long dob, String gender, double height, double weight, double waist, double bodyFatPercentage,List<MentalQuestionModel> selfHealthReadiness) {
        this.reportType = reportType;
        this.userReferenceID = userReferenceID;
        this.activityLevel = activityLevel;
        this.dob = dob;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.waist = waist;
        this.bodyFatPercentage = bodyFatPercentage;
        this.selfHealthReadiness = selfHealthReadiness;
    }
}
