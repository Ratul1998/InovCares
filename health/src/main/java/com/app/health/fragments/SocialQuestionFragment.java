package com.app.health.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.app.health.adapters.QuestionOptionsAdapter;
import com.app.health.databinding.FragmentSocialQuestionBinding;
import com.app.health.model.SocialQuestionModel;
import com.app.health.viewModels.TaskViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SocialQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SocialQuestionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private int position;

    SocialQuestionModel questionModel;
    public SocialQuestionFragment() {
        // Required empty public constructor
    }


    FragmentSocialQuestionBinding binding;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SocialQuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SocialQuestionFragment newInstance(int position) {
        SocialQuestionFragment fragment = new SocialQuestionFragment();
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

        questionModel = (new ViewModelProvider(requireActivity()).get(TaskViewModel.class)).socialQuestions.get(position);

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSocialQuestionBinding.inflate(inflater);

        return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.questionTypeTextView.setText(questionModel.title);
        binding.questionTextView.setText(questionModel.question);

        QuestionOptionsAdapter optionsAdapter = new  QuestionOptionsAdapter(requireContext(),questionModel.options,questionModel.answers,questionModel.isMultiSelect);

        binding.optionsListView.setAdapter(optionsAdapter);


    }
}