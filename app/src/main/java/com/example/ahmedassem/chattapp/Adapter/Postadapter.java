package com.example.ahmedassem.chattapp.Adapter;

/**
 * Created by Ahmed Assem on 11/16/2017.
 */

import com.example.ahmedassem.chattapp.Userdata.Post;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import com.example.ahmedassem.chattapp.R;


public class Postadapter extends RecyclerView.Adapter<Postadapter.MyViewHolder> {

    private List<Post> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username,date,post;

        public MyViewHolder(View view) {
            super(view);
            username =  view.findViewById(R.id.postusername);
            date =  view.findViewById(R.id.postdate);
            post =  view.findViewById(R.id.postname);
        }
    }


    public Postadapter(List<Post> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.postitem, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Post movie = moviesList.get(position);
        holder.post.setText(movie.getPost());
        holder.date.setText(movie.getDate());
        holder.username.setText(movie.getUsername());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
