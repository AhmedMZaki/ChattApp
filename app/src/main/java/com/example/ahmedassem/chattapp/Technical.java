package com.example.ahmedassem.chattapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.example.ahmedassem.chattapp.Adapter.Messageadapter;
import com.example.ahmedassem.chattapp.Userdata.Message;

import java.util.ArrayList;

public class Technical extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
         /* get toolbar name from contact list */
        toolbar = findViewById(R.id.chattoolbar);
        /* set toolbar name */
        toolbar.setTitle("TechnicalSupport");


        ArrayList<Message> list= new ArrayList<>();
        list.add(new Message(Message.TEXT_TYPE,"Hello. This is the Text-only View Type. Nice to meet you",0));
        list.add(new Message(Message.IMAGE_TYPE,"Hi. I display a cool image too besides the omnipresent TextView.",1));
        list.add(new Message(Message.TEXT_TYPE,"Hello. This is the Text-only View Type. Nice to meet you",0));
        list.add(new Message(Message.IMAGE_TYPE,"Hi. I display a cool image too besides the omnipresent TextView.",1));
        list.add(new Message(Message.TEXT_TYPE,"Hello. This is the Text-only View Type. Nice to meet you",0));
        list.add(new Message(Message.IMAGE_TYPE,"Hi. I display a cool image too besides the omnipresent TextView.",1));

        /* Show Message */
        Messageadapter adapter = new Messageadapter(list,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        RecyclerView mRecyclerView =  findViewById(R.id.messagelist);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }
}
