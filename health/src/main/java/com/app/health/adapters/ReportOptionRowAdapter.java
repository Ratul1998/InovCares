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
import com.app.health.model.ReportDataModel;

import java.util.List;

public class ReportOptionRowAdapter extends ArrayAdapter<ReportDataModel> {


    List<ReportDataModel> optionsList;


    Context context;


    public ReportOptionRowAdapter(@NonNull Context context, List<ReportDataModel> arrayList) {
        super(context, 0, arrayList);
        this.optionsList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return optionsList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.report_data_row, parent, false);
        }

        ReportDataModel option = optionsList.get(position);

        TextView titleTextView = currentItemView.findViewById(R.id.titleTextView);
        TextView valueTextView = currentItemView.findViewById(R.id.valueTextView);
        TextView scaleTextView = currentItemView.findViewById(R.id.scaleTextView);

        titleTextView.setText(option.name);
        valueTextView.setText(option.value);

        if(option.scale != 0){
            scaleTextView.setText(String.valueOf(Math.abs(option.scale)));

            if(option.scale > 0){
                scaleTextView.setTextColor(context.getColor(R.color.success));
            }
            else{
                scaleTextView.setTextColor(context.getColor(R.color.error));
            }

        }
        else{
            scaleTextView.setText("");
        }

        return currentItemView;
    }

}
