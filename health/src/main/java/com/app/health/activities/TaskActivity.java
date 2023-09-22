package com.app.health.activities;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.app.health.BaseActivity;
import com.app.health.R;
import com.app.health.databinding.ActivityTaskBinding;
import com.app.health.viewModels.TaskViewModel;

public class TaskActivity extends BaseActivity<ActivityTaskBinding> {


    TaskViewModel taskController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenTitle(getString(R.string.social_needs_screening));

        getBackButton().setOnClickListener(v -> {finish();});

        taskController = new ViewModelProvider(this).get(TaskViewModel.class);

        taskController = new ViewModelProvider(this).get(TaskViewModel.class);

        taskController.getLoading().observe(this, aBoolean -> {

            if(aBoolean){
                progressLayout.setVisibility(View.VISIBLE);
            }
            else{
                progressLayout.setVisibility(View.GONE);
            }

        });

        taskController.getReportSuccess().observe(this,message -> {

            if(message.isEmpty()){
                return;
            }

            Toast.makeText(this, message,Toast.LENGTH_SHORT).show();

            if(message.equalsIgnoreCase("success")){
                finish();
            }

        });

        taskController.generateAccessToken();

    }

    @Override
    protected ActivityTaskBinding getViewBinding() {
        return ActivityTaskBinding.inflate(getLayoutInflater());
    }
}