package com.codepathjamesonf.jamstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {
    public static final String TAG="SignupActivity";


    private EditText etUsername;
    private EditText etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        Button btnSignup = findViewById(R.id.btnSignup);

        // here we want to sign up new user when button is pressed


        btnSignup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                SignupUser(username, password);
            }

        });
    }





    // Method for signup
    private void SignupUser(String username, String password) {
        Log.i(TAG, "attempt to Signup: " + username);

        // Create the ParseUser
        ParseUser user = new ParseUser();
// Set core properties
        user.setUsername(username);
        user.setPassword(password);
// Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignupActivity.this, "Yay! You are sucessfully signed up.", Toast.LENGTH_SHORT).show();

                    goMainActivity();
                    // Hooray! Let them use the app now.
                } else {
                    Log.e(TAG, "issue with login", e);
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });


    }
    private void goMainActivity() {
        Intent i = new Intent (this, MainActivity.class);
        startActivity(i);
        finish();
    }
    }
