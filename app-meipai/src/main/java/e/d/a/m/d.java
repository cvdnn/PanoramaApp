package e.d.a.m;

import android.util.Log;
import e.a.a.a.a;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* compiled from: GifHeaderParser */
public class d {

    /* renamed from: a reason: collision with root package name */
    public final byte[] f7197a = new byte[256];

    /* renamed from: b reason: collision with root package name */
    public ByteBuffer f7198b;

    /* renamed from: c reason: collision with root package name */
    public c f7199c;

    /* renamed from: d reason: collision with root package name */
    public int f7200d = 0;

    public final int[] a(int i2) {
        byte[] bArr = new byte[(i2 * 3)];
        int[] iArr = null;
        try {
            this.f7198b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | -16777216 | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e2) {
            String str = "GifHeaderParser";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Format Error Reading Color Table", e2);
            }
            this.f7199c.f7188b = 1;
        }
        return iArr;
    }

    public c b() {
        if (this.f7198b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (a()) {
            return this.f7199c;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < 6; i2++) {
                sb.append((char) c());
            }
            if (!sb.toString().startsWith("GIF")) {
                this.f7199c.f7188b = 1;
            } else {
                this.f7199c.f7192f = e();
                this.f7199c.f7193g = e();
                int c2 = c();
                this.f7199c.f7194h = (c2 & 128) != 0;
                this.f7199c.f7195i = (int) Math.pow(2.0d, (double) ((c2 & 7) + 1));
                this.f7199c.f7196j = c();
                this.f7199c.k = c();
                if (this.f7199c.f7194h && !a()) {
                    c cVar = this.f7199c;
                    cVar.f7187a = a(cVar.f7195i);
                    c cVar2 = this.f7199c;
                    cVar2.l = cVar2.f7187a[cVar2.f7196j];
                }
            }
            if (!a()) {
                boolean z = false;
                while (!z && !a() && this.f7199c.f7189c <= Integer.MAX_VALUE) {
                    int c3 = c();
                    if (c3 == 33) {
                        int c4 = c();
                        if (c4 == 1) {
                            f();
                        } else if (c4 == 249) {
                            this.f7199c.f7190d = new b();
                            c();
                            int c5 = c();
                            b bVar = this.f7199c.f7190d;
                            int i3 = (c5 & 28) >> 2;
                            bVar.f7183g = i3;
                            if (i3 == 0) {
                                bVar.f7183g = 1;
                            }
                            this.f7199c.f7190d.f7182f = (c5 & 1) != 0;
                            int e2 = e();
                            if (e2 < 2) {
                                e2 = 10;
                            }
                            b bVar2 = this.f7199c.f7190d;
                            bVar2.f7185i = e2 * 10;
                            bVar2.f7184h = c();
                            c();
                        } else if (c4 == 254) {
                            f();
                        } else if (c4 != 255) {
                            f();
                        } else {
                            d();
                            StringBuilder sb2 = new StringBuilder();
                            for (int i4 = 0; i4 < 11; i4++) {
                                sb2.append((char) this.f7197a[i4]);
                            }
                            if (sb2.toString().equals("NETSCAPE2.0")) {
                                do {
                                    d();
                                    byte[] bArr = this.f7197a;
                                    if (bArr[0] == 1) {
                                        this.f7199c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
                                    }
                                    if (this.f7200d <= 0) {
                                        break;
                                    }
                                } while (!a());
                            } else {
                                f();
                            }
                        }
                    } else if (c3 == 44) {
                        c cVar3 = this.f7199c;
                        if (cVar3.f7190d == null) {
                            cVar3.f7190d = new b();
                        }
                        this.f7199c.f7190d.f7177a = e();
                        this.f7199c.f7190d.f7178b = e();
                        this.f7199c.f7190d.f7179c = e();
                        this.f7199c.f7190d.f7180d = e();
                        int c6 = c();
                        boolean z2 = (c6 & 128) != 0;
                        int pow = (int) Math.pow(2.0d, (double) ((c6 & 7) + 1));
                        this.f7199c.f7190d.f7181e = (c6 & 64) != 0;
                        if (z2) {
                            this.f7199c.f7190d.k = a(pow);
                        } else {
                            this.f7199c.f7190d.k = null;
                        }
                        this.f7199c.f7190d.f7186j = this.f7198b.position();
                        c();
                        f();
                        if (!a()) {
                            c cVar4 = this.f7199c;
                            cVar4.f7189c++;
                            cVar4.f7191e.add(cVar4.f7190d);
                        }
                    } else if (c3 != 59) {
                        this.f7199c.f7188b = 1;
                    } else {
                        z = true;
                    }
                }
                c cVar5 = this.f7199c;
                if (cVar5.f7189c < 0) {
                    cVar5.f7188b = 1;
                }
            }
            return this.f7199c;
        }
    }

    public final int c() {
        try {
            return this.f7198b.get() & 255;
        } catch (Exception unused) {
            this.f7199c.f7188b = 1;
            return 0;
        }
    }

    public final void d() {
        int c2 = c();
        this.f7200d = c2;
        if (c2 > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f7200d) {
                try {
                    i3 = this.f7200d - i2;
                    this.f7198b.get(this.f7197a, i2, i3);
                    i2 += i3;
                } catch (Exception e2) {
                    String str = "GifHeaderParser";
                    if (Log.isLoggable(str, 3)) {
                        StringBuilder a2 = a.a("Error Reading Block n: ", i2, " count: ", i3, " blockSize: ");
                        a2.append(this.f7200d);
                        Log.d(str, a2.toString(), e2);
                    }
                    this.f7199c.f7188b = 1;
                    return;
                }
            }
        }
    }

    public final int e() {
        return this.f7198b.getShort();
    }

    public final void f() {
        int c2;
        do {
            c2 = c();
            this.f7198b.position(Math.min(this.f7198b.position() + c2, this.f7198b.limit()));
        } while (c2 > 0);
    }

    public final boolean a() {
        return this.f7199c.f7188b != 0;
    }
}
