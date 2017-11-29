package com.example.ahmedassem.chattapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;


public class chatcontent extends AppCompatActivity {

    private FrameLayout chatframe,groupchatframe,technicalsupportframe,notificationframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatandgroups);
        setId();
        activitySwitcher();

    }

    private void setId()
    {
        chatframe=findViewById(R.id.chatframe);
        groupchatframe=findViewById(R.id.groupchatframe);
        technicalsupportframe=findViewById(R.id.technicalframe);
        notificationframe=findViewById(R.id.notificationframe);
    }

    private void activitySwitcher()
    {
        chatframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(chatcontent.this,Contact.class);
                startActivity(intent);
            }
        });


        groupchatframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(chatcontent.this,groupchat.class);
                startActivity(intent);
            }
        });



        technicalsupportframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(chatcontent.this,TechnicalSupport.class);
                startActivity(intent);
            }
        });


        notificationframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(chatcontent.this,Notification.class);
                startActivity(intent);
            }
        });
    }
}
