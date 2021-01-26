package e.c.f.k;

import android.content.Context;
import android.text.TextUtils;
import e.c.d.n.e;
import e.c.f.c;
import org.json.JSONObject;

/* compiled from: ReportEngine */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public Context f7027a;

    public a(Context context) {
        this.f7027a = context;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        new StringBuilder().append(str);
        c.a();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(e.c.f.n.a.b());
            sb.append("p/1/r");
            String sb2 = sb.toString();
            new StringBuilder().append(sb2);
            String a2 = e.a(this.f7027a, sb2, str, false);
            if (!TextUtils.isEmpty(a2) && new JSONObject(a2).getInt("response") == 1) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            c.d();
            return true;
        }
    }
}
