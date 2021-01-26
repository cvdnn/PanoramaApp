package d.l.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.baidubce.auth.NTLMEngineImpl;
import d.h.k.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DrawerLayout */
public class a extends ViewGroup {
    public static final int[] q = {16842931};

    /* renamed from: a reason: collision with root package name */
    public float f5043a;

    /* renamed from: b reason: collision with root package name */
    public int f5044b;

    /* renamed from: c reason: collision with root package name */
    public float f5045c;

    /* renamed from: d reason: collision with root package name */
    public boolean f5046d;

    /* renamed from: e reason: collision with root package name */
    public boolean f5047e;

    /* renamed from: f reason: collision with root package name */
    public int f5048f;

    /* renamed from: g reason: collision with root package name */
    public int f5049g;

    /* renamed from: h reason: collision with root package name */
    public int f5050h;

    /* renamed from: i reason: collision with root package name */
    public int f5051i;

    /* renamed from: j reason: collision with root package name */
    public C0047a f5052j;
    public List<C0047a> k;
    public Drawable l;
    public Drawable m;
    public Drawable n;
    public Rect o;
    public Matrix p;

    /* renamed from: d.l.a.a$a reason: collision with other inner class name */
    /* compiled from: DrawerLayout */
    public interface C0047a {
        void a(View view, float f2);
    }

    /* compiled from: DrawerLayout */
    public static class b extends MarginLayoutParams {

        /* renamed from: a reason: collision with root package name */
        public int f5053a = 0;

        /* renamed from: b reason: collision with root package name */
        public float f5054b;

        /* renamed from: c reason: collision with root package name */
        public boolean f5055c;

        /* renamed from: d reason: collision with root package name */
        public int f5056d;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.q);
            this.f5053a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public b(int i2, int i3) {
            super(i2, i3);
        }

