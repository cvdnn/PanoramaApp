package e.c.d.j;

import android.text.TextUtils;
import com.baidu.picapture.common.bos.beans.UploadTask;
import com.baidu.picapture.db.tables.PanoTaskDao;
import com.baidu.picapture.db.tables.PanoTaskDao.Properties;
import com.baidu.picapture.model.net.panorama.NewPanoTaskReq;
import com.baidu.picapture.model.net.panorama.NewPanoTaskReq.PackagePropertiesBean;
import com.baidu.picapture.model.net.panorama.NewPanoTaskResp;
import com.tencent.connect.common.Constants;
import e.c.b.e.Utils;
import e.c.d.d.a.m;
import e.c.d.d.a.s;
import e.c.d.f.d.d;
import e.g.b.j;
import g.e;
import g.y;
import i.b.b.j.f;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: PanoTaskManager */
public class h1 extends f1 {

    /* renamed from: h reason: collision with root package name */
    public static volatile h1 f6267h;

    /* renamed from: d reason: collision with root package name */
    public Map<String, d> f6268d = new HashMap();

    /* renamed from: e reason: collision with root package name */
    public Map<String, d> f6269e = new HashMap();

    /* renamed from: f reason: collision with root package name */
    public e.c.d.d.f.b<c> f6270f = new e.c.d.d.f.b<>();

    /* renamed from: g reason: collision with root package name */
    public e.c.d.d.f.b<b> f6271g = new e.c.d.d.f.b<>();

    /* compiled from: PanoTaskManager */
    public class a extends e.c.d.l.b.a<NewPanoTaskResp> {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ d f6272a;

        public a(d dVar) {
            this.f6272a = dVar;
        }

        public void a(e eVar, Object obj, int i2) {
            h1.this.f6254a.execute(new g(this, i2, (NewPanoTaskResp) obj, this.f6272a));
        }

        public /* synthetic */ void a(int i2, NewPanoTaskResp newPanoTaskResp, d dVar) {
            if (i2 != 0) {
                h1.a(h1.this, dVar, -1);
            } else if (newPanoTaskResp.getErrorCode() == 0) {
                h1 h1Var = h1.this;
                h1Var.f6268d.remove(dVar.f6081a);
                h1Var.a(dVar, 1000);
                h1Var.f6270f.contains(new Utils(dVar));
            } else {
                h1.a(h1.this, dVar, newPanoTaskResp.getErrorCode());
            }
        }
    }

    /* compiled from: PanoTaskManager */
    public interface b {
        void a(String str, String str2);
    }

    /* compiled from: PanoTaskManager */
    public interface c {
    }

    public static h1 e() {
        if (f6267h == null) {
            synchronized (h1.class) {
                if (f6267h == null) {
                    f6267h = new h1();
                }
            }
        }
        return f6267h;
    }

    /* renamed from: a */
    public final void b(d dVar) {
        String str = dVar.f6081a;
        int i2 = dVar.f6085e;
        if (!TextUtils.isEmpty(str) && !this.f6268d.containsKey(str)) {
            this.f6268d.put(str, dVar);
        }
        if (i2 == 0 || i2 == 5 || i2 == 6 || i2 == 11) {
            if (b()) {
                String g2 = e.c.d.n.e.g(dVar.f6081a);
                String str2 = dVar.f6081a;
                String a2 = s.a().a(new UploadTask(g2, String.format("%s/pano_images/mobile/baidu/%s/%s", new Object[]{"penglai", e.c.d.d.c.e.f6006d.f6009c, e.a.a.a.a.a(str2, ".jpg")}), dVar.f6082b, new g1(this)));
                dVar.f6085e = 5;
                if (!this.f6269e.containsKey(a2)) {
                    dVar.f6082b = a2;
                    this.f6269e.put(a2, dVar);
                }
                e(dVar);
                return;
            }
            a(dVar, 6);
            this.f6270f.contains(new s(dVar));
        } else if (i2 != 7 && i2 != 10) {
        } else {
            if (b()) {
                d(dVar);
                return;
            }
            a(dVar, 10);
            this.f6270f.observable(new n(dVar));
        }
    }

