package com.arashivision.camera.listener;

import com.arashivision.onecamera.cameraresponse.TakePictureResponse;
import com.arashivision.onecamera.cameraresponse.TakePictureWithoutStorageResponse;

public interface OnStillImageListener {
    void onDriverStillImageNotify(TakePictureResponse takePictureResponse);

    void onDriverStillImageWithoutStorageNotify(TakePictureWithoutStorageResponse takePictureWithoutStorageResponse);
}
