package com.example.ahmedassem.chattapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.ahmedassem.chattapp.Contact;
import com.example.ahmedassem.chattapp.Notification;
import com.example.ahmedassem.chattapp.R;
import com.example.ahmedassem.chattapp.TechnicalSupport;
import com.example.ahmedassem.chattapp.groupchat;

/**
 * Created by Ahmed Assem on 11/20/2017.
 */

public class chatandgroups extends Fragment {

    private FrameLayout chatframe,groupchatframe,technicalframe,notfifcationframe;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.chatandgroups, container, false);
        setId();
        activitySwitcher();
        return view;
    }


    /* Add Id for each Frame */
    private void setId()
    {
        chatframe=view.findViewById(R.id.chatframe);
        groupchatframe=view.findViewById(R.id.groupchatframe);
        technicalframe=view.findViewById(R.id.technicalframe);
        notfifcationframe=view.findViewById(R.id.notificationframe);
    }


    private void activitySwitcher()
    {
        chatframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Contact.class);
                startActivity(intent);

            }
        });


        groupchatframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),groupchat.class);
                startActivity(intent);
            }
        });

        technicalframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TechnicalSupport.class);
                startActivity(intent);
            }
        });


        notfifcationframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Notification.class);
                startActivity(intent);
            }
        });
    }
}
