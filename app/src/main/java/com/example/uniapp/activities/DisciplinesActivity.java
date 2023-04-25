package com.example.uniapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.uniapp.R;
import com.example.uniapp.adapters.DisciplineAdapter;
import com.example.uniapp.models.Discipline;

import java.util.ArrayList;
import java.util.List;

public class DisciplinesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewDisciplines;
    private DisciplineAdapter disciplineAdapter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplines);

        String specialtyName = getIntent().getStringExtra("specialtyName");
        //textView = findViewById(R.id.discipline_text_view);
        //textView.setText(specialtyName);

        // get the list of disciplines for the selected specialty
        List<Discipline> disciplines = getDisciplinesBySpecialty(specialtyName);

        // set up the recycler view for displaying the list of disciplines
        recyclerViewDisciplines = findViewById(R.id.discipline_recycler_view);
        recyclerViewDisciplines.setLayoutManager(new LinearLayoutManager(this));
        disciplineAdapter = new DisciplineAdapter(disciplines);
        recyclerViewDisciplines.setAdapter(disciplineAdapter);
    }

    private List<Discipline> getDisciplinesBySpecialty(String specialtyName) {
        // TODO: implement the logic for getting the list of disciplines for the selected specialty
        // Here is a sample list for testing purposes
        List<Discipline> disciplines = new ArrayList<>();
        if (specialtyName.equals("Computer Science")) {
            disciplines.add(new Discipline("Algorithms"));
            disciplines.add(new Discipline("Data Structures"));
            disciplines.add(new Discipline("Database Systems"));
        } else if (specialtyName.equals("Electrical Engineering")) {
            disciplines.add(new Discipline("Circuits"));
            disciplines.add(new Discipline("Electromagnetics"));
            disciplines.add(new Discipline("Power Systems"));
        } else {
            disciplines.add(new Discipline("Discipline 1"));
            disciplines.add(new Discipline("Discipline 2"));
            disciplines.add(new Discipline("Discipline 3"));
        }
        return disciplines;
    }
}
