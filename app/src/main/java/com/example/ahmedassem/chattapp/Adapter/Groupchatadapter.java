package com.example.ahmedassem.chattapp.Adapter;

/**
 * Created by Ahmed Assem on 11/14/2017.
 */

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ahmedassem.chattapp.Userdata.GroupChat;
import java.util.List;
import com.example.ahmedassem.chattapp.R;

public class Groupchatadapter extends RecyclerView.Adapter<Groupchatadapter.MyViewHolder> {

    private List<GroupChat> moviesList;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView groupchatname,menu;

        public MyViewHolder(View view) {
            super(view);
            groupchatname =view.findViewById(R.id.groupchatname);
            menu=view.findViewById(R.id.textViewOptions);
        }
    }


    public Groupchatadapter(List<GroupChat> moviesList,Context context) {
        this.context=context;
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.groupchatitem, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        GroupChat movie = moviesList.get(position);
        holder.groupchatname.setText(movie.getName());
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(context, holder.menu);
                //inflating menu from xml resource
                popup.inflate(R.menu.options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                //handle menu1 click
                                break;
                            case R.id.menu2:
                                //handle menu2 click
                                break;
                            case R.id.menu3:
                                //handle menu3 click
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
    }
    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
