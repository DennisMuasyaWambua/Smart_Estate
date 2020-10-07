package com.example.smartestate;

import android.graphics.Bitmap;

public class recyclerItems {
    private Bitmap tenantImage;
    private int houseNumber;
   private String estate, tenant, block, phone;

   public recyclerItems(Bitmap tenantImage, String estate, String tenant, String block, String phone, int houseNumber){
       this.tenantImage = tenantImage;
       this.estate = estate;
       this.tenant = tenant;
       this.block = block;
       this.phone = phone;
       this.houseNumber=houseNumber;
   }

    public Bitmap getTenantImage() {
        return tenantImage;
    }

    public void setTenantImage(Bitmap tenantImage) {
        this.tenantImage = tenantImage;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
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
}
