package com.example.smartestate;

public class SmartModel {
    private String EstateName,Surname,blockNumber,password,confirmPassword;
    private int houseNumber,phoneNumber;

    public SmartModel(){

    }

    public SmartModel(String estateName, String surname, String blockNumber, String password, String confirmPassword, int houseNumber, int phoneNumber) {
        EstateName = estateName;
        Surname = surname;
        this.blockNumber = blockNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.houseNumber = houseNumber;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
