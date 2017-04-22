package com.example.bikramkoju.firebaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

public class Login extends AppCompatActivity {
    EditText username;
    EditText password;
    FirebaseAuth auth;

    Button login,signup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        auth=FirebaseAuth.getInstance();

        username=(EditText)findViewById(R.id.iemail);
        password=(EditText)findViewById(R.id.ipassword);

        login=(Button)findViewById(R.id.ilogin);
        signup=(Button)findViewById(R.id.isignup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=username.getText().toString();
                String pass=password.getText().toString();

                auth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Intent i = new Intent(Login.this,MainActivity.class);
                        startActivity(i);
                    }
                });

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,RegisterActivity.class);
                startActivity(i);

            }
        });



    }
}
