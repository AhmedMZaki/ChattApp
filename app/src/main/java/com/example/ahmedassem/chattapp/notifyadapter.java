package com.example.ahmedassem.chattapp;

/**
 * Created by Ahmed Assem on 11/6/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class notifyadapter extends RecyclerView.Adapter<notifyadapter.MyViewHolder> {

    private List<notificationitem> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView content,date,name;

        public MyViewHolder(View view) {
            super(view);
            content = (TextView) view.findViewById(R.id.notifycontent);
            date=(TextView) view.findViewById(R.id.date);
            name=(TextView) view.findViewById(R.id.personname);
        }
    }


    public notifyadapter(List<notificationitem> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notificationitem, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        notificationitem movie = moviesList.get(position);
        holder.content.setText(movie.getContent());
        holder.date.setText(movie.getDate());
        holder.name.setText(movie.getName());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}


