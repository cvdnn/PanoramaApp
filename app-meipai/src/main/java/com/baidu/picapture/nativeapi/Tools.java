package com.baidu.picapture.nativeapi;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.baidu.picapture.App;
import com.baidu.picapture.common.share.ShareEntity;
import com.baidu.picapture.model.device.LanguageUtils;
import com.baidu.picapture.model.nativeapi.ShareBean;
import com.baidu.picapture.model.nativeapi.UnZipTask;
import com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a;
import com.baidubce.BceConfig;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import e.c.b.e.Utils;
import e.c.d.d.d.b;
import e.c.d.d.e.ThreadPoolService;
import e.c.d.f.d.d;
import e.c.d.k.m;
import e.c.d.k.n;
import e.c.d.k.o;
import e.c.d.k.p;
import e.c.d.k.q;
import e.c.d.n.e;
import e.g.b.j;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class Tools {

    /* renamed from: a reason: collision with root package name */
    public Context f1976a;

    public Tools(Context context) {
        this.f1976a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void b(com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a r7) {
        /*
            e.c.d.f.b.a r0 = e.c.d.f.b.a.c()
            java.util.List r0 = r0.b()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004a
            java.lang.Object r2 = r0.next()
            e.c.d.f.d.d r2 = (e.c.d.f.d.d) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r2.f6081a
            r3.append(r4)
            java.lang.String r4 = ".jpg"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.add(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = r2.f6081a
            r3.append(r2)
            java.lang.String r2 = "_thumb.jpg"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.add(r2)
            goto L_0x0011
        L_0x004a:
            java.lang.String r0 = e.c.d.n.e.c()
            java.io.File[] r0 = e.c.b.e.i.f(r0)
            if (r0 == 0) goto L_0x0073
            int r2 = r0.length
            if (r2 > 0) goto L_0x0058
            goto L_0x0073
        L_0x0058:
            int r2 = r0.length
            r3 = 0
            r4 = r3
        L_0x005b:
            if (r4 >= r2) goto L_0x0073
            r5 = r0[r4]
            java.lang.String r6 = r5.getName()
            boolean r6 = r1.contains(r6)
            if (r6 != 0) goto L_0x0070
            boolean r5 = e.c.b.e.i.a(r5)
            if (r5 != 0) goto L_0x0070
            goto L_0x0074
        L_0x0070:
            int r4 = r4 + 1
            goto L_0x005b
        L_0x0073:
            r3 = 1
        L_0x0074:
            if (r3 == 0) goto L_0x007c
            java.lang.String r0 = "0"
            r7.a(r0)
            goto L_0x0081
        L_0x007c:
            java.lang.String r0 = "1"
            r7.a(r0)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.picapture.nativeapi.Tools.b(com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a):void");
    }

    public static String getLanguageJsonString(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("selected", str);
            jSONObject.put("lang", str2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.toString();
            return null;
        }
    }

    public /* synthetic */ void a(UnZipTask unZipTask, a aVar) {
        List list;
        Context context = this.f1976a;
        o oVar = new o(aVar);
        if (TextUtils.isEmpty(unZipTask.getFrom())) {
            oVar.a(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(e.b());
        sb2.append("/download");
        sb.append(sb2.toString());
        sb.append(BceConfig.BOS_DELIMITER);
        sb.append(unZipTask.getFrom());
        String sb3 = sb.toString();
        String d2 = e.d(e.n(unZipTask.getTo()));
        if (TextUtils.isEmpty(unZipTask.getTo()) || !unZipTask.getTo().startsWith("DCIM")) {
            list = Utils.a(sb3, d2, false, unZipTask.isRecursion(), unZipTask.isRemoveSource());
        } else {
            list = Utils.a(sb3, d2, true, unZipTask.isRecursion(), unZipTask.isRemoveSource());
        }
        if (!list.isEmpty()) {
            Utils.a(context, list);
        }
        oVar.a(0);
    }

    @JavascriptInterface
    public void allowCellular(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "is_allow_cellular";
            if (str.equalsIgnoreCase("1")) {
                e.b(str2, true, true);
            } else {
                e.b(str2, false, true);
            }
        }
    }

    @JavascriptInterface
    public void cacheSize(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            aVar.a("1");
            return;
        }
        if (str.equalsIgnoreCase("panotask")) {
            ThreadPoolService.fixedThreadPool.execute(new q(aVar));
        } else {
            aVar.a("0");
        }
    }

    @JavascriptInterface
    public void clearCache(String str, a aVar) {
        String str2 = "1";
        if (TextUtils.isEmpty(str)) {
            aVar.a(str2);
            return;
        }
        if (str.equalsIgnoreCase("panotask")) {
            ThreadPoolService.fixedThreadPool.execute(new p(aVar));
        } else {
            aVar.a(str2);
        }
    }

    @JavascriptInterface
    public void getLanguage(a aVar) {
        String str;
        String d2 = e.d();
        String str2 = LanguageUtils.AUTO;
        if (d2 == null || d2.equals(str2)) {
            String str3 = str2;
            str = LanguageUtils.getSystemLanguageValue(LanguageUtils.getSystemLanguage());
            d2 = str3;
        } else {
            str = d2;
        }
        if (aVar != null) {
            aVar.a(getLanguageJsonString(d2, str));
        }
    }

    @JavascriptInterface
    public void isAllowCellular(a aVar) {
        if (e.a("is_allow_cellular", false, true)) {
            aVar.a("1");
        } else {
            aVar.a("0");
        }
    }

    @JavascriptInterface
    public void saveBase64File(String str, a aVar) {
        String str2 = "to";
        String str3 = WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA;
        String str4 = "1";
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str5 = null;
            String string = jSONObject.has(str3) ? jSONObject.getString(str3) : null;
            if (TextUtils.isEmpty(string)) {
                aVar.a(str4);
                return;
            }
            if (jSONObject.has(str2)) {
                str5 = jSONObject.getString(str2);
            }
            if (TextUtils.isEmpty(str5)) {
                aVar.a(str4);
            } else {
                ThreadPoolService.fixedThreadPool.execute(new m(this, e.n(str5), string, aVar));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            aVar.a(str4);
        }
    }

    @JavascriptInterface
    public void setLanguage(String str, a aVar) {
        Locale locale;
        if (!TextUtils.isEmpty(str)) {
            String systemLanguageValue = str.equals(LanguageUtils.AUTO) ? LanguageUtils.getSystemLanguageValue(LanguageUtils.getSystemLanguage()) : str;
            e.g().edit().putString("app_language", str).apply();
            if (systemLanguageValue.startsWith(LanguageUtils.ZH_REGION)) {
                locale = Locale.CHINA;
            } else {
                locale = Locale.US;
            }
            LanguageUtils.setContextLanguage(this.f1976a, locale);
            LanguageUtils.setContextLanguage(App.f1954b.getBaseContext(), locale);
            if (aVar != null) {
                aVar.a(getLanguageJsonString(str, systemLanguageValue));
            }
        }
    }

    @JavascriptInterface
    public void share(String str, a aVar) {
        try {
            ShareBean shareBean = (ShareBean) new j().a(str, ShareBean.class);
            if (TextUtils.isEmpty(shareBean.getType())) {
                aVar.a(b.PARAM_TYPE_EMPTY.a());
                return;
            }
            ShareEntity shareEntity = new ShareEntity(shareBean.getType(), shareBean.getTitle(), shareBean.getDescription(), shareBean.getImageUrl(), shareBean.getShareUrl());
            e.c.d.d.d.a c2 = Utils.c(this.f1976a, shareBean.getType());
            if (c2 == null) {
                shareBean.getType();
                aVar.a(b.PARAM_TYPE_ERROR.a());
            } else {
                aVar.getClass();
                c2.a(shareEntity, new e.c.d.k.a(aVar));
            }
        } catch (Exception e2) {
            e2.toString();
            aVar.a(b.PARAM_JSON_ERROR.a());
        }
    }

    @JavascriptInterface
    public void unZip(String str, a aVar) {
        ThreadPoolService.fixedThreadPool.execute(new n(this, (UnZipTask) new j().a(str, UnZipTask.class), aVar));
    }

    public static /* synthetic */ void a(a aVar, int i2) {
        if (i2 == 0) {
            aVar.a("0");
        } else {
            aVar.a("1");
        }
    }

    public /* synthetic */ void a(String str, String str2, a aVar) {
        boolean z = false;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            fileOutputStream.write(Base64.decode(str2, 0));
            fileOutputStream.close();
            z = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            Utils.a(this.f1976a, (List<String>) arrayList);
            aVar.a("0");
            return;
        }
        aVar.a("2");
    }

    public static /* synthetic */ void a(a aVar) {
        List<d> b2 = e.c.d.f.b.a.c().b();
        HashSet hashSet = new HashSet();
        for (d dVar : b2) {
            StringBuilder sb = new StringBuilder();
            sb.append(dVar.f6081a);
            sb.append(".jpg");
            hashSet.add(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dVar.f6081a);
            sb2.append("_thumb.jpg");
            hashSet.add(sb2.toString());
        }
        File[] f2 = Utils.f(e.c());
        long j2 = 0;
        if (f2 != null && f2.length > 0) {
            for (File file : f2) {
                if (!hashSet.contains(file.getName())) {
                    j2 += file.length();
                }
            }
        }
        aVar.a(String.valueOf(j2));
    }
}
