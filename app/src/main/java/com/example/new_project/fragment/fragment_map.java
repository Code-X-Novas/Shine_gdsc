package com.example.new_project.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.new_project.BuildConfig;
import com.example.new_project.R;



public class fragment_map extends Fragment {

    View layout;
    Activity activity;
    public fragment_map(Activity activity){
        this.activity=activity;
    }

    public fragment_map() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        layout= inflater.inflate(R.layout.fragment_map, container, false);




        return layout;
    }

}