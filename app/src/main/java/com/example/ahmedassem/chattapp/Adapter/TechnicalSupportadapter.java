package com.example.ahmedassem.chattapp.Adapter;

/**
 * Created by Ahmed Assem on 11/15/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import com.example.ahmedassem.chattapp.R;
import com.example.ahmedassem.chattapp.Userdata.TechnicalSupport;


public class TechnicalSupportadapter extends RecyclerView.Adapter<TechnicalSupportadapter.MyViewHolder> {

    private List<TechnicalSupport> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView technicalsupportname;

        public MyViewHolder(View view) {
            super(view);
            technicalsupportname =  view.findViewById(R.id.technicalsupportname);
        }
    }


    public TechnicalSupportadapter(List<TechnicalSupport> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.technicalsupportitem, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TechnicalSupport movie = moviesList.get(position);
        holder.technicalsupportname.setText(movie.getName());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
