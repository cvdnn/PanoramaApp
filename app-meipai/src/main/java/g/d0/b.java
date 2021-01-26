package g.d0;

/* compiled from: NamedRunnable */
public abstract class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final String f9173a;

    public b(String str, Object... objArr) {
        this.f9173a = c.a(str, objArr);
    }

    public abstract void a();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f9173a);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
