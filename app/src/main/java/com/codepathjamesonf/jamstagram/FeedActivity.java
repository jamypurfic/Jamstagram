package com.codepathjamesonf.jamstagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class FeedActivity extends AppCompatActivity {


    ImageView ivProfile;
    TextView tvUsername;
    ImageView ivPost;
    TextView tvDescription;
    ImageButton ibPhoto;
    ImageButton ibMessage;
    ImageButton ibHome;
    ImageButton ibAdd;
    ImageButton ibProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);


        ivProfile = findViewById(R.id.ivProfile);
        tvUsername = findViewById(R.id.tvUsername);
        ivPost = findViewById(R.id.ivPost);
        tvDescription = findViewById(R.id.tvCaption);
        ibPhoto = findViewById(R.id.ibPhoto);
        ibMessage = findViewById(R.id.ibMessage);
        ibHome = findViewById(R.id.ibHome);
        ibAdd = findViewById(R.id.ibAdd);
        ibProfile = findViewById(R.id.ibProfile);
    }


}