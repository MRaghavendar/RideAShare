package com.example.rideashare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class WelcomePage extends AppCompatActivity {
        TextView tv;
        DatabaseReference reff;
        FirebaseAuth mFirebaseAuth;
        String user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        mFirebaseAuth = FirebaseAuth.getInstance();
        tv = findViewById(R.id.welcome_nameTV);
        user_id = mFirebaseAuth.getCurrentUser().getUid();
        reff = FirebaseDatabase.getInstance().getReference().child("details").child(user_id);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("first_name").getValue().toString();

                tv.setText(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void PostRide(View v){
        Intent intent1 = new Intent(this,Post_A_Ride.class);
        startActivity(intent1);
    }
    public void ReqRide(View v){
        Intent intent2= new Intent(this,Request_A_Ride.class);
        startActivity(intent2);
    }
    public void available(View v){
        Intent logout_intent = new Intent(this, RideActivity.class);
        startActivity(logout_intent);
    }
    public void logout_fun(View v){
        Intent logout_intent = new Intent(this,MainActivity.class);
        startActivity(logout_intent);
    }
    public void Requested(View v){
        Intent logout_intent = new Intent(this, Requested.class);
        startActivity(logout_intent);
    }
    public void Myrides_function(View v){
        Intent logout_intent = new Intent(this, Myrides.class);
        startActivity(logout_intent);
    }


}
