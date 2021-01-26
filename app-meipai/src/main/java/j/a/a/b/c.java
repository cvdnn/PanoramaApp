package j.a.a.b;

import com.arashivision.sdkcamera.camera.callback.ICameraChangedCallback;

/* compiled from: lambda */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ICameraChangedCallback f9918a;

    public /* synthetic */ c(ICameraChangedCallback iCameraChangedCallback) {
        this.f9918a = iCameraChangedCallback;
    }

    public final void run() {
        this.f9918a.onCameraConnectError();
    }
}
