package com.example.rideashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login_Fun(View v){
        Intent intent1= new Intent(this,WelcomePage.class);
        startActivity(intent1);
    }
    public void Signup_fun(View v){
        Intent intent1= new Intent(this,Sign_up.class);
        startActivity(intent1);
    }
}
