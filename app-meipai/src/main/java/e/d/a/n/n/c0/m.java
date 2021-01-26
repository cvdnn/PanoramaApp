package e.d.a.n.n.c0;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import e.d.a.t.j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: SizeConfigStrategy */
public class m implements k {

    /* renamed from: d reason: collision with root package name */
    public static final Config[] f7322d;

    /* renamed from: e reason: collision with root package name */
    public static final Config[] f7323e;

    /* renamed from: f reason: collision with root package name */
    public static final Config[] f7324f = {Config.RGB_565};

    /* renamed from: g reason: collision with root package name */
    public static final Config[] f7325g = {Config.ARGB_4444};

    /* renamed from: h reason: collision with root package name */
    public static final Config[] f7326h = {Config.ALPHA_8};

    /* renamed from: a reason: collision with root package name */
    public final c f7327a = new c();

    /* renamed from: b reason: collision with root package name */
    public final g<b, Bitmap> f7328b = new g<>();

    /* renamed from: c reason: collision with root package name */
    public final Map<Config, NavigableMap<Integer, Integer>> f7329c = new HashMap();

    /* compiled from: SizeConfigStrategy */
    public static /* synthetic */ class a {

        /* renamed from: a reason: collision with root package name */
        public static final /* synthetic */ int[] f7330a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7330a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7330a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7330a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7330a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.n.c0.m.a.<clinit>():void");
        }
    }

    /* compiled from: SizeConfigStrategy */
    public static final class b implements l {

        /* renamed from: a reason: collision with root package name */
        public final c f7331a;

        /* renamed from: b reason: collision with root package name */
        public int f7332b;

        /* renamed from: c reason: collision with root package name */
        public Config f7333c;

        public b(c cVar) {
            this.f7331a = cVar;
        }

        public void a() {
            this.f7331a.a(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f7332b != bVar.f7332b || !j.b(this.f7333c, bVar.f7333c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2 = this.f7332b * 31;
            Config config = this.f7333c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return m.a(this.f7332b, this.f7333c);
        }
    }

    /* compiled from: SizeConfigStrategy */
    public static class c extends c<b> {
        public b a(int i2, Config config) {
            b bVar = (b) b();
            bVar.f7332b = i2;
            bVar.f7333c = config;
            return bVar;
        }

        public l a() {
            return new b(this);
        }
    }

    static {
        Config[] configArr = {Config.ARGB_8888, null};
        if (VERSION.SDK_INT >= 26) {
            configArr = (Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Config.RGBA_F16;
        }
        f7322d = configArr;
        f7323e = configArr;
    }

    public void a(Bitmap bitmap) {
        b a2 = this.f7327a.a(j.a(bitmap), bitmap.getConfig());
        this.f7328b.a(a2, bitmap);
        NavigableMap a3 = a(bitmap.getConfig());
        Integer num = (Integer) a3.get(Integer.valueOf(a2.f7332b));
        Integer valueOf = Integer.valueOf(a2.f7332b);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        a3.put(valueOf, Integer.valueOf(i2));
    }

    public String b(int i2, int i3, Config config) {
        return a(j.a(i2, i3, config), config);
    }

    public String c(Bitmap bitmap) {
        return a(j.a(bitmap), bitmap.getConfig());
    }

    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.f7328b.a();
        if (bitmap != null) {
            a(Integer.valueOf(j.a(bitmap)), bitmap);
        }
        return bitmap;
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("SizeConfigStrategy{groupedMap=");
        a2.append(this.f7328b);
        a2.append(", sortedSizes=(");
        for (Entry entry : this.f7329c.entrySet()) {
            a2.append(entry.getKey());
            a2.append('[');
            a2.append(entry.getValue());
            a2.append("], ");
        }
        if (!this.f7329c.isEmpty()) {
            a2.replace(a2.length() - 2, a2.length(), "");
        }
        a2.append(")}");
        return a2.toString();
    }

    public int b(Bitmap bitmap) {
        return j.a(bitmap);
    }

    public Bitmap a(int i2, int i3, Config config) {
        Config[] configArr;
        int a2 = j.a(i2, i3, config);
        b bVar = (b) this.f7327a.b();
        bVar.f7332b = a2;
        bVar.f7333c = config;
        int i4 = 0;
        if (VERSION.SDK_INT < 26 || !Config.RGBA_F16.equals(config)) {
            int i5 = a.f7330a[config.ordinal()];
            if (i5 == 1) {
                configArr = f7322d;
            } else if (i5 == 2) {
                configArr = f7324f;
            } else if (i5 != 3) {
                configArr = i5 != 4 ? new Config[]{config} : f7326h;
            } else {
                configArr = f7325g;
            }
        } else {
            configArr = f7323e;
        }
        int length = configArr.length;
        while (true) {
            if (i4 >= length) {
                break;
            }
            Config config2 = configArr[i4];
            Integer num = (Integer) a(config2).ceilingKey(Integer.valueOf(a2));
            if (num == null || num.intValue() > a2 * 8) {
                i4++;
            } else if (num.intValue() != a2 || (config2 != null ? !config2.equals(config) : config != null)) {
                this.f7327a.a(bVar);
                bVar = this.f7327a.a(num.intValue(), config2);
            }
        }
        Bitmap bitmap = (Bitmap) this.f7328b.a(bVar);
        if (bitmap != null) {
            a(Integer.valueOf(bVar.f7332b), bitmap);
            bitmap.reconfigure(i2, i3, config);
        }
        return bitmap;
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap a2 = a(bitmap.getConfig());
        Integer num2 = (Integer) a2.get(num);
        if (num2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to decrement empty size, size: ");
            sb.append(num);
            sb.append(", removed: ");
            sb.append(c(bitmap));
            sb.append(", this: ");
            sb.append(this);
            throw new NullPointerException(sb.toString());
        } else if (num2.intValue() == 1) {
            a2.remove(num);
        } else {
            a2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public final NavigableMap<Integer, Integer> a(Config config) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f7329c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f7329c.put(config, treeMap);
        return treeMap;
    }

    public static String a(int i2, Config config) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i2);
        sb.append("](");
        sb.append(config);
        sb.append(")");
        return sb.toString();
    }
}
