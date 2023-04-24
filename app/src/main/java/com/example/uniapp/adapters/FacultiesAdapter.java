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
import com.example.uniapp.activities.DepartmentsActivity;
import com.example.uniapp.models.Faculty;

import java.util.List;

public class FacultiesAdapter extends RecyclerView.Adapter<FacultiesAdapter.ViewHolder> {

    private List<Faculty> faculties;
    private Context context;

    public FacultiesAdapter(List<Faculty> faculties, Context context) {
        this.faculties = faculties;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_faculty, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Faculty faculty = faculties.get(position);
        holder.textViewFacultyName.setText(faculty.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DepartmentsActivity.class);
                intent.putExtra("facultyName", faculty.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return faculties.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewFacultyName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewFacultyName = itemView.findViewById(R.id.text_view_faculty_name);
        }
    }
}

