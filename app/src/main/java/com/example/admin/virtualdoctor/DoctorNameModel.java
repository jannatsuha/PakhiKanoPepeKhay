package com.example.admin.virtualdoctor;

public class DoctorNameModel {
    private String typeName;
    private int image;

    public DoctorNameModel(String typeName, int image) {
        this.typeName = typeName;
        this.image = image;
    }

    public DoctorNameModel() {
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
