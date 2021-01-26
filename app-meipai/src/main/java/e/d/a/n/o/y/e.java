package e.d.a.n.o.y;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import e.d.a.f;
import e.d.a.n.h;
import e.d.a.n.o.n;
import e.d.a.n.o.o;
import e.d.a.n.o.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: QMediaStoreUriLoader */
public final class e<DataT> implements n<Uri, DataT> {

    /* renamed from: a reason: collision with root package name */
    public final Context f7630a;

    /* renamed from: b reason: collision with root package name */
    public final n<File, DataT> f7631b;

    /* renamed from: c reason: collision with root package name */
    public final n<Uri, DataT> f7632c;

    /* renamed from: d reason: collision with root package name */
    public final Class<DataT> f7633d;

    /* compiled from: QMediaStoreUriLoader */
    public static abstract class a<DataT> implements o<Uri, DataT> {

        /* renamed from: a reason: collision with root package name */
        public final Context f7634a;

        /* renamed from: b reason: collision with root package name */
        public final Class<DataT> f7635b;

        public a(Context context, Class<DataT> cls) {
            this.f7634a = context;
            this.f7635b = cls;
        }

        public final n<Uri, DataT> a(r rVar) {
            return new e(this.f7634a, rVar.a(File.class, this.f7635b), rVar.a(Uri.class, this.f7635b), this.f7635b);
        }
    }

    /* compiled from: QMediaStoreUriLoader */
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* compiled from: QMediaStoreUriLoader */
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* compiled from: QMediaStoreUriLoader */
    public static final class d<DataT> implements e.d.a.n.m.d<DataT> {
        public static final String[] k = {"_data"};

        /* renamed from: a reason: collision with root package name */
        public final Context f7636a;

        /* renamed from: b reason: collision with root package name */
        public final n<File, DataT> f7637b;

        /* renamed from: c reason: collision with root package name */
        public final n<Uri, DataT> f7638c;

        /* renamed from: d reason: collision with root package name */
        public final Uri f7639d;

        /* renamed from: e reason: collision with root package name */
        public final int f7640e;

        /* renamed from: f reason: collision with root package name */
        public final int f7641f;

        /* renamed from: g reason: collision with root package name */
        public final h f7642g;

        /* renamed from: h reason: collision with root package name */
        public final Class<DataT> f7643h;

        /* renamed from: i reason: collision with root package name */
        public volatile boolean f7644i;

        /* renamed from: j reason: collision with root package name */
        public volatile e.d.a.n.m.d<DataT> f7645j;

        public d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i2, int i3, h hVar, Class<DataT> cls) {
            this.f7636a = context.getApplicationContext();
            this.f7637b = nVar;
            this.f7638c = nVar2;
            this.f7639d = uri;
            this.f7640e = i2;
            this.f7641f = i3;
            this.f7642g = hVar;
            this.f7643h = cls;
        }

        public void a(f fVar, e.d.a.n.m.d.a<? super DataT> aVar) {
            try {
                e.d.a.n.m.d<DataT> d2 = d();
                if (d2 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to build fetcher for: ");
                    sb.append(this.f7639d);
                    aVar.a((Exception) new IllegalArgumentException(sb.toString()));
                    return;
                }
                this.f7645j = d2;
                if (this.f7644i) {
                    cancel();
                } else {
                    d2.a(fVar, aVar);
                }
            } catch (FileNotFoundException e2) {
                aVar.a((Exception) e2);
            }
        }

        public void b() {
            e.d.a.n.m.d<DataT> dVar = this.f7645j;
            if (dVar != null) {
                dVar.b();
            }
        }

        public e.d.a.n.a c() {
            return e.d.a.n.a.LOCAL;
        }

