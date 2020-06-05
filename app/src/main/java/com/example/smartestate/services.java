package com.example.smartestate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class services extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new DashboardFragment();
    }

}
