package e.c.f.f;

import android.content.IntentFilter;
import android.text.TextUtils;
import e.c.f.c;

/* compiled from: PluginloaderIntentFilter */
public final class h {

    /* renamed from: a reason: collision with root package name */
    public String f6988a;

    /* renamed from: b reason: collision with root package name */
    public String f6989b;

    /* renamed from: c reason: collision with root package name */
    public String f6990c;

    /* renamed from: d reason: collision with root package name */
    public IntentFilter f6991d;

    public h(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f6988a = str;
        this.f6991d = intentFilter;
        this.f6989b = str2;
        this.f6990c = str3;
    }

    public final boolean a(h hVar) {
        if (hVar != null) {
            try {
                if (!TextUtils.isEmpty(hVar.f6988a) && !TextUtils.isEmpty(hVar.f6989b)) {
                    if (!TextUtils.isEmpty(hVar.f6990c)) {
                        if (hVar.f6988a.equals(this.f6988a) && hVar.f6989b.equals(this.f6989b)) {
                            if (hVar.f6990c.equals(this.f6990c)) {
                                if (hVar.f6991d != null) {
                                    if (this.f6991d != null) {
                                        if (this.f6991d == hVar.f6991d) {
                                            return true;
                                        }
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                        return false;
                    }
                }
            } catch (Throwable unused) {
                c.d();
            }
        }
        return false;
    }

    public final String toString() {
        String str = "-";
        try {
            StringBuilder sb = new StringBuilder("PluginloaderIntentFilter:");
            sb.append(this.f6988a);
            sb.append(str);
            sb.append(this.f6989b);
            sb.append(str);
            sb.append(this.f6990c);
            sb.append(str);
            sb.append(this.f6991d);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
