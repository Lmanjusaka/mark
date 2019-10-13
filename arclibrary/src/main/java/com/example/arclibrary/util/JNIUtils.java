package com.example.arclibrary.util;

public class JNIUtils {
    static {
        System.loadLibrary("MyJni");
    }
    public static native String getStringFromNative();
}
