package com.example.arclibrary.model;

public class FaceRegisterInfo {
    private byte[] featureData;
    private String name;

    public FaceRegisterInfo(byte[] featureData, String name) {
        this.featureData = featureData;
        this.name = name;
    }

    public byte[] getFeatureData() {
        return featureData;
    }

    public void setFeatureData(byte[] featureData) {
        this.featureData = featureData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
