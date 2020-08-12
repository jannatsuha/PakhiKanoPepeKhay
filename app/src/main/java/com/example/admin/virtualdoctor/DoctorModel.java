package com.example.admin.virtualdoctor;

public class DoctorModel {


    private String name ;
    private String degree ;
    private String position ;
    private String chamber ;
    private String chamberAddress ;
    private String phoneNo ;
    private String visitingTime ;
    private String VisitingFee ;


    public DoctorModel(String name, String degree, String position, String chamber, String chamberAddress, String phoneNo, String visitingTime, String visitingFee) {
        this.name = name;
        this.degree = degree;
        this.position = position;
        this.chamber = chamber;
        this.chamberAddress = chamberAddress;
        this.phoneNo = phoneNo;
        this.visitingTime = visitingTime;
        VisitingFee = visitingFee;
    }

    public DoctorModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public String getChamberAddress() {
        return chamberAddress;
    }

    public void setChamberAddress(String chamberAddress) {
        this.chamberAddress = chamberAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getVisitingTime() {
        return visitingTime;
    }

    public void setVisitingTime(String visitingTime) {
        this.visitingTime = visitingTime;
    }

    public String getVisitingFee() {
        return VisitingFee;
    }

    public void setVisitingFee(String visitingFee) {
        VisitingFee = visitingFee;
    }
}
