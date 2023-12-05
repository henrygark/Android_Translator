//Henry Garkanian
//CST 338
//2 December 2023
//Project 2 Android Translator

package com.example.androidtranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LanguageActivity extends AppCompatActivity {

    Button armenianButton, frenchButton, backButton, createWordButton;
    TextView textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        backButton = findViewById(R.id.exitButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(LanguageActivity.this, LoginActivity.class);     //Heads back to app main page
                startActivity(intent3);
            }
        });

        }
    }