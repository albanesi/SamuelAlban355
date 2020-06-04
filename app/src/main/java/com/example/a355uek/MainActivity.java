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
    private List<Pendence> dataModelList;
    Adapter adapter;
    ArrayList<Pendence> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.insertButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThePendenceActivity();
            }
        });
        createExampleList();
        buildRecyclerView();


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
        items = new ArrayList<>();

        items.add(new Pendence(2,"Tisch putzen","hosi","medium"));
        items.add(new Pendence(3,"halloasds","haoi","medium"));
        items.add(new Pendence(4,"hallsaswao","hosai","medium"));
        items.add(new Pendence(5,"haafdsafdllo","moi","medium"));
    }


}

