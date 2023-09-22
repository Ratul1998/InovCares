package com.app.inovcares.activities;

import android.content.Intent;
import android.os.Bundle;

import com.app.health.BaseActivity;
import com.app.health.activities.CaptureVideoActivity;
import com.app.health.activities.ChartActivity;
import com.app.health.activities.TaskActivity;
import com.app.inovcares.R;
import com.app.inovcares.databinding.ActivityHomeBinding;

public class HomeActivity extends BaseActivity<ActivityHomeBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setScreenTitle(R.string.choose_assessment);

        getBackButton().setOnClickListener(v -> finish());

        binding.bodyCard.setOnClickListener(view-> {
            Intent intent = new Intent(this, CaptureVideoActivity.class);
            startActivity(intent);
        });

        binding.socialCard.setOnClickListener(view -> {
            Intent intent = new Intent(this, TaskActivity.class);
            startActivity(intent);
        });

        binding.mentalCard.setOnClickListener(view -> {
            Intent intent = new Intent(this, ChartActivity.class);
            startActivity(intent);
        });

        binding.mentalEmotionalBodyCard.setOnClickListener(view -> {
            Intent intent = new Intent(this, ReportExtension.class);
            startActivity(intent);
        });

    }

    @Override
    protected ActivityHomeBinding getViewBinding() {
        return ActivityHomeBinding.inflate(getLayoutInflater());
    }
}
