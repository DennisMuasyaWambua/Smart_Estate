package com.example.smartestate;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class rentFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton floatingActionButton;
    private Dialog addBuildingDialog;
    private ImageView close,imageOfEstate;
    private EditText nameEstate, nameBuilding;
    private NumberPicker capacityPicker;
    private Button newBuilding, uploadPicture;
    private ImageButton takePicture;
    ArrayList<recyclerItems>items = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = LayoutInflater.from(getContext()).inflate(R.layout.rent_fragment,container,false);
       addBuildingDialog = new Dialog(Objects.requireNonNull(getContext()));
       floatingActionButton = (FloatingActionButton)v.findViewById(R.id.addBuilding);
       floatingActionButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                    addBuilding();
           }
       });
        mRecyclerView = v.findViewById(R.id.rentRecyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new RecyclerViewAdapter(items);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(mLayoutManager);
        return v;
    }

    public void addBuilding(){
        addBuildingDialog.setContentView(R.layout.add_building_dialog);
        close = (ImageView)addBuildingDialog.findViewById(R.id.close);
        imageOfEstate = (ImageView)addBuildingDialog.findViewById(R.id.imageOfEstate);
        uploadPicture = (Button)addBuildingDialog.findViewById(R.id.uploadPicture);
        takePicture = (ImageButton)addBuildingDialog.findViewById(R.id.takePicture);
        nameEstate = (EditText)addBuildingDialog.findViewById(R.id.nameEstate);
        nameBuilding = (EditText)addBuildingDialog.findViewById(R.id.nameBuilding);
        capacityPicker = (NumberPicker)addBuildingDialog.findViewById(R.id.capacityPicker);
        newBuilding = (Button)addBuildingDialog.findViewById(R.id.newBuilding);

        //listener to create a new recycler view item
        newBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBuildingDialog.dismiss();
            }
        });

        addBuildingDialog.show();

    }
}
