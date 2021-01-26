package e.b.e.b.d;

import com.arashivision.sdkmedia.player.listener.VideoStatusListener;

/* compiled from: lambda */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ VideoStatusListener f5856a;

    public /* synthetic */ f(VideoStatusListener videoStatusListener) {
        this.f5856a = videoStatusListener;
    }

    public final void run() {
        this.f5856a.onCompletion();
    }
}
