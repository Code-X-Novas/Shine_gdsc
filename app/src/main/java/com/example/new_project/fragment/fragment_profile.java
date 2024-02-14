package com.example.new_project.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.new_project.DonationFormActivity;
import com.example.new_project.R;
import com.example.new_project.community;


public class fragment_profile extends Fragment {
    View layout;
    Activity activity;
    public fragment_profile(Activity activity){
        this.activity=activity;
    }

    public fragment_profile() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout= inflater.inflate(R.layout.fragment_profile, container, false);
        CardView donateMoneyCardView = layout.findViewById(R.id.donate_money);
        donateMoneyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the donation form activity
                Intent intent = new Intent(getActivity(), DonationFormActivity.class);
                startActivity(intent);
            }
        });
        CardView CommunityCradView= layout.findViewById(R.id.community);
        CommunityCradView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), community.class);
                startActivity(intent);
            }
        });




        return layout;
    }

  }