package com.example.smartestate;

public class recyclerItems {
    private int mEstateImage, mTotalAmount, mTotalDue;
    private String mTotal, mDue, mBuildingName, mEstateName;

    public String getmBuildingName() {
        return mBuildingName;
    }



    public recyclerItems(String mBuildingName,int mTotalAmount,String mEstateName,int mEstateImage,  int mTotalDue){
            this.mEstateImage = mEstateImage;
            this.mTotalAmount = mTotalAmount;
            this.mTotalDue = mTotalDue;
            this.mBuildingName = mBuildingName;
            this.mEstateName = mEstateName;
        }

    public int getmEstateImage() {
        return mEstateImage;
    }

    public void setmBuildingName(String mBuildingName) {
        this.mBuildingName = mBuildingName;
    }

    public void setmEstateImage(int mEstateImage) {
        this.mEstateImage = mEstateImage;
    }

    public int getmTotalAmount() {
        return mTotalAmount;
    }

    public void setmTotalAmount(int mTotalAmount) {
        this.mTotalAmount = mTotalAmount;
    }

    public int getmTotalDue() {
        return mTotalDue;
    }

    public void setmTotalDue(int mTotalDue) {
        this.mTotalDue = mTotalDue;
    }

    public String getmTotal() {
        return mTotal;
    }

    public void setmTotal(String mTotal) {
        this.mTotal = mTotal;
    }

    public String getmDue() {
        return mDue;
    }

    public void setmDue(String mDue) {
        this.mDue = mDue;
    }

    public String getmEstateName() {
        return mEstateName;
    }

    public void setmEstateName(String mEstateName) {
        this.mEstateName = mEstateName;
    }
}
