package e.b.e.b.d;

import com.arashivision.sdkmedia.player.listener.VideoStatusListener;

/* compiled from: lambda */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ VideoStatusListener f5850a;

    public /* synthetic */ c(VideoStatusListener videoStatusListener) {
        this.f5850a = videoStatusListener;
    }

    public final void run() {
        this.f5850a.onSeekComplete();
    }
}