        public b(b bVar) {
            super(bVar);
            this.f5053a = bVar.f5053a;
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* compiled from: DrawerLayout */
    public static class c extends d.j.a.a {
        public static final Creator<c> CREATOR = new C0048a();

        /* renamed from: c reason: collision with root package name */
        public int f5057c = 0;

        /* renamed from: d reason: collision with root package name */
        public int f5058d;

        /* renamed from: e reason: collision with root package name */
        public int f5059e;

        /* renamed from: f reason: collision with root package name */
        public int f5060f;

        /* renamed from: g reason: collision with root package name */
        public int f5061g;

        /* renamed from: d.l.a.a$c$a reason: collision with other inner class name */
        /* compiled from: DrawerLayout */
        public static class C0048a implements ClassLoaderCreator<c> {
            public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            public Object[] newArray(int i2) {
                return new c[i2];
            }

            public Object createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5057c = parcel.readInt();
            this.f5058d = parcel.readInt();
            this.f5059e = parcel.readInt();
            this.f5060f = parcel.readInt();
            this.f5061g = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f5012a, i2);
            parcel.writeInt(this.f5057c);
            parcel.writeInt(this.f5058d);
            parcel.writeInt(this.f5059e);
            parcel.writeInt(this.f5060f);
            parcel.writeInt(this.f5061g);
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.Throwable, d.j.b.e] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v1, types: [java.lang.Throwable, d.j.b.e]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [java.lang.Throwable, d.j.b.e]
  mth insns count: 54
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r5, int r6) {
        /*
            r4 = this;
            int r0 = d.h.k.m.m(r4)
            int r0 = android.view.Gravity.getAbsoluteGravity(r6, r0)
            r1 = 3
            if (r6 == r1) goto L_0x0022
            r2 = 5
            if (r6 == r2) goto L_0x001f
            r2 = 8388611(0x800003, float:1.1754948E-38)
            if (r6 == r2) goto L_0x001c
            r2 = 8388613(0x800005, float:1.175495E-38)
            if (r6 == r2) goto L_0x0019
            goto L_0x0024
        L_0x0019:
            r4.f5051i = r5
            goto L_0x0024
        L_0x001c:
            r4.f5050h = r5
            goto L_0x0024
        L_0x001f:
            r4.f5049g = r5
            goto L_0x0024
        L_0x0022:
            r4.f5048f = r5
        L_0x0024:
            r6 = 0
            if (r5 == 0) goto L_0x002a
            r6.a()
        L_0x002a:
            r2 = 1
            if (r5 == r2) goto L_0x003b
            r6 = 2
            if (r5 == r6) goto L_0x0031
            goto L_0x0091
        L_0x0031:
            android.view.View r5 = r4.a(r0)
            if (r5 == 0) goto L_0x0091
            r4.e(r5)
            goto L_0x0091
        L_0x003b:
            android.view.View r5 = r4.a(r0)
            if (r5 == 0) goto L_0x0091
            boolean r0 = r4.d(r5)
            if (r0 == 0) goto L_0x0075
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            d.l.a.a$b r0 = (d.l.a.a.b) r0
            boolean r2 = r4.f5047e
            r3 = 0
            if (r2 == 0) goto L_0x005b
            r0.f5054b = r3
            r5 = 0
            r0.f5056d = r5
            r4.invalidate()
            goto L_0x0091
        L_0x005b:
            int r2 = r0.f5056d
            r2 = r2 | 4
            r0.f5056d = r2
            boolean r0 = r4.a(r5, r1)
            if (r0 == 0) goto L_0x006e
            r5.getWidth()
            r5.getTop()
            throw r6
        L_0x006e:
            r4.getWidth()
            r5.getTop()
            throw r6
        L_0x0075:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "View "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = " is not a sliding drawer"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.l.a.a.a(int, int):void");
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            int i4 = 0;
            boolean z = false;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (!d(childAt)) {
                    throw null;
                } else if (d(childAt)) {
                    if ((((b) childAt.getLayoutParams()).f5056d & 1) == 1) {
                        childAt.addFocusables(arrayList, i2, i3);
                        z = true;
                    }
                    i4++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("View ");
                    sb.append(childAt);
                    sb.append(" is not a drawer");
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void addView(View view, int i2, LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (a() != null || d(view)) {
            m.g(view, 4);
        } else {
            view.setImportantForAccessibility(1);
        }
    }

    public int b(View view) {
        return Gravity.getAbsoluteGravity(((b) view.getLayoutParams()).f5053a, m.m(this));
    }

    public boolean c(View view) {
        return ((b) view.getLayoutParams()).f5053a == 0;
    }

    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof b) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((b) getChildAt(i2).getLayoutParams()).f5054b);
        }
        this.f5045c = f2;
        throw null;
    }

    public boolean d(View view) {
        int absoluteGravity = Gravity.getAbsoluteGravity(((b) view.getLayoutParams()).f5053a, m.m(view));
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean z;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f5045c <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount != 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                if (this.o == null) {
                    this.o = new Rect();
                }
                childAt.getHitRect(this.o);
                if (this.o.contains((int) x, (int) y) && !c(childAt)) {
                    if (!childAt.getMatrix().isIdentity()) {
                        float scrollX = (float) (getScrollX() - childAt.getLeft());
                        float scrollY = (float) (getScrollY() - childAt.getTop());
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.offsetLocation(scrollX, scrollY);
                        Matrix matrix = childAt.getMatrix();
                        if (!matrix.isIdentity()) {
                            if (this.p == null) {
                                this.p = new Matrix();
                            }
                            matrix.invert(this.p);
                            obtain.transform(this.p);
                        }
                        z = childAt.dispatchGenericMotionEvent(obtain);
                        obtain.recycle();
                    } else {
                        float scrollX2 = (float) (getScrollX() - childAt.getLeft());
                        float scrollY2 = (float) (getScrollY() - childAt.getTop());
                        motionEvent.offsetLocation(scrollX2, scrollY2);
                        z = childAt.dispatchGenericMotionEvent(motionEvent);
                        motionEvent.offsetLocation(-scrollX2, -scrollY2);
                    }
                    if (z) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean c2 = c(view2);
        int width = getWidth();
        int save = canvas.save();
        if (c2) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view2 && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    if ((background != null && background.getOpacity() == -1) && d(childAt) && childAt.getHeight() >= height) {
                        if (a(childAt, 3)) {
                            int right = childAt.getRight();
                            if (right > i2) {
                                i2 = right;
                            }
                        } else {
                            int left = childAt.getLeft();
                            if (left < width) {
                                width = left;
                            }
                        }
                    }
                }
            }
            canvas2.clipRect(i2, 0, width, getHeight());
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas2.restoreToCount(save);
        if (this.f5045c > 0.0f && c2) {
            throw null;
        } else if (this.m != null && a(view2, 3)) {
            this.m.getIntrinsicWidth();
            view.getRight();
            throw null;
        } else if (this.n == null || !a(view2, 5)) {
            return drawChild;
        } else {
            this.n.getIntrinsicWidth();
            view.getLeft();
            getWidth();
            throw null;
        }
    }

    public void e(View view) {
        if (d(view)) {
            b bVar = (b) view.getLayoutParams();
            if (this.f5047e) {
                bVar.f5054b = 1.0f;
                bVar.f5056d = 1;
                a(view, true);
                invalidate();
                return;
            }
            bVar.f5056d |= 2;
            if (a(view, 3)) {
                view.getTop();
                throw null;
            }
            getWidth();
            view.getWidth();
            view.getTop();
            throw null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a sliding drawer");
        throw new IllegalArgumentException(sb.toString());
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new b((MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public float getDrawerElevation() {
        return this.f5043a;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.l;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5047e = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5047e = true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        motionEvent.getActionMasked();
        throw null;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (b() != null) {
                keyEvent.startTracking();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View b2 = b();
        boolean z = false;
        if (b2 == null || a(b2) != 0) {
            if (b2 != null) {
                z = true;
            }
            return z;
        }
        a(false);
        throw null;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        boolean z2 = true;
        this.f5046d = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                if (c(childAt)) {
                    int i9 = bVar.leftMargin;
                    childAt.layout(i9, bVar.topMargin, childAt.getMeasuredWidth() + i9, childAt.getMeasuredHeight() + bVar.topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f3 = (float) measuredWidth;
                        i6 = (-measuredWidth) + ((int) (bVar.f5054b * f3));
                        f2 = ((float) (measuredWidth + i6)) / f3;
                    } else {
                        float f4 = (float) measuredWidth;
                        int i10 = i7 - ((int) (bVar.f5054b * f4));
                        f2 = ((float) (i7 - i10)) / f4;
                        i6 = i10;
                    }
                    boolean z3 = f2 != bVar.f5054b ? z2 : false;
                    int i11 = bVar.f5053a & 112;
                    if (i11 == 16) {
                        int i12 = i5 - i3;
                        int i13 = (i12 - measuredHeight) / 2;
                        int i14 = bVar.topMargin;
                        if (i13 < i14) {
                            i13 = i14;
                        } else {
                            int i15 = i13 + measuredHeight;
                            int i16 = bVar.bottomMargin;
                            if (i15 > i12 - i16) {
                                i13 = (i12 - i16) - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i13, measuredWidth + i6, measuredHeight + i13);
                    } else if (i11 != 80) {
                        int i17 = bVar.topMargin;
                        childAt.layout(i6, i17, measuredWidth + i6, measuredHeight + i17);
                    } else {
                        int i18 = i5 - i3;
                        childAt.layout(i6, (i18 - bVar.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i18 - bVar.bottomMargin);
                    }
                    if (z3) {
                        a(childAt, f2);
                    }
                    int i19 = bVar.f5054b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i19) {
                        childAt.setVisibility(i19);
                    }
                }
            }
            i8++;
            z2 = true;
        }
        this.f5046d = false;
        this.f5047e = false;
    }

    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i2, int i3) {
        int mode = MeasureSpec.getMode(i2);
        int mode2 = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i2);
        int size2 = MeasureSpec.getSize(i3);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        m.m(this);
        int childCount = getChildCount();
        boolean z = false;
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                if (c(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((size - bVar.leftMargin) - bVar.rightMargin, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH), MeasureSpec.makeMeasureSpec((size2 - bVar.topMargin) - bVar.bottomMargin, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH));
                } else if (d(childAt)) {
                    float elevation = childAt.getElevation();
                    float f2 = this.f5043a;
                    if (elevation != f2) {
                        childAt.setElevation(f2);
                    }
                    int b2 = b(childAt) & 7;
                    boolean z3 = b2 == 3;
                    if ((!z3 || !z) && (z3 || !z2)) {
                        if (z3) {
                            z = true;
                        } else {
                            z2 = true;
                        }
                        childAt.measure(ViewGroup.getChildMeasureSpec(i2, bVar.leftMargin + 0 + bVar.rightMargin, bVar.width), ViewGroup.getChildMeasureSpec(i3, bVar.topMargin + bVar.bottomMargin, bVar.height));
                    } else {
                        StringBuilder a2 = e.a.a.a.a.a("Child drawer has absolute gravity ");
                        String str = (b2 & 3) != 3 ? (b2 & 5) == 5 ? "RIGHT" : Integer.toHexString(b2) : "LEFT";
                        e.a.a.a.a.a(a2, str, " but this ", "DrawerLayout", " already has a ");
                        a2.append("drawer view along that edge");
                        throw new IllegalStateException(a2.toString());
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Child ");
                    sb.append(childAt);
                    sb.append(" at index ");
                    sb.append(i4);
                    sb.append(" does not have a valid layout_gravity - must be Gravity.LEFT, ");
                    sb.append("Gravity.RIGHT or Gravity.NO_GRAVITY");
                    throw new IllegalStateException(sb.toString());
                }
            }
            int i5 = i2;
            int i6 = i3;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.f5012a);
        int i2 = cVar.f5057c;
        if (i2 != 0) {
            View a2 = a(i2);
            if (a2 != null) {
                e(a2);
            }
        }
        int i3 = cVar.f5058d;
        if (i3 != 3) {
            a(i3, 3);
        }
        int i4 = cVar.f5059e;
        if (i4 != 3) {
            a(i4, 5);
        }
        int i5 = cVar.f5060f;
        if (i5 != 3) {
            a(i5, 8388611);
        }
        int i6 = cVar.f5061g;
        if (i6 != 3) {
            a(i6, 8388613);
        }
    }

    public void onRtlPropertiesChanged(int i2) {
    }

    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            b bVar = (b) getChildAt(i2).getLayoutParams();
            boolean z = true;
            boolean z2 = bVar.f5056d == 1;
            if (bVar.f5056d != 2) {
                z = false;
            }
            if (z2 || z) {
                cVar.f5057c = bVar.f5053a;
            } else {
                i2++;
            }
        }
        cVar.f5058d = this.f5048f;
        cVar.f5059e = this.f5049g;
        cVar.f5060f = this.f5050h;
        cVar.f5061g = this.f5051i;
        return cVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        throw null;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            a(true);
            throw null;
        }
    }

    public void requestLayout() {
        if (!this.f5046d) {
            super.requestLayout();
        }
    }

    public void setDrawerElevation(float f2) {
        this.f5043a = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (d(childAt)) {
                childAt.setElevation(this.f5043a);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(C0047a aVar) {
        C0047a aVar2 = this.f5052j;
        if (!(aVar2 == null || aVar2 == null)) {
            List<C0047a> list = this.k;
            if (list != null) {
                list.remove(aVar2);
            }
        }
        if (aVar != null) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            this.k.add(aVar);
        }
        this.f5052j = aVar;
    }

    public void setDrawerLockMode(int i2) {
        a(i2, 3);
        a(i2, 5);
    }

    public void setScrimColor(int i2) {
        this.f5044b = i2;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.l = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.l = new ColorDrawable(i2);
        invalidate();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public void setStatusBarBackground(int i2) {
        this.l = i2 != 0 ? d.h.e.a.b(getContext(), i2) : null;
        invalidate();
    }

    public View b() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (d(childAt)) {
                if (d(childAt)) {
                    if (((b) childAt.getLayoutParams()).f5054b > 0.0f) {
                        return childAt;
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("View ");
                    sb.append(childAt);
                    sb.append(" is not a drawer");
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        }
        return null;
    }

    public int a(View view) {
        if (d(view)) {
            int i2 = ((b) view.getLayoutParams()).f5053a;
            int m2 = m.m(this);
            if (i2 == 3) {
                int i3 = this.f5048f;
                if (i3 != 3) {
                    return i3;
                }
                int i4 = m2 == 0 ? this.f5050h : this.f5051i;
                if (i4 != 3) {
                    return i4;
                }
            } else if (i2 == 5) {
                int i5 = this.f5049g;
                if (i5 != 3) {
                    return i5;
                }
                int i6 = m2 == 0 ? this.f5051i : this.f5050h;
                if (i6 != 3) {
                    return i6;
                }
            } else if (i2 == 8388611) {
                int i7 = this.f5050h;
                if (i7 != 3) {
                    return i7;
                }
                int i8 = m2 == 0 ? this.f5048f : this.f5049g;
                if (i8 != 3) {
                    return i8;
                }
            } else if (i2 == 8388613) {
                int i9 = this.f5051i;
                if (i9 != 3) {
                    return i9;
                }
                int i10 = m2 == 0 ? this.f5049g : this.f5048f;
                if (i10 != 3) {
                    return i10;
                }
            }
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a drawer");
        throw new IllegalArgumentException(sb.toString());
    }

    public final void a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z || d(childAt)) && (!z || childAt != view)) {
                m.g(childAt, 4);
            } else {
                m.g(childAt, 1);
            }
        }
    }

    public void a(View view, float f2) {
        b bVar = (b) view.getLayoutParams();
        if (f2 != bVar.f5054b) {
            bVar.f5054b = f2;
            List<C0047a> list = this.k;
            if (list != null) {
                int size = list.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    ((C0047a) this.k.get(size)).a(view, f2);
                }
            }
        }
    }

    public boolean a(View view, int i2) {
        return (b(view) & i2) == i2;
    }

    public View a() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((b) childAt.getLayoutParams()).f5056d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public View a(int i2) {
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, m.m(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((b(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    public void a(boolean z) {
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            b bVar = (b) childAt.getLayoutParams();
            if (!d(childAt) || (z && !bVar.f5055c)) {
                i2++;
            } else {
                childAt.getWidth();
                if (a(childAt, 3)) {
                    childAt.getTop();
                    throw null;
                }
                getWidth();
                childAt.getTop();
                throw null;
            }
        }
        throw null;
    }
}
