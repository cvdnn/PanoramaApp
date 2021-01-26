package d.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import d.b.l.a.a;
import d.h.e.b.g;

/* compiled from: TintTypedArray */
public class x0 {

    /* renamed from: a reason: collision with root package name */
    public final Context f4484a;

    /* renamed from: b reason: collision with root package name */
    public final TypedArray f4485b;

    /* renamed from: c reason: collision with root package name */
    public TypedValue f4486c;

    public x0(Context context, TypedArray typedArray) {
        this.f4484a = context;
        this.f4485b = typedArray;
    }

    public static x0 a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new x0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public Drawable b(int i2) {
        if (this.f4485b.hasValue(i2)) {
            int resourceId = this.f4485b.getResourceId(i2, 0);
            if (resourceId != 0) {
                return a.b(this.f4484a, resourceId);
            }
        }
        return this.f4485b.getDrawable(i2);
    }

    public Drawable c(int i2) {
        if (this.f4485b.hasValue(i2)) {
            int resourceId = this.f4485b.getResourceId(i2, 0);
            if (resourceId != 0) {
                return j.a().a(this.f4484a, resourceId, true);
            }
        }
        return null;
    }

    public String d(int i2) {
        return this.f4485b.getString(i2);
    }

    public CharSequence e(int i2) {
        return this.f4485b.getText(i2);
    }

    public int f(int i2, int i3) {
        return this.f4485b.getResourceId(i2, i3);
    }

    public static x0 a(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new x0(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public int d(int i2, int i3) {
        return this.f4485b.getInt(i2, i3);
    }

    public int e(int i2, int i3) {
        return this.f4485b.getLayoutDimension(i2, i3);
    }

    public boolean f(int i2) {
        return this.f4485b.hasValue(i2);
    }

    public Typeface a(int i2, int i3, g gVar) {
        int resourceId = this.f4485b.getResourceId(i2, 0);
        Typeface typeface = null;
        if (resourceId == 0) {
            return null;
        }
        if (this.f4486c == null) {
            this.f4486c = new TypedValue();
        }
        Context context = this.f4484a;
        TypedValue typedValue = this.f4486c;
        if (!context.isRestricted()) {
            typeface = a.a.a.a.b.a.a(context, resourceId, typedValue, i3, gVar, (Handler) null, true);
        }
        return typeface;
    }

    public int c(int i2, int i3) {
        return this.f4485b.getDimensionPixelSize(i2, i3);
    }

    public int b(int i2, int i3) {
        return this.f4485b.getDimensionPixelOffset(i2, i3);
    }

    public boolean a(int i2, boolean z) {
        return this.f4485b.getBoolean(i2, z);
    }

    public int a(int i2, int i3) {
        return this.f4485b.getColor(i2, i3);
    }

    public ColorStateList a(int i2) {
        if (this.f4485b.hasValue(i2)) {
            int resourceId = this.f4485b.getResourceId(i2, 0);
            if (resourceId != 0) {
                ColorStateList a2 = a.a(this.f4484a, resourceId);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return this.f4485b.getColorStateList(i2);
    }

    public float a(int i2, float f2) {
        return this.f4485b.getDimension(i2, f2);
    }
}
