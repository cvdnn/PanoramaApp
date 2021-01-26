package e.d.a.n.p.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.baidu.mobstat.Config;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import e.c.f.n.n;
import e.d.a.n.g;
import e.d.a.n.h;
import e.d.a.n.i;
import e.d.a.n.n.c0.d;
import e.d.a.n.n.w;
import e.d.a.t.j;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler */
public final class m {

    /* renamed from: f reason: collision with root package name */
    public static final g<e.d.a.n.b> f7695f = g.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", e.d.a.n.b.f7219c);

    /* renamed from: g reason: collision with root package name */
    public static final g<i> f7696g = g.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", i.SRGB);

    /* renamed from: h reason: collision with root package name */
    public static final g<Boolean> f7697h;

    /* renamed from: i reason: collision with root package name */
    public static final g<Boolean> f7698i;

    /* renamed from: j reason: collision with root package name */
    public static final Set<String> f7699j = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
    public static final b k = new a();
    public static final Set<ImageType> l = Collections.unmodifiableSet(EnumSet.of(ImageType.JPEG, ImageType.PNG_A, ImageType.PNG));
    public static final Queue<Options> m = j.a(0);

    /* renamed from: a reason: collision with root package name */
    public final d f7700a;

    /* renamed from: b reason: collision with root package name */
    public final DisplayMetrics f7701b;

    /* renamed from: c reason: collision with root package name */
    public final e.d.a.n.n.c0.b f7702c;

    /* renamed from: d reason: collision with root package name */
    public final List<ImageHeaderParser> f7703d;

    /* renamed from: e reason: collision with root package name */
    public final r f7704e = r.b();

    /* compiled from: Downsampler */
    public class a implements b {
        public void a() {
        }

        public void a(d dVar, Bitmap bitmap) {
        }
    }

    /* compiled from: Downsampler */
    public interface b {
        void a();

        void a(d dVar, Bitmap bitmap) throws IOException;
    }

    static {
        g<l> gVar = l.f7690f;
        Boolean valueOf = Boolean.valueOf(false);
        f7697h = g.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", valueOf);
        f7698i = g.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", valueOf);
    }

    public m(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, d dVar, e.d.a.n.n.c0.b bVar) {
        this.f7703d = list;
        String str = "Argument must not be null";
        n.a(displayMetrics, str);
        this.f7701b = displayMetrics;
        n.a(dVar, str);
        this.f7700a = dVar;
        n.a(bVar, str);
        this.f7702c = bVar;
    }

    public static boolean a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    public static int b(double d2) {
        return (int) (d2 + 0.5d);
    }

