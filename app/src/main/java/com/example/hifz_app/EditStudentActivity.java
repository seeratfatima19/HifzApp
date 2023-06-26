package com.example.hifz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import data.DBHandler;

public class EditStudentActivity extends AppCompatActivity {

    EditText date, surah, para, sabaq, sabqi, manzil;
    AppCompatButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        Intent intent=getIntent();
        String id = intent.getStringExtra("id");
        date= findViewById(R.id.editDate);
        surah=findViewById(R.id.editSurah);
        para=findViewById(R.id.editPara);
        sabaq=findViewById(R.id.editsabaq);
        sabqi=findViewById(R.id.editsabaqi);
        manzil=findViewById(R.id.editManzil);

        btn= findViewById(R.id.updateStudent);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler dbHandler = new DBHandler(EditStudentActivity.this);
                int result = dbHandler.updateStudent(id,date.getText().toString(),Integer.parseInt(surah.getText().toString()),Integer.parseInt(para.getText().toString()),sabaq.getText().toString(),Integer.parseInt(sabqi.getText().toString()), Integer.parseInt(manzil.getText().toString()));

                if(result==-1)
                {
                    Toast.makeText(EditStudentActivity.this,"Couldn't update data!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(EditStudentActivity.this,"Data added!",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}