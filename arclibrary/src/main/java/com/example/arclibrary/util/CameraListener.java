package com.example.arclibrary.util;

import android.hardware.Camera;

public interface CameraListener {
    /**
     * 当打开时执行
     * @param camera    相机实例
     * @param cameraId  相机ID
     * @param displayOrientation    相机预览角度
     * @param isMirror  是否镜像显示
     */

    void onCameraOpened(Camera camera, int cameraId, int displayOrientation, boolean isMirror);

    /**
     * 预览数据回调
     * @param data  预览数据
     * @param camera    相机实例
     */
    void onPreview(byte[] data, Camera camera);

    /**
     * 相机关闭时执行
     */
    void onCameraClosed();

    /**
     * 当出现异常时执行
     * @param e 相机相关异常
     */
    void onCameraError(Exception e);

    /**
     * 属性变化时调用
     * @param cameraID  相机ID
     * @param displayOrientaion    相机旋转方向
     */
    void onCameraConfigurationChanged(int cameraID, int displayOrientaion);
}
