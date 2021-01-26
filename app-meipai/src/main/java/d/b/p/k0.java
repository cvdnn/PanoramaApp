package d.b.p;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidubce.auth.NTLMEngineImpl;
import d.b.j;
import d.b.o.i.p;
import d.h.k.m;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow */
public class k0 implements p {
    public static Method C;
    public static Method D;
    public static Method E;
    public boolean A;
    public PopupWindow B;

    /* renamed from: a reason: collision with root package name */
    public Context f4380a;

    /* renamed from: b reason: collision with root package name */
    public ListAdapter f4381b;

    /* renamed from: c reason: collision with root package name */
    public f0 f4382c;

    /* renamed from: d reason: collision with root package name */
    public int f4383d = -2;

    /* renamed from: e reason: collision with root package name */
    public int f4384e = -2;

    /* renamed from: f reason: collision with root package name */
    public int f4385f;

    /* renamed from: g reason: collision with root package name */
    public int f4386g;

    /* renamed from: h reason: collision with root package name */
    public int f4387h = 1002;

    /* renamed from: i reason: collision with root package name */
    public boolean f4388i;

    /* renamed from: j reason: collision with root package name */
    public boolean f4389j;
    public boolean k;
    public int l = 0;
    public boolean m = false;
    public boolean n = false;
    public int o = Integer.MAX_VALUE;
    public int p = 0;
    public DataSetObserver q;
    public View r;
    public OnItemClickListener s;
    public final e t = new e();
    public final d u = new d();
    public final c v = new c();
    public final a w = new a();
    public final Handler x;
    public final Rect y = new Rect();
    public Rect z;

