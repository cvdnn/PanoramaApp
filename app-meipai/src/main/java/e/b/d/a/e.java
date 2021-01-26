package e.b.d.a;

import com.arashivision.sdkcamera.camera.callback.ILiveStatusListener;

/* compiled from: lambda */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ILiveStatusListener f5824a;

    public /* synthetic */ e(ILiveStatusListener iLiveStatusListener) {
        this.f5824a = iLiveStatusListener;
    }

    public final void run() {
        this.f5824a.onLivePushFinished();
    }
}
