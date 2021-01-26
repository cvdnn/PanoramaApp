package e.c.f.n;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: HandlerHelper */
public final class f {

    /* renamed from: c reason: collision with root package name */
    public static final f f7059c = new f();

    /* renamed from: a reason: collision with root package name */
    public HandlerThread f7060a;

    /* renamed from: b reason: collision with root package name */
    public Handler f7061b = new Handler(this.f7060a.getLooper());

    public f() {
        HandlerThread handlerThread = new HandlerThread("rp_th", 10);
        this.f7060a = handlerThread;
        handlerThread.start();
    }
}
