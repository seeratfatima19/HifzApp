package com.example.hifz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import data.DBHandler;
import data.RecyclerViewAdapter;
import data.Student;
import data.StudentData;

public class UpdateStudentActivity extends AppCompatActivity {

    // experiment ++

     RecyclerView recyclerView;
     RecyclerViewAdapter adapter;
     ArrayList<StudentData> studentData;
     ArrayAdapter<String> arrayAdapter;
    /// exp
    TextView name, stClass, age;
    AppCompatButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        System.out.println("Id gotten from intent "+id);

            //recycler view initialized
            recyclerView= findViewById(R.id.recyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            /////////

        name= findViewById(R.id.textViewName2);
        stClass= findViewById(R.id.textViewClass2);
        age= findViewById(R.id.textViewAge2);

        DBHandler dbHandler = new DBHandler(UpdateStudentActivity.this);
        Student student = dbHandler.getStudent(id);

        name.setText(student.getName());
        stClass.setText(Integer.toString(student.get_Class()));
        age.setText(Integer.toString(student.getAge()));

    // implement recycler view here


        studentData=dbHandler.getStudentData(id);
        RecyclerViewAdapter recyclerViewAdapter= new RecyclerViewAdapter(UpdateStudentActivity.this,studentData);
        recyclerView.setAdapter(recyclerViewAdapter);


        ///////////////////////

        btn=findViewById(R.id.updateBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(UpdateStudentActivity.this,EditStudentActivity.class);
                intent2.putExtra("id",id);
                startActivity(intent2);
            }
        });

    }
}