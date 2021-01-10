package com.example.smartestate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static final int TIME_DELAY=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.this.startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                MainActivity.this.finish();
            }
        },TIME_DELAY);
    }

    @Override
    public void finish() {
        super.finish();
    }
}
