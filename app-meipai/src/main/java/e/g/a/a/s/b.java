package e.g.a.a.s;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import com.arashivision.graphicpath.render.Stabilization.GyroType;
import e.c.f.n.n;
import e.g.a.a.b0.c;
import e.g.a.a.b0.d;
import e.g.a.a.e0.g;
import e.g.a.a.e0.j;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: ChipDrawable */
public class b extends g implements Callback, e.g.a.a.z.g.b {
    public static final int[] G0 = {16842910};
    public static final ShapeDrawable H0 = new ShapeDrawable(new OvalShape());
    public ColorStateList A;
    public ColorStateList A0;
    public float B;
    public WeakReference<a> B0;
    public ColorStateList C;
    public TruncateAt C0;
    public CharSequence D;
    public boolean D0;
    public boolean E;
    public int E0;
    public Drawable F;
    public boolean F0;
    public ColorStateList G;
    public float H;
    public boolean I;
    public boolean J;
    public Drawable K;
    public Drawable L;
    public ColorStateList M;
    public float N;
    public CharSequence O;
    public boolean P;
    public boolean Q;
    public Drawable R;
    public e.g.a.a.l.g S;
    public e.g.a.a.l.g T;
    public float U;
    public float V;
    public float W;
    public float X;
    public float Y;
    public float Z;
    public float b0;
    public float c0;
    public final Context d0;
    public final Paint e0 = new Paint(1);
    public final Paint f0;
    public final FontMetrics g0 = new FontMetrics();
    public final RectF h0 = new RectF();
    public final PointF i0 = new PointF();
    public final Path j0 = new Path();
    public final e.g.a.a.z.g k0;
    public int l0;
    public int m0;
    public int n0;
    public int o0;
    public int p0;
    public int q0;
    public boolean r0;
    public int s0;
    public int t0 = 255;
    public ColorFilter u0;
    public PorterDuffColorFilter v0;
    public ColorStateList w;
    public ColorStateList w0;
    public ColorStateList x;
    public Mode x0 = Mode.SRC_IN;
    public float y;
    public int[] y0;
    public float z;
    public boolean z0;

    /* compiled from: ChipDrawable */
    public interface a {
        void a();
    }

    public b(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(j.a(context, attributeSet, i2, i3).a());
        Paint paint = null;
        this.B0 = new WeakReference<>(paint);
        this.f8072a.f8084b = new e.g.a.a.w.a(context);
        j();
        this.d0 = context;
        e.g.a.a.z.g gVar = new e.g.a.a.z.g(this);
        this.k0 = gVar;
        this.D = "";
        gVar.f8455a.density = context.getResources().getDisplayMetrics().density;
        this.f0 = paint;
        if (paint != null) {
            paint.setStyle(Style.STROKE);
        }
        setState(G0);
        b(G0);
        this.D0 = true;
        if (e.g.a.a.c0.a.f8055a) {
            H0.setTint(-1);
        }
    }

