package i.b.b.i;

/* compiled from: LongHashMap */
public final class c<T> {

    /* renamed from: a reason: collision with root package name */
    public a<T>[] f9825a = new a[16];

    /* renamed from: b reason: collision with root package name */
    public int f9826b = 16;

    /* renamed from: c reason: collision with root package name */
    public int f9827c = 21;

    /* renamed from: d reason: collision with root package name */
    public int f9828d;

    /* compiled from: LongHashMap */
    public static final class a<T> {

        /* renamed from: a reason: collision with root package name */
        public final long f9829a;

        /* renamed from: b reason: collision with root package name */
        public T f9830b;

        /* renamed from: c reason: collision with root package name */
        public a<T> f9831c;

        public a(long j2, T t, a<T> aVar) {
            this.f9829a = j2;
            this.f9830b = t;
            this.f9831c = aVar;
        }
    }

    public T a(long j2) {
        for (a<T> aVar = this.f9825a[((((int) (j2 >>> 32)) ^ ((int) j2)) & Integer.MAX_VALUE) % this.f9826b]; aVar != null; aVar = aVar.f9831c) {
            if (aVar.f9829a == j2) {
                return aVar.f9830b;
            }
        }
        return null;
    }

    public T a(long j2, T t) {
        int i2 = ((((int) (j2 >>> 32)) ^ ((int) j2)) & Integer.MAX_VALUE) % this.f9826b;
        a<T> aVar = this.f9825a[i2];
        for (a<T> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f9831c) {
            if (aVar2.f9829a == j2) {
                T t2 = aVar2.f9830b;
                aVar2.f9830b = t;
                return t2;
            }
        }
        this.f9825a[i2] = new a<>(j2, t, aVar);
        int i3 = this.f9828d + 1;
        this.f9828d = i3;
        if (i3 > this.f9827c) {
            a(this.f9826b * 2);
        }
        return null;
    }

    public void a(int i2) {
        a<T>[] aVarArr = new a[i2];
        for (a<T> aVar : this.f9825a) {
            while (aVar != null) {
                long j2 = aVar.f9829a;
                int i3 = ((((int) j2) ^ ((int) (j2 >>> 32))) & Integer.MAX_VALUE) % i2;
                a<T> aVar2 = aVar.f9831c;
                aVar.f9831c = aVarArr[i3];
                aVarArr[i3] = aVar;
                aVar = aVar2;
            }
        }
        this.f9825a = aVarArr;
        this.f9826b = i2;
        this.f9827c = (i2 * 4) / 3;
    }
}
