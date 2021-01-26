package h;

/* compiled from: SegmentPool */
public final class u {

    /* renamed from: a reason: collision with root package name */
    public static t f9686a;

    /* renamed from: b reason: collision with root package name */
    public static long f9687b;

    public static t a() {
        synchronized (u.class) {
            if (f9686a == null) {
                return new t();
            }
            t tVar = f9686a;
            f9686a = tVar.f9684f;
            tVar.f9684f = null;
            f9687b -= 8192;
            return tVar;
        }
    }

    public static void a(t tVar) {
        if (tVar.f9684f != null || tVar.f9685g != null) {
            throw new IllegalArgumentException();
        } else if (!tVar.f9682d) {
            synchronized (u.class) {
                if (f9687b + 8192 <= 65536) {
                    f9687b += 8192;
                    tVar.f9684f = f9686a;
                    tVar.f9681c = 0;
                    tVar.f9680b = 0;
                    f9686a = tVar;
                }
            }
        }
    }
}
