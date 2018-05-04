package com.e_tickets.e_ticketingsystem;



public class VehicleInfoClass {

private String Platenum;
private String vehicleType;
private String make;
private String model;
private String Owner;


   public  VehicleInfoClass(String platenum,String vehicletype,String Make, String Model, String owner)
   {
       this.Platenum=platenum;
       this.vehicleType=vehicletype;
       this.make=Make;
       this.model=Model;
       this.Owner=owner;
   }

   public VehicleInfoClass()
   {
       this.Platenum="";
       this.vehicleType="";
       this.make="";
       this.model="";
       this.Owner="";
   }

    public void setPlatenum(String platenum) {
        Platenum = platenum;
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
}
