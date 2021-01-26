package g.d0.h;

import e.a.a.a.a;
import g.d0.c;
import h.h;
import java.io.IOException;

/* compiled from: Http2 */
public final class e {

    /* renamed from: a reason: collision with root package name */
    public static final h f9316a = h.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b reason: collision with root package name */
    public static final String[] f9317b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c reason: collision with root package name */
    public static final String[] f9318c = new String[64];

    /* renamed from: d reason: collision with root package name */
    public static final String[] f9319d = new String[256];

    static {
        String str;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = f9319d;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = c.a("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = f9318c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i4 = 0;
        while (true) {
            str = "|PADDED";
            if (i4 >= 1) {
                break;
            }
            int i5 = iArr[i4];
            f9318c[i5 | 8] = a.a(new StringBuilder(), f9318c[i5], str);
            i4++;
        }
        String[] strArr3 = f9318c;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            for (int i8 = 0; i8 < 1; i8++) {
                int i9 = iArr[i8];
                String[] strArr4 = f9318c;
                int i10 = i9 | i7;
                StringBuilder sb = new StringBuilder();
                sb.append(f9318c[i9]);
                sb.append('|');
                sb.append(f9318c[i7]);
                strArr4[i10] = sb.toString();
                String[] strArr5 = f9318c;
                int i11 = i10 | 8;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f9318c[i9]);
                sb2.append('|');
                strArr5[i11] = a.a(sb2, f9318c[i7], str);
            }
        }
        while (true) {
            String[] strArr6 = f9318c;
            if (i2 < strArr6.length) {
                if (strArr6[i2] == null) {
                    strArr6[i2] = f9319d[i2];
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(c.a(str, objArr));
    }

    public static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(c.a(str, objArr));
    }

    public static String a(boolean z, int i2, int i3, byte b2, byte b3) {
        String str;
        String[] strArr = f9317b;
        String a2 = b2 < strArr.length ? strArr[b2] : c.a("0x%02x", Byte.valueOf(b2));
        if (b3 == 0) {
            str = "";
        } else {
            if (!(b2 == 2 || b2 == 3)) {
                if (b2 == 4 || b2 == 6) {
                    str = b3 == 1 ? "ACK" : f9319d[b3];
                } else if (!(b2 == 7 || b2 == 8)) {
                    String[] strArr2 = f9318c;
                    String str2 = b3 < strArr2.length ? strArr2[b3] : f9319d[b3];
                    str = (b2 != 5 || (b3 & 4) == 0) ? (b2 != 0 || (b3 & 32) == 0) ? str2 : str2.replace("PRIORITY", "COMPRESSED") : str2.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            str = f9319d[b3];
        }
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = a2;
        objArr[4] = str;
        return c.a("%s 0x%08x %5d %-13s %s", objArr);
    }
}
