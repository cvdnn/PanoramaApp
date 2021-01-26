package j.a.a.b;

import com.arashivision.sdkcamera.camera.callback.ICameraChangedCallback;

/* compiled from: lambda */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ g f9922a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ ICameraChangedCallback f9923b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ boolean f9924c;

    public /* synthetic */ f(g gVar, ICameraChangedCallback iCameraChangedCallback, boolean z) {
        this.f9922a = gVar;
        this.f9923b = iCameraChangedCallback;
        this.f9924c = z;
    }

    public final void run() {
        this.f9922a.a(this.f9923b, this.f9924c);
    }
}
