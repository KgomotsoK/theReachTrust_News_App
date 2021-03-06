package com.example.newsapp;
/**
  * The class is responsible for the "walkthrough" page simulations
  * Utilises the ViewPager for this functionality
  *
  * @version 0.1
  * @Kgomotso
  */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerWrapper extends PagerAdapter {
    Context context;

    int description[] = {R.string.introScreenParagraph1, R.string.introscreenParagraph2, R.string.introParagraph3};

    public ViewPagerWrapper(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return description.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);
        TextView slideDescription = view.findViewById(R.id.textDescription);
        slideDescription.setText(description[position]);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

}