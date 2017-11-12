package com.example.ahmedassem.chattapp;

/**
 * Created by Ahmed Assem on 11/6/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Assem on 11/6/2017.
 */

public class contact extends Fragment {
    private List<ChatUser> movieList = new ArrayList<ChatUser>();
    private RecyclerView recyclerView;
    private chatadapter mAdapter;
    String name="";
    Context context;
    public contact() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareMovieData();
    }


    private void prepareMovieData()
    {
        ChatUser movie = new ChatUser("AbdelSadek nady","Manager");
        movieList.add(movie);

        movie = new ChatUser("Mohammed Galal","UI Developer");
        movieList.add(movie);

        movie = new ChatUser("Mohammed Serag","Backend developer");
        movieList.add(movie);


        movie = new ChatUser("AbdelAziz Hassan","PHP Developer");
        movieList.add(movie);
    }

    private void recycleviewactionlistner()
    {
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        int pos=position;
                        Log.d("Position=", "value: " + pos);
                        ChatUser user=movieList.get(pos);
                        String username= user.getUsername();
                        Log.d("Name=",username);
                        Intent intent=new Intent(getActivity(),chat.class);
                        intent.putExtra("user_name", username);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mAdapter = new chatadapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
        recycleviewactionlistner();
        return view;

    }
}
