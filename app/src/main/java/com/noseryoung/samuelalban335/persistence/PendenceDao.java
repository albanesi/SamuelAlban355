package com.noseryoung.samuelalban335.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.noseryoung.samuelalban335.model.Pendence;

import java.util.List;

@Dao
public interface PendenceDao {
    @Query("SELECT * FROM Pendence")
    List<Pendence> getAll();

    @Query("DELETE FROM Pendence")
    void deleteAll();

    @Insert
    void insertAll(List<Pendence> pendences);

    @Query("Select count(*) from Pendence")
    int countPendences();
}
