package com.example.smartestate;

public class SmartModel {
    private String EstateName,Surname,blockNumber,password,confirmPassword,email,phoneNumber;
    private int houseNumber;

    public SmartModel(){

    }

    public SmartModel(String estateName, String surname, String blockNumber, String password,String email ,String confirmPassword, int houseNumber, String phoneNumber) {
        EstateName = estateName;
        Surname = surname;
        this.blockNumber = blockNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.houseNumber = houseNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public SmartModel(String surname,String EstateName,String email, String phoneNumber){
        this.Surname = surname;
        this.EstateName = EstateName;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
