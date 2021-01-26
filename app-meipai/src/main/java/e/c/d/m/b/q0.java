package e.c.d.m.b;

import android.os.Environment;
import android.text.TextUtils;
import com.arashivision.sdkcamera.camera.InstaCameraManager;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import com.baidu.picapture.hardware.ble.BleHistoryBean;
import com.baidu.picapture.model.spin.SpinTaskInfo;
import com.baidubce.BceConfig;
import e.c.b.e.Utils;
import e.c.d.d.e.ThreadPoolService;
import e.c.d.i.a.b0;
import e.c.d.i.a.w;
import e.c.d.i.a.BleHistoryRecord;
import e.c.d.i.a.y;
import e.c.d.i.c.r;
import e.c.d.j.h1;
import e.c.d.j.j1;
import e.c.d.j.j1.d;
import e.c.d.l.c.h;
import e.c.d.l.c.h.f;
import e.c.d.m.a.c;
import e.c.d.n.e;
import e.g.b.j;
import g.u;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HomePresenter */
public class q0 extends c<p0> implements o0 {

    /* renamed from: b reason: collision with root package name */
    public Map<String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a> f6472b = new HashMap();

    /* renamed from: c reason: collision with root package name */
    public d f6473c = new a();

    /* renamed from: d reason: collision with root package name */
    public h1.c f6474d = new b();

    /* renamed from: e reason: collision with root package name */
    public y f6475e = new m0(this);

    /* renamed from: f reason: collision with root package name */
    public h.c f6476f = new g0(this);

    /* renamed from: g reason: collision with root package name */
    public f f6477g = new j0(this);

    /* compiled from: HomePresenter */
    public class a implements d {
        public a() {
        }

        public void a(SpinTaskInfo spinTaskInfo, float f2) {
            q0.a(q0.this, spinTaskInfo, (int) f2, spinTaskInfo.getTask().f6077f);
        }

        public void b(SpinTaskInfo spinTaskInfo) {
            q0.a(q0.this, spinTaskInfo, 0, 0);
        }

        public void a(SpinTaskInfo spinTaskInfo, int i2) {
            q0.a(q0.this, spinTaskInfo, 0, i2);
        }

        public void a(SpinTaskInfo spinTaskInfo) {
            q0.a(q0.this, spinTaskInfo, 100, spinTaskInfo.getTask().f6077f);
        }
    }

    /* compiled from: HomePresenter */
    public class b implements h1.c {
        public b() {
        }
    }

    public q0(p0 p0Var) {
        super(p0Var);
    }

    public static /* synthetic */ void a(q0 q0Var, e.c.d.f.d.d dVar, int i2) {
        if (q0Var != null) {
            ThreadPoolService.post(new k0(q0Var, dVar, i2, e.h(dVar.f6081a)));
            return;
        }
        throw null;
    }

    public void B() {
        j1 e2 = j1.e();
        if (e2 != null) {
            h.c().a(e2.f6256c);
            j1.e().a(this.f6473c);
            h1 e3 = h1.e();
            if (e3 != null) {
                h.c().a(e3.f6256c);
                h1 e4 = h1.e();
                h1.c cVar = this.f6474d;
                if (e4.f6270f.contains(cVar)) {
                    e4.f6270f.unregisterObserver(cVar);
                }
                h.c().a(this.f6476f);
                h c2 = h.c();
                f fVar = this.f6477g;
                if (c2.f6390e.contains(fVar)) {
                    c2.f6390e.unregisterObserver(fVar);
                }
                b0.impl().unregisterObserver(this.f6475e);
                return;
            }
            throw null;
        }
        throw null;
    }

    public /* synthetic */ void F() {
        V v = this.f6403a;
        if (v != null) {
            ((p0) v).n(App.f1954b.getString(R.string.opening_pano_camera));
        }
    }

    public /* synthetic */ void b(h.d dVar) {
        V v = this.f6403a;
        if (v != null) {
            if (dVar == h.d.CELLULAR) {
                ((p0) v).e("1");
            } else if (dVar == h.d.WIFI) {
                ((p0) v).e("2");
            } else {
                ((p0) v).e("0");
            }
        }
    }

    public /* synthetic */ void c(boolean z) {
        V v = this.f6403a;
        if (v != null) {
            ((p0) v).e(z);
        }
    }

