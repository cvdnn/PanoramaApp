package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.sapi2.X.a.C0011a;
import com.baidu.sapi2.X.d;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.t;
import e.c.b.e.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SapiCache */
public final class V {

    /* renamed from: a reason: collision with root package name */
    public static final Map<String, SoftReference<String>> f2467a = new ConcurrentHashMap();

    /* renamed from: b reason: collision with root package name */
    public final List<String> f2468b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    public final List<String> f2469c = new ArrayList();

    /* renamed from: d reason: collision with root package name */
    public Context f2470d;

    /* compiled from: SapiCache */
    public interface a {
        void a(C0011a aVar);

        void a(C0011a aVar, String str);
    }

    public String c(String str) {
        if (f2467a.containsKey(str) && f2467a.get(str) != null) {
            String str2 = (String) ((SoftReference) f2467a.get(str)).get();
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return null;
    }

    public void d(String str) {
        f2467a.remove(str);
    }

    public String b(Context context, String str) {
        if (!SapiContext.getInstance().getBoolean(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, false)) {
            return null;
        }
        return a(context, a(str));
    }

    @TargetApi(4)
    public String d(Context context, String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getApplicationInfo().dataDir);
        sb.append(File.separator);
        sb.append("files");
        sb.append(File.separator);
        sb.append(str);
        return com.baidu.sapi2.utils.a.b(sb.toString());
    }

    public void a(String str, String str2) {
        f2467a.put(str, new SoftReference(str2));
    }

    public String a(Context context, String str) {
        a();
        if (!SapiContext.getInstance().getSapiOptions().e().c()) {
            return null;
        }
        String c2 = c(str);
        if (!TextUtils.isEmpty(c2)) {
            return c2;
        }
        C0011a c3 = c(context, str);
        if (c3 != null) {
            a(c3, (a) new O(this, context));
        }
        return c(str);
    }

