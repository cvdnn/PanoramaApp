package g.d0.h;

import com.arashivision.graphicpath.render.Stabilization.GyroType;
import com.baidu.mobstat.Config;
import com.baidubce.BceConfig;
import com.tencent.connect.common.Constants;
import h.e;
import h.g;
import h.h;
import h.o;
import h.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Hpack */
public final class d {

    /* renamed from: a reason: collision with root package name */
    public static final c[] f9297a;

    /* renamed from: b reason: collision with root package name */
    public static final Map<h, Integer> f9298b;

    /* compiled from: Hpack */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        public final List<c> f9299a = new ArrayList();

        /* renamed from: b reason: collision with root package name */
        public final g f9300b;

        /* renamed from: c reason: collision with root package name */
        public final int f9301c;

        /* renamed from: d reason: collision with root package name */
        public int f9302d;

        /* renamed from: e reason: collision with root package name */
        public c[] f9303e = new c[8];

        /* renamed from: f reason: collision with root package name */
        public int f9304f = 7;

        /* renamed from: g reason: collision with root package name */
        public int f9305g = 0;

        /* renamed from: h reason: collision with root package name */
        public int f9306h = 0;

        public a(int i2, x xVar) {
            this.f9301c = i2;
            this.f9302d = i2;
            this.f9300b = o.a(xVar);
        }

        public final void a() {
            Arrays.fill(this.f9303e, null);
            this.f9304f = this.f9303e.length - 1;
            this.f9305g = 0;
            this.f9306h = 0;
        }

