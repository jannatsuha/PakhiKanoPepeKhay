package com.example.admin.virtualdoctor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<ChatModel>chatModels;

    public MyAdapter(Context context1, ArrayList<ChatModel>chatModels1)
    {

        context=context1;
        chatModels=chatModels1;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.model_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.myText.setText( chatModels.get(position).getChatMe());
        holder.botText.setText( chatModels.get(position).getChatBot());

    }

    @Override
    public int getItemCount() {
        return chatModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView botText,myText;

        public MyViewHolder(View itemView) {
            super(itemView);

            botText=itemView.findViewById(R.id.textByBot);
            myText=itemView.findViewById(R.id.textByMe);
        }
    }


}
