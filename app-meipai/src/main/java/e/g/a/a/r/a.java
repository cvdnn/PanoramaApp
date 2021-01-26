package e.g.a.a.r;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import d.b.p.g;
import e.c.f.n.n;
import e.g.a.a.b;
import e.g.a.a.j;
import e.g.a.a.k;
import e.g.a.a.z.h;

/* compiled from: MaterialCheckBox */
public class a extends g {

    /* renamed from: f reason: collision with root package name */
    public static final int f8301f = j.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: g reason: collision with root package name */
    public static final int[][] f8302g = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: d reason: collision with root package name */
    public ColorStateList f8303d;

    /* renamed from: e reason: collision with root package name */
    public boolean f8304e;

    public a(Context context, AttributeSet attributeSet) {
        int i2 = b.checkboxStyle;
        super(h.b(context, attributeSet, i2, f8301f), attributeSet, i2);
        Context context2 = getContext();
        TypedArray b2 = h.b(context2, attributeSet, k.MaterialCheckBox, i2, f8301f, new int[0]);
        if (b2.hasValue(k.MaterialCheckBox_buttonTint)) {
            setButtonTintList(n.a(context2, b2, k.MaterialCheckBox_buttonTint));
        }
        this.f8304e = b2.getBoolean(k.MaterialCheckBox_useMaterialThemeColors, false);
        b2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f8303d == null) {
            int[] iArr = new int[f8302g.length];
            int a2 = n.a((View) this, b.colorControlActivated);
            int a3 = n.a((View) this, b.colorSurface);
            int a4 = n.a((View) this, b.colorOnSurface);
            iArr[0] = n.a(a3, a2, 1.0f);
            iArr[1] = n.a(a3, a4, 0.54f);
            iArr[2] = n.a(a3, a4, 0.38f);
            iArr[3] = n.a(a3, a4, 0.38f);
            this.f8303d = new ColorStateList(f8302g, iArr);
        }
        return this.f8303d;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8304e && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f8304e = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
