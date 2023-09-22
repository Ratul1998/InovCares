package com.app.health.activities;

import android.os.Bundle;


import com.app.health.BaseActivity;
import com.app.health.R;
import com.app.health.databinding.ActivityChartBinding;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;

public class ChartActivity extends BaseActivity<ActivityChartBinding> {

    String[] axisData = {"5 Aug", "16 Aug", "1 Sep", "15 Sept", "9 Oct"};

    int[] yAxisData = {15, 15, 12, 10, 9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenTitle(getString(R.string.charts));
        getBackButton().setOnClickListener(view -> {finish();});

        List<PointValue> yAxisValues = new ArrayList<>();
        List<AxisValue> axisValues = new ArrayList<>();


        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }

        Line line = new Line(yAxisValues).setColor(getColor(R.color.blue_700));
        line.setAreaTransparency(16);
        line.setCubic(true);
        line.setFilled(true);
        line.setHasPoints(false);

        List<Line> lines = new ArrayList<>();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(12);
        axis.setLineColor(getColor(R.color.transparent));
        axis.setName("Date ->");
        axis.setTextColor(getColor(R.color.gray));
        data.setAxisXBottom(axis);


        binding.chart.setLineChartData(data);
        Viewport viewport = new Viewport(binding.chart.getMaximumViewport());
        viewport.top = 20;
        binding.chart.setMaximumViewport(viewport);
        binding.chart.setCurrentViewport(viewport);

    }

    @Override
    protected ActivityChartBinding getViewBinding() {
        return ActivityChartBinding.inflate(getLayoutInflater());
    }
}