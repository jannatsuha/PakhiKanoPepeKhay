package com.example.admin.virtualdoctor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class DoctorListAdapter extends RecyclerView.Adapter<com.example.admin.virtualdoctor.DoctorListAdapter.MyViewHolder> {

        Context context;
        ArrayList<String> strings;

        public DoctorListAdapter(Context context1, ArrayList<String>strings1)
        {

            context=context1;
            strings=strings1;
        }
        @Override
        public DoctorListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new DoctorListAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.special_list_show,parent,false));
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

            }
        }


    }

