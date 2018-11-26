package com.example.admin.virtualdoctor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;


public class DoctorListAdapter extends RecyclerView.Adapter<com.example.admin.virtualdoctor.DoctorListAdapter.MyViewHolder> {

        Context context;
        ArrayList<String> strings;
        ArrayList<String> stringsCopy;
        ArrayList<String> results;

        public DoctorListAdapter(Context context1, ArrayList<String>strings1)
        {

            context=context1;
            strings=strings1;
            stringsCopy=strings1;
        }
        @Override
        public com.example.admin.virtualdoctor.DoctorListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new com.example.admin.virtualdoctor.DoctorListAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.special_list_show,parent,false));
        }

        @Override
        public void onBindViewHolder(com.example.admin.virtualdoctor.DoctorListAdapter.MyViewHolder holder, int position) {

            holder.btnSpcListName.setText(strings.get(position).toString());

        }
        @Override
        public int getItemCount() {
            return strings.size();
        }


    class MyViewHolder extends RecyclerView.ViewHolder {
            Button btnSpcListName;

            public MyViewHolder(View itemView) {
                super(itemView);

                btnSpcListName=itemView.findViewById(R.id.btnSpecialsName);
                btnSpcListName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(getLayoutPosition()==0){
                            Intent intent1 = new Intent(context, Anesthesiology.class);
                            context.startActivity(intent1);

                        }else if(getLayoutPosition()==1){
                            //Do whatever you want here

                        }else if(getLayoutPosition()==2){

                        }else if(getLayoutPosition()==3){

                        }else if(getLayoutPosition()==4){

                        }else if(getLayoutPosition()==5){

                        }
                    }
                });
            }
        }
    }

