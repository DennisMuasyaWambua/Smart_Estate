package com.example.smartestate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class DashboardFragment extends Fragment implements View.OnClickListener{
    private CardView statementCard, paymentCard,suggestionsCard, servicesCard;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard,container, false);

        //initializing user interface elements
        statementCard = (CardView)v.findViewById(R.id.statementCard);
        paymentCard = (CardView)v.findViewById(R.id.paymentCard);
        suggestionsCard = (CardView)v.findViewById(R.id.suggestionsCard);
        servicesCard = (CardView)v.findViewById(R.id.servicesCard);

        //setting the click listeners to this fragment in particular
        statementCard.setOnClickListener(this);
        paymentCard.setOnClickListener(this);
        suggestionsCard.setOnClickListener(this);
        servicesCard.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.statementCard: intent = new Intent();startActivity(intent);break;
            case R.id.paymentCard: intent = new Intent();startActivity(intent);break;
            case R.id.suggestionsCard: intent = new Intent();startActivity(intent);break;
            case R.id.servicesCard:intent = new Intent();startActivity(intent);break;
            default:break;
        }
        
    }
}
