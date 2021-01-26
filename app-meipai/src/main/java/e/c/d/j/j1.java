package e.c.d.j;

import android.text.TextUtils;
import com.baidu.picapture.common.bos.beans.UploadTask;
import com.baidu.picapture.db.tables.LocalTaskDao;
import com.baidu.picapture.db.tables.LocalTaskDao.Properties;
import com.baidu.picapture.model.net.BaseResponse;
import com.baidu.picapture.model.net.spin.NewSpinTaskReq;
import com.baidu.picapture.model.net.spin.RemoteSpinTaskProcessReq;
import com.baidu.picapture.model.spin.SpinTaskInfo;
import com.tencent.connect.common.Constants;
import e.c.b.e.Utils;
import e.c.d.d.a.m;
import e.c.d.d.a.p;
import e.c.d.d.a.s;
import e.c.d.d.e.ThreadPoolService;
import e.g.b.j;
import g.e;
import g.y;
import i.b.b.j.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: SpinTaskManager */
public class j1 extends f1 {

    /* renamed from: j reason: collision with root package name */
    public static volatile j1 f6280j;

    /* renamed from: d reason: collision with root package name */
    public Map<String, SpinTaskInfo> f6281d = new HashMap();

    /* renamed from: e reason: collision with root package name */
    public List<String> f6282e = new ArrayList();

    /* renamed from: f reason: collision with root package name */
    public Map<e, SpinTaskInfo> f6283f = new HashMap();

    /* renamed from: g reason: collision with root package name */
    public e.c.d.d.f.b<d> f6284g = new e.c.d.d.f.b<>();

    /* renamed from: h reason: collision with root package name */
    public e.c.d.d.f.b<c> f6285h = new e.c.d.d.f.b<>();

    /* renamed from: i reason: collision with root package name */
    public Map<String, SpinTaskInfo> f6286i = new HashMap();

    /* compiled from: SpinTaskManager */
    public class a implements p {
        public a() {
        }

        public void a(String str) {
            j1.this.f6254a.execute(new z(this, str));
        }

        public /* synthetic */ void b(String str, float f2) {
            j1 j1Var = j1.this;
            SpinTaskInfo spinTaskInfo = (SpinTaskInfo) j1Var.f6286i.get(str);
            if (spinTaskInfo != null && Math.abs(spinTaskInfo.getProgress() - f2) >= 1.0f) {
                spinTaskInfo.setProgress(f2);
                j1Var.f6284g.observable(new b1(spinTaskInfo, ((f2 * 90.0f) / 100.0f) + 9.0f));
                String str2 = spinTaskInfo.getTask().f6072a;
            }
        }

        public /* synthetic */ void c(String str) {
            SpinTaskInfo spinTaskInfo = (SpinTaskInfo) j1.this.f6286i.get(str);
            if (spinTaskInfo != null) {
                String str2 = spinTaskInfo.getTask().f6072a;
            }
        }

        public void a(String str, float f2) {
            j1.this.f6254a.execute(new y(this, str, f2));
        }

        public void a(String str, int i2) {
            j1.this.f6254a.execute(new a0(this, str, i2));
        }

        public void a(String str, String str2) {
            j1.this.f6254a.execute(new x(this, str));
        }

        public /* synthetic */ void b(String str, int i2) {
            j1 j1Var = j1.this;
            SpinTaskInfo spinTaskInfo = (SpinTaskInfo) j1Var.f6286i.get(str);
            if (spinTaskInfo != null) {
                j1Var.f6286i.remove(str);
                if (spinTaskInfo.getTask().f6077f == 5 || spinTaskInfo.getTask().f6077f == 998) {
                    String str2 = spinTaskInfo.getTask().f6072a;
                    if (i2 == 3) {
                        j1Var.b(spinTaskInfo, 999);
                    } else {
                        j1Var.b(spinTaskInfo, 6);
                        if (i2 == 6) {
                            j1Var.f6284g.observable(new j0(spinTaskInfo));
                        } else if (i2 == 5) {
                            j1Var.f6284g.observable(new c1(spinTaskInfo));
                        } else {
                            j1Var.f6284g.observable(new p0(spinTaskInfo));
                        }
                    }
                    e.c.d.f.b.b.b().a(spinTaskInfo.getTask());
                    return;
                }
                int i3 = spinTaskInfo.getTask().f6077f;
            }
        }