    public void b(X x) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl());
        sb.append("/static/appsapi/conf/android-conf.txt");
        String sb2 = sb.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("If-None-Match", SapiContext.getInstance().getString(SapiContext.KEY_CONFIG_FILE_ETAG));
        try {
            new HttpClientWrap().get(sb2, (HttpHashMap) httpHashMapWrap, hashMap, null, (String) null, 0, (HttpHandlerWrap) new Q(this, true, x));
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public C0011a c(Context context, String str) {
        for (C0011a aVar : SapiContext.getInstance().getSapiOptions().e().a()) {
            if (aVar.f2485a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void c(X x) {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        SapiAccountManager.getInstance().preFetchStoken(SapiContext.getInstance().getCurrentAccount(), false);
        new FaceLoginService().syncFaceLoginUID(this.f2470d, null);
        a(x.Z);
        if (sapiConfiguration.syncOneKeyLoginInfo) {
            new c().a(sapiConfiguration, c.l);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        String deviceInfo = SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
        if (!TextUtils.isEmpty(deviceInfo)) {
            t.a("dvif_interface", Collections.singletonMap("di", deviceInfo));
        }
    }

    public void a(Context context) {
        this.f2470d = context.getApplicationContext();
        X sapiOptions = SapiContext.getInstance().getSapiOptions();
        a(sapiOptions);
        b(sapiOptions);
    }

    public String b(String str) throws IOException {
        return com.baidu.sapi2.utils.a.b(new File(Environment.getExternalStorageDirectory(), str).getAbsolutePath());
    }

    public void a(X x) {
        com.baidu.sapi2.X.a e2 = x.e();
        if (e2.c()) {
            for (C0011a aVar : e2.a()) {
                this.f2468b.add(aVar.f2485a);
            }
            this.f2469c.addAll(this.f2468b);
            for (C0011a a2 : e2.a()) {
                a(a2, (a) new P(this));
            }
        }
    }

    public void a(C0011a aVar, a aVar2) {
        if (aVar2 != null) {
            String b2 = C0011a.b(aVar.f2485a);
            try {
                if (!"mounted".equals(Environment.getExternalStorageState()) || !new File(Environment.getExternalStorageDirectory(), b2).exists()) {
                    aVar2.a(aVar);
                    return;
                }
                String b3 = b(b2);
                if (Utils.a(b3.getBytes(), false).equals(aVar.f2487c)) {
                    aVar2.a(aVar, b3);
                } else {
                    aVar2.a(aVar);
                }
            } catch (Throwable unused) {
                aVar2.a(aVar);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(a.class.getName());
            sb.append("can't be null");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void a(Context context, C0011a aVar) {
        String c2 = C0011a.c(aVar.f2485a);
        if (new File(context.getFilesDir(), c2).exists()) {
            try {
                a(aVar.f2485a, d(context, c2));
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public String a(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getHost());
        if (parse.getPort() == -1) {
            str2 = "";
        } else {
            StringBuilder a2 = e.a.a.a.a.a(Config.TRACE_TODAY_VISIT_SPLIT);
            a2.append(parse.getPort());
            str2 = a2.toString();
        }
        sb.append(str2);
        sb.append(parse.getPath());
        String sb2 = sb.toString();
        String str3 = ".html";
        return !sb2.endsWith(str3) ? e.a.a.a.a.a(sb2, str3) : sb2;
    }

    public void a(String str, X x) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            X a2 = X.a(jSONObject);
            SapiContext.getInstance().setSapiOptions(a2);
            SapiContext.getInstance().setPkgSigns(d.a(jSONObject));
            com.baidu.sapi2.X.a e2 = a2.e();
            com.baidu.sapi2.X.a e3 = x.e();
            c(a2);
            this.f2469c.clear();
            if (e2.c()) {
                for (C0011a aVar : e2.a()) {
                    this.f2469c.add(aVar.f2485a);
                }
                for (C0011a aVar2 : e2.a()) {
                    C0011a aVar3 = null;
                    for (C0011a aVar4 : e3.a()) {
                        if (aVar4.f2485a.equals(aVar2.f2485a)) {
                            aVar3 = aVar4;
                        }
                    }
                    if (a(aVar2, aVar3)) {
                        a(aVar2, (a) new T(this, aVar2, a2, e3));
                    } else {
                        SapiContext.getInstance().put(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, true);
                        a(aVar2, (a) new U(this));
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void a(String str, C0011a aVar) {
        if (!TextUtils.isEmpty(aVar.f2485a) && !TextUtils.isEmpty(str) && aVar.f2487c.equals(Utils.a(str.getBytes(), false))) {
            a(aVar.f2485a, str);
            a(this.f2470d, C0011a.c(aVar.f2485a), str.getBytes());
            if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.f2470d)) {
                a(C0011a.b(aVar.f2485a), str.getBytes());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r0 == null) goto L_0x0058;
     */
    @android.annotation.TargetApi(4)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            com.baidu.sapi2.SapiContext r5 = com.baidu.sapi2.SapiContext.getInstance()
            java.lang.String r5 = r5.getPackageDirExecutePer()
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0012
            return
        L_0x0012:
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x004c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004c }
            r2.<init>()     // Catch:{ Exception -> 0x004c }
            java.lang.String r3 = "chmod "
            r2.append(r3)     // Catch:{ Exception -> 0x004c }
            r2.append(r5)     // Catch:{ Exception -> 0x004c }
            java.lang.String r5 = " "
            r2.append(r5)     // Catch:{ Exception -> 0x004c }
            android.content.Context r5 = r4.f2470d     // Catch:{ Exception -> 0x004c }
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()     // Catch:{ Exception -> 0x004c }
            java.lang.String r5 = r5.dataDir     // Catch:{ Exception -> 0x004c }
            r2.append(r5)     // Catch:{ Exception -> 0x004c }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x004c }
            java.lang.Process r0 = r1.exec(r5)     // Catch:{ Exception -> 0x004c }
            int r5 = r0.waitFor()     // Catch:{ Exception -> 0x004c }
            if (r5 != 0) goto L_0x0055
            com.baidu.sapi2.SapiContext r5 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x004c }
            java.lang.String r1 = ""
            r5.setPackageDirExecutePer(r1)     // Catch:{ Exception -> 0x004c }
            goto L_0x0055
        L_0x004c:
            r5 = move-exception
            goto L_0x0050
        L_0x004e:
            r5 = move-exception
            goto L_0x0059
        L_0x0050:
            com.baidu.sapi2.utils.Log.e(r5)     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0058
        L_0x0055:
            r0.destroy()
        L_0x0058:
            return
        L_0x0059:
            if (r0 == 0) goto L_0x005e
            r0.destroy()
        L_0x005e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.V.a(boolean):void");
    }

    public boolean a(C0011a aVar, C0011a aVar2) {
        return !TextUtils.isEmpty(aVar.f2487c) && (aVar2 == null || !aVar.f2487c.equals(aVar2.f2487c));
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f2468b) {
            if (!this.f2469c.contains(str)) {
                arrayList.add(str);
                d(str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (this.f2468b.contains(str2)) {
                this.f2468b.remove(str2);
            }
        }
    }

    public void a(Context context, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = context.openFileOutput(str, 0);
            try {
                fileOutputStream.write(bArr);
                SapiContext.getInstance().put(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, true);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
            if (fileOutputStream == null) {
                return;
            }
            fileOutputStream.close();
        }
        try {
            fileOutputStream.close();
        } catch (Throwable unused3) {
        }
    }

    public void a(String str, byte[] bArr) {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                com.baidu.sapi2.utils.a.a(new File(Environment.getExternalStorageDirectory(), str), bArr, false);
            }
        } catch (Throwable th) {
            Log.e(th);
        }
    }
}
