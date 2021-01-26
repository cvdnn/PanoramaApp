package e.d.a.n.m.p;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.util.Log;
import e.d.a.f;
import e.d.a.n.m.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher */
public class b implements d<InputStream> {

    /* renamed from: a reason: collision with root package name */
    public final Uri f7265a;

    /* renamed from: b reason: collision with root package name */
    public final d f7266b;

    /* renamed from: c reason: collision with root package name */
    public InputStream f7267c;

    /* compiled from: ThumbFetcher */
    public static class a implements c {

        /* renamed from: b reason: collision with root package name */
        public static final String[] f7268b = {"_data"};

        /* renamed from: a reason: collision with root package name */
        public final ContentResolver f7269a;

        public a(ContentResolver contentResolver) {
            this.f7269a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f7269a.query(Thumbnails.EXTERNAL_CONTENT_URI, f7268b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    /* renamed from: e.d.a.n.m.p.b$b reason: collision with other inner class name */
    /* compiled from: ThumbFetcher */
    public static class C0080b implements c {

        /* renamed from: b reason: collision with root package name */
        public static final String[] f7270b = {"_data"};

        /* renamed from: a reason: collision with root package name */
        public final ContentResolver f7271a;

        public C0080b(ContentResolver contentResolver) {
            this.f7271a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f7271a.query(Video.Thumbnails.EXTERNAL_CONTENT_URI, f7270b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    public b(Uri uri, d dVar) {
        this.f7265a = uri;
        this.f7266b = dVar;
    }

    public static b a(Context context, Uri uri, c cVar) {
        return new b(uri, new d(e.d.a.b.a(context).f7086d.a(), cVar, e.d.a.b.a(context).f7087e, context.getContentResolver()));
    }

    public void b() {
        InputStream inputStream = this.f7267c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public e.d.a.n.a c() {
        return e.d.a.n.a.LOCAL;
    }

    public void cancel() {
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Throwable, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r6v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r6v9, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v13, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r6 != 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r6 == 0) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r7 = r3;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v0, types: [java.lang.Throwable, java.io.InputStream]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [java.lang.Throwable, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.io.InputStream, ?[OBJECT, ARRAY]]
  mth insns count: 112
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0036 A[Catch:{ all -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.InputStream d() throws java.io.FileNotFoundException {
        /*
            r11 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            e.d.a.n.m.p.d r1 = r11.f7266b
            android.net.Uri r2 = r11.f7265a
            r3 = 0
            if (r1 == 0) goto L_0x010a
            r4 = 0
            r5 = 3
            e.d.a.n.m.p.c r6 = r1.f7274b     // Catch:{ SecurityException -> 0x002d, all -> 0x002a }
            android.database.Cursor r6 = r6.a(r2)     // Catch:{ SecurityException -> 0x002d, all -> 0x002a }
            if (r6 == 0) goto L_0x0027
            boolean r7 = r6.moveToFirst()     // Catch:{ SecurityException -> 0x0025 }
            if (r7 == 0) goto L_0x0027
            java.lang.String r7 = r6.getString(r4)     // Catch:{ SecurityException -> 0x0025 }
            r6.close()
            goto L_0x0050
        L_0x0021:
            r0 = move-exception
            r3 = r6
            goto L_0x0104
        L_0x0025:
            r7 = move-exception
            goto L_0x0030
        L_0x0027:
            if (r6 == 0) goto L_0x004f
            goto L_0x004c
        L_0x002a:
            r0 = move-exception
            goto L_0x0104
        L_0x002d:
            r6 = move-exception
            r7 = r6
            r6 = r3
        L_0x0030:
            boolean r8 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0021 }
            if (r8 == 0) goto L_0x004a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0021 }
            r8.<init>()     // Catch:{ all -> 0x0021 }
            java.lang.String r9 = "Failed to query for thumbnail for Uri: "
            r8.append(r9)     // Catch:{ all -> 0x0021 }
            r8.append(r2)     // Catch:{ all -> 0x0021 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0021 }
            android.util.Log.d(r0, r8, r7)     // Catch:{ all -> 0x0021 }
        L_0x004a:
            if (r6 == 0) goto L_0x004f
        L_0x004c:
            r6.close()
        L_0x004f:
            r7 = r3
        L_0x0050:
            boolean r6 = android.text.TextUtils.isEmpty(r7)
            if (r6 == 0) goto L_0x0058
        L_0x0056:
            r1 = r3
            goto L_0x0089
        L_0x0058:
            e.d.a.n.m.p.a r6 = r1.f7273a
            if (r6 == 0) goto L_0x0103
            java.io.File r6 = new java.io.File
            r6.<init>(r7)
            e.d.a.n.m.p.a r7 = r1.f7273a
            if (r7 == 0) goto L_0x0102
            boolean r7 = r6.exists()
            if (r7 == 0) goto L_0x007c
            r7 = 0
            e.d.a.n.m.p.a r9 = r1.f7273a
            if (r9 == 0) goto L_0x007b
            long r9 = r6.length()
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 >= 0) goto L_0x007c
            r4 = 1
            goto L_0x007c
        L_0x007b:
            throw r3
        L_0x007c:
            if (r4 != 0) goto L_0x007f
            goto L_0x0056
        L_0x007f:
            android.net.Uri r4 = android.net.Uri.fromFile(r6)
            android.content.ContentResolver r1 = r1.f7276d     // Catch:{ NullPointerException -> 0x00dc }
            java.io.InputStream r1 = r1.openInputStream(r4)     // Catch:{ NullPointerException -> 0x00dc }
        L_0x0089:
            r2 = -1
            if (r1 == 0) goto L_0x00d2
            e.d.a.n.m.p.d r4 = r11.f7266b
            android.net.Uri r6 = r11.f7265a
            if (r4 == 0) goto L_0x00d1
            android.content.ContentResolver r7 = r4.f7276d     // Catch:{ IOException -> 0x00aa, NullPointerException -> 0x00a8 }
            java.io.InputStream r3 = r7.openInputStream(r6)     // Catch:{ IOException -> 0x00aa, NullPointerException -> 0x00a8 }
            java.util.List<com.bumptech.glide.load.ImageHeaderParser> r7 = r4.f7277e     // Catch:{ IOException -> 0x00aa, NullPointerException -> 0x00a8 }
            e.d.a.n.n.c0.b r4 = r4.f7275c     // Catch:{ IOException -> 0x00aa, NullPointerException -> 0x00a8 }
            int r0 = e.c.f.n.n.a(r7, r3, r4)     // Catch:{ IOException -> 0x00aa, NullPointerException -> 0x00a8 }
            if (r3 == 0) goto L_0x00d3
            r3.close()     // Catch:{ IOException -> 0x00d3 }
            goto L_0x00d3
        L_0x00a6:
            r0 = move-exception
            goto L_0x00cb
        L_0x00a8:
            r4 = move-exception
            goto L_0x00ab
        L_0x00aa:
            r4 = move-exception
        L_0x00ab:
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x00c5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r5.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r7 = "Failed to open uri: "
            r5.append(r7)     // Catch:{ all -> 0x00a6 }
            r5.append(r6)     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00a6 }
            android.util.Log.d(r0, r5, r4)     // Catch:{ all -> 0x00a6 }
        L_0x00c5:
            if (r3 == 0) goto L_0x00d2
            r3.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00d2
        L_0x00cb:
            if (r3 == 0) goto L_0x00d0
            r3.close()     // Catch:{ IOException -> 0x00d0 }
        L_0x00d0:
            throw r0
        L_0x00d1:
            throw r3
        L_0x00d2:
            r0 = r2
        L_0x00d3:
            if (r0 == r2) goto L_0x00db
            e.d.a.n.m.g r2 = new e.d.a.n.m.g
            r2.<init>(r1, r0)
            r1 = r2
        L_0x00db:
            return r1
        L_0x00dc:
            r0 = move-exception
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "NPE opening uri: "
            r3.append(r5)
            r3.append(r2)
            java.lang.String r2 = " -> "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            java.lang.Throwable r0 = r1.initCause(r0)
            java.io.FileNotFoundException r0 = (java.io.FileNotFoundException) r0
            throw r0
        L_0x0102:
            throw r3
        L_0x0103:
            throw r3
        L_0x0104:
            if (r3 == 0) goto L_0x0109
            r3.close()
        L_0x0109:
            throw r0
        L_0x010a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.m.p.b.d():java.io.InputStream");
    }

    public void a(f fVar, e.d.a.n.m.d.a<? super InputStream> aVar) {
        try {
            InputStream d2 = d();
            this.f7267c = d2;
            aVar.a(d2);
        } catch (FileNotFoundException e2) {
            String str = "MediaStoreThumbFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to find thumbnail file", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
