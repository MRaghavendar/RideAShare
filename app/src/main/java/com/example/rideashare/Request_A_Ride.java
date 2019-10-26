package com.example.rideashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Request_A_Ride extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request__a__ride);
    }

    public void Search_fun(View v){
        EditText fromET = findViewById(R.id.startET);
        EditText toET = findViewById(R.id.destinationET);
        EditText timET = findViewById(R.id.dateET_req);
        SharedPreferences preferences = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Start", fromET.getText().toString());
        editor.putString("Des", toET.getText().toString());
        editor.putString("time", timET.getText().toString());
        editor.commit();
        Intent intent1= new Intent(this,Search_result.class);
        startActivity(intent1);
    }
}
