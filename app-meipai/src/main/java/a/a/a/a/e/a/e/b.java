package a.a.a.a.e.a.e;

import java.util.concurrent.CountDownLatch;

/* compiled from: lambda */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ o f490a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String[] f491b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ CountDownLatch f492c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ int[] f493d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ String[] f494e;

    public /* synthetic */ b(o oVar, String[] strArr, CountDownLatch countDownLatch, int[] iArr, String[] strArr2) {
        this.f490a = oVar;
        this.f491b = strArr;
        this.f492c = countDownLatch;
        this.f493d = iArr;
        this.f494e = strArr2;
    }

    public final void run() {
        this.f490a.a(this.f491b, this.f492c, this.f493d, this.f494e);
    }
}
