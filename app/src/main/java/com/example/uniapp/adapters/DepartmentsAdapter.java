package com.example.uniapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uniapp.R;
import com.example.uniapp.activities.SpecialtiesActivity;
import com.example.uniapp.models.Department;

import java.util.List;

public class DepartmentsAdapter extends RecyclerView.Adapter<DepartmentsAdapter.ViewHolder> {

    private List<Department> departments;
    private Context context;

    public DepartmentsAdapter(List<Department> departments, Context context) {
        this.departments = departments;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_department, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Department department = departments.get(position);
        holder.textViewDepartmentName.setText(department.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SpecialtiesActivity.class);
                intent.putExtra("departmentName", department.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return departments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewDepartmentName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDepartmentName = itemView.findViewById(R.id.text_view_department_name);
        }
    }
}

