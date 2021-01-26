package j.a.a.b;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.sdkcamera.camera.callback.ICameraChangedCallback;

/* compiled from: lambda */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ICameraChangedCallback f9919a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ BaseCamera f9920b;

    public /* synthetic */ d(ICameraChangedCallback iCameraChangedCallback, BaseCamera baseCamera) {
        this.f9919a = iCameraChangedCallback;
        this.f9920b = baseCamera;
    }

    public final void run() {
        this.f9919a.onCameraStorageChanged(this.f9920b.getStorageFreeSpace(), this.f9920b.getStorageTotalSpace());
    }
}
