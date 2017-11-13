package com.example.ahmedassem.chattapp;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.ahmedassem.chattapp.Fragment.Contact;

public class chatcontent extends AppCompatActivity {
    private FrameLayout chatframe,groupchatframe,technicalframe,notfifcationframe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatcontent);
        chatframe=findViewById(R.id.chatframe);
        groupchatframe=findViewById(R.id.groupchatframe);
        technicalframe=findViewById(R.id.technicalframe);
        notfifcationframe=findViewById(R.id.notificationframe);
        chatframe.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {

            }
        });


    }

}
