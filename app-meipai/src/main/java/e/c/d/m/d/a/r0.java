package e.c.d.m.d.a;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.arashivision.sdkcamera.camera.InstaCameraManager;
import com.arashivision.sdkcamera.camera.callback.ICameraChangedCallback;
import com.arashivision.sdkcamera.camera.callback.IPreviewStatusListener;
import com.arashivision.sdkmedia.export.ExportImageParamsBuilder;
import com.arashivision.sdkmedia.export.ExportUtils;
import com.arashivision.sdkmedia.export.ExportUtils.ExportMode;
import com.arashivision.sdkmedia.work.WorkWrapper;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import com.baidu.picapture.hardware.panorama.beans.OSCOptions;
import com.baidu.picapture.hardware.panorama.beans.OSCState;
import com.baidu.picapture.model.device.LanguageUtils;
import e.b.d.a.j.d;
import e.c.b.e.Utils;
import e.c.d.d.e.ThreadPoolService;
import e.c.d.i.c.e;
import e.c.d.i.c.g;
import e.c.d.i.c.h;
import e.c.d.i.c.m;
import e.c.d.i.c.n;
import e.c.d.i.c.p;
import e.c.d.i.c.q;
import e.c.d.i.c.r;
import e.c.d.m.a.c;
import g.u;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PanoramaCapturePresenter */
public class r0 extends c<q0> implements p0 {

    /* renamed from: b reason: collision with root package name */
    public OSCOptions f6560b;

    /* renamed from: c reason: collision with root package name */
    public int f6561c = 0;

    /* renamed from: d reason: collision with root package name */
    public int f6562d = 0;

    /* renamed from: e reason: collision with root package name */
    public ScheduledFuture<?> f6563e;

    /* renamed from: f reason: collision with root package name */
    public ScheduledFuture<?> f6564f;

    /* renamed from: g reason: collision with root package name */
    public String f6565g;

    /* renamed from: h reason: collision with root package name */
    public boolean f6566h = false;

    /* renamed from: i reason: collision with root package name */
    public List<e.c.d.m.d.a.t0.j.a> f6567i = new ArrayList();

    /* renamed from: j reason: collision with root package name */
    public List<e.c.d.m.d.a.t0.g.a> f6568j = new ArrayList();
    public List<e.c.d.m.d.a.t0.h.a> k = new ArrayList();
    public List<e.c.d.m.d.a.t0.l.a> l = new ArrayList();
    public List<e.c.d.m.d.a.t0.i.a> m = new ArrayList();
    public List<e.c.d.m.d.a.t0.k.a> n = new ArrayList();
    public WorkWrapper o;
    public IPreviewStatusListener p = new a();
    public ICameraChangedCallback q = new b();

    /* compiled from: PanoramaCapturePresenter */
    public class a implements IPreviewStatusListener {
        public a() {
        }

        public void onError() {
            r0 r0Var = r0.this;
            if (r0Var != null) {
                ThreadPoolService.post(new a0(r0Var));
                return;
            }
            throw null;
        }

        public /* synthetic */ void onIdle() {
            d.$default$onIdle(this);
        }

        public void onOpened() {
            r0 r0Var = r0.this;
            if (r0Var == null) {
                throw null;
            } else if (r.f6218b != null) {
                InstaCameraManager.getInstance().setStreamEncode();
                r rVar = r.f6218b;
                y yVar = new y(r0Var);
                if (rVar != null) {
                    n nVar = n.f6212c;
                    yVar.getClass();
                    e.c.d.i.c.b bVar = new e.c.d.i.c.b(yVar);
                    if (nVar != null) {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put("captureMode");
                        jSONArray.put("captureModeSupport");
                        jSONArray.put("exposureProgram");
                        jSONArray.put("exposureProgramSupport");
                        jSONArray.put("iso");
                        jSONArray.put("isoSupport");
                        jSONArray.put("shutterSpeed");
                        jSONArray.put("shutterSpeedSupport");
                        jSONArray.put("aperture");
                        jSONArray.put("apertureSupport");
                        jSONArray.put("whiteBalance");
                        jSONArray.put("whiteBalanceSupport");
                        jSONArray.put("hdr");
                        jSONArray.put("hdrSupport");
                        jSONArray.put("exposureCompensation");
                        jSONArray.put("exposureCompensationSupport");
                        jSONArray.put("totalSpace");
                        jSONArray.put("remainingSpace");
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("optionNames", jSONArray);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", "camera.getOptions");
                            jSONObject2.put("parameters", jSONObject);
                            String jSONObject3 = jSONObject2.toString();
                            nVar.f6213a.execute(new g(nVar, "/osc/commands/execute", jSONObject3, new e.c.d.i.c.d(bVar)));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            bVar.a(null, -2);
                        }
                    } else {
                        throw null;
                    }
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        }

        public /* synthetic */ void onOpening() {
            d.$default$onOpening(this);
        }
    }

    /* compiled from: PanoramaCapturePresenter */
    public class b implements ICameraChangedCallback {
        public b() {
        }

