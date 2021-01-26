package e.d.a.n.p.d;

import e.d.a.n.m.e;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder */
public class a implements e<ByteBuffer> {

    /* renamed from: a reason: collision with root package name */
    public final ByteBuffer f7742a;

    /* renamed from: e.d.a.n.p.d.a$a reason: collision with other inner class name */
    /* compiled from: ByteBufferRewinder */
    public static class C0095a implements e.d.a.n.m.e.a<ByteBuffer> {
        public e a(Object obj) {
            return new a((ByteBuffer) obj);
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f7742a = byteBuffer;
    }

    public Object a() throws IOException {
        this.f7742a.position(0);
        return this.f7742a;
    }

    public void b() {
    }
}
