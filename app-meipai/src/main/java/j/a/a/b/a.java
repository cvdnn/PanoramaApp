package j.a.a.b;

import com.arashivision.sdkcamera.camera.callback.ICameraChangedCallback;

/* compiled from: lambda */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ICameraChangedCallback f9914a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ boolean f9915b;

    public /* synthetic */ a(ICameraChangedCallback iCameraChangedCallback, boolean z) {
        this.f9914a = iCameraChangedCallback;
        this.f9915b = z;
    }

    public final void run() {
        this.f9914a.onCameraSDCardStateChanged(this.f9915b);
    }
}
