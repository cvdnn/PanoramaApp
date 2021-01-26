package e.h.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.jaygoo.widget.RangeSeekBar;
import com.tencent.connect.common.Constants;
import e.c.f.n.n;
import java.text.DecimalFormat;

/* compiled from: SeekBar */
public class f {
    public boolean A;
    public Bitmap B;
    public Bitmap C;
    public Bitmap D;
    public ValueAnimator E;
    public String F;
    public boolean G = false;
    public boolean H = true;
    public RangeSeekBar I;
    public String J;
    public Path K = new Path();
    public Rect L = new Rect();
    public Rect M = new Rect();
    public Paint N = new Paint(1);
    public DecimalFormat O;
    public int P;
    public int Q;

    /* renamed from: a reason: collision with root package name */
    public int f8633a;

    /* renamed from: b reason: collision with root package name */
    public int f8634b;

    /* renamed from: c reason: collision with root package name */
    public int f8635c;

    /* renamed from: d reason: collision with root package name */
    public int f8636d;

    /* renamed from: e reason: collision with root package name */
    public int f8637e;

    /* renamed from: f reason: collision with root package name */
    public int f8638f;

    /* renamed from: g reason: collision with root package name */
    public int f8639g;

    /* renamed from: h reason: collision with root package name */
    public int f8640h;

    /* renamed from: i reason: collision with root package name */
    public float f8641i;

    /* renamed from: j reason: collision with root package name */
    public int f8642j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public int t;
    public int u;
    public int v;
    public int w;
    public float x;
    public float y = 0.0f;
    public boolean z;

