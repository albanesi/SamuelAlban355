package com.example.a355uek;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a355uek.model.Pendence;
import com.example.a355uek.persistence.AppDatabase;
import com.example.a355uek.persistence.PendenceDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton button;
    RecyclerView recyclerView;
    Adapter adapter;
    List<Pendence> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createExampleList();
        buildRecyclerView();
        button= findViewById(R.id.insertButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThePendenceActivity();
            }
        });



    }

    private void openThePendenceActivity() {
        Intent intent= new Intent(this, PendenceActivity.class);
        startActivity(intent);
    }

    private void buildRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new Adapter(this, items);
        recyclerView.setAdapter(adapter);
    }

    private void createExampleList() {
        PendenceDao pendenceDao = AppDatabase.getAppDb(this).getPendenceDao();
        items  = pendenceDao.getAll();
    }


}

