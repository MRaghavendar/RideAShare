package com.example.rideashare;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class DisplayData extends AppCompatActivity {
    TextView userName;
//    TextView startPoint;
//    TextView endPoint;
//    TextView noOfSeata;
//    TextView cost;
//    DatabaseReference databaseReference;
    String username;
    String start;
    String post;
//    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_data);

        username = "";
        start = "";
        post = null;

        userName = findViewById(R.id.userName);

//        startPoint = findViewById(R.id.startPoint);
//        endPoint = findViewById(R.id.endPoint);
//        noOfSeata = findViewById(R.id.noOfSeata);
//        cost = findViewById(R.id.cost);
//        String user = firebaseAuth.getCurrentUser().getUid();
        //Get datasnapshot at your "users" root node
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("details");
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                        try {
                            collectPhoneNumbers((Map<String, Object>) dataSnapshot.getValue());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d("access the method", "hell");
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
    }

    private void collectPhoneNumbers(Map<String, Object> users) throws JSONException {

        String username = "";
        String start = "";
        String post = "";

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : users.entrySet()) {


            //Get user map
            Map singleUser = (Map) entry.getValue();

            username += "\nFirst Name " + singleUser.get("first_name");
            username += "\nLast Name " + singleUser.get("last_name");
            Map postMap = (Map) singleUser.get("post");
            username += "\nStarting Point: " + postMap.get("start");
            username += "\nEnding Point: " + postMap.get("end");
            username += "\nPlace: " + postMap.get("place");
            username += "\nCost: " + postMap.get("price");
            username += "\nNo of seats: " + postMap.get("seats")+"\n\n";

            userName.setText(username);

        }


    }

}

