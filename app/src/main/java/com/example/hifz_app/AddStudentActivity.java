package com.example.hifz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import data.DBHandler;
import data.Student;

public class AddStudentActivity extends AppCompatActivity {

    EditText name, _class, age, id;
    AppCompatButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


    btn= findViewById(R.id.saveStudentBtn);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            id = findViewById(R.id.enterId);
            name = findViewById(R.id.enterName);
            _class = findViewById(R.id.enterClass);
            age=findViewById(R.id.enterAge);

            // create an object
            Student student = new Student(id.getText().toString(), name.getText().toString(), Integer.parseInt(age.getText().toString()),Integer.parseInt(_class.getText().toString()));

            // create object of db handler

            DBHandler dbHandler = new DBHandler(AddStudentActivity.this);
            int result = dbHandler.insertStudent(student);

            if(result==-1)
            {
                Toast.makeText(AddStudentActivity.this,"Couldn't add student!",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(AddStudentActivity.this,"Student added!",Toast.LENGTH_SHORT).show();
            }



            // checking if added or not
            dbHandler.showDb();

            Intent intent = new Intent(AddStudentActivity.this, SelectActionActivity.class);
            startActivity(intent);
        }
    });


    }
}