package e.d.a.t;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import com.baidu.mobstat.Config;
import e.d.a.n.o.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* compiled from: Util */
public final class j {

    /* renamed from: a reason: collision with root package name */
    public static final char[] f7921a = "0123456789abcdef".toCharArray();

    /* renamed from: b reason: collision with root package name */
    public static final char[] f7922b = new char[64];

    /* compiled from: Util */
    public static /* synthetic */ class a {

        /* renamed from: a reason: collision with root package name */
        public static final /* synthetic */ int[] f7923a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7923a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7923a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7923a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7923a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGBA_F16     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7923a     // Catch:{ NoSuchFieldError -> 0x003e }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.d.a.t.j.a.<clinit>():void");
        }
    }

    public static String a(byte[] bArr) {
        String str;
        synchronized (f7922b) {
            char[] cArr = f7922b;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                byte b2 = bArr[i2] & 255;
                int i3 = i2 * 2;
                char[] cArr2 = f7921a;
                cArr[i3] = cArr2[b2 >>> 4];
                cArr[i3 + 1] = cArr2[b2 & 15];
            }
            str = new String(cArr);
        }
        return str;
    }

    public static boolean a(int i2, int i3) {
        if (!(i2 > 0 || i2 == Integer.MIN_VALUE)) {
            return false;
        }
        return i3 > 0 || i3 == Integer.MIN_VALUE;
    }

    public static boolean b() {
        return !c();
    }

    public static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @TargetApi(19)
    public static int a(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot obtain size for recycled Bitmap: ");
            sb.append(bitmap);
            sb.append("[");
            sb.append(bitmap.getWidth());
            sb.append(Config.EVENT_HEAT_X);
            sb.append(bitmap.getHeight());
            sb.append("] ");
            sb.append(bitmap.getConfig());
            throw new IllegalStateException(sb.toString());
        }
    }

    public static int a(int i2, int i3, Bitmap.Config config) {
        int i4 = i2 * i3;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i5 = a.f7923a[config.ordinal()];
        int i6 = 4;
        if (i5 == 1) {
            i6 = 1;
        } else if (i5 == 2 || i5 == 3) {
            i6 = 2;
        } else if (i5 == 4) {
            i6 = 8;
        }
        return i4 * i6;
    }

    public static void a() {
        if (!c()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static <T> Queue<T> a(int i2) {
        return new ArrayDeque(i2);
    }

    public static <T> List<T> a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else if (obj instanceof l) {
            return ((l) obj).a(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    public static int a(float f2) {
        return Float.floatToIntBits(f2) + 527;
    }

    public static int a(Object obj, int i2) {
        return (i2 * 31) + (obj == null ? 0 : obj.hashCode());
    }
}
