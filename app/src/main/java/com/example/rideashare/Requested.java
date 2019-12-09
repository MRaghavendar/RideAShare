package com.example.rideashare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Requested extends AppCompatActivity  {

    List<RequestModel> lm = new ArrayList<>();
    RecyclerView rv;
    RecyclerView.LayoutManager ml;
    FirebaseFirestore fs;
    RequestAdapter ra;
    Button viewBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requested);

        fs = FirebaseFirestore.getInstance();

        rv = findViewById(R.id.recycle);
        rv.setHasFixedSize(true);
        ml = new LinearLayoutManager(this);
        rv.setLayoutManager(ml);


        retrieveData();

    }

    private void retrieveData() {
        fs.collection("Requested").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                lm.clear();

                for (DocumentSnapshot details: task.getResult()){

                    RequestModel rm = new RequestModel(details.getString("id"), details.getString("Name"), details.getString("Start"), details.getString("Destination"), details.getString("Date"), details.getString("Number"));
                    lm.add(rm);

                }

                ra = new RequestAdapter(Requested.this, lm );

                rv.setAdapter(ra);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(Requested.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

//    @Override
//    public void onNoteCLick(int position) {
//        lm.get(position);
//        Intent intent = new Intent(this, Details_of_ride.class);
//        startActivity(intent);
//    }
}
