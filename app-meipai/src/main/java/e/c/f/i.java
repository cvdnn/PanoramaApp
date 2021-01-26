package e.c.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import e.c.f.g.b;
import e.c.f.n.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Preferences */
public final class i {

    /* renamed from: a reason: collision with root package name */
    public SharedPreferences f7007a;

    /* renamed from: b reason: collision with root package name */
    public SharedPreferences f7008b;

    /* renamed from: c reason: collision with root package name */
    public Editor f7009c;

    /* renamed from: d reason: collision with root package name */
    public Editor f7010d;

    /* renamed from: e reason: collision with root package name */
    public SharedPreferences f7011e;

    /* renamed from: f reason: collision with root package name */
    public Editor f7012f;

    /* renamed from: g reason: collision with root package name */
    public Context f7013g;

    public i(Context context) {
        String str = "leroadcfg";
        try {
            this.f7013g = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 4);
            this.f7007a = sharedPreferences;
            this.f7009c = sharedPreferences.edit();
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 4);
            this.f7008b = sharedPreferences2;
            this.f7010d = sharedPreferences2.edit();
            SharedPreferences sharedPreferences3 = context.getSharedPreferences("re_po_rt", 4);
            this.f7011e = sharedPreferences3;
            this.f7012f = sharedPreferences3.edit();
        } catch (Throwable th) {
            th.getMessage();
            c.c();
        }
    }

    public final void a(int i2) {
        this.f7009c.putInt("wi_fa_pu_ap", i2);
        this.f7009c.commit();
    }

    public final boolean b() {
        return this.f7007a.getBoolean("bka", true);
    }

    public final int c() {
        return this.f7007a.getInt("wi_fa_pu_ap", 0);
    }

    public final int d() {
        return this.f7007a.getInt("mo_fa_pu_ap", 0);
    }

    public final String e() {
        return this.f7008b.getString("xyus", "");
    }

    public final List<Integer> f() {
        ArrayList arrayList = new ArrayList();
        String string = this.f7007a.getString("hcpk", "");
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split("-");
            if (split != null && split.length > 0) {
                for (int i2 = 0; i2 < split.length; i2++) {
                    try {
                        arrayList.add(Integer.valueOf(Integer.parseInt(split[i2])));
                    } catch (NumberFormatException e2) {
                        e2.getMessage();
                        c.c();
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<Integer> g() {
        ArrayList arrayList = new ArrayList();
        String string = this.f7007a.getString("glspk", "");
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split("-");
            if (split != null && split.length > 0) {
                for (int i2 = 0; i2 < split.length; i2++) {
                    try {
                        arrayList.add(Integer.valueOf(Integer.parseInt(split[i2])));
                    } catch (NumberFormatException e2) {
                        e2.getMessage();
                        c.c();
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<b> h() {
        String[] split;
        String string = this.f7011e.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : string.split("\\|\\|")) {
            if (!TextUtils.isEmpty(str)) {
                b bVar = new b();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    bVar.f6997a = jSONObject.optString("0");
                    bVar.f6999c = jSONObject.optString("1");
                    bVar.f7000d = jSONObject.optString("2");
                    bVar.f7001e = jSONObject.optString("3");
                    bVar.f6998b = jSONObject.optString("4");
                } catch (Exception unused) {
                    c.d();
                    bVar = null;
                }
                if (bVar != null) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public final int i() {
        String str = "re_net_hr";
        int i2 = 24;
        if ("com.baidu.BaiduMap.meizu".equals(this.f7013g.getPackageName())) {
            return this.f7011e.getInt(str, 24);
        }
        int i3 = this.f7011e.getInt(str, 3);
        try {
            String[] e2 = a.e(this.f7013g);
            if (e2 == null || e2.length != 2 || TextUtils.isEmpty(e2[0]) || TextUtils.isEmpty(e2[1]) || !"200080".equals(e2[0]) || !"com.baidu.BaiduMap".equals(this.f7013g.getPackageName()) || i3 >= 24) {
                i2 = i3;
            }
            i3 = i2;
        } catch (Throwable unused) {
        }
        return i3;
    }

    public final void b(int i2) {
        this.f7009c.putInt("mo_fa_pu_ap", i2);
        this.f7009c.commit();
    }

    public final void c(int i2) {
        this.f7009c.putInt("sustfd", i2);
        this.f7009c.commit();
    }

    public final void d(int i2) {
        this.f7009c.putInt("sufzfd", i2);
        this.f7009c.commit();
    }

    public final void a(int... iArr) {
        String str = "hcpk";
        if (iArr == null || iArr.length == 0) {
            this.f7009c.putString(str, "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                sb.append(iArr[i2]);
                if (i2 != iArr.length - 1) {
                    sb.append("-");
                }
            }
            this.f7009c.putString(str, sb.toString());
        }
        this.f7009c.commit();
    }

    public final void a(int i2, int i3, int i4) {
        String str = i2 != 0 ? i2 != 1 ? "" : "suetfite" : "sustfits";
        if (!TextUtils.isEmpty(str)) {
            Editor editor = this.f7009c;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(i3);
            editor.putInt(sb.toString(), i4);
            this.f7009c.commit();
        }
    }

    public final int a(int i2, int i3) {
        String str = i2 != 0 ? i2 != 1 ? "" : "suetfite" : "sustfits";
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        SharedPreferences sharedPreferences = this.f7007a;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i3);
        return sharedPreferences.getInt(sb.toString(), 0);
    }

    public final void a(b bVar) {
        String str = "re_con";
        String string = this.f7011e.getString(str, "");
        Editor editor = this.f7012f;
        StringBuilder b2 = e.a.a.a.a.b(string, "||");
        b2.append(b.a(bVar));
        editor.putString(str, b2.toString());
        this.f7012f.commit();
    }

    public final String a(String str) {
        SharedPreferences sharedPreferences = this.f7011e;
        StringBuilder sb = new StringBuilder("al_da");
        sb.append(str);
        return sharedPreferences.getString(sb.toString(), "");
    }

    public final boolean a() {
        return this.f7007a.getBoolean("s_c_c", true);
    }
}
