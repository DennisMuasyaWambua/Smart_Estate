package com.example.smartestate;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.smartestate.R;

public class loading {
    Activity myActivity;
    AlertDialog dialog;

    public loading(Activity myActivity){
        this.myActivity = myActivity;
    }

    void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(myActivity);
        LayoutInflater inflater = myActivity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog,null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }

    void dialogDismiss(){
        dialog.dismiss();
    }
}
