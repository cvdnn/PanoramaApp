package e.d.a.n.n;

/* compiled from: ActiveResources */
public class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f7288a;

    public b(a aVar) {
        this.f7288a = aVar;
    }

    public void run() {
        a aVar = this.f7288a;
        if (aVar != null) {
            while (true) {
                try {
                    aVar.a((e.d.a.n.n.a.b) aVar.f7280c.remove());
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            throw null;
        }
    }
}
