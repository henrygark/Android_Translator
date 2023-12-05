//Henry Garkanian
//CST 338
//2 December 2023
//Project 2 Android Translator

package com.example.androidtranslator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidtranslator.Database.AppDAO;
import com.example.androidtranslator.Database.AppDatabase;

public class LoginActivity extends AppCompatActivity {
    Button login, signup;
    EditText editText, editText2;

    private String mUsername;
    private String mPassword;
    private User mUser;
    private AppDAO mAppDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup = findViewById(R.id.button3);     //signup button
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signup);
            }
        });

        wireupDisplay();
        getDatabase();
    }

    private void wireupDisplay() {
        editText = findViewById(R.id.editText);        //username
        editText2 = findViewById(R.id.editText2);       //password
        login = findViewById(R.id.button);      //login button

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDisplayVals();
                if (checkForUser()) {
                    if (!validatePassword()) {
                        Toast.makeText(LoginActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = MainActivity.intentFactory(getApplicationContext(), mUser.getUserId());
                        startActivity(intent);
                    }
                }
            }
        });
        getDatabase();
    }
        private void getDatabase () {
            mAppDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build()
                    .getAppDao();
        }

        public static Intent intentFactory (Context context){
            Intent intent = new Intent(context, LoginActivity.class);
            return intent;
        }

        private boolean validatePassword () {
            return mUser.getPassword().equals(mPassword);
        }

        private boolean checkForUser () {
            mUser = mAppDao.getUsersByUsername(mUsername);
            if (mUser == null) {
                Toast.makeText(this, "No user " + mUsername + " found", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }
        private void getDisplayVals () {
            mUsername = editText.getText().toString().trim();
            mPassword = editText2.getText().toString().trim();
        }

    }