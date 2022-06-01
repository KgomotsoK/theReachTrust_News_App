package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.net.PasswordAuthentication;

public class MainActivity extends AppCompatActivity {
    private boolean rememberMe = false;
    private String[] NameDatabase = {"John Doe", "Jane Doe", "JohnD", "JohnChamp"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onSkipButtonClick(View view){
        if (rememberMe != true) {
            setContentView(R.layout.login);}
        else{
            setContentView(R.layout.newsfeed);
        }
    }
    public void onLogInClick(View view){
        EditText usernameIn = findViewById(R.id.usernameText);
        String username = usernameIn.getText().toString();

        EditText passwordIn = findViewById(R.id.password);
        String password = passwordIn.getText().toString();

            if (username.isEmpty()) {
                usernameIn.setError("Invalid username");
            } else if (password.isEmpty()) {
                passwordIn.setError("Invalid password");
            } else {
                setContentView(R.layout.newsfeed);
            }


    }
    public void selectArticle(View v){
        setContentView(R.layout.articledetails);
    }
    public void logOut(View v){
        setContentView(R.layout.login);
    }
    public void backPage(View v){
        setContentView(R.layout.newsfeed);
    }
    public void rememberMeButton(View v){
        if (rememberMe == false){
            return;
        }
        else{
            rememberMe = true;
        }
    }
}