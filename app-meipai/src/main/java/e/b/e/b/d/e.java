package e.b.e.b.d;

import com.arashivision.sdkmedia.player.listener.PlayerViewListener;

/* compiled from: lambda */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ PlayerViewListener f5854a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5855b;

    public /* synthetic */ e(PlayerViewListener playerViewListener, String str) {
        this.f5854a = playerViewListener;
        this.f5855b = str;
    }

    public final void run() {
        this.f5854a.onFail(this.f5855b);
    }
}
