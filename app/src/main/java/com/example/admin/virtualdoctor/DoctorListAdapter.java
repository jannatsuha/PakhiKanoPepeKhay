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


public class DoctorListAdapter extends RecyclerView.Adapter<com.example.admin.virtualdoctor.DoctorListAdapter.MyViewHolder> implements Filterable {

        Context context;
        ArrayList<String> strings;
        ArrayList<String> stringsCopy;
        ArrayList<String> results;
        ArrayList<String> filterList;

        public DoctorListAdapter(Context context1, ArrayList<String>strings1)
        {

            context=context1;
            this.strings=strings1;
            stringsCopy=strings1;
            this.filterList=strings1;
        }
        @Override
        public com.example.admin.virtualdoctor.DoctorListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new com.example.admin.virtualdoctor.DoctorListAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.special_list_show,parent,false));
        }

        @Override
        public void onBindViewHolder(com.example.admin.virtualdoctor.DoctorListAdapter.MyViewHolder holder, int position) {

            holder.btnSpcListName.setText(filterList.get(position).toString());

        }
        @Override
        public int getItemCount() {
            return filterList.size();
        }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String quertString= charSequence.toString();
                if(quertString.isEmpty())
                    filterList=strings;
                else {
                    ArrayList<String> stringtemp= new ArrayList<>();
                    for(String s: strings){
                        if(s.toLowerCase().contains(quertString.toLowerCase())){
                            stringtemp.add(s);
                        }

                    }
                    filterList=stringtemp;
                }
                FilterResults filterResults= new FilterResults();
                filterResults.values=filterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterList= (ArrayList<String>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
            Button btnSpcListName;

            public MyViewHolder(View itemView) {
                super(itemView);

                btnSpcListName=itemView.findViewById(R.id.btnSpecialsName);
                btnSpcListName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(getLayoutPosition()==0)
                        {
                            Intent intent1 = new Intent(context, Anesthesiology.class);
                            context.startActivity(intent1);

                        }else if(getLayoutPosition()==1){
                            Intent i = new Intent(context,BurnAndSurgery.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==2){
                            Intent i = new Intent(context,BreastSurgeon.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==3){
                            Intent i = new Intent(context,Cardiology.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==4){
                            Intent i = new Intent(context,Cancer.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==5){
                            Intent i = new Intent(context,CardiovascularAndThoracicSurgeon.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==6){
                            Intent i = new Intent(context,Asthma.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==7){
                            Intent i = new Intent(context,PediatricCardiology.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==8){
                            Intent i = new Intent(context,Dental.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==9){
                            Intent i = new Intent(context,Dermatology.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==10){
                            Intent i = new Intent(context,Diabetes.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==11){
                            Intent i = new Intent(context,Eye.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==12){
                            Intent i = new Intent(context,ENT.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==13){
                            Intent i = new Intent(context,Gynaecology.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==14){
                            Intent i = new Intent(context,Gastrology.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==15){
                            Intent i = new Intent(context,Haematology.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==16){
                            Intent i = new Intent(context,Kidney.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==17){
                            Intent i = new Intent(context,Liver.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==18){
                            Intent i = new Intent(context,Medicine.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==19){
                            Intent i = new Intent(context,NeuroMedicine.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==20){
                            Intent i = new Intent(context,NeuroSurgeon.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==21){
                            Intent i = new Intent(context,Nutritionist.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==22){
                            Intent i = new Intent(context,Orthopaedics.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==23){
                            Intent i = new Intent(context,Psychologist.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==24){
                            Intent i = new Intent(context,Rheumatology.class);
                            context.startActivity(i);

                        }else if(getLayoutPosition()==25){
                            Intent i = new Intent(context,Urology.class);
                            context.startActivity(i);

                        }
                    }
                });
            }
        }
    }

