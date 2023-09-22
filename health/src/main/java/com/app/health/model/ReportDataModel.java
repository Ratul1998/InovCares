package com.app.health.model;

public class ReportDataModel {

    public final String name;

    public final String value;

    public final double scale;

    public ReportDataModel(String name, String value, double scale) {
        this.name = name;

        this.value = value;

        this.scale = scale;
    }

}
