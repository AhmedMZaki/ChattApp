package com.example.ahmedassem.chattapp.Adapter;

/**
 * Created by Ahmed Assem on 11/12/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ahmedassem.chattapp.Userdata.Notificationitem;
import com.example.ahmedassem.chattapp.R;
import java.util.List;

public class Notificationadapter extends RecyclerView.Adapter<Notificationadapter.MyViewHolder> {

    private List<Notificationitem> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView content,date,name;

        public MyViewHolder(View view) {
            super(view);
            content = (TextView) view.findViewById(R.id.notifycontent);
            date=(TextView) view.findViewById(R.id.date);
            name=(TextView) view.findViewById(R.id.personname);
        }
    }


    public Notificationadapter(List<Notificationitem> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public Notificationadapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notificationitem, parent, false);

        return new Notificationadapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Notificationadapter.MyViewHolder holder, int position) {
        Notificationitem movie = moviesList.get(position);
        holder.content.setText(movie.getContent());
        holder.date.setText(movie.getDate());
        holder.name.setText(movie.getName());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}

