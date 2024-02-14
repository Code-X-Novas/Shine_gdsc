package com.example.new_project.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
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


    View layout;
    Activity activity;

    public fragment_home_community() {
        // Required empty public constructor
    }

     @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout= inflater.inflate(R.layout.fragment_home_community, container, false);

         RecyclerView recyclerView = layout.findViewById(R.id.recyclerViewComuunity);
         recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
         PostAdapter adapter = new PostAdapter(postList);
         recyclerView.setAdapter(adapter);








        return layout;
    }
}