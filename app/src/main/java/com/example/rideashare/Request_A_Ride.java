package com.example.rideashare;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Request_A_Ride extends AppCompatActivity {


    EditText pName, passStart, passEnd, passDate, rphone;
    Button Request;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request__a__ride);
        pName =findViewById(R.id.nameET_req);
        passStart = findViewById(R.id.startET);
        passEnd = findViewById(R.id.destinationET);
        passDate = findViewById(R.id.dateET_req);
        rphone = findViewById(R.id.phoneET_req);
//        passSeats = findViewById(R.id.seatsEdit);
//        passAddress = findViewById(R.id.locationET);
        Request = findViewById(R.id.searchBTN);
//        passDetails = findViewById(R.id.detailsBtn);
        db = FirebaseFirestore.getInstance();

//        passDetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent in = new Intent(getApplicationContext(), RideActivity.class);
//                startActivity(in);
//
//            }
//        });
        Request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = pName.getText().toString().trim();
                String startLoc = passStart.getText().toString().trim();
                String endLoc = passEnd.getText().toString().trim();
                String dates = passDate.getText().toString().trim();
                String number = rphone.getText().toString().trim();
//                String seats = passSeats.getText().toString().trim();
//                String address = passAddress.getText().toString().trim();

                storeData(name, startLoc, endLoc, dates, number);

            }
        });



    }


    private void storeData(String name, String startLoc, String endLoc, String dates, String number) {
        String id = UUID.randomUUID().toString();
        Map<String, Object> doc = new HashMap<>();
        doc.put("id",id);
        doc.put("Name",name);
        doc.put("Start", startLoc);
        doc.put("Destination", endLoc);
        doc.put("Date", dates);
        doc.put("Number", number);
//        doc.put("seats", seats);
//        doc.put("address", address);

        db.collection("Requested").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(Request_A_Ride.this,"Added..",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(Request_A_Ride.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });

    }

}






//    EditText startPoint, endPoint;
//    Button search_BTN;
//    DatabaseReference reff;
//    FirebaseUser firebaseUser;
//    ArrayList<String> fullNameList;
//    ArrayList<String> userNameList;
//    ArrayList<String> firstnameList;
////    SearchAdapter searchAdapter;
//    RecyclerView recyclerView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_request__a__ride);
//        startPoint = (EditText) findViewById(R.id.startET);
//
//        endPoint = (EditText) findViewById(R.id.destinationET);
//        search_BTN = findViewById(R.id.searchBTN);
//        reff = FirebaseDatabase.getInstance().getReference().child("details").child("post");
//        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//
////        recyclerView.setHasFixedSize(true);
////        recyclerView.setLayoutManager(new LinearLayoutManager(this));
////        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//
//        fullNameList = new ArrayList<>();
//        userNameList = new ArrayList<>();
//        firstnameList = new ArrayList<>();
//
//        search_BTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                startActivity(new Intent(Request_A_Ride.this, Search_result.class));
////                final String start_text = startPoint.getText().toString();
////                final String end_text = endPoint.getText().toString();
////                if (!(start_text.isEmpty() && end_text.isEmpty())) {
//////                    startActivity(new Intent(Request_A_Ride.this, Search_result.class));
////                    reff.child("details").addListenerForSingleValueEvent(new ValueEventListener() {
////                        @Override
////                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                            fullNameList = new ArrayList<>();
////                            userNameList = new ArrayList<>();
////                            firstnameList = new ArrayList<>();
////                            fullNameList.clear();
////                            userNameList.clear();
////                            recyclerView.removeAllViews();
////                            /*
////                             * Search all users for matching searched string
////                             * */
////                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
////                                String uid = snapshot.getKey();
////                                String start_point = snapshot.child("start").getValue().toString();
////                                String end_point = snapshot.child("end").getValue().toString();
////                                String name = snapshot.child("first_name").getValue().toString();
////
////                                if (start_point.toLowerCase().equals(start_text.toLowerCase()) && end_point.toLowerCase().equals(end_text.toLowerCase())) {
////                                    fullNameList.add(start_point);
////                                    userNameList.add(end_point);
////                                    firstnameList.add(name);
////
////                                }
////
////
////                            }
////                            recyclerView.setAdapter(new SearchAdapter(Request_A_Ride.this, fullNameList, userNameList, firstnameList));
////
////                        }
////
////                        @Override
////                        public void onCancelled(@NonNull DatabaseError databaseError) {
////
////                        }
////
////
////                    });
////                }
////                else {
////                    fullNameList.add("abc");
////                    userNameList.add("def");
////                    firstnameList.add("ghij");
////                    searchAdapter = new SearchAdapter(Request_A_Ride.this, fullNameList, userNameList, firstnameList);
////                    Log.d("search ",": "+searchAdapter);
////                    recyclerView.setAdapter(searchAdapter);
////
////                }
//            }
//                                      });
//
//
//    }






//        myRef = FirebaseDatabase.getInstance().getReference("message");
//        StartPoint=(EditText)findViewById(R.id.startingEdit);
//        EndPoint=(EditText)findViewById(R.id.destinationEdit);
////        DateOfRide=(EditText)findViewById(R.id.dateET_req);
//
//        Search_BTN=findViewById(R.id.searchBTN);
//        Search_BTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                BTNSearch();
//                Intent b1 = new Intent(Request_A_Ride.this, Search_result.class);
//                Log.d("map", "started");
//                startActivity(b1);
//            }
//        });




//    public void BTNSearch() {
//        String Start=StartPoint.getText().toString();
//        String End=EndPoint.getText().toString();
////        String Date=DateOfRide.getText().toString();
//
//        if(!TextUtils.isEmpty(Start) && !TextUtils.isEmpty(End) && !TextUtils.isEmpty(Date) ){
//            String id=myRef.push().getKey();
//            EditText_For_RequestARide p=new EditText_For_RequestARide(Start, End, Date, id);
//            myRef.child(id).setValue(p);
//            StartPoint.setText("");
//            EndPoint.setText("");
////            DateOfRide.setText("");
//
//        }
//        else {
//                    Toast.makeText(Request_A_Ride.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
//        }
//
//    }






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
