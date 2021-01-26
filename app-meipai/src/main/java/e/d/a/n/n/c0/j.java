package e.d.a.n.n.c0;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool */
public class j implements d {

    /* renamed from: j reason: collision with root package name */
    public static final Config f7312j = Config.ARGB_8888;

    /* renamed from: a reason: collision with root package name */
    public final k f7313a;

    /* renamed from: b reason: collision with root package name */
    public final Set<Config> f7314b;

    /* renamed from: c reason: collision with root package name */
    public final a f7315c;

    /* renamed from: d reason: collision with root package name */
    public long f7316d;

    /* renamed from: e reason: collision with root package name */
    public long f7317e;

    /* renamed from: f reason: collision with root package name */
    public int f7318f;

    /* renamed from: g reason: collision with root package name */
    public int f7319g;

    /* renamed from: h reason: collision with root package name */
    public int f7320h;

    /* renamed from: i reason: collision with root package name */
    public int f7321i;

    /* compiled from: LruBitmapPool */
    public interface a {
    }

    /* compiled from: LruBitmapPool */
    public static final class b implements a {
    }

    public j(long j2) {
        m mVar = new m();
        HashSet hashSet = new HashSet(Arrays.asList(Config.values()));
        hashSet.add(null);
        if (VERSION.SDK_INT >= 26) {
            hashSet.remove(Config.HARDWARE);
        }
        Set<Config> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f7316d = j2;
        this.f7313a = mVar;
        this.f7314b = unmodifiableSet;
        this.f7315c = new b();
    }

    public synchronized void a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f7313a.b(bitmap)) <= this.f7316d) {
                        if (this.f7314b.contains(bitmap.getConfig())) {
                            int b2 = this.f7313a.b(bitmap);
                            this.f7313a.a(bitmap);
                            if (((b) this.f7315c) != null) {
                                this.f7320h++;
                                this.f7317e += (long) b2;
                                if (Log.isLoggable("LruBitmapPool", 2)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Put bitmap in pool=");
                                    sb.append(this.f7313a.c(bitmap));
                                    Log.v("LruBitmapPool", sb.toString());
                                }
                                b();
                                a(this.f7316d);
                                return;
                            }
                            throw null;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Reject bitmap from pool, bitmap: ");
                        sb2.append(this.f7313a.c(bitmap));
                        sb2.append(", is mutable: ");
                        sb2.append(bitmap.isMutable());
                        sb2.append(", is allowed config: ");
                        sb2.append(this.f7314b.contains(bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb2.toString());
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } finally {
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public Bitmap b(int i2, int i3, Config config) {
        Bitmap c2 = c(i2, i3, config);
        if (c2 != null) {
            return c2;
        }
        if (config == null) {
            config = f7312j;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    public final synchronized Bitmap c(int i2, int i3, Config config) {
        Bitmap a2;
        if (VERSION.SDK_INT >= 26) {
            if (config == Config.HARDWARE) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot create a mutable Bitmap with config: ");
                sb.append(config);
                sb.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        a2 = this.f7313a.a(i2, i3, config != null ? config : f7312j);
        if (a2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Missing bitmap=");
                sb2.append(this.f7313a.b(i2, i3, config));
                Log.d("LruBitmapPool", sb2.toString());
            }
            this.f7319g++;
        } else {
            this.f7318f++;
            this.f7317e -= (long) this.f7313a.b(a2);
            if (((b) this.f7315c) != null) {
                a2.setHasAlpha(true);
                a2.setPremultiplied(true);
            } else {
                throw null;
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Get bitmap=");
            sb3.append(this.f7313a.b(i2, i3, config));
            Log.v("LruBitmapPool", sb3.toString());
        }
        b();
        return a2;
    }

    public final void b() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            c();
        }
    }

    public final void c() {
        StringBuilder a2 = e.a.a.a.a.a("Hits=");
        a2.append(this.f7318f);
        a2.append(", misses=");
        a2.append(this.f7319g);
        a2.append(", puts=");
        a2.append(this.f7320h);
        a2.append(", evictions=");
        a2.append(this.f7321i);
        a2.append(", currentSize=");
        a2.append(this.f7317e);
        a2.append(", maxSize=");
        a2.append(this.f7316d);
        a2.append("\nStrategy=");
        a2.append(this.f7313a);
        Log.v("LruBitmapPool", a2.toString());
    }

    public Bitmap a(int i2, int i3, Config config) {
        Bitmap c2 = c(i2, i3, config);
        if (c2 != null) {
            c2.eraseColor(0);
            return c2;
        }
        if (config == null) {
            config = f7312j;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    public void a() {
        String str = "LruBitmapPool";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "clearMemory");
        }
        a(0);
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        String str = "LruBitmapPool";
        if (Log.isLoggable(str, 3)) {
            e.a.a.a.a.b("trimMemory, level=", i2, str);
        }
        if (i2 >= 40 || i2 >= 20) {
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "clearMemory");
            }
            a(0);
        } else if (i2 >= 20 || i2 == 15) {
            a(this.f7316d / 2);
        }
    }

    public final synchronized void a(long j2) {
        while (this.f7317e > j2) {
            Bitmap removeLast = this.f7313a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    c();
                }
                this.f7317e = 0;
                return;
            } else if (((b) this.f7315c) != null) {
                this.f7317e -= (long) this.f7313a.b(removeLast);
                this.f7321i++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Evicting bitmap=");
                    sb.append(this.f7313a.c(removeLast));
                    Log.d("LruBitmapPool", sb.toString());
                }
                b();
                removeLast.recycle();
            } else {
                throw null;
            }
        }
    }
}
