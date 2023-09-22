package com.app.health.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;


import com.app.health.R;
import com.app.health.model.ActivityLevelOptionModel;
import com.app.health.viewModels.TaskViewModel;

import java.util.List;

public class ActivityLevelOptionAdapter extends ArrayAdapter<ActivityLevelOptionModel> {

    List<ActivityLevelOptionModel> optionsList;

    Context context;

    TaskViewModel taskController;


    public ActivityLevelOptionAdapter(@NonNull Context context, List<ActivityLevelOptionModel> arrayList,TaskViewModel taskController) {
        super(context, 0, arrayList);
        this.optionsList = arrayList;
        this.context = context;
        this.taskController = taskController;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_level_option_row, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        ActivityLevelOptionModel option = optionsList.get(position);

        // then according to the position of the view assign the desired image for the same
        CardView optionLayout = currentItemView.findViewById(R.id.optionCardView);
        TextView titleTextView = currentItemView.findViewById(R.id.optionTitleTextView);
        TextView subTitle = currentItemView.findViewById(R.id.optionSubtitleTextView);

        titleTextView.setText(option.title);
        subTitle.setText(option.subTitle);

        setButtonStyle(option,optionLayout,titleTextView,subTitle);


        optionLayout.setOnClickListener(view -> {
            taskController.activityLevel = option.value;
            notifyDataSetChanged();
        });

        // then return the recyclable view
        return currentItemView;
    }

    private void setButtonStyle(ActivityLevelOptionModel option,CardView optionLayout,TextView titleTextView,TextView subTitle) {

        if(taskController.activityLevel == option.value){
            optionLayout.setCardBackgroundColor(context.getColor(R.color.blue_700));
            titleTextView.setTextColor(context.getColor(R.color.white));
            subTitle.setTextColor(context.getColor(R.color.white));
        }
        else{
            optionLayout.setCardBackgroundColor(context.getColor(R.color.white));
            titleTextView.setTextColor(context.getColor(R.color.blue_700));
            subTitle.setTextColor(context.getColor(R.color.blue_700));
        }

    }

}
