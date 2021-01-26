package com.arashivision.onecamera;

import com.arashivision.onecamera.cameraresponse.TakePictureResponse;
import com.arashivision.onecamera.cameraresponse.VideoResult;

public interface OneCallbacks {
    void onDetached();

    void onError(int i2, int i3, String str);

    void onOpenComplete();

    void onPhotoCaptured(int i2, String str);

    void onRecordComplete(RecordType recordType, String str);

    void onRecordError(int i2, RecordType recordType, String str);

    void onRecordVideoStateNotify(int i2, VideoResult videoResult);

    void onScreenCapture(int i2, String str);

    void onStillImageCaptured(int i2, String str);

    void onStillImageWithStorageNotify(TakePictureResponse takePictureResponse);

    void onTimelapseNotify(int i2, VideoResult videoResult);

    void onUsbSpeedTest(String str);

    void onUsbState(int i2, int i3);
}