    /* compiled from: ListPopupWindow */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            f0 f0Var = k0.this.f4382c;
            if (f0Var != null) {
                f0Var.setListSelectionHidden(true);
                f0Var.requestLayout();
            }
        }
    }

    /* compiled from: ListPopupWindow */
    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            if (k0.this.a()) {
                k0.this.d();
            }
        }

        public void onInvalidated() {
            k0.this.dismiss();
        }
    }

    /* compiled from: ListPopupWindow */
    public class c implements OnScrollListener {
        public c() {
        }

        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            boolean z = true;
            if (i2 == 1) {
                if (k0.this.B.getInputMethodMode() != 2) {
                    z = false;
                }
                if (!z && k0.this.B.getContentView() != null) {
                    k0 k0Var = k0.this;
                    k0Var.x.removeCallbacks(k0Var.t);
                    k0.this.t.run();
                }
            }
        }
    }

    /* compiled from: ListPopupWindow */
    public class d implements OnTouchListener {
        public d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0) {
                PopupWindow popupWindow = k0.this.B;
                if (popupWindow != null && popupWindow.isShowing() && x >= 0 && x < k0.this.B.getWidth() && y >= 0 && y < k0.this.B.getHeight()) {
                    k0 k0Var = k0.this;
                    k0Var.x.postDelayed(k0Var.t, 250);
                    return false;
                }
            }
            if (action == 1) {
                k0 k0Var2 = k0.this;
                k0Var2.x.removeCallbacks(k0Var2.t);
            }
            return false;
        }
    }

    /* compiled from: ListPopupWindow */
    public class e implements Runnable {
        public e() {
        }

        public void run() {
            f0 f0Var = k0.this.f4382c;
            if (f0Var != null && m.y(f0Var) && k0.this.f4382c.getCount() > k0.this.f4382c.getChildCount()) {
                int childCount = k0.this.f4382c.getChildCount();
                k0 k0Var = k0.this;
                if (childCount <= k0Var.o) {
                    k0Var.B.setInputMethodMode(2);
                    k0.this.d();
                }
            }
        }
    }

    static {
        String str = "ListPopupWindow";
        if (VERSION.SDK_INT <= 28) {
            try {
                C = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i(str, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                E = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i(str, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (VERSION.SDK_INT <= 23) {
            try {
                D = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i(str, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public k0(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f4380a = context;
        this.x = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ListPopupWindow, i2, i3);
        this.f4385f = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f4386g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f4388i = true;
        }
        obtainStyledAttributes.recycle();
        p pVar = new p(context, attributeSet, i2, i3);
        this.B = pVar;
        pVar.setInputMethodMode(1);
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.q;
        if (dataSetObserver == null) {
            this.q = new b();
        } else {
            ListAdapter listAdapter2 = this.f4381b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f4381b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.q);
        }
        f0 f0Var = this.f4382c;
        if (f0Var != null) {
            f0Var.setAdapter(this.f4381b);
        }
    }

    public int b() {
        return this.f4385f;
    }

    public void d(int i2) {
        Drawable background = this.B.getBackground();
        if (background != null) {
            background.getPadding(this.y);
            Rect rect = this.y;
            this.f4384e = rect.left + rect.right + i2;
            return;
        }
        this.f4384e = i2;
    }

    public void dismiss() {
        this.B.dismiss();
        this.B.setContentView(null);
        this.f4382c = null;
        this.x.removeCallbacks(this.t);
    }

    public Drawable e() {
        return this.B.getBackground();
    }

    public ListView f() {
        return this.f4382c;
    }

    public int g() {
        if (!this.f4388i) {
            return 0;
        }
        return this.f4386g;
    }

    public void b(int i2) {
        this.f4386g = i2;
        this.f4388i = true;
    }

    public void d() {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2 = true;
        if (this.f4382c == null) {
            f0 a2 = a(this.f4380a, !this.A);
            this.f4382c = a2;
            a2.setAdapter(this.f4381b);
            this.f4382c.setOnItemClickListener(this.s);
            this.f4382c.setFocusable(true);
            this.f4382c.setFocusableInTouchMode(true);
            this.f4382c.setOnItemSelectedListener(new j0(this));
            this.f4382c.setOnScrollListener(this.v);
            this.B.setContentView(this.f4382c);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.B.getContentView();
        }
        Drawable background = this.B.getBackground();
        if (background != null) {
            background.getPadding(this.y);
            Rect rect = this.y;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.f4388i) {
                this.f4386g = -i6;
            }
        } else {
            this.y.setEmpty();
            i2 = 0;
        }
        boolean z3 = this.B.getInputMethodMode() == 2;
        View view = this.r;
        int i7 = this.f4386g;
        String str = "ListPopupWindow";
        if (VERSION.SDK_INT <= 23) {
            Method method = D;
            if (method != null) {
                try {
                    i3 = ((Integer) method.invoke(this.B, new Object[]{view, Integer.valueOf(i7), Boolean.valueOf(z3)})).intValue();
                } catch (Exception unused) {
                    Log.i(str, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            i3 = this.B.getMaxAvailableHeight(view, i7);
        } else {
            i3 = this.B.getMaxAvailableHeight(view, i7, z3);
        }
        if (this.m || this.f4383d == -1) {
            i4 = i3 + i2;
        } else {
            int i8 = this.f4384e;
            if (i8 == -2) {
                int i9 = this.f4380a.getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = this.y;
                i5 = MeasureSpec.makeMeasureSpec(i9 - (rect2.left + rect2.right), Integer.MIN_VALUE);
            } else if (i8 != -1) {
                i5 = MeasureSpec.makeMeasureSpec(i8, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
            } else {
                int i10 = this.f4380a.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.y;
                i5 = MeasureSpec.makeMeasureSpec(i10 - (rect3.left + rect3.right), NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
            }
            int a3 = this.f4382c.a(i5, i3 - 0, -1);
            i4 = a3 + (a3 > 0 ? this.f4382c.getPaddingBottom() + this.f4382c.getPaddingTop() + i2 + 0 : 0);
        }
        boolean z4 = this.B.getInputMethodMode() == 2;
        this.B.setWindowLayoutType(this.f4387h);
        if (!this.B.isShowing()) {
            int i11 = this.f4384e;
            if (i11 == -1) {
                i11 = -1;
            } else if (i11 == -2) {
                i11 = this.r.getWidth();
            }
            int i12 = this.f4383d;
            if (i12 == -1) {
                i4 = -1;
            } else if (i12 != -2) {
                i4 = i12;
            }
            this.B.setWidth(i11);
            this.B.setHeight(i4);
            if (VERSION.SDK_INT <= 28) {
                Method method2 = C;
                if (method2 != null) {
                    try {
                        method2.invoke(this.B, new Object[]{Boolean.valueOf(true)});
                    } catch (Exception unused2) {
                        Log.i(str, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    }
                }
            } else {
                this.B.setIsClippedToScreen(true);
            }
            this.B.setOutsideTouchable(!this.n && !this.m);
            this.B.setTouchInterceptor(this.u);
            if (this.k) {
                this.B.setOverlapAnchor(this.f4389j);
            }
            if (VERSION.SDK_INT <= 28) {
                Method method3 = E;
                if (method3 != null) {
                    try {
                        method3.invoke(this.B, new Object[]{this.z});
                    } catch (Exception e2) {
                        Log.e(str, "Could not invoke setEpicenterBounds on PopupWindow", e2);
                    }
                }
            } else {
                this.B.setEpicenterBounds(this.z);
            }
            this.B.showAsDropDown(this.r, this.f4385f, this.f4386g, this.l);
            this.f4382c.setSelection(-1);
            if (!this.A || this.f4382c.isInTouchMode()) {
                f0 f0Var = this.f4382c;
                if (f0Var != null) {
                    f0Var.setListSelectionHidden(true);
                    f0Var.requestLayout();
                }
            }
            if (!this.A) {
                this.x.post(this.w);
            }
        } else if (m.y(this.r)) {
            int i13 = this.f4384e;
            if (i13 == -1) {
                i13 = -1;
            } else if (i13 == -2) {
                i13 = this.r.getWidth();
            }
            int i14 = this.f4383d;
            if (i14 == -1) {
                if (!z4) {
                    i4 = -1;
                }
                if (z4) {
                    this.B.setWidth(this.f4384e == -1 ? -1 : 0);
                    this.B.setHeight(0);
                } else {
                    this.B.setWidth(this.f4384e == -1 ? -1 : 0);
                    this.B.setHeight(-1);
                }
            } else if (i14 != -2) {
                i4 = i14;
            }
            PopupWindow popupWindow = this.B;
            if (this.n || this.m) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.B.update(this.r, this.f4385f, this.f4386g, i13 < 0 ? -1 : i13, i4 < 0 ? -1 : i4);
        }
    }

    public void a(boolean z2) {
        this.A = z2;
        this.B.setFocusable(z2);
    }

    public void a(Drawable drawable) {
        this.B.setBackgroundDrawable(drawable);
    }

    public void a(int i2) {
        this.f4385f = i2;
    }

    public boolean a() {
        return this.B.isShowing();
    }

    public f0 a(Context context, boolean z2) {
        return new f0(context, z2);
    }
}