    public static boolean f(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static boolean h(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public final void a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (q() || p()) {
            float f2 = this.U + this.V;
            if (getLayoutDirection() == 0) {
                float f3 = ((float) rect.left) + f2;
                rectF.left = f3;
                rectF.right = f3 + this.H;
            } else {
                float f4 = ((float) rect.right) - f2;
                rectF.right = f4;
                rectF.left = f4 - this.H;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.H;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    public final void b(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (r()) {
            float f2 = this.c0 + this.b0;
            if (getLayoutDirection() == 0) {
                float f3 = ((float) rect.right) - f2;
                rectF.right = f3;
                rectF.left = f3 - this.N;
            } else {
                float f4 = ((float) rect.left) + f2;
                rectF.left = f4;
                rectF.right = f4 + this.N;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.N;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    public final void c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (r()) {
            float f2 = this.c0 + this.b0 + this.N + this.Z + this.Y;
            if (getLayoutDirection() == 0) {
                float f3 = (float) rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i2 = rect.left;
                rectF.left = (float) i2;
                rectF.right = ((float) i2) + f2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    public void d(ColorStateList colorStateList) {
        this.I = true;
        if (this.G != colorStateList) {
            this.G = colorStateList;
            if (q()) {
                this.F.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void draw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            int i8 = this.t0;
            if (i8 != 0) {
                int saveLayerAlpha = i8 < 255 ? canvas.saveLayerAlpha((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i8) : 0;
                if (!this.F0) {
                    this.e0.setColor(this.l0);
                    this.e0.setStyle(Style.FILL);
                    this.h0.set(bounds);
                    canvas2.drawRoundRect(this.h0, m(), m(), this.e0);
                }
                if (!this.F0) {
                    this.e0.setColor(this.m0);
                    this.e0.setStyle(Style.FILL);
                    Paint paint = this.e0;
                    ColorFilter colorFilter = this.u0;
                    if (colorFilter == null) {
                        colorFilter = this.v0;
                    }
                    paint.setColorFilter(colorFilter);
                    this.h0.set(bounds);
                    canvas2.drawRoundRect(this.h0, m(), m(), this.e0);
                }
                if (this.F0) {
                    super.draw(canvas);
                }
                if (this.B > 0.0f && !this.F0) {
                    this.e0.setColor(this.o0);
                    this.e0.setStyle(Style.STROKE);
                    if (!this.F0) {
                        Paint paint2 = this.e0;
                        ColorFilter colorFilter2 = this.u0;
                        if (colorFilter2 == null) {
                            colorFilter2 = this.v0;
                        }
                        paint2.setColorFilter(colorFilter2);
                    }
                    float f2 = this.B / 2.0f;
                    this.h0.set(((float) bounds.left) + f2, ((float) bounds.top) + f2, ((float) bounds.right) - f2, ((float) bounds.bottom) - f2);
                    float f3 = this.z - (this.B / 2.0f);
                    canvas2.drawRoundRect(this.h0, f3, f3, this.e0);
                }
                this.e0.setColor(this.p0);
                this.e0.setStyle(Style.FILL);
                this.h0.set(bounds);
                if (!this.F0) {
                    canvas2.drawRoundRect(this.h0, m(), m(), this.e0);
                } else {
                    b(new RectF(bounds), this.j0);
                    a(canvas, this.e0, this.j0, this.f8072a.f8083a, b());
                }
                if (q()) {
                    a(bounds, this.h0);
                    RectF rectF = this.h0;
                    float f4 = rectF.left;
                    float f5 = rectF.top;
                    canvas2.translate(f4, f5);
                    this.F.setBounds(0, 0, (int) this.h0.width(), (int) this.h0.height());
                    this.F.draw(canvas2);
                    canvas2.translate(-f4, -f5);
                }
                if (p()) {
                    a(bounds, this.h0);
                    RectF rectF2 = this.h0;
                    float f6 = rectF2.left;
                    float f7 = rectF2.top;
                    canvas2.translate(f6, f7);
                    this.R.setBounds(0, 0, (int) this.h0.width(), (int) this.h0.height());
                    this.R.draw(canvas2);
                    canvas2.translate(-f6, -f7);
                }
                if (!this.D0 || this.D == null) {
                    i2 = saveLayerAlpha;
                    i3 = 0;
                    i4 = 255;
                } else {
                    PointF pointF = this.i0;
                    pointF.set(0.0f, 0.0f);
                    Align align = Align.LEFT;
                    if (this.D != null) {
                        float k = k() + this.U + this.X;
                        if (getLayoutDirection() == 0) {
                            pointF.x = ((float) bounds.left) + k;
                            align = Align.LEFT;
                        } else {
                            pointF.x = ((float) bounds.right) - k;
                            align = Align.RIGHT;
                        }
                        float centerY = (float) bounds.centerY();
                        this.k0.f8455a.getFontMetrics(this.g0);
                        FontMetrics fontMetrics = this.g0;
                        pointF.y = centerY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
                    }
                    RectF rectF3 = this.h0;
                    rectF3.setEmpty();
                    if (this.D != null) {
                        float k2 = k() + this.U + this.X;
                        float l = l() + this.c0 + this.Y;
                        if (getLayoutDirection() == 0) {
                            rectF3.left = ((float) bounds.left) + k2;
                            rectF3.right = ((float) bounds.right) - l;
                        } else {
                            rectF3.left = ((float) bounds.left) + l;
                            rectF3.right = ((float) bounds.right) - k2;
                        }
                        rectF3.top = (float) bounds.top;
                        rectF3.bottom = (float) bounds.bottom;
                    }
                    e.g.a.a.z.g gVar = this.k0;
                    if (gVar.f8460f != null) {
                        gVar.f8455a.drawableState = getState();
                        e.g.a.a.z.g gVar2 = this.k0;
                        gVar2.f8460f.a(this.d0, gVar2.f8455a, gVar2.f8456b);
                    }
                    this.k0.f8455a.setTextAlign(align);
                    boolean z2 = Math.round(this.k0.a(this.D.toString())) > Math.round(this.h0.width());
                    if (z2) {
                        i7 = canvas.save();
                        canvas2.clipRect(this.h0);
                    } else {
                        i7 = 0;
                    }
                    CharSequence charSequence = this.D;
                    if (z2 && this.C0 != null) {
                        charSequence = TextUtils.ellipsize(charSequence, this.k0.f8455a, this.h0.width(), this.C0);
                    }
                    CharSequence charSequence2 = charSequence;
                    int length = charSequence2.length();
                    PointF pointF2 = this.i0;
                    i2 = saveLayerAlpha;
                    float f8 = pointF2.x;
                    i3 = 0;
                    float f9 = pointF2.y;
                    i4 = 255;
                    canvas.drawText(charSequence2, 0, length, f8, f9, this.k0.f8455a);
                    if (z2) {
                        canvas2.restoreToCount(i7);
                    }
                }
                if (r()) {
                    b(bounds, this.h0);
                    RectF rectF4 = this.h0;
                    float f10 = rectF4.left;
                    float f11 = rectF4.top;
                    canvas2.translate(f10, f11);
                    this.K.setBounds(i3, i3, (int) this.h0.width(), (int) this.h0.height());
                    if (e.g.a.a.c0.a.f8055a) {
                        this.L.setBounds(this.K.getBounds());
                        this.L.jumpToCurrentState();
                        this.L.draw(canvas2);
                    } else {
                        this.K.draw(canvas2);
                    }
                    canvas2.translate(-f10, -f11);
                }
                Paint paint3 = this.f0;
                if (paint3 != null) {
                    paint3.setColor(d.h.f.a.b(-16777216, GyroType.INS_WEARABLE_TEST));
                    canvas2.drawRect(bounds, this.f0);
                    if (q() || p()) {
                        a(bounds, this.h0);
                        canvas2.drawRect(this.h0, this.f0);
                    }
                    if (this.D != null) {
                        i6 = i4;
                        i5 = i2;
                        canvas.drawLine((float) bounds.left, bounds.exactCenterY(), (float) bounds.right, bounds.exactCenterY(), this.f0);
                    } else {
                        i6 = i4;
                        i5 = i2;
                    }
                    if (r()) {
                        b(bounds, this.h0);
                        canvas2.drawRect(this.h0, this.f0);
                    }
                    this.f0.setColor(d.h.f.a.b(-65536, GyroType.INS_WEARABLE_TEST));
                    RectF rectF5 = this.h0;
                    rectF5.set(bounds);
                    if (r()) {
                        float f12 = this.c0 + this.b0 + this.N + this.Z + this.Y;
                        if (getLayoutDirection() == 0) {
                            rectF5.right = ((float) bounds.right) - f12;
                        } else {
                            rectF5.left = ((float) bounds.left) + f12;
                        }
                    }
                    canvas2.drawRect(this.h0, this.f0);
                    this.f0.setColor(d.h.f.a.b(-16711936, GyroType.INS_WEARABLE_TEST));
                    c(bounds, this.h0);
                    canvas2.drawRect(this.h0, this.f0);
                } else {
                    i6 = i4;
                    i5 = i2;
                }
                if (this.t0 < i6) {
                    canvas2.restoreToCount(i5);
                }
            }
        }
    }

    public void e(boolean z2) {
        if (this.z0 != z2) {
            this.z0 = z2;
            this.A0 = z2 ? e.g.a.a.c0.a.a(this.C) : null;
            onStateChange(getState());
        }
    }

    public void g(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            this.A0 = this.z0 ? e.g.a.a.c0.a.a(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public int getAlpha() {
        return this.t0;
    }

    public ColorFilter getColorFilter() {
        return this.u0;
    }

    public int getIntrinsicHeight() {
        return (int) this.y;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(l() + this.k0.a(this.D.toString()) + k() + this.U + this.X + this.Y + this.c0), this.E0);
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.F0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.z);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.y, this.z);
        }
        outline.setAlpha(((float) this.t0) / 255.0f);
    }

    public void i(float f2) {
        if (this.b0 != f2) {
            this.b0 = f2;
            invalidateSelf();
            if (r()) {
                o();
            }
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r3 = this;
            android.content.res.ColorStateList r0 = r3.w
            boolean r0 = h(r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0064
            android.content.res.ColorStateList r0 = r3.x
            boolean r0 = h(r0)
            if (r0 != 0) goto L_0x0064
            android.content.res.ColorStateList r0 = r3.A
            boolean r0 = h(r0)
            if (r0 != 0) goto L_0x0064
            boolean r0 = r3.z0
            if (r0 == 0) goto L_0x0026
            android.content.res.ColorStateList r0 = r3.A0
            boolean r0 = h(r0)
            if (r0 != 0) goto L_0x0064
        L_0x0026:
            e.g.a.a.z.g r0 = r3.k0
            e.g.a.a.b0.b r0 = r0.f8460f
            if (r0 == 0) goto L_0x0038
            android.content.res.ColorStateList r0 = r0.f8041b
            if (r0 == 0) goto L_0x0038
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0038
            r0 = r2
            goto L_0x0039
        L_0x0038:
            r0 = r1
        L_0x0039:
            if (r0 != 0) goto L_0x0064
            boolean r0 = r3.Q
            if (r0 == 0) goto L_0x0049
            android.graphics.drawable.Drawable r0 = r3.R
            if (r0 == 0) goto L_0x0049
            boolean r0 = r3.P
            if (r0 == 0) goto L_0x0049
            r0 = r2
            goto L_0x004a
        L_0x0049:
            r0 = r1
        L_0x004a:
            if (r0 != 0) goto L_0x0064
            android.graphics.drawable.Drawable r0 = r3.F
            boolean r0 = f(r0)
            if (r0 != 0) goto L_0x0064
            android.graphics.drawable.Drawable r0 = r3.R
            boolean r0 = f(r0)
            if (r0 != 0) goto L_0x0064
            android.content.res.ColorStateList r0 = r3.w0
            boolean r0 = h(r0)
            if (r0 == 0) goto L_0x0065
        L_0x0064:
            r1 = r2
        L_0x0065:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.a.a.s.b.isStateful():boolean");
    }

    public void j(float f2) {
        if (this.N != f2) {
            this.N = f2;
            invalidateSelf();
            if (r()) {
                o();
            }
        }
    }

    public float k() {
        if (q() || p()) {
            return this.V + this.H + this.W;
        }
        return 0.0f;
    }

    public float l() {
        if (r()) {
            return this.Z + this.N + this.b0;
        }
        return 0.0f;
    }

    public float m() {
        return this.F0 ? g() : this.z;
    }

    public Drawable n() {
        Drawable drawable = this.K;
        if (drawable != null) {
            return drawable instanceof d.h.f.i.a ? ((d.h.f.i.a) drawable).a() : drawable;
        }
        return null;
    }

    public void o() {
        a aVar = (a) this.B0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (q()) {
            onLayoutDirectionChanged |= this.F.setLayoutDirection(i2);
        }
        if (p()) {
            onLayoutDirectionChanged |= this.R.setLayoutDirection(i2);
        }
        if (r()) {
            onLayoutDirectionChanged |= this.K.setLayoutDirection(i2);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
        }
        return true;
    }

    public boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (q()) {
            onLevelChange |= this.F.setLevel(i2);
        }
        if (p()) {
            onLevelChange |= this.R.setLevel(i2);
        }
        if (r()) {
            onLevelChange |= this.K.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public boolean onStateChange(int[] iArr) {
        if (this.F0) {
            super.onStateChange(iArr);
        }
        return a(iArr, this.y0);
    }

    public final boolean p() {
        return this.Q && this.R != null && this.r0;
    }

    public final boolean q() {
        return this.E && this.F != null;
    }

    public final boolean r() {
        return this.J && this.K != null;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (this.t0 != i2) {
            this.t0 = i2;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.u0 != colorFilter) {
            this.u0 = colorFilter;
            invalidateSelf();
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.w0 != colorStateList) {
            this.w0 = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(Mode mode) {
        if (this.x0 != mode) {
            this.x0 = mode;
            this.v0 = n.a((Drawable) this, this.w0, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (q()) {
            visible |= this.F.setVisible(z2, z3);
        }
        if (p()) {
            visible |= this.R.setVisible(z2, z3);
        }
        if (r()) {
            visible |= this.K.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void f(float f2) {
        if (this.y != f2) {
            this.y = f2;
            invalidateSelf();
            o();
        }
    }

    public void h(float f2) {
        if (this.B != f2) {
            this.B = f2;
            this.e0.setStrokeWidth(f2);
            if (this.F0) {
                this.f8072a.l = f2;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public void m(float f2) {
        if (this.V != f2) {
            float k = k();
            this.V = f2;
            float k2 = k();
            invalidateSelf();
            if (k != k2) {
                o();
            }
        }
    }

    public void k(float f2) {
        if (this.Z != f2) {
            this.Z = f2;
            invalidateSelf();
            if (r()) {
                o();
            }
        }
    }

    public void l(float f2) {
        if (this.W != f2) {
            float k = k();
            this.W = f2;
            float k2 = k();
            invalidateSelf();
            if (k != k2) {
                o();
            }
        }
    }

    public void o(float f2) {
        if (this.X != f2) {
            this.X = f2;
            invalidateSelf();
            o();
        }
    }

    public void n(float f2) {
        if (this.Y != f2) {
            this.Y = f2;
            invalidateSelf();
            o();
        }
    }

    public final void e(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        if (this.M != colorStateList) {
            this.M = colorStateList;
            if (r()) {
                this.K.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void g(float f2) {
        if (this.U != f2) {
            this.U = f2;
            invalidateSelf();
            o();
        }
    }

    public void e(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            if (this.F0) {
                b(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void d(boolean z2) {
        if (this.J != z2) {
            boolean r = r();
            this.J = z2;
            boolean r2 = r();
            if (r != r2) {
                if (r2) {
                    a(this.K);
                } else {
                    e(this.K);
                }
                invalidateSelf();
                o();
            }
        }
    }

    public void a() {
        o();
        invalidateSelf();
    }

    public boolean b(int[] iArr) {
        if (!Arrays.equals(this.y0, iArr)) {
            this.y0 = iArr;
            if (r()) {
                return a(getState(), iArr);
            }
        }
        return false;
    }

    public void c(ColorStateList colorStateList) {
        if (this.x != colorStateList) {
            this.x = colorStateList;
            onStateChange(getState());
        }
    }

    public void e(float f2) {
        if (this.H != f2) {
            float k = k();
            this.H = f2;
            float k2 = k();
            invalidateSelf();
            if (k != k2) {
                o();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0144  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int[] r9, int[] r10) {
        /*
            r8 = this;
            boolean r0 = super.onStateChange(r9)
            android.content.res.ColorStateList r1 = r8.w
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r8.l0
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0011
        L_0x0010:
            r1 = r2
        L_0x0011:
            int r3 = r8.l0
            r4 = 1
            if (r3 == r1) goto L_0x0019
            r8.l0 = r1
            r0 = r4
        L_0x0019:
            android.content.res.ColorStateList r3 = r8.x
            if (r3 == 0) goto L_0x0024
            int r5 = r8.m0
            int r3 = r3.getColorForState(r9, r5)
            goto L_0x0025
        L_0x0024:
            r3 = r2
        L_0x0025:
            int r5 = r8.m0
            if (r5 == r3) goto L_0x002c
            r8.m0 = r3
            r0 = r4
        L_0x002c:
            int r1 = d.h.f.a.a(r3, r1)
            int r3 = r8.n0
            if (r3 == r1) goto L_0x0036
            r3 = r4
            goto L_0x0037
        L_0x0036:
            r3 = r2
        L_0x0037:
            e.g.a.a.e0.g$b r5 = r8.f8072a
            android.content.res.ColorStateList r5 = r5.f8086d
            if (r5 != 0) goto L_0x003f
            r5 = r4
            goto L_0x0040
        L_0x003f:
            r5 = r2
        L_0x0040:
            r3 = r3 | r5
            if (r3 == 0) goto L_0x004d
            r8.n0 = r1
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r1)
            r8.a(r0)
            r0 = r4
        L_0x004d:
            android.content.res.ColorStateList r1 = r8.A
            if (r1 == 0) goto L_0x0058
            int r3 = r8.o0
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0059
        L_0x0058:
            r1 = r2
        L_0x0059:
            int r3 = r8.o0
            if (r3 == r1) goto L_0x0060
            r8.o0 = r1
            r0 = r4
        L_0x0060:
            android.content.res.ColorStateList r1 = r8.A0
            if (r1 == 0) goto L_0x0073
            boolean r1 = e.g.a.a.c0.a.a(r9)
            if (r1 == 0) goto L_0x0073
            android.content.res.ColorStateList r1 = r8.A0
            int r3 = r8.p0
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0074
        L_0x0073:
            r1 = r2
        L_0x0074:
            int r3 = r8.p0
            if (r3 == r1) goto L_0x007f
            r8.p0 = r1
            boolean r1 = r8.z0
            if (r1 == 0) goto L_0x007f
            r0 = r4
        L_0x007f:
            e.g.a.a.z.g r1 = r8.k0
            e.g.a.a.b0.b r1 = r1.f8460f
            if (r1 == 0) goto L_0x0090
            android.content.res.ColorStateList r1 = r1.f8041b
            if (r1 == 0) goto L_0x0090
            int r3 = r8.q0
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0091
        L_0x0090:
            r1 = r2
        L_0x0091:
            int r3 = r8.q0
            if (r3 == r1) goto L_0x0098
            r8.q0 = r1
            r0 = r4
        L_0x0098:
            int[] r1 = r8.getState()
            r3 = 16842912(0x10100a0, float:2.3694006E-38)
            if (r1 != 0) goto L_0x00a3
        L_0x00a1:
            r1 = r2
            goto L_0x00b0
        L_0x00a3:
            int r5 = r1.length
            r6 = r2
        L_0x00a5:
            if (r6 >= r5) goto L_0x00a1
            r7 = r1[r6]
            if (r7 != r3) goto L_0x00ad
            r1 = r4
            goto L_0x00b0
        L_0x00ad:
            int r6 = r6 + 1
            goto L_0x00a5
        L_0x00b0:
            if (r1 == 0) goto L_0x00b8
            boolean r1 = r8.P
            if (r1 == 0) goto L_0x00b8
            r1 = r4
            goto L_0x00b9
        L_0x00b8:
            r1 = r2
        L_0x00b9:
            boolean r3 = r8.r0
            if (r3 == r1) goto L_0x00d5
            android.graphics.drawable.Drawable r3 = r8.R
            if (r3 == 0) goto L_0x00d5
            float r0 = r8.k()
            r8.r0 = r1
            float r1 = r8.k()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00d2
            r0 = r4
            r1 = r0
            goto L_0x00d6
        L_0x00d2:
            r1 = r2
            r0 = r4
            goto L_0x00d6
        L_0x00d5:
            r1 = r2
        L_0x00d6:
            android.content.res.ColorStateList r3 = r8.w0
            if (r3 == 0) goto L_0x00e1
            int r5 = r8.s0
            int r3 = r3.getColorForState(r9, r5)
            goto L_0x00e2
        L_0x00e1:
            r3 = r2
        L_0x00e2:
            int r5 = r8.s0
            if (r5 == r3) goto L_0x00f3
            r8.s0 = r3
            android.content.res.ColorStateList r0 = r8.w0
            android.graphics.PorterDuff$Mode r3 = r8.x0
            android.graphics.PorterDuffColorFilter r0 = e.c.f.n.n.a(r8, r0, r3)
            r8.v0 = r0
            goto L_0x00f4
        L_0x00f3:
            r4 = r0
        L_0x00f4:
            android.graphics.drawable.Drawable r0 = r8.F
            boolean r0 = f(r0)
            if (r0 == 0) goto L_0x0103
            android.graphics.drawable.Drawable r0 = r8.F
            boolean r0 = r0.setState(r9)
            r4 = r4 | r0
        L_0x0103:
            android.graphics.drawable.Drawable r0 = r8.R
            boolean r0 = f(r0)
            if (r0 == 0) goto L_0x0112
            android.graphics.drawable.Drawable r0 = r8.R
            boolean r0 = r0.setState(r9)
            r4 = r4 | r0
        L_0x0112:
            android.graphics.drawable.Drawable r0 = r8.K
            boolean r0 = f(r0)
            if (r0 == 0) goto L_0x012f
            int r0 = r9.length
            int r3 = r10.length
            int r0 = r0 + r3
            int[] r0 = new int[r0]
            int r3 = r9.length
            java.lang.System.arraycopy(r9, r2, r0, r2, r3)
            int r9 = r9.length
            int r3 = r10.length
            java.lang.System.arraycopy(r10, r2, r0, r9, r3)
            android.graphics.drawable.Drawable r9 = r8.K
            boolean r9 = r9.setState(r0)
            r4 = r4 | r9
        L_0x012f:
            boolean r9 = e.g.a.a.c0.a.f8055a
            if (r9 == 0) goto L_0x0142
            android.graphics.drawable.Drawable r9 = r8.L
            boolean r9 = f(r9)
            if (r9 == 0) goto L_0x0142
            android.graphics.drawable.Drawable r9 = r8.L
            boolean r9 = r9.setState(r10)
            r4 = r4 | r9
        L_0x0142:
            if (r4 == 0) goto L_0x0147
            r8.invalidateSelf()
        L_0x0147:
            if (r1 == 0) goto L_0x014c
            r8.o()
        L_0x014c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.a.a.s.b.a(int[], int[]):boolean");
    }

    @Deprecated
    public void c(float f2) {
        if (this.z != f2) {
            this.z = f2;
            setShapeAppearanceModel(this.f8072a.f8083a.a(f2));
        }
    }

    public void b(boolean z2) {
        if (this.Q != z2) {
            boolean p = p();
            this.Q = z2;
            boolean p2 = p();
            if (p != p2) {
                if (p2) {
                    a(this.R);
                } else {
                    e(this.R);
                }
                invalidateSelf();
                o();
            }
        }
    }

    public void d(Drawable drawable) {
        Drawable n = n();
        if (n != drawable) {
            float l = l();
            this.K = drawable != null ? drawable.mutate() : null;
            if (e.g.a.a.c0.a.f8055a) {
                this.L = new RippleDrawable(e.g.a.a.c0.a.a(this.C), this.K, H0);
            }
            float l2 = l();
            e(n);
            if (r()) {
                a(this.K);
            }
            invalidateSelf();
            if (l != l2) {
                o();
            }
        }
    }

    public void c(boolean z2) {
        if (this.E != z2) {
            boolean q = q();
            this.E = z2;
            boolean q2 = q();
            if (q != q2) {
                if (q2) {
                    a(this.F);
                } else {
                    e(this.F);
                }
                invalidateSelf();
                o();
            }
        }
    }

    public void b(Drawable drawable) {
        if (this.R != drawable) {
            float k = k();
            this.R = drawable;
            float k2 = k();
            e(this.R);
            a(this.R);
            invalidateSelf();
            if (k != k2) {
                o();
            }
        }
    }

    public void c(Drawable drawable) {
        Drawable drawable2 = this.F;
        Drawable drawable3 = null;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof d.h.f.i.a) {
            drawable2 = ((d.h.f.i.a) drawable2).a();
        }
        if (drawable2 != drawable) {
            float k = k();
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.F = drawable3;
            float k2 = k();
            e(drawable2);
            if (q()) {
                a(this.F);
            }
            invalidateSelf();
            if (k != k2) {
                o();
            }
        }
    }

    public void d(float f2) {
        if (this.c0 != f2) {
            this.c0 = f2;
            invalidateSelf();
            o();
        }
    }

    public final void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setLayoutDirection(getLayoutDirection());
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.K) {
                if (drawable.isStateful()) {
                    drawable.setState(this.y0);
                }
                drawable.setTintList(this.M);
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
            Drawable drawable2 = this.F;
            if (drawable == drawable2 && this.I) {
                drawable2.setTintList(this.G);
            }
        }
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.D, charSequence)) {
            this.D = charSequence;
            this.k0.f8458d = true;
            invalidateSelf();
            o();
        }
    }

    public void a(e.g.a.a.b0.b bVar) {
        e.g.a.a.z.g gVar = this.k0;
        Context context = this.d0;
        if (gVar.f8460f != bVar) {
            gVar.f8460f = bVar;
            if (bVar != null) {
                TextPaint textPaint = gVar.f8455a;
                d dVar = gVar.f8456b;
                bVar.a();
                bVar.a(textPaint, bVar.l);
                bVar.a(context, (d) new c(bVar, textPaint, dVar));
                e.g.a.a.z.g.b bVar2 = (e.g.a.a.z.g.b) gVar.f8459e.get();
                if (bVar2 != null) {
                    gVar.f8455a.drawableState = bVar2.getState();
                }
                bVar.a(context, gVar.f8455a, gVar.f8456b);
                gVar.f8458d = true;
            }
            e.g.a.a.z.g.b bVar3 = (e.g.a.a.z.g.b) gVar.f8459e.get();
            if (bVar3 != null) {
                bVar3.a();
                bVar3.onStateChange(bVar3.getState());
            }
        }
    }

    public void a(boolean z2) {
        if (this.P != z2) {
            this.P = z2;
            float k = k();
            if (!z2 && this.r0) {
                this.r0 = false;
            }
            float k2 = k();
            invalidateSelf();
            if (k != k2) {
                o();
            }
        }
    }
}
