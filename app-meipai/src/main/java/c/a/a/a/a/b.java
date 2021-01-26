package c.a.a.a.a;

import com.arashivision.camera.listener.ICameraRecordListener;
import com.arashivision.insta360.basecamera.camera.BaseCamera.CaptureStatus;
import com.arashivision.insta360.basecamera.camera.BaseCameraController;
import com.arashivision.insta360.basecamera.log.CameraLogger;
import com.arashivision.onecamera.cameraresponse.VideoResult;
import e.a.a.a.a;

public class b implements ICameraRecordListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ BaseCameraController f1117a;

    public b(BaseCameraController baseCameraController) {
        this.f1117a = baseCameraController;
    }

    public void onDriverRecordVideoStateNotify(int i2, VideoResult videoResult) {
        CameraLogger cameraLogger = BaseCameraController.OoooOOo;
        StringBuilder a2 = a.a("onDriverRecordVideoStateNotify, state: ", i2, ", errorCode: ");
        a2.append(videoResult.error_code);
        a2.append(", path: ");
        a2.append(videoResult.video.uri);
        cameraLogger.d(a2.toString());
        if (i2 == 0) {
            BaseCameraController baseCameraController = this.f1117a;
            if (baseCameraController.OooOoo == CaptureStatus.STARTING) {
                baseCameraController.OooO00o(baseCameraController.OooOoo0, Integer.valueOf(0), (Integer) null);
            }
        } else if (i2 == 1 || i2 == 2 || i2 == 3) {
            BaseCameraController baseCameraController2 = this.f1117a;
            baseCameraController2.OooOooo = baseCameraController2.OooO00o(videoResult.video.uri);
            this.f1117a.Oooo000 = Integer.valueOf(videoResult.error_code);
            this.f1117a.OooOoOO();
        }
    }
}