        public /* synthetic */ void b(String str) {
            j1 j1Var = j1.this;
            SpinTaskInfo spinTaskInfo = (SpinTaskInfo) j1Var.f6286i.get(str);
            if (spinTaskInfo != null) {
                String str2 = spinTaskInfo.getTask().f6072a;
                j1Var.f6286i.remove(str);
                j1Var.c(spinTaskInfo);
            }
        }
    }

    /* compiled from: SpinTaskManager */
    public class b extends e.c.d.l.b.a<BaseResponse<String>> {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ SpinTaskInfo f6288a;

        public b(SpinTaskInfo spinTaskInfo) {
            this.f6288a = spinTaskInfo;
        }

        public void a(e eVar, Object obj, int i2) {
            BaseResponse baseResponse = (BaseResponse) obj;
            if (i2 != 0) {
                j1.this.f6254a.execute(new d0(this, this.f6288a));
            } else if (baseResponse.getError_code() == 0) {
                j1.this.f6254a.execute(new c0(this, this.f6288a));
            } else {
                j1.this.f6254a.execute(new b0(this, this.f6288a, baseResponse));
            }
        }

        public /* synthetic */ void b(SpinTaskInfo spinTaskInfo) {
            j1.b(j1.this, spinTaskInfo, -1);
        }

        public /* synthetic */ void a(SpinTaskInfo spinTaskInfo) {
            j1 j1Var = j1.this;
            if (j1Var != null) {
                String str = spinTaskInfo.getTask().f6072a;
                j1Var.f6281d.remove(spinTaskInfo.getTask().f6072a);
                j1Var.b(spinTaskInfo, 1000);
                e.c.d.n.e.c(spinTaskInfo.getTask().f6072a);
                j1Var.f6284g.observable(new z0(spinTaskInfo));
                return;
            }
            throw null;
        }

        public /* synthetic */ void a(SpinTaskInfo spinTaskInfo, BaseResponse baseResponse) {
            j1.b(j1.this, spinTaskInfo, baseResponse.getError_code());
        }
    }

    /* compiled from: SpinTaskManager */
    public interface c {
        void a(String str, String str2);
    }

    /* compiled from: SpinTaskManager */
    public interface d {
        void a(SpinTaskInfo spinTaskInfo);

        void a(SpinTaskInfo spinTaskInfo, float f2);

        void a(SpinTaskInfo spinTaskInfo, int i2);

        void b(SpinTaskInfo spinTaskInfo);
    }

    public static j1 e() {
        if (f6280j == null) {
            synchronized (j1.class) {
                if (f6280j == null) {
                    f6280j = new j1();
                }
            }
        }
        return f6280j;
    }

