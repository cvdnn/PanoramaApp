package d.h.k;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import d.h.k.a.C0040a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ViewCompat */
public class m {

    /* renamed from: a reason: collision with root package name */
    public static final AtomicInteger f4927a = new AtomicInteger(1);

    /* renamed from: b reason: collision with root package name */
    public static WeakHashMap<View, r> f4928b = null;

    /* renamed from: c reason: collision with root package name */
    public static Field f4929c;

    /* renamed from: d reason: collision with root package name */
    public static boolean f4930d = false;

    /* compiled from: ViewCompat */
    public static class a implements OnApplyWindowInsetsListener {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ k f4931a;

        public a(k kVar) {
            this.f4931a = kVar;
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            Object obj = null;
            v a2 = this.f4931a.a(view, windowInsets == null ? null : new v(windowInsets));
            if (a2 != null) {
                obj = a2.f4948a;
            }
            return (WindowInsets) obj;
        }
    }

    /* compiled from: ViewCompat */
    public static abstract class b<T> {

        /* renamed from: a reason: collision with root package name */
        public final int f4932a;

        /* renamed from: b reason: collision with root package name */
        public final Class<T> f4933b;

        /* renamed from: c reason: collision with root package name */
        public final int f4934c;

        public b(int i2, Class<T> cls, int i3) {
            this.f4932a = i2;
            this.f4933b = cls;
            this.f4934c = i3;
        }

        public abstract T a(View view);

        public abstract void a(View view, T t);

        public boolean a(Boolean bool, Boolean bool2) {
            boolean z;
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            if (bool2 == null) {
                z = false;
            } else {
                z = bool2.booleanValue();
            }
            if (booleanValue == z) {
                return true;
            }
            return false;
        }

        public abstract boolean a(T t, T t2);

