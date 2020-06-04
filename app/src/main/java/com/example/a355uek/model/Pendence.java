package com.example.a355uek.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;


import com.example.a355uek.DateConverter;

import java.util.Date;

import java.text.DateFormat;

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
   /* @ColumnInfo
    private String date;*/
    @ColumnInfo
    private String importance;
    @ColumnInfo
    @TypeConverters({DateConverter.class})
    private Date dateToFinish;

    public Pendence(String title, String description, Date date, String importance) {
        this.title = title;
        this.description = description;
        this.dateToFinish = date;
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

   /* public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }*/

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

