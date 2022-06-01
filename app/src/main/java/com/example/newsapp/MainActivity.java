package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private boolean rememberMe = false;
    private String[] NameDatabase = {"John Doe", "Jane Doe", "JohnD", "JohnChamp"};
    private String[] passwords = {"abcdef", "Jane007", "JohnDoe001", "Johnny2022"};


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
                for (int i = 0; i > NameDatabase.length; i++){
                    if (username.equals(NameDatabase[i])){
                        if (password.equals(passwords[i])){
                            setContentView(R.layout.newsfeed);
                        }
                        else{
                            passwordIn.setError("Invalid Password");
                        }
                    }
                    else{
                        usernameIn.setError("Invalid Username");
                    }
                }

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