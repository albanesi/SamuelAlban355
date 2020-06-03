package com.example.a355uek.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.a355uek.model.Pendence;

import java.util.List;

@Dao
public interface PendenceDao {
    @Query("SELECT * FROM Pendence")
    List<Pendence> getAll();

    @Query("SELECT * FROM Pendence WHERE id = :pendenceId")
    Pendence getPendenceById(long pendenceId);

    @Query("DELETE FROM Pendence")
    void deleteAll();

    @Insert
    void insertAll(Pendence pendences);

}
