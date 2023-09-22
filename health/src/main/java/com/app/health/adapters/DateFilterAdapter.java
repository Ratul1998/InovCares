package com.app.health.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.health.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateFilterAdapter extends RecyclerView.Adapter<DateFilterAdapter.ButtonViewHolder> {

    List<Date> list;

    Context context;

    Date selectedDate;

    public DateFilterAdapter(List<Date> list,
                         Context context)
    {
        this.list = list;

        if(list.size() > 0){
            selectedDate = list.get(0);
        }

        this.context = context;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater
                = LayoutInflater.from(context);


        View view
                = inflater
                .inflate(R.layout.app_button,
                        parent, false);

        return new ButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {


        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM");

        holder.button.setText(formatter.format(list.get(position)));

        if(selectedDate == list.get(position)){
            holder.button.setTextColor(context.getColor(R.color.white));
            holder.button.setBackgroundColor(context.getColor(R.color.blue_500));
        }
        else{
            holder.button.setTextColor(context.getColor(R.color.black));
            holder.button.setBackgroundColor(context.getColor(R.color.white));
        }

        holder.button.setOnClickListener(view -> {selectedDate = list.get(position);notifyDataSetChanged();});


    }


    public static class ButtonViewHolder extends RecyclerView.ViewHolder {
        public final Button button;

        public ButtonViewHolder(View view) {
            super(view);

            button = (Button) view.findViewById(R.id.appButton);
        }

    }


    @Override
    public int getItemCount()
    {
        return list.size();
    }
}

