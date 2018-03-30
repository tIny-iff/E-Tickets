package com.e_tickets.e_ticketingsystem;

/**
 * Created by Kerrs Unit on 23/03/2018.
 */

public class Offenderclass {

    private String email;

    private  String TRN;

    private int license_num;

    private String W_Status;

    private String gender;

    private String phone_num;

    private String address;

    public Offenderclass(String email, String trn, int License, String warrant_S, String Gender, String Phone_num, String Address) {
        this.email = email;
        this.address=Address;
        this.TRN=trn;
        this.license_num=License;
        this.W_Status=warrant_S;
        this.gender=Gender;
        this.phone_num=Phone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTRN() {
        return TRN;
    }

    public void setTRN(String TRN) {
        this.TRN = TRN;
    }

    public int getLicense_num() {
        return license_num;
    }

    public void setLicense_num(int license_num) {
        this.license_num = license_num;
    }

    public String getW_Status() {
        return W_Status;
    }

    public void setW_Status(String w_Status) {
        W_Status = w_Status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

