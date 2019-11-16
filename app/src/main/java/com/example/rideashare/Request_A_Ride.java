package com.example.rideashare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Request_A_Ride extends AppCompatActivity {
    EditText StartPoint, EndPoint, DateOfRide;
    Button Search_BTN;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request__a__ride);
        myRef = FirebaseDatabase.getInstance().getReference("message");
        StartPoint=(EditText)findViewById(R.id.startingEdit);
        EndPoint=(EditText)findViewById(R.id.destinationEdit);
        DateOfRide=(EditText)findViewById(R.id.dateET_req);

        Search_BTN=findViewById(R.id.searchBTN);
        Search_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTNSearch();
                Intent b1 = new Intent(Request_A_Ride.this, Search_result.class);
                Log.d("map", "started");
                startActivity(b1);
            }
        });



    }

    public void BTNSearch() {
        String Start=StartPoint.getText().toString();
        String End=EndPoint.getText().toString();
        String Date=DateOfRide.getText().toString();

        if(!TextUtils.isEmpty(Start) && !TextUtils.isEmpty(End) && !TextUtils.isEmpty(Date) ){
            String id=myRef.push().getKey();
            EditText_For_RequestARide p=new EditText_For_RequestARide(Start, End, Date, id);
            myRef.child(id).setValue(p);
            StartPoint.setText("");
            EndPoint.setText("");
            DateOfRide.setText("");

        }
        else {
                    Toast.makeText(Request_A_Ride.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
        }

    }
}




//
//        mFirebaseAuth = FirebaseAuth.getInstance();
//        StartPoint = findViewById(R.id.startingEdit);
//        EndPoint = findViewById(R.id.destinationEdit);
//        DateOfRide = findViewById(R.id.dateET_req);
//
//        Search_BTN = findViewById(R.id.searchBTN);
//
//        Search_BTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Start = StartPoint.getText().toString();
//                String End = EndPoint.getText().toString();
//                String Date = DateOfRide.getText().toString();
//                if(Start.isEmpty()){
//                    StartPoint.setError("Please enter a starting point");
//                    StartPoint.requestFocus();
//                }
//                else  if(End.isEmpty()){
//                    EndPoint.setError("Please enter a ending point");
//                    EndPoint.requestFocus();
//                }
//                else if(Date.isEmpty()){
//                    DateOfRide.setError("Please enter correct date format");
//                    DateOfRide.requestFocus();
//                }
//
//                else  if(!Start.isEmpty() && End.isEmpty() && Date.isEmpty()){
//                    Toast.makeText(Request_A_Ride.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
//                }
//
//                else{
//                    Toast.makeText(Request_A_Ride.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
