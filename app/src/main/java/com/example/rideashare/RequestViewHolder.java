package com.example.rideashare;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RequestViewHolder extends RecyclerView.ViewHolder{


        TextView id , name, start, end , date, number ;
        View mView;

        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;


//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                     mClickListener.onItemClick(v, getAdapterPosition());
////                     onNoteListener.onNoteCLick(getAdapterPosition());
//
//                }
//            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mClickListener.onItemClick(v, getAdapterPosition());
                    return true;
                }
            });

            name = itemView.findViewById(R.id.name1);
            start = itemView.findViewById(R.id.name2);
            end = itemView.findViewById(R.id.name3);
            date = itemView.findViewById(R.id.name4);
            number = itemView.findViewById(R.id.name5);


        }
        private com.example.rideashare.RequestViewHolder.ClickListener mClickListener;
        public interface ClickListener{
            void onItemClick(View view, int position);
            void onItemLongClick(View view, int position);
        }

        public void setOnClickListener(com.example.rideashare.RequestViewHolder.ClickListener clickListener){
            mClickListener = clickListener;
        }
//    public interface OnNoteListener{
//        void onNoteCLick(int position);
//    }
    }


