package com.example.androidtranslator.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.androidtranslator.User;

@Database(entities = {User.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "TRANSLATOR_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";
    public abstract AppDAO getAppDao();

}
