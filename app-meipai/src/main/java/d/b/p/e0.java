package d.b.p;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.ScaleDrawable;
import d.b.m.a.c;
import d.h.f.i.a;

@SuppressLint({"RestrictedAPI"})
/* compiled from: DrawableUtils */
public class e0 {

    /* renamed from: a reason: collision with root package name */
    public static final int[] f4317a = {16842912};

    /* renamed from: b reason: collision with root package name */
    public static final int[] f4318b = new int[0];

    static {
        new Rect();
        try {
            Class.forName("android.graphics.Insets");
        } catch (ClassNotFoundException unused) {
        }
    }

    public static boolean a(Drawable drawable) {
        if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainerState) {
                for (Drawable a2 : ((DrawableContainerState) constantState).getChildren()) {
                    if (!a(a2)) {
                        return false;
                    }
                }
            }
        } else if (drawable instanceof a) {
            return a(((a) drawable).a());
        } else {
            if (drawable instanceof c) {
                return a(((c) drawable).f4093a);
            }
            if (drawable instanceof ScaleDrawable) {
                return a(((ScaleDrawable) drawable).getDrawable());
            }
        }
        return true;
    }

    public static void b(Drawable drawable) {
    }

    public static Mode a(int i2, Mode mode) {
        if (i2 == 3) {
            return Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return Mode.SRC_IN;
        }
        if (i2 == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }
}
