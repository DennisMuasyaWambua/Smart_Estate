package com.example.smartestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {
     EditText surname, estate, email,phoneNumber, Password, confirmation, accountNumber, payBillNumber;
     Button buttonRegister, agreeButton, submit;
     TextView loginRedirect;
     Dialog epicDialog;
     ImageView cancelButton;
     FirebaseAuth mAuth;
     FirebaseDatabase rootNode;
     DatabaseReference reference;
     ImageView exit;




    @Override
    protected void onStart() {
        super.onStart();
        //checking if user is signed in and updating the user interface appropriately
        FirebaseUser currentUser = mAuth.getCurrentUser();
       if(currentUser!=null){
           startActivity(new Intent(this,LandlordsActivity.class));
       }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        epicDialog = new Dialog(RegistrationActivity.this);
        mAuth = FirebaseAuth.getInstance();

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
                accountInformation();
               //validate();
            }
        });
        Objects.requireNonNull(epicDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();

    }
    public void createUser(){
        String Email = email.getText().toString().trim();
        String password = Password.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    //if user creation was successful

                   // reference = FirebaseDatabase.getInstance().getReference("Landlord");
                   final loading loading = new loading(RegistrationActivity.this);
                   loading.startLoadingDialog();
                   Toast.makeText(getApplicationContext(),"Registration successful",Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(RegistrationActivity.this,LandlordsActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(),"Unable to create user ",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void validate(){
        
        surname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String Surname = surname.getText().toString().trim();
                if(Surname.isEmpty()){
                    surname.setError("This field cannot be left empty");
                }else{
                    surname.setError(null);
                }
            }
        });
        estate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String Estate = estate.getText().toString().trim();
                if(Estate.isEmpty()){
                    estate.setError("This field cannot be left empty");
                }else{
                    estate.setError(null);
                }
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String Email = email.getText().toString().trim();
                String emailPattern = "[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
                if(TextUtils.isEmpty(Email)||!Email.matches(emailPattern)){
                    email.setError("Invalid email address!");
                }else{
                    email.setError(null);
                }

            }
        });
        Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = 8;
                String password = Password.getText().toString().trim();
               if(TextUtils.isEmpty(password)||password.length()<length){
                   Password.setError("Password cannot be less than eight characters!");
               }else{
                   Password.setError(null);
               }


            }
        });
        confirmation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String password = Password.getText().toString().trim();
                String confirmPassword = confirmation.getText().toString().trim();
                if(!confirmPassword.equals(password)){
                    confirmation.setError("The two passwords do not match");
                }else if(confirmPassword.isEmpty()){confirmation.setError("field cannot be left empty");
                }else{confirmation.setError(null);}
            }
        });
        accountNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        payBillNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
    public void accountInformation(){
        epicDialog.setContentView(R.layout.account_information);
        accountNumber = (EditText)epicDialog.findViewById(R.id.accountNumber);
        payBillNumber = (EditText)epicDialog.findViewById(R.id.payBillNumber);
        exit = (ImageView)epicDialog.findViewById(R.id.exit);
        submit = (Button)epicDialog.findViewById(R.id.submit);

        final String AccountNumber = accountNumber.getText().toString();
        final String payBill  = payBillNumber.getText().toString();
        final String Surname = surname.getText().toString().trim();
        final String estateName = estate.getText().toString().trim();
        final String mail = email.getText().toString().trim();
        final String phone = phoneNumber.getText().toString().trim();

        int value=0;
        int val=0;
        if(!"".equals(AccountNumber)&&!"".equals(payBill)){
            value = Integer.parseInt(AccountNumber);
            val = Integer.parseInt(payBill);
        }

        final int finalValue = value;
        final int finalVal = val;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode=FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Landlord");
                String id = reference.push().getKey();
                SmartModel landlord = new SmartModel(id,Surname, estateName,mail, phone,finalValue,finalVal);
                assert id != null;
                reference.child(id).setValue(landlord);
                validate();
                createUser();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        epicDialog.show();
    }
}
