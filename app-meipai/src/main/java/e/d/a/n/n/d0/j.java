package e.d.a.n.n.d0;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* compiled from: MemorySizeCalculator */
public final class j {

    /* renamed from: a reason: collision with root package name */
    public final int f7358a;

    /* renamed from: b reason: collision with root package name */
    public final int f7359b;

    /* renamed from: c reason: collision with root package name */
    public final Context f7360c;

    /* renamed from: d reason: collision with root package name */
    public final int f7361d;

    /* compiled from: MemorySizeCalculator */
    public static final class a {

        /* renamed from: i reason: collision with root package name */
        public static final int f7362i = (VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: a reason: collision with root package name */
        public final Context f7363a;

        /* renamed from: b reason: collision with root package name */
        public ActivityManager f7364b;

        /* renamed from: c reason: collision with root package name */
        public c f7365c;

        /* renamed from: d reason: collision with root package name */
        public float f7366d = 2.0f;

        /* renamed from: e reason: collision with root package name */
        public float f7367e = ((float) f7362i);

        /* renamed from: f reason: collision with root package name */
        public float f7368f = 0.4f;

        /* renamed from: g reason: collision with root package name */
        public float f7369g = 0.33f;

        /* renamed from: h reason: collision with root package name */
        public int f7370h = 4194304;

        public a(Context context) {
            this.f7363a = context;
            this.f7364b = (ActivityManager) context.getSystemService("activity");
            this.f7365c = new b(context.getResources().getDisplayMetrics());
            if (VERSION.SDK_INT >= 26 && this.f7364b.isLowRamDevice()) {
                this.f7367e = 0.0f;
            }
        }
    }

    /* compiled from: MemorySizeCalculator */
    public static final class b implements c {

        /* renamed from: a reason: collision with root package name */
        public final DisplayMetrics f7371a;

        public b(DisplayMetrics displayMetrics) {
            this.f7371a = displayMetrics;
        }
    }

    /* compiled from: MemorySizeCalculator */
    public interface c {
    }

    public j(a aVar) {
        int i2;
        this.f7360c = aVar.f7363a;
        if (aVar.f7364b.isLowRamDevice()) {
            i2 = aVar.f7370h / 2;
        } else {
            i2 = aVar.f7370h;
        }
        this.f7361d = i2;
        ActivityManager activityManager = aVar.f7364b;
        float f2 = aVar.f7368f;
        float f3 = aVar.f7369g;
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (activityManager.isLowRamDevice()) {
            f2 = f3;
        }
        int round = Math.round(memoryClass * f2);
        c cVar = aVar.f7365c;
        float f4 = (float) (((b) cVar).f7371a.widthPixels * ((b) cVar).f7371a.heightPixels * 4);
        int round2 = Math.round(aVar.f7367e * f4);
        int round3 = Math.round(f4 * aVar.f7366d);
        int i3 = round - this.f7361d;
        int i4 = round3 + round2;
        if (i4 <= i3) {
            this.f7359b = round3;
            this.f7358a = round2;
        } else {
            float f5 = (float) i3;
            float f6 = aVar.f7367e;
            float f7 = aVar.f7366d;
            float f8 = f5 / (f6 + f7);
            this.f7359b = Math.round(f7 * f8);
            this.f7358a = Math.round(f8 * aVar.f7367e);
        }
        String str = "MemorySizeCalculator";
        if (Log.isLoggable(str, 3)) {
            StringBuilder a2 = e.a.a.a.a.a("Calculation complete, Calculated memory cache size: ");
            a2.append(a(this.f7359b));
            a2.append(", pool size: ");
            a2.append(a(this.f7358a));
            a2.append(", byte array size: ");
            a2.append(a(this.f7361d));
            a2.append(", memory class limited? ");
            a2.append(i4 > round);
            a2.append(", max size: ");
            a2.append(a(round));
            a2.append(", memoryClass: ");
            a2.append(aVar.f7364b.getMemoryClass());
            a2.append(", isLowMemoryDevice: ");
            a2.append(aVar.f7364b.isLowRamDevice());
            Log.d(str, a2.toString());
        }
    }

    public final String a(int i2) {
        return Formatter.formatFileSize(this.f7360c, (long) i2);
    }
}
