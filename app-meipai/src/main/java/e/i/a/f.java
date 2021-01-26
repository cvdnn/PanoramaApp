package e.i.a;

import android.os.SystemClock;

/* compiled from: SpeedCalculator */
public class f {

    /* renamed from: a reason: collision with root package name */
    public long f8681a;

    /* renamed from: b reason: collision with root package name */
    public long f8682b;

    /* renamed from: c reason: collision with root package name */
    public long f8683c;

    public synchronized void a() {
        SystemClock.uptimeMillis();
    }

    public synchronized void a(long j2) {
        if (this.f8681a == 0) {
            this.f8681a = SystemClock.uptimeMillis();
        }
        this.f8682b += j2;
        this.f8683c += j2;
    }
}
