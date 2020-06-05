package com.example.a355uek.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.a355uek.model.Pendence;
import java.util.List;

@Dao
public interface PendenceDao {
    //gets all Pendences from the DB
    @Query("SELECT * FROM Pendence")
    List<Pendence> getAll();
    //gets all pendences that have the same id
    //unnecessary for our project, but good for NOA
    @Query("SELECT * FROM Pendence WHERE id = :pendenceId")
    Pendence getPendenceById(long pendenceId);
    //deletes all Users from the DB
    //unnecessary for our project but good for NOA
    @Query("DELETE FROM Pendence")
    void deleteAll();
    //inserts the pendence that is given as a parameter
    @Insert
    void insertAll(Pendence pendences);

}
