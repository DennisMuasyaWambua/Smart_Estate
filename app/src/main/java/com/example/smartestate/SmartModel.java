package com.example.smartestate;

public class SmartModel {
     String EstateName,Surname,email,blockNumber,password,confirmPassword,phoneNumber,landlordId;
     int houseNumber, payBill, accountNumber;

    public SmartModel(){

    }


    public SmartModel(String landlordId,String surname,String EstateName,String email, String phoneNumber, int accountNumber, int payBill){
        this.landlordId = landlordId;
        this.Surname = surname;
        this.EstateName = EstateName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.payBill = payBill;
    }


    public String getEstateName() {
        return EstateName;
    }

    public void setEstateName(String estateName) {
        EstateName = estateName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
