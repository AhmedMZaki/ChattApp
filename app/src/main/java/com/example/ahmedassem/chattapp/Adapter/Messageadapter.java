package com.example.ahmedassem.chattapp.Adapter;

/**
 * Created by Ahmed Assem on 11/12/2017.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ahmedassem.chattapp.R;
import com.example.ahmedassem.chattapp.Userdata.Message;
import java.util.ArrayList;


/**
 * Created by anupamchugh on 09/02/16.
 */
public class Messageadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Message> dataSet;
    Context mContext;
    int total_types;

    public static class chatrcv extends RecyclerView.ViewHolder {

        TextView txtType;

        public chatrcv(View itemView) {
            super(itemView);
            this.txtType =  itemView.findViewById(R.id.messagercv);
        }
    }

    public static class chatsend extends RecyclerView.ViewHolder {
        TextView txtType;
        public chatsend(View itemView) {
            super(itemView);

            this.txtType =  itemView.findViewById(R.id.messagesent);
        }
    }

    public Messageadapter(ArrayList<Message> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case Message.TEXT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_sent, parent, false);
                return new Messageadapter.chatsend(view);
            case Message.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_rcv, parent, false);
                return new Messageadapter.chatrcv(view);
        }
        return null;


    }


    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type) {
            case 0:
                return Message.TEXT_TYPE;
            case 1:
                return Message.IMAGE_TYPE;
            default:
                return -1;
        }


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        Message object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case Message.TEXT_TYPE:
                    ((chatsend) holder).txtType.setText(object.message);
                    break;
                case Message.IMAGE_TYPE:
                    ((chatrcv) holder).txtType.setText(object.message);
                    break;
            }
        }
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}
