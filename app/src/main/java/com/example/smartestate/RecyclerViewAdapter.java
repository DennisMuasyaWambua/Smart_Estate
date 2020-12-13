package com.example.smartestate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.RecyclerViewHolder>{
    private ArrayList<recyclerItems>mRecyclerItems;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        public TextView  mTenant, mEstateName, mBlockNumber, mHouseNumber;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mTenant = itemView.findViewById(R.id.buildingName);
            mEstateName = itemView.findViewById(R.id.EstateName);
            mBlockNumber = itemView.findViewById(R.id.rentTotal);
            mHouseNumber = itemView.findViewById(R.id.totalDue);
        }
    }
    public RecyclerViewAdapter(ArrayList<recyclerItems>recyclerItems){
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
    }

    @Override
    public int getItemCount() {
        return  mRecyclerItems.size();
    }
}
