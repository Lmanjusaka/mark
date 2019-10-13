//
// Created by liuchen on 2019/7/31.
//

#include <jni.h>
#include <string>
#include <stdio.h>
#include "com_example_arclibrary_util_JNIUtils.h"
JNIEXPORT jstring JNICALL Java_com_example_arclibrary_util_JNIUtils_getStringFromNative
  (JNIEnv *env, jclass jniclass){
    char buf[16];
    FILE *led = fopen("/dev/smy_drv","w");
    if(led != nullptr){
        fwrite(buf,1, sizeof(buf),led);
        fclose(led);
        led = nullptr;

    }


  return env->NewStringUTF("SEND 1");
  }