package e.d.a.l;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache */
public final class a implements Closeable {

    /* renamed from: a reason: collision with root package name */
    public final File f7146a;

    /* renamed from: b reason: collision with root package name */
    public final File f7147b;

    /* renamed from: c reason: collision with root package name */
    public final File f7148c;

    /* renamed from: d reason: collision with root package name */
    public final File f7149d;

    /* renamed from: e reason: collision with root package name */
    public final int f7150e;

    /* renamed from: f reason: collision with root package name */
    public long f7151f;

    /* renamed from: g reason: collision with root package name */
    public final int f7152g;

    /* renamed from: h reason: collision with root package name */
    public long f7153h = 0;

    /* renamed from: i reason: collision with root package name */
    public Writer f7154i;

    /* renamed from: j reason: collision with root package name */
    public final LinkedHashMap<String, d> f7155j = new LinkedHashMap<>(0, 0.75f, true);
    public int k;
    public long l = 0;
    public final ThreadPoolExecutor m;
    public final Callable<Void> n;

    /* renamed from: e.d.a.l.a$a reason: collision with other inner class name */
    /* compiled from: DiskLruCache */
    public class C0078a implements Callable<Void> {
        public C0078a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                e.d.a.l.a r0 = e.d.a.l.a.this
                monitor-enter(r0)
                e.d.a.l.a r1 = e.d.a.l.a.this     // Catch:{ all -> 0x0025 }
                java.io.Writer r1 = r1.f7154i     // Catch:{ all -> 0x0025 }
                r2 = 0
                if (r1 != 0) goto L_0x000c
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return r2
            L_0x000c:
                e.d.a.l.a r1 = e.d.a.l.a.this     // Catch:{ all -> 0x0025 }
                r1.l()     // Catch:{ all -> 0x0025 }
                e.d.a.l.a r1 = e.d.a.l.a.this     // Catch:{ all -> 0x0025 }
                boolean r1 = r1.b()     // Catch:{ all -> 0x0025 }
                if (r1 == 0) goto L_0x0023
                e.d.a.l.a r1 = e.d.a.l.a.this     // Catch:{ all -> 0x0025 }
                r1.i()     // Catch:{ all -> 0x0025 }
                e.d.a.l.a r1 = e.d.a.l.a.this     // Catch:{ all -> 0x0025 }
                r3 = 0
                r1.k = r3     // Catch:{ all -> 0x0025 }
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return r2
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: e.d.a.l.a.C0078a.call():java.lang.Void");
        }
    }

    /* compiled from: DiskLruCache */
    public static final class b implements ThreadFactory {
        public /* synthetic */ b(C0078a aVar) {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* compiled from: DiskLruCache */
    public final class c {

        /* renamed from: a reason: collision with root package name */
        public final d f7157a;

        /* renamed from: b reason: collision with root package name */
        public final boolean[] f7158b;

        /* renamed from: c reason: collision with root package name */
        public boolean f7159c;

        public /* synthetic */ c(d dVar, C0078a aVar) {
            boolean[] zArr;
            this.f7157a = dVar;
            if (dVar.f7165e) {
                zArr = null;
            } else {
                zArr = new boolean[a.this.f7152g];
            }
            this.f7158b = zArr;
        }

        public File a(int i2) throws IOException {
            File file;
            synchronized (a.this) {
                if (this.f7157a.f7166f == this) {
                    if (!this.f7157a.f7165e) {
                        this.f7158b[i2] = true;
                    }
                    file = this.f7157a.f7164d[i2];
                    if (!a.this.f7146a.exists()) {
                        a.this.f7146a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return file;
        }

        public void a() throws IOException {
            a.this.a(this, false);
        }
    }

    /* compiled from: DiskLruCache */
    public final class d {

        /* renamed from: a reason: collision with root package name */
        public final String f7161a;

        /* renamed from: b reason: collision with root package name */
        public final long[] f7162b;

        /* renamed from: c reason: collision with root package name */
        public File[] f7163c;

        /* renamed from: d reason: collision with root package name */
        public File[] f7164d;

        /* renamed from: e reason: collision with root package name */
        public boolean f7165e;

        /* renamed from: f reason: collision with root package name */
        public c f7166f;

        /* renamed from: g reason: collision with root package name */
        public long f7167g;

        public /* synthetic */ d(String str, C0078a aVar) {
            this.f7161a = str;
            int i2 = a.this.f7152g;
            this.f7162b = new long[i2];
            this.f7163c = new File[i2];
            this.f7164d = new File[i2];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i3 = 0; i3 < a.this.f7152g; i3++) {
                sb.append(i3);
                this.f7163c[i3] = new File(a.this.f7146a, sb.toString());
                sb.append(".tmp");
                this.f7164d[i3] = new File(a.this.f7146a, sb.toString());
                sb.setLength(length);
            }
        }

        public String a() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f7162b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        public final IOException a(String[] strArr) throws IOException {
            StringBuilder a2 = e.a.a.a.a.a("unexpected journal line: ");
            a2.append(Arrays.toString(strArr));
            throw new IOException(a2.toString());
        }
    }

    /* compiled from: DiskLruCache */
    public final class e {

        /* renamed from: a reason: collision with root package name */
        public final File[] f7169a;

        public /* synthetic */ e(a aVar, String str, long j2, File[] fileArr, long[] jArr, C0078a aVar2) {
            this.f7169a = fileArr;
        }
    }

    public a(File file, int i2, int i3, long j2) {
        File file2 = file;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
        this.m = threadPoolExecutor;
        this.n = new C0078a();
        this.f7146a = file2;
        this.f7150e = i2;
        this.f7147b = new File(file2, "journal");
        this.f7148c = new File(file2, "journal.tmp");
        this.f7149d = new File(file2, "journal.bkp");
        this.f7152g = i3;
        this.f7151f = j2;
    }

    public static a a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i2, i3, j2);
            if (aVar.f7147b.exists()) {
                try {
                    aVar.e();
                    aVar.d();
                    return aVar;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(file);
                    sb.append(" is corrupt: ");
                    sb.append(e2.getMessage());
                    sb.append(", removing");
                    printStream.println(sb.toString());
                    aVar.close();
                    c.a(aVar.f7146a);
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i2, i3, j2);
            aVar2.i();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public final void b(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        String str3 = "unexpected journal line: ";
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f7155j.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            d dVar = (d) this.f7155j.get(str2);
            if (dVar == null) {
                dVar = new d(str2, null);
                this.f7155j.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f7165e = true;
                dVar.f7166f = null;
                if (split.length == a.this.f7152g) {
                    int i3 = 0;
                    while (i3 < split.length) {
                        try {
                            dVar.f7162b[i3] = Long.parseLong(split[i3]);
                            i3++;
                        } catch (NumberFormatException unused) {
                            dVar.a(split);
                            throw null;
                        }
                    }
                } else {
                    dVar.a(split);
                    throw null;
                }
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f7166f = new c(dVar, null);
            } else if (!(indexOf2 == -1 && indexOf == 4 && str.startsWith("READ"))) {
                throw new IOException(e.a.a.a.a.a(str3, str));
            }
            return;
        }
        throw new IOException(e.a.a.a.a.a(str3, str));
    }

    public synchronized void close() throws IOException {
        if (this.f7154i != null) {
            Iterator it = new ArrayList(this.f7155j.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f7166f != null) {
                    dVar.f7166f.a();
                }
            }
            l();
            a(this.f7154i);
            this.f7154i = null;
        }
    }

    public final void d() throws IOException {
        a(this.f7148c);
        Iterator it = this.f7155j.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i2 = 0;
            if (dVar.f7166f == null) {
                while (i2 < this.f7152g) {
                    this.f7153h += dVar.f7162b[i2];
                    i2++;
                }
            } else {
                dVar.f7166f = null;
                while (i2 < this.f7152g) {
                    a(dVar.f7163c[i2]);
                    a(dVar.f7164d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|(1:19)|(1:21)(1:22)|23|24|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.k = r2 - r9.f7155j.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006d, code lost:
        if (r1.f7174e == -1) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        if (r0 != false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0076, code lost:
        r9.f7154i = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f7147b, true), e.d.a.l.c.f7176a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0090, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0060 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0060=Splitter:B:16:0x0060, B:28:0x0091=Splitter:B:28:0x0091} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            e.d.a.l.b r1 = new e.d.a.l.b
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f7147b
            r2.<init>(r3)
            java.nio.charset.Charset r3 = e.d.a.l.c.f7176a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.b()     // Catch:{ all -> 0x00bf }
            java.lang.String r3 = r1.b()     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = r1.b()     // Catch:{ all -> 0x00bf }
            java.lang.String r5 = r1.b()     // Catch:{ all -> 0x00bf }
            java.lang.String r6 = r1.b()     // Catch:{ all -> 0x00bf }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00bf }
            if (r7 == 0) goto L_0x0091
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00bf }
            if (r7 == 0) goto L_0x0091
            int r7 = r9.f7150e     // Catch:{ all -> 0x00bf }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00bf }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00bf }
            if (r4 == 0) goto L_0x0091
            int r4 = r9.f7152g     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00bf }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00bf }
            if (r4 == 0) goto L_0x0091
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00bf }
            if (r4 == 0) goto L_0x0091
            r0 = 0
            r2 = r0
        L_0x0056:
            java.lang.String r3 = r1.b()     // Catch:{ EOFException -> 0x0060 }
            r9.b(r3)     // Catch:{ EOFException -> 0x0060 }
            int r2 = r2 + 1
            goto L_0x0056
        L_0x0060:
            java.util.LinkedHashMap<java.lang.String, e.d.a.l.a$d> r3 = r9.f7155j     // Catch:{ all -> 0x00bf }
            int r3 = r3.size()     // Catch:{ all -> 0x00bf }
            int r2 = r2 - r3
            r9.k = r2     // Catch:{ all -> 0x00bf }
            int r2 = r1.f7174e     // Catch:{ all -> 0x00bf }
            r3 = -1
            r4 = 1
            if (r2 != r3) goto L_0x0070
            r0 = r4
        L_0x0070:
            if (r0 == 0) goto L_0x0076
            r9.i()     // Catch:{ all -> 0x00bf }
            goto L_0x008b
        L_0x0076:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00bf }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00bf }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00bf }
            java.io.File r5 = r9.f7147b     // Catch:{ all -> 0x00bf }
            r3.<init>(r5, r4)     // Catch:{ all -> 0x00bf }
            java.nio.charset.Charset r4 = e.d.a.l.c.f7176a     // Catch:{ all -> 0x00bf }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00bf }
            r0.<init>(r2)     // Catch:{ all -> 0x00bf }
            r9.f7154i = r0     // Catch:{ all -> 0x00bf }
        L_0x008b:
            r1.close()     // Catch:{ RuntimeException -> 0x008f, Exception -> 0x008e }
        L_0x008e:
            return
        L_0x008f:
            r0 = move-exception
            throw r0
        L_0x0091:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00bf }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
            r7.<init>()     // Catch:{ all -> 0x00bf }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00bf }
            r7.append(r2)     // Catch:{ all -> 0x00bf }
            r7.append(r0)     // Catch:{ all -> 0x00bf }
            r7.append(r3)     // Catch:{ all -> 0x00bf }
            r7.append(r0)     // Catch:{ all -> 0x00bf }
            r7.append(r5)     // Catch:{ all -> 0x00bf }
            r7.append(r0)     // Catch:{ all -> 0x00bf }
            r7.append(r6)     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00bf }
            r4.<init>(r0)     // Catch:{ all -> 0x00bf }
            throw r4     // Catch:{ all -> 0x00bf }
        L_0x00bf:
            r0 = move-exception
            r1.close()     // Catch:{ RuntimeException -> 0x00c4, Exception -> 0x00c3 }
        L_0x00c3:
            throw r0
        L_0x00c4:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.l.a.e():void");
    }

    public final synchronized void i() throws IOException {
        if (this.f7154i != null) {
            a(this.f7154i);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7148c), c.f7176a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f7150e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f7152g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.f7155j.values()) {
                if (dVar.f7166f != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DIRTY ");
                    sb.append(dVar.f7161a);
                    sb.append(10);
                    bufferedWriter.write(sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("CLEAN ");
                    sb2.append(dVar.f7161a);
                    sb2.append(dVar.a());
                    sb2.append(10);
                    bufferedWriter.write(sb2.toString());
                }
            }
            a((Writer) bufferedWriter);
            if (this.f7147b.exists()) {
                a(this.f7147b, this.f7149d, true);
            }
            a(this.f7148c, this.f7147b, false);
            this.f7149d.delete();
            this.f7154i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7147b, true), c.f7176a));
        } finally {
            a((Writer) bufferedWriter);
        }
    }

    public final void l() throws IOException {
        while (this.f7153h > this.f7151f) {
            d((String) ((Entry) this.f7155j.entrySet().iterator().next()).getKey());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0085, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean d(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.a()     // Catch:{ all -> 0x0088 }
            java.util.LinkedHashMap<java.lang.String, e.d.a.l.a$d> r0 = r7.f7155j     // Catch:{ all -> 0x0088 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0088 }
            e.d.a.l.a$d r0 = (e.d.a.l.a.d) r0     // Catch:{ all -> 0x0088 }
            r1 = 0
            if (r0 == 0) goto L_0x0086
            e.d.a.l.a$c r2 = r0.f7166f     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x0014
            goto L_0x0086
        L_0x0014:
            int r2 = r7.f7152g     // Catch:{ all -> 0x0088 }
            if (r1 >= r2) goto L_0x0052
            java.io.File[] r2 = r0.f7163c     // Catch:{ all -> 0x0088 }
            r2 = r2[r1]     // Catch:{ all -> 0x0088 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0088 }
            if (r3 == 0) goto L_0x0040
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0088 }
            if (r3 == 0) goto L_0x0029
            goto L_0x0040
        L_0x0029:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r0.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x0088 }
            r0.append(r2)     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0088 }
            r8.<init>(r0)     // Catch:{ all -> 0x0088 }
            throw r8     // Catch:{ all -> 0x0088 }
        L_0x0040:
            long r2 = r7.f7153h     // Catch:{ all -> 0x0088 }
            long[] r4 = r0.f7162b     // Catch:{ all -> 0x0088 }
            r5 = r4[r1]     // Catch:{ all -> 0x0088 }
            long r2 = r2 - r5
            r7.f7153h = r2     // Catch:{ all -> 0x0088 }
            long[] r2 = r0.f7162b     // Catch:{ all -> 0x0088 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0088 }
            int r1 = r1 + 1
            goto L_0x0014
        L_0x0052:
            int r0 = r7.k     // Catch:{ all -> 0x0088 }
            r1 = 1
            int r0 = r0 + r1
            r7.k = r0     // Catch:{ all -> 0x0088 }
            java.io.Writer r0 = r7.f7154i     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x0088 }
            java.io.Writer r0 = r7.f7154i     // Catch:{ all -> 0x0088 }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x0088 }
            java.io.Writer r0 = r7.f7154i     // Catch:{ all -> 0x0088 }
            r0.append(r8)     // Catch:{ all -> 0x0088 }
            java.io.Writer r0 = r7.f7154i     // Catch:{ all -> 0x0088 }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x0088 }
            java.util.LinkedHashMap<java.lang.String, e.d.a.l.a$d> r0 = r7.f7155j     // Catch:{ all -> 0x0088 }
            r0.remove(r8)     // Catch:{ all -> 0x0088 }
            boolean r8 = r7.b()     // Catch:{ all -> 0x0088 }
            if (r8 == 0) goto L_0x0084
            java.util.concurrent.ThreadPoolExecutor r8 = r7.m     // Catch:{ all -> 0x0088 }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.n     // Catch:{ all -> 0x0088 }
            r8.submit(r0)     // Catch:{ all -> 0x0088 }
        L_0x0084:
            monitor-exit(r7)
            return r1
        L_0x0086:
            monitor-exit(r7)
            return r1
        L_0x0088:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.l.a.d(java.lang.String):boolean");
    }

    public static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized e a(String str) throws IOException {
        a();
        d dVar = (d) this.f7155j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f7165e) {
            return null;
        }
        for (File exists : dVar.f7163c) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.k++;
        this.f7154i.append("READ");
        this.f7154i.append(' ');
        this.f7154i.append(str);
        this.f7154i.append(10);
        if (b()) {
            this.m.submit(this.n);
        }
        e eVar = new e(this, str, dVar.f7167g, dVar.f7163c, dVar.f7162b, null);
        return eVar;
    }

    public final boolean b() {
        int i2 = this.k;
        return i2 >= 2000 && i2 >= this.f7155j.size();
    }

    @TargetApi(26)
    public static void b(Writer writer) throws IOException {
        if (VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized e.d.a.l.a.c a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.a()     // Catch:{ all -> 0x0058 }
            java.util.LinkedHashMap<java.lang.String, e.d.a.l.a$d> r0 = r5.f7155j     // Catch:{ all -> 0x0058 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0058 }
            e.d.a.l.a$d r0 = (e.d.a.l.a.d) r0     // Catch:{ all -> 0x0058 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x001d
            if (r0 == 0) goto L_0x001b
            long r3 = r0.f7167g     // Catch:{ all -> 0x0058 }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x001d
        L_0x001b:
            monitor-exit(r5)
            return r2
        L_0x001d:
            if (r0 != 0) goto L_0x002a
            e.d.a.l.a$d r0 = new e.d.a.l.a$d     // Catch:{ all -> 0x0058 }
            r0.<init>(r6, r2)     // Catch:{ all -> 0x0058 }
            java.util.LinkedHashMap<java.lang.String, e.d.a.l.a$d> r7 = r5.f7155j     // Catch:{ all -> 0x0058 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0058 }
            goto L_0x0030
        L_0x002a:
            e.d.a.l.a$c r7 = r0.f7166f     // Catch:{ all -> 0x0058 }
            if (r7 == 0) goto L_0x0030
            monitor-exit(r5)
            return r2
        L_0x0030:
            e.d.a.l.a$c r7 = new e.d.a.l.a$c     // Catch:{ all -> 0x0058 }
            r7.<init>(r0, r2)     // Catch:{ all -> 0x0058 }
            r0.f7166f = r7     // Catch:{ all -> 0x0058 }
            java.io.Writer r8 = r5.f7154i     // Catch:{ all -> 0x0058 }
            java.lang.String r0 = "DIRTY"
            r8.append(r0)     // Catch:{ all -> 0x0058 }
            java.io.Writer r8 = r5.f7154i     // Catch:{ all -> 0x0058 }
            r0 = 32
            r8.append(r0)     // Catch:{ all -> 0x0058 }
            java.io.Writer r8 = r5.f7154i     // Catch:{ all -> 0x0058 }
            r8.append(r6)     // Catch:{ all -> 0x0058 }
            java.io.Writer r6 = r5.f7154i     // Catch:{ all -> 0x0058 }
            r8 = 10
            r6.append(r8)     // Catch:{ all -> 0x0058 }
            java.io.Writer r6 = r5.f7154i     // Catch:{ all -> 0x0058 }
            b(r6)     // Catch:{ all -> 0x0058 }
            monitor-exit(r5)
            return r7
        L_0x0058:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.l.a.a(java.lang.String, long):e.d.a.l.a$c");
    }

    public final void a() {
        if (this.f7154i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    public static void a(Writer writer) throws IOException {
        if (VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(e.d.a.l.a.c r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            e.d.a.l.a$d r0 = r10.f7157a     // Catch:{ all -> 0x00f7 }
            e.d.a.l.a$c r1 = r0.f7166f     // Catch:{ all -> 0x00f7 }
            if (r1 != r10) goto L_0x00f1
            r1 = 0
            if (r11 == 0) goto L_0x0045
            boolean r2 = r0.f7165e     // Catch:{ all -> 0x00f7 }
            if (r2 != 0) goto L_0x0045
            r2 = r1
        L_0x000f:
            int r3 = r9.f7152g     // Catch:{ all -> 0x00f7 }
            if (r2 >= r3) goto L_0x0045
            boolean[] r3 = r10.f7158b     // Catch:{ all -> 0x00f7 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00f7 }
            if (r3 == 0) goto L_0x002b
            java.io.File[] r3 = r0.f7164d     // Catch:{ all -> 0x00f7 }
            r3 = r3[r2]     // Catch:{ all -> 0x00f7 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x00f7 }
            if (r3 != 0) goto L_0x0028
            r10.a()     // Catch:{ all -> 0x00f7 }
            monitor-exit(r9)
            return
        L_0x0028:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x002b:
            r10.a()     // Catch:{ all -> 0x00f7 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f7 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r11.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x00f7 }
            r11.append(r2)     // Catch:{ all -> 0x00f7 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00f7 }
            r10.<init>(r11)     // Catch:{ all -> 0x00f7 }
            throw r10     // Catch:{ all -> 0x00f7 }
        L_0x0045:
            int r10 = r9.f7152g     // Catch:{ all -> 0x00f7 }
            if (r1 >= r10) goto L_0x0075
            java.io.File[] r10 = r0.f7164d     // Catch:{ all -> 0x00f7 }
            r10 = r10[r1]     // Catch:{ all -> 0x00f7 }
            if (r11 == 0) goto L_0x006f
            boolean r2 = r10.exists()     // Catch:{ all -> 0x00f7 }
            if (r2 == 0) goto L_0x0072
            java.io.File[] r2 = r0.f7163c     // Catch:{ all -> 0x00f7 }
            r2 = r2[r1]     // Catch:{ all -> 0x00f7 }
            r10.renameTo(r2)     // Catch:{ all -> 0x00f7 }
            long[] r10 = r0.f7162b     // Catch:{ all -> 0x00f7 }
            r3 = r10[r1]     // Catch:{ all -> 0x00f7 }
            long r5 = r2.length()     // Catch:{ all -> 0x00f7 }
            long[] r10 = r0.f7162b     // Catch:{ all -> 0x00f7 }
            r10[r1] = r5     // Catch:{ all -> 0x00f7 }
            long r7 = r9.f7153h     // Catch:{ all -> 0x00f7 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f7153h = r7     // Catch:{ all -> 0x00f7 }
            goto L_0x0072
        L_0x006f:
            a(r10)     // Catch:{ all -> 0x00f7 }
        L_0x0072:
            int r1 = r1 + 1
            goto L_0x0045
        L_0x0075:
            int r10 = r9.k     // Catch:{ all -> 0x00f7 }
            r1 = 1
            int r10 = r10 + r1
            r9.k = r10     // Catch:{ all -> 0x00f7 }
            r10 = 0
            r0.f7166f = r10     // Catch:{ all -> 0x00f7 }
            boolean r10 = r0.f7165e     // Catch:{ all -> 0x00f7 }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00b6
            r0.f7165e = r1     // Catch:{ all -> 0x00f7 }
            java.io.Writer r10 = r9.f7154i     // Catch:{ all -> 0x00f7 }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x00f7 }
            java.io.Writer r10 = r9.f7154i     // Catch:{ all -> 0x00f7 }
            r10.append(r3)     // Catch:{ all -> 0x00f7 }
            java.io.Writer r10 = r9.f7154i     // Catch:{ all -> 0x00f7 }
            java.lang.String r1 = r0.f7161a     // Catch:{ all -> 0x00f7 }
            r10.append(r1)     // Catch:{ all -> 0x00f7 }
            java.io.Writer r10 = r9.f7154i     // Catch:{ all -> 0x00f7 }
            java.lang.String r1 = r0.a()     // Catch:{ all -> 0x00f7 }
            r10.append(r1)     // Catch:{ all -> 0x00f7 }
            java.io.Writer r10 = r9.f7154i     // Catch:{ all -> 0x00f7 }
            r10.append(r2)     // Catch:{ all -> 0x00f7 }
            if (r11 == 0) goto L_0x00d5
            long r10 = r9.l     // Catch:{ all -> 0x00f7 }
            r1 = 1
            long r1 = r1 + r10
            r9.l = r1     // Catch:{ all -> 0x00f7 }
            r0.f7167g = r10     // Catch:{ all -> 0x00f7 }
            goto L_0x00d5
        L_0x00b6:
            java.util.LinkedHashMap<java.lang.String, e.d.a.l.a$d> r10 = r9.f7155j     // Catch:{ all -> 0x00f7 }
            java.lang.String r11 = r0.f7161a     // Catch:{ all -> 0x00f7 }
            r10.remove(r11)     // Catch:{ all -> 0x00f7 }
            java.io.Writer r10 = r9.f7154i     // Catch:{ all -> 0x00f7 }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x00f7 }
            java.io.Writer r10 = r9.f7154i     // Catch:{ all -> 0x00f7 }
            r10.append(r3)     // Catch:{ all -> 0x00f7 }
            java.io.Writer r10 = r9.f7154i     // Catch:{ all -> 0x00f7 }
            java.lang.String r11 = r0.f7161a     // Catch:{ all -> 0x00f7 }
            r10.append(r11)     // Catch:{ all -> 0x00f7 }
            java.io.Writer r10 = r9.f7154i     // Catch:{ all -> 0x00f7 }
            r10.append(r2)     // Catch:{ all -> 0x00f7 }
        L_0x00d5:
            java.io.Writer r10 = r9.f7154i     // Catch:{ all -> 0x00f7 }
            b(r10)     // Catch:{ all -> 0x00f7 }
            long r10 = r9.f7153h     // Catch:{ all -> 0x00f7 }
            long r0 = r9.f7151f     // Catch:{ all -> 0x00f7 }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x00e8
            boolean r10 = r9.b()     // Catch:{ all -> 0x00f7 }
            if (r10 == 0) goto L_0x00ef
        L_0x00e8:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.m     // Catch:{ all -> 0x00f7 }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.n     // Catch:{ all -> 0x00f7 }
            r10.submit(r11)     // Catch:{ all -> 0x00f7 }
        L_0x00ef:
            monitor-exit(r9)
            return
        L_0x00f1:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f7 }
            r10.<init>()     // Catch:{ all -> 0x00f7 }
            throw r10     // Catch:{ all -> 0x00f7 }
        L_0x00f7:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.l.a.a(e.d.a.l.a$c, boolean):void");
    }
}
