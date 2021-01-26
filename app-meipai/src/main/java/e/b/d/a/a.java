package e.b.d.a;

import com.arashivision.sdkcamera.camera.callback.ILiveStatusListener;

/* compiled from: lambda */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ILiveStatusListener f5818a;

    public /* synthetic */ a(ILiveStatusListener iLiveStatusListener) {
        this.f5818a = iLiveStatusListener;
    }

    public final void run() {
        this.f5818a.onLivePushError();
    }
}
