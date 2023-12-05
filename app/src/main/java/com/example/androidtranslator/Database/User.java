package com.example.androidtranslator.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.androidtranslator.Database.AppDatabase;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User {

    @PrimaryKey(autoGenerate = true)
    private int mUserId;

    private String mUsername;
    private String mPassword;

    public User(String username, String password) {
        this.mUsername = username;
        this.mPassword = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + mUsername + '\'' +
                ", password='" + mPassword + '\'' +
                '}';
    }

    @NonNull
    public String getUsername() {
        return mUsername;
    }

    public void setUsername(@NonNull String username) {
        this.mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }
    public void setUserId(int userId) {
        this.mUserId = userId;
    }
    public int getUserId() {
        return mUserId;
    }
}
