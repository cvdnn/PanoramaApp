package e.c.d.i.b;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

/* compiled from: lambda */
public final /* synthetic */ class d implements AutoFocusCallback {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ h f6154a;

    public /* synthetic */ d(h hVar) {
        this.f6154a = hVar;
    }

    public final void onAutoFocus(boolean z, Camera camera) {
        this.f6154a.a(z, camera);
    }
}
