package d.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;
import d.h.f.a;

/* compiled from: ThemeUtils */
public class s0 {

    /* renamed from: a reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f4440a = new ThreadLocal<>();

    /* renamed from: b reason: collision with root package name */
    public static final int[] f4441b = {-16842910};

    /* renamed from: c reason: collision with root package name */
    public static final int[] f4442c = {16842908};

    /* renamed from: d reason: collision with root package name */
    public static final int[] f4443d = {16842919};

    /* renamed from: e reason: collision with root package name */
    public static final int[] f4444e = {16842912};

    /* renamed from: f reason: collision with root package name */
    public static final int[] f4445f = new int[0];

    /* renamed from: g reason: collision with root package name */
    public static final int[] f4446g = new int[1];

    public static int a(Context context, int i2) {
        ColorStateList c2 = c(context, i2);
        if (c2 != null && c2.isStateful()) {
            return c2.getColorForState(f4441b, c2.getDefaultColor());
        }
        TypedValue typedValue = (TypedValue) f4440a.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f4440a.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f2 = typedValue.getFloat();
        int b2 = b(context, i2);
        return a.b(b2, Math.round(((float) Color.alpha(b2)) * f2));
    }

    public static int b(Context context, int i2) {
        int[] iArr = f4446g;
        iArr[0] = i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList c(Context context, int i2) {
        ColorStateList colorStateList;
        int[] iArr = f4446g;
        iArr[0] = i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId != 0) {
                    colorStateList = d.b.l.a.a.a(context, resourceId);
                    if (colorStateList != null) {
                        return colorStateList;
                    }
                }
            }
            colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
