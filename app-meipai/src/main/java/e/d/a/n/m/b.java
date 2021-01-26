package e.d.a.n.m;

import android.content.res.AssetManager;
import android.util.Log;
import e.d.a.f;
import e.d.a.n.m.d.a;
import java.io.IOException;

/* compiled from: AssetPathFetcher */
public abstract class b<T> implements d<T> {

    /* renamed from: a reason: collision with root package name */
    public final String f7235a;

    /* renamed from: b reason: collision with root package name */
    public final AssetManager f7236b;

    /* renamed from: c reason: collision with root package name */
    public T f7237c;

    public b(AssetManager assetManager, String str) {
        this.f7236b = assetManager;
        this.f7235a = str;
    }

    public abstract T a(AssetManager assetManager, String str) throws IOException;

    public void a(f fVar, a<? super T> aVar) {
        try {
            T a2 = a(this.f7236b, this.f7235a);
            this.f7237c = a2;
            aVar.a(a2);
        } catch (IOException e2) {
            String str = "AssetPathFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to load data from asset manager", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    public abstract void a(T t) throws IOException;

    public void b() {
        T t = this.f7237c;
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
