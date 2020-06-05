package com.example.a355uek.persistence;
//the imports we needed for this class
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.a355uek.DateConverter;
import com.example.a355uek.model.Pendence;
//Here we have the annotations that tell us that this is a db
//it has only one entity the pendence class and the Db has been changed 3 times
//it also shows us that it has a typeconverter. It is for the Date Field
@Database(entities = {Pendence.class}, version = 3)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    //here we set the db name
    private static final String DB_NAME = "pendence_db";
    //the AppDatabase Field. Will get used when we need the Dao
    private static AppDatabase appDb;

    //a static method that initalises the databases after it has
    //checked if the db is null
    //then the method returns the db
    //takes a Context as parameter
    public static AppDatabase getAppDb(Context context) {
        if (appDb == null) {
            appDb = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return appDb;
    }
    //abstract Method. Is used to initalise the Dao
    public abstract PendenceDao getPendenceDao();
}
