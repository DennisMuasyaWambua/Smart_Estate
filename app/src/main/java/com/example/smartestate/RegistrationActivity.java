package com.example.smartestate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {
    private EditText surname, estate, email,phoneNumber, Password, confirmation;
    private Button buttonRegister, agreeButton;
    private TextView loginRedirect;
    private Dialog epicDialog;
    private ImageView cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        epicDialog = new Dialog(RegistrationActivity.this);

        //initializing the values
        surname = (EditText)findViewById(R.id.surname);
        estate = (EditText)findViewById(R.id.estate);
        email = (EditText)findViewById(R.id.email);
        phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        Password = (EditText)findViewById(R.id.Password);
        confirmation = (EditText)findViewById(R.id.confirmation);
        buttonRegister = (Button)findViewById(R.id.buttonRegister);
        loginRedirect = (TextView)findViewById(R.id.loginRedirect);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                termsAndConditions();
            }
        });
    }
    public void termsAndConditions(){
        epicDialog.setContentView(R.layout.terms_pop_up);
        cancelButton = (ImageView)epicDialog.findViewById(R.id.cancelButton);
        agreeButton = (Button)epicDialog.findViewById(R.id.agreeButton);


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
                Toast.makeText(getApplicationContext(),"You have to agree in order to proceed",Toast.LENGTH_LONG).show();
            }
        });
        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Objects.requireNonNull(epicDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();

    }
}
