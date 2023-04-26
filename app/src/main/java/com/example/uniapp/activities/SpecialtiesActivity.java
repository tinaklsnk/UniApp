package com.example.uniapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.uniapp.R;
import com.example.uniapp.adapters.SpecialtiesAdapter;
import com.example.uniapp.models.Department;
import com.example.uniapp.models.Discipline;
import com.example.uniapp.models.Specialty;

import java.util.ArrayList;
import java.util.List;

public class SpecialtiesActivity extends AppCompatActivity {

    private List<Specialty> specialtyList;
    private RecyclerView specialtiesRecyclerView;
    private SpecialtiesAdapter specialtiesAdapter;
    private Department department;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialties);

        String departmentName = getIntent().getStringExtra("departmentName");
        textView = findViewById(R.id.specialty_text_view);
        textView.setText(departmentName);

        department = new Department(departmentName);
        setSpecialtyRecyclerView(departmentName);

        specialtiesRecyclerView = findViewById(R.id.specialty_recycler_view);
        specialtiesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        specialtiesAdapter = new SpecialtiesAdapter(getSpecialtiesForDepartment(), this);
        specialtiesRecyclerView.setAdapter(specialtiesAdapter);
    }

    private List<Specialty> getSpecialtiesForDepartment() {
        specialtyList = new ArrayList<>();
        if (department != null && department.getSpecialties() != null) {
            specialtyList.addAll(department.getSpecialties());
        }

        return specialtyList;
    }

    private void setSpecialtyRecyclerView(String departmentName) {
        if (departmentName.equals("Кафедра диференціальних рівнянь і прикладної математики")) {
            department.setSpecialties(setMiF1());
        }
        else if (departmentName.equals("Кафедра комп’ютерних наук та інформаційних систем")) {
            department.setSpecialties(setMiF2());
        }
        else if (departmentName.equals("Кафедра математики та інформатики і методики навчання")) {
            department.setSpecialties(setMiF3());
        }
        else if (departmentName.equals("Кафедра української мови")) {
            department.setSpecialties(setFIL1());
        }
    }
    private List<Specialty> setMiF1() {
        List<Specialty> specialties= new ArrayList<>();
        specialties.add(new Specialty("113 - Прикладна математика", setPM(), "/faculty/MIF/MIF1/PM"));
        return specialties;
    }
    public List<Specialty> setMiF2() {
        List<Specialty> specialties= new ArrayList<>();
        specialties.add(new Specialty("122 - Комп’ютерні науки", setKN(), "/faculty/MIF/MIF2/KN"));
        specialties.add(new Specialty("126 – Інформаційні системи та технології", new ArrayList<>(), "/faculty/MIF/MIF2/IST"));
        return specialties;
    }
    public List<Specialty> setMiF3() {
        List<Specialty> specialties= new ArrayList<>();
        specialties.add(new Specialty("014.04 - Середня освіта (Математика)", new ArrayList<>(), ""));
        specialties.add(new Specialty("014.09 - Середня освіта (Інформатика)", new ArrayList<>(), ""));
        return specialties;
    }
    public List<Specialty> setMiF4() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setMiF5() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setMiF6() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }

    public List<Specialty> setFIL1() {
        List<Specialty> specialties= new ArrayList<>();
        specialties.add(new Specialty("035 Філологія", new ArrayList<>(), ""));
        return specialties;
    }
    public List<Specialty> setFIL2() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setFIL3() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setFIL4() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setFIL5() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setFIL6() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    private List<Discipline> setPM() {
        List<Discipline> disciplines = new ArrayList<>();
        disciplines.add(new Discipline("Диференціальні рівняння"));
        disciplines.add(new Discipline("Рівняння математичної фізики"));
        disciplines.add(new Discipline("Пакети комп’ютерної математики"));
        disciplines.add(new Discipline("Варіаційне числення і методи оптимізації"));
        disciplines.add(new Discipline("Основи математичного моделювання\t"));
        disciplines.add(new Discipline("Диференціальні рівняння"));
        disciplines.add(new Discipline("Методи оптимізації"));
        disciplines.add(new Discipline("Диференціальні рівняння"));
        disciplines.add(new Discipline("Пакети комп’ютерної математики"));
        disciplines.add(new Discipline("Числові методи"));
        disciplines.add(new Discipline("Програмування на C/C++"));
        disciplines.add(new Discipline("Спеціалізовані мови програмування"));
        disciplines.add(new Discipline("Видавнича система LaTeX"));
        disciplines.add(new Discipline("Рівняння з частинними похідними"));
        disciplines.add(new Discipline("Числові методи"));
        disciplines.add(new Discipline("Методи оптимізації і дослідженння операцій"));
        disciplines.add(new Discipline("Теорія систем і математичне моделювання"));
        disciplines.add(new Discipline("Моделі та методи прийняття рішень"));
        disciplines.add(new Discipline("Теорія керування"));
        disciplines.add(new Discipline("Математичні моделі економ., еколог. і соц. процесів"));
        disciplines.add(new Discipline("Об’єктно-орієнтоване програмування"));
        return disciplines;
    }
    private List<Discipline> setKN() {
        List<Discipline> disciplines = new ArrayList<>();
        disciplines.add(new Discipline("Диференціальні рівняння"));
        disciplines.add(new Discipline("Математичний аналіз"));
        disciplines.add(new Discipline("Алгебра і геометрія"));
        disciplines.add(new Discipline("Дискретна математика"));
        disciplines.add(new Discipline("Теорія ймовірностей та математична статистика"));
        disciplines.add(new Discipline("Математична логіка та теорія алгоритмів"));
        disciplines.add(new Discipline("Іноземна мова"));
        disciplines.add(new Discipline("Web-дизайн"));
        disciplines.add(new Discipline("Структури даних"));
        disciplines.add(new Discipline("Архітектура обчислювальних систем"));
        disciplines.add(new Discipline("Комп’ютерні мережі"));
        disciplines.add(new Discipline("Вступ у спеціальність"));
        disciplines.add(new Discipline("Бази даних"));
        disciplines.add(new Discipline("Операційні системи"));
        disciplines.add(new Discipline("Програмування С++"));
        disciplines.add(new Discipline("Програмування C#"));
        disciplines.add(new Discipline("Програмування Java"));
        disciplines.add(new Discipline("Паралельні та розподілені обчислення"));
        disciplines.add(new Discipline("Програмування та підтримка веб-застосувань"));
        disciplines.add(new Discipline("Теорія програмування"));
        disciplines.add(new Discipline("Цифрова техніка"));
        return disciplines;
    }
}