    public static int[] b(s sVar, Options options, b bVar, d dVar) throws IOException {
        options.inJustDecodeBounds = true;
        a(sVar, options, bVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public w<Bitmap> a(InputStream inputStream, int i2, int i3, h hVar, b bVar) throws IOException {
        return a((s) new e.d.a.n.p.c.s.a(inputStream, this.f7703d, this.f7702c), i2, i3, hVar, bVar);
    }

    public final w<Bitmap> a(s sVar, int i2, int i3, h hVar, b bVar) throws IOException {
        h hVar2 = hVar;
        byte[] bArr = (byte[]) this.f7702c.b(65536, byte[].class);
        Options a2 = a();
        a2.inTempStorage = bArr;
        try {
            return e.a(a(sVar, a2, (l) hVar2.a(l.f7690f), (e.d.a.n.b) hVar2.a(f7695f), (i) hVar2.a(f7696g), hVar2.a(f7698i) != null && ((Boolean) hVar2.a(f7698i)).booleanValue(), i2, i3, ((Boolean) hVar2.a(f7697h)).booleanValue(), bVar), this.f7700a);
        } finally {
            a(a2);
            this.f7702c.a(bArr);
        }
    }

    public static void b(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:133:0x033c, code lost:
        if (r4 != r6) goto L_0x0340;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0329 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x034a  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03b8  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03c2  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x03d3  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x03e8  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03eb  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0412  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0531  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0237  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap a(e.d.a.n.p.c.s r33, android.graphics.BitmapFactory.Options r34, e.d.a.n.p.c.l r35, e.d.a.n.b r36, e.d.a.n.i r37, boolean r38, int r39, int r40, boolean r41, e.d.a.n.p.c.m.b r42) throws java.io.IOException {
        /*
            r32 = this;
            r1 = r32
            r2 = r33
            r3 = r34
            r0 = r35
            r4 = r36
            r5 = r39
            r6 = r40
            r7 = r42
            long r8 = e.d.a.t.f.a()
            e.d.a.n.n.c0.d r10 = r1.f7700a
            int[] r10 = b(r2, r3, r7, r10)
            r11 = 0
            r12 = r10[r11]
            r13 = 1
            r10 = r10[r13]
            java.lang.String r14 = r3.outMimeType
            r15 = -1
            if (r12 == r15) goto L_0x002b
            if (r10 != r15) goto L_0x0028
            goto L_0x002b
        L_0x0028:
            r15 = r38
            goto L_0x002c
        L_0x002b:
            r15 = r11
        L_0x002c:
            int r16 = r33.a()
            switch(r16) {
                case 3: goto L_0x003c;
                case 4: goto L_0x003c;
                case 5: goto L_0x0039;
                case 6: goto L_0x0039;
                case 7: goto L_0x0036;
                case 8: goto L_0x0036;
                default: goto L_0x0033;
            }
        L_0x0033:
            r38 = r11
            goto L_0x0040
        L_0x0036:
            r17 = 270(0x10e, float:3.78E-43)
            goto L_0x003e
        L_0x0039:
            r17 = 90
            goto L_0x003e
        L_0x003c:
            r17 = 180(0xb4, float:2.52E-43)
        L_0x003e:
            r38 = r17
        L_0x0040:
            switch(r16) {
                case 2: goto L_0x0044;
                case 3: goto L_0x0044;
                case 4: goto L_0x0044;
                case 5: goto L_0x0044;
                case 6: goto L_0x0044;
                case 7: goto L_0x0044;
                case 8: goto L_0x0044;
                default: goto L_0x0043;
            }
        L_0x0043:
            goto L_0x0045
        L_0x0044:
            r11 = r13
        L_0x0045:
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 != r13) goto L_0x0057
            boolean r17 = a(r38)
            if (r17 == 0) goto L_0x0053
            r17 = r8
            r8 = r10
            goto L_0x005a
        L_0x0053:
            r17 = r8
            r8 = r12
            goto L_0x005a
        L_0x0057:
            r17 = r8
            r8 = r5
        L_0x005a:
            if (r6 != r13) goto L_0x0066
            boolean r9 = a(r38)
            if (r9 == 0) goto L_0x0064
            r9 = r12
            goto L_0x0067
        L_0x0064:
            r9 = r10
            goto L_0x0067
        L_0x0066:
            r9 = r6
        L_0x0067:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r13 = r33.c()
            e.d.a.n.n.c0.d r6 = r1.f7700a
            java.lang.String r5 = "]"
            r19 = r14
            java.lang.String r14 = ", target density: "
            java.lang.String r4 = ", density: "
            r20 = r11
            java.lang.String r11 = "x"
            r21 = r15
            java.lang.String r15 = "Downsampler"
            if (r12 <= 0) goto L_0x0293
            if (r10 > 0) goto L_0x008d
            r0 = 3
            r6 = r9
            r9 = r12
            r1 = r14
            r7 = r15
            r14 = r10
            r10 = r8
            r8 = r0
            r0 = r5
            r5 = r11
            goto L_0x029c
        L_0x008d:
            boolean r22 = a(r38)
            r23 = r4
            if (r22 == 0) goto L_0x009a
            r22 = r5
            r1 = r10
            r5 = r12
            goto L_0x009e
        L_0x009a:
            r22 = r5
            r5 = r10
            r1 = r12
        L_0x009e:
            float r4 = r0.b(r1, r5, r8, r9)
            r24 = 0
            int r24 = (r4 > r24 ? 1 : (r4 == r24 ? 0 : -1))
            if (r24 <= 0) goto L_0x024e
            r24 = r14
            e.d.a.n.p.c.l$e r14 = r0.a(r1, r5, r8, r9)
            if (r14 == 0) goto L_0x0246
            r25 = r10
            float r10 = (float) r1
            r26 = r11
            float r11 = r4 * r10
            r27 = r12
            double r11 = (double) r11
            int r11 = b(r11)
            float r12 = (float) r5
            r28 = r15
            float r15 = r4 * r12
            r29 = r8
            r30 = r9
            double r8 = (double) r15
            int r8 = b(r8)
            int r9 = r1 / r11
            int r8 = r5 / r8
            e.d.a.n.p.c.l$e r11 = e.d.a.n.p.c.l.e.MEMORY
            if (r14 != r11) goto L_0x00d9
            int r8 = java.lang.Math.max(r9, r8)
            goto L_0x00dd
        L_0x00d9:
            int r8 = java.lang.Math.min(r9, r8)
        L_0x00dd:
            int r9 = android.os.Build.VERSION.SDK_INT
            r11 = 23
            if (r9 > r11) goto L_0x00ef
            java.util.Set<java.lang.String> r9 = f7699j
            java.lang.String r11 = r3.outMimeType
            boolean r9 = r9.contains(r11)
            if (r9 == 0) goto L_0x00ef
            r8 = 1
            goto L_0x0106
        L_0x00ef:
            int r8 = java.lang.Integer.highestOneBit(r8)
            r9 = 1
            int r8 = java.lang.Math.max(r9, r8)
            e.d.a.n.p.c.l$e r9 = e.d.a.n.p.c.l.e.MEMORY
            if (r14 != r9) goto L_0x0106
            float r9 = (float) r8
            r11 = 1065353216(0x3f800000, float:1.0)
            float r11 = r11 / r4
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L_0x0106
            int r8 = r8 << 1
        L_0x0106:
            r3.inSampleSize = r8
            com.bumptech.glide.load.ImageHeaderParser$ImageType r9 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG
            if (r13 != r9) goto L_0x012d
            r1 = 8
            int r1 = java.lang.Math.min(r8, r1)
            float r1 = (float) r1
            float r10 = r10 / r1
            double r5 = (double) r10
            double r5 = java.lang.Math.ceil(r5)
            int r5 = (int) r5
            float r12 = r12 / r1
            double r9 = (double) r12
            double r9 = java.lang.Math.ceil(r9)
            int r1 = (int) r9
            int r6 = r8 / 8
            if (r6 <= 0) goto L_0x0127
            int r5 = r5 / r6
            int r1 = r1 / r6
        L_0x0127:
            r10 = r29
            r6 = r30
            goto L_0x0190
        L_0x012d:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r9 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG
            if (r13 == r9) goto L_0x0180
            com.bumptech.glide.load.ImageHeaderParser$ImageType r9 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A
            if (r13 != r9) goto L_0x0136
            goto L_0x0180
        L_0x0136:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r9 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP
            if (r13 == r9) goto L_0x015f
            com.bumptech.glide.load.ImageHeaderParser$ImageType r9 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A
            if (r13 != r9) goto L_0x013f
            goto L_0x015f
        L_0x013f:
            int r9 = r1 % r8
            if (r9 != 0) goto L_0x0154
            int r9 = r5 % r8
            if (r9 == 0) goto L_0x0148
            goto L_0x0154
        L_0x0148:
            int r1 = r1 / r8
            int r5 = r5 / r8
            r10 = r29
            r6 = r30
            r31 = r5
            r5 = r1
            r1 = r31
            goto L_0x0190
        L_0x0154:
            int[] r1 = b(r2, r3, r7, r6)
            r5 = 0
            r5 = r1[r5]
            r6 = 1
            r1 = r1[r6]
            goto L_0x0127
        L_0x015f:
            int r1 = android.os.Build.VERSION.SDK_INT
            r5 = 24
            if (r1 < r5) goto L_0x0171
            float r1 = (float) r8
            float r10 = r10 / r1
            int r5 = java.lang.Math.round(r10)
            float r12 = r12 / r1
            int r1 = java.lang.Math.round(r12)
            goto L_0x0127
        L_0x0171:
            float r1 = (float) r8
            float r10 = r10 / r1
            double r5 = (double) r10
            double r5 = java.lang.Math.floor(r5)
            int r5 = (int) r5
            float r12 = r12 / r1
            double r9 = (double) r12
            double r9 = java.lang.Math.floor(r9)
            goto L_0x018e
        L_0x0180:
            float r1 = (float) r8
            float r10 = r10 / r1
            double r5 = (double) r10
            double r5 = java.lang.Math.floor(r5)
            int r5 = (int) r5
            float r12 = r12 / r1
            double r9 = (double) r12
            double r9 = java.lang.Math.floor(r9)
        L_0x018e:
            int r1 = (int) r9
            goto L_0x0127
        L_0x0190:
            float r0 = r0.b(r5, r1, r10, r6)
            double r11 = (double) r0
            int r0 = a(r11)
            double r13 = (double) r0
            double r13 = r13 * r11
            int r9 = b(r13)
            float r13 = (float) r9
            float r0 = (float) r0
            float r13 = r13 / r0
            double r13 = (double) r13
            double r13 = r11 / r13
            r15 = r8
            double r7 = (double) r9
            double r13 = r13 * r7
            int r0 = b(r13)
            r3.inTargetDensity = r0
            int r0 = a(r11)
            r3.inDensity = r0
            int r7 = r3.inTargetDensity
            if (r7 <= 0) goto L_0x01be
            if (r0 <= 0) goto L_0x01be
            if (r7 == r0) goto L_0x01be
            r0 = 1
            goto L_0x01bf
        L_0x01be:
            r0 = 0
        L_0x01bf:
            if (r0 == 0) goto L_0x01c5
            r0 = 1
            r3.inScaled = r0
            goto L_0x01ca
        L_0x01c5:
            r0 = 0
            r3.inTargetDensity = r0
            r3.inDensity = r0
        L_0x01ca:
            r0 = 2
            r7 = r28
            boolean r0 = android.util.Log.isLoggable(r7, r0)
            if (r0 == 0) goto L_0x0237
            java.lang.String r0 = "Calculate scaling, source: ["
            java.lang.String r8 = "], degreesToRotate: "
            r14 = r25
            r13 = r26
            r9 = r27
            java.lang.StringBuilder r0 = e.a.a.a.a.a(r0, r9, r13, r14, r8)
            r8 = r38
            r0.append(r8)
            java.lang.String r8 = ", target: ["
            r0.append(r8)
            r0.append(r10)
            r0.append(r13)
            r0.append(r6)
            java.lang.String r8 = "], power of two scaled: ["
            r0.append(r8)
            r0.append(r5)
            r0.append(r13)
            r0.append(r1)
            java.lang.String r1 = "], exact scale factor: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = ", power of 2 sample size: "
            r0.append(r1)
            r8 = r15
            r0.append(r8)
            java.lang.String r1 = ", adjusted scale factor: "
            r0.append(r1)
            r0.append(r11)
            r1 = r24
            r0.append(r1)
            int r4 = r3.inTargetDensity
            r0.append(r4)
            r4 = r23
            r0.append(r4)
            int r5 = r3.inDensity
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r7, r0)
            goto L_0x0241
        L_0x0237:
            r4 = r23
            r1 = r24
            r14 = r25
            r13 = r26
            r9 = r27
        L_0x0241:
            r8 = r32
            r5 = r13
            goto L_0x02c9
        L_0x0246:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot round with null rounding"
            r0.<init>(r1)
            throw r0
        L_0x024e:
            r6 = r9
            r14 = r10
            r13 = r11
            r9 = r12
            r10 = r8
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot scale with factor: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = " from: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ", source: ["
            r2.append(r0)
            r2.append(r9)
            r2.append(r13)
            r2.append(r14)
            java.lang.String r0 = "], target: ["
            r2.append(r0)
            r2.append(r10)
            r2.append(r13)
            r2.append(r6)
            r0 = r22
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0293:
            r0 = r5
            r6 = r9
            r5 = r11
            r9 = r12
            r1 = r14
            r7 = r15
            r14 = r10
            r10 = r8
            r8 = 3
        L_0x029c:
            boolean r8 = android.util.Log.isLoggable(r7, r8)
            if (r8 == 0) goto L_0x02c7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r11 = "Unable to determine dimensions for: "
            r8.append(r11)
            r8.append(r13)
            java.lang.String r11 = " with target ["
            r8.append(r11)
            r8.append(r10)
            r8.append(r5)
            r8.append(r6)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            android.util.Log.d(r7, r0)
        L_0x02c7:
            r8 = r32
        L_0x02c9:
            e.d.a.n.p.c.r r0 = r8.f7704e
            r13 = r20
            r11 = r21
            boolean r0 = r0.a(r10, r6, r11, r13)
            if (r0 == 0) goto L_0x02dc
            android.graphics.Bitmap$Config r11 = android.graphics.Bitmap.Config.HARDWARE
            r3.inPreferredConfig = r11
            r11 = 0
            r3.inMutable = r11
        L_0x02dc:
            if (r0 == 0) goto L_0x02e0
            r11 = r4
            goto L_0x031e
        L_0x02e0:
            e.d.a.n.b r0 = e.d.a.n.b.PREFER_ARGB_8888
            r11 = r4
            r4 = r36
            if (r4 == r0) goto L_0x0320
            com.bumptech.glide.load.ImageHeaderParser$ImageType r0 = r33.c()     // Catch:{ IOException -> 0x02f0 }
            boolean r0 = r0.hasAlpha()     // Catch:{ IOException -> 0x02f0 }
            goto L_0x030d
        L_0x02f0:
            r0 = move-exception
            r12 = 3
            boolean r12 = android.util.Log.isLoggable(r7, r12)
            if (r12 == 0) goto L_0x030c
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Cannot determine whether the image has alpha or not from header, format "
            r12.append(r13)
            r12.append(r4)
            java.lang.String r4 = r12.toString()
            android.util.Log.d(r7, r4, r0)
        L_0x030c:
            r0 = 0
        L_0x030d:
            if (r0 == 0) goto L_0x0312
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x0314
        L_0x0312:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.RGB_565
        L_0x0314:
            r3.inPreferredConfig = r0
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
            if (r0 != r4) goto L_0x031e
            r0 = 1
            r3.inDither = r0
            goto L_0x0325
        L_0x031e:
            r0 = 1
            goto L_0x0325
        L_0x0320:
            r0 = 1
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            r3.inPreferredConfig = r4
        L_0x0325:
            int r4 = r3.inSampleSize
            if (r9 < 0) goto L_0x0334
            if (r14 < 0) goto L_0x0334
            if (r41 == 0) goto L_0x0334
            r31 = r10
            r10 = r6
            r6 = r31
            goto L_0x03ac
        L_0x0334:
            int r4 = r3.inTargetDensity
            if (r4 <= 0) goto L_0x033f
            int r6 = r3.inDensity
            if (r6 <= 0) goto L_0x033f
            if (r4 == r6) goto L_0x033f
            goto L_0x0340
        L_0x033f:
            r0 = 0
        L_0x0340:
            if (r0 == 0) goto L_0x034a
            int r0 = r3.inTargetDensity
            float r0 = (float) r0
            int r4 = r3.inDensity
            float r4 = (float) r4
            float r0 = r0 / r4
            goto L_0x034c
        L_0x034a:
            r0 = 1065353216(0x3f800000, float:1.0)
        L_0x034c:
            int r4 = r3.inSampleSize
            float r6 = (float) r9
            float r10 = (float) r4
            float r6 = r6 / r10
            double r12 = (double) r6
            double r12 = java.lang.Math.ceil(r12)
            int r6 = (int) r12
            float r12 = (float) r14
            float r12 = r12 / r10
            double r12 = (double) r12
            double r12 = java.lang.Math.ceil(r12)
            int r10 = (int) r12
            float r6 = (float) r6
            float r6 = r6 * r0
            int r6 = java.lang.Math.round(r6)
            float r10 = (float) r10
            float r10 = r10 * r0
            int r10 = java.lang.Math.round(r10)
            r12 = 2
            boolean r12 = android.util.Log.isLoggable(r7, r12)
            if (r12 == 0) goto L_0x03ac
            java.lang.String r12 = "Calculated target ["
            java.lang.String r13 = "] for source ["
            java.lang.StringBuilder r12 = e.a.a.a.a.a(r12, r6, r5, r10, r13)
            r12.append(r9)
            r12.append(r5)
            r12.append(r14)
            java.lang.String r13 = "], sampleSize: "
            r12.append(r13)
            r12.append(r4)
            java.lang.String r4 = ", targetDensity: "
            r12.append(r4)
            int r4 = r3.inTargetDensity
            r12.append(r4)
            r12.append(r11)
            int r4 = r3.inDensity
            r12.append(r4)
            java.lang.String r4 = ", density multiplier: "
            r12.append(r4)
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            android.util.Log.v(r7, r0)
        L_0x03ac:
            r0 = 26
            if (r6 <= 0) goto L_0x03cd
            if (r10 <= 0) goto L_0x03cd
            e.d.a.n.n.c0.d r4 = r8.f7700a
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r0) goto L_0x03c2
            android.graphics.Bitmap$Config r12 = r3.inPreferredConfig
            android.graphics.Bitmap$Config r13 = android.graphics.Bitmap.Config.HARDWARE
            if (r12 != r13) goto L_0x03bf
            goto L_0x03cd
        L_0x03bf:
            android.graphics.Bitmap$Config r12 = r3.outConfig
            goto L_0x03c3
        L_0x03c2:
            r12 = 0
        L_0x03c3:
            if (r12 != 0) goto L_0x03c7
            android.graphics.Bitmap$Config r12 = r3.inPreferredConfig
        L_0x03c7:
            android.graphics.Bitmap r4 = r4.b(r6, r10, r12)
            r3.inBitmap = r4
        L_0x03cd:
            int r4 = android.os.Build.VERSION.SDK_INT
            r6 = 28
            if (r4 < r6) goto L_0x03f4
            e.d.a.n.i r0 = e.d.a.n.i.DISPLAY_P3
            r4 = r37
            if (r4 != r0) goto L_0x03e5
            android.graphics.ColorSpace r0 = r3.outColorSpace
            if (r0 == 0) goto L_0x03e5
            boolean r0 = r0.isWideGamut()
            if (r0 == 0) goto L_0x03e5
            r0 = 1
            goto L_0x03e6
        L_0x03e5:
            r0 = 0
        L_0x03e6:
            if (r0 == 0) goto L_0x03eb
            android.graphics.ColorSpace$Named r0 = android.graphics.ColorSpace.Named.DISPLAY_P3
            goto L_0x03ed
        L_0x03eb:
            android.graphics.ColorSpace$Named r0 = android.graphics.ColorSpace.Named.SRGB
        L_0x03ed:
            android.graphics.ColorSpace r0 = android.graphics.ColorSpace.get(r0)
            r3.inPreferredColorSpace = r0
            goto L_0x03fe
        L_0x03f4:
            if (r4 < r0) goto L_0x03fe
            android.graphics.ColorSpace$Named r0 = android.graphics.ColorSpace.Named.SRGB
            android.graphics.ColorSpace r0 = android.graphics.ColorSpace.get(r0)
            r3.inPreferredColorSpace = r0
        L_0x03fe:
            e.d.a.n.n.c0.d r0 = r8.f7700a
            r4 = r42
            android.graphics.Bitmap r0 = a(r2, r3, r4, r0)
            e.d.a.n.n.c0.d r2 = r8.f7700a
            r4.a(r2, r0)
            r2 = 2
            boolean r2 = android.util.Log.isLoggable(r7, r2)
            if (r2 == 0) goto L_0x0494
            java.lang.String r2 = "Decoded "
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            java.lang.String r4 = a(r0)
            r2.append(r4)
            java.lang.String r4 = " from ["
            r2.append(r4)
            r2.append(r9)
            r2.append(r5)
            r2.append(r14)
            java.lang.String r4 = "] "
            r2.append(r4)
            r4 = r19
            r2.append(r4)
            java.lang.String r4 = " with inBitmap "
            r2.append(r4)
            android.graphics.Bitmap r4 = r3.inBitmap
            java.lang.String r4 = a(r4)
            r2.append(r4)
            java.lang.String r4 = " for ["
            r2.append(r4)
            r4 = r39
            r2.append(r4)
            r2.append(r5)
            r4 = r40
            r2.append(r4)
            java.lang.String r4 = "], sample size: "
            r2.append(r4)
            int r4 = r3.inSampleSize
            r2.append(r4)
            r2.append(r11)
            int r4 = r3.inDensity
            r2.append(r4)
            r2.append(r1)
            int r1 = r3.inTargetDensity
            r2.append(r1)
            java.lang.String r1 = ", thread: "
            r2.append(r1)
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.String r1 = r1.getName()
            r2.append(r1)
            java.lang.String r1 = ", duration: "
            r2.append(r1)
            double r3 = e.d.a.t.f.a(r17)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            android.util.Log.v(r7, r1)
        L_0x0494:
            if (r0 == 0) goto L_0x0531
            android.util.DisplayMetrics r1 = r8.f7701b
            int r1 = r1.densityDpi
            r0.setDensity(r1)
            e.d.a.n.n.c0.d r1 = r8.f7700a
            switch(r16) {
                case 2: goto L_0x04a4;
                case 3: goto L_0x04a4;
                case 4: goto L_0x04a4;
                case 5: goto L_0x04a4;
                case 6: goto L_0x04a4;
                case 7: goto L_0x04a4;
                case 8: goto L_0x04a4;
                default: goto L_0x04a2;
            }
        L_0x04a2:
            r2 = 0
            goto L_0x04a5
        L_0x04a4:
            r2 = 1
        L_0x04a5:
            if (r2 != 0) goto L_0x04aa
            r1 = r0
            goto L_0x0525
        L_0x04aa:
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            r3 = -1028390912(0xffffffffc2b40000, float:-90.0)
            r4 = 1119092736(0x42b40000, float:90.0)
            r5 = 1127481344(0x43340000, float:180.0)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            switch(r16) {
                case 2: goto L_0x04e2;
                case 3: goto L_0x04de;
                case 4: goto L_0x04d5;
                case 5: goto L_0x04cc;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04bf;
                case 8: goto L_0x04bb;
                default: goto L_0x04ba;
            }
        L_0x04ba:
            goto L_0x04e7
        L_0x04bb:
            r2.setRotate(r3)
            goto L_0x04e7
        L_0x04bf:
            r2.setRotate(r3)
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.postScale(r6, r3)
            goto L_0x04e7
        L_0x04c8:
            r2.setRotate(r4)
            goto L_0x04e7
        L_0x04cc:
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.setRotate(r4)
            r2.postScale(r6, r3)
            goto L_0x04e7
        L_0x04d5:
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.setRotate(r5)
            r2.postScale(r6, r3)
            goto L_0x04e7
        L_0x04de:
            r2.setRotate(r5)
            goto L_0x04e7
        L_0x04e2:
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.setScale(r6, r3)
        L_0x04e7:
            android.graphics.RectF r3 = new android.graphics.RectF
            int r4 = r0.getWidth()
            float r4 = (float) r4
            int r5 = r0.getHeight()
            float r5 = (float) r5
            r6 = 0
            r3.<init>(r6, r6, r4, r5)
            r2.mapRect(r3)
            float r4 = r3.width()
            int r4 = java.lang.Math.round(r4)
            float r5 = r3.height()
            int r5 = java.lang.Math.round(r5)
            android.graphics.Bitmap$Config r6 = e.d.a.n.p.c.z.a(r0)
            android.graphics.Bitmap r1 = r1.a(r4, r5, r6)
            float r4 = r3.left
            float r4 = -r4
            float r3 = r3.top
            float r3 = -r3
            r2.postTranslate(r4, r3)
            boolean r3 = r0.hasAlpha()
            r1.setHasAlpha(r3)
            e.d.a.n.p.c.z.a(r0, r1, r2)
        L_0x0525:
            boolean r2 = r0.equals(r1)
            if (r2 != 0) goto L_0x0532
            e.d.a.n.n.c0.d r2 = r8.f7700a
            r2.a(r0)
            goto L_0x0532
        L_0x0531:
            r1 = 0
        L_0x0532:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.p.c.m.a(e.d.a.n.p.c.s, android.graphics.BitmapFactory$Options, e.d.a.n.p.c.l, e.d.a.n.b, e.d.a.n.i, boolean, int, int, boolean, e.d.a.n.p.c.m$b):android.graphics.Bitmap");
    }

    public static int a(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x004a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(e.d.a.n.p.c.s r5, android.graphics.BitmapFactory.Options r6, e.d.a.n.p.c.m.b r7, e.d.a.n.n.c0.d r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto L_0x000c
            r7.a()
            r5.b()
        L_0x000c:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = e.d.a.n.p.c.z.f7741d
            r4.lock()
            android.graphics.Bitmap r5 = r5.a(r6)     // Catch:{ IllegalArgumentException -> 0x0023 }
            java.util.concurrent.locks.Lock r6 = e.d.a.n.p.c.z.f7741d
            r6.unlock()
            return r5
        L_0x0021:
            r5 = move-exception
            goto L_0x004c
        L_0x0023:
            r4 = move-exception
            java.io.IOException r1 = a(r4, r1, r2, r3, r6)     // Catch:{ all -> 0x0021 }
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0021 }
            if (r2 == 0) goto L_0x0034
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch:{ all -> 0x0021 }
        L_0x0034:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x004b
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch:{ IOException -> 0x004a }
            r8.a(r0)     // Catch:{ IOException -> 0x004a }
            r0 = 0
            r6.inBitmap = r0     // Catch:{ IOException -> 0x004a }
            android.graphics.Bitmap r5 = a(r5, r6, r7, r8)     // Catch:{ IOException -> 0x004a }
            java.util.concurrent.locks.Lock r6 = e.d.a.n.p.c.z.f7741d
            r6.unlock()
            return r5
        L_0x004a:
            throw r1     // Catch:{ all -> 0x0021 }
        L_0x004b:
            throw r1     // Catch:{ all -> 0x0021 }
        L_0x004c:
            java.util.concurrent.locks.Lock r6 = e.d.a.n.p.c.z.f7741d
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.p.c.m.a(e.d.a.n.p.c.s, android.graphics.BitmapFactory$Options, e.d.a.n.p.c.m$b, e.d.a.n.n.c0.d):android.graphics.Bitmap");
    }

    @TargetApi(19)
    public static String a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder a2 = e.a.a.a.a.a(" (");
        a2.append(bitmap.getAllocationByteCount());
        a2.append(")");
        String sb = a2.toString();
        StringBuilder a3 = e.a.a.a.a.a("[");
        a3.append(bitmap.getWidth());
        a3.append(Config.EVENT_HEAT_X);
        a3.append(bitmap.getHeight());
        a3.append("] ");
        a3.append(bitmap.getConfig());
        a3.append(sb);
        return a3.toString();
    }

    public static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, Options options) {
        StringBuilder a2 = e.a.a.a.a.a("Exception decoding bitmap, outWidth: ", i2, ", outHeight: ", i3, ", outMimeType: ");
        a2.append(str);
        a2.append(", inBitmap: ");
        a2.append(a(options.inBitmap));
        return new IOException(a2.toString(), illegalArgumentException);
    }

    public static synchronized Options a() {
        Options options;
        synchronized (m.class) {
            synchronized (m) {
                options = (Options) m.poll();
            }
            if (options == null) {
                options = new Options();
                b(options);
            }
        }
        return options;
    }

    public static void a(Options options) {
        b(options);
        synchronized (m) {
            m.offer(options);
        }
    }
}
