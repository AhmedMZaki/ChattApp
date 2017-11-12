package com.example.ahmedassem.chattapp;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.text.format.DateUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class chat extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        ed=findViewById(R.id.txt);
        String Toolbartitle = getIntent().getStringExtra("user_name");
        toolbar = findViewById(R.id.chattoolbar);
        toolbar.setTitle(Toolbartitle);


        ArrayList<msg> list= new ArrayList<>();
        list.add(new msg(msg.TEXT_TYPE,"Hello. This is the Text-only View Type. Nice to meet you",0));
        list.add(new msg(msg.IMAGE_TYPE,"Hi. I display a cool image too besides the omnipresent TextView.",1));
        list.add(new msg(msg.TEXT_TYPE,"Hello. This is the Text-only View Type. Nice to meet you",0));
        list.add(new msg(msg.IMAGE_TYPE,"Hi. I display a cool image too besides the omnipresent TextView.",1));
        list.add(new msg(msg.TEXT_TYPE,"Hello. This is the Text-only View Type. Nice to meet you",0));
        list.add(new msg(msg.IMAGE_TYPE,"Hi. I display a cool image too besides the omnipresent TextView.",1));

        msgadpter adapter = new msgadpter(list,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView =  findViewById(R.id.list);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);



    }



}
