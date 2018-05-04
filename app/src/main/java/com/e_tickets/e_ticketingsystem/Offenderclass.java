package com.e_tickets.e_ticketingsystem;


import java.sql.Blob;

public class Offenderclass {

    private String email;
    private String OffenseCode;
    private String Platenum;
    private String vehicleType;
    private String make;
    private String model;
    private String Owner;

    private Blob Photo;

    private String Ticketnum;

    private String badgeNum;

    private String date;

    private String f_name;

    private String l_name;

    private  String TRN;

    private String Police_pass;

    private String OffenseCom;

    private int licensePL_num;

    private String W_Status;

    private String gender;

    private String phone_num;

    private String address;

    private String Mid_name;



    private String Location;

    private String FeeOffense;

    private String PointOffense;

    private int vehicleRegnum;

    private String Rank;

    private int points;

    private String Commuterpass;

    private int fees;



    public Offenderclass(String fname,String lname,String email, String trn, int License, String warrant_S, String Gender, String Phone_num,
                         String Address, String locate,int VehicleReg,int Points,int Fees,String feeOff,
                         String PointOff,String rank,Blob photo,String midname,String platenum,String vehicletype,
                         String Make,String Model,String owner,String ticketnum,String offenseCode,
                         String Date,String offenseCom,String police_pass,String commuterpass,String badgenum) {
        this.f_name=fname;
        this.OffenseCode=offenseCode;
        this.Ticketnum=ticketnum;
        this.Platenum=platenum;
        this.vehicleType=vehicletype;
        this.make=Make;
        this.model=Model;
        this.Owner=owner;
        this.Mid_name=midname;
        this.Photo=photo;
        this.Rank=rank;
        this.badgeNum=badgenum;
        this.Police_pass=police_pass;
        this.Commuterpass=commuterpass;
        this.OffenseCom=offenseCom;
        this.l_name=lname;
        this.email = email;
        this.Location = locate;
        this.vehicleRegnum=VehicleReg;
        this.address=Address;
        this.TRN=trn;
        this.licensePL_num=License;
        this.W_Status=warrant_S;
        this.gender=Gender;
        this.phone_num=Phone_num;
        this.points=Points;
        this.fees=Fees;
        this.FeeOffense=feeOff;
        this.PointOffense=PointOff;
        this.date=Date;
    }

    public Offenderclass()
    {
        this.Ticketnum="";
        this.OffenseCode="";
        this.f_name="";
        this.Platenum="";
        this.vehicleType="";
        this.make="";
        this.model="";
        this.Owner="";
        this.Mid_name="";
        this.OffenseCom="";
        this.Commuterpass="";
        this.Police_pass="";
        this.l_name="";
        this.Rank="";
        this.email = "";
        this.Location = "";
        this.vehicleRegnum=0;
        this.badgeNum="";
        this.address="";
        this.TRN="";
        this.licensePL_num=0;
        this.W_Status="";
        this.gender="";
        this.phone_num="";
        this.points=0;
        this.fees=0;
        this.FeeOffense="";
        this.PointOffense="";
        this.date="";
    }

    public String getOffenseCode() {
        return OffenseCode;
    }

    public void setOffenseCode(String offenseCode) {
        OffenseCode = offenseCode;
    }

    public void setPlatenum(String platenum) {
        Platenum = platenum;
    }

    public void setTicketnum(String ticketnum) {
        Ticketnum = ticketnum;
    }

    public String getTicketnum() {
        return Ticketnum;
    }

    public String getPlatenum() {
        return Platenum;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public Blob getPhoto() {
        return Photo;
    }

    public String getMid_name() {
        return Mid_name;
    }

    public void setMid_name(String mid_name) {
        Mid_name = mid_name;
    }

    public void setPhoto(Blob photo) {
        Photo = photo;
    }

    public String getPolice_pass() {
        return Police_pass;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public String getBadgeNum() {
        return badgeNum;
    }

    public void setBadgeNum(String badgeNum) {
        this.badgeNum = badgeNum;
    }

    public void setPolice_pass(String police_pass) {
        Police_pass = police_pass;
    }

    public void setCommuterpass(String commuterpass) {
        Commuterpass = commuterpass;
    }

    public String getCommuterpass() {
        return Commuterpass;
    }

    public String getOffenseCom() {
        return OffenseCom;
    }

    public void setOffenseCom(String offenseCom) {
        OffenseCom = offenseCom;
    }

    public String getFeeOffense() {
        return FeeOffense;
    }

    public void setFeeOffense(String feeOffense) {
        FeeOffense = feeOffense;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPointOffense() {
        return PointOffense;
    }

    public void setPointOffense(String pointOffense) {
        PointOffense = pointOffense;
    }

    public String getEmail() {
        return email;
    }

    public int getVehicleRegnum() {
        return vehicleRegnum;
    }

    public void setVehicleRegnum(int vehicleRegnum) {
        this.vehicleRegnum = vehicleRegnum;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
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

    public void setFname(String fname)
    {
        this.f_name=fname;
    }

    public String getF_name() {
        return f_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getL_name() {
        return l_name;
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

