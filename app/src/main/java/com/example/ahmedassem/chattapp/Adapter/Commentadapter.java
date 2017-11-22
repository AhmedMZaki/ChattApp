package com.example.ahmedassem.chattapp.Adapter;

/**
 * Created by Ahmed Assem on 11/22/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ahmedassem.chattapp.R;
import com.example.ahmedassem.chattapp.Userdata.Comment;
import java.util.List;


public class Commentadapter extends RecyclerView.Adapter<Commentadapter.MyViewHolder> {

    private List<Comment> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,content,date;

        public MyViewHolder(View view) {
            super(view);
            name= view.findViewById(R.id.commentusername);
            content= view.findViewById(R.id.commentname);
            date=view.findViewById(R.id.commentdate);
        }
    }


    public Commentadapter(List<Comment> moviesList) {
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
        Comment movie = moviesList.get(position);
        holder.name.setText(movie.getName());
        holder.content.setText(movie.getContent());
        holder.date.setText(movie.getDate());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}

