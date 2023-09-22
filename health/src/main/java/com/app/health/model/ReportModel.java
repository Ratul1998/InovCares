package com.app.health.model;

import java.util.Date;
import java.util.List;

public class ReportModel {

    public final String reportName;

    public final Date date;

    public final List<ReportDataModel> reportData;


    public ReportModel(String reportName, Date date, List<ReportDataModel> reportData) {
        this.reportName = reportName;
        this.date = date;
        this.reportData = reportData;
    }
}

