package com.example.smartestate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class occupancyFragment extends Fragment {
    private ImageView buildingImage;
    private TextView NameEstate, Occupied, amountOccupied, Vacant, amountVacant;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.occupancy_fragment,container,false);
        buildingImage = (ImageView)v.findViewById(R.id.buildingImage);
        NameEstate = (TextView)v.findViewById(R.id.NameEstate);
        Occupied = (TextView)v.findViewById(R.id.Occupied);
        amountOccupied = (TextView)v.findViewById(R.id.amountOccupied);
        Vacant = (TextView)v.findViewById(R.id.vacant);
        amountVacant = (TextView)v.findViewById(R.id.amountVacant);

        

        return v;

    }
}
