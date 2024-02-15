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
        scholarships.add(new Scholarship("Scheme For Residential Education For Students in High Schools in Targeted Areas (SHRESHTA)", "https://socialjustice.gov.in/schemes/41"));
        scholarships.add(new Scholarship("National Fellowship for OBC Students (NF-OBC)", "https://socialjustice.gov.in/schemes/7"));
        scholarships.add(new Scholarship("Pre- Matric Scholarships Scheme for Scheduled Castes & Others", "https://socialjustice.gov.in/schemes/23"));
        scholarships.add(new Scholarship("Post-Matric Scholarship for SC students", "https://socialjustice.gov.in/schemes/25"));
        scholarships.add(new Scholarship("Central Sector Scholarship of Top Class Education for SC Students", "https://socialjustice.gov.in/schemes/27"));
        scholarships.add(new Scholarship("SCHOLARSHIP FOR PM CARES CHILDREN", "https://socialjustice.gov.in/schemes/102"));
        scholarships.add(new Scholarship("Dr. Ambedkar Scheme of Interest Subsidy on Educational Loan for Overseas Studies for OBCs & EBCs", "https://socialjustice.gov.in/schemes/11"));
        scholarships.add(new Scholarship("Atal Vayo Abhyuday Yojana (AVYAY)", "https://socialjustice.gov.in/schemes/43"));
        scholarships.add(new Scholarship("Scheme of National Awards for Outstanding Services in the field of Prevention of Alcoholism and Substance (Drug) Abuse", "https://socialjustice.gov.in/schemes/90"));
        scholarships.add(new Scholarship("Credit Enhancement Guarantee Scheme for the Scheduled Castes (SCs)", "https://socialjustice.gov.in/schemes/32"));
        scholarships.add(new Scholarship("Scheme of Assistance to Scheduled Castes Development Corporations (SCDCs)", "https://socialjustice.gov.in/schemes/36"));
        return scholarships;
    }

    private void openNgoDarpanWebsite() {

        String url = "https://ngodarpan.gov.in/index.php/home/statewise_ngo/69/35/1";

        // Create an intent to open a web browser
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
