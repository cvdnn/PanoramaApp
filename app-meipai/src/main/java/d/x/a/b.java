package d.x.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.baidubce.auth.NTLMEngineImpl;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Comparator;

/* compiled from: ViewPager */
public class b extends ViewGroup {
    public static final int[] E = {16842931};
    public static final Comparator<c> F = new a();
    public static final g G = new g();
    public int A;
    public e B;
    public ArrayList<View> C;
    public int D;

    /* renamed from: a reason: collision with root package name */
    public int f5611a;

    /* renamed from: b reason: collision with root package name */
    public a f5612b;

    /* renamed from: c reason: collision with root package name */
    public int f5613c;

    /* renamed from: d reason: collision with root package name */
    public int f5614d;

    /* renamed from: e reason: collision with root package name */
    public Parcelable f5615e;

    /* renamed from: f reason: collision with root package name */
    public ClassLoader f5616f;

    /* renamed from: g reason: collision with root package name */
    public boolean f5617g;

    /* renamed from: h reason: collision with root package name */
    public int f5618h;

    /* renamed from: i reason: collision with root package name */
    public Drawable f5619i;

    /* renamed from: j reason: collision with root package name */
    public int f5620j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public float t;
    public float u;
    public float v;
    public float w;
    public int x;
    public VelocityTracker y;
    public boolean z;

