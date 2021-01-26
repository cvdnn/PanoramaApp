package e.b.d.a;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.insta360.basecamera.camera.BaseCamera.PreviewStatus;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0156OooOo0o;
import com.arashivision.sdkcamera.camera.InstaCameraManager;
import com.arashivision.sdkcamera.camera.callback.IPreviewStatusListener;

/* compiled from: lambda */
public final /* synthetic */ class f implements C0156OooOo0o {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ IPreviewStatusListener f5825a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ BaseCamera f5826b;

    public /* synthetic */ f(IPreviewStatusListener iPreviewStatusListener, BaseCamera baseCamera) {
        this.f5825a = iPreviewStatusListener;
        this.f5826b = baseCamera;
    }

    public final void OooO00o(PreviewStatus previewStatus, int i2) {
        InstaCameraManager.m50(this.f5825a, this.f5826b, previewStatus, i2);
    }
}
