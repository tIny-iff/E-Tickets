package com.e_tickets.e_ticketingsystem;

/**
 * Created by Kerrs Unit on 23/03/2018.
 */

public class Offenderclass {

    private String email;

    private String f_name;

    private String l_name;

    private  String TRN;

    private int licensePL_num;

    private String W_Status;

    private String gender;

    private String phone_num;

    private String address;

    private String Location;



    public Offenderclass(String fname,String lname,String email, String trn, int License, String warrant_S, String Gender, String Phone_num, String Address, String locate) {
        this.f_name=fname;
        this.l_name=lname;
        this.email = email;
        this.Location = locate;

        this.address=Address;
        this.TRN=trn;
        this.licensePL_num=License;
        this.W_Status=warrant_S;
        this.gender=Gender;
        this.phone_num=Phone_num;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
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

    public int getLicensePL_num() {
        return licensePL_num;
    }

    public void setLicensePL_num(int license_num) {
        this.licensePL_num = license_num;
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

