package com.example.newsapp;
/**
 * This class is responsible for "remember me" functionality when user switches the switch button
 * It is also responsible for logging in functionality
 * Does this by using SharedPreferences API instead of the database,
 * The SharedPreferences variables are shared between the Homepage and LogIn classes
 * The user credetials are saved in a Room DataBase afetr they are entered by the user -
 * This functionality is simple and only uses one SQL query on which is import.
 *
 * @version 0.1
 *
 * @Kgomotso
 */

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

import com.example.newsapp.Database.AppDatabase;
import com.example.newsapp.Database.User;

public class LogIn extends AppCompatActivity {
    EditText usernameIn, passwordIn;
    SwitchCompat switchButton;
    Button login;
    static SharedPreferences preferences;
    static SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usernameIn = findViewById(R.id.usernameText);
        passwordIn = findViewById(R.id.password);
        switchButton = findViewById(R.id.rememberMeButton);
        login = findViewById(R.id.logIn);

        login.setOnClickListener((View view) -> {
                Intent intent = new Intent(LogIn.this, Homepage.class);
                startActivity(intent);
        });
        /*
         * Stores user creditials( username and password) into a database
         */
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());
        User user = new User();
        user.username = usernameIn.getText().toString();
        user.password = passwordIn.getText().toString();
        db.userDao().insertUser(user);
        /*
         * Checks if "remember me" button has been switched,
         * If it is switched on the app switches to the homepage of the app
         * If not, It tells the user to sign in
         */
        preferences = getSharedPreferences("switch_button", MODE_PRIVATE);
        String switch_button = preferences.getString("remember", "");
        if (switch_button.equals("true")){
            Intent intent = new Intent(LogIn.this, Homepage.class);
            startActivity(intent);
        }
        else if(!switch_button.equals("false")){
            Toast.makeText(this, "Please Enter Details.", Toast.LENGTH_SHORT).show();
        }
        /*
         * This button uses the concept of shared preferences to save the user input
         * When the "Remember me" button is switched on,
         * In the last log in session
         */
        switchButton.setOnCheckedChangeListener((CompoundButton compoundButton, boolean b) -> {
                if (compoundButton.isChecked()) {
                    preferences = getSharedPreferences("switch_button", MODE_PRIVATE);
                    editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                }
                else if (!compoundButton.isChecked()){
                    preferences = getSharedPreferences("switch_button", MODE_PRIVATE);
                    editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                }
        });
    }


}