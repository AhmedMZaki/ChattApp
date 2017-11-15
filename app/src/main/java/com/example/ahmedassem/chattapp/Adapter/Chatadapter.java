package com.example.ahmedassem.chattapp.Adapter;

/**
 * Created by Ahmed Assem on 11/12/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ahmedassem.chattapp.R;
import com.example.ahmedassem.chattapp.Userdata.chatuser;
import java.util.List;


public class Chatadapter extends RecyclerView.Adapter<Chatadapter.MyViewHolder> {

    private List<chatuser> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username,userinfo;

        public MyViewHolder(View view) {
            super(view);
            username=(TextView) view.findViewById(R.id.contactname);
            userinfo=(TextView) view.findViewById(R.id.contacttype);
        }
    }


    public Chatadapter(List<chatuser> moviesList) {
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
        chatuser movie = moviesList.get(position);
        holder.username.setText(movie.getUsername());
        holder.userinfo.setText(movie.getUserinfo());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}

