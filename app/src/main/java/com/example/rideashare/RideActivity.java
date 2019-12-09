package com.example.rideashare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
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

public class RideActivity extends AppCompatActivity {
    List<RideModel> lm = new ArrayList<>();
    RecyclerView rv;
    RecyclerView.LayoutManager ml;
    FirebaseFirestore fs;
    RideAdapter ra;
    Button viewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        fs = FirebaseFirestore.getInstance();

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        ml = new LinearLayoutManager(this);
        rv.setLayoutManager(ml);


                retrieveData();

    }

    private void retrieveData() {
        fs.collection("Details").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                lm.clear();

                for (DocumentSnapshot details: task.getResult()){

                    RideModel rm = new RideModel(details.getString("id"), details.getString("name"), details.getString("startLoc"), details.getString("endLoc"), details.getString("dates"), details.getString("price"),details.getString("seats"),details.getString("number"));
                    lm.add(rm);

                }

                ra = new RideAdapter(RideActivity.this, lm);
                rv.setAdapter(ra);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(RideActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
