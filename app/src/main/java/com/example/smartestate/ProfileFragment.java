package com.example.smartestate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
     CardView LandLordHeader;
     CardView TenantsCard;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile,container,false);
        LandLordHeader = (CardView)v.findViewById(R.id.LandLordHeader);
        TenantsCard = (CardView)v.findViewById(R.id.TenantsCard);
        LandLordHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),LandlordloginActivity.class));
            }
        });
        TenantsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),loginActivity.class));
            }
        });
        return v;
    }
}
