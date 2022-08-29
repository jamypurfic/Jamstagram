package com.codepathjamesonf.jamstagram.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepathjamesonf.jamstagram.Post;
import com.codepathjamesonf.jamstagram.PostAdapter;
import com.codepathjamesonf.jamstagram.R;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class PostFragment extends Fragment {
    public static final String TAG = "PostFragment";

    List<Post> allPost;
    TextView tvUsername;
    ImageView ivPost;
    TextView tvCaption;
    PostAdapter adapter = new PostAdapter(getContext(), allPost);
    private RecyclerView rvPost;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPost = view.findViewById(R.id.rvPost);
//
//        //steps for the rv
//        // 0. layout  for one row
//        1. create adapter
//       2. data source
//       3 set adapter on rv
//      4 set layout manager on rv

        allPost = new ArrayList<>();
        //create adapter
        PostAdapter adapter = new PostAdapter(getContext(), allPost);

        //set layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvPost.setLayoutManager(linearLayoutManager);

        //set adapter
        rvPost.setAdapter(adapter);



        getPost();
    }




    private void getPost() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.include(Post.KEY_CREATED_AT);
        query.findInBackground((posts, e) -> {
            if (e != null) {
                Log.e(TAG, "issue with getting posts", e);
                return;
            }
            for (Post post: posts) {
                Log.i(TAG, "Post: " + post.getDescription());
            }
            allPost.addAll(posts);
            adapter.notifyDataSetChanged();




        });


    }

}