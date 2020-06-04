 package com.example.a355uek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

 public class SecondActivity extends AppCompatActivity {

    TextView title,description,importance, date;
    String titleString,descriptionString,importanceString, dateString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        title=findViewById(R.id.titleofsecond);
        description=findViewById(R.id.descriptionofsecond);
        importance=findViewById(R.id.importanceofsecond);
        date = findViewById(R.id.dateofsecond);
        getData();
        setData();
    }

    private void getData(){
    titleString=getIntent().getStringExtra("title");
    descriptionString=getIntent().getStringExtra("description");
    importanceString=getIntent().getStringExtra("importance");
    dateString=getIntent().getStringExtra("date");
    }
    private void setData(){
    title.setText(titleString);
    description.setText(descriptionString);
    importance.setText(importanceString);
    }
}