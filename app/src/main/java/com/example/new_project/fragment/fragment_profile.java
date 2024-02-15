package com.example.new_project.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.new_project.DonationFormActivity;
import com.example.new_project.R;
import com.example.new_project.SliderAdapter;
import com.example.new_project.community;
import com.example.new_project.donate_meal;

import java.util.Arrays;
import java.util.List;


public class fragment_profile extends Fragment {


    private ViewPager2 viewPager;
    private SliderAdapter sliderAdapter;

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


        CardView donateMealCardview=layout.findViewById(R.id.donate_meal);
        donateMealCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), donate_meal.class );
                startActivity(intent);
            }
        });



        viewPager = layout.findViewById(R.id.viewpager);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        List<Integer> images = Arrays.asList(R.drawable.resturant3, R.drawable.resturantpic1, R.drawable.resturantpic2);
        sliderAdapter = new SliderAdapter(images);

        viewPager.setAdapter(sliderAdapter);






        return layout;
    }

  }