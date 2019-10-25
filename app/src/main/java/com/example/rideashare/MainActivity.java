package com.example.rideashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void login_Fun(View V) {
//        EditText etName = findViewById(R.id.uNameET);
//        EditText etPassword = findViewById(R.id.pwdET);
//        SharedPreferences preferences = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
//        String user = preferences.getString("username", "");
//        String password = preferences.getString("password", "");
//        if (!user.equals("") && !password.equals("")) {
//            if (user.equalsIgnoreCase(etName.getText().toString()) && password.equalsIgnoreCase(etPassword.getText().toString())) {
                Intent intent1 = new Intent(MainActivity.this, WelcomePage.class);
                startActivity(intent1);
//            } else {
//                Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
//        }
    }

    public void Signup_fun(View v) {
        Intent intent1 = new Intent(this, Sign_up.class);
        startActivity(intent1);
    }

}