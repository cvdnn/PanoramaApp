package e.b.d.a;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0149OooOO0o;
import com.arashivision.sdkcamera.camera.InstaCameraManager;
import com.arashivision.sdkcamera.camera.callback.IPreviewStatusListener;

/* compiled from: lambda */
public final /* synthetic */ class d implements C0149OooOO0o {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ BaseCamera f5822a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ IPreviewStatusListener f5823b;

    public /* synthetic */ d(BaseCamera baseCamera, IPreviewStatusListener iPreviewStatusListener) {
        this.f5822a = baseCamera;
        this.f5823b = iPreviewStatusListener;
    }

    public final void OooO00o(int i2) {
        InstaCameraManager.m48(this.f5822a, this.f5823b, i2);
    }
}