    public void c(d dVar) {
        String str = dVar.f6084d;
        dVar.f6085e = 0;
        dVar.f6083c = e.c.d.d.c.e.f6006d.f6009c;
        e.c.d.f.b.a c2 = e.c.d.f.b.a.c();
        if (c2 != null) {
            dVar.f6086f = new Date();
            c2.a().c(dVar);
            this.f6270f.observable(new r(dVar));
            this.f6254a.execute(new f(this, dVar));
            return;
        }
        throw null;
    }

    public void d() {
        List<d> list;
        e.c.d.f.b.a c2 = e.c.d.f.b.a.c();
        if (c2 != null) {
            String str = e.c.d.d.c.e.f6006d.f6009c;
            if (TextUtils.isEmpty(str)) {
                list = new ArrayList<>();
            } else {
                PanoTaskDao a2 = c2.a();
                if (a2 != null) {
                    f fVar = new f(a2);
                    fVar.a(" DESC", Properties.CreateTime);
                    fVar.a(Properties.Uid.a(str), Properties.Status.b(Integer.valueOf(1000)));
                    list = fVar.a();
                } else {
                    throw null;
                }
            }
            if (list != null && !list.isEmpty()) {
                for (d vVar : list) {
                    this.f6270f.observable(new v(vVar));
                }
                for (d dVar : list) {
                    this.f6270f.observable(new k(dVar));
                    b(dVar);
                }
                return;
            }
            return;
        }
        throw null;
    }

    public /* synthetic */ void b(String str) {
        d dVar = (d) this.f6268d.get(str);
        if (dVar != null) {
            a(dVar, 1001);
            this.f6268d.remove(str);
            Utils.d(e.c.d.n.e.g(str));
            Utils.d(e.c.d.n.e.h(str));
        }
    }

    public final void e(d dVar) {
        e.c.d.f.b.a.c().a().d(dVar);
    }

    public void c() {
        for (Entry value : this.f6268d.entrySet()) {
            d dVar = (d) value.getValue();
            int i2 = dVar.f6085e;
            if (i2 == 6 || i2 == 10) {
                this.f6270f.observable(new l(dVar));
                b(dVar);
            }
        }
    }

    public final void d(d dVar) {
        a(dVar, 9);
        long e2 = Utils.e(e.c.d.n.e.g(dVar.f6081a));
        e.c.d.l.b.b a2 = e.c.d.l.b.b.a();
        String str = dVar.f6087g;
        String str2 = dVar.f6084d;
        a aVar = new a(dVar);
        if (a2 != null) {
            NewPanoTaskReq newPanoTaskReq = new NewPanoTaskReq();
            newPanoTaskReq.setImageUrl(str);
            newPanoTaskReq.setPackageName(str2);
            newPanoTaskReq.setPackageDesc("");
            newPanoTaskReq.setStorageBytes(e2);
            newPanoTaskReq.setPackageProperties(new PackagePropertiesBean());
            y create = y.create(e.c.d.l.b.b.f6372b, new j().a((Object) newPanoTaskReq));
            g.x.a aVar2 = new g.x.a();
            aVar2.a("https://vrstudio.baidu.com/vr/mkt/repos3d/api/v3/package/pano/create");
            aVar2.a(Constants.HTTP_POST, create);
            a2.f6374a.a(aVar2.a()).a(aVar);
            return;
        }
        throw null;
    }

    public final void a(d dVar, int i2) {
        dVar.f6085e = i2;
        if (i2 == 999) {
            this.f6271g.observable(new h(dVar));
        }
        e(dVar);
    }

    public static /* synthetic */ void a(h1 h1Var, d dVar, int i2) {
        h1Var.a(dVar, 10);
        if (i2 == -20) {
            h1Var.f6270f.observable(new q(dVar));
        } else {
            h1Var.f6270f.observable(new t(dVar));
        }
    }

    public /* synthetic */ void a(String str) {
        d dVar = (d) this.f6268d.get(str);
        if (dVar != null) {
            int i2 = dVar.f6085e;
            a(dVar, 998);
            if (i2 == 5) {
                String str2 = dVar.f6082b;
                if (TextUtils.isEmpty(str2)) {
                    a(dVar, 999);
                } else {
                    s a2 = s.a();
                    if (a2 != null) {
                        s.f5986e.execute(new m(a2, str2));
                    } else {
                        throw null;
                    }
                }
            }
            this.f6268d.remove(str);
        }
    }
}
