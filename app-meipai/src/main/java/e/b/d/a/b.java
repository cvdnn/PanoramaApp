package e.b.d.a;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0149OooOO0o;
import com.arashivision.sdkcamera.camera.InstaCameraManager;
import com.arashivision.sdkcamera.camera.callback.IPreviewStatusListener;

/* compiled from: lambda */
public final /* synthetic */ class b implements C0149OooOO0o {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ BaseCamera f5819a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ IPreviewStatusListener f5820b;

    public /* synthetic */ b(BaseCamera baseCamera, IPreviewStatusListener iPreviewStatusListener) {
        this.f5819a = baseCamera;
        this.f5820b = iPreviewStatusListener;
    }

    public final void OooO00o(int i2) {
        InstaCameraManager.m46(this.f5819a, this.f5820b, i2);
    }
}
