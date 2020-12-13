package com.example.smartestate;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static android.app.Activity.RESULT_OK;

public class rentFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton floatingActionButton;
    private Dialog addBuildingDialog;
    private ImageView close,imageOfEstate;
    private EditText nameEstate, nameBuilding, estate,PhoneNumber,capacityPicker;
    private Button newBuilding, uploadPicture;
    private ImageButton takePicture;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private FirebaseAuth mAuth;
    private Uri imageUri;
    private StorageReference mStorageRef;
    private String id;
    private String user_image_path;
    private ProgressBar mProgressBar;
    private static final int IMAGE_PICK_CODE=1000;
    private static final int PERMISSION_CODE=1003;
    private static final int REQUEST_IMAGE_CAPTURE=2;
    private static final int IMAGE_CAPTURE_CODE=2001;
    private static final int IMAGE_REQUEST=2;

    public rentFragment() {
    }

    ArrayList<recyclerItems>items = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = LayoutInflater.from(getContext()).inflate(R.layout.rent_fragment,container,false);
       addBuildingDialog = new Dialog(Objects.requireNonNull(getContext()));
       floatingActionButton = (FloatingActionButton)v.findViewById(R.id.addBuilding);

       floatingActionButton.setOnClickListener(v1 -> addBuilding());
        mRecyclerView = v.findViewById(R.id.rentRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new RecyclerViewAdapter(items);
        mAuth=FirebaseAuth.getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference();

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }
    //customize the add building dialog
    public void addBuilding(){
        //initializing UI items
        addBuildingDialog.setContentView(R.layout.add_building_dialog);
        close = (ImageView)addBuildingDialog.findViewById(R.id.close);
        imageOfEstate = (ImageView)addBuildingDialog.findViewById(R.id.imageOfEstate);
        uploadPicture = (Button)addBuildingDialog.findViewById(R.id.uploadPicture);
        takePicture = (ImageButton)addBuildingDialog.findViewById(R.id.takePicture);
        estate = (EditText)addBuildingDialog.findViewById(R.id.estate);
        nameEstate = (EditText)addBuildingDialog.findViewById(R.id.nameEstate);
        nameBuilding = (EditText)addBuildingDialog.findViewById(R.id.nameBuilding);
        PhoneNumber = (EditText)addBuildingDialog.findViewById(R.id.PhoneNumber);
        capacityPicker = (EditText) addBuildingDialog.findViewById(R.id.capacityPicker);
        newBuilding = (Button)addBuildingDialog.findViewById(R.id.newBuilding);

       // newBuilding.setOnClickListener(view -> addItems());
        newBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addItems();
               addBuildingDialog.dismiss();
            }
        });


        close.setOnClickListener(v -> addBuildingDialog.dismiss());
        takePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
              //   openCamera();
            }
        });

        uploadPicture.setOnClickListener(view -> {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
               if (ContextCompat.checkSelfPermission(Objects.requireNonNull(getActivity()),Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){
                   String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
                   requestPermissions(permission,PERMISSION_CODE);
               }else{
                   //uploadImage();
                   takeImageFromGallery();

               }

            }else{
               // uploadImage();
                takeImageFromGallery();
            }
        });
        Objects.requireNonNull(addBuildingDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        addBuildingDialog.show();
    }

    public void checkPermission(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(Objects.requireNonNull(getActivity()),Manifest.permission.CAMERA)==PackageManager.PERMISSION_DENIED||
                    ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){
                String[] permission = {Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permission,PERMISSION_CODE);
            }else{
                openCamera();
            }
        }else{
            openCamera();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
       switch (requestCode){
           case PERMISSION_CODE:{
               if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                   takeImageFromGallery();
                    openCamera();
               }else{
                   Toast.makeText(getContext(), "Permission denied!..", Toast.LENGTH_SHORT).show();
               }
           }
       }

    }
    //taking an image from the gallery
    public void takeImageFromGallery(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE_PICK_CODE);

    }
    public void openCamera(){
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"New picture");
        values.put(MediaStore.Images.Media.DESCRIPTION,"From the camera");

        imageUri = getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(cameraIntent,IMAGE_CAPTURE_CODE);


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==IMAGE_CAPTURE_CODE&&resultCode==RESULT_OK){
                imageOfEstate.setImageURI(imageUri);
//                getFileExtension(imageUri);
//                uploadImage();
//                getFileExtension(imageUri);
//                uploadImage();
               // uploadImage();
        }
        if(requestCode==IMAGE_PICK_CODE&&resultCode==RESULT_OK){
//               Bundle extras = data.getExtras();
//               Bitmap imageBitMap = (Bitmap)extras.get("data");
//               imageOfEstate.setImageBitmap(imageBitMap);
//               imageUri = data.getData();
               imageOfEstate.setImageURI(data.getData());
               
//               imageUri = data.getData();
//               getFileExtension(imageUri);
//               uploadImage();

               //uploadImage();
        }
    }




    //this method is meant to add items to the card items
    public void addItems(){
        //Bitmap tenantImage = imageOfEstate.getDrawable();
        String nameOfEstate = estate.getText().toString();
        String tenantName = nameEstate.getText().toString();
        String block = nameBuilding.getText().toString();
        String phoneNumber = PhoneNumber.getText().toString();
        String houseNumber = capacityPicker.getText().toString();


        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Tenant");
        id = reference.child("Tenant").push().getKey();
        recyclerItems tenant = new recyclerItems(id,nameOfEstate,tenantName,block,phoneNumber,houseNumber);
        reference.child(id).setValue(tenant);

        reference.child(id).child("Landlord").child(mAuth.getCurrentUser().getUid()).setValue(mAuth.getCurrentUser().getEmail());


    }
    private String getFileExtension(Uri uri){
        ContentResolver contentResolver = getActivity().getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }
    private void uploadImage(){
        if(imageUri!=null){
            StorageReference fileRef = mStorageRef.child(System.currentTimeMillis()+"."+getFileExtension(imageUri));
            fileRef.putFile(imageUri)
                    .addOnSuccessListener(taskSnapshot -> {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mProgressBar.setProgress(0);
                            }
                        },2000);
                        Toast.makeText(getContext(),"upload successful",Toast.LENGTH_SHORT).show();
                        recyclerItems tenant = new recyclerItems(nameEstate.getText().toString().trim(),
                                fileRef.getDownloadUrl().toString());
                        String uploadid = reference.push().getKey();
                        reference.child(id).child(uploadid).setValue(tenant);
                    })
                    .addOnFailureListener(e -> Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show())
                    .addOnProgressListener(snapshot -> {
                        double progress = (100.0*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                        mProgressBar.setProgress((int)progress);

                    });
        }else{
            Toast.makeText(getContext(),"No file selected",Toast.LENGTH_SHORT).show();
        }
    }
}
