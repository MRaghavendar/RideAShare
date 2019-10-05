package com.example.rideashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Post_A_Ride extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__a__ride);
    }
    public void backToHome(View v){
        Intent b1= new Intent(this,WelcomePage.class);
        startActivity(b1);
    }
}
