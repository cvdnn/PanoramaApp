package e.c.b.g;

import android.content.Context;

public final class h implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Context f5942a;

    public h(Context context) {
        this.f5942a = context;
    }

    public final void run() {
        try {
            g.a(this.f5942a);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