    public void create() {
        ThreadPoolService.fixedThreadPool.execute(a.f6404a);
        e.c.d.l.b.b a2 = e.c.d.l.b.b.a();
        if (a2 != null) {
            g.u.b bVar = new g.u.b();
            bVar.f9575e.add(new e.c.d.l.b.c.b());
            bVar.f9575e.add(new e.c.d.l.b.c.a());
            bVar.a(5, TimeUnit.SECONDS);
            bVar.b(5, TimeUnit.SECONDS);
            bVar.c(5, TimeUnit.SECONDS);
            a2.f6374a = new u(bVar);
            BleHistoryRecord b2 = BleHistoryRecord.impl();
            if (b2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(e.b());
                String str = "/config";
                sb.append(str);
                String sb2 = sb.toString();
                if (e.m(sb2) || e.b(sb2)) {
                    StringBuilder sb3 = new StringBuilder();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(e.b());
                    sb4.append(str);
                    sb3.append(sb4.toString());
                    sb3.append("/ble_history.dat");
                    String sb5 = sb3.toString();
                    b2.f6148b = sb5;
                    if (e.m(sb5)) {
                        b2.bleHistoryBean = (BleHistoryBean) new j().a(Utils.o(b2.f6148b), BleHistoryBean.class);
                    }
                    if (b2.bleHistoryBean == null) {
                        BleHistoryBean bleHistoryBean = new BleHistoryBean();
                        b2.bleHistoryBean = bleHistoryBean;
                        bleHistoryBean.setDevices(new ArrayList());
                    }
                }
                b0.impl().c();
                w.c().b();
                return;
            }
            throw null;
        }
        throw null;
    }

    public void e() {
        super.e();
        j1.e().a(this.f6473c);
        h1 e2 = h1.e();
        h1.c cVar = this.f6474d;
        if (e2.f6270f.contains(cVar)) {
            e2.f6270f.unregisterObserver(cVar);
        }
        b0.impl().unregisterObserver(this.f6475e);
        h.c().a(this.f6476f);
        h c2 = h.c();
        f fVar = this.f6477g;
        if (c2.f6390e.contains(fVar)) {
            c2.f6390e.unregisterObserver(fVar);
        }
    }

    public /* synthetic */ void k(int i2) {
        V v = this.f6403a;
        if (v != null) {
            if (i2 == 3) {
                ((p0) v).h(false);
            } else if (i2 == 2) {
                ((p0) v).h(true);
            }
        }
    }

