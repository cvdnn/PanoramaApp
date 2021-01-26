package d.h.i;

import android.text.TextUtils;
import java.util.Locale;

/* compiled from: TextUtilsCompat */
public final class e {

    /* renamed from: a reason: collision with root package name */
    public static final Locale f4900a;

    static {
        String str = "";
        f4900a = new Locale(str, str);
    }

    public static int a(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
