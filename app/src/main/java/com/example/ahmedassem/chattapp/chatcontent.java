package com.example.ahmedassem.chattapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;



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
        groupchatframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(chatcontent.this,groupchat.class);
                startActivity(intent);
            }
        });
    }

}
