package com.baidu.mobstat;

import com.baidu.mobstat.cq.a;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class cr implements cp {

    /* renamed from: b reason: collision with root package name */
    public static byte[] f1827b = new byte[0];

    /* renamed from: a reason: collision with root package name */
    public ByteBuffer f1828a;

    /* renamed from: c reason: collision with root package name */
    public boolean f1829c;

    /* renamed from: d reason: collision with root package name */
    public a f1830d;

    /* renamed from: e reason: collision with root package name */
    public boolean f1831e;

    public cr() {
    }

    public void a(boolean z) {
        this.f1829c = z;
    }

    public void b(boolean z) {
        this.f1831e = z;
    }

    public ByteBuffer c() {
        return this.f1828a;
    }

    public boolean d() {
        return this.f1829c;
    }

    public boolean e() {
        return this.f1831e;
    }

    public a f() {
        return this.f1830d;
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("Framedata{ optcode:");
        a2.append(f());
        a2.append(", fin:");
        a2.append(d());
        a2.append(", payloadlength:[pos:");
        a2.append(this.f1828a.position());
        a2.append(", len:");
        a2.append(this.f1828a.remaining());
        a2.append("], payload:");
        a2.append(Arrays.toString(dc.a(new String(this.f1828a.array()))));
        a2.append("}");
        return a2.toString();
    }

    public cr(a aVar) {
        this.f1830d = aVar;
        this.f1828a = ByteBuffer.wrap(f1827b);
    }

    public void a(a aVar) {
        this.f1830d = aVar;
    }

    public void a(ByteBuffer byteBuffer) throws ch {
        this.f1828a = byteBuffer;
    }

    public void a(cq cqVar) throws ci {
        ByteBuffer c2 = cqVar.c();
        if (this.f1828a == null) {
            this.f1828a = ByteBuffer.allocate(c2.remaining());
            c2.mark();
            this.f1828a.put(c2);
            c2.reset();
        } else {
            c2.mark();
            ByteBuffer byteBuffer = this.f1828a;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.f1828a;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (c2.remaining() > this.f1828a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.f1828a.capacity() + c2.remaining());
                this.f1828a.flip();
                allocate.put(this.f1828a);
                allocate.put(c2);
                this.f1828a = allocate;
            } else {
                this.f1828a.put(c2);
            }
            this.f1828a.rewind();
            c2.reset();
        }
        this.f1829c = cqVar.d();
    }

    public cr(cq cqVar) {
        this.f1829c = cqVar.d();
        this.f1830d = cqVar.f();
        this.f1828a = cqVar.c();
        this.f1831e = cqVar.e();
    }
}
