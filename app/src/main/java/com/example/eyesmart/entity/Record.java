package com.example.eyesmart.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Record implements Serializable {
    private String deviceid;
    private Employee employee;
    private byte[] photo;
    private String recordId;
    private String time;

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Record{recordId='" + this.recordId + '\'' + ", time='" + this.time + '\'' +
                ", deviceid='" + this.deviceid + '\'' + ", photo=" + Arrays.toString(this.photo) +
                ", employee=" + this.employee + '}';

    }
}
