package com.example.smartestate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity {
    private EditText estateName, Block, houseNumber,password;
    private TextView registration, forgotPassword;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initializing elements
        estateName = (EditText)findViewById(R.id.estateName);
        Block = (EditText)findViewById(R.id.Block);
        houseNumber = (EditText)findViewById(R.id.houseNumber);
        password = (EditText)findViewById(R.id.password);
        registration = (TextView)findViewById(R.id.registration);
        forgotPassword = (TextView)findViewById(R.id.forgotPassword);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this,services.class));
            }
        });
    }
}
