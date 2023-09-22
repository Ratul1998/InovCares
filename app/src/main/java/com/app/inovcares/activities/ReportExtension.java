package com.app.inovcares.activities;

import com.app.health.activities.ReportActivity;
import com.app.health.model.ReportDataModel;
import com.app.health.model.ReportModel;

import java.util.ArrayList;
import java.util.Date;

public class ReportExtension extends ReportActivity {

    @Override
    protected void setReportData() {

        dates.clear();

        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());

        reports.clear();

        reports.add(new ReportModel("Overall Health Status",new Date(),new ArrayList<ReportDataModel>(){
            {
                add(new ReportDataModel("Complete Health Score","91",1));
                add(new ReportDataModel("Depression","Normal",-1));
                add(new ReportDataModel("Anxiety","Normal",-1));
                add(new ReportDataModel("Stress","Mild",1));
                add(new ReportDataModel("Type II Diabetes Risk","< 1%",0));
                add(new ReportDataModel("Pre-ecclesial risk factor","< 1%",0));
            }
        }));

        reports.add(new ReportModel("Body Composition Summary",new Date(),new ArrayList<ReportDataModel>(){
            {
                add(new ReportDataModel("Corrected BMI","23.3",0.1));
                add(new ReportDataModel("Body Fat %","18.9%",-0.7));
                add(new ReportDataModel("Healthy Body Fat Target","14.5%",-1));
                add(new ReportDataModel("Weight","201.0 lbs",-2.5));
                add(new ReportDataModel("Healthy Weight Target","190.7 lbs",0));
                add(new ReportDataModel("Lean Mass","163.0 lbs",-0.6));
                add(new ReportDataModel("Fat Mass","38.0 lbs",-1.9));
            }
        }));

        reports.add(new ReportModel("Metabolism and Caloric Intake",new Date(),new ArrayList<ReportDataModel>(){
            {
                add(new ReportDataModel("Projected Weekly Fat Loss","1.40 lbs",1));
                add(new ReportDataModel("Active Metabolic Rate","3400 cals",-1));
                add(new ReportDataModel("Resting Metabolic Rate","1971 cals",-1));
                add(new ReportDataModel("Daily Caloric Intake Goal","2685 cals",1));
                add(new ReportDataModel("Carbohydrate Daily (40%)","-714 cals",0));
                add(new ReportDataModel("Fat Daily (30%)","268 gms",0));
                add(new ReportDataModel("Protein Daily (30%)","98 gms",0));
            }
        }));

    }
}
