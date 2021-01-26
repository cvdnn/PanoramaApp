package e.c.d.i.b;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

/* compiled from: lambda */
public final /* synthetic */ class b implements AutoFocusCallback {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ h f6151a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f6152b;

    public /* synthetic */ b(h hVar, String str) {
        this.f6151a = hVar;
        this.f6152b = str;
    }

    public final void onAutoFocus(boolean z, Camera camera) {
        this.f6151a.a(this.f6152b, z, camera);
    }
}
