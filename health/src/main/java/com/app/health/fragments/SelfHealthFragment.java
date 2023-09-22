package com.app.health.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.app.health.adapters.SelfHealthQuestionAdapter;
import com.app.health.databinding.FragmentSelfHealthBinding;
import com.app.health.model.MentalQuestionModel;
import com.app.health.viewModels.TaskViewModel;

import java.util.ArrayList;
import java.util.List;

public class SelfHealthFragment extends Fragment {


    FragmentSelfHealthBinding binding;

    TaskViewModel taskController;

    public SelfHealthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelfHealthBinding.inflate(inflater);

        taskController = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        taskController.setSelfHealthQuestions();

        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SelfHealthQuestionAdapter adapter = new SelfHealthQuestionAdapter(requireContext(),taskController.selfHealthQuestions);

        binding.questionsListView.setAdapter(adapter);


    }
}