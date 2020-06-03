package com.example.a355uek.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;

@Entity
public class Pendence {

    //Autoincrement
    @PrimaryKey(autoGenerate = true)
    private int id;

    //Spalte heisst in der DB title
    private String title;

    private String description;

    private  String date;

    private String importance;

    public Pendence(int id, String title,String description/* DateFormat dateFormat*/, String importance) {
        this.id=id;
        this.title=title;
        this.description=description;
       // this.date=dateFormat.toString();
        this.importance=importance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descritpion) {
        this.description = descritpion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }
}
