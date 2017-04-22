package com.example.bikramkoju.firebaseexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Bikramkoju on 4/6/2017.
 */

public class RegisterActivity extends AppCompatActivity {
    EditText username,password;
    Button signup;
    FirebaseAuth auth;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        //initializing firebaseauth
        auth=FirebaseAuth.getInstance();

        username=(EditText)findViewById(R.id.uemail);
        password=(EditText)findViewById(R.id.upassword);

        signup=(Button)findViewById(R.id.usignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Intent i =new Intent(RegisterActivity.this,Login.class);
                        startActivity(i);
                    }
                });

            }
        });
    }
}
