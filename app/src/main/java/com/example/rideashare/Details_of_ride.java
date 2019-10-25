package com.example.rideashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Details_of_ride extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_ride);

        SharedPreferences preferences = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String uName = preferences.getString("First Name", "");
        int uNumber = preferences.getInt("Phone Number", 0);
        String email = preferences.getString("username", "");

        TextView uNameTV = findViewById(R.id.Name);
        uNameTV.setText(uName);
        TextView uNumberTV = findViewById(R.id.ContactNUM);
        uNumberTV.setText(Integer.toString(uNumber));
        TextView emailTV = findViewById(R.id.Email);
        emailTV.setText(email);
    }

    public void close_fun(View v){
        Intent intent1= new Intent(this,Search_result.class);
        startActivity(intent1);
    }
}
