package com.example.ahmedassem.chattapp;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmedassem.chattapp.Adapter.Groupchatadapter;
import com.example.ahmedassem.chattapp.Userdata.GroupChat;
import com.example.ahmedassem.chattapp.Design.MyDividerItemDecoration;
import java.util.ArrayList;
import java.util.List;

public class groupchat extends AppCompatActivity {
    private List<GroupChat> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Groupchatadapter mAdapter;
    private TextView newgroupchat;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groupchat);
        imageView=findViewById(R.id.newgroupchatimage);
        newgroupchat=findViewById(R.id.newgroupchat);
        recyclerView = findViewById(R.id.groupchatlist);
        mAdapter = new Groupchatadapter(movieList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 5));
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();


        newgroupchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLangDialog();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLangDialog();
            }
        });


    }

    private void prepareMovieData() {
        GroupChat movie = new GroupChat("Meesi");
        movieList.add(movie);

        movie = new GroupChat("Inesta");
        movieList.add(movie);

        movie = new GroupChat("Xavi");
        movieList.add(movie);

        movie = new GroupChat("Ronaldinho");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }


    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.newgroupchat, null);
        dialogBuilder.setView(dialogView);


        dialogBuilder.setTitle("New Group Chat");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();

            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }
}
