package e.i.a;

import android.net.Uri;
import android.util.SparseArray;
import com.baidubce.BceConfig;
import e.i.a.h.g.b;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: DownloadTask */
public class c extends e.i.a.h.a implements Comparable<c> {

    /* renamed from: b reason: collision with root package name */
    public final int f8649b;

    /* renamed from: c reason: collision with root package name */
    public final String f8650c;

    /* renamed from: d reason: collision with root package name */
    public final Uri f8651d;

    /* renamed from: e reason: collision with root package name */
    public final Map<String, List<String>> f8652e;

    /* renamed from: f reason: collision with root package name */
    public e.i.a.h.d.c f8653f;

    /* renamed from: g reason: collision with root package name */
    public final int f8654g;

    /* renamed from: h reason: collision with root package name */
    public final int f8655h;

    /* renamed from: i reason: collision with root package name */
    public final int f8656i;

    /* renamed from: j reason: collision with root package name */
    public final int f8657j;
    public final int k;
    public final Integer l;
    public final Boolean m;
    public final boolean n;
    public final boolean o;
    public final int p;
    public volatile a q;
    public volatile SparseArray<Object> r;
    public final boolean s;
    public final AtomicLong t = new AtomicLong();
    public final boolean u;
    public final e.i.a.h.h.g.a v;
    public final File w;
    public final File x;
    public File y;
    public String z;

    /* compiled from: DownloadTask */
    public static class a extends e.i.a.h.a {

        /* renamed from: b reason: collision with root package name */
        public final int f8658b;

        /* renamed from: c reason: collision with root package name */
        public final String f8659c;

        /* renamed from: d reason: collision with root package name */
        public final File f8660d;

        /* renamed from: e reason: collision with root package name */
        public final String f8661e;

        /* renamed from: f reason: collision with root package name */
        public final File f8662f;

        public a(int i2, c cVar) {
            this.f8658b = i2;
            this.f8659c = cVar.f8650c;
            this.f8662f = cVar.x;
            this.f8660d = cVar.w;
            this.f8661e = cVar.v.f8854a;
        }

        public String a() {
            return this.f8661e;
        }

        public int b() {
            return this.f8658b;
        }

        public File c() {
            return this.f8662f;
        }

        public File d() {
            return this.f8660d;
        }

        public String e() {
            return this.f8659c;
        }
    }

