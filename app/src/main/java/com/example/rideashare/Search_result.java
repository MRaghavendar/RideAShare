package com.example.rideashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Search_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        SharedPreferences preferences = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String name = preferences.getString("First Name", "");
        String Spoint = preferences.getString("Starting Point", "");
        String Dpoint = preferences.getString("Destination", "");
        String price = preferences.getString("Cost", "");
        String t = preferences.getString("Timing", "");
        TextView userInfo = findViewById(R.id.nameTV);
        userInfo.setText(name);
        TextView SpointTV = findViewById(R.id.addTV);
        SpointTV.setText(Spoint + "->" + Dpoint + "   "+ "Price: "+ price + "   "+ t);
    }
    public void details(View v){
        Intent intent1= new Intent(this,Details_of_ride.class);
        startActivity(intent1);
    }
}
