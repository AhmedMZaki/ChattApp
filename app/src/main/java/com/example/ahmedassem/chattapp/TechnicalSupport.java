package com.example.ahmedassem.chattapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.example.ahmedassem.chattapp.ActionListner.RecyclerItemClickListener;
import com.example.ahmedassem.chattapp.Adapter.TechnicalSupportadapter;
import com.example.ahmedassem.chattapp.Userdata.chatuser;
import java.util.ArrayList;
import java.util.List;

public class TechnicalSupport extends AppCompatActivity {
    private List<com.example.ahmedassem.chattapp.Userdata.TechnicalSupport> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TechnicalSupportadapter mAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical_support);

        intializerecyclerview();
    }

    private void intializerecyclerview() {
        recyclerView = (RecyclerView) findViewById(R.id.technicallist);
        mAdapter = new TechnicalSupportadapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
    }

    private void prepareMovieData() {
        com.example.ahmedassem.chattapp.Userdata.TechnicalSupport movie = new com.example.ahmedassem.chattapp.Userdata.TechnicalSupport("Technical Support");
        movieList.add(movie);
        mAdapter.notifyDataSetChanged();
        recycleviewactionlistner();
    }


    //action listner when user choose one friend to talk
    private void recycleviewactionlistner()
    {
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        Intent intent=new Intent(TechnicalSupport.this,Technical.class);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                }));}


}
