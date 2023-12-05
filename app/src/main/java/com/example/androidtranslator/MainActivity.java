//Henry Garkanian
//CST 338
//2 December 2023
//Project 2 Android Translator

package com.example.androidtranslator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidtranslator.Database.AppDAO;
import com.example.androidtranslator.Database.AppDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String USER_ID_KEY = ""
    private static final String PREFENCES_KEY = ""

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .getAppDao();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);     //shows login screen
        startActivity(intent);

    }
}