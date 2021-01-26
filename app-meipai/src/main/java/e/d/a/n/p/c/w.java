package e.d.a.n.p.c;

import e.d.a.n.n.c0.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RecyclableBufferedInputStream */
public class w extends FilterInputStream {

    /* renamed from: a reason: collision with root package name */
    public volatile byte[] f7726a;

    /* renamed from: b reason: collision with root package name */
    public int f7727b;

    /* renamed from: c reason: collision with root package name */
    public int f7728c;

    /* renamed from: d reason: collision with root package name */
    public int f7729d = -1;

    /* renamed from: e reason: collision with root package name */
    public int f7730e;

    /* renamed from: f reason: collision with root package name */
    public final b f7731f;

    /* compiled from: RecyclableBufferedInputStream */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public w(InputStream inputStream, b bVar) {
        super(inputStream);
        this.f7731f = bVar;
        this.f7726a = (byte[]) bVar.b(65536, byte[].class);
    }

    public static IOException d() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f7728c = this.f7726a.length;
    }

    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f7726a == null || inputStream == null) {
            d();
            throw null;
        }
        return (this.f7727b - this.f7730e) + inputStream.available();
    }

    public synchronized void b() {
        if (this.f7726a != null) {
            this.f7731f.a(this.f7726a);
            this.f7726a = null;
        }
    }

    public void close() throws IOException {
        if (this.f7726a != null) {
            this.f7731f.a(this.f7726a);
            this.f7726a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void mark(int i2) {
        this.f7728c = Math.max(this.f7728c, i2);
        this.f7729d = this.f7730e;
    }

    public boolean markSupported() {
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0026=Splitter:B:19:0x0026, B:11:0x0019=Splitter:B:11:0x0019, B:28:0x003b=Splitter:B:28:0x003b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.f7726a     // Catch:{ all -> 0x003f }
            java.io.InputStream r1 = r6.in     // Catch:{ all -> 0x003f }
            r2 = 0
            if (r0 == 0) goto L_0x003b
            if (r1 == 0) goto L_0x003b
            int r3 = r6.f7730e     // Catch:{ all -> 0x003f }
            int r4 = r6.f7727b     // Catch:{ all -> 0x003f }
            r5 = -1
            if (r3 < r4) goto L_0x0019
            int r1 = r6.a(r1, r0)     // Catch:{ all -> 0x003f }
            if (r1 != r5) goto L_0x0019
            monitor-exit(r6)
            return r5
        L_0x0019:
            byte[] r1 = r6.f7726a     // Catch:{ all -> 0x003f }
            if (r0 == r1) goto L_0x0026
            byte[] r0 = r6.f7726a     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0022
            goto L_0x0026
        L_0x0022:
            d()     // Catch:{ all -> 0x003f }
            throw r2
        L_0x0026:
            int r1 = r6.f7727b     // Catch:{ all -> 0x003f }
            int r2 = r6.f7730e     // Catch:{ all -> 0x003f }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0039
            int r1 = r6.f7730e     // Catch:{ all -> 0x003f }
            int r2 = r1 + 1
            r6.f7730e = r2     // Catch:{ all -> 0x003f }
            byte r0 = r0[r1]     // Catch:{ all -> 0x003f }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r6)
            return r0
        L_0x0039:
            monitor-exit(r6)
            return r5
        L_0x003b:
            d()     // Catch:{ all -> 0x003f }
            throw r2
        L_0x003f:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.p.c.w.read():int");
    }

    public synchronized void reset() throws IOException {
        if (this.f7726a == null) {
            throw new IOException("Stream is closed");
        } else if (-1 != this.f7729d) {
            this.f7730e = this.f7729d;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Mark has been invalidated, pos: ");
            sb.append(this.f7730e);
            sb.append(" markLimit: ");
            sb.append(this.f7728c);
            throw new a(sb.toString());
        }
    }

    public synchronized long skip(long j2) throws IOException {
        if (j2 < 1) {
            return 0;
        }
        byte[] bArr = this.f7726a;
        if (bArr != null) {
            InputStream inputStream = this.in;
            if (inputStream == null) {
                d();
                throw null;
            } else if (((long) (this.f7727b - this.f7730e)) >= j2) {
                this.f7730e = (int) (((long) this.f7730e) + j2);
                return j2;
            } else {
                long j3 = ((long) this.f7727b) - ((long) this.f7730e);
                this.f7730e = this.f7727b;
                if (this.f7729d == -1 || j2 > ((long) this.f7728c)) {
                    return j3 + inputStream.skip(j2 - j3);
                } else if (a(inputStream, bArr) == -1) {
                    return j3;
                } else {
                    if (((long) (this.f7727b - this.f7730e)) >= j2 - j3) {
                        this.f7730e = (int) ((((long) this.f7730e) + j2) - j3);
                        return j2;
                    }
                    long j4 = (j3 + ((long) this.f7727b)) - ((long) this.f7730e);
                    this.f7730e = this.f7727b;
                    return j4;
                }
            }
        } else {
            d();
            throw null;
        }
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f7729d;
        if (i2 != -1) {
            int i3 = this.f7730e - i2;
            int i4 = this.f7728c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f7727b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i4) {
                        i4 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f7731f.b(i4, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f7726a = bArr2;
                    this.f7731f.a(bArr);
                    bArr = bArr2;
                } else {
                    int i5 = this.f7729d;
                    if (i5 > 0) {
                        System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                    }
                }
                int i6 = this.f7730e - this.f7729d;
                this.f7730e = i6;
                this.f7729d = 0;
                this.f7727b = 0;
                int read = inputStream.read(bArr, i6, bArr.length - i6);
                int i7 = this.f7730e;
                if (read > 0) {
                    i7 += read;
                }
                this.f7727b = i7;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f7729d = -1;
            this.f7730e = 0;
            this.f7727b = read2;
        }
        return read2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0051, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005e, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.f7726a     // Catch:{ all -> 0x009c }
            r1 = 0
            if (r0 == 0) goto L_0x0098
            if (r9 != 0) goto L_0x000b
            r7 = 0
            monitor-exit(r6)
            return r7
        L_0x000b:
            java.io.InputStream r2 = r6.in     // Catch:{ all -> 0x009c }
            if (r2 == 0) goto L_0x0094
            int r3 = r6.f7730e     // Catch:{ all -> 0x009c }
            int r4 = r6.f7727b     // Catch:{ all -> 0x009c }
            if (r3 >= r4) goto L_0x003c
            int r3 = r6.f7727b     // Catch:{ all -> 0x009c }
            int r4 = r6.f7730e     // Catch:{ all -> 0x009c }
            int r3 = r3 - r4
            if (r3 < r9) goto L_0x001e
            r3 = r9
            goto L_0x0023
        L_0x001e:
            int r3 = r6.f7727b     // Catch:{ all -> 0x009c }
            int r4 = r6.f7730e     // Catch:{ all -> 0x009c }
            int r3 = r3 - r4
        L_0x0023:
            int r4 = r6.f7730e     // Catch:{ all -> 0x009c }
            java.lang.System.arraycopy(r0, r4, r7, r8, r3)     // Catch:{ all -> 0x009c }
            int r4 = r6.f7730e     // Catch:{ all -> 0x009c }
            int r4 = r4 + r3
            r6.f7730e = r4     // Catch:{ all -> 0x009c }
            if (r3 == r9) goto L_0x003a
            int r4 = r2.available()     // Catch:{ all -> 0x009c }
            if (r4 != 0) goto L_0x0036
            goto L_0x003a
        L_0x0036:
            int r8 = r8 + r3
            int r3 = r9 - r3
            goto L_0x003d
        L_0x003a:
            monitor-exit(r6)
            return r3
        L_0x003c:
            r3 = r9
        L_0x003d:
            int r4 = r6.f7729d     // Catch:{ all -> 0x009c }
            r5 = -1
            if (r4 != r5) goto L_0x0052
            int r4 = r0.length     // Catch:{ all -> 0x009c }
            if (r3 < r4) goto L_0x0052
            int r4 = r2.read(r7, r8, r3)     // Catch:{ all -> 0x009c }
            if (r4 != r5) goto L_0x0084
            if (r3 != r9) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            int r5 = r9 - r3
        L_0x0050:
            monitor-exit(r6)
            return r5
        L_0x0052:
            int r4 = r6.a(r2, r0)     // Catch:{ all -> 0x009c }
            if (r4 != r5) goto L_0x005f
            if (r3 != r9) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            int r5 = r9 - r3
        L_0x005d:
            monitor-exit(r6)
            return r5
        L_0x005f:
            byte[] r4 = r6.f7726a     // Catch:{ all -> 0x009c }
            if (r0 == r4) goto L_0x006c
            byte[] r0 = r6.f7726a     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x0068
            goto L_0x006c
        L_0x0068:
            d()     // Catch:{ all -> 0x009c }
            throw r1
        L_0x006c:
            int r4 = r6.f7727b     // Catch:{ all -> 0x009c }
            int r5 = r6.f7730e     // Catch:{ all -> 0x009c }
            int r4 = r4 - r5
            if (r4 < r3) goto L_0x0075
            r4 = r3
            goto L_0x007a
        L_0x0075:
            int r4 = r6.f7727b     // Catch:{ all -> 0x009c }
            int r5 = r6.f7730e     // Catch:{ all -> 0x009c }
            int r4 = r4 - r5
        L_0x007a:
            int r5 = r6.f7730e     // Catch:{ all -> 0x009c }
            java.lang.System.arraycopy(r0, r5, r7, r8, r4)     // Catch:{ all -> 0x009c }
            int r5 = r6.f7730e     // Catch:{ all -> 0x009c }
            int r5 = r5 + r4
            r6.f7730e = r5     // Catch:{ all -> 0x009c }
        L_0x0084:
            int r3 = r3 - r4
            if (r3 != 0) goto L_0x0089
            monitor-exit(r6)
            return r9
        L_0x0089:
            int r5 = r2.available()     // Catch:{ all -> 0x009c }
            if (r5 != 0) goto L_0x0092
            int r9 = r9 - r3
            monitor-exit(r6)
            return r9
        L_0x0092:
            int r8 = r8 + r4
            goto L_0x003d
        L_0x0094:
            d()     // Catch:{ all -> 0x009c }
            throw r1
        L_0x0098:
            d()     // Catch:{ all -> 0x009c }
            throw r1
        L_0x009c:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.p.c.w.read(byte[], int, int):int");
    }
}
