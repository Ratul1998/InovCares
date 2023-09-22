package com.app.health.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.health.R;
import com.app.health.model.ReportModel;

import java.text.SimpleDateFormat;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {

    List<ReportModel> list;

    Context context;

    public ReportAdapter(List<ReportModel> list,
                         Context context)
    {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater
                = LayoutInflater.from(context);


        View view
                = inflater
                .inflate(R.layout.report_row,
                        parent, false);

        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {

        ReportModel data = list.get(position);

        holder.reportTitleTextView.setText(data.reportName);

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM");

        holder.reportDateTextView.setText("Last updated on " + formatter.format(data.date));

        ReportOptionRowAdapter optionRowAdapter = new ReportOptionRowAdapter(context,data.reportData);

        holder.optionListView.setAdapter(optionRowAdapter);

        holder.rootLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 228 * data.reportData.size()));

    }


    public static class ReportViewHolder extends RecyclerView.ViewHolder {
        public final TextView reportTitleTextView;
        public final TextView reportDateTextView;

        public  final ListView optionListView;

        public final LinearLayout rootLayout;

        public ReportViewHolder(View view) {
            super(view);

            reportTitleTextView = (TextView) view.findViewById(R.id.reportTitleTextView);
            reportDateTextView = (TextView) view.findViewById(R.id.reportDateTextView);
            optionListView = (ListView) view.findViewById(R.id.dataListView);
            rootLayout = (LinearLayout) view.findViewById(R.id.rootLayout);
        }

    }


    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
