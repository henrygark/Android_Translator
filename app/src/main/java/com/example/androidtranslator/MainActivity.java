//Henry Garkanian
//CST 338
//2 December 2023
//Project 2 Android Translator

package com.example.androidtranslator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.androidtranslator.Database.AppDAO;
import com.example.androidtranslator.Database.AppDatabase;
import com.example.androidtranslator.Database.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String USER_ID_KEY = "com.example.androidtranslator.Database.userIdKey";
    private static final String PREFENCES_KEY = "com.example.androidtranslator.Database.preferences_key";

    private AppDAO mAppDAO;
    private List<User> mUsers;
    private int mUserId = -1;
    private SharedPreferences mPreferences = null;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDatabase();
        userCheck();
        loginUser(mUserId);
    }

    private void getDatabase() {
        mAppDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .getAppDao();
    }
        private void loginUser ( int userId){
            mUser = mAppDAO.getUsersById(userId);
            addUser(userId);
            invalidateOptionsMenu();
        }
        public static Intent intentFactory (Context context, int userId){
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra(USER_ID_KEY, userId);

            return intent;
        }
    private void addUser(int userId) {
        if (mPreferences == null) {
            getPreferences();
        }
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(USER_ID_KEY, userId);
        editor.apply();
    }
    private void getPreferences() {
        mPreferences = this.getSharedPreferences(PREFENCES_KEY, Context.MODE_PRIVATE);
    }
    private void userCheck() {
        mUserId = getIntent().getIntExtra(USER_ID_KEY, -1);

        if (mUserId != -1) {
            return;
        }
        if (mPreferences == null) {
            getPreferences();
        }
        mUserId = mPreferences.getInt(USER_ID_KEY, -1);
        if (mUserId != -1) {
            return;
        }
        List<User> users = mAppDAO.getAllUsers();
        if (users.size() <= 0) {
            User defaultUser = new User("testuser1", "testuser1");
            User altUser = new User("admin2", "admin2");
            mAppDAO.insert(defaultUser, altUser);
        }
        Intent intent = LoginActivity.intentFactory(this);
        startActivity(intent);
    }

    private void logoutUser () {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

            alertBuilder.setMessage(R.string.logout);

            alertBuilder.setPositiveButton(getString(R.string.yes),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            clearUserFromIntent();
                            clearUserFromPref();
                            mUserId = -1;
                            userCheck();
                        }
                    });
            alertBuilder.setNegativeButton(getString(R.string.no),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            alertBuilder.create().show();
        }

    private void clearUserFromIntent() {
        getIntent().putExtra(USER_ID_KEY, -1);
    }
    private void clearUserFromPref() {
        addUser(-1);
    }
}