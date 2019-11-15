package com.example.rideashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Post_A_Ride extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__a__ride);
    }
//    public void backToHome(View v){
//        EditText startET = findViewById(R.id.startingEdit);
//        EditText DesET = findViewById(R.id.destinationEdit);
//        EditText seatsET = findViewById(R.id.seatsEdit);
//        EditText locET = findViewById(R.id.locationET);
//        String s = seatsET.getText().toString();
//        EditText timeET = findViewById(R.id.dateEdit);
//        EditText costET = findViewById(R.id.costEdit);
//        SharedPreferences preferences = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString("Starting Point",startET.getText().toString());
//        editor.putString("Destination",DesET.getText().toString());
//        editor.putString("Seats",s);
//        editor.putString("Timing",timeET.getText().toString());
//        editor.putString("Cost",costET.getText().toString());
//        editor.putString("Address", locET.getText().toString());
//        editor.commit();
//        Toast.makeText(getApplicationContext(), "Posted successful", Toast.LENGTH_SHORT).show();
//        Intent b1= new Intent(this,WelcomePage.class);
//        startActivity(b1);
//    }
}
