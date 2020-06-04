package com.example.a355uek.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Pendence {

    //Autoincrement
    @PrimaryKey(autoGenerate = true)
    public int id;

    //Spalte heisst in der DB title
    @ColumnInfo
    public String title;
    @ColumnInfo
    public String description;
    @ColumnInfo
    public String date;
    @ColumnInfo
    public String importance;
    //  private DateFormat datum;

    public Pendence(int id, String title, String description, String importance) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.importance = importance;
    }

    public Pendence(){
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

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Pendence{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", importance='" + importance + '\'' +
                '}';
    }
}

