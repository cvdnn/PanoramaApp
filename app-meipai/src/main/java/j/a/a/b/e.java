package j.a.a.b;

import com.arashivision.sdkcamera.camera.callback.ICameraChangedCallback;

/* compiled from: lambda */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ICameraChangedCallback f9921a;

    public /* synthetic */ e(ICameraChangedCallback iCameraChangedCallback) {
        this.f9921a = iCameraChangedCallback;
    }

    public final void run() {
        this.f9921a.onCameraBatteryLow();
    }
}
