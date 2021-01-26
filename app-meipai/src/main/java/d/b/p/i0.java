package d.b.p;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.baidubce.auth.NTLMEngineImpl;
import d.b.j;

/* compiled from: LinearLayoutCompat */
public class i0 extends ViewGroup {

    /* renamed from: a reason: collision with root package name */
    public boolean f4355a;

    /* renamed from: b reason: collision with root package name */
    public int f4356b;

    /* renamed from: c reason: collision with root package name */
    public int f4357c;

    /* renamed from: d reason: collision with root package name */
    public int f4358d;

    /* renamed from: e reason: collision with root package name */
    public int f4359e;

    /* renamed from: f reason: collision with root package name */
    public int f4360f;

    /* renamed from: g reason: collision with root package name */
    public float f4361g;

    /* renamed from: h reason: collision with root package name */
    public boolean f4362h;

    /* renamed from: i reason: collision with root package name */
    public int[] f4363i;

    /* renamed from: j reason: collision with root package name */
    public int[] f4364j;
    public Drawable k;
    public int l;
    public int m;
    public int n;
    public int o;

    /* compiled from: LinearLayoutCompat */
    public static class a extends MarginLayoutParams {

        /* renamed from: a reason: collision with root package name */
        public float f4365a;

        /* renamed from: b reason: collision with root package name */
        public int f4366b;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4366b = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.LinearLayoutCompat_Layout);
            this.f4365a = obtainStyledAttributes.getFloat(j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f4366b = obtainStyledAttributes.getInt(j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public a(int i2, int i3) {
            super(i2, i3);
            this.f4366b = -1;
            this.f4365a = 0.0f;
        }

        public a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f4366b = -1;
        }
    }

    public i0(Context context) {
        this(context, null);
    }

    public void a(Canvas canvas, int i2) {
        this.k.setBounds(getPaddingLeft() + this.o, i2, (getWidth() - getPaddingRight()) - this.o, this.m + i2);
        this.k.draw(canvas);
    }

