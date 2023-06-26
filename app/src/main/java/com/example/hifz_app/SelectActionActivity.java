package com.example.hifz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectActionActivity extends AppCompatActivity {

    AppCompatButton viewStudent, addStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_action);

        viewStudent = (AppCompatButton)findViewById(R.id.viewStudentBtnU);
        addStudent = (AppCompatButton)findViewById(R.id.addStudentBtn);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActionActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });

        viewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActionActivity.this, ViewStudentActivity.class);
                startActivity(intent);
            }
        });


    }
}