    public /* synthetic */ void a(String str) {
        String str2;
        SpinTaskInfo spinTaskInfo = (SpinTaskInfo) this.f6281d.get(str);
        if (spinTaskInfo != null) {
            int i2 = spinTaskInfo.getTask().f6077f;
            b(spinTaskInfo, 998);
            if (i2 == 1) {
                Iterator it = this.f6283f.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Entry entry = (Entry) it.next();
                    e eVar = (e) entry.getKey();
                    SpinTaskInfo spinTaskInfo2 = (SpinTaskInfo) entry.getValue();
                    if (spinTaskInfo2.getTask().f6072a.compareToIgnoreCase(str) == 0) {
                        if (eVar != null && !eVar.i()) {
                            eVar.cancel();
                        }
                        this.f6283f.remove(eVar);
                        b(spinTaskInfo2, 999);
                    }
                }
            } else if (i2 == 5) {
                Iterator it2 = this.f6286i.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        str2 = null;
                        break;
                    }
                    Entry entry2 = (Entry) it2.next();
                    str2 = (String) entry2.getKey();
                    if (((SpinTaskInfo) entry2.getValue()).getTask().f6072a.compareToIgnoreCase(str) == 0) {
                        break;
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    b(spinTaskInfo, 999);
                } else {
                    s a2 = s.a();
                    if (a2 != null) {
                        s.f5986e.execute(new m(a2, str2));
                    } else {
                        throw null;
                    }
                }
            }
            this.f6281d.remove(str);
        }
    }

    public void c() {
        for (Entry value : this.f6281d.entrySet()) {
            SpinTaskInfo spinTaskInfo = (SpinTaskInfo) value.getValue();
            int i2 = spinTaskInfo.getTask().f6077f;
            if (i2 == 2 || i2 == 6 || i2 == 8) {
                this.f6284g.observable(new w0(spinTaskInfo));
                b(spinTaskInfo);
            }
        }
    }

    public void d() {
        List<e.c.d.f.d.c> list;
        e.c.d.f.b.b b2 = e.c.d.f.b.b.b();
        if (b2 != null) {
            String str = e.c.d.d.c.e.f6006d.f6009c;
            if (TextUtils.isEmpty(str)) {
                list = new ArrayList<>();
            } else {
                LocalTaskDao a2 = b2.a();
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
                ArrayList arrayList = new ArrayList();
                for (e.c.d.f.d.c cVar : list) {
                    SpinTaskInfo spinTaskInfo = new SpinTaskInfo();
                    spinTaskInfo.setTask(cVar);
                    arrayList.add(spinTaskInfo);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    SpinTaskInfo spinTaskInfo2 = (SpinTaskInfo) it.next();
                    this.f6284g.observable(new k0(spinTaskInfo2));
                    b(spinTaskInfo2);
                }
                return;
            }
            return;
        }
        throw null;
    }

    public /* synthetic */ void b(String str) {
        SpinTaskInfo spinTaskInfo = (SpinTaskInfo) this.f6281d.get(str);
        if (spinTaskInfo != null) {
            b(spinTaskInfo, 1001);
            this.f6281d.remove(spinTaskInfo.getTask().f6072a);
            e.c.d.n.e.c(spinTaskInfo.getTask().f6072a);
        }
    }

    public /* synthetic */ void c(String str) {
        SpinTaskInfo spinTaskInfo = (SpinTaskInfo) this.f6281d.get(str);
        if (spinTaskInfo != null) {
            int i2 = spinTaskInfo.getTask().f6077f;
            if (i2 == 2 || i2 == 4 || i2 == 6 || i2 == 8) {
                b(spinTaskInfo);
            } else {
                String str2 = spinTaskInfo.getTask().f6076e;
            }
        }
    }

    public final void e(SpinTaskInfo spinTaskInfo) {
        String str = spinTaskInfo.getTask().f6072a;
        b(spinTaskInfo, 3);
        if (!this.f6282e.contains(str)) {
            this.f6282e.add(str);
            ThreadPoolService.fixedThreadPool.execute(new r0(this, spinTaskInfo, str));
        }
    }

    public static /* synthetic */ void b(j1 j1Var, SpinTaskInfo spinTaskInfo, int i2) {
        if (j1Var != null) {
            String str = spinTaskInfo.getTask().f6072a;
            j1Var.b(spinTaskInfo, 8);
            if (i2 == -20) {
                j1Var.f6284g.observable(new m0(spinTaskInfo));
            } else {
                j1Var.f6284g.observable(new o0(spinTaskInfo));
            }
        } else {
            throw null;
        }
    }

    public final void c(SpinTaskInfo spinTaskInfo) {
        String str = spinTaskInfo.getTask().f6072a;
        b(spinTaskInfo, 7);
        long e2 = Utils.e(e.c.d.n.e.l(spinTaskInfo.getTask().f6072a));
        e.c.d.l.b.b a2 = e.c.d.l.b.b.a();
        String str2 = spinTaskInfo.getTask().f6073b;
        String str3 = spinTaskInfo.getTask().f6072a;
        b bVar = new b(spinTaskInfo);
        if (a2 != null) {
            RemoteSpinTaskProcessReq remoteSpinTaskProcessReq = new RemoteSpinTaskProcessReq();
            remoteSpinTaskProcessReq.setSource("PCT");
            remoteSpinTaskProcessReq.setStorageBytes(e2);
            StringBuilder a3 = e.a.a.a.a.a("https://repos3d.bj.bcebos.com/");
            a3.append(e.c.d.n.e.a(str2, str3));
            remoteSpinTaskProcessReq.setMaterialUrl(a3.toString());
            remoteSpinTaskProcessReq.setMaterialType("spin_360");
            y create = y.create(e.c.d.l.b.b.f6372b, new j().a((Object) remoteSpinTaskProcessReq));
            g.x.a aVar = new g.x.a();
            StringBuilder sb = new StringBuilder();
            sb.append("https://vrstudio.baidu.com/vr/mkt/repos3d/api/v2/package/");
            sb.append(str2);
            sb.append("/upload");
            aVar.a(sb.toString());
            aVar.a(Constants.HTTP_POST, create);
            a2.f6374a.a(aVar.a()).a(bVar);
            return;
        }
        throw null;
    }

    public final void b(SpinTaskInfo spinTaskInfo, int i2) {
        String str = spinTaskInfo.getTask().f6072a;
        if (i2 == 999) {
            this.f6285h.observable(new t0(str));
        }
        spinTaskInfo.getTask().f6077f = i2;
        e.c.d.f.b.b.b().a(spinTaskInfo.getTask());
    }

    /* renamed from: a */
    public final void b(SpinTaskInfo spinTaskInfo) {
        String str = spinTaskInfo.getTask().f6072a;
        int i2 = spinTaskInfo.getTask().f6077f;
        if (!TextUtils.isEmpty(str) && !this.f6281d.containsKey(str)) {
            this.f6281d.put(str, spinTaskInfo);
        }
        if (TextUtils.isEmpty(spinTaskInfo.getTask().f6073b)) {
            if (b()) {
                String str2 = spinTaskInfo.getTask().f6072a;
                b(spinTaskInfo, 1);
                e.c.d.l.b.b a2 = e.c.d.l.b.b.a();
                String str3 = spinTaskInfo.getTask().f6076e;
                i1 i1Var = new i1(this);
                if (a2 != null) {
                    NewSpinTaskReq newSpinTaskReq = new NewSpinTaskReq();
                    newSpinTaskReq.setProductId("PCT");
                    newSpinTaskReq.setPackageName(str3);
                    y create = y.create(e.c.d.l.b.b.f6372b, new j().a((Object) newSpinTaskReq));
                    g.x.a aVar = new g.x.a();
                    aVar.a("https://vrstudio.baidu.com/vr/mkt/repos3d/api/v2/package/create");
                    aVar.a(Constants.HTTP_POST, create);
                    e a3 = a2.f6374a.a(aVar.a());
                    a3.a(i1Var);
                    this.f6283f.put(a3, spinTaskInfo);
                    return;
                }
                throw null;
            }
            b(spinTaskInfo, 2);
            this.f6284g.observable(new a1(spinTaskInfo));
        } else if (i2 == 998 || i2 == 999 || i2 == 3 || i2 == 4) {
            if (b()) {
                e(spinTaskInfo);
                return;
            }
            b(spinTaskInfo, 4);
            this.f6284g.observable(new q0(spinTaskInfo));
        } else if (i2 == 5 || i2 == 6 || i2 == 11) {
            if (b()) {
                d(spinTaskInfo);
                return;
            }
            b(spinTaskInfo, 6);
            this.f6284g.observable(new e1(spinTaskInfo));
        } else if (i2 != 7 && i2 != 8) {
        } else {
            if (b()) {
                c(spinTaskInfo);
                return;
            }
            b(spinTaskInfo, 8);
            this.f6284g.observable(new u0(spinTaskInfo));
        }
    }

    public final void d(SpinTaskInfo spinTaskInfo) {
        String str = spinTaskInfo.getTask().f6072a;
        this.f6284g.observable(new i0(spinTaskInfo));
        b(spinTaskInfo, 5);
        String a2 = s.a().a(new UploadTask(e.c.d.n.e.l(str), e.c.d.n.e.a(spinTaskInfo.getTask().f6073b, str), spinTaskInfo.getTask().f6074c, new a()));
        this.f6286i.put(a2, spinTaskInfo);
        String str2 = spinTaskInfo.getTask().f6074c;
        if (TextUtils.isEmpty(str2) || str2.compareToIgnoreCase(a2) != 0) {
            spinTaskInfo.getTask().f6074c = a2;
            e.c.d.f.b.b.b().a(spinTaskInfo.getTask());
        }
        String str3 = spinTaskInfo.getTask().f6072a;
    }

    public static /* synthetic */ void a(j1 j1Var, SpinTaskInfo spinTaskInfo, int i2) {
        if (j1Var != null) {
            String str = spinTaskInfo.getTask().f6072a;
            j1Var.b(spinTaskInfo, 6);
            if (i2 == -20) {
                j1Var.f6284g.observable(new n0(spinTaskInfo));
            } else {
                j1Var.f6284g.observable(new d1(spinTaskInfo));
            }
        } else {
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0054, code lost:
        if (r4.delete() == false) goto L_0x00b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(com.baidu.picapture.model.spin.SpinTaskInfo r10, java.lang.String r11) {
        /*
            r9 = this;
            e.c.d.j.h0 r0 = new e.c.d.j.h0
            r0.<init>(r9, r10)
            java.lang.System.currentTimeMillis()
            e.c.d.f.d.c r1 = r10.getTask()
            java.lang.String r1 = r1.f6072a
            e.c.d.f.d.c r2 = r10.getTask()
            int r2 = r2.f6079h
            e.c.d.f.d.c r3 = r10.getTask()
            java.lang.String r3 = r3.f6080i
            java.io.File r4 = new java.io.File
            java.lang.String r5 = e.c.d.n.e.j(r1)
            r4.<init>(r5)
            boolean r4 = r4.exists()
            r5 = 0
            if (r4 != 0) goto L_0x002c
            goto L_0x00b0
        L_0x002c:
            java.io.File r4 = new java.io.File
            java.lang.String r6 = e.c.d.n.e.l(r1)
            r4.<init>(r6)
            boolean r6 = r4.exists()
            r7 = 1
            if (r6 == 0) goto L_0x0057
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 != 0) goto L_0x0057
            java.lang.String r6 = e.c.b.e.i.b(r4)
            if (r6 == 0) goto L_0x0050
            int r3 = r6.compareToIgnoreCase(r3)
            if (r3 != 0) goto L_0x0050
        L_0x004e:
            r5 = r7
            goto L_0x00b0
        L_0x0050:
            boolean r3 = r4.delete()
            if (r3 != 0) goto L_0x0057
            goto L_0x00b0
        L_0x0057:
            java.io.File r3 = new java.io.File
            java.lang.String r6 = e.c.d.n.e.k(r1)
            r3.<init>(r6)
            java.io.File[] r6 = r3.listFiles()
            if (r6 != 0) goto L_0x0067
            goto L_0x00b0
        L_0x0067:
            int r6 = r6.length
            boolean r3 = r3.exists()
            if (r3 == 0) goto L_0x0071
            if (r2 == r6) goto L_0x0071
            goto L_0x00b0
        L_0x0071:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00ac }
            java.lang.String r1 = e.c.d.n.e.j(r1)     // Catch:{ Exception -> 0x00ac }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00ac }
            boolean r1 = r2.isDirectory()     // Catch:{ Exception -> 0x00ac }
            if (r1 == 0) goto L_0x0085
            int r1 = e.c.b.e.i.c(r2)     // Catch:{ Exception -> 0x00ac }
            goto L_0x0086
        L_0x0085:
            r1 = r7
        L_0x0086:
            int[] r3 = new int[r7]     // Catch:{ Exception -> 0x00ac }
            r3[r5] = r5     // Catch:{ Exception -> 0x00ac }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x00ac }
            java.lang.String r8 = r4.getPath()     // Catch:{ Exception -> 0x00ac }
            r6.<init>(r8)     // Catch:{ Exception -> 0x00ac }
            e.c.d.n.a r8 = new e.c.d.n.a     // Catch:{ Exception -> 0x00ac }
            r8.<init>(r0, r1, r3)     // Catch:{ Exception -> 0x00ac }
            i.d.a.h.a(r2, r6, r8)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r0 = e.c.b.e.i.b(r4)
            if (r0 != 0) goto L_0x00a2
            goto L_0x00b0
        L_0x00a2:
            e.c.d.f.d.c r1 = r10.getTask()
            r1.f6080i = r0
            java.lang.System.currentTimeMillis()
            goto L_0x004e
        L_0x00ac:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b0:
            java.util.concurrent.ExecutorService r0 = r9.f6254a
            e.c.d.j.v0 r1 = new e.c.d.j.v0
            r1.<init>(r9, r11, r10, r5)
            r0.execute(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.j.j1.a(com.baidu.picapture.model.spin.SpinTaskInfo, java.lang.String):void");
    }

    public /* synthetic */ void a(SpinTaskInfo spinTaskInfo, int i2) {
        int i3 = (i2 * 9) / 100;
        float f2 = (float) i3;
        if (Math.abs(spinTaskInfo.getProgress() - f2) >= 1.0f) {
            spinTaskInfo.setProgress(f2);
            this.f6284g.observable(new l0(spinTaskInfo, i3));
            String str = spinTaskInfo.getTask().f6072a;
        }
    }

    public /* synthetic */ void a(String str, SpinTaskInfo spinTaskInfo, boolean z) {
        this.f6282e.remove(str);
        if (spinTaskInfo.getTask().f6077f == 998) {
            b(spinTaskInfo, 999);
            return;
        }
        String str2 = spinTaskInfo.getTask().f6072a;
        if (z) {
            d(spinTaskInfo);
        } else {
            b(spinTaskInfo, 4);
            this.f6284g.observable(new s0(spinTaskInfo));
        }
    }

    public void a(d dVar) {
        if (this.f6284g.contains(dVar)) {
            this.f6284g.unregisterObserver(dVar);
        }
    }
}
