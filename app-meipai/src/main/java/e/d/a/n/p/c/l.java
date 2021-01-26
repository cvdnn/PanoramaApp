package e.d.a.n.p.c;

import e.d.a.n.g;

/* compiled from: DownsampleStrategy */
public abstract class l {

    /* renamed from: a reason: collision with root package name */
    public static final l f7685a = new c();

    /* renamed from: b reason: collision with root package name */
    public static final l f7686b = new a();

    /* renamed from: c reason: collision with root package name */
    public static final l f7687c = new b();

    /* renamed from: d reason: collision with root package name */
    public static final l f7688d = new d();

    /* renamed from: e reason: collision with root package name */
    public static final l f7689e;

    /* renamed from: f reason: collision with root package name */
    public static final g<l> f7690f;

    /* renamed from: g reason: collision with root package name */
    public static final boolean f7691g = true;

    /* compiled from: DownsampleStrategy */
    public static class a extends l {
        public e a(int i2, int i3, int i4, int i5) {
            if (b(i2, i3, i4, i5) == 1.0f) {
                return e.QUALITY;
            }
            return l.f7685a.a(i2, i3, i4, i5);
        }

        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, l.f7685a.b(i2, i3, i4, i5));
        }
    }

    /* compiled from: DownsampleStrategy */
    public static class b extends l {
        public e a(int i2, int i3, int i4, int i5) {
            return e.QUALITY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            return Math.max(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
        }
    }

    /* compiled from: DownsampleStrategy */
    public static class c extends l {
        public e a(int i2, int i3, int i4, int i5) {
            if (l.f7691g) {
                return e.QUALITY;
            }
            return e.MEMORY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            if (l.f7691g) {
                return Math.min(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
            }
            int max = Math.max(i3 / i5, i2 / i4);
            float f2 = 1.0f;
            if (max != 0) {
                f2 = 1.0f / ((float) Integer.highestOneBit(max));
            }
            return f2;
        }
    }

    /* compiled from: DownsampleStrategy */
    public static class d extends l {
        public e a(int i2, int i3, int i4, int i5) {
            return e.QUALITY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    /* compiled from: DownsampleStrategy */
    public enum e {
        MEMORY,
        QUALITY
    }

    static {
        l lVar = f7687c;
        f7689e = lVar;
        f7690f = g.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", lVar);
    }

    public abstract e a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
