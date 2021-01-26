package com.baidu.mobstat;

import com.arashivision.sdkcamera.camera.InstaCameraManager;
import com.baidu.mobstat.cd.b;
import com.facebook.stetho.websocket.WebSocketHandler;
import com.tencent.connect.common.Constants;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ce extends cd {

    /* renamed from: f reason: collision with root package name */
    public static final /* synthetic */ boolean f1810f = (!ce.class.desiredAssertionStatus());

    /* renamed from: g reason: collision with root package name */
    public ByteBuffer f1811g;

    /* renamed from: h reason: collision with root package name */
    public final Random f1812h = new Random();

    public class a extends Throwable {

        /* renamed from: b reason: collision with root package name */
        public int f1814b;

        public a(int i2) {
            this.f1814b = i2;
        }

        public int a() {
            return this.f1814b;
        }
    }

    public b a(cs csVar, cz czVar) throws cj {
        String str = WebSocketHandler.HEADER_SEC_WEBSOCKET_KEY;
        if (csVar.c(str)) {
            String str2 = WebSocketHandler.HEADER_SEC_WEBSOCKET_ACCEPT;
            if (czVar.c(str2)) {
                if (a(csVar.b(str)).equals(czVar.b(str2))) {
                    return b.MATCHED;
                }
                return b.NOT_MATCHED;
            }
        }
        return b.NOT_MATCHED;
    }

    public com.baidu.mobstat.cd.a b() {
        return com.baidu.mobstat.cd.a.TWOWAY;
    }

    public List<cq> c(ByteBuffer byteBuffer) throws ck, ch {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.f1811g == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.f1811g.remaining();
                if (remaining2 > remaining) {
                    this.f1811g.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.f1811g.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(e((ByteBuffer) this.f1811g.duplicate().position(0)));
                this.f1811g = null;
            } catch (a e2) {
                this.f1811g.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a(e2.a()));
                if (f1810f || allocate.limit() > this.f1811g.limit()) {
                    this.f1811g.rewind();
                    allocate.put(this.f1811g);
                    this.f1811g = allocate;
                } else {
                    throw new AssertionError();
                }
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(e(byteBuffer));
            } catch (a e3) {
                byteBuffer.reset();
                ByteBuffer allocate2 = ByteBuffer.allocate(a(e3.a()));
                this.f1811g = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public cq e(ByteBuffer byteBuffer) throws a, ch {
        cp cpVar;
        int remaining = byteBuffer.remaining();
        int i2 = 2;
        if (remaining >= 2) {
            byte b2 = byteBuffer.get();
            boolean z = (b2 >> 8) != 0;
            byte b3 = (byte) ((b2 & Byte.MAX_VALUE) >> 4);
            if (b3 == 0) {
                byte b4 = byteBuffer.get();
                boolean z2 = (b4 & Byte.MIN_VALUE) != 0;
                int i3 = (byte) (b4 & Byte.MAX_VALUE);
                com.baidu.mobstat.cq.a a2 = a((byte) (b2 & 15));
                if (z || !(a2 == com.baidu.mobstat.cq.a.PING || a2 == com.baidu.mobstat.cq.a.PONG || a2 == com.baidu.mobstat.cq.a.CLOSING)) {
                    if (i3 < 0 || i3 > 125) {
                        if (a2 == com.baidu.mobstat.cq.a.PING || a2 == com.baidu.mobstat.cq.a.PONG || a2 == com.baidu.mobstat.cq.a.CLOSING) {
                            throw new ci("more than 125 octets");
                        } else if (i3 != 126) {
                            i2 = 10;
                            if (remaining >= 10) {
                                byte[] bArr = new byte[8];
                                for (int i4 = 0; i4 < 8; i4++) {
                                    bArr[i4] = byteBuffer.get();
                                }
                                long longValue = new BigInteger(bArr).longValue();
                                if (longValue <= 2147483647L) {
                                    i3 = (int) longValue;
                                } else {
                                    throw new ck("Payloadsize is to big...");
                                }
                            } else {
                                throw new a(10);
                            }
                        } else if (remaining >= 4) {
                            byte[] bArr2 = new byte[3];
                            bArr2[1] = byteBuffer.get();
                            bArr2[2] = byteBuffer.get();
                            i3 = new BigInteger(bArr2).intValue();
                            i2 = 4;
                        } else {
                            throw new a(4);
                        }
                    }
                    int i5 = i2 + (z2 ? 4 : 0) + i3;
                    if (remaining >= i5) {
                        ByteBuffer allocate = ByteBuffer.allocate(a(i3));
                        if (z2) {
                            byte[] bArr3 = new byte[4];
                            byteBuffer.get(bArr3);
                            for (int i6 = 0; i6 < i3; i6++) {
                                allocate.put((byte) (byteBuffer.get() ^ bArr3[i6 % 4]));
                            }
                        } else {
                            allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                            byteBuffer.position(allocate.limit() + byteBuffer.position());
                        }
                        if (a2 == com.baidu.mobstat.cq.a.CLOSING) {
                            cpVar = new co();
                        } else {
                            cpVar = new cr();
                            cpVar.a(z);
                            cpVar.a(a2);
                        }
                        allocate.flip();
                        cpVar.a(allocate);
                        if (a2 != com.baidu.mobstat.cq.a.TEXT || dc.b(cpVar.c())) {
                            return cpVar;
                        }
                        throw new ch(InstaCameraManager.CAPTURE_TYPE_BURST_CAPTURE);
                    }
                    throw new a(i5);
                }
                throw new ci("control frames may no be fragmented");
            }
            throw new ci(e.a.a.a.a.a("bad rsv ", (int) b3));
        }
        throw new a(2);
    }

    public ByteBuffer a(cq cqVar) {
        ByteBuffer c2 = cqVar.c();
        int i2 = 0;
        boolean z = this.f1801d == by.b.CLIENT;
        int i3 = c2.remaining() <= 125 ? 1 : c2.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate(c2.remaining() + (i3 > 1 ? i3 + 1 : i3) + 1 + (z ? 4 : 0));
        byte b2 = Byte.MIN_VALUE;
        allocate.put((byte) (((byte) (cqVar.d() ? -128 : 0)) | a(cqVar.f())));
        byte[] a2 = a((long) c2.remaining(), i3);
        if (f1810f || a2.length == i3) {
            if (i3 == 1) {
                byte b3 = a2[0];
                if (!z) {
                    b2 = 0;
                }
                allocate.put((byte) (b3 | b2));
            } else if (i3 == 2) {
                if (!z) {
                    b2 = 0;
                }
                allocate.put((byte) (b2 | 126));
                allocate.put(a2);
            } else if (i3 == 8) {
                if (!z) {
                    b2 = 0;
                }
                allocate.put((byte) (b2 | Byte.MAX_VALUE));
                allocate.put(a2);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.f1812h.nextInt());
                allocate.put(allocate2.array());
                while (c2.hasRemaining()) {
                    allocate.put((byte) (c2.get() ^ allocate2.get(i2 % 4)));
                    i2++;
                }
            } else {
                allocate.put(c2);
            }
            if (f1810f || allocate.remaining() == 0) {
                allocate.flip();
                return allocate;
            }
            throw new AssertionError(allocate.remaining());
        }
        throw new AssertionError();
    }

    public cd c() {
        return new ce();
    }

    public List<cq> a(ByteBuffer byteBuffer, boolean z) {
        cr crVar = new cr();
        try {
            crVar.a(byteBuffer);
            crVar.a(true);
            crVar.a(com.baidu.mobstat.cq.a.BINARY);
            crVar.b(z);
            return Collections.singletonList(crVar);
        } catch (ch e2) {
            throw new cl(e2);
        }
    }

    private byte a(com.baidu.mobstat.cq.a aVar) {
        if (aVar == com.baidu.mobstat.cq.a.CONTINUOUS) {
            return 0;
        }
        if (aVar == com.baidu.mobstat.cq.a.TEXT) {
            return 1;
        }
        if (aVar == com.baidu.mobstat.cq.a.BINARY) {
            return 2;
        }
        if (aVar == com.baidu.mobstat.cq.a.CLOSING) {
            return 8;
        }
        if (aVar == com.baidu.mobstat.cq.a.PING) {
            return 9;
        }
        if (aVar == com.baidu.mobstat.cq.a.PONG) {
            return 10;
        }
        StringBuilder a2 = e.a.a.a.a.a("Don't know how to handle ");
        a2.append(aVar.toString());
        throw new RuntimeException(a2.toString());
    }

    private String a(String str) {
        String a2 = e.a.a.a.a.a(str.trim(), WebSocketHandler.SERVER_KEY_GUID);
        try {
            return db.a(MessageDigest.getInstance("SHA1").digest(a2.getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public ct a(ct ctVar) {
        String str = "Upgrade";
        ctVar.a(str, WebSocketHandler.HEADER_UPGRADE_WEBSOCKET);
        ctVar.a(WebSocketHandler.HEADER_CONNECTION, str);
        ctVar.a(WebSocketHandler.HEADER_SEC_WEBSOCKET_VERSION, Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
        byte[] bArr = new byte[16];
        this.f1812h.nextBytes(bArr);
        ctVar.a(WebSocketHandler.HEADER_SEC_WEBSOCKET_KEY, db.a(bArr));
        return ctVar;
    }

    private byte[] a(long j2, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = (i2 * 8) - 8;
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) ((int) (j2 >>> (i3 - (i4 * 8))));
        }
        return bArr;
    }

    private com.baidu.mobstat.cq.a a(byte b2) throws ci {
        if (b2 == 0) {
            return com.baidu.mobstat.cq.a.CONTINUOUS;
        }
        if (b2 == 1) {
            return com.baidu.mobstat.cq.a.TEXT;
        }
        if (b2 == 2) {
            return com.baidu.mobstat.cq.a.BINARY;
        }
        switch (b2) {
            case 8:
                return com.baidu.mobstat.cq.a.CLOSING;
            case 9:
                return com.baidu.mobstat.cq.a.PING;
            case 10:
                return com.baidu.mobstat.cq.a.PONG;
            default:
                StringBuilder a2 = e.a.a.a.a.a("unknow optcode ");
                a2.append((short) b2);
                throw new ci(a2.toString());
        }
    }

    public void a() {
        this.f1811g = null;
    }
}
