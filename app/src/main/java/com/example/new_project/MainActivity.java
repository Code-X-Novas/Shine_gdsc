package com.example.new_project;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.new_project.fragment.fragment_help;
import com.example.new_project.fragment.fragment_learnt;
import com.example.new_project.fragment.fragment_map;
import com.example.new_project.fragment.fragment_profile;
import com.example.new_project.fragment.fragment_shineBot;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setBottom();
    }

    private void setBottom() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main,new fragment_help(MainActivity.this)).commit();


        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment=new fragment_help(MainActivity.this);
                int item_id = menuItem.getItemId();

                if (item_id == R.id.bottom_help) {
                     fragment=new fragment_help(MainActivity.this);

                } else if (item_id == R.id.bottom_map) {
                    fragment=new fragment_map(MainActivity.this);

                } else if (item_id == R.id.bottom_bot) {
                    fragment=new fragment_shineBot(MainActivity.this);

                } else if (item_id == R.id.bottom_learn) {
                    fragment=new fragment_learnt(MainActivity.this);

                } else if (item_id == R.id.bottom_profile) {
                    fragment=new fragment_profile(MainActivity.this);

                }

                return true;

            }
        });
        }
    }
















