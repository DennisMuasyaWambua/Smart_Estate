package com.example.smartestate;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

import static android.app.Activity.RESULT_OK;

public class rentFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton floatingActionButton;
    private Dialog addBuildingDialog;
    private ImageView close,imageOfEstate;
    private EditText nameEstate, nameBuilding, estate,PhoneNumber,unitOnePrice, unitTwoPrice, unitThreePrice, unitFourPrice;
    private NumberPicker capacityPicker;
    private Button newBuilding, uploadPicture;
    private ImageButton takePicture;
    private Spinner unitOne, unitTwo, unitThree, unitFour;
    private static final int IMAGE_PICK_CODE=1000;
    private static final int PERMISSION_CODE=1001;
    private static final int REQUEST_IMAGE_CAPTURE=1;

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
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new RecyclerViewAdapter(items);


        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }
    //customize the add building dialog
    public void addBuilding(){
        addBuildingDialog.setContentView(R.layout.add_building_dialog);
        close = (ImageView)addBuildingDialog.findViewById(R.id.close);
        imageOfEstate = (ImageView)addBuildingDialog.findViewById(R.id.imageOfEstate);
        uploadPicture = (Button)addBuildingDialog.findViewById(R.id.uploadPicture);
        takePicture = (ImageButton)addBuildingDialog.findViewById(R.id.takePicture);
        estate = (EditText)addBuildingDialog.findViewById(R.id.estate);
        nameEstate = (EditText)addBuildingDialog.findViewById(R.id.nameEstate);
        nameBuilding = (EditText)addBuildingDialog.findViewById(R.id.nameBuilding);
        PhoneNumber = (EditText)addBuildingDialog.findViewById(R.id.PhoneNumber);
        capacityPicker = (NumberPicker)addBuildingDialog.findViewById(R.id.capacityPicker);
        newBuilding = (Button)addBuildingDialog.findViewById(R.id.newBuilding);

        newBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItems();
            }
        });


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBuildingDialog.dismiss();
            }
        });
        takePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();
            }
        });

        uploadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                   if (ContextCompat.checkSelfPermission(Objects.requireNonNull(getActivity()),Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){
                       String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
                       requestPermissions(permission,PERMISSION_CODE);
                   }else{
                       takeImageFromGallery();
                   }

                }else{
                    takeImageFromGallery();
                }
            }
        });
        Objects.requireNonNull(addBuildingDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        capacityPicker.setMinValue(1);
        capacityPicker.setMaxValue(100);
        capacityPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                capacityPicker.getValue();
            }
        });
        addBuildingDialog.show();
    }

    public void checkPermission(){
        if(ContextCompat.checkSelfPermission(Objects.requireNonNull(getActivity()),Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
            String[] permission = {Manifest.permission.CAMERA};
            requestPermissions(permission,PERMISSION_CODE);
        }else{
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            checkPermission();
        }else{
            Toast.makeText(getContext(),"permission denied",Toast.LENGTH_SHORT).show();
        }

        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                takeImageFromGallery();
            }else{
                Toast.makeText(getContext(), "Permission denied....!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_IMAGE_CAPTURE&&resultCode==RESULT_OK){
            assert data != null;
            Bundle extras = data.getExtras();
            assert extras != null;
            Bitmap photo = (Bitmap)extras.get("data");
            imageOfEstate.setImageBitmap(photo);
            imageOfEstate.setImageURI(data.getData());
        }
        assert data != null;
        imageOfEstate.setImageURI(data.getData());

    }
    //taking an image from the gallery
    public void takeImageFromGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE_PICK_CODE);
    }

    //this method is meant to add items to the card items
    public void addItems(){
        Bitmap tenantImage = imageOfEstate.getDrawable();
        String nameOfEstate = estate.getText().toString();
        String tenantName = nameEstate.getText().toString();
        String block = nameBuilding.getText().toString();
        String phoneNumber = PhoneNumber.getText().toString();
        int houseNumber = capacityPicker.getValue();

        items.add(new recyclerItems(tenantImage,nameOfEstate,tenantName,block,phoneNumber,houseNumber));
    }
}
