package com.snhu.weight_tracker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Save values in myprefs.xml
        SharedPreferences namedSharedPref = getSharedPreferences("myprefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = namedSharedPref.edit();
        editor.putString("name", "Tamika");
        editor.putInt("highScore", 500);
        editor.apply(); 

        // Save values in activity's default XML file
        SharedPreferences defaultSharedPref = getPreferences(Context.MODE_PRIVATE);
        editor = defaultSharedPref.edit();
        editor.putBoolean("bestScore", false);
        editor.putFloat("rating", 4.5f);
        editor.apply();
    }
}