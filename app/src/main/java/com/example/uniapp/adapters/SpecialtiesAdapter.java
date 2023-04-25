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
import com.example.uniapp.activities.DisciplinesActivity;
import com.example.uniapp.models.Specialty;

import java.io.Serializable;
import java.util.List;

public class SpecialtiesAdapter extends RecyclerView.Adapter<SpecialtiesAdapter.ViewHolder> {

    private List<Specialty> specialties;
    private Context context;

    public SpecialtiesAdapter(List<Specialty> specialties, Context context) {
        this.specialties = specialties;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_specialty, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Specialty specialty = specialties.get(position);
        holder.textViewSpecialtyName.setText(specialty.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DisciplinesActivity.class);
                intent.putExtra("list", (Serializable) specialty.getDisciplines());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return specialties.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSpecialtyName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSpecialtyName = itemView.findViewById(R.id.text_view_specialty_name);
        }
    }
}
