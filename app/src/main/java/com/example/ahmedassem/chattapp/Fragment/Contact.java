package com.example.ahmedassem.chattapp.Fragment;

/**
 * Created by Ahmed Assem on 11/12/2017.
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
import com.example.ahmedassem.chattapp.Userdata.chatuser;
import com.example.ahmedassem.chattapp.R;
import com.example.ahmedassem.chattapp.chat;
import com.example.ahmedassem.chattapp.Adapter.Chatadapter;
import java.util.ArrayList;
import java.util.List;
import com.example.ahmedassem.chattapp.Design.DividerItemDecoration;
import com.example.ahmedassem.chattapp.ActionListner.RecyclerItemClickListener;

/**
 * Created by Ahmed Assem on 11/6/2017.
 */

public class Contact extends Fragment {
    private List<chatuser> chatusers = new ArrayList<chatuser>();
    private RecyclerView recyclerView;
    private Chatadapter mAdapter;
    Context context;
    public Contact() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareMovieData();
    }


    /* Add Contact itens Manually */
    private void prepareMovieData()
    {
        chatuser movie = new chatuser("AbdelSadek nady","Manager");
        chatusers.add(movie);

        movie = new chatuser("Mohammed Galal","UI Developer");
        chatusers.add(movie);

        movie = new chatuser("Mohammed Serag","Backend developer");
        chatusers.add(movie);


        movie = new chatuser("AbdelAziz Hassan","PHP Developer");
        chatusers.add(movie);
    }

    private void recycleviewactionlistner()
    {
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        int pos=position;
                        Log.d("Position=", "value: " + pos);
                        chatuser user=chatusers.get(pos);
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
        recyclerView =  view.findViewById(R.id.contactlist);
        mAdapter = new Chatadapter(chatusers);
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

