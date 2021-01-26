package e.d.a.n.p.c;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;

/* compiled from: HardwareConfigState */
public final class r {

    /* renamed from: f reason: collision with root package name */
    public static final File f7709f = new File("/proc/self/fd");

    /* renamed from: g reason: collision with root package name */
    public static volatile r f7710g;

    /* renamed from: a reason: collision with root package name */
    public final boolean f7711a;

    /* renamed from: b reason: collision with root package name */
    public final int f7712b;

    /* renamed from: c reason: collision with root package name */
    public final int f7713c;

    /* renamed from: d reason: collision with root package name */
    public int f7714d;

    /* renamed from: e reason: collision with root package name */
    public boolean f7715e = true;

    public r() {
        boolean z = true;
        String str = Build.MODEL;
        if (str != null && str.length() >= 7) {
            String substring = Build.MODEL.substring(0, 7);
            char c2 = 65535;
            switch (substring.hashCode()) {
                case -1398613787:
                    if (substring.equals("SM-A520")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1398431166:
                    if (substring.equals("SM-G930")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1398431161:
                    if (substring.equals("SM-G935")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1398431073:
                    if (substring.equals("SM-G960")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1398431068:
                    if (substring.equals("SM-G965")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1398343746:
                    if (substring.equals("SM-J720")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1398222624:
                    if (substring.equals("SM-N935")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    if (VERSION.SDK_INT == 26) {
                        z = false;
                        break;
                    }
                    break;
            }
        }
        this.f7711a = z;
        if (VERSION.SDK_INT >= 28) {
            this.f7712b = 20000;
            this.f7713c = 0;
            return;
        }
        this.f7712b = 700;
        this.f7713c = 128;
    }

    public static r b() {
        if (f7710g == null) {
            synchronized (r.class) {
                if (f7710g == null) {
                    f7710g = new r();
                }
            }
        }
        return f7710g;
    }

    public boolean a(int i2, int i3, boolean z, boolean z2) {
        if (!z || !this.f7711a || VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        int i4 = this.f7713c;
        if (i2 < i4 || i3 < i4 || !a()) {
            return false;
        }
        return true;
    }

    public final synchronized boolean a() {
        boolean z = true;
        int i2 = this.f7714d + 1;
        this.f7714d = i2;
        if (i2 >= 50) {
            this.f7714d = 0;
            int length = f7709f.list().length;
            if (length >= this.f7712b) {
                z = false;
            }
            this.f7715e = z;
            if (!z && Log.isLoggable("Downsampler", 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                sb.append(length);
                sb.append(", limit ");
                sb.append(this.f7712b);
                Log.w("Downsampler", sb.toString());
            }
        }
        return this.f7715e;
    }
}
