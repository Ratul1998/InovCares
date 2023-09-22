package com.app.health.fragments;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.health.R;
import com.app.health.databinding.FragmentRiskFactorBinding;

public class RiskFactorFragment extends Fragment {

    FragmentRiskFactorBinding binding;

    boolean answer = false;

    public RiskFactorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentRiskFactorBinding.inflate(inflater);

        return  binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.yesButton.setOnClickListener(view1 -> {

            answer = true;

            binding.yesButton.setBackgroundTintList(ColorStateList.valueOf(requireContext().getColor(R.color.blue_700)));
            binding.yesButton.setTextColor(requireContext().getColor(R.color.white));

            binding.noButton.setBackgroundTintList(ColorStateList.valueOf(requireContext().getColor(R.color.white)));
            binding.noButton.setTextColor(requireContext().getColor(R.color.blue_700));

        });


        binding.noButton.setOnClickListener(view1 -> {

            answer = false;

            binding.noButton.setBackgroundTintList(ColorStateList.valueOf(requireContext().getColor(R.color.blue_700)));
            binding.noButton.setTextColor(requireContext().getColor(R.color.white));

            binding.yesButton.setBackgroundTintList(ColorStateList.valueOf(requireContext().getColor(R.color.white)));
            binding.yesButton.setTextColor(requireContext().getColor(R.color.blue_700));

        });

    }
}