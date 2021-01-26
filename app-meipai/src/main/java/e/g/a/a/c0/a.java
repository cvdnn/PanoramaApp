package e.g.a.a.c0;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.Log;

/* compiled from: RippleUtils */
public class a {

    /* renamed from: a reason: collision with root package name */
    public static final boolean f8055a = true;

    /* renamed from: b reason: collision with root package name */
    public static final int[] f8056b = {16842910, 16842919};

    /* renamed from: c reason: collision with root package name */
    public static final String f8057c = a.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f8056b, 0)) != 0) {
            Log.w(f8057c, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean a(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
