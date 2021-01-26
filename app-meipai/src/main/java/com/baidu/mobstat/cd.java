package com.baidu.mobstat;

import com.arashivision.insbase.arlog.MultipartUtility;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class cd {

    /* renamed from: a reason: collision with root package name */
    public static int f1798a = 1000;

    /* renamed from: b reason: collision with root package name */
    public static int f1799b = 64;

    /* renamed from: c reason: collision with root package name */
    public static final byte[] f1800c = dc.a("<policy-file-request/>\u0000");

    /* renamed from: d reason: collision with root package name */
    public com.baidu.mobstat.by.b f1801d = null;

    /* renamed from: e reason: collision with root package name */
    public com.baidu.mobstat.cq.a f1802e = null;

    public enum a {
        NONE,
        ONEWAY,
        TWOWAY
    }

    public enum b {
        MATCHED,
        NOT_MATCHED
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b2 = 48;
        while (byteBuffer.hasRemaining()) {
            byte b3 = byteBuffer.get();
            allocate.put(b3);
            if (b2 == 13 && b3 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b2 = b3;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String b(ByteBuffer byteBuffer) {
        ByteBuffer a2 = a(byteBuffer);
        if (a2 == null) {
            return null;
        }
        return dc.a(a2.array(), 0, a2.limit());
    }

    public abstract b a(cs csVar, cz czVar) throws cj;

    public abstract ct a(ct ctVar) throws cj;

    public abstract ByteBuffer a(cq cqVar);

    public abstract List<cq> a(ByteBuffer byteBuffer, boolean z);

    public abstract void a();

    public abstract a b();

    public abstract cd c();

    public abstract List<cq> c(ByteBuffer byteBuffer) throws ch;

    public cx d(ByteBuffer byteBuffer) throws cj {
        return a(byteBuffer, this.f1801d);
    }

    public static cu a(ByteBuffer byteBuffer, com.baidu.mobstat.by.b bVar) throws cj, cg {
        cu cuVar;
        String b2 = b(byteBuffer);
        if (b2 != null) {
            String[] split = b2.split(" ", 3);
            if (split.length == 3) {
                if (bVar == com.baidu.mobstat.by.b.CLIENT) {
                    da cwVar = new cw();
                    cwVar.a(Short.parseShort(split[1]));
                    cwVar.a(split[2]);
                    cuVar = cwVar;
                } else {
                    ct cvVar = new cv();
                    cvVar.a(split[1]);
                    cuVar = cvVar;
                }
                String b3 = b(byteBuffer);
                while (b3 != null && b3.length() > 0) {
                    String[] split2 = b3.split(Config.TRACE_TODAY_VISIT_SPLIT, 2);
                    if (split2.length == 2) {
                        cuVar.a(split2[0], split2[1].replaceFirst("^ +", ""));
                        b3 = b(byteBuffer);
                    } else {
                        throw new cj("not an http header");
                    }
                }
                if (b3 != null) {
                    return cuVar;
                }
                throw new cg();
            }
            throw new cj();
        }
        throw new cg(byteBuffer.capacity() + 128);
    }

    public List<ByteBuffer> a(cx cxVar, com.baidu.mobstat.by.b bVar) {
        return a(cxVar, bVar, true);
    }

    public List<ByteBuffer> a(cx cxVar, com.baidu.mobstat.by.b bVar, boolean z) {
        int i2;
        StringBuilder sb = new StringBuilder(100);
        if (cxVar instanceof cs) {
            sb.append("GET ");
            sb.append(((cs) cxVar).a());
            sb.append(" HTTP/1.1");
        } else if (cxVar instanceof cz) {
            sb.append("HTTP/1.1 101 ");
            sb.append(((cz) cxVar).a());
        } else {
            throw new RuntimeException("unknown role");
        }
        String str = MultipartUtility.CTRLF;
        sb.append(str);
        Iterator b2 = cxVar.b();
        while (b2.hasNext()) {
            String str2 = (String) b2.next();
            String b3 = cxVar.b(str2);
            sb.append(str2);
            sb.append(": ");
            sb.append(b3);
            sb.append(str);
        }
        sb.append(str);
        byte[] b4 = dc.b(sb.toString());
        byte[] c2 = z ? cxVar.c() : null;
        if (c2 == null) {
            i2 = 0;
        } else {
            i2 = c2.length;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2 + b4.length);
        allocate.put(b4);
        if (c2 != null) {
            allocate.put(c2);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public int a(int i2) throws ck, ch {
        if (i2 >= 0) {
            return i2;
        }
        throw new ch(1002, "Negative count");
    }

    public void a(com.baidu.mobstat.by.b bVar) {
        this.f1801d = bVar;
    }
}
