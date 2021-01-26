package e.d.a.n.o;

import android.util.Log;
import e.d.a.f;
import e.d.a.n.h;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader */
public class d implements n<File, ByteBuffer> {

    /* compiled from: ByteBufferFileLoader */
    public static final class a implements e.d.a.n.m.d<ByteBuffer> {

        /* renamed from: a reason: collision with root package name */
        public final File f7543a;

        public a(File file) {
            this.f7543a = file;
        }

        public void a(f fVar, e.d.a.n.m.d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a(e.d.a.t.a.a(this.f7543a));
            } catch (IOException e2) {
                String str = "ByteBufferFileLoader";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        public void b() {
        }

        public e.d.a.n.a c() {
            return e.d.a.n.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    /* compiled from: ByteBufferFileLoader */
    public static class b implements o<File, ByteBuffer> {
        public n<File, ByteBuffer> a(r rVar) {
            return new d();
        }
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        File file = (File) obj;
        return new e.d.a.n.o.n.a(new e.d.a.s.b(file), new a(file));
    }

    public boolean a(Object obj) {
        File file = (File) obj;
        return true;
    }
}
