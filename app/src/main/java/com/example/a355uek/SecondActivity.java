 package com.example.a355uek;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

 public class SecondActivity extends AppCompatActivity {

    //UI Components
    TextView title,description,importance, date;

    //Strings that are used to fill the UI Components with Data
    String titleString,descriptionString,importanceString, dateString;

    //this method gets called, each time we create a new state of this activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_second is our view
        setContentView(R.layout.activity_second);

        //we connect and initalise the UI Components from the Activity
        //with them from the XML View
        title=findViewById(R.id.titleofsecond);
        description=findViewById(R.id.descriptionofsecond);
        importance=findViewById(R.id.importanceofsecond);
        date = findViewById(R.id.dateofsecond);

        //fills the Strings with Data
        getData();
        //sets the value of the UI Components
        setData();
    }

    //gets the data from the intent and saves it in the different Strings
    private void getData(){
    titleString=getIntent().getStringExtra("title");
    descriptionString=getIntent().getStringExtra("description");
    importanceString=getIntent().getStringExtra("importance");
    dateString=getIntent().getStringExtra("date");
    }

    //sets the value of the strings in the UI Components
    private void setData(){
    title.setText(titleString);
    description.setText(descriptionString);
    importance.setText(importanceString);
    date.setText(dateString);
    }
}