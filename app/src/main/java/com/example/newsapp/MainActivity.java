package com.example.newsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

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

    /*
     * When user press skip button
     * The display changes to the log in display
     * the onclick method is defined in the main_activity xml layout
     */
    public void onSkipButtonClick(View view) {
        Intent intent = new Intent(MainActivity.this, LogIn.class);
        startActivity(intent);
    }

    /*
     * When a specific article is selected
     * this method is responsible for changing the view to a selected article.
     */
    public void selectArticle(View v) {
        setContentView(v);
    }
    public void logOut(View v) {
        Intent intent = new Intent(MainActivity.this, LogIn.class);
       startActivity(intent);
    }

    /*
     * This view in the article screen is for the back page button,
     * Takes the user to previous screen.
     */
    public void backPage(View v) {
        setContentView(v);
    }

    /*
     * The following methods are responsible for the walkthrough screen
     * When the app is first opened
     *
     * This method here sets up the three dots at the bottom of page
     */
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

    /*
     * This method is responsible for the view of three screens in the walk through screen,
     * resposible for rotation of the views.
     */
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            setUpIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    private int getitem(int i) {

        return viewerPager.getCurrentItem() + i;
    }
}
