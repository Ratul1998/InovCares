package com.app.health.fragments;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.health.R;
import com.app.health.activities.TaskActivity;
import com.app.health.adapters.MentalQuestionFragmentAdapter;
import com.app.health.databinding.FragmentMentalBinding;
import com.app.health.viewModels.TaskViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

public class MentalFragment extends Fragment {


    FragmentMentalBinding binding;

    TaskViewModel taskController;

    public MentalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMentalBinding.inflate(inflater);

        taskController = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        ((TaskActivity)requireActivity()).setScreenTitle(requireContext().getString(R.string.mental_and_emotional));

        taskController.setMentalQuestions();

        return  binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setStepperView();

        MentalQuestionFragmentAdapter fragmentAdapter = new MentalQuestionFragmentAdapter(requireActivity(), taskController.mentalQuestions.size());

        binding.questionViewPager.setAdapter(fragmentAdapter);

        new TabLayoutMediator(binding.tabLayout, binding.questionViewPager, (tab, position) -> {}).attach();



        binding.startButton.setOnClickListener(v -> {

            binding.questionViewPager.setVisibility(View.VISIBLE);
            binding.bottomView.setVisibility(View.VISIBLE);
            binding.startLayout.setVisibility(View.GONE);

        });

        binding.questionViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                String text = (position + 1) + "/" + taskController.mentalQuestions.size();

                binding.pageCountTextView.setText(text);

            }
        });

        binding.skipAssessmentButton.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_mentalFragment_to_bodyCompositionFragment);
        });

    }

    public void setStepperView() {

        binding.stepperView.stepOneDivider.setBackgroundColor(requireActivity().getColor(R.color.blue_700));
        binding.stepperView.stepOneTextView.setBackground(ContextCompat.getDrawable(requireContext(),R.drawable.circle_background_filled_selected));
        binding.stepperView.stepOneTextView.setTextColor(requireActivity().getColor(R.color.white));

        binding.stepperView.stepTwoTextView.setBackground(ContextCompat.getDrawable(requireContext(),R.drawable.circle_backgroud_outline));
        binding.stepperView.stepTwoTextView.setBackgroundTintList(ColorStateList.valueOf(requireActivity().getColor(R.color.blue_700)));
        binding.stepperView.stepTwoTextView.setTextColor(requireActivity().getColor(R.color.blue_700));
        binding.stepperView.stepTwoTitleView.setTextColor(requireActivity().getColor(R.color.blue_700));

    }
}