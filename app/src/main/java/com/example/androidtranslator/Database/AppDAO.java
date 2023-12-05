package com.example.androidtranslator.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidtranslator.User;

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
    List<User> getAllUsers();

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserId = mUsername")
    User getUsersByUsername(String username);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserId = :userId")
    User getUsersById(int userId);

}