        public /* synthetic */ void a(boolean z) {
            V v = r0.this.f6403a;
            if (v != null && !z) {
                ((q0) v).u();
            }
        }

        public /* synthetic */ void onCameraBatteryLow() {
            e.b.d.a.j.a.$default$onCameraBatteryLow(this);
        }

        public /* synthetic */ void onCameraBatteryUpdate(int i2, boolean z) {
            e.b.d.a.j.a.$default$onCameraBatteryUpdate(this, i2, z);
        }

        public void onCameraConnectError() {
            r0 r0Var = r0.this;
            ScheduledFuture<?> scheduledFuture = r0Var.f6563e;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                r0Var.f6563e = null;
            }
            ThreadPoolService.post(new a0(r0Var));
        }

        public void onCameraSDCardStateChanged(boolean z) {
            ThreadPoolService.post(new m(this, z));
        }

        public void onCameraStatusChanged(boolean z) {
            if (z) {
                r0 r0Var = r0.this;
                r0Var.S();
                if (r0Var.f6563e == null) {
                    r0Var.f6563e = ThreadPoolService.scheduleAtFixedRate(new f0(r0Var), 0, 5, TimeUnit.SECONDS);
                    return;
                }
                return;
            }
            r0 r0Var2 = r0.this;
            ScheduledFuture<?> scheduledFuture = r0Var2.f6563e;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                r0Var2.f6563e = null;
            }
            ThreadPoolService.post(new a0(r0Var2));
        }

