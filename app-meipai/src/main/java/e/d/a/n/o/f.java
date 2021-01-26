package e.d.a.n.o;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import e.d.a.n.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader */
public class f<Data> implements n<File, Data> {

    /* renamed from: a reason: collision with root package name */
    public final d<Data> f7549a;

    /* compiled from: FileLoader */
    public static class a<Data> implements o<File, Data> {

        /* renamed from: a reason: collision with root package name */
        public final d<Data> f7550a;

        public a(d<Data> dVar) {
            this.f7550a = dVar;
        }

        public final n<File, Data> a(r rVar) {
            return new f(this.f7550a);
        }
    }

    /* compiled from: FileLoader */
    public static class b extends a<ParcelFileDescriptor> {

        /* compiled from: FileLoader */
        public class a implements d<ParcelFileDescriptor> {
            public void a(Object obj) throws IOException {
                ((ParcelFileDescriptor) obj).close();
            }

            public Object a(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }
        }

        public b() {
            super(new a());
        }
    }

    /* compiled from: FileLoader */
    public static final class c<Data> implements e.d.a.n.m.d<Data> {

        /* renamed from: a reason: collision with root package name */
        public final File f7551a;

        /* renamed from: b reason: collision with root package name */
        public final d<Data> f7552b;

        /* renamed from: c reason: collision with root package name */
        public Data f7553c;

        public c(File file, d<Data> dVar) {
            this.f7551a = file;
            this.f7552b = dVar;
        }

        public void a(e.d.a.f fVar, e.d.a.n.m.d.a<? super Data> aVar) {
            try {
                Data a2 = this.f7552b.a(this.f7551a);
                this.f7553c = a2;
                aVar.a(a2);
            } catch (FileNotFoundException e2) {
                String str = "FileLoader";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to open file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        public void b() {
            Data data = this.f7553c;
            if (data != null) {
                try {
                    this.f7552b.a(data);
                } catch (IOException unused) {
                }
            }
        }

        public e.d.a.n.a c() {
            return e.d.a.n.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Data> a() {
            return this.f7552b.a();
        }
    }

    /* compiled from: FileLoader */
    public interface d<Data> {
        Class<Data> a();

        Data a(File file) throws FileNotFoundException;

        void a(Data data) throws IOException;
    }

    /* compiled from: FileLoader */
    public static class e extends a<InputStream> {

        /* compiled from: FileLoader */
        public class a implements d<InputStream> {
            public void a(Object obj) throws IOException {
                ((InputStream) obj).close();
            }

            public Object a(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.f7549a = dVar;
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        File file = (File) obj;
        return new e.d.a.n.o.n.a(new e.d.a.s.b(file), new c(file, this.f7549a));
    }

    public boolean a(Object obj) {
        File file = (File) obj;
        return true;
    }
}
