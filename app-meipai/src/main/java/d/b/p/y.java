package d.b.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import d.b.j;
import d.h.e.b.g;
import d.h.l.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: AppCompatTextHelper */
public class y {

    /* renamed from: a reason: collision with root package name */
    public final TextView f4487a;

    /* renamed from: b reason: collision with root package name */
    public v0 f4488b;

    /* renamed from: c reason: collision with root package name */
    public v0 f4489c;

    /* renamed from: d reason: collision with root package name */
    public v0 f4490d;

    /* renamed from: e reason: collision with root package name */
    public v0 f4491e;

    /* renamed from: f reason: collision with root package name */
    public v0 f4492f;

    /* renamed from: g reason: collision with root package name */
    public v0 f4493g;

    /* renamed from: h reason: collision with root package name */
    public v0 f4494h;

    /* renamed from: i reason: collision with root package name */
    public final a0 f4495i;

    /* renamed from: j reason: collision with root package name */
    public int f4496j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    /* compiled from: AppCompatTextHelper */
    public static class a extends g {

        /* renamed from: a reason: collision with root package name */
        public final WeakReference<y> f4497a;

        /* renamed from: b reason: collision with root package name */
        public final int f4498b;

        /* renamed from: c reason: collision with root package name */
        public final int f4499c;

        /* renamed from: d.b.p.y$a$a reason: collision with other inner class name */
        /* compiled from: AppCompatTextHelper */
        public class C0030a implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final WeakReference<y> f4500a;

            /* renamed from: b reason: collision with root package name */
            public final Typeface f4501b;

            public C0030a(a aVar, WeakReference<y> weakReference, Typeface typeface) {
                this.f4500a = weakReference;
                this.f4501b = typeface;
            }

            public void run() {
                y yVar = (y) this.f4500a.get();
                if (yVar != null) {
                    Typeface typeface = this.f4501b;
                    if (yVar.m) {
                        yVar.f4487a.setTypeface(typeface);
                        yVar.l = typeface;
                    }
                }
            }
        }

        public a(y yVar, int i2, int i3) {
            this.f4497a = new WeakReference<>(yVar);
            this.f4498b = i2;
            this.f4499c = i3;
        }

        public void a(int i2) {
        }

