package com.example.uniapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.uniapp.R;
import com.example.uniapp.adapters.DisciplineAdapter;
import com.example.uniapp.models.Discipline;
import com.example.uniapp.models.Specialty;

import java.util.ArrayList;
import java.util.List;

public class DisciplinesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewDisciplines;
    private DisciplineAdapter disciplineAdapter;
    private TextView textView;
    Specialty specialty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplines);

        //String specialtyName = getIntent().getStringExtra("specialtyName");
        //specialty = (Specialty) getIntent().getSerializableExtra("specialty");
        //textView = findViewById(R.id.discipline_text_view);
        //textView.setText(specialtyName);
        Intent intent = getIntent();
        List<Discipline> disciplines = (List<Discipline>) intent.getSerializableExtra("list");
        // get the list of disciplines for the selected specialty
         //disciplines = getDisciplinesBySpecialty();

        // set up the recycler view for displaying the list of disciplines
        recyclerViewDisciplines = findViewById(R.id.discipline_recycler_view);
        recyclerViewDisciplines.setLayoutManager(new LinearLayoutManager(this));
        disciplineAdapter = new DisciplineAdapter(disciplines);
        recyclerViewDisciplines.setAdapter(disciplineAdapter);
    }

    private List<Discipline> getDisciplinesBySpecialty() {
        List<Discipline> disciplines = new ArrayList<>();
        if (specialty != null && specialty.getDisciplines() != null) {
            disciplines.addAll(specialty.getDisciplines());
        }
        return disciplines;
    }
}
