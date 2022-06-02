package com.example.newsapp;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private boolean rememberMe = false;
    private String[] NameDatabase = {"John Doe", "Jane Doe", "JohnD", "JohnChamp"};
    private String[] passwords = {"abcdef", "Jane007", "JohnDoe001", "Johnny2022"};
    ViewPager pageSlider;
    LinearLayout linerDots;
    TextView[] dots;
    ViewPagerWrapper viewpagerWrapper;
    ViewPager viewerPager;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewerPager = (ViewPager) findViewById(R.id.slideViewPager);
        linearLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        viewpagerWrapper = new ViewPagerWrapper(this);

        viewerPager.setAdapter(viewpagerWrapper);

        setUpIndicator(0);
        viewerPager.addOnPageChangeListener(viewListener);

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

    public void setUpIndicator(int position) {

        dots = new TextView[3];
        linearLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive, getApplicationContext().getTheme()));
            linearLayout.addView(dots[i]);

        }

        dots[position].setTextColor(getResources().getColor(R.color.active, getApplicationContext().getTheme()));

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
        @Override
        public void onPageSelected(int position) {

            setUpIndicator(position);


        }
        @Override
        public void onPageScrollStateChanged(int state) {}
    };

    private int getitem(int i) {

        return viewerPager.getCurrentItem() + i;
    }
}







