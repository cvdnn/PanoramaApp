package e.b.d.a;

import com.arashivision.sdkcamera.camera.callback.ILiveStatusListener;

/* compiled from: lambda */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ILiveStatusListener f5821a;

    public /* synthetic */ c(ILiveStatusListener iLiveStatusListener) {
        this.f5821a = iLiveStatusListener;
    }

    public final void run() {
        this.f5821a.onLivePushStarted();
    }
}
