package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SessionAnalysis {

    /* renamed from: a reason: collision with root package name */
    public boolean f1475a = false;

    /* renamed from: b reason: collision with root package name */
    public Map<String, a> f1476b = new HashMap();

    /* renamed from: c reason: collision with root package name */
    public a f1477c = new a();

    /* renamed from: d reason: collision with root package name */
    public a f1478d = new a();

    /* renamed from: e reason: collision with root package name */
    public boolean f1479e = false;

    /* renamed from: f reason: collision with root package name */
    public long f1480f = 0;

    /* renamed from: g reason: collision with root package name */
    public Session f1481g = new Session();

    /* renamed from: h reason: collision with root package name */
    public int f1482h = 0;

    /* renamed from: i reason: collision with root package name */
    public int f1483i = 0;

    /* renamed from: j reason: collision with root package name */
    public long f1484j = 0;
    public boolean k = true;
    public LaunchInfo l;
    public LaunchInfo m;
    public Callback mCallback;

    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    public static class a {

        /* renamed from: a reason: collision with root package name */
        public String f1485a;

        /* renamed from: b reason: collision with root package name */
        public long f1486b;

        /* renamed from: c reason: collision with root package name */
        public boolean f1487c = false;

        public a() {
        }

        public a(String str) {
            this.f1485a = str;
        }
    }

    public SessionAnalysis() {
    }

    private void a(Context context, long j2, long j3, int i2, int i3) {
        if (j3 - j2 > ((long) getSessionTimeOut())) {
            if (j2 > 0) {
                if (2 == i3) {
                    this.f1481g.setEndTime(j2);
                }
                LaunchInfo launchInfo = this.m;
                a(context, j3, false, false, launchInfo != null ? launchInfo.getLaunchType(context) : 0);
            }
            this.f1481g.setTrackStartTime(this.f1484j);
            this.f1481g.setInvokeType(i2);
        }
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str) && this.f1476b.containsKey(str)) {
            this.f1476b.remove(str);
        }
    }

    public void autoTrackLaunchInfo(LaunchInfo launchInfo, boolean z) {
        if (z) {
            this.l = launchInfo;
        } else {
            this.m = launchInfo;
        }
    }

    public void autoTrackSessionEndTime(Context context, long j2) {
        if (context != null) {
            this.f1481g.setTrackEndTime(j2);
            a(context);
        }
    }

    public void autoTrackSessionStartTime(Context context, long j2) {
        if (context != null) {
            this.f1481g.setTrackStartTime(j2);
            this.f1484j = j2;
        }
    }

    public void clearLastSessionCache(Context context) {
        if (context != null) {
            String jSONObject = new JSONObject().toString();
            StringBuilder a2 = e.a.a.a.a.a(bw.u(context));
            a2.append(Config.LAST_SESSION_FILE_NAME);
            bo.a(context, a2.toString(), jSONObject, false);
        }
    }

    public void doSendLogCheck(Context context, long j2) {
        long j3 = this.f1480f;
        if (j3 > 0 && j2 - j3 > ((long) getSessionTimeOut())) {
            a(context, -1, false, false, 0);
        }
    }

    public JSONObject getPageSessionHead() {
        return this.f1481g.getPageSessionHead();
    }

    public int getSessionSize() {
        return this.f1483i;
    }

    public long getSessionStartTime() {
        return this.f1481g.getStartTime();
    }

    public int getSessionTimeOut() {
        if (this.f1482h <= 0) {
            this.f1482h = 30000;
        }
        return this.f1482h;
    }

    public boolean isSessionStart() {
        return this.f1481g.getStartTime() > 0;
    }

    public void onPageEnd(Context context, String str, String str2, String str3, long j2, ExtraInfo extraInfo, boolean z) {
        String str4 = str;
        this.f1479e = false;
        if (!TextUtils.isEmpty(str)) {
            a a2 = a(str4);
            if (a2 != null) {
                if (!a2.f1487c) {
                    bc c2 = bc.c();
                    StringBuilder sb = new StringBuilder();
                    sb.append("[WARNING] 遗漏StatService.onPageStart(), 请检查邻近页面埋点: ");
                    sb.append(str4);
                    c2.c(sb.toString());
                    return;
                }
                a(context, a2.f1485a, str, a2.f1486b, j2, str2, "", str3, false, extraInfo, z);
                b(str4);
                this.f1480f = j2;
            }
        }
    }

    public void onPageEndAct(Context context, String str, String str2, String str3, long j2, boolean z, ExtraInfo extraInfo) {
        this.f1479e = false;
        a aVar = z ? this.f1478d : this.f1477c;
        if (!aVar.f1487c) {
            if (!z) {
                bc c2 = bc.c();
                StringBuilder sb = new StringBuilder();
                sb.append("[WARNING] 遗漏StatService.onResume(Activity), 请检查邻近页面埋点: ");
                sb.append(str);
                c2.c(sb.toString());
            }
            return;
        }
        a aVar2 = aVar;
        a(context, aVar.f1485a, str, aVar.f1486b, j2, str2, str3, str, z, extraInfo, false);
        aVar2.f1487c = false;
        this.f1480f = j2;
    }

    public void onPageEndFrag(Context context, String str, String str2, String str3, long j2) {
        String str4 = str;
        if (!TextUtils.isEmpty(str)) {
            a a2 = a(str4);
            if (a2 != null) {
                if (!a2.f1487c) {
                    bc c2 = bc.c();
                    StringBuilder sb = new StringBuilder();
                    sb.append("[WARNING] 遗漏StatService.onResume(Fragment), 请检查邻近页面埋点: ");
                    sb.append(str4);
                    c2.c(sb.toString());
                    return;
                }
                a(context, a2.f1485a, str, a2.f1486b, j2, str2, str3, null, false, null, false);
                b(str4);
                this.f1480f = j2;
            }
        }
    }

    public void onPageStart(Context context, String str, int i2, long j2) {
        onSessionStart(context, j2, false);
        if (!TextUtils.isEmpty(str)) {
            a a2 = a(str);
            if (a2 != null) {
                if (a2.f1487c) {
                    bc c2 = bc.c();
                    StringBuilder sb = new StringBuilder();
                    sb.append("[WARNING] 遗漏StatService.onPageEnd(), 请检查邻近页面埋点: ");
                    sb.append(str);
                    c2.c(sb.toString());
                }
                if (!this.f1479e) {
                    a(context, this.f1480f, j2, i2, 3);
                    this.f1479e = true;
                }
                a2.f1487c = true;
                a2.f1486b = j2;
            }
        }
    }

    public void onPageStartAct(Context context, String str, long j2, boolean z) {
        onSessionStart(context, j2, false);
        if (!TextUtils.isEmpty(str)) {
            a aVar = z ? this.f1478d : this.f1477c;
            if (aVar.f1487c && !z) {
                bc c2 = bc.c();
                StringBuilder sb = new StringBuilder();
                sb.append("[WARNING] 遗漏StatService.onPause(Activity), 请检查邻近页面埋点: ");
                sb.append(str);
                c2.c(sb.toString());
            }
            if (!this.f1479e) {
                a(context, this.f1480f, j2, 1, 1);
                this.f1479e = true;
            }
            aVar.f1487c = true;
            aVar.f1485a = str;
            aVar.f1486b = j2;
        }
    }

    public void onPageStartFrag(Context context, String str, long j2) {
        onSessionStart(context, j2, false);
        if (!TextUtils.isEmpty(str)) {
            a a2 = a(str);
            if (a2.f1487c) {
                bc c2 = bc.c();
                StringBuilder sb = new StringBuilder();
                sb.append("[WARNING] 遗漏StatService.onPause(Fragment), 请检查邻近页面埋点: ");
                sb.append(str);
                c2.c(sb.toString());
            }
            a(context, this.f1480f, j2, 2, 2);
            a2.f1487c = true;
            a2.f1485a = str;
            a2.f1486b = j2;
        }
    }

    public void onSessionStart(Context context, long j2, boolean z) {
        if (!this.f1475a) {
            DataCore.instance().init(context);
            try {
                Thread.sleep(3000);
            } catch (Exception unused) {
            }
            int i2 = 0;
            LaunchInfo launchInfo = this.l;
            if (launchInfo != null) {
                i2 = launchInfo.getLaunchType(context);
            }
            a(context, j2, z, true, i2);
            this.f1475a = true;
        }
    }

    public void setAutoSend(boolean z) {
        this.k = z;
    }

    public void setSessionTimeOut(int i2) {
        if (i2 < 1) {
            i2 = 30;
            bc.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[30] is used");
        } else if (i2 > 600) {
            bc.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[600] is used");
            i2 = 600;
        }
        this.f1482h = i2 * 1000;
    }

    private void a(Context context, String str, String str2, long j2, long j3, String str3, String str4, String str5, boolean z, ExtraInfo extraInfo, boolean z2) {
        long j4 = j3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2)) {
            com.baidu.mobstat.Session.a aVar = new com.baidu.mobstat.Session.a(str3, str4, str5, j4 - j2, j2, z, extraInfo, z2);
            this.f1481g.addPageView(aVar);
            this.f1481g.setEndTime(j4);
            a(context);
        }
    }

    public SessionAnalysis(Callback callback) {
        this.mCallback = callback;
    }

    private a a(String str) {
        if (!this.f1476b.containsKey(str)) {
            this.f1476b.put(str, new a(str));
        }
        return (a) this.f1476b.get(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r13, long r14, boolean r16, boolean r17, int r18) {
        /*
            r12 = this;
            r0 = r12
            r9 = r13
            r1 = r14
            r3 = r18
            com.baidu.mobstat.Session r4 = r0.f1481g
            boolean r4 = r4.hasEnd()
            r5 = 0
            if (r4 == 0) goto L_0x002d
            com.baidu.mobstat.DataCore r4 = com.baidu.mobstat.DataCore.instance()
            com.baidu.mobstat.Session r7 = r0.f1481g
            r4.putSession(r7)
            com.baidu.mobstat.DataCore r4 = com.baidu.mobstat.DataCore.instance()
            r4.flush(r13)
            com.baidu.mobstat.Session r4 = r0.f1481g
            org.json.JSONObject r4 = r4.getPageSessionHead()
            com.baidu.mobstat.av.a(r4)
            com.baidu.mobstat.Session r4 = r0.f1481g
            r4.setEndTime(r5)
        L_0x002d:
            int r4 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            r10 = r4
            if (r10 == 0) goto L_0x0039
            r5 = r1
            goto L_0x0040
        L_0x0039:
            com.baidu.mobstat.Session r4 = r0.f1481g
            long r4 = r4.getStartTime()
            r5 = r4
        L_0x0040:
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0066
            if (r17 == 0) goto L_0x0055
            com.baidu.mobstat.LaunchInfo r7 = r0.l
            if (r7 == 0) goto L_0x0064
            java.lang.String r4 = r7.getPushContent()
            com.baidu.mobstat.LaunchInfo r7 = r0.l
            java.lang.String r7 = r7.getRefererPkgName()
            goto L_0x006a
        L_0x0055:
            com.baidu.mobstat.LaunchInfo r7 = r0.m
            if (r7 == 0) goto L_0x0064
            java.lang.String r4 = r7.getPushContent()
            com.baidu.mobstat.LaunchInfo r7 = r0.m
            java.lang.String r7 = r7.getRefererPkgName()
            goto L_0x006a
        L_0x0064:
            r7 = r4
            goto L_0x006d
        L_0x0066:
            java.lang.String r7 = com.baidu.mobstat.LaunchInfo.getLauncherHomePkgName(r13)
        L_0x006a:
            r11 = r7
            r7 = r4
            r4 = r11
        L_0x006d:
            org.json.JSONObject r8 = com.baidu.mobstat.LaunchInfo.getConvertedJson(r3, r4, r7)
            if (r10 == 0) goto L_0x0084
            com.baidu.mobstat.Session r3 = r0.f1481g
            r3.reset()
            com.baidu.mobstat.Session r3 = r0.f1481g
            r3.setStartTime(r14)
            if (r8 == 0) goto L_0x0084
            com.baidu.mobstat.Session r1 = r0.f1481g
            r1.setLaunchInfo(r8)
        L_0x0084:
            com.baidu.mobstat.DataCore r1 = com.baidu.mobstat.DataCore.instance()
            r2 = r13
            r3 = r10
            r4 = r16
            r7 = r17
            r1.saveLogData(r2, r3, r4, r5, r7, r8)
            com.baidu.mobstat.SessionAnalysis$Callback r1 = r0.mCallback
            if (r1 == 0) goto L_0x00a0
            com.baidu.mobstat.DataCore r2 = com.baidu.mobstat.DataCore.instance()
            org.json.JSONObject r2 = r2.getLogData()
            r1.onCallback(r2)
        L_0x00a0:
            if (r10 != 0) goto L_0x00a6
            boolean r1 = r0.k
            if (r1 == 0) goto L_0x00ad
        L_0x00a6:
            com.baidu.mobstat.LogSender r1 = com.baidu.mobstat.LogSender.instance()
            r1.onSend(r13)
        L_0x00ad:
            r12.clearLastSessionCache(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.SessionAnalysis.a(android.content.Context, long, boolean, boolean, int):void");
    }

    private void a(Context context) {
        if (this.f1481g.hasStart()) {
            String jSONObject = this.f1481g.constructJSONObject().toString();
            this.f1483i = jSONObject.getBytes().length;
            StringBuilder a2 = e.a.a.a.a.a(bw.u(context));
            a2.append(Config.LAST_SESSION_FILE_NAME);
            bo.a(context, a2.toString(), jSONObject, false);
        }
    }
}
