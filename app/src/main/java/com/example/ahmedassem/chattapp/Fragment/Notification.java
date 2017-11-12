package com.example.ahmedassem.chattapp.Fragment;

/**
 * Created by Ahmed Assem on 11/12/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.example.ahmedassem.chattapp.Design.DividerItemDecoration;
import android.view.ViewGroup;
import com.example.ahmedassem.chattapp.Userdata.Notificationitem;
import com.example.ahmedassem.chattapp.R;
import com.example.ahmedassem.chattapp.Adapter.Notificationadapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Assem on 11/6/2017.
 */

public class Notification extends Fragment {
    private List<Notificationitem> notificationitems = new ArrayList<Notificationitem>();
    private RecyclerView recyclerView;
    private Notificationadapter mAdapter;
    public Notification() {
        // Required empty public constructor
    }


    private void prepareMovieData() {

        Notificationitem items = new Notificationitem("Messi has scored a goal","11:00","Leo Messi");
        notificationitems.add(items);

        items = new Notificationitem("Ronaldo Miss a penality","12:00","C.Ronaldo");
        notificationitems.add(items);

        items = new Notificationitem("Inesta make an awesome assist","11:05","A.Inesta");
        notificationitems.add(items);


        items = new Notificationitem("Stegen make a greate save ","14:05","Ter Stegen");
        notificationitems.add(items);

        //mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notification, container, false);
        recyclerView =  view.findViewById(R.id.notificationlist);
        mAdapter = new Notificationadapter(notificationitems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
        return view;
    }
}

