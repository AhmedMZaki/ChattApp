package com.example.ahmedassem.chattapp.Adapter;

/**
 * Created by Ahmed Assem on 11/16/2017.
 */

import com.example.ahmedassem.chattapp.Userdata.Post;
import com.example.ahmedassem.chattapp.Fragment.Comments;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.example.ahmedassem.chattapp.chatposts;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import com.example.ahmedassem.chattapp.R;

import static android.app.PendingIntent.getActivity;

public class Postadapter extends RecyclerView.Adapter<Postadapter.MyViewHolder> {

    private List<Post> moviesList;
    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username,date,post,liketextview,commenttextview;
        public ImageView like,comment;

        public MyViewHolder(View view) {
            super(view);
            username =  view.findViewById(R.id.postusername);
            date =  view.findViewById(R.id.postdate);
            post =  view.findViewById(R.id.postname);
            like=view.findViewById(R.id.likeimage);
            commenttextview=view.findViewById(R.id.commenttextview);
            comment=view.findViewById(R.id.commentimage);
            liketextview=view.findViewById(R.id.liketext);
            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if(like.getDrawable().getConstantState() == like.getResources().getDrawable( R.drawable.like).getConstantState())
                   {
                       like.setImageResource(R.drawable.bluelike);
                   }
                   else
                   {
                       like.setImageResource(R.drawable.like);
                   }
                }
            });

            liketextview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(like.getDrawable().getConstantState() == like.getResources().getDrawable( R.drawable.like).getConstantState())
                    {
                        like.setImageResource(R.drawable.bluelike);
                    }
                    else
                    {
                        like.setImageResource(R.drawable.like);
                    }
                }
            });

            comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
/*
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    android.support.v4.app.Fragment myFragment = new Comments();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.comments, myFragment).addToBackStack(null).commit();*/
/*                    android.support.v4.app.Fragment myFragment = new Comments();
                    FragmentTransaction transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.writepost, myFragment);
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    transaction.addToBackStack(null);
                    transaction.commit();*/
/*                    Fragment fragment = new Comments();
                    Bundle args = new Bundle();
                    args.putString("data", "This data has sent to FragmentTwo");
                    fragment.setArguments(args);
                    FragmentTransaction transaction =fragment.getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.writepost, fragment);
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    transaction.addToBackStack(null);
                    transaction.commit();*/

                }
            });
        }
    }


    public Postadapter(List<Post> moviesList,Context context) {
        this.moviesList = moviesList;
        this.context=context;
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
