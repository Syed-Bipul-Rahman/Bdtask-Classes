package com.storedata.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Name of the SharedPreferences file
    private static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //code example
        // Get SharedPreferences instance
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Saving data
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", "John");
        editor.putInt("age", 25);
        editor.putBoolean("isStudent", true);
        editor.apply(); // Commit the changes

        // Retrieving data
        String username = preferences.getString("username", ""); // Provide a default value
        int age = preferences.getInt("age", 0); // Provide a default value
        boolean isStudent = preferences.getBoolean("isStudent", false); // Provide a default value



    }
}