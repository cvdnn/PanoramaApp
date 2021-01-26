package e.b.e.b.a;

import com.arashivision.sdkmedia.player.listener.PlayerViewListener;

/* compiled from: lambda */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ PlayerViewListener f5840a;

    public /* synthetic */ c(PlayerViewListener playerViewListener) {
        this.f5840a = playerViewListener;
    }

    public final void run() {
        this.f5840a.onLoadingFinish();
    }
}
