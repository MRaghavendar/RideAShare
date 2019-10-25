package com.example.rideashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }

    public void signup(View v) {
        EditText firstnameET = findViewById(R.id.firstNameET);
        EditText lasttnameET = findViewById(R.id.lastNameET);
        EditText numberET = findViewById(R.id.contactET);
        EditText passwordET = findViewById(R.id.passwordET);
        EditText email = findViewById(R.id.emailET);
        SharedPreferences preferences = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String fName = firstnameET.getText().toString();
        String lName = lasttnameET.getText().toString();
        int num = Integer.parseInt(numberET.getText().toString());
        String newPass = passwordET.getText().toString();
        String newEmail = email.getText().toString();
        editor.putString("username", newEmail);
        editor.putString("password", newPass);
        editor.putString("First Name", fName);
        editor.putString("Last Name", lName);
        editor.putInt("Phone Number", num);
        editor.commit();
        Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}
