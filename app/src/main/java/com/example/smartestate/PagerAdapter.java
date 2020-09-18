package com.example.smartestate;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Objects;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(Objects.requireNonNull(fm));
        this.numOfTabs = numOfTabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                    return new rentFragment();
            case 1:
                    return new occupancyFragment();
            case 2:
                    return new expensesFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
