package e.b.e.b.b;

import com.arashivision.sdkmedia.player.listener.PlayerViewListener;

/* compiled from: lambda */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ PlayerViewListener f5843a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5844b;

    public /* synthetic */ b(PlayerViewListener playerViewListener, String str) {
        this.f5843a = playerViewListener;
        this.f5844b = str;
    }

    public final void run() {
        this.f5843a.onFail(this.f5844b);
    }
}
