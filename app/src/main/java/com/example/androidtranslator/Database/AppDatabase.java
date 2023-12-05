package com.example.androidtranslator.Database;

import android.content.Context;

import com.example.androidtranslator.User;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AppDAO.class, User.class}, version = 2)
public abstract class AppDatabase  extends RoomDatabase {
    public static final String DATABASE_NAME = "Translator.db";
    public static final String USER_TABLE = "user_table";
    public abstract AppDAO getAppDao();
    private static volatile  AppDatabase instance;
    private static final Object LOCK = new Object();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }


}
