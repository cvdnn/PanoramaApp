package e.c.b.g;

public final class e implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ d f5934a;

    public e(d dVar) {
        this.f5934a = dVar;
    }

    public final void run() {
        d dVar = this.f5934a;
        dVar.f5931e = (dVar.f5931e + 1) % 10;
    }
}