    public void m() {
        long time = new Date().getTime();
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath());
        sb.append(BceConfig.BOS_DELIMITER);
        sb.append(time);
        sb.append(".jpg");
        ((p0) this.f6403a).j(sb.toString());
    }

    public void p() {
        j1.e().a();
        j1 e2 = j1.e();
        d dVar = this.f6473c;
        if (!e2.f6284g.contains(dVar)) {
            e2.f6284g.registerObserver(dVar);
        }
        h1.e().a();
        h1 e3 = h1.e();
        h1.c cVar = this.f6474d;
        if (!e3.f6270f.contains(cVar)) {
            e3.f6270f.registerObserver(cVar);
        }
        h c2 = h.c();
        h.c cVar2 = this.f6476f;
        if (!c2.f6389d.contains(cVar2)) {
            c2.f6389d.registerObserver(cVar2);
            cVar2.a(c2.f6391f);
        }
        h c3 = h.c();
        f fVar = this.f6477g;
        if (!c3.f6390e.contains(fVar)) {
            c3.f6390e.registerObserver(fVar);
            fVar.a(c3.f6392g);
        }
        b0.impl().registerObserver(this.f6475e);
        if (b0.impl().b()) {
            ((p0) this.f6403a).h(true);
        } else {
            ((p0) this.f6403a).h(false);
        }
        e.c.d.l.b.b a2 = e.c.d.l.b.b.a();
        r0 r0Var = new r0(this);
        if (a2 != null) {
            g.x.a aVar = new g.x.a();
            aVar.a("https://vrstudio.baidu.com/vr/mkt/repos3d/api/v2/public/updating/android/version/latest");
            aVar.b();
            a2.f6374a.a(aVar.a()).a(r0Var);
            return;
        }
        throw null;
    }

    public void t() {
        com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a aVar = (com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a) this.f6472b.remove("hotspotCapture");
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", 2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            aVar.a(jSONObject.toString());
        }
    }

    public void c(String str) {
        String str2 = "taskName";
        String str3 = "taskId";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str3) && !jSONObject.isNull(str3) && jSONObject.has(str2)) {
                if (!jSONObject.isNull(str2)) {
                    String string = jSONObject.getString(str3);
                    String string2 = jSONObject.getString(str2);
                    e.c.d.f.d.d dVar = new e.c.d.f.d.d();
                    dVar.f6081a = string;
                    dVar.f6084d = string2;
                    h1.e().c(dVar);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(e.c.d.f.d.d dVar, int i2, String str) {
        a("pano", dVar.f6084d, dVar.f6081a, 0, i2, str, dVar.f6086f.getTime());
    }

    public /* synthetic */ void b(boolean z) {
        ThreadPoolService.post(new d0(this, z));
    }

    public /* synthetic */ void a(String str, int i2) {
        ThreadPoolService.post(new h0(this, i2));
    }

    public /* synthetic */ void a(h.d dVar) {
        ThreadPoolService.post(new l0(this, dVar));
    }

    public static /* synthetic */ void a(q0 q0Var, SpinTaskInfo spinTaskInfo, int i2, int i3) {
        if (q0Var != null) {
            ThreadPoolService.post(new c0(q0Var, spinTaskInfo, i2, i3));
            return;
        }
        throw null;
    }

    public /* synthetic */ void a(SpinTaskInfo spinTaskInfo, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        a("spin", spinTaskInfo.getTask().f6076e, spinTaskInfo.getTask().f6072a, i4, i5, "", spinTaskInfo.getTask().f6078g.getTime());
    }

    public final void a(String str, String str2, String str3, int i2, int i3, String str4, long j2) {
        String str5;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taskType", str);
            jSONObject.put("taskName", str2);
            jSONObject.put("taskId", str3);
            jSONObject.put("progress", i2);
            jSONObject.put("errorCode", i3);
            if (!TextUtils.isEmpty(str4)) {
                StringBuilder sb = new StringBuilder();
                sb.append("https://penglai.baidu.com/picapture/appfile/pano_thumb/");
                sb.append(str3);
                jSONObject.put("thumbImage", sb.toString());
            }
            jSONObject.put("createTime", j2);
            str5 = jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            str5 = null;
        }
        V v = this.f6403a;
        if (v != null) {
            ((p0) v).l(str5);
        }
    }

    public void a(String str, com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a aVar) {
        String str2 = "taskId";
        String str3 = "param";
        String str4 = "page";
        String str5 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str4)) {
                str5 = jSONObject.getString(str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                if (aVar != null) {
                    this.f6472b.put(str5, aVar);
                }
                if (str5.equalsIgnoreCase("spinCapture")) {
                    if (!b0.impl().e()) {
                        ((p0) this.f6403a).g();
                    } else if (b0.impl().b()) {
                        ((p0) this.f6403a).b();
                    } else {
                        ((p0) this.f6403a).g(6);
                    }
                } else if (str5.equalsIgnoreCase("spinDevice")) {
                    if (b0.impl().e()) {
                        ((p0) this.f6403a).g(5);
                    } else {
                        ((p0) this.f6403a).g();
                    }
                } else if (str5.equalsIgnoreCase("panoCapture")) {
                    ThreadPoolService.post(new f0(this));
                    r.f6218b.a((e.c.d.i.c.r.a<Boolean>) new i0<Boolean>(this));
                } else if (str5.equalsIgnoreCase("wifiSetting")) {
                    ((p0) this.f6403a).l();
                } else if (str5.equalsIgnoreCase("panoPreview") && jSONObject.has(str3)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                    if (jSONObject2.has(str2)) {
                        String string = jSONObject2.getString(str2);
                        if (!TextUtils.isEmpty(string)) {
                            ((p0) this.f6403a).h(string);
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(Boolean bool, int i2) {
        ThreadPoolService.post(new e0(this, i2, bool));
    }

    public /* synthetic */ void a(int i2, Boolean bool) {
        V v = this.f6403a;
        if (v != null) {
            ((p0) v).r();
            if (i2 != 0 || !bool.booleanValue()) {
                ((p0) this.f6403a).L();
            } else if (r.f6218b != null) {
                InstaCameraManager.getInstance().closeCamera();
                ((p0) this.f6403a).h();
            } else {
                throw null;
            }
        }
    }
}
