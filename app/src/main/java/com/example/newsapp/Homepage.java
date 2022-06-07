package com.example.newsapp;

import android.content.Intent;
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
            LogIn.preferences = getSharedPreferences("switch_button", MODE_PRIVATE);
            LogIn.editor = LogIn.preferences.edit();
            LogIn.editor.putString("remember", "false");
            LogIn.editor.apply();
            finish();
            Intent intent = new Intent(Homepage.this, LogIn.class);
            startActivity(intent);
        });
    }

    /*
     * When a specific article is selected
     * this method is responsible for changing the view to a selected article.
     */
    public void selectArticle(View v) {
        Intent intent = new Intent(Homepage.this, ReadArticle.class);
        startActivity(intent);
    }
}