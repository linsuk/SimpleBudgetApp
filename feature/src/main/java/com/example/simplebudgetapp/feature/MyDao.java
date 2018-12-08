package com.example.simplebudgetapp.feature;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import java.util.Date;
import java.util.List;

@Dao
public interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addToBiudzetas(Biudzetas biudzetas);

    @Query("select * from duomenys")
    public List<Biudzetas> getDuomenys();

    @Delete
    public void deleteEntry(Biudzetas biudzetas);
}
