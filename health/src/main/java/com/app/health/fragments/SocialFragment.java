package com.app.health.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.health.R;
import com.app.health.activities.TaskActivity;
import com.app.health.adapters.SocialQuestionFragmentAdapter;
import com.app.health.databinding.FragmentSocialBinding;
import com.app.health.viewModels.TaskViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

public class SocialFragment extends Fragment {


    FragmentSocialBinding binding;


    private TaskViewModel taskController;

    public SocialFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSocialBinding.inflate(inflater);

        taskController = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        taskController.setSocialActivityQuestions();

        ((TaskActivity)requireActivity()).setScreenTitle(requireContext().getString(R.string.social_needs_screening));

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        SocialQuestionFragmentAdapter fragmentAdapter = new SocialQuestionFragmentAdapter(requireActivity(), taskController.socialQuestions);

        binding.questionViewPager.setAdapter(fragmentAdapter);


        new TabLayoutMediator(binding.tabLayout, binding.questionViewPager, (tab, position) -> {}).attach();


        binding.questionViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                String text = (position + 1) + "/" + taskController.socialQuestions.size();

                binding.pageCountTextView.setText(text);

            }
        });

        binding.skipAssessmentButton.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_socialFragment_to_mentalFragment);
        });


    }
}