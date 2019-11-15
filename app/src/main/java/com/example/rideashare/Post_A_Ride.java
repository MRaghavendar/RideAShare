package com.example.rideashare;

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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Post_A_Ride extends AppCompatActivity {
    EditText Starting_Point, Ending_Point, Date, Cost, Seats_available, Location;
    Button Post_BTN;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__a__ride);
        myRef = FirebaseDatabase.getInstance().getReference("message");
        Starting_Point=(EditText)findViewById(R.id.startingEdit);
        Ending_Point=(EditText)findViewById(R.id.destinationEdit);
        Date=(EditText)findViewById(R.id.dateET_req);
        Cost=(EditText)findViewById(R.id.costEdit);
        Seats_available=(EditText)findViewById(R.id.seatsEdit);
        Location=(EditText)findViewById(R.id.locationET);

        Post_BTN=findViewById(R.id.postBTN);
        Post_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RouteBTN();
                Intent b1 = new Intent(Post_A_Ride.this, Details_of_ride.class);
                Log.d("map", "started");
                startActivity(b1);
            }
        });



    }

    public void RouteBTN() {
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








    }
//    public void backToHome(View v){
//        EditText startET = findViewById(R.id.startingEdit);
//        EditText DesET = findViewById(R.id.destinationEdit);
//        EditText seatsET = findViewById(R.id.seatsEdit);
//        EditText locET = findViewById(R.id.locationET);
//        String s = seatsET.getText().toString();
//        EditText timeET = findViewById(R.id.dateEdit);
//        EditText costET = findViewById(R.id.costEdit);
//        SharedPreferences preferences = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString("Starting Point",startET.getText().toString());
//        editor.putString("Destination",DesET.getText().toString());
//        editor.putString("Seats",s);
//        editor.putString("Timing",timeET.getText().toString());
//        editor.putString("Cost",costET.getText().toString());
//        editor.putString("Address", locET.getText().toString());
//        editor.commit();
//        Toast.makeText(getApplicationContext(), "Posted successful", Toast.LENGTH_SHORT).show();
//        Intent b1= new Intent(this,WelcomePage.class);
//        startActivity(b1);
//    }
}
