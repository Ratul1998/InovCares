package com.app.health.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.app.health.R;
import com.app.health.model.MentalQuestionModel;
import com.google.android.material.slider.Slider;

import java.util.List;

public class SelfHealthQuestionAdapter extends ArrayAdapter<MentalQuestionModel> {

    List<MentalQuestionModel> questions;

    public SelfHealthQuestionAdapter(@NonNull Context context,List<MentalQuestionModel> questions) {
        super(context, 0);
        this.questions = questions;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        MentalQuestionModel question = questions.get(position);

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.self_health_question_view, parent, false);
        }


        TextView questionNumberTextView =  currentItemView.findViewById(R.id.questionNumberTextView);
        TextView questionTextView =  currentItemView.findViewById(R.id.questionTextView);
        Slider answerSlider =  currentItemView.findViewById(R.id.answerStepper);

        questionNumberTextView.setText("Q"+(position +1)+". ");
        questionTextView.setText(question.question);
        answerSlider.setValue(Integer.parseInt(question.answer));

        answerSlider.addOnChangeListener((slider, value, fromUser) -> question.answer = String.valueOf((int) slider.getValue()));

        return currentItemView;
    }

    @Override
    public int getCount() {
        return questions.size();
    }
}
