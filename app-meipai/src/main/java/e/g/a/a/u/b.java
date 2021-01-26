package e.g.a.a.u;

import a.a.a.a.b.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.TextView;
import d.h.k.m;
import e.c.f.n.n;
import e.g.a.a.e0.c;
import e.g.a.a.e0.g;
import e.g.a.a.e0.j;
import e.g.a.a.k;

/* compiled from: CalendarItemStyle */
public final class b {

    /* renamed from: a reason: collision with root package name */
    public final Rect f8320a;

    /* renamed from: b reason: collision with root package name */
    public final ColorStateList f8321b;

    /* renamed from: c reason: collision with root package name */
    public final ColorStateList f8322c;

    /* renamed from: d reason: collision with root package name */
    public final ColorStateList f8323d;

    /* renamed from: e reason: collision with root package name */
    public final int f8324e;

    /* renamed from: f reason: collision with root package name */
    public final j f8325f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, j jVar, Rect rect) {
        a.b(rect.left);
        a.b(rect.top);
        a.b(rect.right);
        a.b(rect.bottom);
        this.f8320a = rect;
        this.f8321b = colorStateList2;
        this.f8322c = colorStateList;
        this.f8323d = colorStateList3;
        this.f8324e = i2;
        this.f8325f = jVar;
    }

    public static b a(Context context, int i2) {
        if (i2 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, k.MaterialCalendarItem);
            Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(k.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(k.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(k.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(k.MaterialCalendarItem_android_insetBottom, 0));
            ColorStateList a2 = n.a(context, obtainStyledAttributes, k.MaterialCalendarItem_itemFillColor);
            ColorStateList a3 = n.a(context, obtainStyledAttributes, k.MaterialCalendarItem_itemTextColor);
            ColorStateList a4 = n.a(context, obtainStyledAttributes, k.MaterialCalendarItem_itemStrokeColor);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(k.MaterialCalendarItem_itemStrokeWidth, 0);
            j a5 = j.a(context, obtainStyledAttributes.getResourceId(k.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(k.MaterialCalendarItem_itemShapeAppearanceOverlay, 0), (c) new e.g.a.a.e0.a((float) 0)).a();
            obtainStyledAttributes.recycle();
            b bVar = new b(a2, a3, a4, dimensionPixelSize, a5, rect);
            return bVar;
        }
        throw new IllegalArgumentException("Cannot create a CalendarItemStyle with a styleResId of 0");
    }

    public void a(TextView textView) {
        g gVar = new g();
        g gVar2 = new g();
        gVar.setShapeAppearanceModel(this.f8325f);
        gVar2.setShapeAppearanceModel(this.f8325f);
        gVar.a(this.f8322c);
        gVar.a((float) this.f8324e, this.f8323d);
        textView.setTextColor(this.f8321b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f8321b.withAlpha(30), gVar, gVar2);
        Rect rect = this.f8320a;
        InsetDrawable insetDrawable = new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        m.a((View) textView, (Drawable) insetDrawable);
    }
}
