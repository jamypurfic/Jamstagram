//package com.codepathjamesonf.jamstagram;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.parse.ParseQuery;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FeedActivity extends AppCompatActivity {
//
//
//    public static final String TAG = "FeedActivity";
//    List<Post> allPost;
//    RecyclerView rvPost;
//    TextView tvUsername;
//    ImageView ivPost;
//    TextView tvCaption;
//    PostAdapter adapter = new PostAdapter(this, allPost);
//
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_feed);
//
//
//
//
//        tvUsername = findViewById(R.id.tvUsername);
//        ivPost = findViewById(R.id.ivPost);
//        tvCaption = findViewById(R.id.tvCaption);
//
//        rvPost = (RecyclerView) findViewById(R.id.rvPost);
//
//
////        // Find the toolbar view inside the activity layout
////        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        // Sets the Toolbar to act as the ActionBar for this Activity window.
////        // Make sure the toolbar exists in the activity and is not null
////        setSupportActionBar(toolbar);
//
//
//
//        allPost = new ArrayList<>();
//        //create adapter
//        PostAdapter adapter = new PostAdapter(this, allPost);
//
//        //set layout manager
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        rvPost.setLayoutManager(linearLayoutManager);
//
//        //set adapter
//       rvPost.setAdapter(adapter);
//
//
//
//    }
//
//
//}