package com.baidu.mobstat;

import com.arashivision.graphicpath.render.Stabilization.GyroType;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.facebook.stetho.dumpapp.Framer;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class db {

    /* renamed from: a reason: collision with root package name */
    public static final /* synthetic */ boolean f1842a = (!db.class.desiredAssertionStatus());

    /* renamed from: b reason: collision with root package name */
    public static final byte[] f1843b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: c reason: collision with root package name */
    public static final byte[] f1844c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, Framer.ENTER_FRAME_PREFIX, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, Framer.STDIN_FRAME_PREFIX, 46, 47, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: d reason: collision with root package name */
    public static final byte[] f1845d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX};

    /* renamed from: e reason: collision with root package name */
    public static final byte[] f1846e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, Framer.ENTER_FRAME_PREFIX, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, Framer.STDIN_FRAME_PREFIX, 46, 47, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: f reason: collision with root package name */
    public static final byte[] f1847f = {Framer.STDIN_FRAME_PREFIX, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, Framer.STDIN_REQUEST_FRAME_PREFIX, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122};

    /* renamed from: g reason: collision with root package name */
    public static final byte[] f1848g;

    public static class a extends FilterOutputStream {

        /* renamed from: a reason: collision with root package name */
        public boolean f1849a;

        /* renamed from: b reason: collision with root package name */
        public int f1850b;

        /* renamed from: c reason: collision with root package name */
        public byte[] f1851c;

        /* renamed from: d reason: collision with root package name */
        public int f1852d;

        /* renamed from: e reason: collision with root package name */
        public int f1853e;

        /* renamed from: f reason: collision with root package name */
        public boolean f1854f;

        /* renamed from: g reason: collision with root package name */
        public byte[] f1855g;

        /* renamed from: h reason: collision with root package name */
        public boolean f1856h;

        /* renamed from: i reason: collision with root package name */
        public int f1857i;

        /* renamed from: j reason: collision with root package name */
        public byte[] f1858j;

        public a(OutputStream outputStream, int i2) {
            super(outputStream);
            boolean z = true;
            this.f1854f = (i2 & 8) != 0;
            if ((i2 & 1) == 0) {
                z = false;
            }
            this.f1849a = z;
            int i3 = z ? 3 : 4;
            this.f1852d = i3;
            this.f1851c = new byte[i3];
            this.f1850b = 0;
            this.f1853e = 0;
            this.f1856h = false;
            this.f1855g = new byte[4];
            this.f1857i = i2;
            this.f1858j = db.c(i2);
        }

        public void a() throws IOException {
            int i2 = this.f1850b;
            if (i2 <= 0) {
                return;
            }
            if (this.f1849a) {
                this.out.write(db.b(this.f1855g, this.f1851c, i2, this.f1857i));
                this.f1850b = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void close() throws IOException {
            a();
            super.close();
            this.f1851c = null;
            this.out = null;
        }

        public void write(int i2) throws IOException {
            if (this.f1856h) {
                this.out.write(i2);
                return;
            }
            if (this.f1849a) {
                byte[] bArr = this.f1851c;
                int i3 = this.f1850b;
                int i4 = i3 + 1;
                this.f1850b = i4;
                bArr[i3] = (byte) i2;
                int i5 = this.f1852d;
                if (i4 >= i5) {
                    this.out.write(db.b(this.f1855g, bArr, i5, this.f1857i));
                    int i6 = this.f1853e + 4;
                    this.f1853e = i6;
                    if (this.f1854f && i6 >= 76) {
                        this.out.write(10);
                        this.f1853e = 0;
                    }
                    this.f1850b = 0;
                }
            } else {
                byte[] bArr2 = this.f1858j;
                int i7 = i2 & GyroType.INS_WEARABLE_TEST;
                if (bArr2[i7] > -5) {
                    byte[] bArr3 = this.f1851c;
                    int i8 = this.f1850b;
                    int i9 = i8 + 1;
                    this.f1850b = i9;
                    bArr3[i8] = (byte) i2;
                    if (i9 >= this.f1852d) {
                        this.out.write(this.f1855g, 0, db.b(bArr3, 0, this.f1855g, 0, this.f1857i));
                        this.f1850b = 0;
                    }
                } else if (bArr2[i7] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (this.f1856h) {
                this.out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }
    }

    static {
        byte[] bArr = new byte[SapiErrorCode.PHONE_NULL];
        // fill-array-data instruction
        bArr[0] = -9;
        bArr[1] = -9;
        bArr[2] = -9;
        bArr[3] = -9;
        bArr[4] = -9;
        bArr[5] = -9;
        bArr[6] = -9;
        bArr[7] = -9;
        bArr[8] = -9;
        bArr[9] = -5;
        bArr[10] = -5;
        bArr[11] = -9;
        bArr[12] = -9;
        bArr[13] = -5;
        bArr[14] = -9;
        bArr[15] = -9;
        bArr[16] = -9;
        bArr[17] = -9;
        bArr[18] = -9;
        bArr[19] = -9;
        bArr[20] = -9;
        bArr[21] = -9;
        bArr[22] = -9;
        bArr[23] = -9;
        bArr[24] = -9;
        bArr[25] = -9;
        bArr[26] = -9;
        bArr[27] = -9;
        bArr[28] = -9;
        bArr[29] = -9;
        bArr[30] = -9;
        bArr[31] = -9;
        bArr[32] = -5;
        bArr[33] = -9;
        bArr[34] = -9;
        bArr[35] = -9;
        bArr[36] = -9;
        bArr[37] = -9;
        bArr[38] = -9;
        bArr[39] = -9;
        bArr[40] = -9;
        bArr[41] = -9;
        bArr[42] = -9;
        bArr[43] = -9;
        bArr[44] = -9;
        bArr[45] = 0;
        bArr[46] = -9;
        bArr[47] = -9;
        bArr[48] = 1;
        bArr[49] = 2;
        bArr[50] = 3;
        bArr[51] = 4;
        bArr[52] = 5;
        bArr[53] = 6;
        bArr[54] = 7;
        bArr[55] = 8;
        bArr[56] = 9;
        bArr[57] = 10;
        bArr[58] = -9;
        bArr[59] = -9;
        bArr[60] = -9;
        bArr[61] = -1;
        bArr[62] = -9;
        bArr[63] = -9;
        bArr[64] = -9;
        bArr[65] = 11;
        bArr[66] = 12;
        bArr[67] = 13;
        bArr[68] = 14;
        bArr[69] = 15;
        bArr[70] = 16;
        bArr[71] = 17;
        bArr[72] = 18;
        bArr[73] = 19;
        bArr[74] = 20;
        bArr[75] = 21;
        bArr[76] = 22;
        bArr[77] = 23;
        bArr[78] = 24;
        bArr[79] = 25;
        bArr[80] = 26;
        bArr[81] = 27;
        bArr[82] = 28;
        bArr[83] = 29;
        bArr[84] = 30;
        bArr[85] = 31;
        bArr[86] = 32;
        bArr[87] = 33;
        bArr[88] = 34;
        bArr[89] = 35;
        bArr[90] = 36;
        bArr[91] = -9;
        bArr[92] = -9;
        bArr[93] = -9;
        bArr[94] = -9;
        bArr[95] = 37;
        bArr[96] = -9;
        bArr[97] = 38;
        bArr[98] = 39;
        bArr[99] = 40;
        bArr[100] = 41;
        bArr[101] = 42;
        bArr[102] = 43;
        bArr[103] = 44;
        bArr[104] = 45;
        bArr[105] = 46;
        bArr[106] = 47;
        bArr[107] = 48;
        bArr[108] = 49;
        bArr[109] = 50;
        bArr[110] = 51;
        bArr[111] = 52;
        bArr[112] = 53;
        bArr[113] = 54;
        bArr[114] = 55;
        bArr[115] = 56;
        bArr[116] = 57;
        bArr[117] = 58;
        bArr[118] = 59;
        bArr[119] = 60;
        bArr[120] = 61;
        bArr[121] = 62;
        bArr[122] = 63;
        bArr[123] = -9;
        bArr[124] = -9;
        bArr[125] = -9;
        bArr[126] = -9;
        bArr[127] = -9;
        bArr[128] = -9;
        bArr[129] = -9;
        bArr[130] = -9;
        bArr[131] = -9;
        bArr[132] = -9;
        bArr[133] = -9;
        bArr[134] = -9;
        bArr[135] = -9;
        bArr[136] = -9;
        bArr[137] = -9;
        bArr[138] = -9;
        bArr[139] = -9;
        bArr[140] = -9;
        bArr[141] = -9;
        bArr[142] = -9;
        bArr[143] = -9;
        bArr[144] = -9;
        bArr[145] = -9;
        bArr[146] = -9;
        bArr[147] = -9;
        bArr[148] = -9;
        bArr[149] = -9;
        bArr[150] = -9;
        bArr[151] = -9;
        bArr[152] = -9;
        bArr[153] = -9;
        bArr[154] = -9;
        bArr[155] = -9;
        bArr[156] = -9;
        bArr[157] = -9;
        bArr[158] = -9;
        bArr[159] = -9;
        bArr[160] = -9;
        bArr[161] = -9;
        bArr[162] = -9;
        bArr[163] = -9;
        bArr[164] = -9;
        bArr[165] = -9;
        bArr[166] = -9;
        bArr[167] = -9;
        bArr[168] = -9;
        bArr[169] = -9;
        bArr[170] = -9;
        bArr[171] = -9;
        bArr[172] = -9;
        bArr[173] = -9;
        bArr[174] = -9;
        bArr[175] = -9;
        bArr[176] = -9;
        bArr[177] = -9;
        bArr[178] = -9;
        bArr[179] = -9;
        bArr[180] = -9;
        bArr[181] = -9;
        bArr[182] = -9;
        bArr[183] = -9;
        bArr[184] = -9;
        bArr[185] = -9;
        bArr[186] = -9;
        bArr[187] = -9;
        bArr[188] = -9;
        bArr[189] = -9;
        bArr[190] = -9;
        bArr[191] = -9;
        bArr[192] = -9;
        bArr[193] = -9;
        bArr[194] = -9;
        bArr[195] = -9;
        bArr[196] = -9;
        bArr[197] = -9;
        bArr[198] = -9;
        bArr[199] = -9;
        bArr[200] = -9;
        bArr[201] = -9;
        bArr[202] = -9;
        bArr[203] = -9;
        bArr[204] = -9;
        bArr[205] = -9;
        bArr[206] = -9;
        bArr[207] = -9;
        bArr[208] = -9;
        bArr[209] = -9;
        bArr[210] = -9;
        bArr[211] = -9;
        bArr[212] = -9;
        bArr[213] = -9;
        bArr[214] = -9;
        bArr[215] = -9;
        bArr[216] = -9;
        bArr[217] = -9;
        bArr[218] = -9;
        bArr[219] = -9;
        bArr[220] = -9;
        bArr[221] = -9;
        bArr[222] = -9;
        bArr[223] = -9;
        bArr[224] = -9;
        bArr[225] = -9;
        bArr[226] = -9;
        bArr[227] = -9;
        bArr[228] = -9;
        bArr[229] = -9;
        bArr[230] = -9;
        bArr[231] = -9;
        bArr[232] = -9;
        bArr[233] = -9;
        bArr[234] = -9;
        bArr[235] = -9;
        bArr[236] = -9;
        bArr[237] = -9;
        bArr[238] = -9;
        bArr[239] = -9;
        bArr[240] = -9;
        bArr[241] = -9;
        bArr[242] = -9;
        bArr[243] = -9;
        bArr[244] = -9;
        bArr[245] = -9;
        bArr[246] = -9;
        bArr[247] = -9;
        bArr[248] = -9;
        bArr[249] = -9;
        bArr[250] = -9;
        bArr[251] = -9;
        bArr[252] = -9;
        bArr[253] = -9;
        bArr[254] = -9;
        bArr[255] = -9;
        bArr[256] = -9;
        f1848g = bArr;
    }

    public static final byte[] b(int i2) {
        if ((i2 & 16) == 16) {
            return f1845d;
        }
        if ((i2 & 32) == 32) {
            return f1847f;
        }
        return f1843b;
    }

    public static final byte[] c(int i2) {
        if ((i2 & 16) == 16) {
            return f1846e;
        }
        if ((i2 & 32) == 32) {
            return f1848g;
        }
        return f1844c;
    }

    public static byte[] a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] b2 = b(i5);
        int i6 = 0;
        int i7 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0);
        if (i3 > 2) {
            i6 = (bArr[i2 + 2] << 24) >>> 24;
        }
        int i8 = i7 | i6;
        if (i3 == 1) {
            bArr2[i4] = b2[i8 >>> 18];
            bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 == 2) {
            bArr2[i4] = b2[i8 >>> 18];
            bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = b2[(i8 >>> 6) & 63];
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 != 3) {
            return bArr2;
        } else {
            bArr2[i4] = b2[i8 >>> 18];
            bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = b2[(i8 >>> 6) & 63];
            bArr2[i4 + 3] = b2[i8 & 63];
            return bArr2;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        a(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    /* JADX WARNING: type inference failed for: r1v25 */
    /* JADX WARNING: type inference failed for: r3v6, types: [com.baidu.mobstat.db$a] */
    /* JADX WARNING: type inference failed for: r2v11, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r1v26, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r1v27 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r1v28 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r2v17, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r1v29 */
    /* JADX WARNING: type inference failed for: r17v0 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r1v30 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11, types: [java.io.OutputStream, com.baidu.mobstat.db$a] */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r1v31 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r4v11, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARNING: type inference failed for: r1v32 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:32|33|46|47|48|49|50|51|52) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0034 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0060 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0063 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v7
  assigns: []
  uses: []
  mth insns count: 143
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 17 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r18, int r19, int r20, int r21) throws java.io.IOException {
        /*
            r0 = r18
            r7 = r19
            r8 = r20
            if (r0 == 0) goto L_0x0109
            if (r7 < 0) goto L_0x00fd
            if (r8 < 0) goto L_0x00f1
            int r1 = r7 + r8
            int r2 = r0.length
            r9 = 1
            if (r1 > r2) goto L_0x00cd
            r1 = r21 & 2
            if (r1 == 0) goto L_0x0067
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0055, all -> 0x0051 }
            r2.<init>()     // Catch:{ IOException -> 0x0055, all -> 0x0051 }
            com.baidu.mobstat.db$a r3 = new com.baidu.mobstat.db$a     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            r4 = r21 | 1
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0042, all -> 0x0040 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0042, all -> 0x0040 }
            r4.write(r0, r7, r8)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r4.close()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r4.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            r3.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r2.close()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            byte[] r0 = r2.toByteArray()
            return r0
        L_0x003c:
            r0 = move-exception
            goto L_0x005c
        L_0x003e:
            r0 = move-exception
            goto L_0x0044
        L_0x0040:
            r0 = move-exception
            goto L_0x005d
        L_0x0042:
            r0 = move-exception
            r4 = r1
        L_0x0044:
            r1 = r3
            goto L_0x004b
        L_0x0046:
            r0 = move-exception
            r3 = r1
            goto L_0x005d
        L_0x0049:
            r0 = move-exception
            r4 = r1
        L_0x004b:
            r17 = r2
            r2 = r1
            r1 = r17
            goto L_0x0058
        L_0x0051:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x005d
        L_0x0055:
            r0 = move-exception
            r2 = r1
            r4 = r2
        L_0x0058:
            throw r0     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r0 = move-exception
            r3 = r2
            r2 = r1
        L_0x005c:
            r1 = r4
        L_0x005d:
            r1.close()     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            r3.close()     // Catch:{ Exception -> 0x0063 }
        L_0x0063:
            r2.close()     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            throw r0
        L_0x0067:
            r1 = r21 & 8
            if (r1 == 0) goto L_0x006d
            r10 = r9
            goto L_0x006f
        L_0x006d:
            r1 = 0
            r10 = r1
        L_0x006f:
            int r1 = r8 / 3
            r2 = 4
            int r1 = r1 * r2
            int r3 = r8 % 3
            if (r3 <= 0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r2 = 0
        L_0x0079:
            int r1 = r1 + r2
            if (r10 == 0) goto L_0x007f
            int r2 = r1 / 76
            int r1 = r1 + r2
        L_0x007f:
            r11 = r1
            byte[] r12 = new byte[r11]
            int r13 = r8 + -2
            r1 = 0
            r2 = 0
            r3 = 0
            r14 = r1
            r15 = r2
            r16 = r3
        L_0x008b:
            if (r14 >= r13) goto L_0x00b1
            int r2 = r14 + r7
            r3 = 3
            r1 = r18
            r4 = r12
            r5 = r15
            r6 = r21
            a(r1, r2, r3, r4, r5, r6)
            int r1 = r16 + 4
            if (r10 == 0) goto L_0x00aa
            r2 = 76
            if (r1 < r2) goto L_0x00aa
            int r1 = r15 + 4
            r2 = 10
            r12[r1] = r2
            int r15 = r15 + 1
            r1 = 0
        L_0x00aa:
            r16 = r1
            int r14 = r14 + 3
            int r15 = r15 + 4
            goto L_0x008b
        L_0x00b1:
            if (r14 >= r8) goto L_0x00c2
            int r2 = r14 + r7
            int r3 = r8 - r14
            r1 = r18
            r4 = r12
            r5 = r15
            r6 = r21
            a(r1, r2, r3, r4, r5, r6)
            int r15 = r15 + 4
        L_0x00c2:
            int r11 = r11 - r9
            if (r15 > r11) goto L_0x00cc
            byte[] r0 = new byte[r15]
            r1 = 0
            java.lang.System.arraycopy(r12, r1, r0, r1, r15)
            return r0
        L_0x00cc:
            return r12
        L_0x00cd:
            r1 = 0
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)
            r3[r1] = r4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r20)
            r3[r9] = r1
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = 2
            r3[r1] = r0
            java.lang.String r0 = "Cannot have offset of %d and length of %d with array of length %d"
            java.lang.String r0 = java.lang.String.format(r0, r3)
            r2.<init>(r0)
            throw r2
        L_0x00f1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot have length offset: "
            java.lang.String r1 = e.a.a.a.a.a(r1, r8)
            r0.<init>(r1)
            throw r0
        L_0x00fd:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot have negative offset: "
            java.lang.String r1 = e.a.a.a.a.a(r1, r7)
            r0.<init>(r1)
            throw r0
        L_0x0109:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Cannot serialize a null array."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.db.b(byte[], int, int, int):byte[]");
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (f1842a) {
                str = null;
            } else {
                throw new AssertionError(e2.getMessage());
            }
        }
        if (f1842a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2, int i3, int i4) throws IOException {
        byte[] b2 = b(bArr, i2, i3, i4);
        try {
            return new String(b2, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(b2);
        }
    }

    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        } else if (bArr2 != null) {
            if (i2 >= 0) {
                int i5 = i2 + 3;
                if (i5 < bArr.length) {
                    if (i3 >= 0) {
                        int i6 = i3 + 2;
                        if (i6 < bArr2.length) {
                            byte[] c2 = c(i4);
                            int i7 = i2 + 2;
                            if (bArr[i7] == 61) {
                                bArr2[i3] = (byte) ((((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18)) >>> 16);
                                return 1;
                            } else if (bArr[i5] == 61) {
                                int i8 = ((c2[bArr[i7]] & 255) << 6) | ((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18);
                                bArr2[i3] = (byte) (i8 >>> 16);
                                bArr2[i3 + 1] = (byte) (i8 >>> 8);
                                return 2;
                            } else {
                                byte b2 = (c2[bArr[i5]] & 255) | ((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18) | ((c2[bArr[i7]] & 255) << 6);
                                bArr2[i3] = (byte) (b2 >> 16);
                                bArr2[i3 + 1] = (byte) (b2 >> 8);
                                bArr2[i6] = (byte) b2;
                                return 3;
                            }
                        }
                    }
                    throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i3)}));
                }
            }
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2)}));
        } else {
            throw new NullPointerException("Destination array was null.");
        }
    }
}
