package e.d.a.n.o;

import android.util.Base64;
import e.d.a.f;
import e.d.a.n.h;
import e.d.a.n.m.d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader */
public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a reason: collision with root package name */
    public final a<Data> f7544a;

    /* compiled from: DataUrlLoader */
    public interface a<Data> {
    }

    /* compiled from: DataUrlLoader */
    public static final class b<Data> implements d<Data> {

        /* renamed from: a reason: collision with root package name */
        public final String f7545a;

        /* renamed from: b reason: collision with root package name */
        public final a<Data> f7546b;

        /* renamed from: c reason: collision with root package name */
        public Data f7547c;

        public b(String str, a<Data> aVar) {
            this.f7545a = str;
            this.f7546b = aVar;
        }

        public void a(f fVar, e.d.a.n.m.d.a<? super Data> aVar) {
            try {
                Data a2 = ((a) this.f7546b).a(this.f7545a);
                this.f7547c = a2;
                aVar.a(a2);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        public void b() {
            try {
                a<Data> aVar = this.f7546b;
                Data data = this.f7547c;
                if (((a) aVar) != null) {
                    ((InputStream) data).close();
                    return;
                }
                throw null;
            } catch (IOException unused) {
            }
        }

        public e.d.a.n.a c() {
            return e.d.a.n.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Data> a() {
            if (((a) this.f7546b) != null) {
                return InputStream.class;
            }
            throw null;
        }
    }

    /* compiled from: DataUrlLoader */
    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a reason: collision with root package name */
        public final a<InputStream> f7548a = new a(this);

        /* compiled from: DataUrlLoader */
        public class a implements a<InputStream> {
            public a(c cVar) {
            }

            public Object a(String str) throws IllegalArgumentException {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        }

        public n<Model, InputStream> a(r rVar) {
            return new e(this.f7548a);
        }
    }

    public e(a<Data> aVar) {
        this.f7544a = aVar;
    }

    public e.d.a.n.o.n.a<Data> a(Model model, int i2, int i3, h hVar) {
        return new e.d.a.n.o.n.a<>(new e.d.a.s.b(model), new b(model.toString(), this.f7544a));
    }

    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }
}
