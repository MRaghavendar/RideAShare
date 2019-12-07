package com.example.rideashare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RideAdapter extends RecyclerView.Adapter<RideViewHolder> {

    RideActivity lv;
    List<RideModel> lm;
    Context context;

    public RideAdapter(RideActivity lv, List<RideModel> lm) {
        this.lv = lv;
        this.lm = lm;

    }

    @NonNull
    @Override
    public RideViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_ride, viewGroup, false);

        RideViewHolder viewHolder = new RideViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RideViewHolder viewHolder, int i) {
        viewHolder.passName.setText(lm.get(i).getName());
        viewHolder.passStart.setText(lm.get(i).getStartLoc());
        viewHolder.passEnd.setText(lm.get(i).getEndLoc());
        viewHolder.passDates.setText(lm.get(i).getDates());
        viewHolder.passSeats.setText(lm.get(i).getSeats());
        viewHolder.passPrice.setText(lm.get(i).getPrice());
        viewHolder.passAddress.setText(lm.get(i).getAddress());


    }

    @Override
    public int getItemCount() {
        return lm.size();
    }

}