        public void a(Typeface typeface) {
            y yVar = (y) this.f4497a.get();
            if (yVar != null) {
                if (VERSION.SDK_INT >= 28) {
                    int i2 = this.f4498b;
                    if (i2 != -1) {
                        typeface = Typeface.create(typeface, i2, (this.f4499c & 2) != 0);
                    }
                }
                yVar.f4487a.post(new C0030a(this, this.f4497a, typeface));
            }
        }
    }

    public y(TextView textView) {
        this.f4487a = textView;
        this.f4495i = new a0(this.f4487a);
    }

    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i2) {
        String str;
        String str2;
        boolean z;
        boolean z2;
        AttributeSet attributeSet2 = attributeSet;
        int i3 = i2;
        Context context = this.f4487a.getContext();
        j a2 = j.a();
        x0 a3 = x0.a(context, attributeSet2, j.AppCompatTextHelper, i3, 0);
        int f2 = a3.f(j.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.f(j.AppCompatTextHelper_android_drawableLeft)) {
            this.f4488b = a(context, a2, a3.f(j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.f(j.AppCompatTextHelper_android_drawableTop)) {
            this.f4489c = a(context, a2, a3.f(j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.f(j.AppCompatTextHelper_android_drawableRight)) {
            this.f4490d = a(context, a2, a3.f(j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.f(j.AppCompatTextHelper_android_drawableBottom)) {
            this.f4491e = a(context, a2, a3.f(j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (a3.f(j.AppCompatTextHelper_android_drawableStart)) {
            this.f4492f = a(context, a2, a3.f(j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (a3.f(j.AppCompatTextHelper_android_drawableEnd)) {
            this.f4493g = a(context, a2, a3.f(j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        a3.f4485b.recycle();
        boolean z3 = this.f4487a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (f2 != -1) {
            x0 x0Var = new x0(context, context.obtainStyledAttributes(f2, j.TextAppearance));
            if (z3 || !x0Var.f(j.TextAppearance_textAllCaps)) {
                z2 = false;
                z = false;
            } else {
                z2 = x0Var.a(j.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, x0Var);
            str2 = x0Var.f(j.TextAppearance_textLocale) ? x0Var.d(j.TextAppearance_textLocale) : null;
            str = (VERSION.SDK_INT < 26 || !x0Var.f(j.TextAppearance_fontVariationSettings)) ? null : x0Var.d(j.TextAppearance_fontVariationSettings);
            x0Var.f4485b.recycle();
        } else {
            z2 = false;
            z = false;
            str2 = null;
            str = null;
        }
        x0 x0Var2 = new x0(context, context.obtainStyledAttributes(attributeSet2, j.TextAppearance, i3, 0));
        if (!z3 && x0Var2.f(j.TextAppearance_textAllCaps)) {
            z2 = x0Var2.a(j.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (x0Var2.f(j.TextAppearance_textLocale)) {
            str2 = x0Var2.d(j.TextAppearance_textLocale);
        }
        if (VERSION.SDK_INT >= 26 && x0Var2.f(j.TextAppearance_fontVariationSettings)) {
            str = x0Var2.d(j.TextAppearance_fontVariationSettings);
        }
        if (VERSION.SDK_INT >= 28 && x0Var2.f(j.TextAppearance_android_textSize) && x0Var2.c(j.TextAppearance_android_textSize, -1) == 0) {
            this.f4487a.setTextSize(0, 0.0f);
        }
        a(context, x0Var2);
        x0Var2.f4485b.recycle();
        if (!z3 && z) {
            this.f4487a.setAllCaps(z2);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.f4487a.setTypeface(typeface, this.f4496j);
            } else {
                this.f4487a.setTypeface(typeface);
            }
        }
        if (str != null) {
            this.f4487a.setFontVariationSettings(str);
        }
        if (str2 != null) {
            if (VERSION.SDK_INT >= 24) {
                this.f4487a.setTextLocales(LocaleList.forLanguageTags(str2));
            } else {
                this.f4487a.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
            }
        }
        a0 a0Var = this.f4495i;
        TypedArray obtainStyledAttributes = a0Var.f4277j.obtainStyledAttributes(attributeSet2, j.AppCompatTextView, i3, 0);
        if (obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeTextType)) {
            a0Var.f4268a = obtainStyledAttributes.getInt(j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizePresetSizes)) {
            int resourceId = obtainStyledAttributes.getResourceId(j.AppCompatTextView_autoSizePresetSizes, 0);
            if (resourceId > 0) {
                TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
                int length = obtainTypedArray.length();
                int[] iArr = new int[length];
                if (length > 0) {
                    for (int i4 = 0; i4 < length; i4++) {
                        iArr[i4] = obtainTypedArray.getDimensionPixelSize(i4, -1);
                    }
                    a0Var.f4273f = a0Var.a(iArr);
                    a0Var.c();
                }
                obtainTypedArray.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        if (!a0Var.d()) {
            a0Var.f4268a = 0;
        } else if (a0Var.f4268a == 1) {
            if (!a0Var.f4274g) {
                DisplayMetrics displayMetrics = a0Var.f4277j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                a0Var.a(dimension2, dimension3, dimension);
            }
            a0Var.b();
        }
        if (b.a0) {
            a0 a0Var2 = this.f4495i;
            if (a0Var2.f4268a != 0) {
                int[] iArr2 = a0Var2.f4273f;
                if (iArr2.length > 0) {
                    if (((float) this.f4487a.getAutoSizeStepGranularity()) != -1.0f) {
                        this.f4487a.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.f4495i.f4271d), Math.round(this.f4495i.f4272e), Math.round(this.f4495i.f4270c), 0);
                    } else {
                        this.f4487a.setAutoSizeTextTypeUniformWithPresetSizes(iArr2, 0);
                    }
                }
            }
        }
        x0 x0Var3 = new x0(context, context.obtainStyledAttributes(attributeSet2, j.AppCompatTextView));
        int f3 = x0Var3.f(j.AppCompatTextView_drawableLeftCompat, -1);
        Drawable a4 = f3 != -1 ? a2.a(context, f3) : null;
        int f4 = x0Var3.f(j.AppCompatTextView_drawableTopCompat, -1);
        Drawable a5 = f4 != -1 ? a2.a(context, f4) : null;
        int f5 = x0Var3.f(j.AppCompatTextView_drawableRightCompat, -1);
        Drawable a6 = f5 != -1 ? a2.a(context, f5) : null;
        int f6 = x0Var3.f(j.AppCompatTextView_drawableBottomCompat, -1);
        Drawable a7 = f6 != -1 ? a2.a(context, f6) : null;
        int f7 = x0Var3.f(j.AppCompatTextView_drawableStartCompat, -1);
        Drawable a8 = f7 != -1 ? a2.a(context, f7) : null;
        int f8 = x0Var3.f(j.AppCompatTextView_drawableEndCompat, -1);
        Drawable a9 = f8 != -1 ? a2.a(context, f8) : null;
        if (a8 != null || a9 != null) {
            Drawable[] compoundDrawablesRelative = this.f4487a.getCompoundDrawablesRelative();
            TextView textView = this.f4487a;
            if (a8 == null) {
                a8 = compoundDrawablesRelative[0];
            }
            if (a5 == null) {
                a5 = compoundDrawablesRelative[1];
            }
            if (a9 == null) {
                a9 = compoundDrawablesRelative[2];
            }
            if (a7 == null) {
                a7 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(a8, a5, a9, a7);
        } else if (!(a4 == null && a5 == null && a6 == null && a7 == null)) {
            Drawable[] compoundDrawablesRelative2 = this.f4487a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.f4487a.getCompoundDrawables();
                TextView textView2 = this.f4487a;
                if (a4 == null) {
                    a4 = compoundDrawables[0];
                }
                if (a5 == null) {
                    a5 = compoundDrawables[1];
                }
                if (a6 == null) {
                    a6 = compoundDrawables[2];
                }
                if (a7 == null) {
                    a7 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(a4, a5, a6, a7);
            } else {
                TextView textView3 = this.f4487a;
                Drawable drawable = compoundDrawablesRelative2[0];
                if (a5 == null) {
                    a5 = compoundDrawablesRelative2[1];
                }
                Drawable drawable2 = compoundDrawablesRelative2[2];
                if (a7 == null) {
                    a7 = compoundDrawablesRelative2[3];
                }
                textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, a5, drawable2, a7);
            }
        }
        if (x0Var3.f(j.AppCompatTextView_drawableTint)) {
            ColorStateList a10 = x0Var3.a(j.AppCompatTextView_drawableTint);
            TextView textView4 = this.f4487a;
            if (textView4 != null) {
                textView4.setCompoundDrawableTintList(a10);
            } else {
                throw null;
            }
        }
        if (x0Var3.f(j.AppCompatTextView_drawableTintMode)) {
            Mode a11 = e0.a(x0Var3.d(j.AppCompatTextView_drawableTintMode, -1), null);
            TextView textView5 = this.f4487a;
            if (textView5 != null) {
                textView5.setCompoundDrawableTintMode(a11);
            } else {
                throw null;
            }
        }
        int c2 = x0Var3.c(j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int c3 = x0Var3.c(j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int c4 = x0Var3.c(j.AppCompatTextView_lineHeight, -1);
        x0Var3.f4485b.recycle();
        if (c2 != -1) {
            a.a.a.a.b.a.a(this.f4487a, c2);
        }
        if (c3 != -1) {
            a.a.a.a.b.a.b(this.f4487a, c3);
        }
        if (c4 != -1) {
            a.a.a.a.b.a.c(this.f4487a, c4);
        }
    }

    public boolean b() {
        a0 a0Var = this.f4495i;
        return a0Var.d() && a0Var.f4268a != 0;
    }

    public final void a(Context context, x0 x0Var) {
        this.f4496j = x0Var.d(j.TextAppearance_android_textStyle, this.f4496j);
        boolean z = false;
        if (VERSION.SDK_INT >= 28) {
            int d2 = x0Var.d(j.TextAppearance_android_textFontWeight, -1);
            this.k = d2;
            if (d2 != -1) {
                this.f4496j = (this.f4496j & 2) | 0;
            }
        }
        if (x0Var.f(j.TextAppearance_android_fontFamily) || x0Var.f(j.TextAppearance_fontFamily)) {
            this.l = null;
            int i2 = x0Var.f(j.TextAppearance_fontFamily) ? j.TextAppearance_fontFamily : j.TextAppearance_android_fontFamily;
            int i3 = this.k;
            int i4 = this.f4496j;
            if (!context.isRestricted()) {
                try {
                    Typeface a2 = x0Var.a(i2, this.f4496j, (g) new a(this, i3, i4));
                    if (a2 != null) {
                        if (VERSION.SDK_INT < 28 || this.k == -1) {
                            this.l = a2;
                        } else {
                            this.l = Typeface.create(Typeface.create(a2, 0), this.k, (this.f4496j & 2) != 0);
                        }
                    }
                    this.m = this.l == null;
                } catch (NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.l == null) {
                String d3 = x0Var.d(i2);
                if (d3 != null) {
                    if (VERSION.SDK_INT < 28 || this.k == -1) {
                        this.l = Typeface.create(d3, this.f4496j);
                    } else {
                        Typeface create = Typeface.create(d3, 0);
                        int i5 = this.k;
                        if ((this.f4496j & 2) != 0) {
                            z = true;
                        }
                        this.l = Typeface.create(create, i5, z);
                    }
                }
            }
            return;
        }
        if (x0Var.f(j.TextAppearance_android_typeface)) {
            this.m = false;
            int d4 = x0Var.d(j.TextAppearance_android_typeface, 1);
            if (d4 == 1) {
                this.l = Typeface.SANS_SERIF;
            } else if (d4 == 2) {
                this.l = Typeface.SERIF;
            } else if (d4 == 3) {
                this.l = Typeface.MONOSPACE;
            }
        }
    }

    public void a(Context context, int i2) {
        x0 x0Var = new x0(context, context.obtainStyledAttributes(i2, j.TextAppearance));
        if (x0Var.f(j.TextAppearance_textAllCaps)) {
            this.f4487a.setAllCaps(x0Var.a(j.TextAppearance_textAllCaps, false));
        }
        if (x0Var.f(j.TextAppearance_android_textSize) && x0Var.c(j.TextAppearance_android_textSize, -1) == 0) {
            this.f4487a.setTextSize(0, 0.0f);
        }
        a(context, x0Var);
        if (VERSION.SDK_INT >= 26 && x0Var.f(j.TextAppearance_fontVariationSettings)) {
            String d2 = x0Var.d(j.TextAppearance_fontVariationSettings);
            if (d2 != null) {
                this.f4487a.setFontVariationSettings(d2);
            }
        }
        x0Var.f4485b.recycle();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f4487a.setTypeface(typeface, this.f4496j);
        }
    }

    public void a() {
        if (!(this.f4488b == null && this.f4489c == null && this.f4490d == null && this.f4491e == null)) {
            Drawable[] compoundDrawables = this.f4487a.getCompoundDrawables();
            a(compoundDrawables[0], this.f4488b);
            a(compoundDrawables[1], this.f4489c);
            a(compoundDrawables[2], this.f4490d);
            a(compoundDrawables[3], this.f4491e);
        }
        if (this.f4492f != null || this.f4493g != null) {
            Drawable[] compoundDrawablesRelative = this.f4487a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f4492f);
            a(compoundDrawablesRelative[2], this.f4493g);
        }
    }

    public final void a(Drawable drawable, v0 v0Var) {
        if (drawable != null && v0Var != null) {
            j.a(drawable, v0Var, this.f4487a.getDrawableState());
        }
    }

    public static v0 a(Context context, j jVar, int i2) {
        ColorStateList b2 = jVar.b(context, i2);
        if (b2 == null) {
            return null;
        }
        v0 v0Var = new v0();
        v0Var.f4459d = true;
        v0Var.f4456a = b2;
        return v0Var;
    }

    public void a(int i2) {
        a0 a0Var = this.f4495i;
        if (!a0Var.d()) {
            return;
        }
        if (i2 == 0) {
            a0Var.f4268a = 0;
            a0Var.f4271d = -1.0f;
            a0Var.f4272e = -1.0f;
            a0Var.f4270c = -1.0f;
            a0Var.f4273f = new int[0];
            a0Var.f4269b = false;
        } else if (i2 == 1) {
            DisplayMetrics displayMetrics = a0Var.f4277j.getResources().getDisplayMetrics();
            a0Var.a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (a0Var.b()) {
                a0Var.a();
            }
        } else {
            throw new IllegalArgumentException(e.a.a.a.a.a("Unknown auto-size text type: ", i2));
        }
    }

    public void a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        a0 a0Var = this.f4495i;
        if (a0Var.d()) {
            DisplayMetrics displayMetrics = a0Var.f4277j.getResources().getDisplayMetrics();
            a0Var.a(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (a0Var.b()) {
                a0Var.a();
            }
        }
    }

    public void a(int[] iArr, int i2) throws IllegalArgumentException {
        a0 a0Var = this.f4495i;
        if (a0Var.d()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = a0Var.f4277j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                a0Var.f4273f = a0Var.a(iArr2);
                if (!a0Var.c()) {
                    StringBuilder a2 = e.a.a.a.a.a("None of the preset sizes is valid: ");
                    a2.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(a2.toString());
                }
            } else {
                a0Var.f4274g = false;
            }
            if (a0Var.b()) {
                a0Var.a();
            }
        }
    }
}
