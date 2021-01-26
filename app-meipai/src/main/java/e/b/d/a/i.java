package e.b.d.a;

import com.arashivision.sdkcamera.camera.callback.ILiveStatusListener;

/* compiled from: lambda */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ILiveStatusListener f5829a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ int f5830b;

    public /* synthetic */ i(ILiveStatusListener iLiveStatusListener, int i2) {
        this.f5829a = iLiveStatusListener;
        this.f5830b = i2;
    }

    public final void run() {
        this.f5829a.onLiveFpsUpdate(this.f5830b);
    }
}
