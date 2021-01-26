package e.c.e.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.baidubce.auth.NTLMEngineImpl;
import d.h.k.m;
import java.util.ArrayList;

/* compiled from: SlidingPaneLayout */
public abstract class e extends ViewGroup {
    public static final h z = new j();

    /* renamed from: a reason: collision with root package name */
    public int f6879a = -858993460;

    /* renamed from: b reason: collision with root package name */
    public int f6880b;

    /* renamed from: c reason: collision with root package name */
    public Drawable f6881c;

    /* renamed from: d reason: collision with root package name */
    public final int f6882d;

    /* renamed from: e reason: collision with root package name */
    public boolean f6883e;

    /* renamed from: f reason: collision with root package name */
    public boolean f6884f;

    /* renamed from: g reason: collision with root package name */
    public View f6885g;

    /* renamed from: h reason: collision with root package name */
    public float f6886h;

    /* renamed from: i reason: collision with root package name */
    public float f6887i;

    /* renamed from: j reason: collision with root package name */
    public int f6888j;
    public boolean k;
    public int l;
    public int m;
    public float n;
    public float o;
    public f p;
    public final g q;
    public double r = 0.25d;
    public double s = 0.15d;
    public boolean t = true;
    public boolean u;
    public boolean v = true;
    public final Rect w = new Rect();
    public final ArrayList<c> x = new ArrayList<>();
    public boolean y = true;

    /* compiled from: SlidingPaneLayout */
    public class b extends d.h.k.a {

        /* renamed from: d reason: collision with root package name */
        public final Rect f6889d = new Rect();

        public b() {
        }

        public void a(View view, d.h.k.w.b bVar) {
            d.h.k.w.b bVar2 = new d.h.k.w.b(AccessibilityNodeInfo.obtain(bVar.f4953a));
            this.f4909a.onInitializeAccessibilityNodeInfo(view, bVar2.f4953a);
            Rect rect = this.f6889d;
            bVar2.f4953a.getBoundsInParent(rect);
            bVar.f4953a.setBoundsInParent(rect);
            bVar2.f4953a.getBoundsInScreen(rect);
            bVar.f4953a.setBoundsInScreen(rect);
            bVar.f4953a.setVisibleToUser(bVar2.n());
            bVar.f4953a.setPackageName(bVar2.f4953a.getPackageName());
            bVar.f4953a.setClassName(bVar2.d());
            bVar.f4953a.setContentDescription(bVar2.e());
            bVar.f4953a.setEnabled(bVar2.j());
            bVar.f4953a.setClickable(bVar2.i());
            bVar.f4953a.setFocusable(bVar2.k());
            bVar.f4953a.setFocused(bVar2.f4953a.isFocused());
            bVar.f4953a.setAccessibilityFocused(bVar2.f4953a.isAccessibilityFocused());
            bVar.f4953a.setSelected(bVar2.f4953a.isSelected());
            bVar.f4953a.setLongClickable(bVar2.l());
            bVar.f4953a.addAction(bVar2.b());
            bVar.f4953a.setMovementGranularities(bVar2.f4953a.getMovementGranularities());
            bVar2.f4953a.recycle();
            bVar.f4953a.setClassName(e.class.getName());
            bVar.f4955c = -1;
            bVar.f4953a.setSource(view);
            ViewParent r = m.r(view);
            if (r instanceof View) {
                View view2 = (View) r;
                bVar.f4954b = -1;
                bVar.f4953a.setParent(view2);
            }
            int childCount = e.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = e.this.getChildAt(i2);
                if (!e.this.a(childAt) && childAt.getVisibility() == 0) {
                    childAt.setImportantForAccessibility(1);
                    bVar.f4953a.addChild(childAt);
                }
            }
        }

