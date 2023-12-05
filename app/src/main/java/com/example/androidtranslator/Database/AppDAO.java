package com.example.androidtranslator.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AppDAO {

    @Insert
    void insert(AppDAO... apps);

    @Update
    void update(AppDAO... apps);
    @Delete
    void delete(AppDAO app);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<AppDAO> getAllUsers();

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserId = mUsername")
    List<AppDAO> getUsersByUsername(String username);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserId = :userId")
    List<AppDAO> getUsersByUserId(int userId);

}
