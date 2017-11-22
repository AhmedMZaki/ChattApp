package com.example.ahmedassem.chattapp;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.example.ahmedassem.chattapp.Fragment.Writeposts;
import com.example.ahmedassem.chattapp.Userdata.Post;
import com.example.ahmedassem.chattapp.Adapter.Postadapter;
import java.util.ArrayList;
import java.util.List;

public class chatposts extends Fragment {
    private List<Post> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Postadapter mAdapter;
    private FrameLayout writepost;
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.posts, container, false);

        setid();
        intializeRecyclerView();
        activitySwitcher();
        return view;
    }

    private void prepareMovieData()
    {
        Post movie = new Post("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);

         movie = new Post("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);

         movie = new Post("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);


        movie = new Post("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);


        movie = new Post("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);


        movie = new Post("Ahmed Assem", "3 mins", "Goooooooooooal Messsssssssssi ♥");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

    private void setid()
    {
        recyclerView = view.findViewById(R.id.postslist);
        writepost=view.findViewById(R.id.writepost);
    }

    private void intializeRecyclerView()
    {

        mAdapter = new Postadapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
    }

    private void activitySwitcher()
    {
        writepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new Writeposts();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.writepost, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
