package com.example.new_project.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.new_project.R;
import com.example.new_project.Scholarship;
import com.example.new_project.ScholarshipAdapter;

import java.util.ArrayList;
import java.util.List;


public class fragment_learnt extends Fragment {
    private RecyclerView recyclerView;
    private ScholarshipAdapter adapter;
    View layout;
    Activity activity;
    public fragment_learnt(Activity activity){
        this.activity=activity;
    }

    public fragment_learnt() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout= inflater.inflate(R.layout.fragment_learnt, container, false);

        TextView headingTextView = layout.findViewById(R.id.text_heading);
        headingTextView.setText("Scholarships and NGO Schemes");

        recyclerView = layout.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Assuming you have a list of scholarships or NGO schemes
        List<Scholarship> scholarships = getScholarship();

        adapter = new ScholarshipAdapter(scholarships);
        recyclerView.setAdapter(adapter);

        Button ngoDarpanButton = layout.findViewById(R.id.button_ngo_darpan);
        ngoDarpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open NGO Darpan website in a browser
                openNgoDarpanWebsite();
            }
        });


        return layout;
    }

    private List<Scholarship> getScholarship() {
        List<Scholarship> scholarships = new ArrayList<>();
        // Add dummy data for demonstration
        scholarships.add(new Scholarship("Scholarship 1", "Description 1"));
        scholarships.add(new Scholarship("Scholarship 2", "Description 2"));
        scholarships.add(new Scholarship("Scholarship 3", "Description 3"));
        scholarships.add(new Scholarship("Scholarship 4", "Description 4"));
        scholarships.add(new Scholarship("Scholarship 5", "Description 5"));
        scholarships.add(new Scholarship("Scholarship 6", "Description 6"));
        scholarships.add(new Scholarship("Scholarship 7", "Description 7"));
        scholarships.add(new Scholarship("Scholarship 8", "Description 8"));
        scholarships.add(new Scholarship("Scholarship 9", "Description 9"));
        scholarships.add(new Scholarship("Scholarship 10", "Description 10"));
        scholarships.add(new Scholarship("Scholarship 11", "Description 11"));
        return scholarships;
    }

    private void openNgoDarpanWebsite() {

        String url = "https://ngodarpan.gov.in/index.php/home/statewise_ngo/69/35/1";

        // Create an intent to open a web browser
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
