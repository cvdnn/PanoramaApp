package e.i.a.h.j;

import android.content.Context;
import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import e.i.a.e;
import e.i.a.h.d.c;
import e.i.a.h.d.g;
import e.i.a.h.j.a.C0126a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* compiled from: MultiPointOutputStream */
public class f {
    public static final ExecutorService y;

    /* renamed from: a reason: collision with root package name */
    public final SparseArray<a> f8866a = new SparseArray<>();

    /* renamed from: b reason: collision with root package name */
    public final SparseArray<AtomicLong> f8867b = new SparseArray<>();

    /* renamed from: c reason: collision with root package name */
    public final AtomicLong f8868c = new AtomicLong();

    /* renamed from: d reason: collision with root package name */
    public final AtomicLong f8869d = new AtomicLong();

    /* renamed from: e reason: collision with root package name */
    public boolean f8870e = false;

    /* renamed from: f reason: collision with root package name */
    public final int f8871f;

    /* renamed from: g reason: collision with root package name */
    public final int f8872g;

    /* renamed from: h reason: collision with root package name */
    public final int f8873h;

    /* renamed from: i reason: collision with root package name */
    public final c f8874i;

    /* renamed from: j reason: collision with root package name */
    public final e.i.a.c f8875j;
    public final g k;
    public final boolean l;
    public final boolean m;
    public volatile Future n;
    public volatile Thread o;
    public final SparseArray<Thread> p = new SparseArray<>();
    public final Runnable q;
    public String r;
    public IOException s;
    public ArrayList<Integer> t;
    @SuppressFBWarnings({"IS2_INCONSISTENT_SYNC"})
    public List<Integer> u;
    public final a v = new a();
    public a w = new a();
    public volatile boolean x = true;

    /* compiled from: MultiPointOutputStream */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public boolean f8876a;

        /* renamed from: b reason: collision with root package name */
        public List<Integer> f8877b = new ArrayList();

