package com.example.a355uek;
//all the import classes we needed
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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //UI Components from activity_main
    private FloatingActionButton button;
    RecyclerView recyclerView;
    PendenceAdapter pendenceAdapter;
    List<Pendence> items;

    //gets called each time the state gets created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main is our XML File
        setContentView(R.layout.activity_main);
        //we fill the items list up with pendeces from the db
        createExampleList();
        //we initialise the recyclerview and the adapter
        // and then we set our adapter as the adapter of the recyclerview
        buildRecyclerView();
        //initalize and connect the button with the insertButton from XML File
        button= findViewById(R.id.insertButton);
        //we set an OnClickListener on our button
        //it opens PendenceActivity and finishes the state
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThePendenceActivity();
            }
        });
    }
    //it opens PendenceActivity and finishes the state
    private void openThePendenceActivity() {
        Intent intent= new Intent(this, PendenceActivity.class);
        startActivity(intent);
        onStop();
    }
    //we initialise the recyclerview and the adapter
    // and then we set our adapter as the adapter of the recyclerview
    private void buildRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        pendenceAdapter = new PendenceAdapter(this, items);
        recyclerView.setAdapter(pendenceAdapter);
    }
    //we fill the items list up with pendeces from the db
    private void createExampleList() {
        PendenceDao pendenceDao = AppDatabase.getAppDb(this).getPendenceDao();
        items  = pendenceDao.getAll();
    }


}

