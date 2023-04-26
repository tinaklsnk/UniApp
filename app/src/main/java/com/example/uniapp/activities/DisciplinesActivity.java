package com.example.uniapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.uniapp.R;
import com.example.uniapp.adapters.DisciplineAdapter;
import com.example.uniapp.models.Discipline;
import com.example.uniapp.models.Specialty;
import com.example.uniapp.pdfs.PdfActivity;

import java.util.List;

public class DisciplinesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewDisciplines;
    private DisciplineAdapter disciplineAdapter;
    private TextView textView;
    Specialty specialty;
    String path;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplines);

        Intent intent = getIntent();
        List<Discipline> disciplines = (List<Discipline>) intent.getSerializableExtra("list");
        path = getIntent().getStringExtra("path");
        button = findViewById(R.id.sylabus_button);
        if (path.isEmpty() || path==null) {
            button.setVisibility(View.GONE);
        }
        recyclerViewDisciplines = findViewById(R.id.discipline_recycler_view);
        recyclerViewDisciplines.setLayoutManager(new LinearLayoutManager(this));
        disciplineAdapter = new DisciplineAdapter(disciplines);
        recyclerViewDisciplines.setAdapter(disciplineAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(DisciplinesActivity.this, SylabusActivity.class);
                intent.putExtra("path", path);
                // Start the new activity
                startActivity(intent);
            }
        });
    }
}
