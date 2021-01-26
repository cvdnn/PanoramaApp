package e.c.f;

import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONObject;

/* compiled from: MyFileObserver */
public class g extends FileObserver {

    /* renamed from: a reason: collision with root package name */
    public String f6992a;

    /* renamed from: b reason: collision with root package name */
    public String f6993b;

    /* renamed from: c reason: collision with root package name */
    public int f6994c;

    /* renamed from: d reason: collision with root package name */
    public Context f6995d;

    /* compiled from: MyFileObserver */
    public class a extends Thread {
        public a() {
        }

        public final void run() {
            try {
                super.run();
                c.a();
                synchronized (g.class) {
                    if (!e.c.f.n.a.c(g.this.f6992a)) {
                        String str = g.this.f6993b;
                        String str2 = g.this.f6992a;
                        if (!TextUtils.isEmpty(str)) {
                            if (!TextUtils.isEmpty(str2)) {
                                e.c.f.n.a.a(new File(str), new File(str2));
                            }
                        }
                        e.c.f.n.a.a(g.this.f6992a, true);
                        e.a(new File(g.this.f6992a));
                        e.a(g.this.f6995d, g.this.f6994c, new File(g.this.f6992a), new File(g.this.f6993b));
                        new StringBuilder().append(g.this.f6992a.toString());
                        e.c.f.d.a.a(g.this.f6995d).b(g.this.f6994c, -1);
                    }
                }
            } catch (Throwable unused) {
                c.d();
            }
        }
    }

    /* compiled from: ReportConfigInfo */
    public final class b {

        /* renamed from: a reason: collision with root package name */
        public String f6997a;

        /* renamed from: b reason: collision with root package name */
        public String f6998b;

        /* renamed from: c reason: collision with root package name */
        public String f6999c;

        /* renamed from: d reason: collision with root package name */
        public String f7000d;

        /* renamed from: e reason: collision with root package name */
        public String f7001e;

        public static String a(b bVar) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("0", bVar.f6997a);
                jSONObject.put("1", bVar.f6999c);
                jSONObject.put("2", bVar.f7000d);
                jSONObject.put("3", bVar.f7001e);
                jSONObject.put("4", bVar.f6998b);
            } catch (Throwable unused) {
                c.d();
            }
            return jSONObject.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            String str = this.f7000d;
            if (str == null) {
                if (bVar.f7000d != null) {
                    return false;
                }
            } else if (!str.equals(bVar.f7000d)) {
                return false;
            }
            String str2 = this.f7001e;
            if (str2 == null) {
                if (bVar.f7001e != null) {
                    return false;
                }
            } else if (!str2.equals(bVar.f7001e)) {
                return false;
            }
            String str3 = this.f6998b;
            if (str3 == null) {
                if (bVar.f6998b != null) {
                    return false;
                }
            } else if (!str3.equals(bVar.f6998b)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f7000d;
            int i2 = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f7001e;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f6998b;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            return hashCode2 + i2;
        }
    }

    public g(Context context, int i2, String str, String str2) {
        super(str, 4095);
        try {
            this.f6992a = str;
            this.f6993b = str2;
            this.f6994c = i2;
            this.f6995d = context;
            StringBuilder sb = new StringBuilder("f=");
            sb.append(this.f6992a);
            sb.append(", e=");
            sb.append(new File(this.f6992a).exists());
            sb.append(", b=");
            sb.append(this.f6993b);
            c.a();
        } catch (Throwable unused) {
            c.d();
        }
    }

    public void onEvent(int i2, String str) {
        if (i2 == 2 || i2 == 4 || i2 == 64 || i2 == 128 || i2 == 512 || i2 == 1024 || i2 == 2048) {
            try {
                new a().start();
            } catch (Throwable unused) {
                c.d();
            }
        }
    }
}
