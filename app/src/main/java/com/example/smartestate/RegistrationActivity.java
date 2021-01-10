package com.example.smartestate;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {
     EditText surname, estate, email,phoneNumber, Password, confirmation, accountNumber, payBillNumber,account, bill;
     Button buttonRegister, agreeButton, submit;
     TextView loginRedirect;
     Dialog epicDialog;
     ImageView cancelButton;
     FirebaseAuth mAuth;
     FirebaseDatabase rootNode;
     DatabaseReference reference;
     ImageView exit;
     String id;




//    @Override
//    protected void onStart() {
//        super.onStart();
//        //checking if user is signed in and updating the user interface appropriately
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//       if(currentUser!=null){
//           startActivity(new Intent(this,LandlordsActivity.class));
//       }
//    }

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

        loginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,LandlordloginActivity.class));
            }
        });

        buttonRegister.setOnClickListener(v -> termsAndConditions());
    }
    public void termsAndConditions(){
        epicDialog.setContentView(R.layout.terms_pop_up);
        cancelButton = (ImageView)epicDialog.findViewById(R.id.cancelButton);
        agreeButton = (Button)epicDialog.findViewById(R.id.agreeButton);


        cancelButton.setOnClickListener(v -> {
            epicDialog.dismiss();
            Toast.makeText(getApplicationContext(),"You have to agree in order to proceed",Toast.LENGTH_LONG).show();
        });
        agreeButton.setOnClickListener(v -> {
            account();
           //validate();
        });
        Objects.requireNonNull(epicDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();

    }
    public void createUser(){
        String Email = email.getText().toString().trim();
        String password = Password.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(this, task -> {
            Log.d("user error",mAuth.toString());

            if(task.isSuccessful()){
                //if user creation was successful
                //accountInformation();
                
               final loading loading = new loading(RegistrationActivity.this);
               loading.startLoadingDialog();
               Toast.makeText(getApplicationContext(),"Registration successful",Toast.LENGTH_SHORT).show();
               startActivity(new Intent(RegistrationActivity.this,LandlordsActivity.class));
            }else {
                Toast.makeText(getApplicationContext(),"Unable to create user ",Toast.LENGTH_LONG).show();
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
    public void initAccountUi(){
       // epicDialog.setContentView(R.layout.account_information);
       // exit = (ImageView)epicDialog.findViewById(R.id.exit);
        account = (EditText)findViewById(R.id.account);
        bill = (EditText)findViewById(R.id.Bill);
      //  submit = (Button)epicDialog.findViewById(R.id.submit);
       // epicDialog.show();
    }
    public void accountInformation(){
        initAccountUi();
        String accountNumber = account.getText().toString().trim();
        String payBillNumber = bill.getText().toString().trim();
        String Surname = surname.getText().toString().trim();
        String phone = phoneNumber.getText().toString().trim();

        //removing the dialog
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Landlord");
                String id = reference.push().getKey();
                SmartModel t = new SmartModel(id,payBillNumber,accountNumber,Surname,phone);
                reference.child(id).setValue(t);
                createUser();
            }
        });
    }

    public void account(){
        initAccountUi();
        String accountNumber = account.getText().toString().trim();
        String payBillNumber = bill.getText().toString().trim();
        String Surname = surname.getText().toString().trim();
        String phone = phoneNumber.getText().toString().trim();

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Landlord");
        String id = reference.push().getKey();
        SmartModel t = new SmartModel(id,payBillNumber,accountNumber,Surname,phone);
        reference.child(id).setValue(t);
        createUser();


    }

    @Override
    public void finish() {
        super.finish();
    }
}
