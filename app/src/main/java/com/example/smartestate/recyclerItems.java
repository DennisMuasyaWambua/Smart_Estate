package com.example.smartestate;

import android.graphics.Bitmap;

public class recyclerItems {
   // private Bitmap tenantImage;
   private String estate, tenant, block, phone,id,houseNumber,imageUrl;

   public recyclerItems(){
       //empty constructor;
   }

   public recyclerItems(String imageUrl){

       this.imageUrl = imageUrl;
   }

   public recyclerItems(String id,String imageUrl,String estate, String tenant, String block, String phone, String houseNumber){
       this.id=id;
       this.imageUrl = imageUrl;
       this.estate = estate;
       this.tenant = tenant;
       this.block = block;
       this.phone = phone;
       this.houseNumber=houseNumber;

   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
