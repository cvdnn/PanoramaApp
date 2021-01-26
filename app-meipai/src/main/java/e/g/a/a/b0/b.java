package e.g.a.a.b0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import d.h.e.b.g;
import e.c.f.n.n;
import e.g.a.a.k;

/* compiled from: TextAppearance */
public class b {

    /* renamed from: a reason: collision with root package name */
    public final float f8040a;

    /* renamed from: b reason: collision with root package name */
    public final ColorStateList f8041b;

    /* renamed from: c reason: collision with root package name */
    public final int f8042c;

    /* renamed from: d reason: collision with root package name */
    public final int f8043d;

    /* renamed from: e reason: collision with root package name */
    public final String f8044e;

    /* renamed from: f reason: collision with root package name */
    public final ColorStateList f8045f;

    /* renamed from: g reason: collision with root package name */
    public final float f8046g;

    /* renamed from: h reason: collision with root package name */
    public final float f8047h;

    /* renamed from: i reason: collision with root package name */
    public final float f8048i;

    /* renamed from: j reason: collision with root package name */
    public final int f8049j;
    public boolean k = false;
    public Typeface l;

    /* compiled from: TextAppearance */
    public class a extends g {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ d f8050a;

        public a(d dVar) {
            this.f8050a = dVar;
        }

        public void a(Typeface typeface) {
            b bVar = b.this;
            bVar.l = Typeface.create(typeface, bVar.f8042c);
            b bVar2 = b.this;
            bVar2.k = true;
            this.f8050a.a(bVar2.l, false);
        }

        public void a(int i2) {
            b.this.k = true;
            this.f8050a.a(i2);
        }
    }

    public b(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, k.TextAppearance);
        this.f8040a = obtainStyledAttributes.getDimension(k.TextAppearance_android_textSize, 0.0f);
        this.f8041b = n.a(context, obtainStyledAttributes, k.TextAppearance_android_textColor);
        n.a(context, obtainStyledAttributes, k.TextAppearance_android_textColorHint);
        n.a(context, obtainStyledAttributes, k.TextAppearance_android_textColorLink);
        this.f8042c = obtainStyledAttributes.getInt(k.TextAppearance_android_textStyle, 0);
        this.f8043d = obtainStyledAttributes.getInt(k.TextAppearance_android_typeface, 1);
        int i3 = k.TextAppearance_fontFamily;
        int i4 = k.TextAppearance_android_fontFamily;
        if (!obtainStyledAttributes.hasValue(i3)) {
            i3 = i4;
        }
        this.f8049j = obtainStyledAttributes.getResourceId(i3, 0);
        this.f8044e = obtainStyledAttributes.getString(i3);
        obtainStyledAttributes.getBoolean(k.TextAppearance_textAllCaps, false);
        this.f8045f = n.a(context, obtainStyledAttributes, k.TextAppearance_android_shadowColor);
        this.f8046g = obtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDx, 0.0f);
        this.f8047h = obtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDy, 0.0f);
        this.f8048i = obtainStyledAttributes.getFloat(k.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public void a(Context context, d dVar) {
        a();
        if (this.f8049j == 0) {
            this.k = true;
        }
        if (this.k) {
            dVar.a(this.l, true);
            return;
        }
        try {
            int i2 = this.f8049j;
            a aVar = new a(dVar);
            if (context.isRestricted()) {
                aVar.a(-4, (Handler) null);
            } else {
                a.a.a.a.b.a.a(context, i2, new TypedValue(), 0, (g) aVar, (Handler) null, false);
            }
        } catch (NotFoundException unused) {
            this.k = true;
            dVar.a(1);
        } catch (Exception e2) {
            StringBuilder a2 = e.a.a.a.a.a("Error loading font ");
            a2.append(this.f8044e);
            Log.d("TextAppearance", a2.toString(), e2);
            this.k = true;
            dVar.a(-3);
        }
    }

    public void a(Context context, TextPaint textPaint, d dVar) {
        a();
        a(textPaint, this.l);
        a(context, (d) new c(this, textPaint, dVar));
        ColorStateList colorStateList = this.f8041b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.f8048i;
        float f3 = this.f8046g;
        float f4 = this.f8047h;
        ColorStateList colorStateList2 = this.f8045f;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void a() {
        if (this.l == null) {
            String str = this.f8044e;
            if (str != null) {
                this.l = Typeface.create(str, this.f8042c);
            }
        }
        if (this.l == null) {
            int i2 = this.f8043d;
            if (i2 == 1) {
                this.l = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.l = Typeface.SERIF;
            } else if (i2 != 3) {
                this.l = Typeface.DEFAULT;
            } else {
                this.l = Typeface.MONOSPACE;
            }
            this.l = Typeface.create(this.l, this.f8042c);
        }
    }

    public void a(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f8042c;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f8040a);
    }
}
