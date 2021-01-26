package e.g.a.a.z;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.view.View;
import com.arashivision.graphicpath.render.Stabilization.GyroType;
import d.h.i.d;
import d.h.i.d.C0039d;
import d.h.k.m;
import e.g.a.a.b0.a;

/* compiled from: CollapsingTextHelper */
public final class b {
    public static final Paint T = null;
    public Bitmap A;
    public Paint B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int[] G;
    public boolean H;
    public final TextPaint I;
    public final TextPaint J;
    public TimeInterpolator K;
    public TimeInterpolator L;
    public float M;
    public float N;
    public float O;
    public ColorStateList P;
    public float Q;
    public float R;
    public float S;

    /* renamed from: a reason: collision with root package name */
    public final View f8433a;

    /* renamed from: b reason: collision with root package name */
    public boolean f8434b;

    /* renamed from: c reason: collision with root package name */
    public float f8435c;

    /* renamed from: d reason: collision with root package name */
    public final Rect f8436d;

    /* renamed from: e reason: collision with root package name */
    public final Rect f8437e;

    /* renamed from: f reason: collision with root package name */
    public final RectF f8438f;

    /* renamed from: g reason: collision with root package name */
    public int f8439g = 16;

    /* renamed from: h reason: collision with root package name */
    public int f8440h = 16;

    /* renamed from: i reason: collision with root package name */
    public float f8441i = 15.0f;

    /* renamed from: j reason: collision with root package name */
    public float f8442j = 15.0f;
    public ColorStateList k;
    public ColorStateList l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public Typeface s;
    public Typeface t;
    public Typeface u;
    public a v;
    public CharSequence w;
    public CharSequence x;
    public boolean y;
    public boolean z;

    static {
        Paint paint = null;
        if (paint != null) {
            paint.setAntiAlias(true);
            T.setColor(-65281);
        }
    }

    public b(View view) {
        this.f8433a = view;
        this.I = new TextPaint(GyroType.INS_LITE_SINGLE_BACK);
        this.J = new TextPaint(this.I);
        this.f8437e = new Rect();
        this.f8436d = new Rect();
        this.f8438f = new RectF();
    }

    public float a() {
        if (this.w == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.J;
        textPaint.setTextSize(this.f8442j);
        textPaint.setTypeface(this.s);
        TextPaint textPaint2 = this.J;
        CharSequence charSequence = this.w;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public void b(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            e();
        }
    }

    public void c(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 != this.f8435c) {
            this.f8435c = f2;
            a(f2);
        }
    }

    public void d() {
        this.f8434b = this.f8437e.width() > 0 && this.f8437e.height() > 0 && this.f8436d.width() > 0 && this.f8436d.height() > 0;
    }

