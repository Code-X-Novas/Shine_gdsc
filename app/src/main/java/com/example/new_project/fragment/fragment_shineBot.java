package com.example.new_project.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.new_project.R;

public class fragment_shineBot extends Fragment {
    View layout;
    Activity activity;
    public fragment_shineBot(Activity activity){
        this.activity=activity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout= inflater.inflate(R.layout.fragment_shine_bot, container, false);
        return layout;
    }

    }