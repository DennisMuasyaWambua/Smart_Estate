package com.example.smartestate;

public class SmartModel {
     String Surname,email,blockNumber,password,confirmPassword,phoneNumber,landlordId ,payBill, accountNumber;





    public SmartModel(String landlordId,String payBill,String accountNumber,String surname, String phoneNumber){
        this.landlordId = landlordId;
        this.Surname = surname;
        this.accountNumber = accountNumber;
        this.payBill=payBill;
        this.phoneNumber = phoneNumber;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(String landlordId) {
        this.landlordId = landlordId;
    }

    public String getPayBill() {
        return payBill;
    }

    public void setPayBill(String payBill) {
        this.payBill = payBill;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
