package e.g.a.a.a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import d.b.p.r;
import e.c.f.n.n;
import e.g.a.a.b;
import e.g.a.a.j;
import e.g.a.a.k;
import e.g.a.a.z.h;

/* compiled from: MaterialRadioButton */
public class a extends r {

    /* renamed from: f reason: collision with root package name */
    public static final int f8033f = j.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: g reason: collision with root package name */
    public static final int[][] f8034g = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: d reason: collision with root package name */
    public ColorStateList f8035d;

    /* renamed from: e reason: collision with root package name */
    public boolean f8036e;

    public a(Context context, AttributeSet attributeSet) {
        int i2 = b.radioButtonStyle;
        super(h.b(context, attributeSet, i2, f8033f), attributeSet, i2);
        TypedArray b2 = h.b(getContext(), attributeSet, k.MaterialRadioButton, i2, f8033f, new int[0]);
        this.f8036e = b2.getBoolean(k.MaterialRadioButton_useMaterialThemeColors, false);
        b2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f8035d == null) {
            int a2 = n.a((View) this, b.colorControlActivated);
            int a3 = n.a((View) this, b.colorOnSurface);
            int a4 = n.a((View) this, b.colorSurface);
            int[] iArr = new int[f8034g.length];
            iArr[0] = n.a(a4, a2, 1.0f);
            iArr[1] = n.a(a4, a3, 0.54f);
            iArr[2] = n.a(a4, a3, 0.38f);
            iArr[3] = n.a(a4, a3, 0.38f);
            this.f8035d = new ColorStateList(f8034g, iArr);
        }
        return this.f8035d;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8036e && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f8036e = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
