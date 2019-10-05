package com.example.rideashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
    }
    public void PostRide(View v){
        Intent intent1 = new Intent(this,Post_A_Ride.class);
        startActivity(intent1);
    }
    public void ReqRide(View v){
        Intent intent2= new Intent(this,Request_A_Ride.class);
        startActivity(intent2);
    }
}
