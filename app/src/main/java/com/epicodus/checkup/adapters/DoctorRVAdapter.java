package com.epicodus.checkup.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.epicodus.checkup.R;
import com.epicodus.checkup.database.Doctor;


public class DoctorRVAdapter extends RecyclerView.Adapter<DoctorRVAdapter.ViewHolder>{

    private LayoutInflater inflater;
    private List<Doctor> doctorList;


    public DoctorRVAdapter(Context context, List<Doctor> doctorList) {
        this.doctorList = doctorList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.doctor_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.doctorName.setText(doctorList.get(position).getName());
        //holder.doctorNumber.setText(doctorList.get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView doctorName;
        public TextView doctorNumber;
        public ViewHolder(View itemView) {
            super(itemView);
            doctorName = (TextView)itemView.findViewById(R.id.nameTV);
            //doctorNumber = (TextView)itemView.findViewById(R.id.numberTV);
        }
    }
}
