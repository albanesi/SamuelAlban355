package com.example.a355uek;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a355uek.model.Pendence;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Pendence> dataModelList;
    Adapter adapter;
    ArrayList<Pendence> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();

        items.add(new Pendence(2,"Tisch putzen","hosi", "medium"));
        items.add(new Pendence(3,"halloasds","haoi","medium"));
        items.add(new Pendence(4,"hallsaswao","hosai","medium"));
        items.add(new Pendence(5,"haafdsafdllo","moi","medium"));
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new Adapter(this, items);
        recyclerView.setAdapter(adapter);

    }
    private void setData(){

        dataModelList = new ArrayList<>();
        dataModelList.add(new Pendence(1, "Schuhe putzen", "ss", "normal"));
        dataModelList.add(new Pendence(2, "kako putzen", "ss", "normal"));
    }
}
