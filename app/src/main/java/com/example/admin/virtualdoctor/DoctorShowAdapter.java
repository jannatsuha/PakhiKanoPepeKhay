package com.example.admin.virtualdoctor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class DoctorShowAdapter extends RecyclerView.Adapter<DoctorShowAdapter.MyViewHolder>implements Filterable{

    Context context;
    private ArrayList<DoctorModel> doctorModels;
   private ArrayList<DoctorModel> filterListDoctorModel;


    public DoctorShowAdapter(Context context1, ArrayList<DoctorModel>doctorModels1)
    {

        this.context=context1;
        this.doctorModels=doctorModels1;
        this.filterListDoctorModel=doctorModels1;
    }
    @Override
    public DoctorShowAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DoctorShowAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.doc_details_show,parent,false));
    }


    @Override
    public void onBindViewHolder(DoctorShowAdapter.MyViewHolder holder, int position) {

        holder.tvDocName.setText( filterListDoctorModel.get(position).getName());
        holder.tvDocDegree.setText( doctorModels.get(position).getDegree());
        holder.tvDocPosition.setText( doctorModels.get(position).getPosition());
        holder.tvDocChamber.setText( doctorModels.get(position).getChamber());
        holder.tvDocAddress.setText( doctorModels.get(position).getChamberAddress());
        holder.tvDocPhone.setText( doctorModels.get(position).getPhoneNo());
        holder.tvVisitingTime.setText(doctorModels.get(position).getVisitingTime());
        holder.tvFees.setText(doctorModels.get(position).getVisitingFee());

    }

    @Override
    public int getItemCount() {
        return filterListDoctorModel.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String quertString= charSequence.toString();
                if(quertString.isEmpty())
                    filterListDoctorModel=doctorModels;
                else {
                    ArrayList<DoctorModel> templist= new ArrayList<>();
                    for(DoctorModel s: doctorModels){
                        if(s.getName().toLowerCase().contains(quertString.toLowerCase())){
                            templist.add(s);
                        }

                    }
                    filterListDoctorModel=templist;
                }
                FilterResults filterResults= new FilterResults();
                filterResults.values=filterListDoctorModel;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                filterListDoctorModel= (ArrayList<DoctorModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvDocName,tvDocDegree,tvDocPosition,tvDocChamber,tvDocAddress,tvDocPhone,tvVisitingTime,tvFees;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvDocName=itemView.findViewById(R.id.tvDoctorName);
            tvDocDegree=itemView.findViewById(R.id.tvDocDegree);
            tvDocPosition=itemView.findViewById(R.id.tvDocPosition);
            tvDocChamber=itemView.findViewById(R.id.tvDocChember);
            tvDocAddress=itemView.findViewById(R.id.tvDocAddress);
            tvDocPhone=itemView.findViewById(R.id.tvDocPhone);
            tvVisitingTime=itemView.findViewById(R.id.tvVisitingTime);
            tvFees=itemView.findViewById(R.id.tvVisitingFees);
        }
    }


}
