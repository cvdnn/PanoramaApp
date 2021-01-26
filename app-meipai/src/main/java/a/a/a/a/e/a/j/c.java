package a.a.a.a.e.a.j;

import android.text.TextUtils;

public enum c {
    LINEAR("linear"),
    QUARTIC_EASE_IN("QuarticEaseIn"),
    QUARTIC_EASE_IN_OUT("QuarticEaseInOut"),
    QUARTIC_EASE_OUT("QuarticEaseOut"),
    SLIP_IN_SLIP_OUT_INTERPOLATOR("SlipInSlipOutInterpolator");
    

    /* renamed from: a reason: collision with root package name */
    public String f633a;

    /* access modifiers changed from: public */
    c(String str) {
        this.f633a = str;
    }

    public static c a(String str) {
        c[] values;
        if (TextUtils.isEmpty(str)) {
            return LINEAR;
        }
        for (c cVar : values()) {
            if (TextUtils.equals(str, cVar.f633a)) {
                return cVar;
            }
        }
        return LINEAR;
    }
}
