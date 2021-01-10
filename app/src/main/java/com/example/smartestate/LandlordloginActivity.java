package com.example.smartestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LandlordloginActivity extends AppCompatActivity {
   EditText eMail,passWord;
   TextView txtToSignUp;
    FirebaseAuth mAuth;
    Button Login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlordlogin);
        mAuth = FirebaseAuth.getInstance();

        eMail = (EditText) findViewById(R.id.eMail);
        passWord = (EditText) findViewById(R.id.passWord);
        txtToSignUp = (TextView) findViewById(R.id.textTosignup);
        Login = (Button)findViewById(R.id.welcome);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login(eMail.getText().toString(),passWord.getText().toString());
            }
        });
        txtToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandlordloginActivity.this,RegistrationActivity.class));
            }
        });
    }



    public void login(String email,String password){
        ProgressDialog pd = new ProgressDialog(LandlordloginActivity.this);
        pd.setMessage("Loging in..");
        pd.show();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    pd.dismiss();
                    startActivity(new Intent(LandlordloginActivity.this,LandlordsActivity.class));
                }else{Toast.makeText(LandlordloginActivity.this,"Unable to login ",Toast.LENGTH_SHORT).show();}
            }
        });
    }


}