    public c(String str, Uri uri, int i2, int i3, int i4, int i5, int i6, boolean z2, int i7, Map<String, List<String>> map, String str2, boolean z3, boolean z4, Boolean bool, Integer num, Boolean bool2) {
        String str3;
        Boolean bool3;
        String str4;
        this.f8650c = str;
        this.f8651d = uri;
        this.f8654g = i2;
        this.f8655h = i3;
        this.f8656i = i4;
        this.f8657j = i5;
        this.k = i6;
        this.o = z2;
        this.p = i7;
        this.f8652e = map;
        this.n = z3;
        this.s = z4;
        this.l = num;
        this.m = bool2;
        if (e.i.a.h.c.c(uri)) {
            File file = new File(uri.getPath());
            String str5 = BceConfig.BOS_DELIMITER;
            if (bool != null) {
                if (bool.booleanValue()) {
                    if (!file.exists() || !file.isFile()) {
                        String str6 = !e.i.a.h.c.a((CharSequence) str2) ? null : str2;
                        this.x = file;
                        bool3 = bool;
                        str3 = str6;
                    } else {
                        StringBuilder a2 = e.a.a.a.a.a("If you want filename from response please make sure you provide path is directory ");
                        a2.append(file.getPath());
                        throw new IllegalArgumentException(a2.toString());
                    }
                } else if (!file.exists() || !file.isDirectory() || !e.i.a.h.c.a((CharSequence) str2)) {
                    if (e.i.a.h.c.a((CharSequence) str2)) {
                        str4 = file.getName();
                        File parentFile = file.getParentFile();
                        if (parentFile == null) {
                            parentFile = new File(str5);
                        }
                        this.x = parentFile;
                    } else {
                        this.x = file;
                        str4 = str2;
                    }
                    str3 = str4;
                    bool3 = bool;
                } else {
                    StringBuilder a3 = e.a.a.a.a.a("If you don't want filename from response please make sure you have already provided valid filename or not directory path ");
                    a3.append(file.getPath());
                    throw new IllegalArgumentException(a3.toString());
                }
            } else if (!file.exists() || !file.isDirectory()) {
                bool3 = Boolean.valueOf(false);
                if (!file.exists()) {
                    String str7 = str2;
                    if (e.i.a.h.c.a((CharSequence) str2)) {
                        str3 = file.getName();
                        File parentFile2 = file.getParentFile();
                        if (parentFile2 == null) {
                            parentFile2 = new File(str5);
                        }
                        this.x = parentFile2;
                    } else {
                        this.x = file;
                        str3 = str7;
                    }
                } else if (e.i.a.h.c.a((CharSequence) str2) || file.getName().equals(str2)) {
                    str3 = file.getName();
                    File parentFile3 = file.getParentFile();
                    if (parentFile3 == null) {
                        parentFile3 = new File(str5);
                    }
                    this.x = parentFile3;
                } else {
                    throw new IllegalArgumentException("Uri already provided filename!");
                }
            } else {
                Boolean valueOf = Boolean.valueOf(true);
                this.x = file;
                str3 = str2;
                bool3 = valueOf;
            }
            this.u = bool3.booleanValue();
        } else {
            String str8 = str2;
            this.u = false;
            this.x = new File(uri.getPath());
            str3 = str8;
        }
        if (e.i.a.h.c.a((CharSequence) str3)) {
            this.v = new e.i.a.h.h.g.a();
            this.w = this.x;
        } else {
            this.v = new e.i.a.h.h.g.a(str3);
            File file2 = new File(this.x, str3);
            this.y = file2;
            this.w = file2;
        }
        this.f8649b = e.a().f8666c.b(this);
    }

    public String a() {
        return this.v.f8854a;
    }

    public int b() {
        return this.f8649b;
    }

    public File c() {
        return this.x;
    }

    public int compareTo(Object obj) {
        return ((c) obj).f8654g - this.f8654g;
    }

    public File d() {
        return this.w;
    }

    public String e() {
        return this.f8650c;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar.f8649b == this.f8649b) {
            return true;
        }
        return a(cVar);
    }

    public void f() {
        b bVar = e.a().f8664a;
        bVar.f8798h.incrementAndGet();
        bVar.a((e.i.a.h.a) this);
        bVar.f8798h.decrementAndGet();
        bVar.b();
    }

    public File g() {
        String str = this.v.f8854a;
        if (str == null) {
            return null;
        }
        if (this.y == null) {
            this.y = new File(this.x, str);
        }
        return this.y;
    }

    public e.i.a.h.d.c h() {
        if (this.f8653f == null) {
            this.f8653f = e.a().f8666c.get(this.f8649b);
        }
        return this.f8653f;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8650c);
        sb.append(this.w.toString());
        sb.append(this.v.f8854a);
        return sb.toString().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        String str = "@";
        sb.append(str);
        sb.append(this.f8649b);
        sb.append(str);
        sb.append(this.f8650c);
        sb.append(str);
        sb.append(this.x.toString());
        sb.append(BceConfig.BOS_DELIMITER);
        sb.append(this.v.f8854a);
        return sb.toString();
    }

    public Object a(int i2) {
        if (this.r == null) {
            return null;
        }
        return this.r.get(i2);
    }

    public synchronized c a(int i2, Object obj) {
        if (this.r == null) {
            synchronized (this) {
                if (this.r == null) {
                    this.r = new SparseArray<>();
                }
            }
        }
        this.r.put(i2, obj);
        return this;
    }
}
