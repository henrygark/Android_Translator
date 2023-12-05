package com.example.androidtranslator;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.androidtranslator.Database.AppDatabase;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User {

    @PrimaryKey(autoGenerate = true)
    private int mUserId;

    private boolean isAdmin;



    private String mUsername;
    private String mPassword;

    public User(String username, String password) {
        this.mUsername = username;
        this.mPassword = password;
        this.isAdmin = false;
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

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
    public void setUserId(int userId) {
        this.mUserId = userId;
    }
    public int getUserId() {
        return mUserId;
    }
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