        public T b(View view) {
            if (VERSION.SDK_INT >= this.f4934c) {
                return a(view);
            }
            T tag = view.getTag(this.f4932a);
            if (this.f4933b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public b(int i2, Class<T> cls, int i3, int i4) {
            this.f4932a = i2;
            this.f4933b = cls;
            this.f4934c = i4;
        }
    }

    /* compiled from: ViewCompat */
    public interface c {
        boolean a(View view, KeyEvent keyEvent);
    }

    /* compiled from: ViewCompat */
    public static class d {

        /* renamed from: d reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f4935d = new ArrayList<>();

        /* renamed from: a reason: collision with root package name */
        public WeakHashMap<View, Boolean> f4936a = null;

        /* renamed from: b reason: collision with root package name */
        public SparseArray<WeakReference<View>> f4937b = null;

        /* renamed from: c reason: collision with root package name */
        public WeakReference<KeyEvent> f4938c = null;

        public static d a(View view) {
            d dVar = (d) view.getTag(d.h.b.tag_unhandled_key_event_manager);
            if (dVar != null) {
                return dVar;
            }
            d dVar2 = new d();
            view.setTag(d.h.b.tag_unhandled_key_event_manager, dVar2);
            return dVar2;
        }

        public final boolean b(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(d.h.b.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((c) arrayList.get(size)).a(view, keyEvent)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final View a(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f4936a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View a2 = a(viewGroup.getChildAt(childCount), keyEvent);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                }
                if (b(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final void a() {
            WeakHashMap<View, Boolean> weakHashMap = this.f4936a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (!f4935d.isEmpty()) {
                synchronized (f4935d) {
                    if (this.f4936a == null) {
                        this.f4936a = new WeakHashMap<>();
                    }
                    for (int size = f4935d.size() - 1; size >= 0; size--) {
                        View view = (View) ((WeakReference) f4935d.get(size)).get();
                        if (view == null) {
                            f4935d.remove(size);
                        } else {
                            this.f4936a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f4936a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        new WeakHashMap();
    }

    public static boolean A(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static boolean B(View view) {
        return view.isPaddingRelative();
    }

    public static boolean C(View view) {
        Boolean bool = (Boolean) new n(d.h.b.tag_screen_reader_focusable, Boolean.class, 28).b(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void D(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void E(View view) {
        view.requestApplyInsets();
    }

    public static void F(View view) {
        view.stopNestedScroll();
    }

    public static v a(View view, v vVar) {
        WindowInsets windowInsets = (WindowInsets) (vVar == null ? null : vVar.f4948a);
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (!onApplyWindowInsets.equals(windowInsets)) {
            windowInsets = new WindowInsets(onApplyWindowInsets);
        }
        if (windowInsets == null) {
            return null;
        }
        return new v(windowInsets);
    }

    public static a b(View view) {
        AccessibilityDelegate c2 = c(view);
        if (c2 == null) {
            return null;
        }
        if (c2 instanceof C0040a) {
            return ((C0040a) c2).f4911a;
        }
        return new a(c2);
    }

    public static AccessibilityDelegate c(View view) {
        if (f4930d) {
            return null;
        }
        if (f4929c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f4929c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f4930d = true;
                return null;
            }
        }
        try {
            Object obj = f4929c.get(view);
            if (obj instanceof AccessibilityDelegate) {
                return (AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f4930d = true;
            return null;
        }
    }

    public static int d(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static void e(View view, int i2) {
        a(i2, view);
        b(view, 0);
    }

    public static void f(View view, int i2) {
        view.setAccessibilityLiveRegion(i2);
    }

    public static void g(View view, int i2) {
        view.setImportantForAccessibility(i2);
    }

    public static float h(View view) {
        return view.getElevation();
    }

    public static boolean i(View view) {
        return view.getFitsSystemWindows();
    }

    public static int j(View view) {
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int k(View view) {
        if (VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    @Deprecated
    public static int l(View view) {
        return view.getLayerType();
    }

    public static int m(View view) {
        return view.getLayoutDirection();
    }

    public static int n(View view) {
        return view.getMinimumHeight();
    }

    public static int o(View view) {
        return view.getMinimumWidth();
    }

    public static int p(View view) {
        return view.getPaddingEnd();
    }

    public static int q(View view) {
        return view.getPaddingStart();
    }

    public static ViewParent r(View view) {
        return view.getParentForAccessibility();
    }

    public static String s(View view) {
        return view.getTransitionName();
    }

    public static int t(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float u(View view) {
        return view.getZ();
    }

    public static boolean v(View view) {
        return view.hasOnClickListeners();
    }

    public static boolean w(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean x(View view) {
        return view.hasTransientState();
    }

    public static boolean y(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean z(View view) {
        return view.isLaidOut();
    }

    public static void d(View view, int i2) {
        view.offsetTopAndBottom(i2);
    }

    public static Rect f(View view) {
        return view.getClipBounds();
    }

    public static Display g(View view) {
        return view.getDisplay();
    }

    public static ColorStateList e(View view) {
        return view.getBackgroundTintList();
    }

    public static void b(View view, boolean z) {
        view.setHasTransientState(z);
    }

    public static boolean b(View view, KeyEvent keyEvent) {
        boolean z = false;
        if (VERSION.SDK_INT >= 28) {
            return false;
        }
        d a2 = d.a(view);
        WeakReference<KeyEvent> weakReference = a2.f4938c;
        if (weakReference == null || weakReference.get() != keyEvent) {
            a2.f4938c = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            if (a2.f4937b == null) {
                a2.f4937b = new SparseArray<>();
            }
            SparseArray<WeakReference<View>> sparseArray = a2.f4937b;
            if (keyEvent.getAction() == 1) {
                int indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode());
                if (indexOfKey >= 0) {
                    weakReference2 = (WeakReference) sparseArray.valueAt(indexOfKey);
                    sparseArray.removeAt(indexOfKey);
                }
            }
            if (weakReference2 == null) {
                weakReference2 = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
            }
            if (weakReference2 != null) {
                View view2 = (View) weakReference2.get();
                if (view2 != null && y(view2)) {
                    a2.b(view2, keyEvent);
                }
                z = true;
            }
        }
        return z;
    }

    @Deprecated
    public static boolean a(View view, int i2) {
        return view.canScrollHorizontally(i2);
    }

    public static void a(View view, d.h.k.w.b.a aVar, CharSequence charSequence, d.h.k.w.d dVar) {
        d.h.k.w.b.a aVar2 = new d.h.k.w.b.a(null, aVar.f4963b, charSequence, dVar, aVar.f4964c);
        a b2 = b(view);
        if (b2 == null) {
            b2 = new a();
        }
        a(view, b2);
        a(aVar2.a(), view);
        ArrayList arrayList = (ArrayList) view.getTag(d.h.b.tag_accessibility_actions);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(d.h.b.tag_accessibility_actions, arrayList);
        }
        arrayList.add(aVar2);
        b(view, 0);
    }

    public static void c(View view, int i2) {
        view.offsetLeftAndRight(i2);
    }

    public static void a(View view, a aVar) {
        AccessibilityDelegate accessibilityDelegate;
        if (aVar == null && (c(view) instanceof C0040a)) {
            aVar = new a();
        }
        if (aVar == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = aVar.f4910b;
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    public static void b(View view, int i2) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = ((CharSequence) new o(d.h.b.tag_accessibility_pane_title, CharSequence.class, 8, 28).b(view)) != null;
            if (view.getAccessibilityLiveRegion() != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i2);
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(view.getParent().getClass().getSimpleName());
                    sb.append(" does not fully implement ViewParent");
                    Log.e("ViewCompat", sb.toString(), e2);
                }
            }
        }
    }

    public static void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void a(View view, Runnable runnable, long j2) {
        view.postOnAnimationDelayed(runnable, j2);
    }

    public static boolean a(View view, int i2, Bundle bundle) {
        return view.performAccessibilityAction(i2, bundle);
    }

    public static void a(int i2, View view) {
        ArrayList arrayList = (ArrayList) view.getTag(d.h.b.tag_accessibility_actions);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(d.h.b.tag_accessibility_actions, arrayList);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (((d.h.k.w.b.a) arrayList.get(i3)).a() == i2) {
                arrayList.remove(i3);
                return;
            }
        }
    }

    @Deprecated
    public static void a(View view, int i2, Paint paint) {
        view.setLayerType(i2, paint);
    }

    public static void a(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static void a(View view, d.h.k.w.b bVar) {
        view.onInitializeAccessibilityNodeInfo(bVar.f4953a);
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        view.setPaddingRelative(i2, i3, i4, i5);
    }

    public static r a(View view) {
        if (f4928b == null) {
            f4928b = new WeakHashMap<>();
        }
        r rVar = (r) f4928b.get(view);
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(view);
        f4928b.put(view, rVar2);
        return rVar2;
    }

    public static void a(View view, float f2) {
        view.setElevation(f2);
    }

    public static void a(View view, String str) {
        view.setTransitionName(str);
    }

    public static void a(View view, k kVar) {
        if (kVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new a(kVar));
        }
    }

    public static void a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void a(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void a(View view, int i2, int i3) {
        view.setScrollIndicators(i2, i3);
    }

    public static int a() {
        return View.generateViewId();
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        boolean z = false;
        if (VERSION.SDK_INT >= 28) {
            return false;
        }
        d a2 = d.a(view);
        if (a2 != null) {
            if (keyEvent.getAction() == 0) {
                a2.a();
            }
            View a3 = a2.a(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (a3 != null && !KeyEvent.isModifierKey(keyCode)) {
                    if (a2.f4937b == null) {
                        a2.f4937b = new SparseArray<>();
                    }
                    a2.f4937b.put(keyCode, new WeakReference(a3));
                }
            }
            if (a3 != null) {
                z = true;
            }
            return z;
        }
        throw null;
    }

    public static void a(View view, boolean z) {
        p pVar = new p(d.h.b.tag_accessibility_heading, Boolean.class, 28);
        Boolean valueOf = Boolean.valueOf(z);
        if (VERSION.SDK_INT >= pVar.f4934c) {
            pVar.a(view, valueOf);
        } else if (pVar.a(pVar.b(view), valueOf)) {
            a b2 = b(view);
            if (b2 == null) {
                b2 = new a();
            }
            a(view, b2);
            view.setTag(pVar.f4932a, valueOf);
            b(view, 0);
        }
    }
}
