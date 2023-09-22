package com.app.health.fragments;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.health.R;
import com.app.health.activities.CaptureVideoActivity;
import com.app.health.activities.TaskActivity;
import com.app.health.adapters.BodyCompositionFragmentAdapter;
import com.app.health.databinding.FragmentBodyCompositionBinding;
import com.app.health.viewModels.TaskViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

public class BodyCompositionFragment extends Fragment {

    FragmentBodyCompositionBinding binding;

    TaskViewModel taskController;

    int currentPosition = 0;

    public BodyCompositionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBodyCompositionBinding.inflate(inflater);

        taskController = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        if(currentPosition == 0){
            ((TaskActivity)requireActivity()).setScreenTitle(requireContext().getString(R.string.pre_ecclesial_risk_factor));
        }
        else{
            ((TaskActivity)requireActivity()).setScreenTitle(requireContext().getString(R.string.social_needs_screening));
        }

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setStepperView();

        BodyCompositionFragmentAdapter fragmentAdapter = new BodyCompositionFragmentAdapter(requireActivity());

        binding.questionViewPager.setAdapter(fragmentAdapter);


        new TabLayoutMediator(binding.tabLayout, binding.questionViewPager, (tab, position) -> {}).attach();


        binding.questionViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                currentPosition = position;

                String text = (position + 1) + "/" + 4;

                binding.pageCountTextView.setText(text);

                if(currentPosition == 0){
                    ((TaskActivity)requireActivity()).setScreenTitle(requireContext().getString(R.string.pre_ecclesial_risk_factor));
                }
                else{
                    ((TaskActivity)requireActivity()).setScreenTitle(requireContext().getString(R.string.social_needs_screening));
                }

            }
        });

        binding.nextButton.setOnClickListener(v -> {

            if(currentPosition < 4){
                binding.questionViewPager.setCurrentItem(++currentPosition);
            }
            else{
                taskController.sendReportData();
            }


        });

    }


    public void setStepperView() {

        binding.stepperView.stepOneDivider.setBackgroundColor(requireActivity().getColor(R.color.blue_700));
        binding.stepperView.stepOneTextView.setBackground(ContextCompat.getDrawable(requireContext(),R.drawable.circle_background_filled_selected));
        binding.stepperView.stepOneTextView.setTextColor(requireActivity().getColor(R.color.white));

        binding.stepperView.stepTwoDivider.setBackgroundColor(requireActivity().getColor(R.color.blue_700));
        binding.stepperView.stepTwoTitleView.setTextColor(requireActivity().getColor(R.color.blue_700));
        binding.stepperView.stepTwoTextView.setBackground(ContextCompat.getDrawable(requireContext(),R.drawable.circle_background_filled_selected));
        binding.stepperView.stepTwoTextView.setTextColor(requireActivity().getColor(R.color.white));

        binding.stepperView.stepThreeTextView.setBackground(ContextCompat.getDrawable(requireContext(),R.drawable.circle_backgroud_outline));
        binding.stepperView.stepThreeTextView.setBackgroundTintList(ColorStateList.valueOf(requireActivity().getColor(R.color.blue_700)));
        binding.stepperView.stepThreeTextView.setTextColor(requireActivity().getColor(R.color.blue_700));
        binding.stepperView.stepThreeTitleTextView.setTextColor(requireActivity().getColor(R.color.blue_700));

    }
}