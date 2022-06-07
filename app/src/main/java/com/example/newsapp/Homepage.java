package com.example.newsapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/**
  * Responsible for the landing page of the app after the user log in
  *
  * @version 0.1
  *
  * @Kgomotso
  */
public class Homepage extends AppCompatActivity {
    Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsfeed);

        logOut = findViewById(R.id.logoutButton);

        logOut.setOnClickListener((View view) -> {
                SharedPreferences preferences = getSharedPreferences("switch_button", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();
                finish();
        });
    }
}