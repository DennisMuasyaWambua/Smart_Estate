package com.example.smartestate;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.RecyclerViewHolder>{
    private ArrayList<recyclerItems>mRecyclerItems;
    Context mContext;


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        public TextView  mTenant, mEstateName, mBlockNumber, mHouseNumber;
        public ImageView tenantImage;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mTenant = (TextView) itemView.findViewById(R.id.buildingName);
            mEstateName =(TextView) itemView.findViewById(R.id.EstateName);
            mBlockNumber = (TextView) itemView.findViewById(R.id.rentTotal);
            mHouseNumber = (TextView) itemView.findViewById(R.id.totalDue);
            tenantImage = (ImageView) itemView.findViewById(R.id.tenantImage);

        }
    }
    public RecyclerViewAdapter(Context context,ArrayList<recyclerItems>recyclerItems){
        mContext = context;
        mRecyclerItems = recyclerItems;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_rent_fragment_items,parent,false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        recyclerItems currentItem = mRecyclerItems.get(position);
        holder.mTenant.setText(currentItem.getTenant());
        holder.mEstateName.setText(currentItem.getEstate());
        holder.mBlockNumber.setText(currentItem.getBlock());
        holder.mHouseNumber.setText(currentItem.getHouseNumber());

        Picasso.get().load(currentItem.getImageUrl()).fit().into(holder.tenantImage);

    }

    @Override
    public int getItemCount() {
        return  mRecyclerItems.size();
    }
}
