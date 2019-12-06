package com.example.rideashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Post_A_Ride extends AppCompatActivity {
    EditText Starting_Point, Ending_Point, date_timeET, Cost, Seats_available, Location;
    Button Post_BTN;
    DatabaseReference reff;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__a__ride);

        mFirebaseAuth = FirebaseAuth.getInstance();
        Starting_Point =  findViewById(R.id.startingEdit);
        Ending_Point = findViewById(R.id.destinationEdit);
        date_timeET = (EditText) findViewById(R.id.dateEdit);
        Cost = (EditText) findViewById(R.id.costEdit);
        Seats_available = (EditText) findViewById(R.id.seatsEdit);
        Location = (EditText) findViewById(R.id.locationET);
        Post_BTN = findViewById(R.id.postBTN);
        Post_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Start = Starting_Point.getText().toString();
                String End = Ending_Point.getText().toString();
                String date_str = date_timeET.getText().toString();
                String Price = Cost.getText().toString();
                String Seats = Seats_available.getText().toString();
                String Place = Location.getText().toString();

                if (Start.isEmpty()) {
                    Starting_Point.setError("Please enter starting point");
                    Starting_Point.requestFocus();
                } else if (End.isEmpty()) {
                    Ending_Point.setError("Please enter ending point");
                    Ending_Point.requestFocus();
                }
                else if (date_str.isEmpty()) {
                    date_timeET.setError("Please enter date of the ride");
                    date_timeET.requestFocus();
                }
                    else if (Price.isEmpty()) {
                    Cost.setError("Please enter price of the ride");
                    Cost.requestFocus();
                } else if (Seats.isEmpty()) {
                    Seats_available.setError("Please enter first name");
                    Seats_available.requestFocus();
                } else if (Place.isEmpty()) {
                    Location.setError("Please enter Current Location");
                    Location.requestFocus();
                } else if (Start.isEmpty() && End.isEmpty()  && Price.isEmpty() && Seats.isEmpty() && Place.isEmpty()) {
                    Toast.makeText(Post_A_Ride.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(Start.isEmpty() && End.isEmpty()  && Price.isEmpty() && Seats.isEmpty() && Place.isEmpty())) {


                    String start = Starting_Point.getText().toString();
                    String end = Ending_Point.getText().toString();
                    String date_str1 = date_timeET.getText().toString();
                    String price = Cost.getText().toString();
                    String seats = Seats_available.getText().toString();
                    String place = Location.getText().toString();
                    String user_id = mFirebaseAuth.getCurrentUser().getUid();
                    reff = FirebaseDatabase.getInstance().getReference().child("details").child(user_id).child("post");


                    PostedRide Ride_Details = new PostedRide(start, end, date_str1, price, seats, place);
                    Starting_Point.setText("");
                    Ending_Point.setText("");
                    date_timeET.setText("");
                    Cost.setText("");
                    Seats_available.setText("");
                    Location.setText("");
                    reff.setValue(Ride_Details);

                    startActivity(new Intent(Post_A_Ride.this, WelcomePage.class));
                }

            }
        });
    }
}