        public /* synthetic */ void onCameraStorageChanged(long j2, long j3) {
            e.b.d.a.j.a.$default$onCameraStorageChanged(this, j2, j3);
        }
    }

    public r0(q0 q0Var) {
        super(q0Var);
    }

    public void A() {
        r.f6218b.b(new w(this));
    }

    public final void F() {
        ThreadPoolService.post(new c0(this));
    }

    public final boolean G() {
        return this.f6560b.getHdr().equalsIgnoreCase("hdr");
    }

    public /* synthetic */ void H() {
        V v = this.f6403a;
        if (v != null) {
            ((q0) v).F();
        }
    }

    public /* synthetic */ void I() {
        this.f6562d++;
        ThreadPoolService.post(new h0(this));
        if (this.f6562d + 1 >= this.f6561c) {
            ThreadPoolService.post(new j0(this));
            R();
            this.f6564f.cancel(false);
            this.f6564f = null;
        }
    }

    public /* synthetic */ void J() {
        V v = this.f6403a;
        if (v != null) {
            ((q0) v).k();
        }
    }

    public /* synthetic */ void K() {
        V v = this.f6403a;
        if (v != null) {
            ((q0) v).s();
        }
    }

    public /* synthetic */ void L() {
        if (this.f6403a != null) {
            f(this.f6560b.getWhiteBalance());
        }
    }

    public /* synthetic */ void M() {
        if (this.f6403a != null) {
            m(this.f6560b.getExposureProgram());
        }
    }

    public /* synthetic */ void N() {
        if (this.f6403a != null) {
            n(this.f6560b.getIso());
        }
    }

    public /* synthetic */ void O() {
        if (this.f6403a != null) {
            U();
        }
    }

    public /* synthetic */ void P() {
        V v = this.f6403a;
        if (v != null) {
            ((q0) v).h(this.f6561c - this.f6562d);
        }
    }

    public /* synthetic */ void Q() {
        r rVar = r.f6218b;
        p pVar = new p(this);
        if (rVar != null) {
            n nVar = n.f6212c;
            pVar.getClass();
            m mVar = new m(pVar);
            if (nVar != null) {
                nVar.f6213a.execute(new g(nVar, "/osc/state", "", new e(mVar)));
                return;
            }
            throw null;
        }
        throw null;
    }

    public final void R() {
        HashMap hashMap = new HashMap();
        hashMap.put("exposureProgram", Integer.valueOf(this.f6560b.getExposureProgram()));
        r rVar = r.f6218b;
        boolean G = G();
        i0 i0Var = new i0(this);
        if (rVar != null) {
            n nVar = n.f6212c;
            i0Var.getClass();
            nVar.f6213a.execute(new h(nVar, hashMap, new e.c.d.i.c.a(i0Var), G));
            return;
        }
        throw null;
    }

    public final void S() {
        r rVar = r.f6218b;
        IPreviewStatusListener iPreviewStatusListener = this.p;
        if (rVar != null) {
            InstaCameraManager.getInstance().setPreviewStatusChangedListener(iPreviewStatusListener);
            if (r.f6218b != null) {
                InstaCameraManager.getInstance().startPreviewStream();
                ((q0) this.f6403a).c(false);
                return;
            }
            throw null;
        }
        throw null;
    }

    public void T() {
        if (r.f6218b != null) {
            InstaCameraManager.getInstance().setPreviewStatusChangedListener(null);
            if (r.f6218b != null) {
                InstaCameraManager.getInstance().closePreviewStream();
                ((q0) this.f6403a).c(false);
                return;
            }
            throw null;
        }
        throw null;
    }

    public final void U() {
        this.n.clear();
        List<Float> shutterSpeedSupport = this.f6560b.getShutterSpeedSupport();
        Collections.sort(shutterSpeedSupport, b.f6514a);
        for (Float f2 : shutterSpeedSupport) {
            if (f2.floatValue() != 0.0f) {
                if (f2.floatValue() == this.f6560b.getShutterSpeed()) {
                    this.n.add(new e.c.d.m.d.a.t0.k.a(f2.floatValue(), true));
                } else {
                    this.n.add(new e.c.d.m.d.a.t0.k.a(f2.floatValue(), false));
                }
            }
        }
        ((q0) this.f6403a).R();
    }

    public void a(Object obj) {
        if (r.f6218b != null) {
            InstaCameraManager.getInstance().setPipeline(obj);
            return;
        }
        throw null;
    }

    public final void b(boolean z) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.k.size()) {
                break;
            } else if (((e.c.d.m.d.a.t0.h.a) this.k.get(i2)).f6595a != 1) {
                i2++;
            } else if (z) {
                if (((e.c.d.m.d.a.t0.h.a) this.k.get(i2)).f6596b) {
                    ((e.c.d.m.d.a.t0.h.a) this.k.get(i2)).f6596b = false;
                }
                c(2, false);
                ((e.c.d.m.d.a.t0.h.a) this.k.get(i2)).f6597c = false;
                a(e.c.d.m.d.a.t0.j.b.EXPOSURE_PROGRAM, k(2));
            } else {
                ((e.c.d.m.d.a.t0.h.a) this.k.get(i2)).f6597c = true;
            }
        }
        ((q0) this.f6403a).w();
    }

    public /* synthetic */ void c(String str, String str2, int i2) {
        a(i2, str);
    }

    public void create() {
        this.f6567i.add(new e.c.d.m.d.a.t0.j.a(e.c.d.m.d.a.t0.j.b.HDR, "hdr", true));
        this.f6567i.add(new e.c.d.m.d.a.t0.j.a(e.c.d.m.d.a.t0.j.b.DELAY_CAPTURE, App.f1954b.getString(R.string.close), true));
        this.f6567i.add(new e.c.d.m.d.a.t0.j.a(e.c.d.m.d.a.t0.j.b.EXPOSURE_PROGRAM, App.f1954b.getString(R.string.auto), true));
        this.f6567i.add(new e.c.d.m.d.a.t0.j.a(e.c.d.m.d.a.t0.j.b.EXPOSURE_VALUE, "0", true));
        this.f6567i.add(new e.c.d.m.d.a.t0.j.a(e.c.d.m.d.a.t0.j.b.WHITE_BALANCE, App.f1954b.getString(R.string.auto), true));
        this.f6567i.add(new e.c.d.m.d.a.t0.j.a(e.c.d.m.d.a.t0.j.b.ISO, "", true));
        this.f6567i.add(new e.c.d.m.d.a.t0.j.a(e.c.d.m.d.a.t0.j.b.SHUTTER_SPEED, "0.0", true));
        ((q0) this.f6403a).d(this.f6567i);
        this.f6568j.add(new e.c.d.m.d.a.t0.g.a(App.f1954b.getString(R.string.close), 0, true));
        this.f6568j.add(new e.c.d.m.d.a.t0.g.a("3S", 3, false));
        this.f6568j.add(new e.c.d.m.d.a.t0.g.a("5S", 5, false));
        this.f6568j.add(new e.c.d.m.d.a.t0.g.a("10S", 10, false));
        ((q0) this.f6403a).g(this.f6568j);
        this.k.add(new e.c.d.m.d.a.t0.h.a(2, true));
        this.k.add(new e.c.d.m.d.a.t0.h.a(9, false));
        this.k.add(new e.c.d.m.d.a.t0.h.a(4, false));
        this.k.add(new e.c.d.m.d.a.t0.h.a(1, false));
        ((q0) this.f6403a).a(this.k);
        this.l.add(new e.c.d.m.d.a.t0.l.a(LanguageUtils.AUTO, true));
        this.l.add(new e.c.d.m.d.a.t0.l.a("cloudy-daylight", false));
        this.l.add(new e.c.d.m.d.a.t0.l.a("datalight", false));
        this.l.add(new e.c.d.m.d.a.t0.l.a("fluorescent", false));
        this.l.add(new e.c.d.m.d.a.t0.l.a("incandescent", false));
        ((q0) this.f6403a).e(this.l);
        ((q0) this.f6403a).c(this.m);
        ((q0) this.f6403a).f(this.n);
    }

    public void d() {
        ScheduledFuture<?> scheduledFuture = this.f6564f;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f6564f = null;
        }
        ScheduledFuture<?> scheduledFuture2 = this.f6563e;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
            this.f6563e = null;
        }
        r rVar = r.f6218b;
        ICameraChangedCallback iCameraChangedCallback = this.q;
        if (rVar != null) {
            InstaCameraManager.getInstance().unregisterCameraChangedCallback(iCameraChangedCallback);
            T();
            if (r.f6218b != null) {
                InstaCameraManager.getInstance().closeCamera();
                return;
            }
            throw null;
        }
        throw null;
    }

    public void e() {
        super.e();
        System.exit(0);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.util.List<e.c.d.m.d.a.t0.l$a> r2 = r7.l
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x00b5
            java.util.List<e.c.d.m.d.a.t0.l$a> r2 = r7.l
            java.lang.Object r2 = r2.get(r1)
            e.c.d.m.d.a.t0.l$a r2 = (e.c.d.m.d.a.t0.l.a) r2
            java.lang.String r2 = r2.f6625a
            boolean r2 = r2.equalsIgnoreCase(r8)
            if (r2 == 0) goto L_0x00a7
            java.util.List<e.c.d.m.d.a.t0.l$a> r2 = r7.l
            java.lang.Object r2 = r2.get(r1)
            e.c.d.m.d.a.t0.l$a r2 = (e.c.d.m.d.a.t0.l.a) r2
            r3 = 1
            r2.f6626b = r3
            int r2 = r8.hashCode()
            r4 = 4
            r5 = 3
            r6 = 2
            switch(r2) {
                case -939299377: goto L_0x0058;
                case -351699028: goto L_0x004e;
                case 3005871: goto L_0x0044;
                case 474934723: goto L_0x003a;
                case 1902580840: goto L_0x0030;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x0062
        L_0x0030:
            java.lang.String r2 = "fluorescent"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0062
            r2 = r4
            goto L_0x0063
        L_0x003a:
            java.lang.String r2 = "cloudy-daylight"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0062
            r2 = r5
            goto L_0x0063
        L_0x0044:
            java.lang.String r2 = "auto"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0062
            r2 = r0
            goto L_0x0063
        L_0x004e:
            java.lang.String r2 = "datalight"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0062
            r2 = r6
            goto L_0x0063
        L_0x0058:
            java.lang.String r2 = "incandescent"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0062
            r2 = r3
            goto L_0x0063
        L_0x0062:
            r2 = -1
        L_0x0063:
            if (r2 == 0) goto L_0x0098
            if (r2 == r3) goto L_0x008e
            if (r2 == r6) goto L_0x0084
            if (r2 == r5) goto L_0x007a
            if (r2 == r4) goto L_0x0070
            java.lang.String r2 = ""
            goto L_0x00a1
        L_0x0070:
            com.baidu.picapture.App r2 = com.baidu.picapture.App.f1954b
            r3 = 2131755102(0x7f10005e, float:1.9141074E38)
            java.lang.String r2 = r2.getString(r3)
            goto L_0x00a1
        L_0x007a:
            com.baidu.picapture.App r2 = com.baidu.picapture.App.f1954b
            r3 = 2131755071(0x7f10003f, float:1.914101E38)
            java.lang.String r2 = r2.getString(r3)
            goto L_0x00a1
        L_0x0084:
            com.baidu.picapture.App r2 = com.baidu.picapture.App.f1954b
            r3 = 2131755080(0x7f100048, float:1.914103E38)
            java.lang.String r2 = r2.getString(r3)
            goto L_0x00a1
        L_0x008e:
            com.baidu.picapture.App r2 = com.baidu.picapture.App.f1954b
            r3 = 2131755113(0x7f100069, float:1.9141096E38)
            java.lang.String r2 = r2.getString(r3)
            goto L_0x00a1
        L_0x0098:
            com.baidu.picapture.App r2 = com.baidu.picapture.App.f1954b
            r3 = 2131755049(0x7f100029, float:1.9140966E38)
            java.lang.String r2 = r2.getString(r3)
        L_0x00a1:
            e.c.d.m.d.a.t0.j$b r3 = e.c.d.m.d.a.t0.j.b.WHITE_BALANCE
            r7.a(r3, r2)
            goto L_0x00b1
        L_0x00a7:
            java.util.List<e.c.d.m.d.a.t0.l$a> r2 = r7.l
            java.lang.Object r2 = r2.get(r1)
            e.c.d.m.d.a.t0.l$a r2 = (e.c.d.m.d.a.t0.l.a) r2
            r2.f6626b = r0
        L_0x00b1:
            int r1 = r1 + 1
            goto L_0x0002
        L_0x00b5:
            V r8 = r7.f6403a
            e.c.d.m.d.a.q0 r8 = (e.c.d.m.d.a.q0) r8
            r8.O()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.m.d.a.r0.f(java.lang.String):void");
    }

    public void g(int i2) {
        for (int i3 = 0; i3 < this.f6568j.size(); i3++) {
            if (i3 != i2) {
                ((e.c.d.m.d.a.t0.g.a) this.f6568j.get(i3)).f6591c = false;
            } else if (!((e.c.d.m.d.a.t0.g.a) this.f6568j.get(i3)).f6591c) {
                ((e.c.d.m.d.a.t0.g.a) this.f6568j.get(i3)).f6591c = true;
                this.f6561c = ((e.c.d.m.d.a.t0.g.a) this.f6568j.get(i3)).f6590b;
                String string = App.f1954b.getString(R.string.close);
                if (this.f6561c > 0) {
                    string = e.a.a.a.a.a(new StringBuilder(), this.f6561c, "S");
                }
                a(e.c.d.m.d.a.t0.j.b.DELAY_CAPTURE, string);
            }
        }
        ((q0) this.f6403a).K();
    }

    public void h(int i2) {
        c(((e.c.d.m.d.a.t0.h.a) this.k.get(i2)).f6595a, false);
    }

    public void i(int i2) {
        e.c.d.m.d.a.t0.j.a aVar = (e.c.d.m.d.a.t0.j.a) this.f6567i.get(i2);
        switch (aVar.f6606a.ordinal()) {
            case 0:
                String str = "hdr";
                if (aVar.f6607b.equalsIgnoreCase(str)) {
                    aVar.f6607b = "off";
                    a(false, false);
                } else {
                    aVar.f6607b = str;
                    a(true, false);
                }
                ((q0) this.f6403a).j(i2);
                return;
            case 1:
                ((q0) this.f6403a).Z();
                return;
            case 2:
                ((q0) this.f6403a).B();
                return;
            case 3:
                ((q0) this.f6403a).A();
                return;
            case 4:
                ((q0) this.f6403a).y();
                return;
            case 5:
                ((q0) this.f6403a).Q();
                return;
            case 6:
                ((q0) this.f6403a).o();
                return;
            default:
                return;
        }
    }

    public void j(int i2) {
        a(((e.c.d.m.d.a.t0.l.a) this.l.get(i2)).f6625a, false);
    }

    public final String k(int i2) {
        if (2 == i2) {
            return App.f1954b.getString(R.string.auto);
        }
        if (9 == i2) {
            return App.f1954b.getString(R.string.iso_priority);
        }
        if (4 == i2) {
            return App.f1954b.getString(R.string.shutter_priority);
        }
        return 1 == i2 ? App.f1954b.getString(R.string.manual) : "";
    }

    public void l() {
        ((q0) this.f6403a).c(false);
        r.f6218b.a(this.q);
        r.f6218b.a();
    }

    public final void m(int i2) {
        boolean z;
        int i3 = 0;
        while (true) {
            z = true;
            if (i3 >= this.k.size()) {
                break;
            }
            if (((e.c.d.m.d.a.t0.h.a) this.k.get(i3)).f6595a == i2) {
                ((e.c.d.m.d.a.t0.h.a) this.k.get(i3)).f6596b = true;
                a(e.c.d.m.d.a.t0.j.b.EXPOSURE_PROGRAM, k(i2));
            } else {
                ((e.c.d.m.d.a.t0.h.a) this.k.get(i3)).f6596b = false;
            }
            i3++;
        }
        ((q0) this.f6403a).w();
        if (i2 != 1) {
            z = false;
        }
        for (int i4 = 0; i4 < this.f6567i.size(); i4++) {
            if (((e.c.d.m.d.a.t0.j.a) this.f6567i.get(i4)).f6606a == e.c.d.m.d.a.t0.j.b.EXPOSURE_VALUE) {
                ((e.c.d.m.d.a.t0.j.a) this.f6567i.get(i4)).f6608c = !z;
                if (z) {
                    ((q0) this.f6403a).a(0);
                }
            }
            if (((e.c.d.m.d.a.t0.j.a) this.f6567i.get(i4)).f6606a == e.c.d.m.d.a.t0.j.b.ISO) {
                ((e.c.d.m.d.a.t0.j.a) this.f6567i.get(i4)).f6608c = z;
            }
            if (((e.c.d.m.d.a.t0.j.a) this.f6567i.get(i4)).f6606a == e.c.d.m.d.a.t0.j.b.SHUTTER_SPEED) {
                ((e.c.d.m.d.a.t0.j.a) this.f6567i.get(i4)).f6608c = z;
            }
        }
        ((q0) this.f6403a).x();
    }

    public final void n(int i2) {
        for (int i3 = 0; i3 < this.m.size(); i3++) {
            if (((e.c.d.m.d.a.t0.i.a) this.m.get(i3)).f6601a == i2) {
                ((e.c.d.m.d.a.t0.i.a) this.m.get(i3)).f6602b = true;
                a(e.c.d.m.d.a.t0.j.b.ISO, String.valueOf(i2));
            } else {
                ((e.c.d.m.d.a.t0.i.a) this.m.get(i3)).f6602b = false;
            }
        }
        ((q0) this.f6403a).U();
    }

    public final void c(int i2, boolean z) {
        if (this.f6560b.getExposureProgram() != i2 || z) {
            m(i2);
            r rVar = r.f6218b;
            l lVar = new l(this, i2, z);
            if (rVar != null) {
                InstaCameraManager instance = InstaCameraManager.getInstance();
                int i3 = 2;
                if (i2 == 2) {
                    i3 = 0;
                } else if (i2 == 9) {
                    i3 = 1;
                } else if (i2 != 4) {
                    i3 = i2 == 1 ? 3 : -1;
                }
                instance.setExposureMode(7, i3);
                lVar.a("", 0);
                return;
            }
            throw null;
        }
    }

    public /* synthetic */ void a(List list, int i2) {
        if (i2 == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(e.c.d.n.e.c());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                e.c.d.n.e.b((String) it.next());
            }
            String[] strArr = (String[]) list.toArray(new String[0]);
            this.f6565g = Utils.k();
            if (strArr.length > 1) {
                e.c.d.l.a.b a2 = e.c.d.l.a.b.a();
                List asList = Arrays.asList(strArr);
                String c2 = e.c.d.n.e.c();
                s0 s0Var = new s0(this);
                if (a2 != null) {
                    Arrays.toString(asList.toArray(new String[0]));
                    if (a2.f6371a == null) {
                        a2.f6371a = new u(new g.u.b(new u()));
                    }
                    ThreadPoolService.cachedThreadPool.execute(new e.c.d.l.a.a(a2, asList, c2, s0Var));
                    return;
                }
                throw null;
            }
            this.o = new WorkWrapper(strArr);
            String g2 = e.c.d.n.e.g(this.f6565g);
            r rVar = r.f6218b;
            WorkWrapper workWrapper = this.o;
            x xVar = new x(this, g2);
            if (rVar != null) {
                ExportUtils.exportImage(workWrapper, new ExportImageParamsBuilder().setExportMode(ExportMode.PANORAMA).setCameraType(InstaCameraManager.getInstance().getCameraType()).setTargetPath(g2), new p(rVar, xVar));
                return;
            }
            throw null;
        }
        F();
    }

    public /* synthetic */ void e(String str) {
        V v = this.f6403a;
        if (v != null) {
            ((q0) v).c(this.f6565g, str);
        }
    }

    public void e(int i2) {
        d(((e.c.d.m.d.a.t0.i.a) this.m.get(i2)).f6601a, false);
    }

    public /* synthetic */ void l(int i2) {
        V v = this.f6403a;
        if (v != null) {
            ((q0) v).a(i2);
        }
    }

    public void k() {
        T();
        S();
    }

    public /* synthetic */ void d(String str, String str2, int i2) {
        if (i2 == 0) {
            this.f6560b.setWhiteBalance(str);
        } else {
            ThreadPoolService.post(new z(this));
        }
    }

    public /* synthetic */ void b(List list, int i2) {
        if (i2 == 0 && list != null && list.size() == 2) {
            ThreadPoolService.post(new o(this, list));
        } else {
            F();
        }
    }

    public final void d(int i2, boolean z) {
        if (this.f6560b.getIso() != i2 || z) {
            n(i2);
            r rVar = r.f6218b;
            u uVar = new u(this, i2);
            if (rVar != null) {
                InstaCameraManager.getInstance().setISO(7, i2);
                uVar.a("", 0);
                return;
            }
            throw null;
        }
    }

    public /* synthetic */ void b(String str, String str2, int i2) {
        a(i2, str);
    }

    public final void b(int i2, boolean z) {
        if (this.f6560b.getExposureCompensation() != i2 || z) {
            a(e.c.d.m.d.a.t0.j.b.EXPOSURE_VALUE, String.valueOf(i2));
            r rVar = r.f6218b;
            b0 b0Var = new b0(this, i2);
            if (rVar != null) {
                n nVar = n.f6212c;
                b0Var.getClass();
                e.c.d.i.c.c cVar = new e.c.d.i.c.c(b0Var);
                if (nVar != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exposureCompensation", i2);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("options", jSONObject);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("name", "camera.setOptions");
                        jSONObject3.put("parameters", jSONObject2);
                        nVar.f6213a.execute(new g(nVar, "/osc/commands/execute", jSONObject3.toString(), cVar));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        cVar.a(null, -2);
                    }
                    return;
                }
                throw null;
            }
            throw null;
        }
    }

    public final void a(e.c.d.m.d.a.t0.j.b bVar, String str) {
        for (int i2 = 0; i2 < this.f6567i.size(); i2++) {
            if (((e.c.d.m.d.a.t0.j.a) this.f6567i.get(i2)).f6606a == bVar) {
                ((e.c.d.m.d.a.t0.j.a) this.f6567i.get(i2)).f6607b = str;
                ((q0) this.f6403a).j(i2);
                return;
            }
        }
    }

    public /* synthetic */ void a(OSCState oSCState, int i2) {
        if (i2 == 0) {
            ThreadPoolService.post(new l0(this, oSCState));
        }
    }

    public /* synthetic */ void a(OSCState oSCState) {
        if (this.f6403a != null && oSCState != null && oSCState.getState() != null) {
            int batteryLevel = (int) (oSCState.getState().getBatteryLevel() * 100.0f);
            ((q0) this.f6403a).c(batteryLevel);
            if (batteryLevel > 20) {
                this.f6566h = false;
            } else if (!this.f6566h) {
                ((q0) this.f6403a).d(batteryLevel);
                this.f6566h = true;
            }
        }
    }

    public /* synthetic */ void b(int i2, String str, int i3) {
        if (i3 == 0) {
            this.f6560b.setIso(i2);
        } else {
            ThreadPoolService.post(new g0(this));
        }
    }

    public void b(int i2) {
        a(((e.c.d.m.d.a.t0.k.a) this.n.get(i2)).f6620a, false);
    }

    public /* synthetic */ void a(OSCOptions oSCOptions, int i2) {
        ThreadPoolService.post(new r(this, i2, oSCOptions));
    }

    public /* synthetic */ void a(int i2, OSCOptions oSCOptions) {
        V v = this.f6403a;
        if (v != null) {
            if (i2 == 0) {
                OSCOptions oSCOptions2 = this.f6560b;
                if (oSCOptions2 == null) {
                    this.f6560b = oSCOptions;
                    ((e.c.d.m.d.a.t0.j.a) this.f6567i.get(0)).f6607b = oSCOptions.getHdr();
                    ((q0) this.f6403a).j(0);
                    int exposureCompensation = this.f6560b.getExposureCompensation();
                    ((q0) this.f6403a).a(exposureCompensation);
                    a(e.c.d.m.d.a.t0.j.b.EXPOSURE_VALUE, String.valueOf(exposureCompensation));
                    f(this.f6560b.getWhiteBalance());
                    m(this.f6560b.getExposureProgram());
                    this.m.clear();
                    for (Integer num : this.f6560b.getIsoSupport()) {
                        if (num.intValue() != 0) {
                            if (num.intValue() == this.f6560b.getIso()) {
                                this.m.add(new e.c.d.m.d.a.t0.i.a(num.intValue(), true));
                                a(e.c.d.m.d.a.t0.j.b.ISO, String.valueOf(num));
                            } else {
                                this.m.add(new e.c.d.m.d.a.t0.i.a(num.intValue(), false));
                            }
                        }
                    }
                    ((q0) this.f6403a).U();
                    U();
                    b(G());
                } else {
                    if (!oSCOptions2.getHdr().equalsIgnoreCase(oSCOptions.getHdr())) {
                        a(G(), true);
                    }
                    if (this.f6560b.getExposureCompensation() != oSCOptions.getExposureCompensation()) {
                        b(this.f6560b.getExposureCompensation(), true);
                    }
                    if (!this.f6560b.getWhiteBalance().equalsIgnoreCase(oSCOptions.getWhiteBalance())) {
                        a(this.f6560b.getWhiteBalance(), true);
                    }
                    if (this.f6560b.getExposureProgram() != oSCOptions.getExposureProgram()) {
                        c(this.f6560b.getExposureProgram(), true);
                    }
                    if (this.f6560b.getExposureProgram() == 1) {
                        if (this.f6560b.getIso() != oSCOptions.getIso()) {
                            d(this.f6560b.getIso(), true);
                        }
                        if (this.f6560b.getShutterSpeed() != oSCOptions.getShutterSpeed()) {
                            a(this.f6560b.getShutterSpeed(), true);
                        }
                    }
                }
                ((q0) this.f6403a).n();
            } else {
                ((q0) v).F();
            }
        }
    }

    public /* synthetic */ void a(List list) {
        if (this.f6403a != null) {
            this.f6560b.setTotalSpace(((Long) list.get(0)).longValue());
            this.f6560b.setRemainingSpace(((Long) list.get(1)).longValue());
            Utils.c(this.f6560b.getTotalSpace());
            Utils.c(this.f6560b.getRemainingSpace());
            if (this.f6560b.getTotalSpace() == 0 && this.f6560b.getRemainingSpace() == 0) {
                ((q0) this.f6403a).u();
            } else if (this.f6560b.getRemainingSpace() < 31457280) {
                ((q0) this.f6403a).X();
            } else {
                int i2 = this.f6561c;
                if (i2 > 0) {
                    this.f6562d = 0;
                    ((q0) this.f6403a).h(i2);
                    this.f6564f = ThreadPoolService.scheduleAtFixedRate(new d0(this), 1, 1, TimeUnit.SECONDS);
                } else {
                    R();
                }
            }
        }
    }

    public /* synthetic */ void a(String str, String str2, int i2) {
        if (i2 == 0) {
            String g2 = e.c.d.n.e.g(this.f6565g);
            r rVar = r.f6218b;
            WorkWrapper workWrapper = this.o;
            q qVar = new q(this, g2);
            if (rVar != null) {
                ExportImageParamsBuilder targetPath = new ExportImageParamsBuilder().setExportMode(ExportMode.PANORAMA).setCameraType(InstaCameraManager.getInstance().getCameraType()).setTargetPath(g2);
                targetPath.setUrlForExport(str);
                ExportUtils.exportImage(workWrapper, targetPath, new q(rVar, qVar));
                return;
            }
            throw null;
        }
        F();
    }

    public final void a(int i2, String str) {
        if (i2 == 0) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(e.c.d.n.e.h(this.f6565g));
                BitmapFactory.decodeFile(str).compress(CompressFormat.JPEG, 10, fileOutputStream);
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ThreadPoolService.post(new o0(this, str));
            return;
        }
        F();
    }

    public final void a(boolean z, boolean z2) {
        if (z != G() || z2) {
            b(z);
            r rVar = r.f6218b;
            e0 e0Var = new e0(this, z);
            if (rVar != null) {
                n nVar = n.f6212c;
                e0Var.getClass();
                e.c.d.i.c.c cVar = new e.c.d.i.c.c(e0Var);
                if (nVar != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        String str = "hdr";
                        if (z) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject.put(str, str);
                            jSONObject2.put("shots", 3);
                            jSONObject2.put("increment", 2);
                            jSONObject.put("exposureBracket", jSONObject2);
                        } else {
                            jSONObject.put(str, "off");
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("options", jSONObject);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("name", "camera.setOptions");
                        jSONObject4.put("parameters", jSONObject3);
                        nVar.f6213a.execute(new g(nVar, "/osc/commands/execute", jSONObject4.toString(), cVar));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        cVar.a(null, -2);
                    }
                    return;
                }
                throw null;
            }
            throw null;
        }
    }

    public /* synthetic */ void a(boolean z, String str, int i2) {
        if (i2 != 0) {
            return;
        }
        if (z) {
            this.f6560b.setHdr("hdr");
        } else {
            this.f6560b.setHdr("off");
        }
    }

    public void a(int i2) {
        b(i2, false);
    }

    public /* synthetic */ void a(int i2, String str, int i3) {
        if (i3 == 0) {
            this.f6560b.setExposureCompensation(i2);
        } else {
            ThreadPoolService.post(new t(this, i2));
        }
    }

    public final void a(String str, boolean z) {
        if (!this.f6560b.getWhiteBalance().equalsIgnoreCase(str) || z) {
            f(str);
            r rVar = r.f6218b;
            v vVar = new v(this, str);
            if (rVar != null) {
                n nVar = n.f6212c;
                vVar.getClass();
                e.c.d.i.c.c cVar = new e.c.d.i.c.c(vVar);
                if (nVar != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("whiteBalance", str);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("options", jSONObject);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("name", "camera.setOptions");
                        jSONObject3.put("parameters", jSONObject2);
                        nVar.f6213a.execute(new g(nVar, "/osc/commands/execute", jSONObject3.toString(), cVar));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        cVar.a(null, -2);
                    }
                    return;
                }
                throw null;
            }
            throw null;
        }
    }

    public /* synthetic */ void a(int i2, boolean z, String str, int i3) {
        if (i3 == 0) {
            this.f6560b.setExposureProgram(i2);
            ThreadPoolService.post(new n0(this, i2, z));
            return;
        }
        ThreadPoolService.post(new s(this));
    }

    public /* synthetic */ void a(int i2, boolean z) {
        if (this.f6403a != null && i2 == 1 && !z) {
            a(0.03333f, false);
            d(800, false);
            int i3 = 0;
            while (true) {
                if (i3 >= this.m.size()) {
                    break;
                } else if (((e.c.d.m.d.a.t0.i.a) this.m.get(i3)).f6601a == 800) {
                    ((q0) this.f6403a).e(i3);
                    break;
                } else {
                    i3++;
                }
            }
            for (int i4 = 0; i4 < this.n.size(); i4++) {
                if (((e.c.d.m.d.a.t0.k.a) this.n.get(i4)).f6620a == 0.03333f) {
                    ((q0) this.f6403a).i(i4);
                    return;
                }
            }
        }
    }

    public final void a(float f2, boolean z) {
        if (this.f6560b.getShutterSpeed() != f2 || z) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                if (((e.c.d.m.d.a.t0.k.a) this.n.get(i2)).f6620a == f2) {
                    ((e.c.d.m.d.a.t0.k.a) this.n.get(i2)).f6621b = true;
                    a(e.c.d.m.d.a.t0.j.b.SHUTTER_SPEED, Utils.a(f2));
                } else {
                    ((e.c.d.m.d.a.t0.k.a) this.n.get(i2)).f6621b = false;
                }
            }
            ((q0) this.f6403a).R();
            r rVar = r.f6218b;
            m0 m0Var = new m0(this, f2);
            if (rVar != null) {
                InstaCameraManager.getInstance().setShutterSpeed(7, (double) f2);
                m0Var.a("", 0);
                return;
            }
            throw null;
        }
    }

    public /* synthetic */ void a(float f2, String str, int i2) {
        if (i2 == 0) {
            this.f6560b.setShutterSpeed(f2);
        } else {
            ThreadPoolService.post(new k0(this));
        }
    }

    public void a() {
        ((q0) this.f6403a).a();
    }
}
