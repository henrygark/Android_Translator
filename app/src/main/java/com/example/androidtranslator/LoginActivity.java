//Henry Garkanian
//CST 338
//2 December 2023
//Project 2 Android Translator

package com.example.androidtranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button login, signup;
    EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText = findViewById(R.id.editText);     //username
        editText2 = findViewById(R.id.editText2);       //password
        login = findViewById(R.id.button);      //login button
        signup = findViewById(R.id.button3);     //signup button

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText.getText().toString();
                String password = editText2.getText().toString();

                if (username.equals("Admin") && password.equals("123")) {
                    Toast.makeText(LoginActivity.this, "Admin Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, LanguageActivity.class);     //Heads to app main page
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Please enter a valid username and password", Toast.LENGTH_SHORT).show();      //Failed login
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LoginActivity.this, SignupActivity.class);     //Heads to app main page
                startActivity(intent2);
            }
        });
    }
}