    /* compiled from: ViewPager */
    public static class a implements Comparator<c> {
        public int compare(Object obj, Object obj2) {
            return ((c) obj).f5621a - ((c) obj2).f5621a;
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: d.x.a.b$b reason: collision with other inner class name */
    /* compiled from: ViewPager */
    public @interface C0061b {
    }

    /* compiled from: ViewPager */
    public static class c {

        /* renamed from: a reason: collision with root package name */
        public int f5621a;
    }

    /* compiled from: ViewPager */
    public static class d extends LayoutParams {

        /* renamed from: a reason: collision with root package name */
        public boolean f5622a;

        /* renamed from: b reason: collision with root package name */
        public int f5623b;

        /* renamed from: c reason: collision with root package name */
        public float f5624c = 0.0f;

        /* renamed from: d reason: collision with root package name */
        public boolean f5625d;

        /* renamed from: e reason: collision with root package name */
        public int f5626e;

        /* renamed from: f reason: collision with root package name */
        public int f5627f;

        public d() {
            super(-1, -1);
        }

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.E);
            this.f5623b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ViewPager */
    public interface e {
        void onPageScrollStateChanged(int i2);
    }

    /* compiled from: ViewPager */
    public static class f extends d.j.a.a {
        public static final Creator<f> CREATOR = new a();

        /* renamed from: c reason: collision with root package name */
        public int f5628c;

        /* renamed from: d reason: collision with root package name */
        public Parcelable f5629d;

        /* renamed from: e reason: collision with root package name */
        public ClassLoader f5630e;

        /* compiled from: ViewPager */
        public static class a implements ClassLoaderCreator<f> {
            public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            public Object[] newArray(int i2) {
                return new f[i2];
            }

            public Object createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }
        }

        public f(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder a2 = e.a.a.a.a.a("FragmentPager.SavedState{");
            a2.append(Integer.toHexString(System.identityHashCode(this)));
            a2.append(" position=");
            return e.a.a.a.a.a(a2, this.f5628c, "}");
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f5012a, i2);
            parcel.writeInt(this.f5628c);
            parcel.writeParcelable(this.f5629d, i2);
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = f.class.getClassLoader();
            }
            this.f5628c = parcel.readInt();
            this.f5629d = parcel.readParcelable(classLoader);
            this.f5630e = classLoader;
        }
    }

    /* compiled from: ViewPager */
    public static class g implements Comparator<View> {
        public int compare(Object obj, Object obj2) {
            d dVar = (d) ((View) obj).getLayoutParams();
            d dVar2 = (d) ((View) obj2).getLayoutParams();
            boolean z = dVar.f5622a;
            if (z != dVar2.f5622a) {
                return z ? 1 : -1;
            }
            return dVar.f5626e - dVar2.f5626e;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.n != z2) {
            this.n = z2;
        }
    }

    public final void a(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            int i4 = 0;
            while (i4 < getChildCount()) {
                if (getChildAt(i4).getVisibility() != 0) {
                    i4++;
                } else {
                    throw null;
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (getChildAt(i2).getVisibility() != 0) {
                i2++;
            } else {
                throw null;
            }
        }
    }

    public void addView(View view, int i2, LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = new d();
        }
        d dVar = (d) layoutParams;
        boolean z2 = dVar.f5622a | (view.getClass().getAnnotation(C0061b.class) != null);
        dVar.f5622a = z2;
        if (!this.m) {
            super.addView(view, i2, layoutParams);
        } else if (!z2) {
            dVar.f5625d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void b() {
        int i2 = this.f5613c;
        if (i2 != i2) {
            throw null;
        }
    }

    public final boolean c() {
        this.x = -1;
        this.q = false;
        this.r = false;
        VelocityTracker velocityTracker = this.y;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.y = null;
        }
        throw null;
    }

    public boolean canScrollHorizontally(int i2) {
        return false;
    }

    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.f5617g = true;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0059
            int r0 = r6.getAction()
            if (r0 != 0) goto L_0x0056
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L_0x0044
            r3 = 22
            if (r0 == r3) goto L_0x0036
            r3 = 61
            if (r0 == r3) goto L_0x0020
            goto L_0x0056
        L_0x0020:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L_0x002b
            boolean r6 = r5.a(r4)
            goto L_0x0057
        L_0x002b:
            boolean r6 = r6.hasModifiers(r2)
            if (r6 == 0) goto L_0x0056
            boolean r6 = r5.a(r2)
            goto L_0x0057
        L_0x0036:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L_0x003d
            goto L_0x0056
        L_0x003d:
            r6 = 66
            boolean r6 = r5.a(r6)
            goto L_0x0057
        L_0x0044:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L_0x004f
            boolean r6 = r5.a()
            goto L_0x0057
        L_0x004f:
            r6 = 17
            boolean r6 = r5.a(r6)
            goto L_0x0057
        L_0x0056:
            r6 = r1
        L_0x0057:
            if (r6 == 0) goto L_0x005a
        L_0x0059:
            r1 = r2
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.x.a.b.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            if (getChildAt(i2).getVisibility() != 0) {
                i2++;
            } else {
                throw null;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getOverScrollMode() != 0) {
            throw null;
        }
        throw null;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f5619i;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new d();
    }

    public a getAdapter() {
        return null;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        return ((d) ((View) this.C.get(i3)).getLayoutParams()).f5627f;
    }

    public int getCurrentItem() {
        return this.f5613c;
    }

    public int getOffscreenPageLimit() {
        return this.p;
    }

    public int getPageMargin() {
        return this.f5618h;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.z = true;
    }

    public void onDetachedFromWindow() {
        removeCallbacks(null);
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5618h > 0 && this.f5619i != null) {
            throw null;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            c();
            throw null;
        }
        if (action != 0) {
            if (this.q) {
                return true;
            }
            if (this.r) {
                return false;
            }
        }
        if (action != 0) {
            if (action == 2) {
                int i2 = this.x;
                if (i2 != -1) {
                    int findPointerIndex = motionEvent2.findPointerIndex(i2);
                    float x2 = motionEvent2.getX(findPointerIndex);
                    float f2 = x2 - this.t;
                    float abs = Math.abs(f2);
                    float y2 = motionEvent2.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.w);
                    int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i3 != 0) {
                        float f3 = this.t;
                        if (!((f3 < ((float) this.s) && i3 > 0) || (f3 > ((float) (getWidth() - this.s)) && f2 < 0.0f))) {
                            if (a(this, false, (int) f2, (int) x2, (int) y2)) {
                                this.t = x2;
                                this.u = y2;
                                this.r = true;
                                return false;
                            }
                        }
                    }
                    float f4 = (float) 0;
                    if (abs > f4 && abs * 0.5f > abs2) {
                        this.q = true;
                        a(true);
                        setScrollState(1);
                        float f5 = this.v;
                        this.t = i3 > 0 ? f5 + f4 : f5 - f4;
                        this.u = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > f4) {
                        this.r = true;
                    }
                    if (this.q) {
                        this.t = x2;
                        getScrollX();
                        getClientWidth();
                        throw null;
                    }
                }
            } else if (action == 6) {
                a(motionEvent);
            }
            if (this.y == null) {
                this.y = VelocityTracker.obtain();
            }
            this.y.addMovement(motionEvent2);
            return this.q;
        }
        float x3 = motionEvent.getX();
        this.v = x3;
        this.t = x3;
        float y3 = motionEvent.getY();
        this.w = y3;
        this.u = y3;
        this.x = motionEvent2.getPointerId(0);
        this.r = false;
        this.f5617g = true;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r18.getChildCount()
            int r2 = r22 - r20
            int r3 = r23 - r21
            int r4 = r18.getPaddingLeft()
            int r5 = r18.getPaddingTop()
            int r6 = r18.getPaddingRight()
            int r7 = r18.getPaddingBottom()
            int r8 = r18.getScrollX()
            r10 = 0
            r11 = 0
        L_0x0020:
            r12 = 8
            if (r10 >= r1) goto L_0x00b6
            android.view.View r13 = r0.getChildAt(r10)
            int r14 = r13.getVisibility()
            if (r14 == r12) goto L_0x00b2
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            d.x.a.b$d r12 = (d.x.a.b.d) r12
            boolean r14 = r12.f5622a
            if (r14 == 0) goto L_0x00b2
            int r12 = r12.f5623b
            r14 = r12 & 7
            r12 = r12 & 112(0x70, float:1.57E-43)
            r15 = 1
            if (r14 == r15) goto L_0x005c
            r15 = 3
            if (r14 == r15) goto L_0x0056
            r15 = 5
            if (r14 == r15) goto L_0x0049
            r14 = r4
            goto L_0x006d
        L_0x0049:
            int r14 = r2 - r6
            int r15 = r13.getMeasuredWidth()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredWidth()
            int r6 = r6 + r15
            goto L_0x0068
        L_0x0056:
            int r14 = r13.getMeasuredWidth()
            int r14 = r14 + r4
            goto L_0x006d
        L_0x005c:
            int r14 = r13.getMeasuredWidth()
            int r14 = r2 - r14
            int r14 = r14 / 2
            int r14 = java.lang.Math.max(r14, r4)
        L_0x0068:
            r17 = r14
            r14 = r4
            r4 = r17
        L_0x006d:
            r15 = 16
            if (r12 == r15) goto L_0x008e
            r15 = 48
            if (r12 == r15) goto L_0x0088
            r15 = 80
            if (r12 == r15) goto L_0x007b
            r12 = r5
            goto L_0x009f
        L_0x007b:
            int r12 = r3 - r7
            int r15 = r13.getMeasuredHeight()
            int r12 = r12 - r15
            int r15 = r13.getMeasuredHeight()
            int r7 = r7 + r15
            goto L_0x009a
        L_0x0088:
            int r12 = r13.getMeasuredHeight()
            int r12 = r12 + r5
            goto L_0x009f
        L_0x008e:
            int r12 = r13.getMeasuredHeight()
            int r12 = r3 - r12
            int r12 = r12 / 2
            int r12 = java.lang.Math.max(r12, r5)
        L_0x009a:
            r17 = r12
            r12 = r5
            r5 = r17
        L_0x009f:
            int r4 = r4 + r8
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r4
            int r16 = r13.getMeasuredHeight()
            int r9 = r16 + r5
            r13.layout(r4, r5, r15, r9)
            int r11 = r11 + 1
            r5 = r12
            r4 = r14
        L_0x00b2:
            int r10 = r10 + 1
            goto L_0x0020
        L_0x00b6:
            r2 = 0
        L_0x00b7:
            r4 = 0
            if (r2 >= r1) goto L_0x00d3
            android.view.View r6 = r0.getChildAt(r2)
            int r8 = r6.getVisibility()
            if (r8 == r12) goto L_0x00d0
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            d.x.a.b$d r6 = (d.x.a.b.d) r6
            boolean r6 = r6.f5622a
            if (r6 == 0) goto L_0x00cf
            goto L_0x00d0
        L_0x00cf:
            throw r4
        L_0x00d0:
            int r2 = r2 + 1
            goto L_0x00b7
        L_0x00d3:
            r0.f5620j = r5
            int r3 = r3 - r7
            r0.k = r3
            r0.A = r11
            boolean r1 = r0.z
            if (r1 != 0) goto L_0x00e2
            r1 = 0
            r0.z = r1
            return
        L_0x00e2:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d.x.a.b.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i2), ViewGroup.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.s = Math.min(measuredWidth / 10, 0);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            boolean z2 = true;
            int i6 = NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar != null && dVar.f5622a) {
                    int i7 = dVar.f5623b;
                    int i8 = i7 & 7;
                    int i9 = i7 & 112;
                    boolean z3 = i9 == 48 || i9 == 80;
                    if (!(i8 == 3 || i8 == 5)) {
                        z2 = false;
                    }
                    int i10 = Integer.MIN_VALUE;
                    if (z3) {
                        i4 = Integer.MIN_VALUE;
                        i10 = 1073741824;
                    } else {
                        i4 = z2 ? 1073741824 : Integer.MIN_VALUE;
                    }
                    int i11 = dVar.width;
                    if (i11 != -2) {
                        if (i11 == -1) {
                            i11 = paddingLeft;
                        }
                        i10 = 1073741824;
                    } else {
                        i11 = paddingLeft;
                    }
                    int i12 = dVar.height;
                    if (i12 == -2) {
                        i12 = measuredHeight;
                        i6 = i4;
                    } else if (i12 == -1) {
                        i12 = measuredHeight;
                    }
                    childAt.measure(MeasureSpec.makeMeasureSpec(i11, i10), MeasureSpec.makeMeasureSpec(i12, i6));
                    if (z3) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z2) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
            i5++;
        }
        MeasureSpec.makeMeasureSpec(paddingLeft, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
        this.l = MeasureSpec.makeMeasureSpec(measuredHeight, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
        this.m = true;
        b();
        this.m = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8) {
                d dVar2 = (d) childAt2.getLayoutParams();
                if (dVar2 == null || !dVar2.f5622a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (((float) paddingLeft) * dVar2.f5624c), NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH), this.l);
                }
            }
        }
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i4 = 1;
            i5 = childCount;
            i3 = 0;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            if (getChildAt(i3).getVisibility() != 0) {
                i3 += i4;
            } else {
                throw null;
            }
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.f5012a);
        this.f5614d = fVar.f5628c;
        this.f5615e = fVar.f5629d;
        this.f5616f = fVar.f5630e;
    }

    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        fVar.f5628c = this.f5613c;
        return fVar;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4) {
            return;
        }
        if (i4 > 0) {
            throw null;
        }
        throw null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            motionEvent.getEdgeFlags();
        }
        return false;
    }

    public void removeView(View view) {
        if (this.m) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(a aVar) {
        this.f5612b = aVar;
        this.f5611a = 0;
    }

    public void setCurrentItem(int i2) {
        this.o = false;
        setScrollingCacheEnabled(false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested offscreen page limit ");
            sb.append(i2);
            sb.append(" too small; defaulting to ");
            sb.append(1);
            Log.w("ViewPager", sb.toString());
            i2 = 1;
        }
        if (i2 != this.p) {
            this.p = i2;
            b();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(e eVar) {
        this.B = eVar;
    }

    public void setPageMargin(int i2) {
        this.f5618h = i2;
        if (getWidth() > 0) {
            throw null;
        }
        throw null;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f5619i = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i2) {
        if (this.D != i2) {
            this.D = i2;
            e eVar = this.B;
            if (eVar != null) {
                eVar.onPageScrollStateChanged(i2);
            }
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5619i;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public final void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.x) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.t = motionEvent.getX(i2);
            this.x = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.y;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(d.h.e.a.b(getContext(), i2));
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
        if (!z2 || !view.canScrollHorizontally(-i2)) {
            z3 = false;
        }
        return z3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r8) {
        /*
            r7 = this;
            android.view.View r0 = r7.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r7) goto L_0x000a
            goto L_0x0063
        L_0x000a:
            if (r0 == 0) goto L_0x0064
            android.view.ViewParent r4 = r0.getParent()
        L_0x0010:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x001d
            if (r4 != r7) goto L_0x0018
            r4 = r1
            goto L_0x001e
        L_0x0018:
            android.view.ViewParent r4 = r4.getParent()
            goto L_0x0010
        L_0x001d:
            r4 = r2
        L_0x001e:
            if (r4 != 0) goto L_0x0064
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L_0x0034:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x004d
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0034
        L_0x004d:
            java.lang.String r0 = "arrowScroll tried to find focus based on non-child current focused view "
            java.lang.StringBuilder r0 = e.a.a.a.a.a(r0)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e(r4, r0)
        L_0x0063:
            r0 = r3
        L_0x0064:
            android.view.FocusFinder r4 = android.view.FocusFinder.getInstance()
            android.view.View r4 = r4.findNextFocus(r7, r0, r8)
            r5 = 66
            r6 = 17
            if (r4 == 0) goto L_0x00a9
            if (r4 == r0) goto L_0x00a9
            if (r8 != r6) goto L_0x0091
            android.graphics.Rect r1 = r7.a(r3, r4)
            int r1 = r1.left
            android.graphics.Rect r2 = r7.a(r3, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x008b
            if (r1 < r2) goto L_0x008b
            boolean r0 = r7.a()
            goto L_0x008f
        L_0x008b:
            boolean r0 = r4.requestFocus()
        L_0x008f:
            r2 = r0
            goto L_0x00b1
        L_0x0091:
            if (r8 != r5) goto L_0x00b1
            android.graphics.Rect r1 = r7.a(r3, r4)
            int r1 = r1.left
            android.graphics.Rect r3 = r7.a(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L_0x00a4
            if (r1 > r3) goto L_0x00a4
            goto L_0x00b1
        L_0x00a4:
            boolean r0 = r4.requestFocus()
            goto L_0x008f
        L_0x00a9:
            if (r8 == r6) goto L_0x00ad
            if (r8 != r1) goto L_0x00b1
        L_0x00ad:
            boolean r2 = r7.a()
        L_0x00b1:
            if (r2 == 0) goto L_0x00ba
            int r8 = android.view.SoundEffectConstants.getContantForFocusDirection(r8)
            r7.playSoundEffect(r8)
        L_0x00ba:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d.x.a.b.a(int):boolean");
    }

    public final Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public boolean a() {
        if (this.f5613c <= 0) {
            return false;
        }
        this.o = false;
        setScrollingCacheEnabled(false);
        return true;
    }
}
