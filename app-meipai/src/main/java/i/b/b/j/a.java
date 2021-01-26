package i.b.b.j;

import i.b.b.e;

/* compiled from: AbstractQuery */
public abstract class a<T> {

    /* renamed from: a reason: collision with root package name */
    public final i.b.b.a<T, ?> f9839a;

    /* renamed from: b reason: collision with root package name */
    public final e<T> f9840b;

    /* renamed from: c reason: collision with root package name */
    public final String f9841c;

    /* renamed from: d reason: collision with root package name */
    public final String[] f9842d;

    /* renamed from: e reason: collision with root package name */
    public final Thread f9843e = Thread.currentThread();

    public a(i.b.b.a<T, ?> aVar, String str, String[] strArr) {
        this.f9839a = aVar;
        this.f9840b = new e<>(aVar);
        this.f9841c = str;
        this.f9842d = strArr;
    }
}
