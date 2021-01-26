package e.d.a.n.p.c;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import e.c.f.n.n;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: DefaultImageHeaderParser */
public final class k implements ImageHeaderParser {

    /* renamed from: a reason: collision with root package name */
    public static final byte[] f7680a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b reason: collision with root package name */
    public static final int[] f7681b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* compiled from: DefaultImageHeaderParser */
    public static final class a implements c {

        /* renamed from: a reason: collision with root package name */
        public final ByteBuffer f7682a;

        public a(ByteBuffer byteBuffer) {
            this.f7682a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() throws a {
            return (b() << 8) | b();
        }

        public short b() throws a {
            if (this.f7682a.remaining() >= 1) {
                return (short) (this.f7682a.get() & 255);
            }
            throw new a();
        }

        public long skip(long j2) {
            int min = (int) Math.min((long) this.f7682a.remaining(), j2);
            ByteBuffer byteBuffer = this.f7682a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }

        public int a(byte[] bArr, int i2) {
            int min = Math.min(i2, this.f7682a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f7682a.get(bArr, 0, min);
            return min;
        }
    }

    /* compiled from: DefaultImageHeaderParser */
    public static final class b {

        /* renamed from: a reason: collision with root package name */
        public final ByteBuffer f7683a;

        public b(byte[] bArr, int i2) {
            this.f7683a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        public short a(int i2) {
            if (this.f7683a.remaining() - i2 >= 2) {
                return this.f7683a.getShort(i2);
            }
            return -1;
        }

        public int b(int i2) {
            if (this.f7683a.remaining() - i2 >= 4) {
                return this.f7683a.getInt(i2);
            }
            return -1;
        }
    }

    /* compiled from: DefaultImageHeaderParser */
    public interface c {

        /* compiled from: DefaultImageHeaderParser */
        public static final class a extends IOException {
            public a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a() throws IOException;

        int a(byte[] bArr, int i2) throws IOException;

        short b() throws IOException;

        long skip(long j2) throws IOException;
    }

    /* compiled from: DefaultImageHeaderParser */
    public static final class d implements c {

        /* renamed from: a reason: collision with root package name */
        public final InputStream f7684a;

        public d(InputStream inputStream) {
            this.f7684a = inputStream;
        }

        public int a() throws IOException {
            return (b() << 8) | b();
        }

        public short b() throws IOException {
            int read = this.f7684a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new a();
        }

        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0;
            }
            long j3 = j2;
            while (j3 > 0) {
                long skip = this.f7684a.skip(j3);
                if (skip <= 0) {
                    if (this.f7684a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j3 -= skip;
            }
            return j2 - j3;
        }

        public int a(byte[] bArr, int i2) throws IOException {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                i4 = this.f7684a.read(bArr, i3, i2 - i3);
                if (i4 == -1) {
                    break;
                }
                i3 += i4;
            }
            if (i3 != 0 || i4 != -1) {
                return i3;
            }
            throw new a();
        }
    }

    public ImageType a(InputStream inputStream) throws IOException {
        n.a(inputStream, "Argument must not be null");
        return a((c) new d(inputStream));
    }

    public final int b(c cVar) throws IOException {
        String str;
        short b2;
        int a2;
        long j2;
        long skip;
        do {
            short b3 = cVar.b();
            str = "DfltImageHeaderParser";
            if (b3 != 255) {
                if (Log.isLoggable(str, 3)) {
                    e.a.a.a.a.b("Unknown segmentId=", (int) b3, str);
                }
                return -1;
            }
            b2 = cVar.b();
            if (b2 == 218) {
                return -1;
            }
            if (b2 == 217) {
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = cVar.a() - 2;
            if (b2 == 225) {
                return a2;
            }
            j2 = (long) a2;
            skip = cVar.skip(j2);
        } while (skip == j2);
        if (Log.isLoggable(str, 3)) {
            StringBuilder a3 = e.a.a.a.a.a("Unable to skip enough data, type: ", (int) b2, ", wanted to skip: ", a2, ", but actually skipped: ");
            a3.append(skip);
            Log.d(str, a3.toString());
        }
        return -1;
    }

    public ImageType a(ByteBuffer byteBuffer) throws IOException {
        n.a(byteBuffer, "Argument must not be null");
        return a((c) new a(byteBuffer));
    }

    public int a(InputStream inputStream, e.d.a.n.n.c0.b bVar) throws IOException {
        byte[] bArr;
        String str = "Argument must not be null";
        n.a(inputStream, str);
        d dVar = new d(inputStream);
        n.a(bVar, str);
        try {
            int a2 = dVar.a();
            String str2 = "DfltImageHeaderParser";
            if ((a2 & 65496) == 65496 || a2 == 19789 || a2 == 18761) {
                int b2 = b(dVar);
                if (b2 != -1) {
                    bArr = (byte[]) bVar.b(b2, byte[].class);
                    int a3 = a(dVar, bArr, b2);
                    bVar.a(bArr);
                    return a3;
                } else if (!Log.isLoggable(str2, 3)) {
                    return -1;
                } else {
                    Log.d(str2, "Failed to parse exif segment length, or exif segment not found");
                    return -1;
                }
            } else if (!Log.isLoggable(str2, 3)) {
                return -1;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Parser doesn't handle magic number: ");
                sb.append(a2);
                Log.d(str2, sb.toString());
                return -1;
            }
        } catch (a unused) {
            return -1;
        } catch (Throwable th) {
            bVar.a(bArr);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bumptech.glide.load.ImageHeaderParser.ImageType a(e.d.a.n.p.c.k.c r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r6.a()     // Catch:{ a -> 0x00a0 }
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto L_0x000c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ a -> 0x00a0 }
            return r6
        L_0x000c:
            int r0 = r0 << 8
            short r1 = r6.b()     // Catch:{ a -> 0x00a0 }
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L_0x001b
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF     // Catch:{ a -> 0x00a0 }
            return r6
        L_0x001b:
            int r0 = r0 << 8
            short r1 = r6.b()     // Catch:{ a -> 0x00a0 }
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L_0x003c
            r0 = 21
            r6.skip(r0)     // Catch:{ a -> 0x00a0 }
            short r6 = r6.b()     // Catch:{ a -> 0x0039 }
            r0 = 3
            if (r6 < r0) goto L_0x0036
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ a -> 0x0039 }
            goto L_0x0038
        L_0x0036:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ a -> 0x0039 }
        L_0x0038:
            return r6
        L_0x0039:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ a -> 0x00a0 }
            return r6
        L_0x003c:
            r1 = 1380533830(0x52494646, float:2.16116855E11)
            if (r0 == r1) goto L_0x0044
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ a -> 0x00a0 }
            return r6
        L_0x0044:
            r0 = 4
            r6.skip(r0)     // Catch:{ a -> 0x00a0 }
            int r2 = r6.a()     // Catch:{ a -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.a()     // Catch:{ a -> 0x00a0 }
            r2 = r2 | r3
            r3 = 1464156752(0x57454250, float:2.16888601E14)
            if (r2 == r3) goto L_0x005c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ a -> 0x00a0 }
            return r6
        L_0x005c:
            int r2 = r6.a()     // Catch:{ a -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.a()     // Catch:{ a -> 0x00a0 }
            r2 = r2 | r3
            r3 = r2 & -256(0xffffffffffffff00, float:NaN)
            r4 = 1448097792(0x56503800, float:5.7234734E13)
            if (r3 == r4) goto L_0x0071
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ a -> 0x00a0 }
            return r6
        L_0x0071:
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 88
            if (r2 != r3) goto L_0x0088
            r6.skip(r0)     // Catch:{ a -> 0x00a0 }
            short r6 = r6.b()     // Catch:{ a -> 0x00a0 }
            r6 = r6 & 16
            if (r6 == 0) goto L_0x0085
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ a -> 0x00a0 }
            goto L_0x0087
        L_0x0085:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ a -> 0x00a0 }
        L_0x0087:
            return r6
        L_0x0088:
            r3 = 76
            if (r2 != r3) goto L_0x009d
            r6.skip(r0)     // Catch:{ a -> 0x00a0 }
            short r6 = r6.b()     // Catch:{ a -> 0x00a0 }
            r6 = r6 & 8
            if (r6 == 0) goto L_0x009a
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ a -> 0x00a0 }
            goto L_0x009c
        L_0x009a:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ a -> 0x00a0 }
        L_0x009c:
            return r6
        L_0x009d:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ a -> 0x00a0 }
            return r6
        L_0x00a0:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.p.c.k.a(e.d.a.n.p.c.k$c):com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    public final int a(c cVar, byte[] bArr, int i2) throws IOException {
        ByteOrder byteOrder;
        int a2 = cVar.a(bArr, i2);
        short s = -1;
        String str = "DfltImageHeaderParser";
        if (a2 != i2) {
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to read exif segment data, length: ");
                sb.append(i2);
                sb.append(", actually read: ");
                sb.append(a2);
                Log.d(str, sb.toString());
            }
            return -1;
        }
        int i3 = 0;
        boolean z = bArr != null && i2 > f7680a.length;
        if (z) {
            int i4 = 0;
            while (true) {
                byte[] bArr2 = f7680a;
                if (i4 >= bArr2.length) {
                    break;
                } else if (bArr[i4] != bArr2[i4]) {
                    z = false;
                    break;
                } else {
                    i4++;
                }
            }
        }
        if (z) {
            b bVar = new b(bArr, i2);
            short a3 = bVar.a(6);
            if (a3 == 18761) {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            } else if (a3 != 19789) {
                if (Log.isLoggable(str, 3)) {
                    e.a.a.a.a.b("Unknown endianness = ", (int) a3, str);
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.BIG_ENDIAN;
            }
            bVar.f7683a.order(byteOrder);
            int b2 = bVar.b(10) + 6;
            short a4 = bVar.a(b2);
            while (true) {
                if (i3 >= a4) {
                    break;
                }
                int i5 = (i3 * 12) + b2 + 2;
                short a5 = bVar.a(i5);
                if (a5 == 274) {
                    short a6 = bVar.a(i5 + 2);
                    if (a6 >= 1 && a6 <= 12) {
                        int b3 = bVar.b(i5 + 4);
                        if (b3 >= 0) {
                            String str2 = " tagType=";
                            if (Log.isLoggable(str, 3)) {
                                StringBuilder a7 = e.a.a.a.a.a("Got tagIndex=", i3, str2, (int) a5, " formatCode=");
                                a7.append(a6);
                                a7.append(" componentCount=");
                                a7.append(b3);
                                Log.d(str, a7.toString());
                            }
                            int i6 = b3 + f7681b[a6];
                            if (i6 <= 4) {
                                int i7 = i5 + 8;
                                if (i7 >= 0 && i7 <= bVar.f7683a.remaining()) {
                                    if (i6 >= 0 && i6 + i7 <= bVar.f7683a.remaining()) {
                                        s = bVar.a(i7);
                                        break;
                                    } else if (Log.isLoggable(str, 3)) {
                                        e.a.a.a.a.b("Illegal number of bytes for TI tag data tagType=", (int) a5, str);
                                    }
                                } else if (Log.isLoggable(str, 3)) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Illegal tagValueOffset=");
                                    sb2.append(i7);
                                    sb2.append(str2);
                                    sb2.append(a5);
                                    Log.d(str, sb2.toString());
                                }
                            } else if (Log.isLoggable(str, 3)) {
                                e.a.a.a.a.b("Got byte count > 4, not orientation, continuing, formatCode=", (int) a6, str);
                            }
                        } else if (Log.isLoggable(str, 3)) {
                            Log.d(str, "Negative tiff component count");
                        }
                    } else if (Log.isLoggable(str, 3)) {
                        e.a.a.a.a.b("Got invalid format code = ", (int) a6, str);
                    }
                }
                i3++;
            }
            return s;
        }
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Missing jpeg exif preamble");
        }
        return -1;
    }
}
