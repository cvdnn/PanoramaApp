package e.c.d.i.c;

import com.arashivision.sdkcamera.camera.callback.ICameraOperateCallback;
import e.c.d.i.c.r.a;

/* compiled from: SphericalCamera */
public class o implements ICameraOperateCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f6215a;

    public o(r rVar, a aVar) {
        this.f6215a = aVar;
    }

    public void onCameraConnectError() {
        this.f6215a.a("", -3);
    }

    public void onFailed() {
        this.f6215a.a("", -1);
    }

    public void onSuccessful() {
        this.f6215a.a("", 0);
    }
}