    public void b(Canvas canvas, int i2) {
        this.k.setBounds(i2, getPaddingTop() + this.o, this.l + i2, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public int getBaseline() {
        if (this.f4356b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.f4356b;
        if (childCount > i2) {
            View childAt = getChildAt(i2);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i3 = this.f4357c;
                if (this.f4358d == 1) {
                    int i4 = this.f4359e & 112;
                    if (i4 != 48) {
                        if (i4 == 16) {
                            i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f4360f) / 2;
                        } else if (i4 == 80) {
                            i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f4360f;
                        }
                    }
                }
                return i3 + ((a) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.f4356b == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f4356b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.f4359e;
    }

    public int getOrientation() {
        return this.f4358d;
    }

    public int getShowDividers() {
        return this.n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f4361g;
    }

    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.k != null) {
            int i7 = 0;
            if (this.f4358d == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i7 < virtualChildCount) {
                    View childAt = getChildAt(i7);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !a(i7))) {
                        a(canvas, (childAt.getTop() - ((a) childAt.getLayoutParams()).topMargin) - this.m);
                    }
                    i7++;
                }
                if (a(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    if (childAt2 == null) {
                        i6 = (getHeight() - getPaddingBottom()) - this.m;
                    } else {
                        i6 = childAt2.getBottom() + ((a) childAt2.getLayoutParams()).bottomMargin;
                    }
                    a(canvas, i6);
                }
            } else {
                int virtualChildCount2 = getVirtualChildCount();
                boolean a2 = d1.a(this);
                while (i7 < virtualChildCount2) {
                    View childAt3 = getChildAt(i7);
                    if (!(childAt3 == null || childAt3.getVisibility() == 8 || !a(i7))) {
                        a aVar = (a) childAt3.getLayoutParams();
                        if (a2) {
                            i5 = childAt3.getRight() + aVar.rightMargin;
                        } else {
                            i5 = (childAt3.getLeft() - aVar.leftMargin) - this.l;
                        }
                        b(canvas, i5);
                    }
                    i7++;
                }
                if (a(virtualChildCount2)) {
                    View childAt4 = getChildAt(virtualChildCount2 - 1);
                    if (childAt4 != null) {
                        a aVar2 = (a) childAt4.getLayoutParams();
                        if (a2) {
                            i4 = childAt4.getLeft() - aVar2.leftMargin;
                            i3 = this.l;
                        } else {
                            i2 = childAt4.getRight() + aVar2.rightMargin;
                            b(canvas, i2);
                        }
                    } else if (a2) {
                        i2 = getPaddingLeft();
                        b(canvas, i2);
                    } else {
                        i4 = getWidth() - getPaddingRight();
                        i3 = this.l;
                    }
                    i2 = i4 - i3;
                    b(canvas, i2);
                }
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r25, int r26, int r27, int r28, int r29) {
        /*
            r24 = this;
            r0 = r24
            int r1 = r0.f4358d
            r2 = 80
            r3 = 16
            r4 = 8
            r5 = 5
            r6 = 8388615(0x800007, float:1.1754953E-38)
            r7 = 2
            r8 = 1
            if (r1 != r8) goto L_0x00b9
            int r1 = r24.getPaddingLeft()
            int r10 = r28 - r26
            int r11 = r24.getPaddingRight()
            int r11 = r10 - r11
            int r10 = r10 - r1
            int r12 = r24.getPaddingRight()
            int r10 = r10 - r12
            int r12 = r24.getVirtualChildCount()
            int r13 = r0.f4359e
            r14 = r13 & 112(0x70, float:1.57E-43)
            r6 = r6 & r13
            if (r14 == r3) goto L_0x0042
            if (r14 == r2) goto L_0x0036
            int r2 = r24.getPaddingTop()
            goto L_0x004d
        L_0x0036:
            int r2 = r24.getPaddingTop()
            int r2 = r2 + r29
            int r2 = r2 - r27
            int r3 = r0.f4360f
            int r2 = r2 - r3
            goto L_0x004d
        L_0x0042:
            int r2 = r24.getPaddingTop()
            int r3 = r29 - r27
            int r13 = r0.f4360f
            int r3 = r3 - r13
            int r3 = r3 / r7
            int r2 = r2 + r3
        L_0x004d:
            r3 = 0
        L_0x004e:
            if (r3 >= r12) goto L_0x01d1
            android.view.View r13 = r0.getChildAt(r3)
            if (r13 != 0) goto L_0x0059
            int r2 = r2 + 0
            goto L_0x00b3
        L_0x0059:
            int r14 = r13.getVisibility()
            if (r14 == r4) goto L_0x00b3
            int r14 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r16 = r13.getLayoutParams()
            r4 = r16
            d.b.p.i0$a r4 = (d.b.p.i0.a) r4
            int r9 = r4.f4366b
            if (r9 >= 0) goto L_0x0074
            r9 = r6
        L_0x0074:
            int r7 = d.h.k.m.m(r24)
            int r7 = android.view.Gravity.getAbsoluteGravity(r9, r7)
            r7 = r7 & 7
            if (r7 == r8) goto L_0x008b
            if (r7 == r5) goto L_0x0086
            int r7 = r4.leftMargin
            int r7 = r7 + r1
            goto L_0x0096
        L_0x0086:
            int r7 = r11 - r14
            int r9 = r4.rightMargin
            goto L_0x0095
        L_0x008b:
            int r7 = r10 - r14
            r9 = 2
            int r7 = r7 / r9
            int r7 = r7 + r1
            int r9 = r4.leftMargin
            int r7 = r7 + r9
            int r9 = r4.rightMargin
        L_0x0095:
            int r7 = r7 - r9
        L_0x0096:
            boolean r9 = r0.a(r3)
            if (r9 == 0) goto L_0x009f
            int r9 = r0.m
            int r2 = r2 + r9
        L_0x009f:
            int r9 = r4.topMargin
            int r2 = r2 + r9
            int r9 = r2 + 0
            int r14 = r14 + r7
            int r5 = r15 + r9
            r13.layout(r7, r9, r14, r5)
            int r4 = r4.bottomMargin
            int r15 = r15 + r4
            r4 = 0
            int r15 = r15 + r4
            int r15 = r15 + r2
            int r3 = r3 + 0
            r2 = r15
        L_0x00b3:
            int r3 = r3 + r8
            r4 = 8
            r5 = 5
            r7 = 2
            goto L_0x004e
        L_0x00b9:
            boolean r1 = d.b.p.d1.a(r24)
            int r4 = r24.getPaddingTop()
            int r5 = r29 - r27
            int r7 = r24.getPaddingBottom()
            int r7 = r5 - r7
            int r5 = r5 - r4
            int r9 = r24.getPaddingBottom()
            int r5 = r5 - r9
            int r9 = r24.getVirtualChildCount()
            int r10 = r0.f4359e
            r6 = r6 & r10
            r10 = r10 & 112(0x70, float:1.57E-43)
            boolean r11 = r0.f4355a
            int[] r12 = r0.f4363i
            int[] r13 = r0.f4364j
            int r14 = r24.getLayoutDirection()
            int r6 = android.view.Gravity.getAbsoluteGravity(r6, r14)
            if (r6 == r8) goto L_0x00fc
            r14 = 5
            if (r6 == r14) goto L_0x00f0
            int r6 = r24.getPaddingLeft()
            goto L_0x0108
        L_0x00f0:
            int r6 = r24.getPaddingLeft()
            int r6 = r6 + r28
            int r6 = r6 - r26
            int r14 = r0.f4360f
            int r6 = r6 - r14
            goto L_0x0108
        L_0x00fc:
            int r6 = r24.getPaddingLeft()
            int r14 = r28 - r26
            int r15 = r0.f4360f
            int r14 = r14 - r15
            r15 = 2
            int r14 = r14 / r15
            int r6 = r6 + r14
        L_0x0108:
            if (r1 == 0) goto L_0x010e
            int r1 = r9 + -1
            r15 = -1
            goto L_0x0110
        L_0x010e:
            r15 = r8
            r1 = 0
        L_0x0110:
            r17 = r6
            r6 = 0
        L_0x0113:
            if (r6 >= r9) goto L_0x01d1
            int r18 = r15 * r6
            int r8 = r18 + r1
            android.view.View r2 = r0.getChildAt(r8)
            if (r2 != 0) goto L_0x012b
            int r17 = r17 + 0
        L_0x0121:
            r27 = r1
            r29 = r9
            r21 = r10
            r1 = 0
        L_0x0128:
            r2 = 1
            goto L_0x01c3
        L_0x012b:
            int r3 = r2.getVisibility()
            r14 = 8
            if (r3 == r14) goto L_0x0121
            int r3 = r2.getMeasuredWidth()
            int r20 = r2.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r21 = r2.getLayoutParams()
            r14 = r21
            d.b.p.i0$a r14 = (d.b.p.i0.a) r14
            if (r11 == 0) goto L_0x0153
            r27 = r1
            int r1 = r14.height
            r29 = r9
            r9 = -1
            if (r1 == r9) goto L_0x0157
            int r9 = r2.getBaseline()
            goto L_0x0158
        L_0x0153:
            r27 = r1
            r29 = r9
        L_0x0157:
            r9 = -1
        L_0x0158:
            int r1 = r14.f4366b
            if (r1 >= 0) goto L_0x015d
            r1 = r10
        L_0x015d:
            r1 = r1 & 112(0x70, float:1.57E-43)
            r21 = r10
            r10 = 16
            if (r1 == r10) goto L_0x0195
            r10 = 48
            if (r1 == r10) goto L_0x0186
            r10 = 80
            if (r1 == r10) goto L_0x0170
            r1 = r4
            r10 = -1
            goto L_0x01a1
        L_0x0170:
            int r1 = r7 - r20
            int r10 = r14.bottomMargin
            int r1 = r1 - r10
            r10 = -1
            if (r9 == r10) goto L_0x01a1
            int r22 = r2.getMeasuredHeight()
            int r22 = r22 - r9
            r9 = 2
            r23 = r13[r9]
            int r23 = r23 - r22
            int r1 = r1 - r23
            goto L_0x01a1
        L_0x0186:
            r10 = -1
            int r1 = r14.topMargin
            int r1 = r1 + r4
            if (r9 == r10) goto L_0x01a1
            r19 = 1
            r22 = r12[r19]
            int r22 = r22 - r9
            int r1 = r22 + r1
            goto L_0x01a1
        L_0x0195:
            r10 = -1
            int r1 = r5 - r20
            r9 = 2
            int r1 = r1 / r9
            int r1 = r1 + r4
            int r9 = r14.topMargin
            int r1 = r1 + r9
            int r9 = r14.bottomMargin
            int r1 = r1 - r9
        L_0x01a1:
            boolean r8 = r0.a(r8)
            if (r8 == 0) goto L_0x01ab
            int r8 = r0.l
            int r17 = r17 + r8
        L_0x01ab:
            int r8 = r14.leftMargin
            int r17 = r17 + r8
            int r8 = r17 + 0
            int r9 = r3 + r8
            int r10 = r20 + r1
            r2.layout(r8, r1, r9, r10)
            int r1 = r14.rightMargin
            int r3 = r3 + r1
            r1 = 0
            int r3 = r3 + r1
            int r17 = r3 + r17
            int r6 = r6 + 0
            goto L_0x0128
        L_0x01c3:
            int r6 = r6 + r2
            r1 = r27
            r9 = r29
            r8 = r2
            r10 = r21
            r2 = 80
            r3 = 16
            goto L_0x0113
        L_0x01d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.p.i0.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:144:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0462  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0467  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x048f  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0494  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x049c  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04aa  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x04be  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x04e4  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0522  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x05bd  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x067b  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x069a  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0783  */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x084f  */
    /* JADX WARNING: Removed duplicated region for block: B:404:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r38, int r39) {
        /*
            r37 = this;
            r6 = r37
            r7 = r38
            r8 = r39
            int r0 = r6.f4358d
            r10 = -2
            r12 = 8
            r13 = 0
            r15 = 1
            r5 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            if (r0 != r15) goto L_0x035b
            r6.f4360f = r4
            int r3 = r37.getVirtualChildCount()
            int r2 = android.view.View.MeasureSpec.getMode(r38)
            int r1 = android.view.View.MeasureSpec.getMode(r39)
            int r0 = r6.f4356b
            boolean r9 = r6.f4362h
            r14 = r4
            r19 = r14
            r20 = r19
            r21 = r20
            r22 = r21
            r24 = r22
            r25 = r24
            r23 = r13
            r18 = r15
            r15 = r25
        L_0x0037:
            if (r15 >= r3) goto L_0x016a
            android.view.View r26 = r6.getChildAt(r15)
            if (r26 != 0) goto L_0x0045
            int r11 = r6.f4360f
            int r11 = r11 + r4
            r6.f4360f = r11
            goto L_0x004d
        L_0x0045:
            int r11 = r26.getVisibility()
            if (r11 != r12) goto L_0x0056
            int r15 = r15 + 0
        L_0x004d:
            r10 = r0
            r29 = r1
            r0 = r2
            r31 = r3
        L_0x0053:
            r1 = 1
            goto L_0x015a
        L_0x0056:
            boolean r11 = r6.a(r15)
            if (r11 == 0) goto L_0x0063
            int r11 = r6.f4360f
            int r4 = r6.m
            int r11 = r11 + r4
            r6.f4360f = r11
        L_0x0063:
            android.view.ViewGroup$LayoutParams r4 = r26.getLayoutParams()
            r11 = r4
            d.b.p.i0$a r11 = (d.b.p.i0.a) r11
            float r4 = r11.f4365a
            float r23 = r23 + r4
            if (r1 != r5) goto L_0x0091
            int r5 = r11.height
            if (r5 != 0) goto L_0x0091
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x0091
            int r4 = r6.f4360f
            int r5 = r11.topMargin
            int r5 = r5 + r4
            int r12 = r11.bottomMargin
            int r5 = r5 + r12
            int r4 = java.lang.Math.max(r4, r5)
            r6.f4360f = r4
            r10 = r0
            r29 = r1
            r30 = r2
            r31 = r3
            r13 = 0
            r24 = 1
            goto L_0x00e0
        L_0x0091:
            int r4 = r11.height
            if (r4 != 0) goto L_0x009f
            float r4 = r11.f4365a
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x009f
            r11.height = r10
            r12 = 0
            goto L_0x00a1
        L_0x009f:
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00a1:
            r4 = 0
            int r5 = (r23 > r13 ? 1 : (r23 == r13 ? 0 : -1))
            if (r5 != 0) goto L_0x00aa
            int r5 = r6.f4360f
            r10 = r0
            goto L_0x00ac
        L_0x00aa:
            r10 = r0
            r5 = 0
        L_0x00ac:
            r0 = r37
            r29 = r1
            r1 = r26
            r30 = r2
            r2 = r38
            r31 = r3
            r3 = r4
            r13 = 0
            r4 = r39
            r0.a(r1, r2, r3, r4, r5)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r12 == r0) goto L_0x00c5
            r11.height = r12
        L_0x00c5:
            int r0 = r26.getMeasuredHeight()
            int r1 = r6.f4360f
            int r2 = r1 + r0
            int r3 = r11.topMargin
            int r2 = r2 + r3
            int r3 = r11.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 + r13
            int r1 = java.lang.Math.max(r1, r2)
            r6.f4360f = r1
            if (r9 == 0) goto L_0x00e0
            int r14 = java.lang.Math.max(r0, r14)
        L_0x00e0:
            if (r10 < 0) goto L_0x00ea
            int r0 = r15 + 1
            if (r10 != r0) goto L_0x00ea
            int r0 = r6.f4360f
            r6.f4357c = r0
        L_0x00ea:
            if (r15 >= r10) goto L_0x00fc
            float r0 = r11.f4365a
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x00f4
            goto L_0x00fc
        L_0x00f4:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r0.<init>(r1)
            throw r0
        L_0x00fc:
            r0 = r30
            r12 = 1073741824(0x40000000, float:2.0)
            if (r0 == r12) goto L_0x010b
            int r1 = r11.width
            r2 = -1
            if (r1 != r2) goto L_0x010b
            r4 = 1
            r25 = 1
            goto L_0x010c
        L_0x010b:
            r4 = r13
        L_0x010c:
            int r1 = r11.leftMargin
            int r2 = r11.rightMargin
            int r1 = r1 + r2
            int r2 = r26.getMeasuredWidth()
            int r2 = r2 + r1
            r3 = r22
            int r3 = java.lang.Math.max(r3, r2)
            int r5 = r26.getMeasuredState()
            r12 = r20
            int r5 = android.view.View.combineMeasuredStates(r12, r5)
            if (r18 == 0) goto L_0x012f
            int r12 = r11.width
            r13 = -1
            if (r12 != r13) goto L_0x012f
            r12 = 1
            goto L_0x0130
        L_0x012f:
            r12 = 0
        L_0x0130:
            float r11 = r11.f4365a
            r13 = 0
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x0142
            if (r4 == 0) goto L_0x013a
            goto L_0x013b
        L_0x013a:
            r1 = r2
        L_0x013b:
            r11 = r21
            int r21 = java.lang.Math.max(r11, r1)
            goto L_0x0150
        L_0x0142:
            r11 = r21
            if (r4 == 0) goto L_0x0147
            goto L_0x0148
        L_0x0147:
            r1 = r2
        L_0x0148:
            r4 = r19
            int r19 = java.lang.Math.max(r4, r1)
            r21 = r11
        L_0x0150:
            int r15 = r15 + 0
            r22 = r3
            r20 = r5
            r18 = r12
            goto L_0x0053
        L_0x015a:
            int r15 = r15 + r1
            r2 = r0
            r0 = r10
            r1 = r29
            r3 = r31
            r4 = 0
            r5 = 1073741824(0x40000000, float:2.0)
            r10 = -2
            r12 = 8
            r13 = 0
            goto L_0x0037
        L_0x016a:
            r29 = r1
            r0 = r2
            r31 = r3
            r4 = r19
            r12 = r20
            r11 = r21
            r3 = r22
            int r1 = r6.f4360f
            if (r1 <= 0) goto L_0x018b
            r1 = r31
            boolean r2 = r6.a(r1)
            if (r2 == 0) goto L_0x018d
            int r2 = r6.f4360f
            int r5 = r6.m
            int r2 = r2 + r5
            r6.f4360f = r2
            goto L_0x018d
        L_0x018b:
            r1 = r31
        L_0x018d:
            if (r9 == 0) goto L_0x01da
            r2 = r29
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == r5) goto L_0x019b
            if (r2 != 0) goto L_0x0198
            goto L_0x019b
        L_0x0198:
            r19 = r3
            goto L_0x01de
        L_0x019b:
            r5 = 0
            r6.f4360f = r5
            r10 = r5
        L_0x019f:
            if (r10 >= r1) goto L_0x0198
            android.view.View r13 = r6.getChildAt(r10)
            if (r13 != 0) goto L_0x01ad
            int r13 = r6.f4360f
            int r13 = r13 + r5
            r6.f4360f = r13
            goto L_0x01b7
        L_0x01ad:
            int r5 = r13.getVisibility()
            r15 = 8
            if (r5 != r15) goto L_0x01ba
            int r10 = r10 + 0
        L_0x01b7:
            r19 = r3
            goto L_0x01d4
        L_0x01ba:
            android.view.ViewGroup$LayoutParams r5 = r13.getLayoutParams()
            d.b.p.i0$a r5 = (d.b.p.i0.a) r5
            int r13 = r6.f4360f
            int r15 = r13 + r14
            r19 = r3
            int r3 = r5.topMargin
            int r15 = r15 + r3
            int r3 = r5.bottomMargin
            int r15 = r15 + r3
            r3 = 0
            int r15 = r15 + r3
            int r3 = java.lang.Math.max(r13, r15)
            r6.f4360f = r3
        L_0x01d4:
            r3 = 1
            int r10 = r10 + r3
            r3 = r19
            r5 = 0
            goto L_0x019f
        L_0x01da:
            r19 = r3
            r2 = r29
        L_0x01de:
            int r3 = r6.f4360f
            int r5 = r37.getPaddingTop()
            int r10 = r37.getPaddingBottom()
            int r10 = r10 + r5
            int r10 = r10 + r3
            r6.f4360f = r10
            int r3 = r37.getSuggestedMinimumHeight()
            int r3 = java.lang.Math.max(r10, r3)
            r5 = 0
            int r3 = android.view.View.resolveSizeAndState(r3, r8, r5)
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            r5 = r5 & r3
            int r10 = r6.f4360f
            int r5 = r5 - r10
            if (r24 != 0) goto L_0x024b
            if (r5 == 0) goto L_0x020a
            r10 = 0
            int r13 = (r23 > r10 ? 1 : (r23 == r10 ? 0 : -1))
            if (r13 <= 0) goto L_0x020a
            goto L_0x024b
        L_0x020a:
            int r4 = java.lang.Math.max(r4, r11)
            if (r9 == 0) goto L_0x0247
            r5 = 1073741824(0x40000000, float:2.0)
            if (r2 == r5) goto L_0x0247
            r2 = 0
        L_0x0215:
            if (r2 >= r1) goto L_0x0247
            android.view.View r5 = r6.getChildAt(r2)
            if (r5 == 0) goto L_0x0244
            int r9 = r5.getVisibility()
            r10 = 8
            if (r9 != r10) goto L_0x0226
            goto L_0x0244
        L_0x0226:
            android.view.ViewGroup$LayoutParams r9 = r5.getLayoutParams()
            d.b.p.i0$a r9 = (d.b.p.i0.a) r9
            float r9 = r9.f4365a
            r10 = 0
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0244
            int r9 = r5.getMeasuredWidth()
            r10 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r10)
            r5.measure(r9, r11)
        L_0x0244:
            int r2 = r2 + 1
            goto L_0x0215
        L_0x0247:
            r22 = r19
            goto L_0x0332
        L_0x024b:
            float r9 = r6.f4361g
            r10 = 0
            int r11 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x0254
            r23 = r9
        L_0x0254:
            r9 = 0
            r6.f4360f = r9
            r9 = r4
            r10 = r19
            r4 = 0
        L_0x025b:
            if (r4 >= r1) goto L_0x0321
            android.view.View r11 = r6.getChildAt(r4)
            int r13 = r11.getVisibility()
            r14 = 8
            if (r13 != r14) goto L_0x026d
            r29 = r2
            goto L_0x031b
        L_0x026d:
            android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
            d.b.p.i0$a r13 = (d.b.p.i0.a) r13
            float r14 = r13.f4365a
            r15 = 0
            int r16 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r16 <= 0) goto L_0x02cf
            float r15 = (float) r5
            float r15 = r15 * r14
            float r15 = r15 / r23
            int r15 = (int) r15
            float r23 = r23 - r14
            int r5 = r5 - r15
            int r14 = r37.getPaddingLeft()
            int r16 = r37.getPaddingRight()
            int r16 = r16 + r14
            int r14 = r13.leftMargin
            int r16 = r16 + r14
            int r14 = r13.rightMargin
            int r14 = r16 + r14
            r16 = r5
            int r5 = r13.width
            int r5 = android.view.ViewGroup.getChildMeasureSpec(r7, r14, r5)
            int r14 = r13.height
            if (r14 != 0) goto L_0x02b1
            r14 = 1073741824(0x40000000, float:2.0)
            if (r2 == r14) goto L_0x02a5
            goto L_0x02b3
        L_0x02a5:
            if (r15 <= 0) goto L_0x02a8
            goto L_0x02a9
        L_0x02a8:
            r15 = 0
        L_0x02a9:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r14)
            r11.measure(r5, r15)
            goto L_0x02c3
        L_0x02b1:
            r14 = 1073741824(0x40000000, float:2.0)
        L_0x02b3:
            int r19 = r11.getMeasuredHeight()
            int r15 = r19 + r15
            if (r15 >= 0) goto L_0x02bc
            r15 = 0
        L_0x02bc:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r14)
            r11.measure(r5, r15)
        L_0x02c3:
            int r5 = r11.getMeasuredState()
            r5 = r5 & -256(0xffffffffffffff00, float:NaN)
            int r12 = android.view.View.combineMeasuredStates(r12, r5)
            r5 = r16
        L_0x02cf:
            int r14 = r13.leftMargin
            int r15 = r13.rightMargin
            int r14 = r14 + r15
            int r15 = r11.getMeasuredWidth()
            int r15 = r15 + r14
            int r10 = java.lang.Math.max(r10, r15)
            r29 = r2
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L_0x02ec
            int r2 = r13.width
            r16 = r5
            r5 = -1
            if (r2 != r5) goto L_0x02ef
            r2 = 1
            goto L_0x02f0
        L_0x02ec:
            r16 = r5
            r5 = -1
        L_0x02ef:
            r2 = 0
        L_0x02f0:
            if (r2 == 0) goto L_0x02f3
            goto L_0x02f4
        L_0x02f3:
            r14 = r15
        L_0x02f4:
            int r2 = java.lang.Math.max(r9, r14)
            if (r18 == 0) goto L_0x0300
            int r9 = r13.width
            if (r9 != r5) goto L_0x0300
            r5 = 1
            goto L_0x0301
        L_0x0300:
            r5 = 0
        L_0x0301:
            int r9 = r6.f4360f
            int r11 = r11.getMeasuredHeight()
            int r11 = r11 + r9
            int r14 = r13.topMargin
            int r11 = r11 + r14
            int r13 = r13.bottomMargin
            int r11 = r11 + r13
            r13 = 0
            int r11 = r11 + r13
            int r9 = java.lang.Math.max(r9, r11)
            r6.f4360f = r9
            r9 = r2
            r18 = r5
            r5 = r16
        L_0x031b:
            int r4 = r4 + 1
            r2 = r29
            goto L_0x025b
        L_0x0321:
            int r2 = r6.f4360f
            int r4 = r37.getPaddingTop()
            int r5 = r37.getPaddingBottom()
            int r5 = r5 + r4
            int r5 = r5 + r2
            r6.f4360f = r5
            r4 = r9
            r22 = r10
        L_0x0332:
            if (r18 != 0) goto L_0x0339
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L_0x0339
            goto L_0x033b
        L_0x0339:
            r4 = r22
        L_0x033b:
            int r0 = r37.getPaddingLeft()
            int r2 = r37.getPaddingRight()
            int r2 = r2 + r0
            int r2 = r2 + r4
            int r0 = r37.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r2, r0)
            int r0 = android.view.View.resolveSizeAndState(r0, r7, r12)
            r6.setMeasuredDimension(r0, r3)
            if (r25 == 0) goto L_0x0856
            r6.b(r1, r8)
            goto L_0x0856
        L_0x035b:
            r0 = r4
            r6.f4360f = r0
            int r9 = r37.getVirtualChildCount()
            int r10 = android.view.View.MeasureSpec.getMode(r38)
            int r11 = android.view.View.MeasureSpec.getMode(r39)
            int[] r0 = r6.f4363i
            r12 = 4
            if (r0 == 0) goto L_0x0373
            int[] r0 = r6.f4364j
            if (r0 != 0) goto L_0x037b
        L_0x0373:
            int[] r0 = new int[r12]
            r6.f4363i = r0
            int[] r0 = new int[r12]
            r6.f4364j = r0
        L_0x037b:
            int[] r13 = r6.f4363i
            int[] r14 = r6.f4364j
            r15 = 3
            r0 = -1
            r13[r15] = r0
            r18 = 2
            r13[r18] = r0
            r1 = 1
            r13[r1] = r0
            r2 = 0
            r13[r2] = r0
            r14[r15] = r0
            r14[r18] = r0
            r14[r1] = r0
            r14[r2] = r0
            boolean r5 = r6.f4355a
            boolean r4 = r6.f4362h
            r0 = 1073741824(0x40000000, float:2.0)
            if (r10 != r0) goto L_0x03a0
            r19 = 1
            goto L_0x03a2
        L_0x03a0:
            r19 = 0
        L_0x03a2:
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r8 = 0
            r12 = 0
            r15 = 0
            r21 = 0
            r23 = 0
            r24 = 1
        L_0x03af:
            if (r3 >= r9) goto L_0x054a
            android.view.View r7 = r6.getChildAt(r3)
            if (r7 != 0) goto L_0x03c4
            int r7 = r6.f4360f
            r25 = 0
            int r7 = r7 + 0
            r6.f4360f = r7
            r25 = r0
            r26 = r2
            goto L_0x03d2
        L_0x03c4:
            r25 = r0
            int r0 = r7.getVisibility()
            r26 = r2
            r2 = 8
            if (r0 != r2) goto L_0x03dd
            int r3 = r3 + 0
        L_0x03d2:
            r29 = r5
            r0 = r25
            r2 = r26
            r26 = r4
            r4 = 1
            goto L_0x0541
        L_0x03dd:
            boolean r0 = r6.a(r3)
            if (r0 == 0) goto L_0x03ea
            int r0 = r6.f4360f
            int r2 = r6.l
            int r0 = r0 + r2
            r6.f4360f = r0
        L_0x03ea:
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            r2 = r0
            d.b.p.i0$a r2 = (d.b.p.i0.a) r2
            float r0 = r2.f4365a
            float r28 = r1 + r0
            r1 = 1073741824(0x40000000, float:2.0)
            if (r10 != r1) goto L_0x0449
            int r1 = r2.width
            if (r1 != 0) goto L_0x0449
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0449
            if (r19 == 0) goto L_0x0411
            int r0 = r6.f4360f
            int r1 = r2.leftMargin
            r29 = r3
            int r3 = r2.rightMargin
            int r1 = r1 + r3
            int r1 = r1 + r0
            r6.f4360f = r1
            goto L_0x0421
        L_0x0411:
            r29 = r3
            int r0 = r6.f4360f
            int r1 = r2.leftMargin
            int r1 = r1 + r0
            int r3 = r2.rightMargin
            int r1 = r1 + r3
            int r0 = java.lang.Math.max(r0, r1)
            r6.f4360f = r0
        L_0x0421:
            if (r5 == 0) goto L_0x0438
            r0 = 0
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r7.measure(r1, r1)
            r1 = r2
            r32 = r25
            r33 = r26
            r25 = r29
            r26 = r4
            r29 = r5
            goto L_0x04c2
        L_0x0438:
            r1 = r2
            r32 = r25
            r33 = r26
            r25 = r29
            r0 = 1073741824(0x40000000, float:2.0)
            r21 = 1
            r26 = r4
            r29 = r5
            goto L_0x04c4
        L_0x0449:
            r29 = r3
            int r0 = r2.width
            if (r0 != 0) goto L_0x045b
            float r0 = r2.f4365a
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x045c
            r0 = -2
            r2.width = r0
            r3 = 0
            goto L_0x045e
        L_0x045b:
            r1 = 0
        L_0x045c:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x045e:
            int r0 = (r28 > r1 ? 1 : (r28 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0467
            int r0 = r6.f4360f
            r30 = r0
            goto L_0x0469
        L_0x0467:
            r30 = 0
        L_0x0469:
            r31 = 0
            r1 = r25
            r0 = r37
            r32 = r1
            r1 = r7
            r34 = r2
            r33 = r26
            r2 = r38
            r35 = r3
            r25 = r29
            r3 = r30
            r26 = r4
            r4 = r39
            r29 = r5
            r5 = r31
            r0.a(r1, r2, r3, r4, r5)
            r0 = r35
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L_0x0494
            r1 = r34
            r1.width = r0
            goto L_0x0496
        L_0x0494:
            r1 = r34
        L_0x0496:
            int r0 = r7.getMeasuredWidth()
            if (r19 == 0) goto L_0x04aa
            int r2 = r6.f4360f
            int r3 = r1.leftMargin
            int r3 = r3 + r0
            int r4 = r1.rightMargin
            int r3 = r3 + r4
            r4 = 0
            int r3 = r3 + r4
            int r3 = r3 + r2
            r6.f4360f = r3
            goto L_0x04bc
        L_0x04aa:
            r4 = 0
            int r2 = r6.f4360f
            int r3 = r2 + r0
            int r5 = r1.leftMargin
            int r3 = r3 + r5
            int r5 = r1.rightMargin
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r2 = java.lang.Math.max(r2, r3)
            r6.f4360f = r2
        L_0x04bc:
            if (r26 == 0) goto L_0x04c2
            int r8 = java.lang.Math.max(r0, r8)
        L_0x04c2:
            r0 = 1073741824(0x40000000, float:2.0)
        L_0x04c4:
            if (r11 == r0) goto L_0x04cf
            int r0 = r1.height
            r2 = -1
            if (r0 != r2) goto L_0x04cf
            r4 = 1
            r23 = 1
            goto L_0x04d0
        L_0x04cf:
            r4 = 0
        L_0x04d0:
            int r0 = r1.topMargin
            int r2 = r1.bottomMargin
            int r0 = r0 + r2
            int r2 = r7.getMeasuredHeight()
            int r2 = r2 + r0
            int r3 = r7.getMeasuredState()
            int r3 = android.view.View.combineMeasuredStates(r12, r3)
            if (r29 == 0) goto L_0x050b
            int r5 = r7.getBaseline()
            r7 = -1
            if (r5 == r7) goto L_0x050b
            int r7 = r1.f4366b
            if (r7 >= 0) goto L_0x04f1
            int r7 = r6.f4359e
        L_0x04f1:
            r7 = r7 & 112(0x70, float:1.57E-43)
            r12 = 4
            int r7 = r7 >> r12
            r12 = -2
            r7 = r7 & r12
            r12 = 1
            int r7 = r7 >> r12
            r12 = r13[r7]
            int r12 = java.lang.Math.max(r12, r5)
            r13[r7] = r12
            r12 = r14[r7]
            int r5 = r2 - r5
            int r5 = java.lang.Math.max(r12, r5)
            r14[r7] = r5
        L_0x050b:
            r5 = r33
            int r5 = java.lang.Math.max(r5, r2)
            if (r24 == 0) goto L_0x051a
            int r7 = r1.height
            r12 = -1
            if (r7 != r12) goto L_0x051a
            r7 = 1
            goto L_0x051b
        L_0x051a:
            r7 = 0
        L_0x051b:
            float r1 = r1.f4365a
            r12 = 0
            int r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r1 <= 0) goto L_0x052d
            if (r4 == 0) goto L_0x0525
            goto L_0x0526
        L_0x0525:
            r0 = r2
        L_0x0526:
            int r15 = java.lang.Math.max(r15, r0)
            r0 = r32
            goto L_0x0537
        L_0x052d:
            if (r4 == 0) goto L_0x0530
            goto L_0x0531
        L_0x0530:
            r0 = r2
        L_0x0531:
            r2 = r32
            int r0 = java.lang.Math.max(r2, r0)
        L_0x0537:
            int r1 = r25 + 0
            r12 = r3
            r2 = r5
            r24 = r7
            r4 = 1
            r3 = r1
            r1 = r28
        L_0x0541:
            int r3 = r3 + r4
            r7 = r38
            r4 = r26
            r5 = r29
            goto L_0x03af
        L_0x054a:
            r26 = r4
            r29 = r5
            r5 = r2
            r2 = r0
            int r0 = r6.f4360f
            if (r0 <= 0) goto L_0x0561
            boolean r0 = r6.a(r9)
            if (r0 == 0) goto L_0x0561
            int r0 = r6.f4360f
            int r3 = r6.l
            int r0 = r0 + r3
            r6.f4360f = r0
        L_0x0561:
            r0 = 1
            r3 = r13[r0]
            r0 = -1
            if (r3 != r0) goto L_0x057a
            r3 = 0
            r4 = r13[r3]
            if (r4 != r0) goto L_0x057a
            r3 = r13[r18]
            if (r3 != r0) goto L_0x057a
            r3 = 3
            r4 = r13[r3]
            if (r4 == r0) goto L_0x0576
            goto L_0x057b
        L_0x0576:
            r0 = r5
            r25 = r12
            goto L_0x05af
        L_0x057a:
            r3 = 3
        L_0x057b:
            r0 = r13[r3]
            r4 = 0
            r7 = r13[r4]
            r17 = 1
            r4 = r13[r17]
            r3 = r13[r18]
            int r3 = java.lang.Math.max(r4, r3)
            int r3 = java.lang.Math.max(r7, r3)
            int r0 = java.lang.Math.max(r0, r3)
            r3 = 3
            r4 = r14[r3]
            r3 = 0
            r7 = r14[r3]
            r3 = r14[r17]
            r25 = r12
            r12 = r14[r18]
            int r3 = java.lang.Math.max(r3, r12)
            int r3 = java.lang.Math.max(r7, r3)
            int r3 = java.lang.Math.max(r4, r3)
            int r3 = r3 + r0
            int r0 = java.lang.Math.max(r5, r3)
        L_0x05af:
            if (r26 == 0) goto L_0x0601
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 == r3) goto L_0x05b7
            if (r10 != 0) goto L_0x0601
        L_0x05b7:
            r3 = 0
            r6.f4360f = r3
            r4 = r3
        L_0x05bb:
            if (r4 >= r9) goto L_0x0601
            android.view.View r5 = r6.getChildAt(r4)
            if (r5 != 0) goto L_0x05c9
            int r5 = r6.f4360f
            int r5 = r5 + r3
            r6.f4360f = r5
            goto L_0x05fd
        L_0x05c9:
            int r3 = r5.getVisibility()
            r7 = 8
            if (r3 != r7) goto L_0x05d4
            int r4 = r4 + 0
            goto L_0x05fd
        L_0x05d4:
            android.view.ViewGroup$LayoutParams r3 = r5.getLayoutParams()
            d.b.p.i0$a r3 = (d.b.p.i0.a) r3
            if (r19 == 0) goto L_0x05ea
            int r5 = r6.f4360f
            int r7 = r3.leftMargin
            int r7 = r7 + r8
            int r3 = r3.rightMargin
            int r7 = r7 + r3
            r12 = 0
            int r7 = r7 + r12
            int r7 = r7 + r5
            r6.f4360f = r7
            goto L_0x05fd
        L_0x05ea:
            r12 = 0
            int r5 = r6.f4360f
            int r7 = r5 + r8
            int r12 = r3.leftMargin
            int r7 = r7 + r12
            int r3 = r3.rightMargin
            int r7 = r7 + r3
            r3 = 0
            int r7 = r7 + r3
            int r3 = java.lang.Math.max(r5, r7)
            r6.f4360f = r3
        L_0x05fd:
            r3 = 1
            int r4 = r4 + r3
            r3 = 0
            goto L_0x05bb
        L_0x0601:
            int r3 = r6.f4360f
            int r4 = r37.getPaddingLeft()
            int r5 = r37.getPaddingRight()
            int r5 = r5 + r4
            int r5 = r5 + r3
            r6.f4360f = r5
            int r3 = r37.getSuggestedMinimumWidth()
            int r3 = java.lang.Math.max(r5, r3)
            r4 = r38
            r5 = 0
            int r3 = android.view.View.resolveSizeAndState(r3, r4, r5)
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            r5 = r5 & r3
            int r7 = r6.f4360f
            int r5 = r5 - r7
            if (r21 != 0) goto L_0x0674
            if (r5 == 0) goto L_0x062f
            r12 = 0
            int r16 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r16 <= 0) goto L_0x062f
            goto L_0x0674
        L_0x062f:
            int r1 = java.lang.Math.max(r2, r15)
            if (r26 == 0) goto L_0x066c
            r2 = 1073741824(0x40000000, float:2.0)
            if (r10 == r2) goto L_0x066c
            r2 = 0
        L_0x063a:
            if (r2 >= r9) goto L_0x066c
            android.view.View r5 = r6.getChildAt(r2)
            if (r5 == 0) goto L_0x0669
            int r10 = r5.getVisibility()
            r12 = 8
            if (r10 != r12) goto L_0x064b
            goto L_0x0669
        L_0x064b:
            android.view.ViewGroup$LayoutParams r10 = r5.getLayoutParams()
            d.b.p.i0$a r10 = (d.b.p.i0.a) r10
            float r10 = r10.f4365a
            r12 = 0
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0669
            r10 = 1073741824(0x40000000, float:2.0)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r10)
            int r13 = r5.getMeasuredHeight()
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r10)
            r5.measure(r12, r13)
        L_0x0669:
            int r2 = r2 + 1
            goto L_0x063a
        L_0x066c:
            r8 = r39
            r12 = r25
            r25 = r9
            goto L_0x0827
        L_0x0674:
            float r0 = r6.f4361g
            r8 = 0
            int r12 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r12 <= 0) goto L_0x067c
            r1 = r0
        L_0x067c:
            r0 = 3
            r8 = -1
            r13[r0] = r8
            r13[r18] = r8
            r12 = 1
            r13[r12] = r8
            r15 = 0
            r13[r15] = r8
            r14[r0] = r8
            r14[r18] = r8
            r14[r12] = r8
            r14[r15] = r8
            r6.f4360f = r15
            r0 = r2
            r8 = r5
            r12 = r25
            r2 = -1
            r5 = 0
        L_0x0698:
            if (r5 >= r9) goto L_0x07c9
            android.view.View r15 = r6.getChildAt(r5)
            if (r15 == 0) goto L_0x07b4
            int r7 = r15.getVisibility()
            r4 = 8
            if (r7 != r4) goto L_0x06aa
            goto L_0x07b4
        L_0x06aa:
            android.view.ViewGroup$LayoutParams r7 = r15.getLayoutParams()
            d.b.p.i0$a r7 = (d.b.p.i0.a) r7
            float r4 = r7.f4365a
            r21 = 0
            int r25 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
            if (r25 <= 0) goto L_0x0715
            r25 = r9
            float r9 = (float) r8
            float r9 = r9 * r4
            float r9 = r9 / r1
            int r9 = (int) r9
            float r1 = r1 - r4
            int r8 = r8 - r9
            int r4 = r37.getPaddingTop()
            int r26 = r37.getPaddingBottom()
            int r26 = r26 + r4
            int r4 = r7.topMargin
            int r26 = r26 + r4
            int r4 = r7.bottomMargin
            int r4 = r26 + r4
            r26 = r1
            int r1 = r7.height
            r27 = r8
            r8 = r39
            int r1 = android.view.ViewGroup.getChildMeasureSpec(r8, r4, r1)
            int r4 = r7.width
            if (r4 != 0) goto L_0x06f3
            r4 = 1073741824(0x40000000, float:2.0)
            if (r10 == r4) goto L_0x06e7
            goto L_0x06f5
        L_0x06e7:
            if (r9 <= 0) goto L_0x06ea
            goto L_0x06eb
        L_0x06ea:
            r9 = 0
        L_0x06eb:
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r4)
            r15.measure(r9, r1)
            goto L_0x0705
        L_0x06f3:
            r4 = 1073741824(0x40000000, float:2.0)
        L_0x06f5:
            int r28 = r15.getMeasuredWidth()
            int r9 = r28 + r9
            if (r9 >= 0) goto L_0x06fe
            r9 = 0
        L_0x06fe:
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r4)
            r15.measure(r9, r1)
        L_0x0705:
            int r1 = r15.getMeasuredState()
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1 = r1 & r4
            int r12 = android.view.View.combineMeasuredStates(r12, r1)
            r1 = r26
            r4 = r27
            goto L_0x071a
        L_0x0715:
            r4 = r8
            r25 = r9
            r8 = r39
        L_0x071a:
            if (r19 == 0) goto L_0x0736
            int r9 = r6.f4360f
            int r26 = r15.getMeasuredWidth()
            r27 = r1
            int r1 = r7.leftMargin
            int r26 = r26 + r1
            int r1 = r7.rightMargin
            int r26 = r26 + r1
            r1 = 0
            int r26 = r26 + 0
            int r9 = r26 + r9
            r6.f4360f = r9
            r28 = r4
            goto L_0x0754
        L_0x0736:
            r27 = r1
            r1 = 0
            int r9 = r6.f4360f
            int r26 = r15.getMeasuredWidth()
            int r26 = r26 + r9
            int r1 = r7.leftMargin
            int r26 = r26 + r1
            int r1 = r7.rightMargin
            int r26 = r26 + r1
            r28 = r4
            r1 = 0
            int r4 = r26 + 0
            int r1 = java.lang.Math.max(r9, r4)
            r6.f4360f = r1
        L_0x0754:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r11 == r1) goto L_0x075f
            int r1 = r7.height
            r4 = -1
            if (r1 != r4) goto L_0x075f
            r4 = 1
            goto L_0x0760
        L_0x075f:
            r4 = 0
        L_0x0760:
            int r1 = r7.topMargin
            int r9 = r7.bottomMargin
            int r1 = r1 + r9
            int r9 = r15.getMeasuredHeight()
            int r9 = r9 + r1
            int r2 = java.lang.Math.max(r2, r9)
            if (r4 == 0) goto L_0x0771
            goto L_0x0772
        L_0x0771:
            r1 = r9
        L_0x0772:
            int r0 = java.lang.Math.max(r0, r1)
            if (r24 == 0) goto L_0x077f
            int r1 = r7.height
            r4 = -1
            if (r1 != r4) goto L_0x0780
            r1 = 1
            goto L_0x0781
        L_0x077f:
            r4 = -1
        L_0x0780:
            r1 = 0
        L_0x0781:
            if (r29 == 0) goto L_0x07ad
            int r15 = r15.getBaseline()
            if (r15 == r4) goto L_0x07ad
            int r4 = r7.f4366b
            if (r4 >= 0) goto L_0x078f
            int r4 = r6.f4359e
        L_0x078f:
            r4 = r4 & 112(0x70, float:1.57E-43)
            r7 = 4
            int r4 = r4 >> r7
            r22 = -2
            r4 = r4 & -2
            r17 = 1
            int r4 = r4 >> 1
            r7 = r13[r4]
            int r7 = java.lang.Math.max(r7, r15)
            r13[r4] = r7
            r7 = r14[r4]
            int r9 = r9 - r15
            int r7 = java.lang.Math.max(r7, r9)
            r14[r4] = r7
            goto L_0x07af
        L_0x07ad:
            r22 = -2
        L_0x07af:
            r24 = r1
            r1 = r27
            goto L_0x07bf
        L_0x07b4:
            r4 = r8
            r25 = r9
            r21 = 0
            r22 = -2
            r8 = r39
            r28 = r4
        L_0x07bf:
            int r5 = r5 + 1
            r4 = r38
            r9 = r25
            r8 = r28
            goto L_0x0698
        L_0x07c9:
            r8 = r39
            r25 = r9
            int r1 = r6.f4360f
            int r4 = r37.getPaddingLeft()
            int r5 = r37.getPaddingRight()
            int r5 = r5 + r4
            int r5 = r5 + r1
            r6.f4360f = r5
            r1 = 1
            r4 = r13[r1]
            r1 = -1
            if (r4 != r1) goto L_0x07f2
            r4 = 0
            r5 = r13[r4]
            if (r5 != r1) goto L_0x07f2
            r4 = r13[r18]
            if (r4 != r1) goto L_0x07f2
            r4 = 3
            r5 = r13[r4]
            if (r5 == r1) goto L_0x07f0
            goto L_0x07f3
        L_0x07f0:
            r1 = r2
            goto L_0x0822
        L_0x07f2:
            r4 = 3
        L_0x07f3:
            r1 = r13[r4]
            r5 = 0
            r7 = r13[r5]
            r9 = 1
            r10 = r13[r9]
            r13 = r13[r18]
            int r10 = java.lang.Math.max(r10, r13)
            int r7 = java.lang.Math.max(r7, r10)
            int r1 = java.lang.Math.max(r1, r7)
            r4 = r14[r4]
            r5 = r14[r5]
            r7 = r14[r9]
            r9 = r14[r18]
            int r7 = java.lang.Math.max(r7, r9)
            int r5 = java.lang.Math.max(r5, r7)
            int r4 = java.lang.Math.max(r4, r5)
            int r4 = r4 + r1
            int r1 = java.lang.Math.max(r2, r4)
        L_0x0822:
            r36 = r1
            r1 = r0
            r0 = r36
        L_0x0827:
            if (r24 != 0) goto L_0x082e
            r2 = 1073741824(0x40000000, float:2.0)
            if (r11 == r2) goto L_0x082e
            r0 = r1
        L_0x082e:
            int r1 = r37.getPaddingTop()
            int r2 = r37.getPaddingBottom()
            int r2 = r2 + r1
            int r2 = r2 + r0
            int r0 = r37.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r2, r0)
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1 = r1 & r12
            r1 = r1 | r3
            int r2 = r12 << 16
            int r0 = android.view.View.resolveSizeAndState(r0, r8, r2)
            r6.setMeasuredDimension(r1, r0)
            if (r23 == 0) goto L_0x0856
            r0 = r38
            r1 = r25
            r6.a(r1, r0)
        L_0x0856:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.p.i0.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z) {
        this.f4355a = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            StringBuilder a2 = e.a.a.a.a.a("base aligned child index out of range (0, ");
            a2.append(getChildCount());
            a2.append(")");
            throw new IllegalArgumentException(a2.toString());
        }
        this.f4356b = i2;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.k) {
            this.k = drawable;
            boolean z = false;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
                this.m = drawable.getIntrinsicHeight();
            } else {
                this.l = 0;
                this.m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i2) {
        this.o = i2;
    }

    public void setGravity(int i2) {
        if (this.f4359e != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f4359e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f4359e;
        if ((8388615 & i4) != i3) {
            this.f4359e = i3 | (-8388616 & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f4362h = z;
    }

    public void setOrientation(int i2) {
        if (this.f4358d != i2) {
            this.f4358d = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.n) {
            requestLayout();
        }
        this.n = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f4359e;
        if ((i4 & 112) != i3) {
            this.f4359e = i3 | (i4 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.f4361g = Math.max(0.0f, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public i0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a generateDefaultLayoutParams() {
        int i2 = this.f4358d;
        if (i2 == 0) {
            return new a(-2, -2);
        }
        if (i2 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    public i0(Context context, AttributeSet attributeSet, int i2) {
        Drawable drawable;
        super(context, attributeSet, i2);
        this.f4355a = true;
        this.f4356b = -1;
        this.f4357c = 0;
        this.f4359e = 8388659;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.LinearLayoutCompat, i2, 0);
        int i3 = obtainStyledAttributes.getInt(j.LinearLayoutCompat_android_orientation, -1);
        if (i3 >= 0) {
            setOrientation(i3);
        }
        int i4 = obtainStyledAttributes.getInt(j.LinearLayoutCompat_android_gravity, -1);
        if (i4 >= 0) {
            setGravity(i4);
        }
        boolean z = obtainStyledAttributes.getBoolean(j.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.f4361g = obtainStyledAttributes.getFloat(j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f4356b = obtainStyledAttributes.getInt(j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f4362h = obtainStyledAttributes.getBoolean(j.LinearLayoutCompat_measureWithLargestChild, false);
        int i5 = j.LinearLayoutCompat_divider;
        if (obtainStyledAttributes.hasValue(i5)) {
            int resourceId = obtainStyledAttributes.getResourceId(i5, 0);
            if (resourceId != 0) {
                drawable = d.b.l.a.a.b(context, resourceId);
                setDividerDrawable(drawable);
                this.n = obtainStyledAttributes.getInt(j.LinearLayoutCompat_showDividers, 0);
                this.o = obtainStyledAttributes.getDimensionPixelSize(j.LinearLayoutCompat_dividerPadding, 0);
                obtainStyledAttributes.recycle();
            }
        }
        drawable = obtainStyledAttributes.getDrawable(i5);
        setDividerDrawable(drawable);
        this.n = obtainStyledAttributes.getInt(j.LinearLayoutCompat_showDividers, 0);
        this.o = obtainStyledAttributes.getDimensionPixelSize(j.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public a generateLayoutParams(LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public boolean a(int i2) {
        boolean z = false;
        if (i2 == 0) {
            if ((this.n & 1) != 0) {
                z = true;
            }
            return z;
        } else if (i2 == getChildCount()) {
            if ((this.n & 4) != 0) {
                z = true;
            }
            return z;
        } else {
            if ((this.n & 2) != 0) {
                int i3 = i2 - 1;
                while (true) {
                    if (i3 < 0) {
                        break;
                    } else if (getChildAt(i3).getVisibility() != 8) {
                        z = true;
                        break;
                    } else {
                        i3--;
                    }
                }
            }
            return z;
        }
    }

    public final void b(int i2, int i3) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
        for (int i4 = 0; i4 < i2; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar.width == -1) {
                    int i5 = aVar.height;
                    aVar.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i3, 0);
                    aVar.height = i5;
                }
            }
        }
    }

    public final void a(int i2, int i3) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
        for (int i4 = 0; i4 < i2; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar.height == -1) {
                    int i5 = aVar.width;
                    aVar.width = childAt.getMeasuredWidth();
                    measureChildWithMargins(childAt, i3, 0, makeMeasureSpec, 0);
                    aVar.width = i5;
                }
            }
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }
}
