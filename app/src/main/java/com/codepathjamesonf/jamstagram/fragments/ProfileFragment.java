package com.codepathjamesonf.jamstagram.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.codepathjamesonf.jamstagram.LoginActivity;
import com.codepathjamesonf.jamstagram.R;
import com.parse.ParseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    private Button btnLogout;
    private TextView tvLogOut;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogout = view.findViewById(R.id.btnLogout);
        tvLogOut = view.findViewById(R.id.tvLogOut);

        // log out

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null

                goLoginActivity();



            }

        });





    }

    private void goLoginActivity() {
        Toast.makeText(getContext(), "You are now logged out. Please log in again.", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);


    }


}