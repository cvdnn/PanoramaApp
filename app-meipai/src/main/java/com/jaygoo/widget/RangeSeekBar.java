package com.jaygoo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.baidu.picapture.ui.panorama.capture.PanoramaCaptureActivity;
import com.baidubce.auth.NTLMEngineImpl;
import e.c.f.n.n;
import e.h.a.a;
import e.h.a.d;
import e.h.a.e;
import e.h.a.f;
import e.h.a.g;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RangeSeekBar extends View {
    public int A;
    public boolean B;
    public int C;
    public float D;
    public float E;
    public boolean F;
    public float G;
    public float H;
    public boolean I;
    public Paint J;
    public RectF K;
    public RectF L;
    public Rect M;
    public RectF N;
    public Rect O;
    public f P;
    public f Q;
    public f R;
    public Bitmap S;
    public Bitmap T;
    public List<Bitmap> U;
    public int V;
    public a W;

    /* renamed from: a reason: collision with root package name */
    public int f3532a;

    /* renamed from: b reason: collision with root package name */
    public int f3533b;

    /* renamed from: c reason: collision with root package name */
    public int f3534c;

    /* renamed from: d reason: collision with root package name */
    public int f3535d;

    /* renamed from: e reason: collision with root package name */
    public int f3536e;

    /* renamed from: f reason: collision with root package name */
    public int f3537f;

    /* renamed from: g reason: collision with root package name */
    public int f3538g;

    /* renamed from: h reason: collision with root package name */
    public int f3539h;

    /* renamed from: i reason: collision with root package name */
    public int f3540i;

    /* renamed from: j reason: collision with root package name */
    public int f3541j;
    public int k;
    public int l;
    public CharSequence[] m;
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float u;
    public int v;
    public int w;
    public float x;
    public float y;
    public float z;

    public RangeSeekBar(Context context) {
        this(context, null);
    }

    public final void a() {
        if (this.S == null) {
            this.S = n.a(getContext(), this.t, this.s, this.q);
        }
        if (this.T == null) {
            this.T = n.a(getContext(), this.t, this.s, this.r);
        }
    }

    public final void b() {
        if (e() && this.C != 0 && this.U.isEmpty()) {
            Bitmap a2 = n.a(getContext(), (int) this.x, (int) this.y, this.C);
            for (int i2 = 0; i2 <= this.A; i2++) {
                this.U.add(a2);
            }
        }
    }

    public final void c() {
        f fVar = this.R;
        if (fVar != null && fVar.s > 1.0f && this.I) {
            this.I = false;
            fVar.P = fVar.q;
            fVar.Q = fVar.r;
            int progressBottom = fVar.I.getProgressBottom();
            int i2 = fVar.Q;
            int i3 = i2 / 2;
            fVar.v = progressBottom - i3;
            fVar.w = i3 + progressBottom;
            fVar.a(fVar.o, fVar.P, i2);
        }
    }

    public final void d() {
        f fVar = this.R;
        if (fVar != null && fVar.s > 1.0f && !this.I) {
            this.I = true;
            fVar.P = (int) fVar.g();
            fVar.Q = (int) fVar.f();
            int progressBottom = fVar.I.getProgressBottom();
            int i2 = fVar.Q;
            int i3 = i2 / 2;
            fVar.v = progressBottom - i3;
            fVar.w = i3 + progressBottom;
            fVar.a(fVar.o, fVar.P, i2);
        }
    }

    public final boolean e() {
        return this.A >= 1 && this.y > 0.0f && this.x > 0.0f;
    }

    public int getGravity() {
        return this.v;
    }

    public f getLeftSeekBar() {
        return this.P;
    }

    public float getMaxProgress() {
        return this.E;
    }

    public float getMinInterval() {
        return this.u;
    }

    public float getMinProgress() {
        return this.D;
    }

    public int getProgressBottom() {
        return this.f3533b;
    }

    public int getProgressColor() {
        return this.o;
    }

    public int getProgressDefaultColor() {
        return this.p;
    }

    public int getProgressDefaultDrawableId() {
        return this.r;
    }

    public int getProgressDrawableId() {
        return this.q;
    }

    public int getProgressHeight() {
        return this.s;
    }

    public int getProgressLeft() {
        return this.f3534c;
    }

    public int getProgressPaddingRight() {
        return this.V;
    }

    public float getProgressRadius() {
        return this.n;
    }

    public int getProgressRight() {
        return this.f3535d;
    }

    public int getProgressTop() {
        return this.f3532a;
    }

    public int getProgressWidth() {
        return this.t;
    }

    public g[] getRangeSeekBarState() {
        g gVar = new g();
        float c2 = this.P.c();
        gVar.f8646b = c2;
        gVar.f8645a = String.valueOf(c2);
        if (n.a(gVar.f8646b, this.D) == 0) {
            gVar.f8647c = true;
        } else if (n.a(gVar.f8646b, this.E) == 0) {
            gVar.f8648d = true;
        }
        g gVar2 = new g();
        if (this.f3536e == 2) {
            float c3 = this.Q.c();
            gVar2.f8646b = c3;
            gVar2.f8645a = String.valueOf(c3);
            if (n.a(this.Q.x, this.D) == 0) {
                gVar2.f8647c = true;
            } else if (n.a(this.Q.x, this.E) == 0) {
                gVar2.f8648d = true;
            }
        }
        return new g[]{gVar, gVar2};
    }

    public float getRawHeight() {
        if (this.f3536e == 1) {
            float d2 = this.P.d();
            if (this.f3541j != 1 || this.m == null) {
                return d2;
            }
            return (((float) this.s) / 2.0f) + (d2 - (this.P.f() / 2.0f)) + Math.max((this.P.f() - ((float) this.s)) / 2.0f, (float) getTickMarkRawHeight());
        }
        float max = Math.max(this.P.d(), this.Q.d());
        if (this.f3541j != 1 || this.m == null) {
            return max;
        }
        float max2 = Math.max(this.P.f(), this.Q.f());
        return (((float) this.s) / 2.0f) + (max - (max2 / 2.0f)) + Math.max((max2 - ((float) this.s)) / 2.0f, (float) getTickMarkRawHeight());
    }

    public f getRightSeekBar() {
        return this.Q;
    }

    public int getSeekBarMode() {
        return this.f3536e;
    }

    public int getSteps() {
        return this.A;
    }

    public List<Bitmap> getStepsBitmaps() {
        return this.U;
    }

    public int getStepsColor() {
        return this.w;
    }

    public int getStepsDrawableId() {
        return this.C;
    }

    public float getStepsHeight() {
        return this.y;
    }

    public float getStepsRadius() {
        return this.z;
    }

    public float getStepsWidth() {
        return this.x;
    }

    public int getTickMarkGravity() {
        return this.f3540i;
    }

    public int getTickMarkInRangeTextColor() {
        return this.l;
    }

    public int getTickMarkLayoutGravity() {
        return this.f3541j;
    }

    public int getTickMarkMode() {
        return this.f3537f;
    }

    public int getTickMarkRawHeight() {
        CharSequence[] charSequenceArr = this.m;
        if (charSequenceArr == null || charSequenceArr.length <= 0) {
            return 0;
        }
        return n.a(String.valueOf(charSequenceArr[0]), (float) this.f3539h).height() + this.f3538g + 3;
    }

    public CharSequence[] getTickMarkTextArray() {
        return this.m;
    }

    public int getTickMarkTextColor() {
        return this.k;
    }

    public int getTickMarkTextMargin() {
        return this.f3538g;
    }

    public int getTickMarkTextSize() {
        return this.f3539h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r14) {
        /*
            r13 = this;
            super.onDraw(r14)
            android.graphics.Paint r0 = r13.J
            java.lang.CharSequence[] r1 = r13.m
            r2 = 2
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x00cb
            int r6 = r13.t
            int r1 = r1.length
            int r1 = r1 - r5
            int r6 = r6 / r1
            r1 = r4
        L_0x0014:
            java.lang.CharSequence[] r7 = r13.m
            int r8 = r7.length
            if (r1 >= r8) goto L_0x00cb
            r7 = r7[r1]
            java.lang.String r7 = r7.toString()
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x0027
            goto L_0x00c7
        L_0x0027:
            int r8 = r7.length()
            android.graphics.Rect r9 = r13.O
            r0.getTextBounds(r7, r4, r8, r9)
            int r8 = r13.k
            r0.setColor(r8)
            int r8 = r13.f3537f
            if (r8 != r5) goto L_0x0066
            int r8 = r13.f3540i
            if (r8 != r2) goto L_0x004c
            int r8 = r13.getProgressLeft()
            int r9 = r1 * r6
            int r9 = r9 + r8
            android.graphics.Rect r8 = r13.O
            int r8 = r8.width()
            int r9 = r9 - r8
            goto L_0x0064
        L_0x004c:
            if (r8 != r5) goto L_0x005d
            int r8 = r13.getProgressLeft()
            int r9 = r1 * r6
            int r9 = r9 + r8
            float r8 = (float) r9
            android.graphics.Rect r9 = r13.O
            int r9 = r9.width()
            goto L_0x00a5
        L_0x005d:
            int r8 = r13.getProgressLeft()
            int r9 = r1 * r6
            int r9 = r9 + r8
        L_0x0064:
            float r8 = (float) r9
            goto L_0x00a8
        L_0x0066:
            float r8 = java.lang.Float.parseFloat(r7)     // Catch:{ NumberFormatException -> 0x006b }
            goto L_0x006c
        L_0x006b:
            r8 = 0
        L_0x006c:
            e.h.a.g[] r9 = r13.getRangeSeekBarState()
            r10 = r9[r4]
            float r10 = r10.f8646b
            int r10 = e.c.f.n.n.a(r8, r10)
            r11 = -1
            if (r10 == r11) goto L_0x008e
            r9 = r9[r5]
            float r9 = r9.f8646b
            int r9 = e.c.f.n.n.a(r8, r9)
            if (r9 == r5) goto L_0x008e
            int r9 = r13.f3536e
            if (r9 != r2) goto L_0x008e
            int r9 = r13.l
            r0.setColor(r9)
        L_0x008e:
            int r9 = r13.getProgressLeft()
            float r9 = (float) r9
            int r10 = r13.t
            float r10 = (float) r10
            float r11 = r13.D
            float r8 = r8 - r11
            float r8 = r8 * r10
            float r10 = r13.E
            float r10 = r10 - r11
            float r8 = r8 / r10
            float r8 = r8 + r9
            android.graphics.Rect r9 = r13.O
            int r9 = r9.width()
        L_0x00a5:
            float r9 = (float) r9
            float r9 = r9 / r3
            float r8 = r8 - r9
        L_0x00a8:
            int r9 = r13.f3541j
            if (r9 != 0) goto L_0x00b5
            int r9 = r13.getProgressTop()
            int r10 = r13.f3538g
            int r9 = r9 - r10
            float r9 = (float) r9
            goto L_0x00c4
        L_0x00b5:
            int r9 = r13.getProgressBottom()
            int r10 = r13.f3538g
            int r9 = r9 + r10
            android.graphics.Rect r10 = r13.O
            int r10 = r10.height()
            int r10 = r10 + r9
            float r9 = (float) r10
        L_0x00c4:
            r14.drawText(r7, r8, r9, r0)
        L_0x00c7:
            int r1 = r1 + 1
            goto L_0x0014
        L_0x00cb:
            android.graphics.Paint r0 = r13.J
            android.graphics.Bitmap r1 = r13.T
            boolean r1 = e.c.f.n.n.a(r1)
            r6 = 0
            if (r1 == 0) goto L_0x00de
            android.graphics.Bitmap r1 = r13.T
            android.graphics.RectF r7 = r13.K
            r14.drawBitmap(r1, r6, r7, r0)
            goto L_0x00ea
        L_0x00de:
            int r1 = r13.p
            r0.setColor(r1)
            android.graphics.RectF r1 = r13.K
            float r7 = r13.n
            r14.drawRoundRect(r1, r7, r7, r0)
        L_0x00ea:
            int r1 = r13.f3536e
            if (r1 != r2) goto L_0x0131
            android.graphics.RectF r1 = r13.L
            int r7 = r13.getProgressTop()
            float r7 = (float) r7
            r1.top = r7
            android.graphics.RectF r1 = r13.L
            e.h.a.f r7 = r13.P
            int r8 = r7.t
            float r8 = (float) r8
            float r7 = r7.g()
            float r7 = r7 / r3
            float r7 = r7 + r8
            int r8 = r13.t
            float r8 = (float) r8
            e.h.a.f r9 = r13.P
            float r9 = r9.x
            float r8 = r8 * r9
            float r8 = r8 + r7
            r1.left = r8
            android.graphics.RectF r1 = r13.L
            e.h.a.f r7 = r13.Q
            int r8 = r7.t
            float r8 = (float) r8
            float r7 = r7.g()
            float r7 = r7 / r3
            float r7 = r7 + r8
            int r8 = r13.t
            float r8 = (float) r8
            e.h.a.f r9 = r13.Q
            float r9 = r9.x
            float r8 = r8 * r9
            float r8 = r8 + r7
            r1.right = r8
            android.graphics.RectF r1 = r13.L
            int r7 = r13.getProgressBottom()
            float r7 = (float) r7
            r1.bottom = r7
            goto L_0x016a
        L_0x0131:
            android.graphics.RectF r1 = r13.L
            int r7 = r13.getProgressTop()
            float r7 = (float) r7
            r1.top = r7
            android.graphics.RectF r1 = r13.L
            e.h.a.f r7 = r13.P
            int r8 = r7.t
            float r8 = (float) r8
            float r7 = r7.g()
            float r7 = r7 / r3
            float r7 = r7 + r8
            r1.left = r7
            android.graphics.RectF r1 = r13.L
            e.h.a.f r7 = r13.P
            int r8 = r7.t
            float r8 = (float) r8
            float r7 = r7.g()
            float r7 = r7 / r3
            float r7 = r7 + r8
            int r8 = r13.t
            float r8 = (float) r8
            e.h.a.f r9 = r13.P
            float r9 = r9.x
            float r8 = r8 * r9
            float r8 = r8 + r7
            r1.right = r8
            android.graphics.RectF r1 = r13.L
            int r7 = r13.getProgressBottom()
            float r7 = (float) r7
            r1.bottom = r7
        L_0x016a:
            android.graphics.Bitmap r1 = r13.S
            boolean r1 = e.c.f.n.n.a(r1)
            if (r1 == 0) goto L_0x01b3
            android.graphics.Rect r0 = r13.M
            r0.top = r4
            android.graphics.Bitmap r1 = r13.S
            int r1 = r1.getHeight()
            r0.bottom = r1
            android.graphics.Bitmap r0 = r13.S
            int r0 = r0.getWidth()
            int r1 = r13.f3536e
            if (r1 != r2) goto L_0x019c
            android.graphics.Rect r1 = r13.M
            float r0 = (float) r0
            e.h.a.f r7 = r13.P
            float r7 = r7.x
            float r7 = r7 * r0
            int r7 = (int) r7
            r1.left = r7
            e.h.a.f r7 = r13.Q
            float r7 = r7.x
            float r0 = r0 * r7
            int r0 = (int) r0
            r1.right = r0
            goto L_0x01a9
        L_0x019c:
            android.graphics.Rect r1 = r13.M
            r1.left = r4
            float r0 = (float) r0
            e.h.a.f r7 = r13.P
            float r7 = r7.x
            float r0 = r0 * r7
            int r0 = (int) r0
            r1.right = r0
        L_0x01a9:
            android.graphics.Bitmap r0 = r13.S
            android.graphics.Rect r1 = r13.M
            android.graphics.RectF r7 = r13.L
            r14.drawBitmap(r0, r1, r7, r6)
            goto L_0x01bf
        L_0x01b3:
            int r1 = r13.o
            r0.setColor(r1)
            android.graphics.RectF r1 = r13.L
            float r7 = r13.n
            r14.drawRoundRect(r1, r7, r7, r0)
        L_0x01bf:
            android.graphics.Paint r0 = r13.J
            boolean r1 = r13.e()
            if (r1 != 0) goto L_0x01c8
            goto L_0x022a
        L_0x01c8:
            int r1 = r13.getProgressWidth()
            int r7 = r13.A
            int r1 = r1 / r7
            float r7 = r13.y
            int r8 = r13.getProgressHeight()
            float r8 = (float) r8
            float r7 = r7 - r8
            float r7 = r7 / r3
        L_0x01d8:
            int r8 = r13.A
            if (r4 > r8) goto L_0x022a
            int r8 = r13.getProgressLeft()
            int r9 = r4 * r1
            int r9 = r9 + r8
            float r8 = (float) r9
            float r9 = r13.x
            float r9 = r9 / r3
            float r8 = r8 - r9
            android.graphics.RectF r9 = r13.N
            int r10 = r13.getProgressTop()
            float r10 = (float) r10
            float r10 = r10 - r7
            float r11 = r13.x
            float r11 = r11 + r8
            int r12 = r13.getProgressBottom()
            float r12 = (float) r12
            float r12 = r12 + r7
            r9.set(r8, r10, r11, r12)
            java.util.List<android.graphics.Bitmap> r8 = r13.U
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x021b
            java.util.List<android.graphics.Bitmap> r8 = r13.U
            int r8 = r8.size()
            if (r8 > r4) goto L_0x020d
            goto L_0x021b
        L_0x020d:
            java.util.List<android.graphics.Bitmap> r8 = r13.U
            java.lang.Object r8 = r8.get(r4)
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.RectF r9 = r13.N
            r14.drawBitmap(r8, r6, r9, r0)
            goto L_0x0227
        L_0x021b:
            int r8 = r13.w
            r0.setColor(r8)
            android.graphics.RectF r8 = r13.N
            float r9 = r13.z
            r14.drawRoundRect(r8, r9, r9, r0)
        L_0x0227:
            int r4 = r4 + 1
            goto L_0x01d8
        L_0x022a:
            e.h.a.f r0 = r13.P
            int r1 = r0.f8633a
            r3 = 3
            if (r1 != r3) goto L_0x0234
            r0.a(r5)
        L_0x0234:
            e.h.a.f r0 = r13.P
            r0.a(r14)
            int r0 = r13.f3536e
            if (r0 != r2) goto L_0x024b
            e.h.a.f r0 = r13.Q
            int r1 = r0.f8633a
            if (r1 != r3) goto L_0x0246
            r0.a(r5)
        L_0x0246:
            e.h.a.f r0 = r13.Q
            r0.a(r14)
        L_0x024b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jaygoo.widget.RangeSeekBar.onDraw(android.graphics.Canvas):void");
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        float f2;
        float f3;
        float f4;
        int size = MeasureSpec.getSize(i3);
        int mode = MeasureSpec.getMode(i3);
        if (mode == 1073741824) {
            i4 = MeasureSpec.makeMeasureSpec(size, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
        } else if (mode == Integer.MIN_VALUE && (getParent() instanceof ViewGroup) && size == -1) {
            i4 = MeasureSpec.makeMeasureSpec(((ViewGroup) getParent()).getMeasuredHeight(), Integer.MIN_VALUE);
        } else {
            if (this.v == 2) {
                if (this.m == null || this.f3541j != 1) {
                    f3 = getRawHeight();
                    f4 = Math.max(this.P.f(), this.Q.f()) / 2.0f;
                } else {
                    f3 = getRawHeight();
                    f4 = (float) getTickMarkRawHeight();
                }
                f2 = (f3 - f4) * 2.0f;
            } else {
                f2 = getRawHeight();
            }
            i4 = MeasureSpec.makeMeasureSpec((int) f2, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
        }
        super.onMeasure(i2, i4);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        try {
            e eVar = (e) parcelable;
            super.onRestoreInstanceState(eVar.getSuperState());
            a(eVar.f8627a, eVar.f8628b, eVar.f8629c);
            a(eVar.f8631e, eVar.f8632f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f8627a = this.D;
        eVar.f8628b = this.E;
        eVar.f8629c = this.u;
        g[] rangeSeekBarState = getRangeSeekBarState();
        eVar.f8631e = rangeSeekBarState[0].f8646b;
        eVar.f8632f = rangeSeekBarState[1].f8646b;
        return eVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        float f2;
        super.onSizeChanged(i2, i3, i4, i5);
        int paddingBottom = (i3 - getPaddingBottom()) - getPaddingTop();
        if (i3 > 0) {
            int i6 = this.v;
            if (i6 == 0) {
                if (this.P.f8633a == 1 && this.Q.f8633a == 1) {
                    f2 = 0.0f;
                } else {
                    f2 = (float) Math.max(this.P.b(), this.Q.b());
                }
                float f3 = (float) this.s;
                float max = Math.max(this.P.f(), this.Q.f()) - (f3 / 2.0f);
                this.f3532a = (int) (((max - f3) / 2.0f) + f2);
                if (this.m != null && this.f3541j == 0) {
                    this.f3532a = (int) Math.max((float) getTickMarkRawHeight(), ((max - ((float) this.s)) / 2.0f) + f2);
                }
                this.f3533b = this.f3532a + this.s;
            } else if (i6 == 1) {
                if (this.m == null || this.f3541j != 1) {
                    this.f3533b = (int) ((((float) this.s) / 2.0f) + (((float) paddingBottom) - (Math.max(this.P.f(), this.Q.f()) / 2.0f)));
                } else {
                    this.f3533b = paddingBottom - getTickMarkRawHeight();
                }
                this.f3532a = this.f3533b - this.s;
            } else {
                int i7 = this.s;
                int i8 = (paddingBottom - i7) / 2;
                this.f3532a = i8;
                this.f3533b = i8 + i7;
            }
            int max2 = ((int) Math.max(this.P.g(), this.Q.g())) / 2;
            this.f3534c = getPaddingLeft() + max2;
            int paddingRight = (i2 - max2) - getPaddingRight();
            this.f3535d = paddingRight;
            this.t = paddingRight - this.f3534c;
            this.K.set((float) getProgressLeft(), (float) getProgressTop(), (float) getProgressRight(), (float) getProgressBottom());
            this.V = i2 - this.f3535d;
            if (this.n <= 0.0f) {
                this.n = (float) ((int) (((float) (getProgressBottom() - getProgressTop())) * 0.45f));
            }
            a();
        }
        a(this.D, this.E, this.u);
        int progressTop = (getProgressTop() + getProgressBottom()) / 2;
        this.P.a(getProgressLeft(), progressTop);
        if (this.f3536e == 2) {
            this.Q.a(getProgressLeft(), progressTop);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.F) {
            return true;
        }
        int action = motionEvent.getAction();
        float f2 = 1.0f;
        if (action != 0) {
            if (action == 1) {
                if (e() && this.B) {
                    float f3 = 1.0f / ((float) this.A);
                    this.R.a(((float) new BigDecimal((double) (a(motionEvent.getX()) / f3)).setScale(0, RoundingMode.HALF_UP).intValue()) * f3);
                }
                if (this.f3536e == 2) {
                    this.Q.a(false);
                }
                this.P.a(false);
                this.R.j();
                c();
                if (this.W != null) {
                    g[] rangeSeekBarState = getRangeSeekBarState();
                    ((PanoramaCaptureActivity.a) this.W).a(this, rangeSeekBarState[0].f8646b, rangeSeekBarState[1].f8646b, false);
                }
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                a aVar = this.W;
                if (aVar != null) {
                    PanoramaCaptureActivity.a aVar2 = (PanoramaCaptureActivity.a) aVar;
                }
                a(false);
            } else if (action == 2) {
                float x2 = motionEvent.getX();
                if (this.f3536e == 2 && this.P.x == this.Q.x) {
                    this.R.j();
                    a aVar3 = this.W;
                    if (aVar3 != null) {
                        PanoramaCaptureActivity.a aVar4 = (PanoramaCaptureActivity.a) aVar3;
                    }
                    if (x2 - this.G > 0.0f) {
                        f fVar = this.R;
                        if (fVar != this.Q) {
                            fVar.a(false);
                            c();
                            this.R = this.Q;
                        }
                    } else {
                        f fVar2 = this.R;
                        if (fVar2 != this.P) {
                            fVar2.a(false);
                            c();
                            this.R = this.P;
                        }
                    }
                    a aVar5 = this.W;
                    if (aVar5 != null) {
                        PanoramaCaptureActivity.a aVar6 = (PanoramaCaptureActivity.a) aVar5;
                    }
                }
                d();
                f fVar3 = this.R;
                float f4 = fVar3.y;
                if (f4 < 1.0f) {
                    f2 = 0.1f + f4;
                }
                fVar3.y = f2;
                this.G = x2;
                this.R.a(a(x2));
                this.R.a(true);
                if (this.W != null) {
                    g[] rangeSeekBarState2 = getRangeSeekBarState();
                    ((PanoramaCaptureActivity.a) this.W).a(this, rangeSeekBarState2[0].f8646b, rangeSeekBarState2[1].f8646b, true);
                }
                invalidate();
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                a(true);
            } else if (action == 3) {
                if (this.f3536e == 2) {
                    this.Q.a(false);
                }
                f fVar4 = this.R;
                if (fVar4 == this.P) {
                    c();
                } else if (fVar4 == this.Q) {
                    c();
                }
                this.P.a(false);
                if (this.W != null) {
                    g[] rangeSeekBarState3 = getRangeSeekBarState();
                    ((PanoramaCaptureActivity.a) this.W).a(this, rangeSeekBarState3[0].f8646b, rangeSeekBarState3[1].f8646b, false);
                }
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                a(false);
            }
            return super.onTouchEvent(motionEvent);
        }
        this.G = motionEvent.getX();
        motionEvent.getY();
        if (this.f3536e != 2) {
            this.R = this.P;
            d();
        } else if (this.Q.x >= 1.0f && this.P.a(motionEvent.getX(), motionEvent.getY())) {
            this.R = this.P;
            d();
        } else if (this.Q.a(motionEvent.getX(), motionEvent.getY())) {
            this.R = this.Q;
            d();
        } else {
            float progressLeft = ((this.G - ((float) getProgressLeft())) * 1.0f) / ((float) this.t);
            if (Math.abs(this.P.x - progressLeft) < Math.abs(this.Q.x - progressLeft)) {
                this.R = this.P;
            } else {
                this.R = this.Q;
            }
            this.R.a(a(this.G));
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        a aVar7 = this.W;
        if (aVar7 != null) {
            PanoramaCaptureActivity.a aVar8 = (PanoramaCaptureActivity.a) aVar7;
        }
        a(true);
        return true;
    }

    public void setEnableThumbOverlap(boolean z2) {
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.F = z2;
    }

    public void setGravity(int i2) {
        this.v = i2;
    }

    public void setIndicatorText(String str) {
        this.P.F = str;
        if (this.f3536e == 2) {
            this.Q.F = str;
        }
    }

    public void setIndicatorTextDecimalFormat(String str) {
        f fVar = this.P;
        if (fVar != null) {
            fVar.O = new DecimalFormat(str);
            if (this.f3536e == 2) {
                f fVar2 = this.Q;
                if (fVar2 != null) {
                    fVar2.O = new DecimalFormat(str);
                    return;
                }
                throw null;
            }
            return;
        }
        throw null;
    }

    public void setIndicatorTextStringFormat(String str) {
        this.P.J = str;
        if (this.f3536e == 2) {
            this.Q.J = str;
        }
    }

    public void setOnRangeChangedListener(a aVar) {
        this.W = aVar;
    }

    public void setProgress(float f2) {
        a(f2, this.E);
    }

    public void setProgressBottom(int i2) {
        this.f3533b = i2;
    }

    public void setProgressColor(int i2) {
        this.o = i2;
    }

    public void setProgressDefaultColor(int i2) {
        this.p = i2;
    }

    public void setProgressDefaultDrawableId(int i2) {
        this.r = i2;
        this.T = null;
        a();
    }

    public void setProgressDrawableId(int i2) {
        this.q = i2;
        this.S = null;
        a();
    }

    public void setProgressHeight(int i2) {
        this.s = i2;
    }

    public void setProgressLeft(int i2) {
        this.f3534c = i2;
    }

    public void setProgressRadius(float f2) {
        this.n = f2;
    }

    public void setProgressRight(int i2) {
        this.f3535d = i2;
    }

    public void setProgressTop(int i2) {
        this.f3532a = i2;
    }

    public void setProgressWidth(int i2) {
        this.t = i2;
    }

    public void setSeekBarMode(int i2) {
        this.f3536e = i2;
        f fVar = this.Q;
        boolean z2 = true;
        if (i2 == 1) {
            z2 = false;
        }
        fVar.H = z2;
    }

    public void setSteps(int i2) {
        this.A = i2;
    }

    public void setStepsAutoBonding(boolean z2) {
        this.B = z2;
    }

    public void setStepsBitmaps(List<Bitmap> list) {
        if (list == null || list.isEmpty() || list.size() <= this.A) {
            throw new IllegalArgumentException("stepsBitmaps must > steps !");
        }
        this.U.clear();
        this.U.addAll(list);
    }

    public void setStepsColor(int i2) {
        this.w = i2;
    }

    public void setStepsDrawable(List<Integer> list) {
        if (list == null || list.isEmpty() || list.size() <= this.A) {
            throw new IllegalArgumentException("stepsDrawableIds must > steps !");
        } else if (e()) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(n.a(getContext(), (int) this.x, (int) this.y, ((Integer) list.get(i2)).intValue()));
            }
            setStepsBitmaps(arrayList);
        } else {
            throw new IllegalArgumentException("stepsWidth must > 0, stepsHeight must > 0,steps must > 0 First!!");
        }
    }

    public void setStepsDrawableId(int i2) {
        this.U.clear();
        this.C = i2;
        b();
    }

    public void setStepsHeight(float f2) {
        this.y = f2;
    }

    public void setStepsRadius(float f2) {
        this.z = f2;
    }

    public void setStepsWidth(float f2) {
        this.x = f2;
    }

    public void setTickMarkGravity(int i2) {
        this.f3540i = i2;
    }

    public void setTickMarkInRangeTextColor(int i2) {
        this.l = i2;
    }

    public void setTickMarkLayoutGravity(int i2) {
        this.f3541j = i2;
    }

    public void setTickMarkMode(int i2) {
        this.f3537f = i2;
    }

    public void setTickMarkTextArray(CharSequence[] charSequenceArr) {
        this.m = charSequenceArr;
    }

    public void setTickMarkTextColor(int i2) {
        this.k = i2;
    }

    public void setTickMarkTextMargin(int i2) {
        this.f3538g = i2;
    }

    public void setTickMarkTextSize(int i2) {
        this.f3539h = i2;
    }

    public void setTypeface(Typeface typeface) {
        this.J.setTypeface(typeface);
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z2 = true;
        this.F = true;
        this.I = false;
        this.J = new Paint();
        this.K = new RectF();
        this.L = new RectF();
        this.M = new Rect();
        this.N = new RectF();
        this.O = new Rect();
        this.U = new ArrayList();
        try {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.RangeSeekBar);
            this.f3536e = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_mode, 2);
            this.D = obtainStyledAttributes.getFloat(d.RangeSeekBar_rsb_min, 0.0f);
            this.E = obtainStyledAttributes.getFloat(d.RangeSeekBar_rsb_max, 100.0f);
            this.u = obtainStyledAttributes.getFloat(d.RangeSeekBar_rsb_min_interval, 0.0f);
            this.v = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_gravity, 0);
            this.o = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_progress_color, -11806366);
            this.n = (float) ((int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_progress_radius, -1.0f));
            this.p = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_progress_default_color, -2631721);
            this.q = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_progress_drawable, 0);
            this.r = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_progress_drawable_default, 0);
            this.s = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_progress_height, (float) n.a(getContext(), 2.0f));
            this.f3537f = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_tick_mark_mode, 0);
            this.f3540i = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_tick_mark_gravity, 1);
            this.f3541j = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_tick_mark_layout_gravity, 0);
            this.m = obtainStyledAttributes.getTextArray(d.RangeSeekBar_rsb_tick_mark_text_array);
            this.f3538g = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_tick_mark_text_margin, (float) n.a(getContext(), 7.0f));
            this.f3539h = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_tick_mark_text_size, (float) n.a(getContext(), 12.0f));
            this.k = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_tick_mark_text_color, this.p);
            this.l = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_tick_mark_text_color, this.o);
            this.A = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_steps, 0);
            this.w = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_step_color, -6447715);
            this.z = obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_step_radius, 0.0f);
            this.x = obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_step_width, 0.0f);
            this.y = obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_step_height, 0.0f);
            this.C = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_step_drawable, 0);
            this.B = obtainStyledAttributes.getBoolean(d.RangeSeekBar_rsb_step_auto_bonding, true);
            obtainStyledAttributes.recycle();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.J.setStyle(Style.FILL);
        this.J.setColor(this.p);
        this.J.setTextSize((float) this.f3539h);
        this.P = new f(this, attributeSet, true);
        f fVar = new f(this, attributeSet, false);
        this.Q = fVar;
        if (this.f3536e == 1) {
            z2 = false;
        }
        fVar.H = z2;
        b();
    }

    public final void a(boolean z2) {
        boolean z3 = false;
        if (z2) {
            f fVar = this.R;
            if (fVar != null) {
                if (fVar == this.P) {
                    z3 = true;
                }
                this.P.G = z3;
                if (this.f3536e == 2) {
                    this.Q.G = !z3;
                    return;
                }
                return;
            }
        }
        this.P.G = false;
        if (this.f3536e == 2) {
            this.Q.G = false;
        }
    }

    public float a(float f2) {
        float f3 = 0.0f;
        if (this.R == null) {
            return 0.0f;
        }
        float progressLeft = ((f2 - ((float) getProgressLeft())) * 1.0f) / ((float) this.t);
        if (f2 >= ((float) getProgressLeft())) {
            f3 = f2 > ((float) getProgressRight()) ? 1.0f : progressLeft;
        }
        if (this.f3536e == 2) {
            f fVar = this.R;
            f fVar2 = this.P;
            if (fVar == fVar2) {
                float f4 = this.Q.x;
                float f5 = this.H;
                if (f3 > f4 - f5) {
                    f3 = f4 - f5;
                }
            } else if (fVar == this.Q) {
                float f6 = fVar2.x;
                float f7 = this.H;
                if (f3 < f6 + f7) {
                    f3 = f6 + f7;
                }
            }
        }
        return f3;
    }

    public void a(float f2, float f3) {
        float min = Math.min(f2, f3);
        float max = Math.max(min, f3);
        float f4 = max - min;
        float f5 = this.u;
        if (f4 < f5) {
            min = max - f5;
        }
        float f6 = this.D;
        if (min >= f6) {
            float f7 = this.E;
            if (max <= f7) {
                float f8 = f7 - f6;
                this.P.x = Math.abs(min - f6) / f8;
                if (this.f3536e == 2) {
                    this.Q.x = Math.abs(max - this.D) / f8;
                }
                a aVar = this.W;
                if (aVar != null) {
                    ((PanoramaCaptureActivity.a) aVar).a(this, min, max, false);
                }
                invalidate();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("setProgress() max > (preset max - offsetValue) . #max:");
            sb.append(max);
            sb.append(" #preset max:");
            sb.append(max);
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setProgress() min < (preset min - offsetValue) . #min:");
        sb2.append(min);
        sb2.append(" #preset min:");
        sb2.append(max);
        throw new IllegalArgumentException(sb2.toString());
    }

    public void a(float f2, float f3, float f4) {
        if (f3 <= f2) {
            StringBuilder sb = new StringBuilder();
            sb.append("setRange() max must be greater than min ! #max:");
            sb.append(f3);
            sb.append(" #min:");
            sb.append(f2);
            throw new IllegalArgumentException(sb.toString());
        } else if (f4 >= 0.0f) {
            float f5 = f3 - f2;
            if (f4 < f5) {
                this.E = f3;
                this.D = f2;
                this.u = f4;
                float f6 = f4 / f5;
                this.H = f6;
                if (this.f3536e == 2) {
                    float f7 = this.P.x;
                    if (f7 + f6 <= 1.0f) {
                        float f8 = f7 + f6;
                        f fVar = this.Q;
                        if (f8 > fVar.x) {
                            fVar.x = f7 + f6;
                        }
                    }
                    float f9 = this.Q.x;
                    float f10 = this.H;
                    if (f9 - f10 >= 0.0f) {
                        float f11 = f9 - f10;
                        f fVar2 = this.P;
                        if (f11 < fVar2.x) {
                            fVar2.x = f9 - f10;
                        }
                    }
                }
                invalidate();
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setRange() interval must be less than (max - min) ! #minInterval:");
            sb2.append(f4);
            sb2.append(" #max - min:");
            sb2.append(f5);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("setRange() interval must be greater than zero ! #minInterval:");
            sb3.append(f4);
            throw new IllegalArgumentException(sb3.toString());
        }
    }
}
