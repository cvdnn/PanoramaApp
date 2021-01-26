package e.d.a.n.o;

import e.d.a.f;
import e.d.a.n.h;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader */
public class b<Data> implements n<byte[], Data> {

    /* renamed from: a reason: collision with root package name */
    public final C0090b<Data> f7540a;

    /* compiled from: ByteArrayLoader */
    public static class a implements o<byte[], ByteBuffer> {

        /* renamed from: e.d.a.n.o.b$a$a reason: collision with other inner class name */
        /* compiled from: ByteArrayLoader */
        public class C0089a implements C0090b<ByteBuffer> {
            public C0089a(a aVar) {
            }

            public Object a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }
        }

        public n<byte[], ByteBuffer> a(r rVar) {
            return new b(new C0089a(this));
        }
    }

    /* renamed from: e.d.a.n.o.b$b reason: collision with other inner class name */
    /* compiled from: ByteArrayLoader */
    public interface C0090b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    /* compiled from: ByteArrayLoader */
    public static class c<Data> implements e.d.a.n.m.d<Data> {

        /* renamed from: a reason: collision with root package name */
        public final byte[] f7541a;

        /* renamed from: b reason: collision with root package name */
        public final C0090b<Data> f7542b;

        public c(byte[] bArr, C0090b<Data> bVar) {
            this.f7541a = bArr;
            this.f7542b = bVar;
        }

        public void a(f fVar, e.d.a.n.m.d.a<? super Data> aVar) {
            aVar.a(this.f7542b.a(this.f7541a));
        }

        public void b() {
        }

        public e.d.a.n.a c() {
            return e.d.a.n.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Data> a() {
            return this.f7542b.a();
        }
    }

    /* compiled from: ByteArrayLoader */
    public static class d implements o<byte[], InputStream> {

        /* compiled from: ByteArrayLoader */
        public class a implements C0090b<InputStream> {
            public a(d dVar) {
            }

            public Object a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }
        }

        public n<byte[], InputStream> a(r rVar) {
            return new b(new a(this));
        }
    }

    public b(C0090b<Data> bVar) {
        this.f7540a = bVar;
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        byte[] bArr = (byte[]) obj;
        return new e.d.a.n.o.n.a(new e.d.a.s.b(bArr), new c(bArr, this.f7540a));
    }

    public boolean a(Object obj) {
        byte[] bArr = (byte[]) obj;
        return true;
    }
}
