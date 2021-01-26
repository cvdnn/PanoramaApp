package e.l.a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import e.a.a.a.a;
import e.l.a.i.d;
import e.l.a.i.e;
import e.l.a.m.c;

/* compiled from: AndPermission */
public class b {

    /* renamed from: a reason: collision with root package name */
    public static final e f8923a = new d();

    public static String a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".andpermission.bridge");
        sb.append(TextUtils.isEmpty(str) ? "" : a.a(".", str));
        return sb.toString();
    }

    public static e.l.a.j.a a(Activity activity) {
        return new c(new e.l.a.m.a(activity));
    }

    public static boolean a(Activity activity, String... strArr) {
        return f8923a.a(activity, strArr);
    }

    public static c a(Context context) {
        if (context instanceof Activity) {
            return new e.l.a.m.a((Activity) context);
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return new e.l.a.m.b(context);
    }
}
