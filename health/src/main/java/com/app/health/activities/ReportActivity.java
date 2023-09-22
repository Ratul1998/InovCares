package com.app.health.activities;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.health.BaseActivity;
import com.app.health.R;
import com.app.health.adapters.DateFilterAdapter;
import com.app.health.adapters.ReportAdapter;
import com.app.health.databinding.ActivityReportBinding;
import com.app.health.model.ReportDataModel;
import com.app.health.model.ReportModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportActivity extends BaseActivity<ActivityReportBinding> {

    ReportAdapter reportAdapter;

    DateFilterAdapter dateFilterAdapter;


    public final List<ReportModel> reports = new ArrayList<>();

    public  final  List<Date> dates = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenTitle(getString(R.string.report));
        getBackButton().setOnClickListener(v -> finish());

        setReportData();

        reportAdapter = new ReportAdapter(reports,this);

        dateFilterAdapter = new DateFilterAdapter(dates,this);

        binding.reportRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.dateRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        binding.reportRecyclerView.setAdapter(reportAdapter);

        binding.dateRecyclerView.setAdapter(dateFilterAdapter);

    }


    protected void setReportData(){



    }

    @Override
    protected ActivityReportBinding getViewBinding() {
        return ActivityReportBinding.inflate(getLayoutInflater());
    }
}