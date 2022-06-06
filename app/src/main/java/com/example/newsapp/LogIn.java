package com.example.newsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class LogIn extends AppCompatActivity {
    private EditText usernameIn, passwordIn;
    private SwitchCompat switchButton;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usernameIn = findViewById(R.id.usernameText);
        passwordIn = findViewById(R.id.password);
        switchButton = findViewById(R.id.rememberMeButton);
        login = findViewById(R.id.logIn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, MainScreenActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences preferences = getSharedPreferences("switched_button", MODE_PRIVATE);
        String switch_button = preferences.getString("remember", "");
        if (switch_button.equals("true")){
            Intent intent = new Intent(LogIn.this, MainScreenActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please Sign In.", Toast.LENGTH_SHORT).show();
        }
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("switch_button", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(LogIn.this, "switched", Toast.LENGTH_LONG).show();
                }
                else{
                    SharedPreferences preferences = getSharedPreferences("switch_button", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(LogIn.this, "Unswitched", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}