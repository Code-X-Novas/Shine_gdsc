package com.example.new_project.fragment;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaCas;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Message;
import android.se.omapi.Session;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.new_project.R;

import java.net.Authenticator;
import java.util.Properties;





public class fragment_help extends Fragment {
    private Button callButton;
    private Button submitButton;
    private EditText reportEditText;

    public fragment_help() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_help, container, false);

        callButton = layout.findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace "911" with the actual phone number of child care services
                dialPhoneNumber("234");
            }
        });

        return layout;
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }


}
