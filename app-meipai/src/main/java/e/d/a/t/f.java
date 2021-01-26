package e.d.a.t;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* compiled from: LogTime */
public final class f {

    /* renamed from: a reason: collision with root package name */
    public static final double f7913a = (1.0d / Math.pow(10.0d, 6.0d));

    public static double a(long j2) {
        return ((double) (SystemClock.elapsedRealtimeNanos() - j2)) * f7913a;
    }

    @TargetApi(17)
    public static long a() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
