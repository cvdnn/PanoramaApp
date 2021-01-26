package e.d.a.n.m;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import e.d.a.f;
import e.d.a.n.m.d.a;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher */
public abstract class l<T> implements d<T> {

    /* renamed from: a reason: collision with root package name */
    public final Uri f7259a;

    /* renamed from: b reason: collision with root package name */
    public final ContentResolver f7260b;

    /* renamed from: c reason: collision with root package name */
    public T f7261c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f7260b = contentResolver;
        this.f7259a = uri;
    }

    public abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public final void a(f fVar, a<? super T> aVar) {
        try {
            T a2 = a(this.f7259a, this.f7260b);
            this.f7261c = a2;
            aVar.a(a2);
        } catch (FileNotFoundException e2) {
            String str = "LocalUriFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to open Uri", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    public abstract void a(T t) throws IOException;

    public void b() {
        T t = this.f7261c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
        }
    }

    public e.d.a.n.a c() {
        return e.d.a.n.a.LOCAL;
    }

    public void cancel() {
    }
}
