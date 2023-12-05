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


public class SignupActivity extends AppCompatActivity {

    Button signUpButton, cancel;
    EditText username, password, password2;
    boolean allFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        password2 = findViewById(R.id.editText3);
        cancel = findViewById(R.id.button2);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnTo = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(returnTo);
            }
        });
    }
    private boolean CheckAllFields() {
        if (username.length() == 0) {
            username.setError("This field is required");
            return false;
        }
        if (password != password2) {
            password.setError("Passwords must match");
            password2.setError("Passwords must match");
        }
        if (password.length() == 0) {
            password.setError("Password is required");
            return false;
        } else if (password.length() < 5) {
            password.setError("Password must be minimum 5 characters");
            return false;
        }
        return true;        //after all fields are checked
    }
}
