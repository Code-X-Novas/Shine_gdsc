package com.example.new_project;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.new_project.fragment.fragment_help;
import com.example.new_project.fragment.fragment_home_community;
import com.example.new_project.fragment.fragment_learnt;
import com.example.new_project.fragment.fragment_map;
import com.example.new_project.fragment.fragment_post_community;
import com.example.new_project.fragment.fragment_profile;
import com.example.new_project.fragment.fragment_profile_community;
import com.example.new_project.fragment.fragment_search_community;
import com.example.new_project.fragment.fragment_shineBot;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class community extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community);
        setBottom();
    }

    private void setBottom() {


        BottomNavigationView bottomNavigationView = findViewById(R.id.btm_navInsta);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int item_id = menuItem.getItemId();

                if (item_id == R.id.bottom_home_community) {
                    loadFrag(new fragment_home_community(), true);


                } else if (item_id == R.id.bottom_search_community) {
                    loadFrag(new fragment_search_community(), false);


                } else if (item_id == R.id.bottom_post_community) {
                    loadFrag(new fragment_post_community(), false);



                } else {
                    loadFrag(new fragment_profile_community(), false);


                }

                return true;

            }
        });
        bottomNavigationView.setSelectedItemId(R.id.bottom_home_community);


    }

    public void loadFrag(Fragment fragment, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag) {
            ft.add(R.id.main, fragment);
        } else {
            ft.replace(R.id.main, fragment);}
        ft.commit();
    }
}















