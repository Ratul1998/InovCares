package com.app.health.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.app.health.databinding.FragmentBodyWeightBinding;
import com.app.health.viewModels.TaskViewModel;
import com.shawnlin.numberpicker.NumberPicker;


public class BodyWeightFragment extends Fragment {


    FragmentBodyWeightBinding binding;

    TaskViewModel taskViewModel;

    public BodyWeightFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBodyWeightBinding.inflate(inflater);


        taskViewModel = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        return  binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.weightIntegerPart.setValue(taskViewModel.bodyWeightInteger);

        binding.weightDecimalPart.setValue(taskViewModel.bodyWeightDecimal);

        binding.weightIntegerPart.setOnValueChangedListener((picker, oldVal, newVal) -> {
            taskViewModel.bodyWeightInteger = newVal;
        });


        binding.weightDecimalPart.setOnValueChangedListener((picker, oldVal, newVal) -> {
            taskViewModel.bodyWeightDecimal = newVal;
        });

    }
}