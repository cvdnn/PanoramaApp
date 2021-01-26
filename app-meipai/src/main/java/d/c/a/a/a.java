package d.c.a.a;

/* compiled from: ArchTaskExecutor */
public class a extends c {

    /* renamed from: c reason: collision with root package name */
    public static volatile a f4521c;

    /* renamed from: a reason: collision with root package name */
    public c f4522a;

    /* renamed from: b reason: collision with root package name */
    public c f4523b;

    public a() {
        b bVar = new b();
        this.f4523b = bVar;
        this.f4522a = bVar;
    }

    public static a b() {
        if (f4521c != null) {
            return f4521c;
        }
        synchronized (a.class) {
            if (f4521c == null) {
                f4521c = new a();
            }
        }
        return f4521c;
    }

    public boolean a() {
        return this.f4522a.a();
    }
}
