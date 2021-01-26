package e.c.b.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import e.c.b.d;
import e.c.b.f.a;
import java.util.UUID;

public final class j {

    /* renamed from: a reason: collision with root package name */
    public static Context f5918a;

    /* renamed from: b reason: collision with root package name */
    public static SharedPreferences f5919b;

    public static String a() {
        if (!TextUtils.isEmpty(d.f5879c)) {
            StringBuilder sb = new StringBuilder("uid is which user setted ");
            sb.append(d.f5879c);
            a.a(sb.toString());
            return d.f5879c;
        }
        Context context = f5918a;
        if (context == null) {
            a.c("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        }
        if (f5919b == null) {
            f5919b = context.getSharedPreferences("crab_user_info", 0);
        }
        String str = "userId";
        String string = f5919b.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString();
            Utils.a(f5919b.edit().putString(str, string), false);
        }
        StringBuilder sb2 = new StringBuilder("uid is UUID ");
        sb2.append(string);
        a.a(sb2.toString());
        return string;
    }
}
