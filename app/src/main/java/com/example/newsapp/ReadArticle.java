package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReadArticle extends AppCompatActivity {
    ImageView backPage;
    static Intent articleIntent;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articledetails);
        articleIntent = getIntent();
        backPage = findViewById(R.id.backPageImage);
        backPage.setOnClickListener((View v) -> {
            Intent intent = new Intent(ReadArticle.this, Homepage.class);
            startActivity(intent);
       });

    }

}
