package com.example.rideashare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Post_A_Ride extends AppCompatActivity {

    EditText passName, passStart, passEnd, passDate, passPrice, passSeats, passnumber;
    Button passSave;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__a__ride);
        passName =findViewById(R.id.nameET_Post);
        passStart = findViewById(R.id.startingEdit);
        passEnd = findViewById(R.id.destinationEdit);
        passDate = findViewById(R.id.dateEdit);
        passPrice = findViewById(R.id.costEdit);
        passSeats = findViewById(R.id.seatsEdit);
        passnumber = findViewById(R.id.locationET);
        passSave = findViewById(R.id.postBTN);

        db = FirebaseFirestore.getInstance();


        passSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = passName.getText().toString().trim();
                String startLoc = passStart.getText().toString().trim();
                String endLoc = passEnd.getText().toString().trim();
                String dates = passDate.getText().toString().trim();
                String price = passPrice.getText().toString().trim();
                String seats = passSeats.getText().toString().trim();
                String address = passnumber.getText().toString().trim();

                storeData(name, startLoc, endLoc, dates, price, seats, address);

            }
        });



    }


    private void storeData(String name, String startLoc, String endLoc, String dates, String price, String seats, String number) {
        String id = UUID.randomUUID().toString();
//        String id = fa.getInstance().getCurrentUser().getUid().toString();

        Map<String, Object> doc = new HashMap<>();
        doc.put("id",id);
        doc.put("name",name);
        doc.put("startLoc", startLoc);
        doc.put("endLoc", endLoc);
        doc.put("dates", dates);
        doc.put("price", price);
        doc.put("seats", seats);
        doc.put("number", number);

        db.collection("Details").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(Post_A_Ride.this,"Added..",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Post_A_Ride.this, WelcomePage.class));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(Post_A_Ride.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });

    }
}


//    EditText Starting_Point, Ending_Point, date_timeET, Cost, Seats_available, Location;
//    Button Post_BTN;
//    DatabaseReference reff;
//    FirebaseAuth mFirebaseAuth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_post__a__ride);
//
//        mFirebaseAuth = FirebaseAuth.getInstance();
//        Starting_Point =  findViewById(R.id.startingEdit);
//        Ending_Point = findViewById(R.id.destinationEdit);
//        date_timeET = (EditText) findViewById(R.id.dateEdit);
//        Cost = (EditText) findViewById(R.id.costEdit);
//        Seats_available = (EditText) findViewById(R.id.seatsEdit);
//        Location = (EditText) findViewById(R.id.locationET);
//        Post_BTN = findViewById(R.id.postBTN);
//        Post_BTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String Start = Starting_Point.getText().toString();
//                String End = Ending_Point.getText().toString();
//                String date_str = date_timeET.getText().toString();
//                String Price = Cost.getText().toString();
//                String Seats = Seats_available.getText().toString();
//                String Place = Location.getText().toString();
//
//                if (Start.isEmpty()) {
//                    Starting_Point.setError("Please enter starting point");
//                    Starting_Point.requestFocus();
//                } else if (End.isEmpty()) {
//                    Ending_Point.setError("Please enter ending point");
//                    Ending_Point.requestFocus();
//                }
//                else if (date_str.isEmpty()) {
//                    date_timeET.setError("Please enter date of the RideActivity");
//                    date_timeET.requestFocus();
//                }
//                    else if (Price.isEmpty()) {
//                    Cost.setError("Please enter price of the RideActivity");
//                    Cost.requestFocus();
//                } else if (Seats.isEmpty()) {
//                    Seats_available.setError("Please enter first name");
//                    Seats_available.requestFocus();
//                } else if (Place.isEmpty()) {
//                    Location.setError("Please enter Current Location");
//                    Location.requestFocus();
//                } else if (Start.isEmpty() && End.isEmpty()  && Price.isEmpty() && Seats.isEmpty() && Place.isEmpty()) {
//                    Toast.makeText(Post_A_Ride.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
//                } else if (!(Start.isEmpty() && End.isEmpty()  && Price.isEmpty() && Seats.isEmpty() && Place.isEmpty())) {
//
//
//                    String start = Starting_Point.getText().toString();
//                    String end = Ending_Point.getText().toString();
//                    String date_str1 = date_timeET.getText().toString();
//                    String price = Cost.getText().toString();
//                    String seats = Seats_available.getText().toString();
//                    String place = Location.getText().toString();
//                    String user_id = mFirebaseAuth.getCurrentUser().getUid();
//                    reff = FirebaseDatabase.getInstance().getReference().child("details").child(user_id).child("post");
//
//
//                    PostedRide Ride_Details = new PostedRide(start, end, date_str1, price, seats, place);
//                    Starting_Point.setText("");
//                    Ending_Point.setText("");
//                    date_timeET.setText("");
//                    Cost.setText("");
//                    Seats_available.setText("");
//                    Location.setText("");
//                    reff.setValue(Ride_Details);
//
//                    startActivity(new Intent(Post_A_Ride.this, WelcomePage.class));
//                }
//
//            }
//        });
//    }
//}
