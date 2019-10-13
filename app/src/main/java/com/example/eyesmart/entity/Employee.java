package com.example.eyesmart.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Employee implements Serializable {
    public static final String FEMALE = "0";
    public static final String MALE = "1";
    public String code;
    public String empBirth;
    public String empGroupCode;
    public String empGroupName;
    public String empno;
    private byte[] faceFeature;
    private  String idcard;
    private  boolean isAdministrator;
    private  String name;
    private byte[] photo;
    private String sex;
    private String telephone;
    private String userId;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmpBirth() {
        return empBirth;
    }

    public void setEmpBirth(String empBirth) {
        this.empBirth = empBirth;
    }

    public String getEmpGroupCode() {
        return empGroupCode;
    }

    public void setEmpGroupCode(String empGroupCode) {
        this.empGroupCode = empGroupCode;
    }

    public String getEmpGroupName() {
        return empGroupName;
    }

    public void setEmpGroupName(String empGroupName) {
        this.empGroupName = empGroupName;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public byte[] getFaceFeature() {
        return faceFeature;
    }

    public void setFaceFeature(byte[] faceFeature) {
        this.faceFeature = faceFeature;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "Employee{userId=" +
                this.userId + ", name='" + this.name + '\'' + ", sex='" + this.sex + '\'' +
                ", idcard='" + this.idcard + '\'' + ", empno='" + this.empno + '\'' + ", code='" +
                this.code + '\'' + ", telephone='" + this.telephone + '\'' + ", isAdministrator=" +
                this.isAdministrator + ", photo=" + Arrays.toString(this.photo) + '}';

    }
}

