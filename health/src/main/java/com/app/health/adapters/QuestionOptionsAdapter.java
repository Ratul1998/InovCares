package com.app.health.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.app.health.R;

import java.util.List;

public class QuestionOptionsAdapter extends ArrayAdapter<String> {

    List<String> optionsList;

    List<String> answerList;

    Context context;

    final boolean isMultiselect;

    public QuestionOptionsAdapter(@NonNull Context context, List<String> arrayList,List<String> answersList,boolean isMultiselect) {
        super(context, 0, arrayList);
        this.optionsList = arrayList;
        this.answerList = answersList;
        this.context = context;
        this.isMultiselect = isMultiselect;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.question_option_button, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        String option = getItem(position);

        // then according to the position of the view assign the desired image for the same
        Button button = currentItemView.findViewById(R.id.optionButton);

        button.setText(option);

       setButtonStyle(option,button);


        button.setOnClickListener(view -> {
            if(isMultiselect){
                if(answerList.contains(option)){
                    answerList.remove(option);
                }
                else{
                    answerList.add(option);
                }
            }
            else{
                answerList.clear();
                answerList.add(option);
            }


            notifyDataSetChanged();

        });

        // then return the recyclable view
        return currentItemView;
    }

    private void setButtonStyle(String option,Button button) {
        if(answerList.contains(option)){
            button.setTextColor(context.getColor(R.color.white));
            button.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.blue_700));
        }
        else{
            button.setTextColor(context.getColor(R.color.blue_700));
            button.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.white));
        }
    }

}
