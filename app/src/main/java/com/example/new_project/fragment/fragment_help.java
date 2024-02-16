package com.example.new_project.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.new_project.R;



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

                dialPhoneNumber("234");
            }
        });


        reportEditText = layout.findViewById(R.id.editText);
        submitButton = layout.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String reportContent = reportEditText.getText().toString();
                        String recipient = "pradhanchandan136@gmail.com";
                        String subject = "Report from Your App";
                        JavaMailSender.sendEmail(recipient, subject, reportContent);
                    }
                }).start();
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
