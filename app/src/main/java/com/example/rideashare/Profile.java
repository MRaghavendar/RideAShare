package com.example.rideashare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Profile extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;
    DatabaseReference dr;
    EditText fnameET;
    EditText lnameET;
    EditText contact;
    EditText email;
    Button saveBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mFirebaseAuth = FirebaseAuth.getInstance();
        saveBTN = findViewById(R.id.save_profileBTN);
        fnameET = findViewById(R.id.fname_profileET);
        lnameET = findViewById(R.id.lname_profileET);
        contact = findViewById(R.id.contact_profileET);
        email = findViewById(R.id.email_profileET);
        String uid = mFirebaseAuth.getCurrentUser().getUid();
        dr = FirebaseDatabase.getInstance().getReference().child("details").child(uid);
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String fname = dataSnapshot.child("first_name").getValue().toString();
                String lname = dataSnapshot.child("last_name").getValue().toString();
                String number = dataSnapshot.child("phone_number").getValue().toString();
                String emailstr = dataSnapshot.child("email").getValue().toString();
                fnameET.setText(fname);
                lnameET.setText(lname);
                contact.setText(number);
                email.setText(emailstr);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                fnameET = findViewById(R.id.fname_profileET);
                lnameET = findViewById(R.id.lname_profileET);
                contact = findViewById(R.id.contact_profileET);
                email = findViewById(R.id.email_profileET);
                final String uid = mFirebaseAuth.getCurrentUser().getUid();
                dr = FirebaseDatabase.getInstance().getReference().child("details").child(uid);
                dr.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String firstname = fnameET.getText().toString();
                        String lastname = lnameET.getText().toString();
                        String phonenumber = contact.getText().toString();
                        String emailstr1 = email.getText().toString();
                        DataSnapshot nodeDataSnapshot = dataSnapshot.getChildren().iterator().next();
                        String key = nodeDataSnapshot.getKey(); // this key is `K1NRz9l5PU_0CFDtgXz`
                        String path = "/" + dataSnapshot.getKey() + "/" + uid;
                        HashMap<String, Object> result = new HashMap<>();
                        dr.child("first_name").setValue(firstname);
                        dr.child("last_name").setValue(lastname);
                        dr.child("phone_number").setValue(phonenumber);
                        dr.child("email").setValue(emailstr1);
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                        user.updateEmail(emailstr1)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Log.d("", "User email address updated.");
                                        }
                                    }
                                });
                        Toast.makeText(Profile.this, "Updated succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Profile.this, WelcomePage.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
    }
}
