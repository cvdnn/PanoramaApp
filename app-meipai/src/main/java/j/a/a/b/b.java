package j.a.a.b;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.sdkcamera.camera.callback.ICameraChangedCallback;

/* compiled from: lambda */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ICameraChangedCallback f9916a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ BaseCamera f9917b;

    public /* synthetic */ b(ICameraChangedCallback iCameraChangedCallback, BaseCamera baseCamera) {
        this.f9916a = iCameraChangedCallback;
        this.f9917b = baseCamera;
    }

    public final void run() {
        this.f9916a.onCameraBatteryUpdate(this.f9917b.getBatteryLevel(), this.f9917b.isCharging());
    }
}
