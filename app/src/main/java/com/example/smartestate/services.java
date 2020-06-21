package com.example.smartestate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class services extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new DashboardFragment();
        
    }



    @Override
    public void onBackPressed() {
        DashboardFragment fragment = new DashboardFragment();
        if (fragment.drawerLayout.isDrawerOpen((GravityCompat.START))){
            fragment.drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }


}
