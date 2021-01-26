package a.a.a.a.d;

import a.a.a.a.a.g.b;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a reason: collision with root package name */
    public static List<a.a.a.a.a.g.a> f436a = new ArrayList();

    /* renamed from: b reason: collision with root package name */
    public static List<a.a.a.a.a.d.a> f437b = new ArrayList();

    public static a.a.a.a.a.g.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return b.b();
        }
        String str2 = "_";
        String[] split = str.split(str2);
        if (split.length != 3) {
            return b.b();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);
        sb.append(str2);
        sb.append(split[1]);
        String sb2 = sb.toString();
        for (a.a.a.a.a.g.a aVar : f436a) {
            if (((b) aVar) == null) {
                throw null;
            } else if (TextUtils.equals("Original", sb2)) {
                return aVar;
            }
        }
        return b.b();
    }

    public static String a(int i2) {
        return i2 == 0 ? "none" : e.a.a.a.a.a("Beautify", i2);
    }

    public static int b(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("none")) {
            try {
                return Integer.valueOf(str.replaceFirst("Beautify", "")).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public static a.a.a.a.a.d.a c(String str) {
        if (TextUtils.isEmpty(str)) {
            return a.a.a.a.a.d.b.a();
        }
        for (a.a.a.a.a.d.a aVar : f437b) {
            if (((a.a.a.a.a.d.b) aVar) == null) {
                throw null;
            } else if (str.equals("LutOff")) {
                return aVar;
            }
        }
        return a.a.a.a.a.d.b.a();
    }

    public static float d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.7f;
        }
        String[] split = str.split("_");
        if (split.length == 3) {
            try {
                return Float.parseFloat(split[2]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0.7f;
    }

    public static String a(a.a.a.a.a.g.a aVar, float f2) {
        StringBuilder sb = new StringBuilder();
        if (((b) aVar) != null) {
            sb.append("Original");
            sb.append("_");
            sb.append(f2);
            return sb.toString();
        }
        throw null;
    }
}
