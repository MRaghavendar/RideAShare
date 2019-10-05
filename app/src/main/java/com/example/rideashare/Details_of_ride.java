package com.example.rideashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Details_of_ride extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_ride);
    }

    public void close_fun(View v){
        Intent intent1= new Intent(this,Search_result.class);
        startActivity(intent1);
    }
}
