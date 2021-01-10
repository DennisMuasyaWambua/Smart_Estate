package com.example.smartestate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LandlordsActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private TabItem Rent, Occupancy, Expenses;
    private FirebaseAuth mAuth;


    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
        
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlords);
        tabLayout = (TabLayout) findViewById(R.id.dashboard);
        Rent = (TabItem)findViewById(R.id.Rent);
        Occupancy = (TabItem)findViewById(R.id.Occupancy);
        Expenses = (TabItem)findViewById(R.id.Expenses);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),0,tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}