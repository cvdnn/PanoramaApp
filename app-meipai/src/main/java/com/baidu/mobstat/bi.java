package com.baidu.mobstat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidubce.BceConfig;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bi {

    /* renamed from: a reason: collision with root package name */
    public boolean f1729a;

    /* renamed from: b reason: collision with root package name */
    public List<b> f1730b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    public String f1731c;

    /* renamed from: d reason: collision with root package name */
    public bk f1732d;

    /* renamed from: e reason: collision with root package name */
    public boolean f1733e;

    public interface a {
        void a(View view, boolean z);
    }

    public class b {

        /* renamed from: a reason: collision with root package name */
        public String f1734a;

        /* renamed from: b reason: collision with root package name */
        public String f1735b;

        /* renamed from: c reason: collision with root package name */
        public boolean f1736c;

        /* renamed from: d reason: collision with root package name */
        public int f1737d;

        public b(String str, String str2, boolean z, int i2) {
            this.f1734a = str;
            this.f1735b = str2;
            this.f1736c = z;
            this.f1737d = i2;
        }
    }

    public static class c {

        /* renamed from: a reason: collision with root package name */
        public String f1739a;

        /* renamed from: b reason: collision with root package name */
        public String f1740b;

        /* renamed from: c reason: collision with root package name */
        public String f1741c;

        /* renamed from: d reason: collision with root package name */
        public c f1742d;

        public c(View view, c cVar, View view2) {
            this.f1742d = cVar;
            this.f1739a = bj.l(view);
            this.f1740b = bj.b(view);
            String c2 = bj.c(view);
            if (TextUtils.isEmpty(c2)) {
                c2 = bj.a(view, c());
                if (TextUtils.isEmpty(c2)) {
                    c2 = bj.a(view, view2);
                }
            }
            this.f1741c = c2;
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (c cVar = this; cVar != null; cVar = cVar.f1742d) {
                sb.insert(0, cVar.a(false));
            }
            return sb.toString();
        }

        public String b() {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (c cVar = this; cVar != null; cVar = cVar.f1742d) {
                boolean z2 = true;
                if (!z) {
                    String c2 = cVar.c();
                    if ("ListView".equals(c2) || RecyclerView.TAG.equals(c2) || "GridView".equals(c2)) {
                        z = true;
                        sb.insert(0, cVar.a(z2));
                    }
                }
                z2 = false;
                sb.insert(0, cVar.a(z2));
            }
            return sb.toString();
        }

        public String c() {
            c cVar = this.f1742d;
            return cVar == null ? "" : cVar.f1740b;
        }

        public String a(boolean z) {
            StringBuilder a2 = e.a.a.a.a.a(BceConfig.BOS_DELIMITER);
            a2.append(this.f1739a);
            if (!z) {
                a2.append("[");
                a2.append(this.f1741c);
                a2.append("]");
            }
            return a2.toString();
        }
    }

    public bi(Activity activity, bk bkVar, boolean z) {
        this.f1731c = activity.getClass().getName();
        this.f1732d = bkVar;
        this.f1733e = z;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1729a = ((JSONObject) jSONObject.get("meta")).getInt("matchAll") != 0;
            } catch (Exception unused) {
            }
            if (!this.f1729a) {
                try {
                    JSONArray jSONArray = (JSONArray) jSONObject.get(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        String optString = jSONObject2.optString("page");
                        String optString2 = jSONObject2.optString("layout");
                        int optInt = jSONObject2.optInt("contentAsLabel");
                        boolean z = jSONObject2.optInt("ignoreCellIndex") != 0;
                        if (this.f1731c.equals(optString)) {
                            b bVar = new b(optString, optString2, z, optInt);
                            this.f1730b.add(bVar);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    public void a(Activity activity) {
        if (!this.f1733e && !this.f1729a) {
            List<b> list = this.f1730b;
            if (list == null || list.size() == 0) {
                return;
            }
        }
        View a2 = bj.a(activity);
        a(activity, a2, null, a2);
    }

    private void a(Activity activity, View view, c cVar, View view2) {
        if (view != null && !ai.a(view) && !bj.c(activity, view)) {
            c cVar2 = new c(view, cVar, view2);
            if (cVar != null) {
                boolean b2 = this.f1729a ? bj.b(view, cVar2.c()) : a(this.f1730b, cVar2.a(), cVar2.b());
                if (b2 || this.f1733e) {
                    String str = "; content:";
                    String str2 = "accumulate view:";
                    if (bd.c().b() && b2) {
                        bd c2 = bd.c();
                        StringBuilder a2 = e.a.a.a.a.a(str2);
                        a2.append(view.getClass().getName());
                        a2.append(str);
                        a2.append(bj.h(view));
                        c2.a(a2.toString());
                    }
                    if (bh.c().b()) {
                        bh c3 = bh.c();
                        StringBuilder a3 = e.a.a.a.a.a(str2);
                        a3.append(view.getClass().getName());
                        a3.append(str);
                        a3.append(bj.h(view));
                        c3.a(a3.toString());
                    }
                    this.f1732d.a(view, b2);
                }
            }
            if (!(view instanceof WebView) && (view instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    a(activity, viewGroup.getChildAt(i2), cVar2, view2);
                }
            }
        }
    }

    private boolean a(List<b> list, String str, String str2) {
        for (b bVar : list) {
            String str3 = bVar.f1736c ? str2 : str;
            if (!TextUtils.isEmpty(str3) && str3.equals(bVar.f1735b)) {
                return true;
            }
        }
        return false;
    }
}
