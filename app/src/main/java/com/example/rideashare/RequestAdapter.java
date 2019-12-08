package com.example.rideashare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestViewHolder> {

    Requested lv;
    List<RequestModel> lm;
    Context context;

    public RequestAdapter(Requested lv, List<RequestModel> lm) {
        this.lv = lv;
        this.lm = lm;

    }

    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_request, viewGroup, false);

        RequestViewHolder viewHolder = new RequestViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RequestViewHolder viewHolder, int i) {
        viewHolder.name.setText(lm.get(i).getName());
        viewHolder.start.setText(lm.get(i).getStart());
        viewHolder.end.setText(lm.get(i).getEnd());
        viewHolder.date.setText(lm.get(i).getDate());
        viewHolder.number.setText(lm.get(i).getNumber());


    }

    @Override
    public int getItemCount() {
        return lm.size();
    }

}
