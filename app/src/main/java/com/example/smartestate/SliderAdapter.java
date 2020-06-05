package com.example.smartestate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    private Context mContext;
    private LayoutInflater inflater;

    public int[]imagesArray = {R.drawable.key,R.drawable.handshake,R.drawable.office,R.drawable.millenials};
    public String[]titlesArray = {"Smart Estate", "You are a ?", " You manage?", "Terms and conditions"};
    public String[]descriptionArray = {"Welcome to smart estate Kenya's first digital Property Management app"
                                        ,"Tenant or landlord"
                                        ,"Rentals or Student Accommodation"
                                        ,"By signing up you agree to Smart estate's flat rate charge of 6% per transactions for running costs and operations of the app"};
    public int[]backgroundColorArray = {R.color.yellow,R.color.oceanBlue,R.color.yellow};
    public SliderAdapter(Context mContext){
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return titlesArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater =  (LayoutInflater)mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        RelativeLayout relativeLayout = (RelativeLayout)view.findViewById(R.id.relativeLayout);
        ImageView slideImg = (ImageView)view.findViewById(R.id.slideImg);
        TextView txtTitle = (TextView)view.findViewById(R.id.txtTitle);
        TextView description = (TextView)view.findViewById(R.id.description);
        relativeLayout.setBackgroundColor(backgroundColorArray[position]);
        slideImg.setImageResource(imagesArray[position]);
        txtTitle.setText(titlesArray[position]);
        description.setText(descriptionArray[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
