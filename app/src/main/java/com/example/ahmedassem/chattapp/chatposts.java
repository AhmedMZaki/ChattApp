package com.example.ahmedassem.chattapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ahmedassem.chattapp.Userdata.Post;
import com.example.ahmedassem.chattapp.Adapter.Postadapter;

import java.util.ArrayList;
import java.util.List;

public class chatposts extends AppCompatActivity {
    private List<Post> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Postadapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posts);
        intializerecyclerview();
    }

    private void intializerecyclerview()
    {

        recyclerView = (RecyclerView) findViewById(R.id.postslist);

        mAdapter = new Postadapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }


    private void prepareMovieData()
    {

        Post movie = new Post("Ahmed Assem ", "3 minutes", "Gooooooooal Messssssssi ♥");
        movieList.add(movie);

         movie = new Post("Ahmed Assem ", "3 minutes", "Gooooooooal Messssssssi ♥");
        movieList.add(movie);

        movie = new Post("Ahmed Assem ", "3 minutes", "Gooooooooal Messssssssi ♥");
        movieList.add(movie);

        movie = new Post("Ahmed Assem ", "3 minutes", "Gooooooooal Messssssssi ♥");
        movieList.add(movie);

         movie = new Post("Ahmed Assem ", "3 minutes", "Gooooooooal Messssssssi ♥");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();

    }
}
