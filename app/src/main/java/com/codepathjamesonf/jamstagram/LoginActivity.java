package com.codepathjamesonf.jamstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG="LoginActivity";

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //if a user is already logged in, no need to go to log screen, go directly to main activity

        if (ParseUser.getCurrentUser() != null) {
            goMainActivity();
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        // here we want to log in new user when button is pressed
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Login button pressed");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username,password);
            }
        });

        // here we want to sign up new user when button is pressed
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                SignupUser(username,password);
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
// Method for login
    private void loginUser(String username, String password) {
        Log.i(TAG, "attempt to login: " + username);

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "issue with login", e);
                    return;
                }

                //if no error, we navigate to MainActivity
                goMainActivity();

            }
        });
    }

    private void goMainActivity() {
        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent (this, MainActivity.class);
        startActivity(i);
      finish();
    }
}