        /* renamed from: c reason: collision with root package name */
        public List<Integer> f8878c = new ArrayList();
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), e.i.a.h.c.a("OkDownload file io", false));
        y = threadPoolExecutor;
    }

    public f(e.i.a.c cVar, c cVar2, g gVar) {
        this.f8875j = cVar;
        this.f8871f = cVar.f8656i;
        this.f8872g = cVar.f8657j;
        this.f8873h = cVar.k;
        this.f8874i = cVar2;
        this.k = gVar;
        if (((e.i.a.h.j.b.a) e.a().f8668e) != null) {
            this.l = true;
            this.m = e.a().f8669f.b(cVar);
            this.t = new ArrayList<>();
            this.q = new d(this);
            File g2 = cVar.g();
            if (g2 != null) {
                this.r = g2.getAbsolutePath();
                return;
            }
            return;
        }
        throw null;
    }

    public synchronized void a(int i2, byte[] bArr, int i3) throws IOException {
        if (!this.f8870e) {
            c(i2).write(bArr, 0, i3);
            long j2 = (long) i3;
            this.f8868c.addAndGet(j2);
            ((AtomicLong) this.f8867b.get(i2)).addAndGet(j2);
            c();
        }
    }

    public void b(int i2) throws IOException {
        this.t.add(Integer.valueOf(i2));
        try {
            if (this.s == null) {
                if (this.n != null && !this.n.isDone()) {
                    AtomicLong atomicLong = (AtomicLong) this.f8867b.get(i2);
                    if (atomicLong != null && atomicLong.get() > 0) {
                        a(this.v);
                        a(this.v.f8876a, i2);
                    }
                } else if (this.n == null) {
                    int i3 = this.f8875j.f8649b;
                } else {
                    this.n.isDone();
                    int i4 = this.f8875j.f8649b;
                }
                return;
            }
            throw this.s;
        } finally {
            a(i2);
        }
    }

    public void c() throws IOException {
        IOException iOException = this.s;
        if (iOException != null) {
            throw iOException;
        } else if (this.n == null) {
            synchronized (this.q) {
                if (this.n == null) {
                    this.n = y.submit(this.q);
                }
            }
        }
    }

    public void d() throws IOException {
        int i2;
        int i3;
        int i4 = this.f8875j.f8649b;
        this.o = Thread.currentThread();
        long j2 = (long) this.f8873h;
        b();
        while (true) {
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(j2));
            a(this.w);
            a aVar = this.w;
            i2 = 0;
            if (aVar.f8876a || aVar.f8878c.size() > 0) {
                StringBuilder a2 = e.a.a.a.a.a("runSync state change isNoMoreStream[");
                a2.append(this.w.f8876a);
                String str = "]";
                a2.append(str);
                a2.append(" newNoMoreStreamBlockList[");
                a2.append(this.w.f8878c);
                a2.append(str);
                a2.toString();
                if (this.f8868c.get() > 0) {
                    b();
                }
                for (Integer num : this.w.f8878c) {
                    Thread thread = (Thread) this.p.get(num.intValue());
                    this.p.remove(num.intValue());
                    if (thread != null) {
                        LockSupport.unpark(thread);
                    }
                }
                if (this.w.f8876a) {
                    break;
                }
            } else {
                if (this.f8868c.get() < ((long) this.f8872g)) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    i3 = this.f8873h;
                } else {
                    j2 = ((long) this.f8873h) - (SystemClock.uptimeMillis() - this.f8869d.get());
                    if (j2 <= 0) {
                        b();
                        i3 = this.f8873h;
                    }
                }
                j2 = (long) i3;
            }
        }
        int size = this.p.size();
        while (i2 < size) {
            Thread thread2 = (Thread) this.p.valueAt(i2);
            if (thread2 != null) {
                LockSupport.unpark(thread2);
            }
            i2++;
        }
        this.p.clear();
        int i5 = this.f8875j.f8649b;
    }

    public synchronized void a() {
        if (this.u != null) {
            if (!this.f8870e) {
                this.f8870e = true;
                this.t.addAll(this.u);
                try {
                    if (this.f8868c.get() <= 0) {
                        for (Integer num : this.u) {
                            a(num.intValue());
                        }
                        this.k.a(this.f8875j.f8649b, e.i.a.h.e.a.CANCELED, (Exception) null);
                        return;
                    }
                    if (this.n != null && !this.n.isDone()) {
                        if (this.r == null && this.f8875j.g() != null) {
                            this.r = this.f8875j.g().getAbsolutePath();
                        }
                        e.a().f8669f.f8879a.b(this.r);
                        a(true, -1);
                        e.a().f8669f.f8879a.a(this.r);
                    }
                    for (Integer num2 : this.u) {
                        try {
                            a(num2.intValue());
                        } catch (IOException e2) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("OutputStream close failed task[");
                            sb.append(this.f8875j.f8649b);
                            sb.append("] block[");
                            sb.append(num2);
                            sb.append("]");
                            sb.append(e2);
                            sb.toString();
                        }
                    }
                    this.k.a(this.f8875j.f8649b, e.i.a.h.e.a.CANCELED, (Exception) null);
                } catch (IOException e3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("OutputStream close failed task[");
                    sb2.append(this.f8875j.f8649b);
                    sb2.append("] block[");
                    sb2.append(num);
                    sb2.append("]");
                    sb2.append(e3);
                    sb2.toString();
                } catch (Throwable th) {
                    for (Integer num3 : this.u) {
                        try {
                            a(num3.intValue());
                        } catch (IOException e4) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("OutputStream close failed task[");
                            sb3.append(this.f8875j.f8649b);
                            sb3.append("] block[");
                            sb3.append(num3);
                            sb3.append("]");
                            sb3.append(e4);
                            sb3.toString();
                        }
                    }
                    this.k.a(this.f8875j.f8649b, e.i.a.h.e.a.CANCELED, (Exception) null);
                    throw th;
                }
            }
        }
    }

    public synchronized a c(int i2) throws IOException {
        a aVar;
        Uri uri;
        aVar = (a) this.f8866a.get(i2);
        if (aVar == null) {
            boolean equals = this.f8875j.f8651d.getScheme().equals(SdkConfigOptions.KEY_SO_FILE);
            if (equals) {
                File g2 = this.f8875j.g();
                if (g2 != null) {
                    File file = this.f8875j.x;
                    if (!file.exists()) {
                        if (!file.mkdirs()) {
                            throw new IOException("Create parent folder failed!");
                        }
                    }
                    if (g2.createNewFile()) {
                        g2.getName();
                    }
                    uri = Uri.fromFile(g2);
                } else {
                    throw new FileNotFoundException("Filename is not ready!");
                }
            } else {
                uri = this.f8875j.f8651d;
            }
            C0126a aVar2 = e.a().f8668e;
            Context context = e.a().f8671h;
            int i3 = this.f8871f;
            if (((e.i.a.h.j.b.a) aVar2) != null) {
                a bVar = new b(context, uri, i3);
                if (this.l) {
                    long b2 = ((e.i.a.h.d.a) this.f8874i.f8708g.get(i2)).b();
                    if (b2 > 0) {
                        bVar.b(b2);
                        int i4 = this.f8875j.f8649b;
                    }
                }
                if (this.x) {
                    this.k.a(this.f8875j.f8649b);
                }
                if (!this.f8874i.f8710i && this.x && this.m) {
                    long d2 = this.f8874i.d();
                    if (equals) {
                        File g3 = this.f8875j.g();
                        long length = d2 - g3.length();
                        if (length > 0) {
                            long a2 = e.i.a.h.c.a(new StatFs(g3.getAbsolutePath()));
                            if (a2 >= length) {
                                bVar.a(d2);
                            } else {
                                throw new e.i.a.h.i.e(length, a2);
                            }
                        }
                    } else {
                        bVar.a(d2);
                    }
                }
                synchronized (this.f8867b) {
                    this.f8866a.put(i2, bVar);
                    this.f8867b.put(i2, new AtomicLong());
                }
                this.x = false;
                aVar = bVar;
            } else {
                throw null;
            }
        }
        return aVar;
    }

    public void b() throws IOException {
        int size;
        long j2;
        boolean z;
        synchronized (this.f8867b) {
            size = this.f8867b.size();
        }
        SparseArray sparseArray = new SparseArray(size);
        int i2 = 0;
        while (true) {
            j2 = 0;
            if (i2 >= size) {
                break;
            }
            try {
                int keyAt = this.f8866a.keyAt(i2);
                long j3 = ((AtomicLong) this.f8867b.get(keyAt)).get();
                if (j3 > 0) {
                    sparseArray.put(keyAt, Long.valueOf(j3));
                    ((a) this.f8866a.get(keyAt)).a();
                }
                i2++;
            } catch (IOException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("OutputStream flush and sync data to filesystem failed ");
                sb.append(e2);
                sb.toString();
                z = false;
            }
        }
        z = true;
        if (z) {
            int size2 = sparseArray.size();
            for (int i3 = 0; i3 < size2; i3++) {
                int keyAt2 = sparseArray.keyAt(i3);
                long longValue = ((Long) sparseArray.valueAt(i3)).longValue();
                this.k.a(this.f8874i, keyAt2, longValue);
                j2 += longValue;
                ((AtomicLong) this.f8867b.get(keyAt2)).addAndGet(-longValue);
                int i4 = this.f8875j.f8649b;
                this.f8874i.a(keyAt2).a();
            }
            this.f8868c.addAndGet(-j2);
            this.f8869d.set(SystemClock.uptimeMillis());
        }
    }

    public void a(boolean z, int i2) {
        if (this.n != null && !this.n.isDone()) {
            if (!z) {
                this.p.put(i2, Thread.currentThread());
            }
            if (this.o != null) {
                LockSupport.unpark(this.o);
            } else {
                while (true) {
                    if (this.o != null) {
                        break;
                    }
                    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(25));
                }
                LockSupport.unpark(this.o);
            }
            if (z) {
                LockSupport.unpark(this.o);
                try {
                    this.n.get();
                } catch (InterruptedException | ExecutionException unused) {
                }
            } else {
                LockSupport.park();
            }
        }
    }

    public synchronized void a(int i2) throws IOException {
        a aVar = (a) this.f8866a.get(i2);
        if (aVar != null) {
            aVar.close();
            this.f8866a.remove(i2);
            int i3 = this.f8875j.f8649b;
        }
    }

    public void a(a aVar) {
        aVar.f8878c.clear();
        if (new HashSet((List) this.t.clone()).size() != this.u.size()) {
            int i2 = this.f8875j.f8649b;
            this.u.size();
            aVar.f8876a = false;
        } else {
            int i3 = this.f8875j.f8649b;
            this.u.size();
            aVar.f8876a = true;
        }
        SparseArray clone = this.f8866a.clone();
        int size = clone.size();
        for (int i4 = 0; i4 < size; i4++) {
            int keyAt = clone.keyAt(i4);
            if (this.t.contains(Integer.valueOf(keyAt)) && !aVar.f8877b.contains(Integer.valueOf(keyAt))) {
                aVar.f8877b.add(Integer.valueOf(keyAt));
                aVar.f8878c.add(Integer.valueOf(keyAt));
            }
        }
    }
}
