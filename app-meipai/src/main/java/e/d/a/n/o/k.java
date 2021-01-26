package e.d.a.n.o;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import e.c.f.n.n;
import e.d.a.f;
import e.d.a.n.h;
import e.d.a.n.m.d;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader */
public final class k implements n<Uri, File> {

    /* renamed from: a reason: collision with root package name */
    public final Context f7568a;

    /* compiled from: MediaStoreFileLoader */
    public static final class a implements o<Uri, File> {

        /* renamed from: a reason: collision with root package name */
        public final Context f7569a;

        public a(Context context) {
            this.f7569a = context;
        }

        public n<Uri, File> a(r rVar) {
            return new k(this.f7569a);
        }
    }

    /* compiled from: MediaStoreFileLoader */
    public static class b implements d<File> {

        /* renamed from: c reason: collision with root package name */
        public static final String[] f7570c = {"_data"};

        /* renamed from: a reason: collision with root package name */
        public final Context f7571a;

        /* renamed from: b reason: collision with root package name */
        public final Uri f7572b;

        public b(Context context, Uri uri) {
            this.f7571a = context;
            this.f7572b = uri;
        }

        public void a(f fVar, e.d.a.n.m.d.a<? super File> aVar) {
            Cursor query = this.f7571a.getContentResolver().query(this.f7572b, f7570c, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder a2 = e.a.a.a.a.a("Failed to find file path for: ");
                a2.append(this.f7572b);
                aVar.a((Exception) new FileNotFoundException(a2.toString()));
                return;
            }
            aVar.a(new File(str));
        }

        public void b() {
        }

        public e.d.a.n.a c() {
            return e.d.a.n.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<File> a() {
            return File.class;
        }
    }

    public k(Context context) {
        this.f7568a = context;
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        Uri uri = (Uri) obj;
        return new e.d.a.n.o.n.a(new e.d.a.s.b(uri), new b(this.f7568a, uri));
    }

    public boolean a(Object obj) {
        return n.a((Uri) obj);
    }
}
