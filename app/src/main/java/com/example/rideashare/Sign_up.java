package com.example.rideashare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_up extends AppCompatActivity {
    EditText emailId, password, firstname, lastname, phonenum;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.emailET);
        password = findViewById(R.id.passwordET);
        firstname = findViewById(R.id.firstNameET);
        lastname = findViewById(R.id.lastNameET);
        phonenum = findViewById(R.id.contactET);
        btnSignUp = findViewById(R.id.signupSubmit);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                String fname = firstname.getText().toString();
                String lname = firstname.getText().toString();
                String number = firstname.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (fname.isEmpty()) {
                    firstname.setError("Please enter first name");
                    firstname.requestFocus();
                } else if (lname.isEmpty()) {
                    firstname.setError("Please enter first name");
                    firstname.requestFocus();
                } else if (number.isEmpty()) {
                    firstname.setError("Please enter first name");
                    firstname.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(Sign_up.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Sign_up.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Sign_up.this, "SignUp Unsuccessful, Please Try Again", Toast.LENGTH_SHORT).show();
                            } else {
                                String user_id = mFirebaseAuth.getCurrentUser().getUid();
                                String email = emailId.getText().toString();
                                String pwd = password.getText().toString();
                                String fname = firstname.getText().toString();
                                String lname = lastname.getText().toString();
                                String number = phonenum.getText().toString();
                                reff = FirebaseDatabase.getInstance().getReference().child("details").child(user_id);

//                               if(!(email.isEmpty() && pwd.isEmpty())){
//                                    String id = reff.push().getKey();
                                Details userdetails = new Details(fname, lname, number, email, pwd);
                                firstname.setText("");
                                lastname.setText("");
                                phonenum.setText("");
                                emailId.setText("");
                                password.setText("");
                                reff.setValue(userdetails);


                                startActivity(new Intent(Sign_up.this, MainActivity.class));
                            }
                        }
                    });
                }
            }
        });
    }

//    public void signup(View v) {
//        EditText firstnameET = findViewById(R.id.firstNameET);
//        EditText lasttnameET = findViewById(R.id.lastNameET);
//        EditText numberET = findViewById(R.id.contactET);
//        EditText passwordET = findViewById(R.id.passwordET);
//        EditText email = findViewById(R.id.emailET);
//        SharedPreferences preferences = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        String fName = firstnameET.getText().toString();
//        String lName = lasttnameET.getText().toString();
//        String num = numberET.getText().toString();
//        String newPass = passwordET.getText().toString();
//        String newEmail = email.getText().toString();
//        editor.putString("username", newEmail);
//        editor.putString("password", newPass);
//        editor.putString("First Name", fName);
//        editor.putString("Last Name", lName);
//        editor.putString("Phone Number", num);
//        editor.commit();
//        Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_SHORT).show();
//        Intent intent1 = new Intent(this, MainActivity.class);
//        startActivity(intent1);
//    }

//    public void user_details(){
//
//
//        }
}

