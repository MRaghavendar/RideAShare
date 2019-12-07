package com.example.rideashare;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RideViewHolder extends RecyclerView.ViewHolder {

    TextView passName, passStart, passEnd, passDates, passSeats, passPrice, passAddress ;
    View mView;
    public RideViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
                return true;
            }
        });

        passName = itemView.findViewById(R.id.nameTV);
        passStart = itemView.findViewById(R.id.startTV);
        passEnd = itemView.findViewById(R.id.endTV);
        passDates = itemView.findViewById(R.id.datesTV);
        passSeats = itemView.findViewById(R.id.seatsTV);
        passPrice = itemView.findViewById(R.id.priceTV);
        passAddress = itemView.findViewById(R.id.addressTV);


    }
    private RideViewHolder.ClickListener mClickListener;
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(RideViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}