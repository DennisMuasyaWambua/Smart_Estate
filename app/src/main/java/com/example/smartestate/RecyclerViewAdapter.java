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
        public ImageView mEstateImage;
        public TextView buildingName, rentTotal, total, totalDue, amountDue;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mEstateImage = itemView.findViewById(R.id.estateImage);
            buildingName = itemView.findViewById(R.id.buildingName);
            rentTotal = itemView.findViewById(R.id.rentTotal);
            total = itemView.findViewById(R.id.total);
            totalDue = itemView.findViewById(R.id.totalDue);
            amountDue = itemView.findViewById(R.id.amountDue);

        }
    }
    public RecyclerViewAdapter(ArrayList<recyclerItems>recyclerItems){
        mRecyclerItems = recyclerItems;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_rent_fragment_items, parent, false);
       RecyclerViewHolder rvh = new RecyclerViewHolder(v);
       return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        recyclerItems currentItems = mRecyclerItems.get(position);
        holder.mEstateImage.setImageResource(currentItems.getmEstateImage());
        holder.buildingName.setText(currentItems.getmBuildingName());
        holder.rentTotal.setText(currentItems.getmTotalAmount());
        holder.total.setText(currentItems.getmTotal());
        holder.totalDue.setText(currentItems.getmTotalDue());
    }

    @Override
    public int getItemCount() {
        return mRecyclerItems.size();
    }
}
