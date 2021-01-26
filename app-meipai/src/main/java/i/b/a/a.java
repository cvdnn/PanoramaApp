package i.b.a;

/* compiled from: AsyncPoster */
public class a implements Runnable, l {

    /* renamed from: a reason: collision with root package name */
    public final k f9719a = new k();

    /* renamed from: b reason: collision with root package name */
    public final c f9720b;

    public a(c cVar) {
        this.f9720b = cVar;
    }

    public void a(q qVar, Object obj) {
        this.f9719a.a(j.a(qVar, obj));
        this.f9720b.f9733j.execute(this);
    }

    public void run() {
        j a2 = this.f9719a.a();
        if (a2 != null) {
            this.f9720b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
