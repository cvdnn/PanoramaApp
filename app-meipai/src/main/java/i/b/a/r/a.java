package i.b.a.r;

import android.util.Log;
import i.b.a.g;
import java.util.logging.Level;

/* compiled from: AndroidLogger */
public class a implements g {

    /* renamed from: b reason: collision with root package name */
    public static final boolean f9785b;

    /* renamed from: a reason: collision with root package name */
    public final String f9786a;

    static {
        boolean z;
        try {
            Class.forName("android.util.Log");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f9785b = z;
    }

    public a(String str) {
        this.f9786a = str;
    }

    public void a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(a(level), this.f9786a, str);
        }
    }

    public void a(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            int a2 = a(level);
            String str2 = this.f9786a;
            StringBuilder b2 = e.a.a.a.a.b(str, "\n");
            b2.append(Log.getStackTraceString(th));
            Log.println(a2, str2, b2.toString());
        }
    }

    public final int a(Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            return intValue < 500 ? 2 : 3;
        }
        if (intValue < 900) {
            return 4;
        }
        return intValue < 1000 ? 5 : 6;
    }
}
