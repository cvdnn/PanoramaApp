package e.b.e.b.a;

import com.arashivision.sdkmedia.player.listener.PlayerViewListener;

/* compiled from: lambda */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ PlayerViewListener f5838a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5839b;

    public /* synthetic */ b(PlayerViewListener playerViewListener, String str) {
        this.f5838a = playerViewListener;
        this.f5839b = str;
    }

    public final void run() {
        this.f5838a.onFail(this.f5839b);
    }
}
