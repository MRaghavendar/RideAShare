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

public class Post_A_Ride extends AppCompatActivity {
    EditText Starting_Point, Ending_Point, Date, Cost, Seats_available, Location;
    Button Post_BTN;
    DatabaseReference myRef;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__a__ride);

        Starting_Point = (EditText) findViewById(R.id.startingEdit);
        Ending_Point = (EditText) findViewById(R.id.destinationEdit);
        Date = (EditText) findViewById(R.id.dateET_req);
        Cost = (EditText) findViewById(R.id.costEdit);
        Seats_available = (EditText) findViewById(R.id.seatsEdit);
        Location = (EditText) findViewById(R.id.locationET);

        Post_BTN = findViewById(R.id.postBTN);
        Post_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Start = Starting_Point.getText().toString();
                String End = Ending_Point.getText().toString();
                String date = Date.getText().toString();
                String Price = Cost.getText().toString();
                String Seats = Seats_available.getText().toString();
                String Place = Location.getText().toString();

                if (Start.isEmpty()) {
                    Starting_Point.setError("Please enter starting point");
                    Starting_Point.requestFocus();
                } else if (End.isEmpty()) {
                    Ending_Point.setError("Please enter ending point");
                    Ending_Point.requestFocus();
                } else if (date.isEmpty()) {
                    Date.setError("Please enter date of the ride");
                    Date.requestFocus();
                } else if (Price.isEmpty()) {
                    Cost.setError("Please enter price of the ride");
                    Cost.requestFocus();
                } else if (Seats.isEmpty()) {
                    Seats_available.setError("Please enter first name");
                    Seats_available.requestFocus();
                } else if (Place.isEmpty()) {
                    Location.setError("Please enter Current Location");
                    Location.requestFocus();
                } else if (Start.isEmpty() && End.isEmpty() && date.isEmpty() && Price.isEmpty() && Seats.isEmpty() && Place.isEmpty()) {
                    Toast.makeText(Post_A_Ride.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(Start.isEmpty() && End.isEmpty() && date.isEmpty() && Price.isEmpty() && Seats.isEmpty() && Place.isEmpty())) {



                    String user_id = mFirebaseAuth.getCurrentUser().getUid();
                    String start = Starting_Point.getText().toString();
                    String end = Ending_Point.getText().toString();
                    String Date_time = Date.getText().toString();
                    String price = Cost.getText().toString();
                    String seats = Seats_available.getText().toString();
                    String place = Location.getText().toString();
                    myRef = FirebaseDatabase.getInstance().getReference().child("message");

                    EditText_For_PostARide Ride_Details = new EditText_For_PostARide(start, end, Date_time, price, seats, place);
                    Starting_Point.setText("");
                    Ending_Point.setText("");
                    Date.setText("");
                    Cost.setText("");
                    Seats_available.setText("");
                    Location.setText("");
                    myRef.child("message").setValue(Ride_Details);

                    startActivity(new Intent(Post_A_Ride.this, WelcomePage.class));
                }

            }
        });
    }
}
