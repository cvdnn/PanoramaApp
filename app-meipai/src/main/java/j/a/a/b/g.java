package j.a.a.b;

import android.os.Handler;
import android.os.Looper;
import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.insta360.basecamera.camera.BaseCamera.CameraStatus;
import com.arashivision.insta360.basecamera.camera.SimpleCameraChangedCallback;
import com.arashivision.sdkcamera.camera.InstaCameraManager;
import com.arashivision.sdkcamera.camera.callback.ICameraChangedCallback;

public class g extends SimpleCameraChangedCallback {

    /* renamed from: a reason: collision with root package name */
    public Handler f9925a = new Handler(Looper.getMainLooper());

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ InstaCameraManager f9926b;

    public g(InstaCameraManager instaCameraManager) {
        this.f9926b = instaCameraManager;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ICameraChangedCallback iCameraChangedCallback, boolean z) {
        iCameraChangedCallback.onCameraStatusChanged(z);
        if (z) {
            iCameraChangedCallback.onCameraSDCardStateChanged(this.f9926b.isSdCardEnabled());
            iCameraChangedCallback.onCameraStorageChanged(this.f9926b.getCameraStorageFreeSpace(), this.f9926b.getCameraStorageTotalSpace());
            iCameraChangedCallback.onCameraBatteryUpdate(this.f9926b.getCameraCurrentBatteryLevel(), this.f9926b.isCameraCharging());
        }
    }

    public void onCameraBatteryLow(BaseCamera baseCamera) {
        super.onCameraBatteryLow(baseCamera);
        for (ICameraChangedCallback iCameraChangedCallback : this.f9926b.f255) {
            Handler handler = this.f9925a;
            iCameraChangedCallback.getClass();
            handler.post(new e(iCameraChangedCallback));
        }
    }

    public void onCameraBatteryUpdate(BaseCamera baseCamera) {
        super.onCameraBatteryUpdate(baseCamera);
        for (ICameraChangedCallback bVar : this.f9926b.f255) {
            this.f9925a.post(new b(bVar, baseCamera));
        }
    }

    public void onCameraSDCardStateChanged(BaseCamera baseCamera, int i2, int i3) {
        super.onCameraSDCardStateChanged(baseCamera, i2, i3);
        boolean z = true;
        boolean z2 = i2 == 0;
        if (i3 != 0) {
            z = false;
        }
        if (z2 ^ z) {
            for (ICameraChangedCallback aVar : this.f9926b.f255) {
                this.f9925a.post(new a(aVar, z));
            }
        }
    }

    public void onCameraStatusChanged(BaseCamera baseCamera, CameraStatus cameraStatus, int i2) {
        super.onCameraStatusChanged(baseCamera, cameraStatus, i2);
        boolean z = true;
        boolean z2 = cameraStatus == CameraStatus.READY;
        if (baseCamera.getCameraStatus() != CameraStatus.READY) {
            z = false;
        }
        if (z2 ^ z) {
            for (ICameraChangedCallback fVar : this.f9926b.f255) {
                this.f9925a.post(new f(this, fVar, z));
            }
        }
        if (baseCamera.getCameraStatus() == CameraStatus.ERROR) {
            for (ICameraChangedCallback iCameraChangedCallback : this.f9926b.f255) {
                Handler handler = this.f9925a;
                iCameraChangedCallback.getClass();
                handler.post(new c(iCameraChangedCallback));
            }
        }
    }

    public void onCameraStorageChanged(BaseCamera baseCamera) {
        super.onCameraStorageChanged(baseCamera);
        for (ICameraChangedCallback dVar : this.f9926b.f255) {
            this.f9925a.post(new d(dVar, baseCamera));
        }
    }
}
