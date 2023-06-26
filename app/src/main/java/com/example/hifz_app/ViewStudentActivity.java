package com.example.hifz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ViewStudentActivity extends AppCompatActivity {

    EditText student;
    AppCompatButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        btn= findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student=findViewById(R.id.getStudentId);
                String id=student.getText().toString();

                System.out.println("Student ID: " + id);
                Intent intent=  new Intent(ViewStudentActivity.this,UpdateStudentActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);

            }
        });
    }
}