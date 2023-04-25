package com.example.uniapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uniapp.R;
import com.example.uniapp.models.Discipline;

import java.util.List;

public class DisciplineAdapter extends RecyclerView.Adapter<DisciplineAdapter.DisciplineViewHolder> {

    private List<Discipline> disciplineList;

    public DisciplineAdapter(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    @NonNull
    @Override
    public DisciplineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_discipline, parent, false);
        return new DisciplineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplineViewHolder holder, int position) {
        Discipline discipline = disciplineList.get(position);
        holder.textViewDisciplineName.setText(discipline.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Do something when a discipline is clicked
            }
        });
    }

    @Override
    public int getItemCount() {
        return disciplineList.size();
    }

    public class DisciplineViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewDisciplineName;

        public DisciplineViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDisciplineName = itemView.findViewById(R.id.text_view_discipline_name);
        }
    }
}
