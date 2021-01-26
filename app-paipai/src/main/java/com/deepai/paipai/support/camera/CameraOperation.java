package com.deepai.paipai.support.camera;

import android.graphics.Bitmap;
import android.hardware.Camera.PictureCallback;
import com.deepai.paipai.support.camera.CameraContainer.TakePictureListener;
import com.deepai.paipai.support.camera.CameraView.FlashMode;

public interface CameraOperation {
    FlashMode getFlashMode();

    int getMaxZoom();

    int getZoom();

    void setFlashMode(FlashMode flashMode);

    void setZoom(int i);

    boolean startRecord();

    void stopCamera();

    Bitmap stopRecord();

    void switchCamera();

    void takePicture(PictureCallback pictureCallback, TakePictureListener takePictureListener);
}
