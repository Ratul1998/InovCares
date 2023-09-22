package com.app.health.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.app.health.R;
import com.app.health.databinding.FragmentMentalQuestionBinding;
import com.app.health.model.MentalQuestionModel;
import com.app.health.viewModels.TaskViewModel;

public class MentalQuestionFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private int position;

    private MentalQuestionModel questionModel;

    private FragmentMentalQuestionBinding binding;

    public MentalQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MentalQuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MentalQuestionFragment newInstance(int position) {
        MentalQuestionFragment fragment = new MentalQuestionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_PARAM1);
        }

        questionModel = (new ViewModelProvider(requireActivity()).get(TaskViewModel.class)).mentalQuestions.get(position);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMentalQuestionBinding.inflate(inflater);

        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.questionTextView.setText(questionModel.question);

        binding.zeroCardView.setOnClickListener(view1 -> {
            questionModel.answer = String.valueOf(0);
            setButtonColor();
        });

        binding.oneCardView.setOnClickListener(view1 -> {
            questionModel.answer = String.valueOf(1);
            setButtonColor();
        });

        binding.twoCardView.setOnClickListener(view1 -> {
            questionModel.answer = String.valueOf(2);
            setButtonColor();
        });

        binding.threeCardView.setOnClickListener(view1 -> {
            questionModel.answer = String.valueOf(3);
            setButtonColor();
        });


    }

    private void setButtonColor() {





        switch (questionModel.answer){
            case "0":
                binding.zeroTextView.setTextColor(requireContext().getColor(R.color.white));
                binding.oneTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.twoTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.threeTextView.setTextColor(requireContext().getColor(R.color.blue_700));

                binding.zeroCardView.setCardBackgroundColor(requireContext().getColor(R.color.blue_700));
                binding.oneCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.twoCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.threeCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                break;
            case "1":
                binding.zeroTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.oneTextView.setTextColor(requireContext().getColor(R.color.white));
                binding.twoTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.threeTextView.setTextColor(requireContext().getColor(R.color.blue_700));

                binding.zeroCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.oneCardView.setCardBackgroundColor(requireContext().getColor(R.color.blue_700));
                binding.twoCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.threeCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                break;
            case "2":
                binding.zeroTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.oneTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.twoTextView.setTextColor(requireContext().getColor(R.color.white));
                binding.threeTextView.setTextColor(requireContext().getColor(R.color.blue_700));

                binding.zeroCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.oneCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.twoCardView.setCardBackgroundColor(requireContext().getColor(R.color.blue_700));
                binding.threeCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                break;
            case "3":
                binding.zeroTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.oneTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.twoTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.threeTextView.setTextColor(requireContext().getColor(R.color.white));

                binding.zeroCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.oneCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.twoCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.threeCardView.setCardBackgroundColor(requireContext().getColor(R.color.blue_700));
                break;
            default:
                binding.zeroTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.oneTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.twoTextView.setTextColor(requireContext().getColor(R.color.blue_700));
                binding.threeTextView.setTextColor(requireContext().getColor(R.color.blue_700));

                binding.zeroCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.oneCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.twoCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
                binding.threeCardView.setCardBackgroundColor(requireContext().getColor(R.color.white));
        }

    }

}