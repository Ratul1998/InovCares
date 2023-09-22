package com.app.health.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.app.health.adapters.ActivityLevelOptionAdapter;
import com.app.health.databinding.FragmentActivityLevelfragmentBinding;
import com.app.health.model.ActivityLevelOptionModel;
import com.app.health.viewModels.TaskViewModel;

import java.util.ArrayList;
import java.util.List;

public class ActivityLevelFragment extends Fragment {


    FragmentActivityLevelfragmentBinding binding;

    TaskViewModel taskController;

    public ActivityLevelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentActivityLevelfragmentBinding.inflate(inflater);

        taskController = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<ActivityLevelOptionModel> options = new ArrayList<>();

        options.add(new ActivityLevelOptionModel(1,"Sedentary","Little or no exercise, desk job."));
        options.add(new ActivityLevelOptionModel(2,"Lightly Active","Exercise 30 minutes or less 1 to 3 times a week."));
        options.add(new ActivityLevelOptionModel(3,"Moderately Active","Exercising 30 minutes or less 3-5 days a week."));
        options.add(new ActivityLevelOptionModel(4,"Very Active","Exercising 60 minutes or less 3-5 days a week."));
        options.add(new ActivityLevelOptionModel(5,"Extreme Active","Professional athlete or individuals doing 2 workouts a day or workouts 90 min+ 6 days a week."));


        ActivityLevelOptionAdapter adapter = new ActivityLevelOptionAdapter(requireContext(),options,taskController);

        binding.optionsListView.setAdapter(adapter);

    }
}