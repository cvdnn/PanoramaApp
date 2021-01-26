package e.b.e.b.d;

import com.arashivision.sdkmedia.player.listener.PlayerViewListener;

/* compiled from: lambda */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ PlayerViewListener f5857a;

    public /* synthetic */ g(PlayerViewListener playerViewListener) {
        this.f5857a = playerViewListener;
    }

    public final void run() {
        this.f5857a.onLoadingFinish();
    }
}
