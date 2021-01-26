package e.b.e.b.d;

import com.arashivision.sdkmedia.player.listener.VideoStatusListener;

/* compiled from: lambda */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ VideoStatusListener f5851a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ double f5852b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ double f5853c;

    public /* synthetic */ d(VideoStatusListener videoStatusListener, double d2, double d3) {
        this.f5851a = videoStatusListener;
        this.f5852b = d2;
        this.f5853c = d3;
    }

    public final void run() {
        this.f5851a.onProgressChanged((long) this.f5852b, (long) this.f5853c);
    }
}
