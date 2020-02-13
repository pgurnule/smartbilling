package com.billbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.billbook.R;

import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeHolder> {

    List<String> lstEmployee;
    Context context;

    public EmployeeListAdapter(List<String> lstEmployee, Context context) {
        this.lstEmployee = lstEmployee;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_employee_list,parent,false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lstEmployee.size();
    }

    public class EmployeeHolder extends RecyclerView.ViewHolder {
        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
