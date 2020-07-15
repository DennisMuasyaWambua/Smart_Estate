package com.example.smartestate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ImageView;

public class PaymentsActivity extends AppCompatActivity {
    private ImageView estateImageView, profileImageView;
    private CardView rentBalanceCard, serviceChargeBalanceCard, loanBalanceCard, rentPaymentCard, serviceChargePaymentCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        estateImageView = (ImageView)findViewById(R.id.estateImageView);
        profileImageView = (ImageView)findViewById(R.id.profileImageView);
        rentBalanceCard = (CardView)findViewById(R.id.rentBalanceCard);
        serviceChargeBalanceCard = (CardView)findViewById(R.id.serviceChargeBalanceCard);
        loanBalanceCard = (CardView)findViewById(R.id.loanBalanceCard);
        rentPaymentCard = (CardView)findViewById(R.id.rentPaymentCard);
        serviceChargePaymentCard = (CardView)findViewById(R.id.serviceChargePaymentCard);


    }
}