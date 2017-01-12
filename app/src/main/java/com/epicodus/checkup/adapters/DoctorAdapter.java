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



public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder>{

    private LayoutInflater inflater;
    private List<Doctor> doctorList;


    public DoctorAdapter(Context context, List<Doctor> doctorList) {
        this.doctorList = doctorList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.doctor_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.doctorName.setText(doctorList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView doctorName;
        public ViewHolder(View itemView) {
            super(itemView);
            doctorName = (TextView)itemView.findViewById(R.id.nameTV);
        }
    }
}