        public void b(View view, AccessibilityEvent accessibilityEvent) {
            this.f4909a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(e.class.getName());
        }

        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!e.this.a(view)) {
                return this.f4909a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* compiled from: SlidingPaneLayout */
    public class c implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final View f6891a;

        public c(View view) {
            this.f6891a = view;
        }

        public void run() {
            if (this.f6891a.getParent() == e.this) {
                m.a(this.f6891a, 0, (Paint) null);
                e.a(e.this, this.f6891a);
            }
            e.this.x.remove(this);
        }
    }

    /* compiled from: SlidingPaneLayout */
    public class d extends e.c.e.a.g.c {

        /* renamed from: a reason: collision with root package name */
        public int f6893a;

        public /* synthetic */ d(a aVar) {
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            this.f6893a = i2;
            e eVar = e.this;
            if (eVar.f6883e) {
                View view2 = eVar.f6885g;
                if (view2 != null) {
                    C0073e eVar2 = (C0073e) view2.getLayoutParams();
                    float paddingLeft = ((float) (i2 - (eVar.getPaddingLeft() + eVar2.leftMargin))) / ((float) eVar.f6888j);
                    eVar.f6886h = paddingLeft;
                    if (eVar.m != 0) {
                        eVar.a(paddingLeft);
                    }
                    if (eVar2.f6898c) {
                        eVar.a(eVar.f6885g, eVar.f6886h, eVar.f6879a);
                    }
                    View view3 = eVar.f6885g;
                    f fVar = eVar.p;
                    if (fVar != null) {
                        fVar.onPanelSlide(view3, eVar.f6886h);
                    }
                }
            }
            e.this.invalidate();
        }

        public int a(View view, int i2, int i3) {
            int paddingLeft = e.this.getPaddingLeft() + ((C0073e) e.this.f6885g.getLayoutParams()).leftMargin;
            return Math.min(Math.max(i2, paddingLeft), e.this.f6888j + paddingLeft);
        }
    }

    /* renamed from: e.c.e.a.e$e reason: collision with other inner class name */
    /* compiled from: SlidingPaneLayout */
    public static class C0073e extends MarginLayoutParams {

        /* renamed from: e reason: collision with root package name */
        public static final int[] f6895e = {16843137};

        /* renamed from: a reason: collision with root package name */
        public float f6896a = 0.0f;

        /* renamed from: b reason: collision with root package name */
        public boolean f6897b;

        /* renamed from: c reason: collision with root package name */
        public boolean f6898c;

        /* renamed from: d reason: collision with root package name */
        public Paint f6899d;

        public C0073e() {
            super(-1, -1);
        }

        public C0073e(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0073e(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0073e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6895e);
            this.f6896a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: SlidingPaneLayout */
    public interface f {
        void onPanelClosed(View view);

        void onPanelOpened(View view);

        void onPanelSlide(View view, float f2);
    }

    /* compiled from: SlidingPaneLayout */
    public static class g extends BaseSavedState {
        public static final Creator<g> CREATOR = new a();

        /* renamed from: a reason: collision with root package name */
        public boolean f6900a;

        /* compiled from: SlidingPaneLayout */
        public static class a implements Creator<g> {
            public Object createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            public Object[] newArray(int i2) {
                return new g[i2];
            }
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f6900a ? 1 : 0);
        }

        public /* synthetic */ g(Parcel parcel, a aVar) {
            super(parcel);
            this.f6900a = parcel.readInt() != 0;
        }
    }

    /* compiled from: SlidingPaneLayout */
    public interface h {
    }

    /* compiled from: SlidingPaneLayout */
    public static class i implements h {
    }

    /* compiled from: SlidingPaneLayout */
    public static class j extends i {
    }

    public e(Context context) {
        super(context, null, 0);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f6882d = 5;
        this.l = context.getResources().getDisplayMetrics().widthPixels;
        setWillNotDraw(false);
        m.a((View) this, (d.h.k.a) new b());
        setImportantForAccessibility(1);
        g gVar = new g(getContext(), this, new d(null));
        gVar.f6903b = (int) (((float) gVar.f6903b) * 2.0f);
        this.q = gVar;
        gVar.p = 1;
        gVar.n = f2 * 400.0f;
    }

    public abstract void a();

    public final boolean a(int i2) {
        if (!this.v && !b(0.0f)) {
            return false;
        }
        this.u = false;
        return true;
    }

    public void b(View view) {
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt != view) {
                childAt.setVisibility((Math.max(paddingLeft, childAt.getLeft()) < 0 || Math.max(paddingTop, childAt.getTop()) < 0 || Math.min(width, childAt.getRight()) > 0 || Math.min(height, childAt.getBottom()) > 0) ? 0 : 4);
                i2++;
            } else {
                return;
            }
        }
    }

    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0073e) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        g gVar = this.q;
        boolean z2 = false;
        if (gVar.f6902a == 2) {
            boolean computeScrollOffset = gVar.q.f4991a.computeScrollOffset();
            int a2 = gVar.q.a();
            int b2 = gVar.q.b();
            int left = a2 - gVar.s.getLeft();
            int top = b2 - gVar.s.getTop();
            if (left != 0) {
                gVar.s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                gVar.s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                gVar.r.a(gVar.s, a2, b2, left, top);
            }
            if (computeScrollOffset && a2 == gVar.q.f4991a.getFinalX() && b2 == gVar.q.f4991a.getFinalY()) {
                gVar.q.f4991a.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                gVar.u.post(gVar.v);
            }
        }
        if (gVar.f6902a == 2) {
            z2 = true;
        }
        if (z2) {
            if (!this.f6883e) {
                this.q.a();
                return;
            }
            m.D(this);
        }
    }

    public void draw(Canvas canvas) {
        try {
            super.draw(canvas);
            View childAt = getChildCount() > 1 ? getChildAt(1) : null;
            if (this.t && childAt != null) {
                if (this.f6881c != null) {
                    int intrinsicWidth = this.f6881c.getIntrinsicWidth();
                    int left = childAt.getLeft();
                    this.f6881c.setBounds(left - intrinsicWidth, childAt.getTop(), left, childAt.getBottom());
                    this.f6881c.draw(canvas);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        C0073e eVar = (C0073e) view.getLayoutParams();
        int save = canvas.save();
        if (this.f6883e && !eVar.f6897b && this.f6885g != null && this.y) {
            canvas.getClipBounds(this.w);
            Rect rect = this.w;
            rect.right = Math.min(rect.right, this.f6885g.getLeft());
            canvas.clipRect(this.w);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        return drawChild;
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new C0073e();
    }

    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0073e((MarginLayoutParams) layoutParams) : new C0073e(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f6880b;
    }

    public int getParallaxDistance() {
        return this.m;
    }

    public int getSliderFadeColor() {
        return this.f6879a;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.v = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.v = true;
        int size = this.x.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((c) this.x.get(i2)).run();
        }
        this.x.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
        if (a(r13, false, java.lang.Math.round(r0 - r13.n), java.lang.Math.round(r0), java.lang.Math.round(r1)) != false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00de, code lost:
        if (a(r13.f6885g) != false) goto L_0x00e0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            int r0 = r14.getActionMasked()
            boolean r1 = r13.f6883e
            r2 = 1
            if (r1 != 0) goto L_0x002a
            if (r0 != 0) goto L_0x002a
            int r1 = r13.getChildCount()
            if (r1 <= r2) goto L_0x002a
            android.view.View r1 = r13.getChildAt(r2)
            if (r1 == 0) goto L_0x002a
            e.c.e.a.g r3 = r13.q
            float r4 = r14.getX()
            int r4 = (int) r4
            float r5 = r14.getY()
            int r5 = (int) r5
            boolean r1 = r3.a(r1, r4, r5)
            r1 = r1 ^ r2
            r13.u = r1
        L_0x002a:
            float r1 = r14.getX()
            int r3 = r13.l
            double r3 = (double) r3
            double r5 = r13.r
            double r3 = r3 * r5
            int r3 = (int) r3
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0044
            e.c.e.a.g r0 = r13.q
            r0.b()
            boolean r14 = super.onInterceptTouchEvent(r14)
            return r14
        L_0x0044:
            boolean r1 = r13.f6883e
            if (r1 == 0) goto L_0x00fc
            boolean r1 = r13.k
            if (r1 == 0) goto L_0x0050
            if (r0 == 0) goto L_0x0050
            goto L_0x00fc
        L_0x0050:
            r1 = 3
            r3 = 0
            if (r0 == r1) goto L_0x00f6
            if (r0 != r2) goto L_0x0058
            goto L_0x00f6
        L_0x0058:
            if (r0 == 0) goto L_0x00be
            r1 = 2
            if (r0 == r1) goto L_0x005f
            goto L_0x00e2
        L_0x005f:
            float r0 = r14.getX()
            float r1 = r14.getY()
            float r4 = r13.n
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r13.o
            float r5 = r1 - r5
            float r5 = java.lang.Math.abs(r5)
            e.c.e.a.g r6 = r13.q
            int r6 = r6.f6903b
            r7 = 0
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0094
            int r7 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0094
            boolean r7 = r13.f6883e
            if (r7 == 0) goto L_0x0094
            double r7 = (double) r0
            int r9 = r13.l
            double r9 = (double) r9
            double r11 = r13.s
            double r9 = r9 * r11
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 >= 0) goto L_0x0094
            goto L_0x00e0
        L_0x0094:
            float r6 = (float) r6
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x009d
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00b6
        L_0x009d:
            r7 = 0
            float r4 = r13.n
            float r4 = r0 - r4
            int r8 = java.lang.Math.round(r4)
            int r9 = java.lang.Math.round(r0)
            int r10 = java.lang.Math.round(r1)
            r5 = r13
            r6 = r13
            boolean r0 = r5.a(r6, r7, r8, r9, r10)
            if (r0 == 0) goto L_0x00e2
        L_0x00b6:
            e.c.e.a.g r14 = r13.q
            r14.b()
            r13.k = r2
            return r3
        L_0x00be:
            r13.k = r3
            float r0 = r14.getX()
            float r1 = r14.getY()
            r13.n = r0
            r13.o = r1
            e.c.e.a.g r4 = r13.q
            android.view.View r5 = r13.f6885g
            int r0 = (int) r0
            int r1 = (int) r1
            boolean r0 = r4.a(r5, r0, r1)
            if (r0 == 0) goto L_0x00e2
            android.view.View r0 = r13.f6885g
            boolean r0 = r13.a(r0)
            if (r0 == 0) goto L_0x00e2
        L_0x00e0:
            r0 = r2
            goto L_0x00e3
        L_0x00e2:
            r0 = r3
        L_0x00e3:
            e.c.e.a.g r1 = r13.q     // Catch:{ Exception -> 0x00ea }
            boolean r14 = r1.c(r14)     // Catch:{ Exception -> 0x00ea }
            goto L_0x00ef
        L_0x00ea:
            r14 = move-exception
            r14.printStackTrace()
            r14 = r3
        L_0x00ef:
            if (r14 != 0) goto L_0x00f5
            if (r0 == 0) goto L_0x00f4
            goto L_0x00f5
        L_0x00f4:
            r2 = r3
        L_0x00f5:
            return r2
        L_0x00f6:
            e.c.e.a.g r14 = r13.q
            r14.b()
            return r3
        L_0x00fc:
            e.c.e.a.g r0 = r13.q
            r0.b()
            boolean r14 = super.onInterceptTouchEvent(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.e.a.e.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.v) {
            this.f6886h = (!this.f6883e || !this.u) ? 0.0f : 1.0f;
        }
        int i9 = paddingLeft;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                C0073e eVar = (C0073e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (eVar.f6897b) {
                    int i11 = i8 - paddingRight;
                    int min = (Math.min(paddingLeft, i11 - this.f6882d) - i9) - (eVar.leftMargin + eVar.rightMargin);
                    this.f6888j = min;
                    eVar.f6898c = (measuredWidth / 2) + ((eVar.leftMargin + i9) + min) > i11;
                    i7 = ((int) (((float) min) * this.f6886h)) + eVar.leftMargin + i9;
                } else {
                    if (this.f6883e) {
                        int i12 = this.m;
                        if (i12 != 0) {
                            i6 = (int) ((1.0f - this.f6886h) * ((float) i12));
                            i7 = paddingLeft;
                            int i13 = i7 - i6;
                            childAt.layout(i13, paddingTop, measuredWidth + i13, childAt.getMeasuredHeight() + paddingTop);
                            paddingLeft = childAt.getWidth() + paddingLeft;
                            i9 = i7;
                        }
                    }
                    i7 = paddingLeft;
                }
                i6 = 0;
                int i132 = i7 - i6;
                childAt.layout(i132, paddingTop, measuredWidth + i132, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft = childAt.getWidth() + paddingLeft;
                i9 = i7;
            }
        }
        if (this.v) {
            if (this.f6883e) {
                if (this.m != 0) {
                    a(this.f6886h);
                }
                if (((C0073e) this.f6885g.getLayoutParams()).f6898c) {
                    a(this.f6885g, this.f6886h, this.f6879a);
                }
            } else {
                for (int i14 = 0; i14 < childCount; i14++) {
                    a(getChildAt(i14), 0.0f, this.f6879a);
                }
            }
            b(this.f6885g);
        }
        this.v = false;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i3);
        int size2 = MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z2 = false;
        if (mode2 == Integer.MIN_VALUE) {
            i4 = (size2 - getPaddingTop()) - getPaddingBottom();
            i5 = 0;
        } else if (mode2 != 1073741824) {
            i5 = 0;
            i4 = -1;
        } else {
            i5 = (size2 - getPaddingTop()) - getPaddingBottom();
            i4 = i5;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f6885g = null;
        float f2 = 0.0f;
        int i16 = 0;
        boolean z3 = false;
        float f3 = 0.0f;
        while (true) {
            i6 = 8;
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            C0073e eVar = (C0073e) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                eVar.f6898c = z2;
            } else {
                float f4 = eVar.f6896a;
                if (f4 > f2) {
                    f3 += f4;
                    if (eVar.width == 0) {
                    }
                }
                int i17 = eVar.leftMargin + eVar.rightMargin;
                int i18 = eVar.width;
                if (i18 == -2) {
                    i12 = MeasureSpec.makeMeasureSpec(size - i17, Integer.MIN_VALUE);
                    i13 = -1;
                } else {
                    i13 = -1;
                    if (i18 == -1) {
                        i12 = MeasureSpec.makeMeasureSpec(size - i17, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
                    } else {
                        i12 = MeasureSpec.makeMeasureSpec(i18, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
                    }
                }
                int i19 = eVar.height;
                if (i19 == -2) {
                    i14 = Integer.MIN_VALUE;
                    i15 = MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                } else {
                    i14 = Integer.MIN_VALUE;
                    if (i19 == i13) {
                        i15 = MeasureSpec.makeMeasureSpec(i4, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
                    } else {
                        i15 = MeasureSpec.makeMeasureSpec(i19, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
                    }
                }
                childAt.measure(i12, i15);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == i14 && measuredHeight > i5) {
                    i5 = Math.min(measuredHeight, i4);
                }
                paddingLeft -= measuredWidth;
                boolean z4 = paddingLeft < 0;
                eVar.f6897b = z4;
                z3 |= z4;
                if (z4) {
                    this.f6885g = childAt;
                }
            }
            i16++;
            z2 = false;
            f2 = 0.0f;
        }
        if (z3 || f3 > 0.0f) {
            int i20 = size - this.f6882d;
            int i21 = 0;
            while (i21 < childCount) {
                View childAt2 = getChildAt(i21);
                if (childAt2.getVisibility() != i6) {
                    C0073e eVar2 = (C0073e) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i6) {
                        boolean z5 = eVar2.width == 0 && eVar2.f6896a > 0.0f;
                        if (z5) {
                            i7 = 0;
                        } else {
                            i7 = childAt2.getMeasuredWidth();
                        }
                        if (!z3 || childAt2 == this.f6885g) {
                            if (eVar2.f6896a > 0.0f) {
                                if (eVar2.width == 0) {
                                    int i22 = eVar2.height;
                                    if (i22 == -2) {
                                        i9 = MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                        i8 = NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH;
                                    } else if (i22 == -1) {
                                        i8 = NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH;
                                        i9 = MeasureSpec.makeMeasureSpec(i4, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
                                    } else {
                                        i8 = NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH;
                                        i9 = MeasureSpec.makeMeasureSpec(i22, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
                                    }
                                } else {
                                    i8 = NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH;
                                    i9 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
                                }
                                if (z3) {
                                    int i23 = size - (eVar2.leftMargin + eVar2.rightMargin);
                                    int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i23, i8);
                                    if (i7 != i23) {
                                        childAt2.measure(makeMeasureSpec, i9);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(i7 + ((int) ((eVar2.f6896a * ((float) Math.max(0, paddingLeft))) / f3)), NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH), i9);
                                    i21++;
                                    i6 = 8;
                                }
                            }
                        } else if (eVar2.width < 0 && (i7 > i20 || eVar2.f6896a > 0.0f)) {
                            if (z5) {
                                int i24 = eVar2.height;
                                if (i24 == -2) {
                                    i11 = MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                    i10 = NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH;
                                } else if (i24 == -1) {
                                    i10 = NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH;
                                    i11 = MeasureSpec.makeMeasureSpec(i4, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
                                } else {
                                    i10 = NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH;
                                    i11 = MeasureSpec.makeMeasureSpec(i24, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
                                }
                            } else {
                                i10 = NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH;
                                i11 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(this.y ? i20 : size, i10), i11);
                        }
                    }
                }
                i21++;
                i6 = 8;
            }
        }
        setMeasuredDimension(size, i5);
        this.f6883e = z3;
        g gVar = this.q;
        if (gVar.f6902a != 0 && !z3) {
            gVar.a();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        if (!gVar.f6900a) {
            a(0);
        } else if (this.v || b(1.0f)) {
            this.u = true;
        }
        this.u = gVar.f6900a;
    }

    public Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        boolean z2 = this.f6883e;
        boolean z3 = z2 ? !z2 || this.f6886h == 1.0f : this.u;
        gVar.f6900a = z3;
        return gVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            this.v = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f6883e) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.n = x2;
            this.o = y2;
        } else if (action != 1) {
            if (action == 2) {
                float x3 = motionEvent.getX();
                if (Math.abs(motionEvent.getY() - this.o) > Math.abs(x3 - this.n)) {
                    return true;
                }
            }
        } else if (a(this.f6885g)) {
            float x4 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float f2 = x4 - this.n;
            float f3 = y3 - this.o;
            g gVar = this.q;
            int i2 = gVar.f6903b;
            if ((f3 * f3) + (f2 * f2) < ((float) (i2 * i2)) && gVar.a(this.f6885g, (int) x4, (int) y3)) {
                a(0);
            }
        }
        try {
            this.q.a(motionEvent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f6883e) {
            this.u = view == this.f6885g;
        }
    }

    public void setActivityIsTranslucent(boolean z2) {
        this.f6884f = z2;
    }

    public void setAutoSlideToRight(boolean z2) {
        this.y = z2;
    }

    public void setCanSlideRegionFactor(double d2) {
        this.r = d2;
    }

    public void setCoveredFadeColor(int i2) {
        this.f6880b = i2;
    }

    public void setPanelSlideListener(f fVar) {
        this.p = fVar;
    }

    public void setParallaxDistance(int i2) {
        this.m = i2;
        requestLayout();
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f6881c = drawable;
    }

    public void setShadowResource(int i2) {
        setShadowDrawable(getResources().getDrawable(i2));
    }

    public void setSliderFadeColor(int i2) {
        this.f6879a = i2;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0073e(getContext(), attributeSet);
    }

    public final void a(View view, float f2, int i2) {
        C0073e eVar = (C0073e) view.getLayoutParams();
        if (f2 > 0.0f && i2 != 0) {
            int i3 = (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24) | (i2 & 16777215);
            if (eVar.f6899d == null) {
                eVar.f6899d = new Paint();
            }
            eVar.f6899d.setColorFilter(new PorterDuffColorFilter(i3, Mode.SRC_OVER));
            if (m.l(view) != 2) {
                view.setLayerType(2, eVar.f6899d);
            }
            view.setLayerPaint(((C0073e) view.getLayoutParams()).f6899d);
        } else if (m.l(view) != 0) {
            Paint paint = eVar.f6899d;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            c cVar = new c(view);
            this.x.add(cVar);
            postOnAnimation(cVar);
        }
    }

    public void b() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public boolean b(float f2) {
        if (!this.f6883e) {
            return false;
        }
        int paddingLeft = (int) ((f2 * ((float) this.f6888j)) + ((float) (getPaddingLeft() + ((C0073e) this.f6885g.getLayoutParams()).leftMargin)));
        g gVar = this.q;
        View view = this.f6885g;
        int top = view.getTop();
        gVar.s = view;
        gVar.f6904c = -1;
        boolean a2 = gVar.a(paddingLeft, top, 0, 0);
        if (!a2 && gVar.f6902a == 0 && gVar.s != null) {
            gVar.s = null;
        }
        if (!a2) {
            return false;
        }
        b();
        m.D(this);
        return true;
    }

    public final void a(float f2) {
        C0073e eVar = (C0073e) this.f6885g.getLayoutParams();
        boolean z2 = eVar.f6898c && eVar.leftMargin <= 0;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != this.f6885g) {
                float f3 = 1.0f - this.f6887i;
                int i3 = this.m;
                int i4 = (int) (f3 * ((float) i3));
                this.f6887i = f2;
                childAt.offsetLeftAndRight(i4 - ((int) ((1.0f - f2) * ((float) i3))));
                if (z2) {
                    a(childAt, 1.0f - this.f6887i, this.f6880b);
                }
            }
        }
    }

    public boolean a(View view, boolean z2, int i2, int i3, int i4) {
        View view2 = view;
        boolean z3 = true;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i3 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight()) {
                    int i6 = i4 + scrollY;
                    if (i6 >= childAt.getTop() && i6 < childAt.getBottom()) {
                        if (a(childAt, true, i2, i5 - childAt.getLeft(), i6 - childAt.getTop())) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!z2 || !m.a(view, -i2)) {
            z3 = false;
        }
        return z3;
    }

    public boolean a(View view) {
        boolean z2 = false;
        if (view == null) {
            return false;
        }
        C0073e eVar = (C0073e) view.getLayoutParams();
        if (this.f6883e && eVar.f6898c && this.f6886h > 0.0f) {
            z2 = true;
        }
        return z2;
    }

    public static /* synthetic */ void a(e eVar, View view) {
        if (eVar != null) {
            m.a(view, ((C0073e) view.getLayoutParams()).f6899d);
            return;
        }
        throw null;
    }
}