        public final int b(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f9303e.length;
                while (true) {
                    length--;
                    if (length < this.f9304f || i2 <= 0) {
                        c[] cVarArr = this.f9303e;
                        int i4 = this.f9304f;
                        System.arraycopy(cVarArr, i4 + 1, cVarArr, i4 + 1 + i3, this.f9305g);
                        this.f9304f += i3;
                    } else {
                        c[] cVarArr2 = this.f9303e;
                        i2 -= cVarArr2[length].f9296c;
                        this.f9306h -= cVarArr2[length].f9296c;
                        this.f9305g--;
                        i3++;
                    }
                }
                c[] cVarArr3 = this.f9303e;
                int i42 = this.f9304f;
                System.arraycopy(cVarArr3, i42 + 1, cVarArr3, i42 + 1 + i3, this.f9305g);
                this.f9304f += i3;
            }
            return i3;
        }

        public final h c(int i2) {
            boolean z = true;
            if (i2 < 0 || i2 > d.f9297a.length - 1) {
                z = false;
            }
            if (z) {
                return d.f9297a[i2].f9294a;
            }
            return this.f9303e[a(i2 - d.f9297a.length)].f9294a;
        }

        public final int a(int i2) {
            return this.f9304f + 1 + i2;
        }

        public final void a(int i2, c cVar) {
            this.f9299a.add(cVar);
            int i3 = cVar.f9296c;
            if (i2 != -1) {
                i3 -= this.f9303e[(this.f9304f + 1) + i2].f9296c;
            }
            int i4 = this.f9302d;
            if (i3 > i4) {
                a();
                return;
            }
            int b2 = b((this.f9306h + i3) - i4);
            if (i2 == -1) {
                int i5 = this.f9305g + 1;
                c[] cVarArr = this.f9303e;
                if (i5 > cVarArr.length) {
                    c[] cVarArr2 = new c[(cVarArr.length * 2)];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f9304f = this.f9303e.length - 1;
                    this.f9303e = cVarArr2;
                }
                int i6 = this.f9304f;
                this.f9304f = i6 - 1;
                this.f9303e[i6] = cVar;
                this.f9305g++;
            } else {
                this.f9303e[this.f9304f + 1 + i2 + b2 + i2] = cVar;
            }
            this.f9306h += i3;
        }

        public h b() throws IOException {
            byte readByte = this.f9300b.readByte() & 255;
            boolean z = (readByte & 128) == 128;
            int a2 = a((int) readByte, (int) GyroType.INS_WEARABLE_TEST);
            if (!z) {
                return this.f9300b.c((long) a2);
            }
            p pVar = p.f9424d;
            byte[] f2 = this.f9300b.f((long) a2);
            if (pVar != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i2 = 0;
                g.d0.h.p.a aVar = pVar.f9425a;
                byte b2 = 0;
                for (byte b3 : f2) {
                    b2 = (b2 << 8) | (b3 & 255);
                    i2 += 8;
                    while (i2 >= 8) {
                        int i3 = i2 - 8;
                        aVar = aVar.f9426a[(b2 >>> i3) & 255];
                        if (aVar.f9426a == null) {
                            byteArrayOutputStream.write(aVar.f9427b);
                            i2 -= aVar.f9428c;
                            aVar = pVar.f9425a;
                        } else {
                            i2 = i3;
                        }
                    }
                }
                while (i2 > 0) {
                    g.d0.h.p.a aVar2 = aVar.f9426a[(b2 << (8 - i2)) & 255];
                    if (aVar2.f9426a != null || aVar2.f9428c > i2) {
                        break;
                    }
                    byteArrayOutputStream.write(aVar2.f9427b);
                    i2 -= aVar2.f9428c;
                    aVar = pVar.f9425a;
                }
                return h.a(byteArrayOutputStream.toByteArray());
            }
            throw null;
        }

        public int a(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                byte readByte = this.f9300b.readByte() & 255;
                if ((readByte & 128) == 0) {
                    return i3 + (readByte << i5);
                }
                i3 += (readByte & Byte.MAX_VALUE) << i5;
                i5 += 7;
            }
        }
    }

    /* compiled from: Hpack */
    public static final class b {

        /* renamed from: a reason: collision with root package name */
        public final e f9307a;

        /* renamed from: b reason: collision with root package name */
        public final boolean f9308b = true;

        /* renamed from: c reason: collision with root package name */
        public int f9309c = Integer.MAX_VALUE;

        /* renamed from: d reason: collision with root package name */
        public boolean f9310d;

        /* renamed from: e reason: collision with root package name */
        public int f9311e = 4096;

        /* renamed from: f reason: collision with root package name */
        public c[] f9312f = new c[8];

        /* renamed from: g reason: collision with root package name */
        public int f9313g = 7;

        /* renamed from: h reason: collision with root package name */
        public int f9314h = 0;

        /* renamed from: i reason: collision with root package name */
        public int f9315i = 0;

        public b(e eVar) {
            this.f9307a = eVar;
        }

        public final void a() {
            Arrays.fill(this.f9312f, null);
            this.f9313g = this.f9312f.length - 1;
            this.f9314h = 0;
            this.f9315i = 0;
        }

        public final int a(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f9312f.length;
                while (true) {
                    length--;
                    if (length < this.f9313g || i2 <= 0) {
                        c[] cVarArr = this.f9312f;
                        int i4 = this.f9313g;
                        System.arraycopy(cVarArr, i4 + 1, cVarArr, i4 + 1 + i3, this.f9314h);
                        c[] cVarArr2 = this.f9312f;
                        int i5 = this.f9313g;
                        Arrays.fill(cVarArr2, i5 + 1, i5 + 1 + i3, null);
                        this.f9313g += i3;
                    } else {
                        c[] cVarArr3 = this.f9312f;
                        i2 -= cVarArr3[length].f9296c;
                        this.f9315i -= cVarArr3[length].f9296c;
                        this.f9314h--;
                        i3++;
                    }
                }
                c[] cVarArr4 = this.f9312f;
                int i42 = this.f9313g;
                System.arraycopy(cVarArr4, i42 + 1, cVarArr4, i42 + 1 + i3, this.f9314h);
                c[] cVarArr22 = this.f9312f;
                int i52 = this.f9313g;
                Arrays.fill(cVarArr22, i52 + 1, i52 + 1 + i3, null);
                this.f9313g += i3;
            }
            return i3;
        }

        public final void a(c cVar) {
            int i2 = cVar.f9296c;
            int i3 = this.f9311e;
            if (i2 > i3) {
                a();
                return;
            }
            a((this.f9315i + i2) - i3);
            int i4 = this.f9314h + 1;
            c[] cVarArr = this.f9312f;
            if (i4 > cVarArr.length) {
                c[] cVarArr2 = new c[(cVarArr.length * 2)];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f9313g = this.f9312f.length - 1;
                this.f9312f = cVarArr2;
            }
            int i5 = this.f9313g;
            this.f9313g = i5 - 1;
            this.f9312f[i5] = cVar;
            this.f9314h++;
            this.f9315i += i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.util.List<g.d0.h.c> r13) throws java.io.IOException {
            /*
                r12 = this;
                boolean r0 = r12.f9310d
                r1 = 0
                if (r0 == 0) goto L_0x001e
                int r0 = r12.f9309c
                int r2 = r12.f9311e
                r3 = 32
                r4 = 31
                if (r0 >= r2) goto L_0x0012
                r12.a(r0, r4, r3)
            L_0x0012:
                r12.f9310d = r1
                r0 = 2147483647(0x7fffffff, float:NaN)
                r12.f9309c = r0
                int r0 = r12.f9311e
                r12.a(r0, r4, r3)
            L_0x001e:
                int r0 = r13.size()
                r2 = r1
            L_0x0023:
                if (r2 >= r0) goto L_0x00f1
                java.lang.Object r3 = r13.get(r2)
                g.d0.h.c r3 = (g.d0.h.c) r3
                h.h r4 = r3.f9294a
                h.h r4 = r4.e()
                h.h r5 = r3.f9295b
                java.util.Map<h.h, java.lang.Integer> r6 = g.d0.h.d.f9298b
                java.lang.Object r6 = r6.get(r4)
                java.lang.Integer r6 = (java.lang.Integer) r6
                r7 = -1
                r8 = 1
                if (r6 == 0) goto L_0x006a
                int r6 = r6.intValue()
                int r6 = r6 + r8
                if (r6 <= r8) goto L_0x0068
                r9 = 8
                if (r6 >= r9) goto L_0x0068
                g.d0.h.c[] r9 = g.d0.h.d.f9297a
                int r10 = r6 + -1
                r9 = r9[r10]
                h.h r9 = r9.f9295b
                boolean r9 = g.d0.c.a(r9, r5)
                if (r9 == 0) goto L_0x0059
                goto L_0x006b
            L_0x0059:
                g.d0.h.c[] r9 = g.d0.h.d.f9297a
                r9 = r9[r6]
                h.h r9 = r9.f9295b
                boolean r9 = g.d0.c.a(r9, r5)
                if (r9 == 0) goto L_0x0068
                int r9 = r6 + 1
                goto L_0x006c
            L_0x0068:
                r9 = r7
                goto L_0x006c
            L_0x006a:
                r6 = r7
            L_0x006b:
                r9 = r6
            L_0x006c:
                if (r9 != r7) goto L_0x00a4
                int r10 = r12.f9313g
                int r10 = r10 + r8
                g.d0.h.c[] r8 = r12.f9312f
                int r8 = r8.length
            L_0x0074:
                if (r10 >= r8) goto L_0x00a4
                g.d0.h.c[] r11 = r12.f9312f
                r11 = r11[r10]
                h.h r11 = r11.f9294a
                boolean r11 = g.d0.c.a(r11, r4)
                if (r11 == 0) goto L_0x00a1
                g.d0.h.c[] r11 = r12.f9312f
                r11 = r11[r10]
                h.h r11 = r11.f9295b
                boolean r11 = g.d0.c.a(r11, r5)
                if (r11 == 0) goto L_0x0097
                int r8 = r12.f9313g
                int r10 = r10 - r8
                g.d0.h.c[] r8 = g.d0.h.d.f9297a
                int r8 = r8.length
                int r9 = r8 + r10
                goto L_0x00a4
            L_0x0097:
                if (r6 != r7) goto L_0x00a1
                int r6 = r12.f9313g
                int r6 = r10 - r6
                g.d0.h.c[] r11 = g.d0.h.d.f9297a
                int r11 = r11.length
                int r6 = r6 + r11
            L_0x00a1:
                int r10 = r10 + 1
                goto L_0x0074
            L_0x00a4:
                if (r9 == r7) goto L_0x00ae
                r3 = 127(0x7f, float:1.78E-43)
                r4 = 128(0x80, float:1.794E-43)
                r12.a(r9, r3, r4)
                goto L_0x00eb
            L_0x00ae:
                r8 = 64
                if (r6 != r7) goto L_0x00c1
                h.e r6 = r12.f9307a
                r6.writeByte(r8)
                r12.a(r4)
                r12.a(r5)
                r12.a(r3)
                goto L_0x00eb
            L_0x00c1:
                h.h r7 = g.d0.h.c.f9288d
                if (r4 == 0) goto L_0x00ef
                int r9 = r7.d()
                boolean r7 = r4.a(r1, r7, r1, r9)
                if (r7 == 0) goto L_0x00e0
                h.h r7 = g.d0.h.c.f9293i
                boolean r4 = r7.equals(r4)
                if (r4 != 0) goto L_0x00e0
                r3 = 15
                r12.a(r6, r3, r1)
                r12.a(r5)
                goto L_0x00eb
            L_0x00e0:
                r4 = 63
                r12.a(r6, r4, r8)
                r12.a(r5)
                r12.a(r3)
            L_0x00eb:
                int r2 = r2 + 1
                goto L_0x0023
            L_0x00ef:
                r13 = 0
                throw r13
            L_0x00f1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.d0.h.d.b.a(java.util.List):void");
        }

        public void a(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.f9307a.writeByte(i2 | i4);
                return;
            }
            this.f9307a.writeByte(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.f9307a.writeByte(128 | (i5 & GyroType.INS_WEARABLE_TEST));
                i5 >>>= 7;
            }
            this.f9307a.writeByte(i5);
        }

        /* JADX WARNING: type inference failed for: r3v4, types: [int] */
        /* JADX WARNING: type inference failed for: r3v5, types: [int, long] */
        /* JADX WARNING: type inference failed for: r3v6 */
        /* JADX WARNING: type inference failed for: r3v7 */
        /* JADX WARNING: type inference failed for: r3v8 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(h.h r13) throws java.io.IOException {
            /*
                r12 = this;
                boolean r0 = r12.f9308b
                r1 = 127(0x7f, float:1.78E-43)
                r2 = 0
                if (r0 == 0) goto L_0x0083
                g.d0.h.p r0 = g.d0.h.p.f9424d
                r3 = 0
                if (r0 == 0) goto L_0x0082
                r4 = 0
                r0 = r2
                r6 = r4
            L_0x0010:
                int r8 = r13.d()
                r9 = 255(0xff, float:3.57E-43)
                if (r0 >= r8) goto L_0x0026
                byte r8 = r13.a(r0)
                r8 = r8 & r9
                byte[] r9 = g.d0.h.p.f9423c
                byte r8 = r9[r8]
                long r8 = (long) r8
                long r6 = r6 + r8
                int r0 = r0 + 1
                goto L_0x0010
            L_0x0026:
                r10 = 7
                long r6 = r6 + r10
                r0 = 3
                long r6 = r6 >> r0
                int r0 = (int) r6
                int r6 = r13.d()
                if (r0 >= r6) goto L_0x0083
                h.e r0 = new h.e
                r0.<init>()
                g.d0.h.p r6 = g.d0.h.p.f9424d
                if (r6 == 0) goto L_0x0081
                r3 = r2
            L_0x003c:
                int r6 = r13.d()
                r7 = 8
                if (r2 >= r6) goto L_0x0063
                byte r6 = r13.a(r2)
                r6 = r6 & r9
                int[] r8 = g.d0.h.p.f9422b
                r8 = r8[r6]
                byte[] r10 = g.d0.h.p.f9423c
                byte r6 = r10[r6]
                long r4 = r4 << r6
                long r10 = (long) r8
                long r4 = r4 | r10
                int r3 = r3 + r6
            L_0x0055:
                if (r3 < r7) goto L_0x0060
                int r3 = r3 + -8
                long r10 = r4 >> r3
                int r6 = (int) r10
                r0.writeByte(r6)
                goto L_0x0055
            L_0x0060:
                int r2 = r2 + 1
                goto L_0x003c
            L_0x0063:
                if (r3 <= 0) goto L_0x006f
                int r7 = r7 - r3
                long r4 = r4 << r7
                int r13 = r9 >>> r3
                long r2 = (long) r13
                long r2 = r2 | r4
                int r13 = (int) r2
                r0.writeByte(r13)
            L_0x006f:
                h.h r13 = r0.b()
                byte[] r0 = r13.f9651a
                int r0 = r0.length
                r2 = 128(0x80, float:1.794E-43)
                r12.a(r0, r1, r2)
                h.e r0 = r12.f9307a
                r0.c(r13)
                goto L_0x008f
            L_0x0081:
                throw r3
            L_0x0082:
                throw r3
            L_0x0083:
                int r0 = r13.d()
                r12.a(r0, r1, r2)
                h.e r0 = r12.f9307a
                r0.c(r13)
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.d0.h.d.b.a(h.h):void");
        }
    }

    static {
        String str = "";
        int i2 = 0;
        f9297a = new c[]{new c(c.f9293i, str), new c(c.f9290f, Constants.HTTP_GET), new c(c.f9290f, Constants.HTTP_POST), new c(c.f9291g, BceConfig.BOS_DELIMITER), new c(c.f9291g, "/index.html"), new c(c.f9292h, "http"), new c(c.f9292h, "https"), new c(c.f9289e, "200"), new c(c.f9289e, "204"), new c(c.f9289e, "206"), new c(c.f9289e, "304"), new c(c.f9289e, "400"), new c(c.f9289e, "404"), new c(c.f9289e, "500"), new c("accept-charset", str), new c("accept-encoding", "gzip, deflate"), new c("accept-language", str), new c("accept-ranges", str), new c("accept", str), new c("access-control-allow-origin", str), new c("age", str), new c("allow", str), new c("authorization", str), new c("cache-control", str), new c("content-disposition", str), new c("content-encoding", str), new c("content-language", str), new c("content-length", str), new c("content-location", str), new c("content-range", str), new c("content-type", str), new c("cookie", str), new c("date", str), new c("etag", str), new c("expect", str), new c("expires", str), new c("from", str), new c("host", str), new c("if-match", str), new c("if-modified-since", str), new c("if-none-match", str), new c("if-range", str), new c("if-unmodified-since", str), new c("last-modified", str), new c("link", str), new c("location", str), new c("max-forwards", str), new c("proxy-authenticate", str), new c("proxy-authorization", str), new c("range", str), new c(Config.LAUNCH_REFERER, str), new c("refresh", str), new c("retry-after", str), new c("server", str), new c("set-cookie", str), new c("strict-transport-security", str), new c("transfer-encoding", str), new c("user-agent", str), new c("vary", str), new c("via", str), new c("www-authenticate", str)};
        LinkedHashMap linkedHashMap = new LinkedHashMap(f9297a.length);
        while (true) {
            c[] cVarArr = f9297a;
            if (i2 < cVarArr.length) {
                if (!linkedHashMap.containsKey(cVarArr[i2].f9294a)) {
                    linkedHashMap.put(f9297a[i2].f9294a, Integer.valueOf(i2));
                }
                i2++;
            } else {
                f9298b = Collections.unmodifiableMap(linkedHashMap);
                return;
            }
        }
    }

    public static h a(h hVar) throws IOException {
        int d2 = hVar.d();
        int i2 = 0;
        while (i2 < d2) {
            byte a2 = hVar.a(i2);
            if (a2 < 65 || a2 > 90) {
                i2++;
            } else {
                StringBuilder a3 = e.a.a.a.a.a("PROTOCOL_ERROR response malformed: mixed case name: ");
                a3.append(hVar.g());
                throw new IOException(a3.toString());
            }
        }
        return hVar;
    }
}
