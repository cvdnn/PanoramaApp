package com.baidu.mobstat;

import com.baidu.mobstat.cq.a;
import java.nio.ByteBuffer;

public class co extends cr implements cn {

    /* renamed from: a reason: collision with root package name */
    public static final ByteBuffer f1817a = ByteBuffer.allocate(0);

    /* renamed from: f reason: collision with root package name */
    public int f1818f;

    /* renamed from: g reason: collision with root package name */
    public String f1819g;

    public co() {
        super(a.CLOSING);
        a(true);
    }

    private void a(int i2, String str) throws ch {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        if (i2 == 1015) {
            i2 = 1005;
        } else {
            str2 = str;
        }
        if (i2 == 1005) {
            if (str2.length() > 0) {
                throw new ch(1002, "A close frame must have a closecode if it has a reason");
            }
        } else if (i2 <= 1011 || i2 >= 3000 || i2 == 1015) {
            byte[] a2 = dc.a(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i2);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(a2.length + 2);
            allocate2.put(allocate);
            allocate2.put(a2);
            allocate2.rewind();
            a(allocate2);
        } else {
            throw new ch(1002, "Trying to send an illegal close code!");
        }
    }

    private void g() throws ci {
        this.f1818f = 1005;
        ByteBuffer c2 = super.c();
        c2.mark();
        if (c2.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(c2.getShort());
            allocate.position(0);
            int i2 = allocate.getInt();
            this.f1818f = i2;
            if (i2 == 1006 || i2 == 1015 || i2 == 1005 || i2 > 4999 || i2 < 1000 || i2 == 1004) {
                StringBuilder a2 = e.a.a.a.a.a("closecode must not be sent over the wire: ");
                a2.append(this.f1818f);
                throw new ci(a2.toString());
            }
        }
        c2.reset();
    }

    private void h() throws ch {
        if (this.f1818f == 1005) {
            this.f1819g = dc.a(super.c());
            return;
        }
        ByteBuffer c2 = super.c();
        int position = c2.position();
        try {
            c2.position(c2.position() + 2);
            this.f1819g = dc.a(c2);
            c2.position(position);
        } catch (IllegalArgumentException e2) {
            throw new ci((Throwable) e2);
        } catch (Throwable th) {
            c2.position(position);
            throw th;
        }
    }

    public String b() {
        return this.f1819g;
    }

    public ByteBuffer c() {
        if (this.f1818f == 1005) {
            return f1817a;
        }
        return super.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("code: ");
        sb.append(this.f1818f);
        return sb.toString();
    }

    public co(int i2, String str) throws ch {
        super(a.CLOSING);
        a(true);
        a(i2, str);
    }

    public int a() {
        return this.f1818f;
    }

    public void a(ByteBuffer byteBuffer) throws ch {
        super.a(byteBuffer);
        g();
        h();
    }
}
