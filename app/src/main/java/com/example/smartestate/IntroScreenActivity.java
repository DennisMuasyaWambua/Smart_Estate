package com.example.smartestate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class IntroScreenActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        sliderAdapter = new SliderAdapter(this);

    }
}