package com.example.smartestate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {
    private EditText surname, estate, phoneNumber, Password, confirmation;
    private Button buttonRegister;
    private TextView loginRedirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //initializing the values
        surname = (EditText)findViewById(R.id.surname);
        estate = (EditText)findViewById(R.id.estate);
        phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        Password = (EditText)findViewById(R.id.Password);
        confirmation = (EditText)findViewById(R.id.confirmation);
        buttonRegister = (Button)findViewById(R.id.buttonRegister);
        loginRedirect = (TextView)findViewById(R.id.loginRedirect);


    }
}
