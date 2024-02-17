package com.example.new_project.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.new_project.DonationFormActivity;

import com.example.new_project.R;
import com.example.new_project.SliderAdapter;
import com.example.new_project.community;
import com.example.new_project.donate_book;
import com.example.new_project.donate_clothes;
import com.example.new_project.donate_meal;

import java.util.Arrays;
import java.util.List;


public class fragment_profile extends Fragment {




    private ViewPager2 viewPager;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private static final int REQUEST_LOCATION_PERMISSION = 123; // Use any unique value here





    private SliderAdapter sliderAdapter;
    private Handler sliderHandler = new Handler();
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    };





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

        CardView donatebookCardview=layout.findViewById(R.id.donate_book);
        donatebookCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), donate_book.class);
                startActivity(intent);
            }
        });


        CardView donateclothesCardview=layout.findViewById(R.id.donate_clothes);
        donateclothesCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), donate_clothes.class);
                startActivity(intent);
            }
        });










            viewPager = layout.findViewById(R.id.viewpager);
            viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

            List<Integer> images = Arrays.asList(R.drawable.resturant3, R.drawable.resturantpic1, R.drawable.resturantpic2);
            sliderAdapter = new SliderAdapter(images);

            viewPager.setAdapter(sliderAdapter);


            startSliderAutoScroll();

        CardView cameraCardView = layout.findViewById(R.id.upload_pic_button);
        cameraCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                launchGoogleMaps(location.getLatitude(), location.getLongitude());
            }

        };






            return layout;
    }

    private void launchGoogleMaps(double latitude, double longitude) {
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=NGOs");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }


    private void startSliderAutoScroll() {
            sliderHandler.postDelayed(sliderRunnable, 3000); // Delay in milliseconds (adjust as needed)
        }

        private void stopSliderAutoScroll() {
            sliderHandler.removeCallbacks(sliderRunnable);
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();

            stopSliderAutoScroll();
        }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {

            if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, locationListener, null);
            } else {

                ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);

            }
        }

    }}


