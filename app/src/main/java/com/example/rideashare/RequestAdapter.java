package com.example.rideashare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestViewHolder> {
    FirebaseFirestore ff;
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
//    public void deleteItem(int position){
//
//        ff.collection("Requested").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                for (DocumentSnapshot details: task.getResult()){
//                details.
//                }
//        })
//    }

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
