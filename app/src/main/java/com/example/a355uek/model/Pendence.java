package com.example.a355uek.model;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.example.a355uek.DateConverter;
import java.util.Date;

@Entity
public class Pendence {

    //Autoincrement
    @PrimaryKey(autoGenerate = true)
    public int id;

    //Spalte heisst in der DB title
    @ColumnInfo
    private String title;
    @ColumnInfo
    private String description;
    @ColumnInfo
    private String importance;
    @ColumnInfo
    @TypeConverters({DateConverter.class})
    @Nullable
    private Date dateToFinish;

    //is the constructor of the class. Takes an id, a title, a description, a importance value and a date as parameters
    public Pendence(String title, String description, Date date, String importance) {
        this.title = title;
        this.description = description;
        this.dateToFinish = date;
        this.importance = importance;
    }
    //the default constructor
    public Pendence(){
    }
    //returns the id
    public int getId() {
        return id;
    }
    //takes an id as a parameter and sets it
    public void setId(int id) {
        this.id = id;
    }
    //returns the title of the Pendenz
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

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public void setDateToFinish(Date dateToFinish){
        this.dateToFinish=dateToFinish;
    }

    public Date getDateToFinish(){
        return dateToFinish;
    }

}

