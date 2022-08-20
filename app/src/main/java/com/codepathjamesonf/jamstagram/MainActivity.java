package com.codepathjamesonf.jamstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private ImageView ivProfileImage;
    private EditText etDescription;
    private Button btnCaptureImage;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivProfileImage = findViewById(R.id.ivPostImage);
        etDescription = findViewById(R.id.etDescription);
        btnCaptureImage = findViewById(R.id.btnCaptureImage);
        btnSubmit = findViewById(R.id.btnSubmit);


        // method to query posts
        QueryPost();


    }

    private void QueryPost() {

        // Specify which class to query
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "unbale to find posts");
                }
                for (Post post: posts) {
                    Log.i(TAG, "Post:" + post.getDescription() + ", username: " + post.getUser().getUsername());

                }

            }
        });
    }
}