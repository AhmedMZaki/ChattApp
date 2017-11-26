package com.example.ahmedassem.chattapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.ahmedassem.chattapp.Adapter.Commentadapter;
import com.example.ahmedassem.chattapp.Adapter.Postadapter;
import com.example.ahmedassem.chattapp.R;
import com.example.ahmedassem.chattapp.Userdata.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Assem on 11/22/2017.
 */

public class Comments extends Fragment {
    private List<Comment> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Commentadapter mAdapter;
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.comments, container, false);
        setid();
        intializeRecyclerView();
        return view;
    }


    private void prepareMovieData()
    {
        Comment movie = new Comment("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);

        movie = new Comment("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);

        movie = new Comment("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);


        movie = new Comment("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);


        movie = new Comment("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);


        movie = new Comment("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

    private void setid()
    {
        recyclerView = view.findViewById(R.id.postslist);
    }

    private void intializeRecyclerView()
    {
        mAdapter = new Commentadapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
    }
}
