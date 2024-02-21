package com.example.new_project.fragment;


import static android.widget.Toast.makeText;
import static java.util.List.*;

import com.google.common.collect.Lists;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.new_project.BotReply;
import com.example.new_project.ChatAdapter;
import com.example.new_project.Message;
import com.example.new_project.R;

import com.example.new_project.SendMessageInBg;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.SessionsSettings;
import com.google.cloud.dialogflow.v2.TextInput;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.UUID;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class fragment_shineBot extends Fragment  {



    private static final String WEBSITE_URL = "https://shine-bot-website.vercel.app/";
    private WebView webView;


    View layout;
    Activity activity;

    public fragment_shineBot(Activity activity) {
        this.activity = activity;
    }

    public fragment_shineBot() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_shine_bot, container, false);


        webView = layout.findViewById(R.id.webview);
        Button chatbotButton = layout.findViewById(R.id.chatbot_button);

        chatbotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://shine-bot-website.vercel.app/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });






        return layout;
    }
}






