package i.d.a.j;

import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* compiled from: AsiExtraField */
public class a implements d, Cloneable {

    /* renamed from: g reason: collision with root package name */
    public static final f f9900g = new f(30062);

    /* renamed from: a reason: collision with root package name */
    public int f9901a = 0;

    /* renamed from: b reason: collision with root package name */
    public int f9902b = 0;

    /* renamed from: c reason: collision with root package name */
    public int f9903c = 0;

    /* renamed from: d reason: collision with root package name */
    public String f9904d = "";

    /* renamed from: e reason: collision with root package name */
    public boolean f9905e = false;

    /* renamed from: f reason: collision with root package name */
    public CRC32 f9906f = new CRC32();

    public f a() {
        return f9900g;
    }

    public f b() {
        return new f(this.f9904d.getBytes().length + 14);
    }

    public byte[] c() {
        int i2 = b().f9911a - 4;
        byte[] bArr = new byte[i2];
        System.arraycopy(f.a(this.f9901a), 0, bArr, 0, 2);
        byte[] bytes = this.f9904d.getBytes();
        System.arraycopy(e.a((long) bytes.length), 0, bArr, 2, 4);
        System.arraycopy(f.a(this.f9902b), 0, bArr, 6, 2);
        System.arraycopy(f.a(this.f9903c), 0, bArr, 8, 2);
        System.arraycopy(bytes, 0, bArr, 10, bytes.length);
        this.f9906f.reset();
        this.f9906f.update(bArr);
        byte[] bArr2 = new byte[(i2 + 4)];
        System.arraycopy(e.a(this.f9906f.getValue()), 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, i2);
        return bArr2;
    }

    public Object clone() {
        try {
            a aVar = (a) super.clone();
            aVar.f9906f = new CRC32();
            return aVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if ((r3.f9904d.length() != 0) == false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(int r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.f9904d
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000c
            r0 = r1
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            if (r0 == 0) goto L_0x0013
            r0 = 40960(0xa000, float:5.7397E-41)
            goto L_0x002e
        L_0x0013:
            boolean r0 = r3.f9905e
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = r3.f9904d
            int r0 = r0.length()
            if (r0 == 0) goto L_0x0021
            r0 = r1
            goto L_0x0022
        L_0x0021:
            r0 = r2
        L_0x0022:
            if (r0 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r1 = r2
        L_0x0026:
            if (r1 == 0) goto L_0x002b
            r0 = 16384(0x4000, float:2.2959E-41)
            goto L_0x002e
        L_0x002b:
            r0 = 32768(0x8000, float:4.5918E-41)
        L_0x002e:
            r4 = r4 & 4095(0xfff, float:5.738E-42)
            r4 = r4 | r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: i.d.a.j.a.a(int):int");
    }

    public void a(byte[] bArr, int i2, int i3) throws ZipException {
        long a2 = e.a(bArr, i2);
        int i4 = i3 - 4;
        byte[] bArr2 = new byte[i4];
        boolean z = false;
        System.arraycopy(bArr, i2 + 4, bArr2, 0, i4);
        this.f9906f.reset();
        this.f9906f.update(bArr2);
        long value = this.f9906f.getValue();
        if (a2 == value) {
            int a3 = f.a(bArr2, 0);
            int a4 = (int) e.a(bArr2, 2);
            byte[] bArr3 = new byte[a4];
            this.f9902b = f.a(bArr2, 6);
            this.f9903c = f.a(bArr2, 8);
            if (a4 == 0) {
                this.f9904d = "";
            } else {
                System.arraycopy(bArr2, 10, bArr3, 0, a4);
                this.f9904d = new String(bArr3);
            }
            if ((a3 & 16384) != 0) {
                z = true;
            }
            this.f9905e = z;
            this.f9901a = a(this.f9901a);
            this.f9901a = a(a3);
            return;
        }
        StringBuilder a5 = e.a.a.a.a.a("bad CRC checksum ");
        a5.append(Long.toHexString(a2));
        a5.append(" instead of ");
        a5.append(Long.toHexString(value));
        throw new ZipException(a5.toString());
    }
}