    public void e() {
        if (this.f8433a.getHeight() > 0 && this.f8433a.getWidth() > 0) {
            float f2 = this.F;
            b(this.f8442j);
            CharSequence charSequence = this.x;
            float f3 = 0.0f;
            float measureText = charSequence != null ? this.I.measureText(charSequence, 0, charSequence.length()) : 0.0f;
            int absoluteGravity = Gravity.getAbsoluteGravity(this.f8440h, this.y ? 1 : 0);
            int i2 = absoluteGravity & 112;
            if (i2 == 48) {
                this.n = ((float) this.f8437e.top) - this.I.ascent();
            } else if (i2 != 80) {
                this.n = ((float) this.f8437e.centerY()) + (((this.I.descent() - this.I.ascent()) / 2.0f) - this.I.descent());
            } else {
                this.n = (float) this.f8437e.bottom;
            }
            int i3 = absoluteGravity & 8388615;
            if (i3 == 1) {
                this.p = ((float) this.f8437e.centerX()) - (measureText / 2.0f);
            } else if (i3 != 5) {
                this.p = (float) this.f8437e.left;
            } else {
                this.p = ((float) this.f8437e.right) - measureText;
            }
            b(this.f8441i);
            CharSequence charSequence2 = this.x;
            if (charSequence2 != null) {
                f3 = this.I.measureText(charSequence2, 0, charSequence2.length());
            }
            int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f8439g, this.y ? 1 : 0);
            int i4 = absoluteGravity2 & 112;
            if (i4 == 48) {
                this.m = ((float) this.f8436d.top) - this.I.ascent();
            } else if (i4 != 80) {
                this.m = ((float) this.f8436d.centerY()) + (((this.I.descent() - this.I.ascent()) / 2.0f) - this.I.descent());
            } else {
                this.m = (float) this.f8436d.bottom;
            }
            int i5 = absoluteGravity2 & 8388615;
            if (i5 == 1) {
                this.o = ((float) this.f8436d.centerX()) - (f3 / 2.0f);
            } else if (i5 != 5) {
                this.o = (float) this.f8436d.left;
            } else {
                this.o = ((float) this.f8436d.right) - f3;
            }
            Bitmap bitmap = this.A;
            if (bitmap != null) {
                bitmap.recycle();
                this.A = null;
            }
            d(f2);
            a(this.f8435c);
        }
    }

    public float b() {
        TextPaint textPaint = this.J;
        textPaint.setTextSize(this.f8442j);
        textPaint.setTypeface(this.s);
        return -this.J.ascent();
    }

    public int c() {
        return a(this.l);
    }

    public void a(Typeface typeface) {
        boolean z2;
        a aVar = this.v;
        boolean z3 = true;
        if (aVar != null) {
            aVar.f8039c = true;
        }
        if (this.s != typeface) {
            this.s = typeface;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.t != typeface) {
            this.t = typeface;
        } else {
            z3 = false;
        }
        if (z2 || z3) {
            e();
        }
    }

    public final void d(float f2) {
        b(f2);
        this.z = false;
        if (0 != 0 && this.A == null && !this.f8436d.isEmpty() && !TextUtils.isEmpty(this.x)) {
            a(0.0f);
            this.C = this.I.ascent();
            this.D = this.I.descent();
            TextPaint textPaint = this.I;
            CharSequence charSequence = this.x;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.D - this.C);
            if (round > 0 && round2 > 0) {
                this.A = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                Canvas canvas = new Canvas(this.A);
                CharSequence charSequence2 = this.x;
                canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, ((float) round2) - this.I.descent(), this.I);
                if (this.B == null) {
                    this.B = new Paint(3);
                }
            }
        }
        m.D(this.f8433a);
    }

    public final void b(float f2) {
        float f3;
        boolean z2;
        if (this.w != null) {
            float width = (float) this.f8437e.width();
            float width2 = (float) this.f8436d.width();
            boolean z3 = true;
            if (Math.abs(f2 - this.f8442j) < 0.001f) {
                f3 = this.f8442j;
                this.E = 1.0f;
                Typeface typeface = this.u;
                Typeface typeface2 = this.s;
                if (typeface != typeface2) {
                    this.u = typeface2;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                float f4 = this.f8441i;
                Typeface typeface3 = this.u;
                Typeface typeface4 = this.t;
                if (typeface3 != typeface4) {
                    this.u = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (Math.abs(f2 - this.f8441i) < 0.001f) {
                    this.E = 1.0f;
                } else {
                    this.E = f2 / this.f8441i;
                }
                float f5 = this.f8442j / this.f8441i;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
                f3 = f4;
            }
            if (width > 0.0f) {
                z2 = this.F != f3 || this.H || z2;
                this.F = f3;
                this.H = false;
            }
            if (this.x == null || z2) {
                this.I.setTextSize(this.F);
                this.I.setTypeface(this.u);
                TextPaint textPaint = this.I;
                if (this.E == 1.0f) {
                    z3 = false;
                }
                textPaint.setLinearText(z3);
                CharSequence ellipsize = TextUtils.ellipsize(this.w, this.I, width, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.x)) {
                    this.x = ellipsize;
                    this.y = a(ellipsize);
                }
            }
        }
    }

    public final int a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.G;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public final void a(float f2) {
        this.f8438f.left = a((float) this.f8436d.left, (float) this.f8437e.left, f2, this.K);
        this.f8438f.top = a(this.m, this.n, f2, this.K);
        this.f8438f.right = a((float) this.f8436d.right, (float) this.f8437e.right, f2, this.K);
        this.f8438f.bottom = a((float) this.f8436d.bottom, (float) this.f8437e.bottom, f2, this.K);
        this.q = a(this.o, this.p, f2, this.K);
        this.r = a(this.m, this.n, f2, this.K);
        d(a(this.f8441i, this.f8442j, f2, this.L));
        ColorStateList colorStateList = this.l;
        ColorStateList colorStateList2 = this.k;
        if (colorStateList != colorStateList2) {
            this.I.setColor(a(a(colorStateList2), c(), f2));
        } else {
            this.I.setColor(c());
        }
        this.I.setShadowLayer(a(this.Q, this.M, f2, null), a(this.R, this.N, f2, null), a(this.S, this.O, f2, null), a(a((ColorStateList) null), a(this.P), f2));
        m.D(this.f8433a);
    }

    public final boolean a(CharSequence charSequence) {
        boolean z2 = true;
        if (m.m(this.f8433a) != 1) {
            z2 = false;
        }
        return ((C0039d) (z2 ? d.f4894d : d.f4893c)).a(charSequence, 0, charSequence.length());
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i3)) * f2) + (((float) Color.alpha(i2)) * f3)), (int) ((((float) Color.red(i3)) * f2) + (((float) Color.red(i2)) * f3)), (int) ((((float) Color.green(i3)) * f2) + (((float) Color.green(i2)) * f3)), (int) ((((float) Color.blue(i3)) * f2) + (((float) Color.blue(i2)) * f3)));
    }

    public static float a(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return e.g.a.a.l.a.a(f2, f3, f4);
    }

    public static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }
}
