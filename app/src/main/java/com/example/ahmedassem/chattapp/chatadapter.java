package com.example.ahmedassem.chattapp;

/**
 * Created by Ahmed Assem on 11/6/2017.
 */

import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class chatadapter extends RecyclerView.Adapter<chatadapter.MyViewHolder> {

    private List<ChatUser> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username,userinfo;

        public MyViewHolder(View view) {
            super(view);
            username=(TextView) view.findViewById(R.id.contactname);
            userinfo=(TextView) view.findViewById(R.id.contacttype);
        }
    }


    public chatadapter(List<ChatUser> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contactitem, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ChatUser movie = moviesList.get(position);
        holder.username.setText(movie.getUsername());
        holder.userinfo.setText(movie.getUserinfo());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}

