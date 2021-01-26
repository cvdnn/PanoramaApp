package e.d.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import e.c.f.n.n;
import e.d.a.n.n.k;
import e.d.a.n.p.c.l;
import e.d.a.n.p.c.q;
import e.d.a.r.b;
import e.d.a.r.c;
import e.d.a.r.d;
import e.d.a.r.e;
import e.d.a.r.g;
import e.d.a.r.h.h;
import e.d.a.t.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executor;

/* compiled from: RequestBuilder */
public class i<TranscodeType> extends e.d.a.r.a<i<TranscodeType>> implements Cloneable {
    public final Context A;
    public final j B;
    public final Class<TranscodeType> C;
    public final d D;
    public k<?, ? super TranscodeType> E;
    public Object F;
    public List<d<TranscodeType>> G;
    public boolean H = true;
    public boolean I;

    /* compiled from: RequestBuilder */
    public static /* synthetic */ class a {

        /* renamed from: a reason: collision with root package name */
        public static final /* synthetic */ int[] f7130a;

        /* renamed from: b reason: collision with root package name */
        public static final /* synthetic */ int[] f7131b;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|5|6|7|8|9|(2:11|12)|13|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|5|6|7|8|9|11|12|13|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0074 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                e.d.a.f[] r0 = e.d.a.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7131b = r0
                r1 = 1
                r2 = 3
                e.d.a.f r3 = e.d.a.f.LOW     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r3 = f7131b     // Catch:{ NoSuchFieldError -> 0x0016 }
                e.d.a.f r4 = e.d.a.f.NORMAL     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r0] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r3 = f7131b     // Catch:{ NoSuchFieldError -> 0x001c }
                e.d.a.f r4 = e.d.a.f.HIGH     // Catch:{ NoSuchFieldError -> 0x001c }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r3 = 4
                int[] r4 = f7131b     // Catch:{ NoSuchFieldError -> 0x0024 }
                e.d.a.f r5 = e.d.a.f.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0024 }
                r5 = 0
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f7130a = r4
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r1 = f7130a     // Catch:{ NoSuchFieldError -> 0x003f }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x003f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003f }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003f }
            L_0x003f:
                int[] r0 = f7130a     // Catch:{ NoSuchFieldError -> 0x0049 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7130a     // Catch:{ NoSuchFieldError -> 0x0053 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = f7130a     // Catch:{ NoSuchFieldError -> 0x005e }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x005e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r0 = f7130a     // Catch:{ NoSuchFieldError -> 0x0069 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r0 = f7130a     // Catch:{ NoSuchFieldError -> 0x0074 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r0 = f7130a     // Catch:{ NoSuchFieldError -> 0x0080 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0080 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0080 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0080 }
            L_0x0080:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.d.a.i.a.<clinit>():void");
        }
    }

    static {
        e eVar = (e) ((e) ((e) new e().a(k.f7436b)).a(f.LOW)).a(true);
    }

    @SuppressLint({"CheckResult"})
    public i(b bVar, j jVar, Class<TranscodeType> cls, Context context) {
        this.B = jVar;
        this.C = cls;
        this.A = context;
        d dVar = jVar.f7132a.f7085c;
        k<?, ?> kVar = (k) dVar.f7106f.get(cls);
        if (kVar == null) {
            for (Entry entry : dVar.f7106f.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    kVar = (k) entry.getValue();
                }
            }
        }
        if (kVar == null) {
            kVar = d.k;
        }
        this.E = kVar;
        this.D = bVar.f7085c;
        for (d dVar2 : jVar.f7141j) {
            if (dVar2 != null) {
                if (this.G == null) {
                    this.G = new ArrayList();
                }
                this.G.add(dVar2);
            }
        }
        a((e.d.a.r.a<?>) jVar.d());
    }

    public i<TranscodeType> a(e.d.a.r.a<?> aVar) {
        n.a(aVar, "Argument must not be null");
        return (i) super.a(aVar);
    }

    public e.d.a.r.a clone() {
        i iVar = (i) super.clone();
        iVar.E = iVar.E.clone();
        return iVar;
    }

    public final <Y extends h<TranscodeType>> Y a(Y y, d<TranscodeType> dVar, e.d.a.r.a<?> aVar, Executor executor) {
        Y y2 = y;
        e.d.a.r.a<?> aVar2 = aVar;
        String str = "Argument must not be null";
        n.a(y2, str);
        if (this.I) {
            b a2 = a(new Object(), (h<TranscodeType>) y, dVar, (c) null, this.E, aVar2.f7858d, aVar2.k, aVar2.f7864j, aVar, executor);
            b c2 = y.c();
            if (a2.a(c2)) {
                if (!(!aVar2.f7863i && c2.c())) {
                    n.a(c2, str);
                    if (!c2.isRunning()) {
                        c2.b();
                    }
                    return y2;
                }
            }
            this.B.a((h<?>) y2);
            y2.a(a2);
            this.B.a(y2, a2);
            return y2;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    /* renamed from: clone reason: collision with other method in class */
    public Object m77clone() throws CloneNotSupportedException {
        i iVar = (i) super.clone();
        iVar.E = iVar.E.clone();
        return iVar;
    }

    public e.d.a.r.h.i<ImageView, TranscodeType> a(ImageView imageView) {
        e.d.a.r.a aVar;
        e.d.a.r.h.i<ImageView, TranscodeType> iVar;
        j.a();
        n.a(imageView, "Argument must not be null");
        if (!e.d.a.r.a.b(this.f7855a, 2048) && this.n && imageView.getScaleType() != null) {
            switch (a.f7130a[imageView.getScaleType().ordinal()]) {
                case 1:
                    e.d.a.r.a clone = clone();
                    if (clone != null) {
                        aVar = clone.a(l.f7687c, (e.d.a.n.l<Bitmap>) new e.d.a.n.p.c.i<Bitmap>());
                        break;
                    } else {
                        throw null;
                    }
                case 2:
                    e.d.a.r.a clone2 = clone();
                    if (clone2 != null) {
                        e.d.a.r.a a2 = clone2.a(l.f7686b, (e.d.a.n.l<Bitmap>) new e.d.a.n.p.c.j<Bitmap>());
                        a2.y = true;
                        aVar = a2;
                        break;
                    } else {
                        throw null;
                    }
                case 3:
                case 4:
                case 5:
                    e.d.a.r.a clone3 = clone();
                    if (clone3 != null) {
                        e.d.a.r.a a3 = clone3.a(l.f7685a, (e.d.a.n.l<Bitmap>) new q<Bitmap>());
                        a3.y = true;
                        aVar = a3;
                        break;
                    } else {
                        throw null;
                    }
                case 6:
                    e.d.a.r.a clone4 = clone();
                    if (clone4 != null) {
                        e.d.a.r.a a4 = clone4.a(l.f7686b, (e.d.a.n.l<Bitmap>) new e.d.a.n.p.c.j<Bitmap>());
                        a4.y = true;
                        aVar = a4;
                        break;
                    } else {
                        throw null;
                    }
            }
        }
        aVar = this;
        d dVar = this.D;
        Class<TranscodeType> cls = this.C;
        if (dVar.f7103c != null) {
            if (Bitmap.class.equals(cls)) {
                iVar = new e.d.a.r.h.b<>(imageView);
            } else if (Drawable.class.isAssignableFrom(cls)) {
                iVar = new e.d.a.r.h.d<>(imageView);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unhandled class: ");
                sb.append(cls);
                sb.append(", try .as*(Class).transcode(ResourceTranscoder)");
                throw new IllegalArgumentException(sb.toString());
            }
            a(iVar, null, aVar, e.d.a.t.e.f7910a);
            return iVar;
        }
        throw null;
    }

    public final b a(Object obj, h<TranscodeType> hVar, d<TranscodeType> dVar, c cVar, k<?, ? super TranscodeType> kVar, f fVar, int i2, int i3, e.d.a.r.a<?> aVar, Executor executor) {
        return a(obj, hVar, dVar, aVar, cVar, kVar, fVar, i2, i3, executor);
    }

    public final b a(Object obj, h<TranscodeType> hVar, d<TranscodeType> dVar, e.d.a.r.a<?> aVar, c cVar, k<?, ? super TranscodeType> kVar, f fVar, int i2, int i3, Executor executor) {
        Context context = this.A;
        d dVar2 = this.D;
        g gVar = new g(context, dVar2, obj, this.F, this.C, aVar, i2, i3, fVar, hVar, dVar, this.G, cVar, dVar2.f7107g, kVar.f7145a, executor);
        return gVar;
    }
}
