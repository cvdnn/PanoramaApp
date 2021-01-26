package e.d.a.n.p.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import e.d.a.n.g;
import e.d.a.n.h;
import e.d.a.n.k;
import e.d.a.n.n.c0.b;

/* compiled from: BitmapEncoder */
public class c implements k<Bitmap> {

    /* renamed from: b reason: collision with root package name */
    public static final g<Integer> f7669b = g.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));

    /* renamed from: c reason: collision with root package name */
    public static final g<CompressFormat> f7670c = new g<>("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, g.f7226e);

    /* renamed from: a reason: collision with root package name */
    public final b f7671a;

    public c(b bVar) {
        this.f7671a = bVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:24|41|(2:43|44)|45|46) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0067, code lost:
        if (r6 == null) goto L_0x006c;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00c0 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0062 A[Catch:{ all -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bd A[SYNTHETIC, Splitter:B:43:0x00bd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.Object r9, java.io.File r10, e.d.a.n.h r11) {
        /*
            r8 = this;
            e.d.a.n.n.w r9 = (e.d.a.n.n.w) r9
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            e.d.a.n.g<android.graphics.Bitmap$CompressFormat> r1 = f7670c
            java.lang.Object r1 = r11.a(r1)
            android.graphics.Bitmap$CompressFormat r1 = (android.graphics.Bitmap.CompressFormat) r1
            if (r1 == 0) goto L_0x0015
            goto L_0x0020
        L_0x0015:
            boolean r1 = r9.hasAlpha()
            if (r1 == 0) goto L_0x001e
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG
            goto L_0x0020
        L_0x001e:
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
        L_0x0020:
            r9.getWidth()
            r9.getHeight()
            long r2 = e.d.a.t.f.a()     // Catch:{ all -> 0x00c1 }
            e.d.a.n.g<java.lang.Integer> r4 = f7669b     // Catch:{ all -> 0x00c1 }
            java.lang.Object r4 = r11.a(r4)     // Catch:{ all -> 0x00c1 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00c1 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x00c1 }
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x005a }
            r7.<init>(r10)     // Catch:{ IOException -> 0x005a }
            e.d.a.n.n.c0.b r10 = r8.f7671a     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            if (r10 == 0) goto L_0x004a
            e.d.a.n.m.c r10 = new e.d.a.n.m.c     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            e.d.a.n.n.c0.b r6 = r8.f7671a     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            r10.<init>(r7, r6)     // Catch:{ IOException -> 0x0055, all -> 0x0053 }
            r6 = r10
            goto L_0x004b
        L_0x004a:
            r6 = r7
        L_0x004b:
            r9.compress(r1, r4, r6)     // Catch:{ IOException -> 0x005a }
            r6.close()     // Catch:{ IOException -> 0x005a }
            r5 = 1
            goto L_0x0069
        L_0x0053:
            r9 = move-exception
            goto L_0x00bb
        L_0x0055:
            r10 = move-exception
            r6 = r7
            goto L_0x005b
        L_0x0058:
            r9 = move-exception
            goto L_0x00ba
        L_0x005a:
            r10 = move-exception
        L_0x005b:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch:{ all -> 0x0058 }
            if (r4 == 0) goto L_0x0067
            java.lang.String r4 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r4, r10)     // Catch:{ all -> 0x0058 }
        L_0x0067:
            if (r6 == 0) goto L_0x006c
        L_0x0069:
            r6.close()     // Catch:{ IOException -> 0x006c }
        L_0x006c:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch:{ all -> 0x00c1 }
            if (r10 == 0) goto L_0x00b9
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c1 }
            r10.<init>()     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = "Compressed with type: "
            r10.append(r4)     // Catch:{ all -> 0x00c1 }
            r10.append(r1)     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = " of size "
            r10.append(r1)     // Catch:{ all -> 0x00c1 }
            int r1 = e.d.a.t.j.a(r9)     // Catch:{ all -> 0x00c1 }
            r10.append(r1)     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = " in "
            r10.append(r1)     // Catch:{ all -> 0x00c1 }
            double r1 = e.d.a.t.f.a(r2)     // Catch:{ all -> 0x00c1 }
            r10.append(r1)     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = ", options format: "
            r10.append(r1)     // Catch:{ all -> 0x00c1 }
            e.d.a.n.g<android.graphics.Bitmap$CompressFormat> r1 = f7670c     // Catch:{ all -> 0x00c1 }
            java.lang.Object r11 = r11.a(r1)     // Catch:{ all -> 0x00c1 }
            r10.append(r11)     // Catch:{ all -> 0x00c1 }
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch:{ all -> 0x00c1 }
            boolean r9 = r9.hasAlpha()     // Catch:{ all -> 0x00c1 }
            r10.append(r9)     // Catch:{ all -> 0x00c1 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x00c1 }
            android.util.Log.v(r0, r9)     // Catch:{ all -> 0x00c1 }
        L_0x00b9:
            return r5
        L_0x00ba:
            r7 = r6
        L_0x00bb:
            if (r7 == 0) goto L_0x00c0
            r7.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x00c0:
            throw r9     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.p.c.c.a(java.lang.Object, java.io.File, e.d.a.n.h):boolean");
    }

    public e.d.a.n.c a(h hVar) {
        return e.d.a.n.c.TRANSFORMED;
    }
}