    /* compiled from: SeekBar */
    public class a implements AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.y = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RangeSeekBar rangeSeekBar = f.this.I;
            if (rangeSeekBar != null) {
                rangeSeekBar.invalidate();
            }
        }
    }

    /* compiled from: SeekBar */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            f fVar = f.this;
            fVar.y = 0.0f;
            RangeSeekBar rangeSeekBar = fVar.I;
            if (rangeSeekBar != null) {
                rangeSeekBar.invalidate();
            }
        }
    }

    public f(RangeSeekBar rangeSeekBar, AttributeSet attributeSet, boolean z2) {
        this.I = rangeSeekBar;
        this.A = z2;
        TypedArray obtainStyledAttributes = a().obtainStyledAttributes(attributeSet, d.RangeSeekBar);
        if (obtainStyledAttributes != null) {
            this.f8636d = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_margin, 0.0f);
            this.f8637e = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_indicator_drawable, 0);
            this.f8633a = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_indicator_show_mode, 1);
            this.f8634b = obtainStyledAttributes.getLayoutDimension(d.RangeSeekBar_rsb_indicator_height, -1);
            this.f8635c = obtainStyledAttributes.getLayoutDimension(d.RangeSeekBar_rsb_indicator_width, -1);
            this.f8639g = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_text_size, (float) n.a(a(), 14.0f));
            this.f8640h = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_indicator_text_color, -1);
            this.f8642j = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_indicator_background_color, d.h.e.a.a(a(), b.colorAccent));
            this.k = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_padding_left, 0.0f);
            this.l = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_padding_right, 0.0f);
            this.m = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_padding_top, 0.0f);
            this.n = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_padding_bottom, 0.0f);
            this.f8638f = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_arrow_size, 0.0f);
            this.o = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_thumb_drawable, c.rsb_default_thumb);
            this.p = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_thumb_inactivated_drawable, 0);
            this.q = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_thumb_width, (float) n.a(a(), 26.0f));
            this.r = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_thumb_height, (float) n.a(a(), 26.0f));
            this.s = obtainStyledAttributes.getFloat(d.RangeSeekBar_rsb_thumb_scale_ratio, 1.0f);
            this.f8641i = obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_radius, 0.0f);
            obtainStyledAttributes.recycle();
        }
        h();
        i();
    }

    public Context a() {
        return this.I.getContext();
    }

    public int b() {
        int i2;
        int i3 = this.f8634b;
        if (i3 <= 0) {
            Bitmap bitmap = this.D;
            String str = Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
            if (bitmap != null) {
                i3 = n.a(str, (float) this.f8639g).height() + this.m + this.n;
                i2 = this.f8636d;
            } else {
                i3 = n.a(str, (float) this.f8639g).height() + this.m + this.n + this.f8636d;
                i2 = this.f8638f;
            }
        } else if (this.D != null) {
            i2 = this.f8636d;
        } else {
            i3 += this.f8638f;
            i2 = this.f8636d;
        }
        return i3 + i2;
    }

    public float c() {
        float maxProgress = this.I.getMaxProgress() - this.I.getMinProgress();
        return (maxProgress * this.x) + this.I.getMinProgress();
    }

    public float d() {
        return f() + ((float) (this.f8634b + this.f8638f + this.f8636d));
    }

    public Resources e() {
        if (a() != null) {
            return a().getResources();
        }
        return null;
    }

    public float f() {
        return ((float) this.r) * this.s;
    }

    public float g() {
        return ((float) this.q) * this.s;
    }

    public final void h() {
        int i2 = this.f8637e;
        if (i2 != 0) {
            this.f8637e = i2;
            this.D = BitmapFactory.decodeResource(e(), i2);
        }
        a(this.o, this.q, this.r);
        int i3 = this.p;
        int i4 = this.q;
        int i5 = this.r;
        if (i3 != 0 && e() != null) {
            this.p = i3;
            this.C = n.a(i4, i5, e().getDrawable(i3, null));
        }
    }

    public void i() {
        this.P = this.q;
        this.Q = this.r;
        if (this.f8634b == -1) {
            this.f8634b = n.a(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, (float) this.f8639g).height() + this.m + this.n;
        }
        if (this.f8638f <= 0) {
            this.f8638f = this.q / 4;
        }
    }

    public void j() {
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.y, 0.0f});
        this.E = ofFloat;
        ofFloat.addUpdateListener(new a());
        this.E.addListener(new b());
        this.E.start();
    }

    public void a(int i2, int i3) {
        i();
        h();
        float f2 = (float) i2;
        this.t = (int) (f2 - (g() / 2.0f));
        this.u = (int) ((g() / 2.0f) + f2);
        int i4 = this.r;
        this.v = i3 - (i4 / 2);
        this.w = (i4 / 2) + i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.graphics.Canvas r15) {
        /*
            r14 = this;
            boolean r0 = r14.H
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.jaygoo.widget.RangeSeekBar r0 = r14.I
            int r0 = r0.getProgressWidth()
            float r0 = (float) r0
            float r1 = r14.x
            float r0 = r0 * r1
            int r0 = (int) r0
            r15.save()
            float r0 = (float) r0
            r1 = 0
            r15.translate(r0, r1)
            int r0 = r14.t
            float r0 = (float) r0
            r15.translate(r0, r1)
            boolean r0 = r14.z
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 0
            if (r0 == 0) goto L_0x0214
            android.graphics.Paint r0 = r14.N
            java.lang.String r4 = r14.F
            com.jaygoo.widget.RangeSeekBar r5 = r14.I
            e.h.a.g[] r5 = r5.getRangeSeekBarState()
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L_0x0060
            boolean r4 = r14.A
            if (r4 == 0) goto L_0x004e
            java.text.DecimalFormat r4 = r14.O
            if (r4 == 0) goto L_0x0049
            r5 = r5[r8]
            float r5 = r5.f8646b
            double r5 = (double) r5
            java.lang.String r4 = r4.format(r5)
            goto L_0x0060
        L_0x0049:
            r4 = r5[r8]
            java.lang.String r4 = r4.f8645a
            goto L_0x0060
        L_0x004e:
            java.text.DecimalFormat r4 = r14.O
            if (r4 == 0) goto L_0x005c
            r5 = r5[r7]
            float r5 = r5.f8646b
            double r5 = (double) r5
            java.lang.String r4 = r4.format(r5)
            goto L_0x0060
        L_0x005c:
            r4 = r5[r7]
            java.lang.String r4 = r4.f8645a
        L_0x0060:
            java.lang.String r5 = r14.J
            if (r5 == 0) goto L_0x006c
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r6[r8] = r4
            java.lang.String r4 = java.lang.String.format(r5, r6)
        L_0x006c:
            if (r4 != 0) goto L_0x0070
            goto L_0x0214
        L_0x0070:
            int r5 = r14.f8639g
            float r5 = (float) r5
            r0.setTextSize(r5)
            android.graphics.Paint$Style r5 = android.graphics.Paint.Style.FILL
            r0.setStyle(r5)
            int r5 = r14.f8642j
            r0.setColor(r5)
            int r5 = r4.length()
            android.graphics.Rect r6 = r14.L
            r0.getTextBounds(r4, r8, r5, r6)
            android.graphics.Rect r5 = r14.L
            int r5 = r5.width()
            int r6 = r14.k
            int r5 = r5 + r6
            int r6 = r14.l
            int r5 = r5 + r6
            int r6 = r14.f8635c
            if (r6 <= r5) goto L_0x009a
            r5 = r6
        L_0x009a:
            android.graphics.Rect r6 = r14.L
            int r6 = r6.height()
            int r8 = r14.m
            int r6 = r6 + r8
            int r8 = r14.n
            int r6 = r6 + r8
            int r8 = r14.f8634b
            if (r8 <= r6) goto L_0x00ab
            r6 = r8
        L_0x00ab:
            android.graphics.Rect r8 = r14.M
            int r9 = r14.P
            float r10 = (float) r9
            float r10 = r10 / r2
            float r11 = (float) r5
            float r11 = r11 / r2
            float r10 = r10 - r11
            int r10 = (int) r10
            r8.left = r10
            int r11 = r14.w
            int r11 = r11 - r6
            int r12 = r14.Q
            int r11 = r11 - r12
            int r12 = r14.f8636d
            int r11 = r11 - r12
            r8.top = r11
            int r10 = r10 + r5
            r8.right = r10
            int r11 = r11 + r6
            r8.bottom = r11
            android.graphics.Bitmap r8 = r14.D
            if (r8 != 0) goto L_0x0106
            int r9 = r9 / 2
            int r8 = r14.f8638f
            int r10 = r9 - r8
            int r12 = r11 - r8
            int r8 = r8 + r9
            android.graphics.Path r13 = r14.K
            r13.reset()
            android.graphics.Path r13 = r14.K
            float r9 = (float) r9
            float r11 = (float) r11
            r13.moveTo(r9, r11)
            android.graphics.Path r9 = r14.K
            float r10 = (float) r10
            float r11 = (float) r12
            r9.lineTo(r10, r11)
            android.graphics.Path r9 = r14.K
            float r8 = (float) r8
            r9.lineTo(r8, r11)
            android.graphics.Path r8 = r14.K
            r8.close()
            android.graphics.Path r8 = r14.K
            r15.drawPath(r8, r0)
            android.graphics.Rect r8 = r14.M
            int r9 = r8.bottom
            int r10 = r14.f8638f
            int r9 = r9 - r10
            r8.bottom = r9
            int r9 = r8.top
            int r9 = r9 - r10
            r8.top = r9
        L_0x0106:
            android.content.Context r8 = r14.a()
            r9 = 1065353216(0x3f800000, float:1.0)
            int r8 = e.c.f.n.n.a(r8, r9)
            android.graphics.Rect r10 = r14.M
            int r10 = r10.width()
            int r10 = r10 / 2
            com.jaygoo.widget.RangeSeekBar r11 = r14.I
            int r11 = r11.getProgressWidth()
            float r11 = (float) r11
            float r12 = r14.x
            float r11 = r11 * r12
            int r11 = (int) r11
            int r10 = r10 - r11
            com.jaygoo.widget.RangeSeekBar r11 = r14.I
            int r11 = r11.getProgressLeft()
            int r10 = r10 - r11
            int r10 = r10 + r8
            android.graphics.Rect r11 = r14.M
            int r11 = r11.width()
            int r11 = r11 / 2
            com.jaygoo.widget.RangeSeekBar r12 = r14.I
            int r12 = r12.getProgressWidth()
            float r12 = (float) r12
            float r13 = r14.x
            float r9 = r9 - r13
            float r9 = r9 * r12
            int r9 = (int) r9
            int r11 = r11 - r9
            com.jaygoo.widget.RangeSeekBar r9 = r14.I
            int r9 = r9.getProgressPaddingRight()
            int r11 = r11 - r9
            int r11 = r11 + r8
            if (r10 <= 0) goto L_0x0158
            android.graphics.Rect r8 = r14.M
            int r9 = r8.left
            int r9 = r9 + r10
            r8.left = r9
            int r9 = r8.right
            int r9 = r9 + r10
            r8.right = r9
            goto L_0x0166
        L_0x0158:
            if (r11 <= 0) goto L_0x0166
            android.graphics.Rect r8 = r14.M
            int r9 = r8.left
            int r9 = r9 - r11
            r8.left = r9
            int r9 = r8.right
            int r9 = r9 - r11
            r8.right = r9
        L_0x0166:
            android.graphics.Bitmap r8 = r14.D
            if (r8 == 0) goto L_0x0194
            android.graphics.Rect r9 = r14.M
            byte[] r10 = r8.getNinePatchChunk()     // Catch:{ Exception -> 0x018a }
            boolean r10 = android.graphics.NinePatch.isNinePatchChunk(r10)     // Catch:{ Exception -> 0x018a }
            if (r10 == 0) goto L_0x018a
            byte[] r10 = r8.getNinePatchChunk()     // Catch:{ Exception -> 0x018a }
            android.graphics.NinePatch.isNinePatchChunk(r10)     // Catch:{ Exception -> 0x018a }
            android.graphics.NinePatch r10 = new android.graphics.NinePatch     // Catch:{ Exception -> 0x018a }
            byte[] r11 = r8.getNinePatchChunk()     // Catch:{ Exception -> 0x018a }
            r10.<init>(r8, r11, r3)     // Catch:{ Exception -> 0x018a }
            r10.draw(r15, r9)     // Catch:{ Exception -> 0x018a }
            goto L_0x01ac
        L_0x018a:
            int r10 = r9.left
            float r10 = (float) r10
            int r9 = r9.top
            float r9 = (float) r9
            r15.drawBitmap(r8, r10, r9, r0)
            goto L_0x01ac
        L_0x0194:
            float r8 = r14.f8641i
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 <= 0) goto L_0x01a7
            android.graphics.RectF r8 = new android.graphics.RectF
            android.graphics.Rect r9 = r14.M
            r8.<init>(r9)
            float r9 = r14.f8641i
            r15.drawRoundRect(r8, r9, r9, r0)
            goto L_0x01ac
        L_0x01a7:
            android.graphics.Rect r8 = r14.M
            r15.drawRect(r8, r0)
        L_0x01ac:
            int r8 = r14.k
            if (r8 <= 0) goto L_0x01b5
            android.graphics.Rect r5 = r14.M
            int r5 = r5.left
            goto L_0x01d3
        L_0x01b5:
            int r8 = r14.l
            if (r8 <= 0) goto L_0x01c6
            android.graphics.Rect r5 = r14.M
            int r5 = r5.right
            int r5 = r5 - r8
            android.graphics.Rect r8 = r14.L
            int r8 = r8.width()
            int r5 = r5 - r8
            goto L_0x01d4
        L_0x01c6:
            android.graphics.Rect r8 = r14.M
            int r8 = r8.left
            android.graphics.Rect r9 = r14.L
            int r9 = r9.width()
            int r5 = r5 - r9
            int r5 = r5 / 2
        L_0x01d3:
            int r5 = r5 + r8
        L_0x01d4:
            int r8 = r14.m
            if (r8 <= 0) goto L_0x01e7
            android.graphics.Rect r6 = r14.M
            int r6 = r6.top
            android.graphics.Rect r7 = r14.L
            int r7 = r7.height()
            int r7 = r7 + r6
            int r6 = r14.m
            int r7 = r7 + r6
            goto L_0x020a
        L_0x01e7:
            int r8 = r14.n
            if (r8 <= 0) goto L_0x01fb
            android.graphics.Rect r6 = r14.M
            int r6 = r6.bottom
            android.graphics.Rect r7 = r14.L
            int r7 = r7.height()
            int r6 = r6 - r7
            int r7 = r14.n
            int r7 = r6 - r7
            goto L_0x020a
        L_0x01fb:
            android.graphics.Rect r8 = r14.M
            int r8 = r8.bottom
            android.graphics.Rect r9 = r14.L
            int r9 = r9.height()
            int r6 = r6 - r9
            int r6 = r6 / 2
            int r8 = r8 - r6
            int r7 = r7 + r8
        L_0x020a:
            int r6 = r14.f8640h
            r0.setColor(r6)
            float r5 = (float) r5
            float r6 = (float) r7
            r15.drawText(r4, r5, r6, r0)
        L_0x0214:
            android.graphics.Bitmap r0 = r14.C
            if (r0 == 0) goto L_0x0233
            boolean r4 = r14.G
            if (r4 != 0) goto L_0x0233
            com.jaygoo.widget.RangeSeekBar r4 = r14.I
            int r4 = r4.getProgressTop()
            float r4 = (float) r4
            com.jaygoo.widget.RangeSeekBar r5 = r14.I
            int r5 = r5.getProgressHeight()
            int r6 = r14.Q
            int r5 = r5 - r6
            float r5 = (float) r5
            float r5 = r5 / r2
            float r5 = r5 + r4
            r15.drawBitmap(r0, r1, r5, r3)
            goto L_0x024d
        L_0x0233:
            android.graphics.Bitmap r0 = r14.B
            if (r0 == 0) goto L_0x024d
            com.jaygoo.widget.RangeSeekBar r4 = r14.I
            int r4 = r4.getProgressTop()
            float r4 = (float) r4
            com.jaygoo.widget.RangeSeekBar r5 = r14.I
            int r5 = r5.getProgressHeight()
            int r6 = r14.Q
            int r5 = r5 - r6
            float r5 = (float) r5
            float r5 = r5 / r2
            float r5 = r5 + r4
            r15.drawBitmap(r0, r1, r5, r3)
        L_0x024d:
            r15.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.h.a.f.a(android.graphics.Canvas):void");
    }

    public boolean a(float f2, float f3) {
        int progressWidth = (int) (((float) this.I.getProgressWidth()) * this.x);
        return f2 > ((float) (this.t + progressWidth)) && f2 < ((float) (this.u + progressWidth)) && f3 > ((float) this.v) && f3 < ((float) this.w);
    }

    public void a(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.x = f2;
    }

    public void a(boolean z2) {
        int i2 = this.f8633a;
        if (i2 == 0) {
            this.z = z2;
        } else if (i2 == 1) {
            this.z = false;
        } else if (i2 == 2 || i2 == 3) {
            this.z = true;
        }
    }

    public void a(int i2, int i3, int i4) {
        if (i2 != 0 && e() != null && i3 > 0 && i4 > 0) {
            this.o = i2;
            this.B = n.a(i3, i4, e().getDrawable(i2, null));
        }
    }
}
