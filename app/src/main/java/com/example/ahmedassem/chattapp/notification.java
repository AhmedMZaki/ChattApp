package com.example.ahmedassem.chattapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Assem on 11/6/2017.
 */

public class notification extends Fragment {
    private List<notificationitem> movieList = new ArrayList<notificationitem>();
    private RecyclerView recyclerView;
    private notifyadapter mAdapter;
    public notification() {
        // Required empty public constructor
    }


    private void prepareMovieData() {

        notificationitem movie = new notificationitem("Messi has scored a goal","11:00","Leo Messi");
        movieList.add(movie);

        movie = new notificationitem("Ronaldo Miss a penality","12:00","C.Ronaldo");
        movieList.add(movie);

        movie = new notificationitem("Inesta make an awesome assist","11:05","A.Inesta");
        movieList.add(movie);


        movie = new notificationitem("Stegen make a greate save ","14:05","Ter Stegen");
        movieList.add(movie);

        //mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notification, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerr);
        mAdapter = new notifyadapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
        return view;
    }
}