        public void cancel() {
            this.f7644i = true;
            e.d.a.n.m.d<DataT> dVar = this.f7645j;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final e.d.a.n.m.d<DataT> d() throws java.io.FileNotFoundException {
            /*
                r9 = this;
                boolean r0 = android.os.Environment.isExternalStorageLegacy()
                r1 = 0
                if (r0 == 0) goto L_0x007e
                e.d.a.n.o.n<java.io.File, DataT> r0 = r9.f7637b
                android.net.Uri r8 = r9.f7639d
                android.content.Context r2 = r9.f7636a     // Catch:{ all -> 0x0077 }
                android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0077 }
                java.lang.String[] r4 = k     // Catch:{ all -> 0x0077 }
                r5 = 0
                r6 = 0
                r7 = 0
                r3 = r8
                android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0077 }
                if (r2 == 0) goto L_0x005d
                boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x0074 }
                if (r3 == 0) goto L_0x005d
                java.lang.String r3 = "_data"
                int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x0074 }
                java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x0074 }
                boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0074 }
                if (r4 != 0) goto L_0x0046
                java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0074 }
                r4.<init>(r3)     // Catch:{ all -> 0x0074 }
                r2.close()
                int r2 = r9.f7640e
                int r3 = r9.f7641f
                e.d.a.n.h r5 = r9.f7642g
                e.d.a.n.o.n$a r0 = r0.a(r4, r2, r3, r5)
                goto L_0x00a2
            L_0x0046:
                java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ all -> 0x0074 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
                r1.<init>()     // Catch:{ all -> 0x0074 }
                java.lang.String r3 = "File path was empty in media store for: "
                r1.append(r3)     // Catch:{ all -> 0x0074 }
                r1.append(r8)     // Catch:{ all -> 0x0074 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0074 }
                r0.<init>(r1)     // Catch:{ all -> 0x0074 }
                throw r0     // Catch:{ all -> 0x0074 }
            L_0x005d:
                java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ all -> 0x0074 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
                r1.<init>()     // Catch:{ all -> 0x0074 }
                java.lang.String r3 = "Failed to media store entry for: "
                r1.append(r3)     // Catch:{ all -> 0x0074 }
                r1.append(r8)     // Catch:{ all -> 0x0074 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0074 }
                r0.<init>(r1)     // Catch:{ all -> 0x0074 }
                throw r0     // Catch:{ all -> 0x0074 }
            L_0x0074:
                r0 = move-exception
                r1 = r2
                goto L_0x0078
            L_0x0077:
                r0 = move-exception
            L_0x0078:
                if (r1 == 0) goto L_0x007d
                r1.close()
            L_0x007d:
                throw r0
            L_0x007e:
                android.content.Context r0 = r9.f7636a
                java.lang.String r2 = "android.permission.ACCESS_MEDIA_LOCATION"
                int r0 = r0.checkSelfPermission(r2)
                if (r0 != 0) goto L_0x008a
                r0 = 1
                goto L_0x008b
            L_0x008a:
                r0 = 0
            L_0x008b:
                if (r0 == 0) goto L_0x0094
                android.net.Uri r0 = r9.f7639d
                android.net.Uri r0 = android.provider.MediaStore.setRequireOriginal(r0)
                goto L_0x0096
            L_0x0094:
                android.net.Uri r0 = r9.f7639d
            L_0x0096:
                e.d.a.n.o.n<android.net.Uri, DataT> r2 = r9.f7638c
                int r3 = r9.f7640e
                int r4 = r9.f7641f
                e.d.a.n.h r5 = r9.f7642g
                e.d.a.n.o.n$a r0 = r2.a(r0, r3, r4, r5)
            L_0x00a2:
                if (r0 == 0) goto L_0x00a6
                e.d.a.n.m.d<Data> r1 = r0.f7580c
            L_0x00a6:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.o.y.e.d.d():e.d.a.n.m.d");
        }

        public Class<DataT> a() {
            return this.f7643h;
        }
    }

    public e(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.f7630a = context.getApplicationContext();
        this.f7631b = nVar;
        this.f7632c = nVar2;
        this.f7633d = cls;
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        Uri uri = (Uri) obj;
        e.d.a.s.b bVar = new e.d.a.s.b(uri);
        d dVar = new d(this.f7630a, this.f7631b, this.f7632c, uri, i2, i3, hVar, this.f7633d);
        return new e.d.a.n.o.n.a(bVar, dVar);
    }

    public boolean a(Object obj) {
        return VERSION.SDK_INT >= 29 && e.c.f.n.n.a((Uri) obj);
    }
}
