package com.example.new_project.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.new_project.PostAdapter;
import com.example.new_project.R;
import com.example.new_project.post;

import java.util.ArrayList;
import java.util.List;


public class fragment_home_community extends Fragment {

    private List<post> postList;
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;

    View layout;
    Activity activity;

    public fragment_home_community() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout= inflater.inflate(R.layout.fragment_home_community, container, false);

        postList = new ArrayList<>();
        recyclerView = layout.findViewById(R.id.recycler_view);
        postAdapter = new PostAdapter(postList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(postAdapter);



        return layout;
    }
}