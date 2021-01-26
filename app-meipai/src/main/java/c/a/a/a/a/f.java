package c.a.a.a.a;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.insta360.basecamera.camera.BaseCamera.CameraStatus;
import com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureType;

public interface f {
    void onCameraAuthorizationStateChanged(BaseCamera baseCamera, int i2);

    void onCameraBatteryLow(BaseCamera baseCamera);

    void onCameraBatteryUpdate(BaseCamera baseCamera);

    void onCameraCaptureFinish(BaseCamera baseCamera, CaptureType captureType);

    void onCameraSDCardStateChanged(BaseCamera baseCamera, int i2, int i3);

    void onCameraStatusChanged(BaseCamera baseCamera, CameraStatus cameraStatus, int i2);

    void onCameraStorageChanged(BaseCamera baseCamera);

    void onCameraTemperatureChanged(BaseCamera baseCamera);
}
