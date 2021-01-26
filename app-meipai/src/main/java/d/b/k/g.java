package d.b.k;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import com.arashivision.graphicpath.render.source.ExtraMetadataKey;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.sina.weibo.sdk.utils.ResourceManager;
import d.b.o.a.C0026a;
import d.b.p.c0;
import d.b.p.d1;
import d.b.p.x0;
import d.h.k.m;
import d.h.k.r;
import d.h.k.s;
import d.h.k.t;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/* compiled from: AppCompatDelegateImpl */
public class g extends f implements d.b.o.i.g.a, Factory2 {
    public static final Map<Class<?>, Integer> Z = new d.e.a();
    public static final boolean b0 = false;
    public static final int[] c0 = {16842836};
    public static boolean d0 = true;
    public static final boolean e0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public j[] F;
    public j G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M = -100;
    public int N;
    public boolean O;
    public boolean P;
    public C0023g Q;
    public C0023g R;
    public boolean S;
    public int T;
    public final Runnable U = new b();
    public boolean V;
    public Rect W;
    public Rect X;
    public AppCompatViewInflater Y;

    /* renamed from: c reason: collision with root package name */
    public final Object f3993c;

    /* renamed from: d reason: collision with root package name */
    public final Context f3994d;

    /* renamed from: e reason: collision with root package name */
    public Window f3995e;

    /* renamed from: f reason: collision with root package name */
    public e f3996f;

    /* renamed from: g reason: collision with root package name */
    public final e f3997g;

    /* renamed from: h reason: collision with root package name */
    public a f3998h;

    /* renamed from: i reason: collision with root package name */
    public MenuInflater f3999i;

    /* renamed from: j reason: collision with root package name */
    public CharSequence f4000j;
    public c0 k;
    public c l;
    public k m;
    public d.b.o.a n;
    public ActionBarContextView o;
    public PopupWindow p;
    public Runnable q;
    public r r = null;
    public boolean s = true;
    public boolean t;
    public ViewGroup u;
    public TextView v;
    public View w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* compiled from: AppCompatDelegateImpl */
    public static class a implements UncaughtExceptionHandler {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ UncaughtExceptionHandler f4001a;

        public a(UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f4001a = uncaughtExceptionHandler;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            boolean z = false;
            if (th instanceof NotFoundException) {
                String message = th.getMessage();
                if (message != null && (message.contains(ResourceManager.DRAWABLE) || message.contains("Drawable"))) {
                    z = true;
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(th.getMessage());
                sb.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                NotFoundException notFoundException = new NotFoundException(sb.toString());
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.f4001a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f4001a.uncaughtException(thread, th);
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            g gVar = g.this;
            if ((gVar.T & 1) != 0) {
                gVar.c(0);
            }
            g gVar2 = g.this;
            if ((gVar2.T & 4096) != 0) {
                gVar2.c(108);
            }
            g gVar3 = g.this;
            gVar3.S = false;
            gVar3.T = 0;
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    public final class c implements d.b.o.i.m.a {
        public c() {
        }

        public boolean a(d.b.o.i.g gVar) {
            Callback i2 = g.this.i();
            if (i2 != null) {
                i2.onMenuOpened(108, gVar);
            }
            return true;
        }

        public void a(d.b.o.i.g gVar, boolean z) {
            g.this.b(gVar);
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    public class d implements C0026a {

        /* renamed from: a reason: collision with root package name */
        public C0026a f4004a;

        /* compiled from: AppCompatDelegateImpl */
        public class a extends t {
            public a() {
            }

            public void b(View view) {
                g.this.o.setVisibility(8);
                g gVar = g.this;
                PopupWindow popupWindow = gVar.p;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (gVar.o.getParent() instanceof View) {
                    m.E((View) g.this.o.getParent());
                }
                g.this.o.removeAllViews();
                g.this.r.a((s) null);
                g.this.r = null;
            }
        }

        public d(C0026a aVar) {
            this.f4004a = aVar;
        }

        public boolean a(d.b.o.a aVar, Menu menu) {
            return this.f4004a.a(aVar, menu);
        }

        public boolean b(d.b.o.a aVar, Menu menu) {
            return this.f4004a.b(aVar, menu);
        }

        public boolean a(d.b.o.a aVar, MenuItem menuItem) {
            return this.f4004a.a(aVar, menuItem);
        }

        public void a(d.b.o.a aVar) {
            this.f4004a.a(aVar);
            g gVar = g.this;
            if (gVar.p != null) {
                gVar.f3995e.getDecorView().removeCallbacks(g.this.q);
            }
            g gVar2 = g.this;
            if (gVar2.o != null) {
                gVar2.e();
                g gVar3 = g.this;
                r a2 = m.a(gVar3.o);
                a2.a(0.0f);
                gVar3.r = a2;
                r rVar = g.this.r;
                a aVar2 = new a();
                View view = (View) rVar.f4940a.get();
                if (view != null) {
                    rVar.a(view, aVar2);
                }
            }
            g gVar4 = g.this;
            e eVar = gVar4.f3997g;
            if (eVar != null) {
                eVar.b(gVar4.n);
            }
            g.this.n = null;
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    public class e extends d.b.o.h {
        public e(Callback callback) {
            super(callback);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x01a5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.ActionMode a(android.view.ActionMode.Callback r10) {
            /*
                r9 = this;
                d.b.o.e$a r0 = new d.b.o.e$a
                d.b.k.g r1 = d.b.k.g.this
                android.content.Context r1 = r1.f3994d
                r0.<init>(r1, r10)
                d.b.k.g r10 = d.b.k.g.this
                r1 = 0
                if (r10 == 0) goto L_0x01ba
                d.b.o.a r2 = r10.n
                if (r2 == 0) goto L_0x0015
                r2.a()
            L_0x0015:
                d.b.k.g$d r2 = new d.b.k.g$d
                r2.<init>(r0)
                r10.j()
                d.b.k.a r3 = r10.f3998h
                if (r3 == 0) goto L_0x0030
                d.b.o.a r3 = r3.a(r2)
                r10.n = r3
                if (r3 == 0) goto L_0x0030
                d.b.k.e r4 = r10.f3997g
                if (r4 == 0) goto L_0x0030
                r4.a(r3)
            L_0x0030:
                d.b.o.a r3 = r10.n
                if (r3 != 0) goto L_0x01b0
                r10.e()
                d.b.o.a r3 = r10.n
                if (r3 == 0) goto L_0x003e
                r3.a()
            L_0x003e:
                d.b.k.e r3 = r10.f3997g
                if (r3 == 0) goto L_0x004b
                boolean r4 = r10.L
                if (r4 != 0) goto L_0x004b
                d.b.o.a r3 = r3.a(r2)     // Catch:{ AbstractMethodError -> 0x004b }
                goto L_0x004c
            L_0x004b:
                r3 = r1
            L_0x004c:
                if (r3 == 0) goto L_0x0052
                r10.n = r3
                goto L_0x01a1
            L_0x0052:
                androidx.appcompat.widget.ActionBarContextView r3 = r10.o
                r4 = 0
                r5 = 1
                if (r3 != 0) goto L_0x010a
                boolean r3 = r10.C
                if (r3 == 0) goto L_0x00de
                android.util.TypedValue r3 = new android.util.TypedValue
                r3.<init>()
                android.content.Context r6 = r10.f3994d
                android.content.res.Resources$Theme r6 = r6.getTheme()
                int r7 = d.b.a.actionBarTheme
                r6.resolveAttribute(r7, r3, r5)
                int r7 = r3.resourceId
                if (r7 == 0) goto L_0x0091
                android.content.Context r7 = r10.f3994d
                android.content.res.Resources r7 = r7.getResources()
                android.content.res.Resources$Theme r7 = r7.newTheme()
                r7.setTo(r6)
                int r6 = r3.resourceId
                r7.applyStyle(r6, r5)
                d.b.o.c r6 = new d.b.o.c
                android.content.Context r8 = r10.f3994d
                r6.<init>(r8, r4)
                android.content.res.Resources$Theme r8 = r6.getTheme()
                r8.setTo(r7)
                goto L_0x0093
            L_0x0091:
                android.content.Context r6 = r10.f3994d
            L_0x0093:
                androidx.appcompat.widget.ActionBarContextView r7 = new androidx.appcompat.widget.ActionBarContextView
                r7.<init>(r6)
                r10.o = r7
                android.widget.PopupWindow r7 = new android.widget.PopupWindow
                int r8 = d.b.a.actionModePopupWindowStyle
                r7.<init>(r6, r1, r8)
                r10.p = r7
                r8 = 2
                r7.setWindowLayoutType(r8)
                android.widget.PopupWindow r7 = r10.p
                androidx.appcompat.widget.ActionBarContextView r8 = r10.o
                r7.setContentView(r8)
                android.widget.PopupWindow r7 = r10.p
                r8 = -1
                r7.setWidth(r8)
                android.content.res.Resources$Theme r7 = r6.getTheme()
                int r8 = d.b.a.actionBarSize
                r7.resolveAttribute(r8, r3, r5)
                int r3 = r3.data
                android.content.res.Resources r6 = r6.getResources()
                android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
                int r3 = android.util.TypedValue.complexToDimensionPixelSize(r3, r6)
                androidx.appcompat.widget.ActionBarContextView r6 = r10.o
                r6.setContentHeight(r3)
                android.widget.PopupWindow r3 = r10.p
                r6 = -2
                r3.setHeight(r6)
                d.b.k.k r3 = new d.b.k.k
                r3.<init>(r10)
                r10.q = r3
                goto L_0x010a
            L_0x00de:
                android.view.ViewGroup r3 = r10.u
                int r6 = d.b.f.action_mode_bar_stub
                android.view.View r3 = r3.findViewById(r6)
                androidx.appcompat.widget.ViewStubCompat r3 = (androidx.appcompat.widget.ViewStubCompat) r3
                if (r3 == 0) goto L_0x010a
                r10.j()
                d.b.k.a r6 = r10.f3998h
                if (r6 == 0) goto L_0x00f6
                android.content.Context r6 = r6.c()
                goto L_0x00f7
            L_0x00f6:
                r6 = r1
            L_0x00f7:
                if (r6 != 0) goto L_0x00fb
                android.content.Context r6 = r10.f3994d
            L_0x00fb:
                android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
                r3.setLayoutInflater(r6)
                android.view.View r3 = r3.a()
                androidx.appcompat.widget.ActionBarContextView r3 = (androidx.appcompat.widget.ActionBarContextView) r3
                r10.o = r3
            L_0x010a:
                androidx.appcompat.widget.ActionBarContextView r3 = r10.o
                if (r3 == 0) goto L_0x01a1
                r10.e()
                androidx.appcompat.widget.ActionBarContextView r3 = r10.o
                r3.b()
                d.b.o.d r3 = new d.b.o.d
                androidx.appcompat.widget.ActionBarContextView r6 = r10.o
                android.content.Context r6 = r6.getContext()
                androidx.appcompat.widget.ActionBarContextView r7 = r10.o
                android.widget.PopupWindow r8 = r10.p
                if (r8 != 0) goto L_0x0125
                goto L_0x0126
            L_0x0125:
                r5 = r4
            L_0x0126:
                r3.<init>(r6, r7, r2, r5)
                d.b.o.i.g r5 = r3.f4105h
                d.b.o.a$a r2 = r2.f4004a
                boolean r2 = r2.a(r3, r5)
                if (r2 == 0) goto L_0x019f
                r3.g()
                androidx.appcompat.widget.ActionBarContextView r2 = r10.o
                r2.a(r3)
                r10.n = r3
                boolean r2 = r10.k()
                r3 = 1065353216(0x3f800000, float:1.0)
                if (r2 == 0) goto L_0x0169
                androidx.appcompat.widget.ActionBarContextView r2 = r10.o
                r4 = 0
                r2.setAlpha(r4)
                androidx.appcompat.widget.ActionBarContextView r2 = r10.o
                d.h.k.r r2 = d.h.k.m.a(r2)
                r2.a(r3)
                r10.r = r2
                d.b.k.l r3 = new d.b.k.l
                r3.<init>(r10)
                java.lang.ref.WeakReference<android.view.View> r4 = r2.f4940a
                java.lang.Object r4 = r4.get()
                android.view.View r4 = (android.view.View) r4
                if (r4 == 0) goto L_0x018f
                r2.a(r4, r3)
                goto L_0x018f
            L_0x0169:
                androidx.appcompat.widget.ActionBarContextView r2 = r10.o
                r2.setAlpha(r3)
                androidx.appcompat.widget.ActionBarContextView r2 = r10.o
                r2.setVisibility(r4)
                androidx.appcompat.widget.ActionBarContextView r2 = r10.o
                r3 = 32
                r2.sendAccessibilityEvent(r3)
                androidx.appcompat.widget.ActionBarContextView r2 = r10.o
                android.view.ViewParent r2 = r2.getParent()
                boolean r2 = r2 instanceof android.view.View
                if (r2 == 0) goto L_0x018f
                androidx.appcompat.widget.ActionBarContextView r2 = r10.o
                android.view.ViewParent r2 = r2.getParent()
                android.view.View r2 = (android.view.View) r2
                r2.requestApplyInsets()
            L_0x018f:
                android.widget.PopupWindow r2 = r10.p
                if (r2 == 0) goto L_0x01a1
                android.view.Window r2 = r10.f3995e
                android.view.View r2 = r2.getDecorView()
                java.lang.Runnable r3 = r10.q
                r2.post(r3)
                goto L_0x01a1
            L_0x019f:
                r10.n = r1
            L_0x01a1:
                d.b.o.a r2 = r10.n
                if (r2 == 0) goto L_0x01ac
                d.b.k.e r3 = r10.f3997g
                if (r3 == 0) goto L_0x01ac
                r3.a(r2)
            L_0x01ac:
                d.b.o.a r2 = r10.n
                r10.n = r2
            L_0x01b0:
                d.b.o.a r10 = r10.n
                if (r10 == 0) goto L_0x01b9
                android.view.ActionMode r10 = r0.b(r10)
                return r10
            L_0x01b9:
                return r1
            L_0x01ba:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: d.b.k.g.e.a(android.view.ActionMode$Callback):android.view.ActionMode");
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.a(keyEvent) || this.f4140a.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (r6 != false) goto L_0x001d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean dispatchKeyShortcutEvent(android.view.KeyEvent r6) {
            /*
                r5 = this;
                android.view.Window$Callback r0 = r5.f4140a
                boolean r0 = r0.dispatchKeyShortcutEvent(r6)
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L_0x004f
                d.b.k.g r0 = d.b.k.g.this
                int r3 = r6.getKeyCode()
                r0.j()
                d.b.k.a r4 = r0.f3998h
                if (r4 == 0) goto L_0x001f
                boolean r3 = r4.a(r3, r6)
                if (r3 == 0) goto L_0x001f
            L_0x001d:
                r6 = r2
                goto L_0x004d
            L_0x001f:
                d.b.k.g$j r3 = r0.G
                if (r3 == 0) goto L_0x0034
                int r4 = r6.getKeyCode()
                boolean r3 = r0.a(r3, r4, r6, r2)
                if (r3 == 0) goto L_0x0034
                d.b.k.g$j r6 = r0.G
                if (r6 == 0) goto L_0x001d
                r6.n = r2
                goto L_0x001d
            L_0x0034:
                d.b.k.g$j r3 = r0.G
                if (r3 != 0) goto L_0x004c
                d.b.k.g$j r3 = r0.d(r1)
                r0.b(r3, r6)
                int r4 = r6.getKeyCode()
                boolean r6 = r0.a(r3, r4, r6, r2)
                r3.m = r1
                if (r6 == 0) goto L_0x004c
                goto L_0x001d
            L_0x004c:
                r6 = r1
            L_0x004d:
                if (r6 == 0) goto L_0x0050
            L_0x004f:
                r1 = r2
            L_0x0050:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: d.b.k.g.e.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof d.b.o.i.g)) {
                return this.f4140a.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i2, Menu menu) {
            this.f4140a.onMenuOpened(i2, menu);
            g gVar = g.this;
            if (gVar != null) {
                if (i2 == 108) {
                    gVar.j();
                    a aVar = gVar.f3998h;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                }
                return true;
            }
            throw null;
        }

        public void onPanelClosed(int i2, Menu menu) {
            this.f4140a.onPanelClosed(i2, menu);
            g gVar = g.this;
            if (gVar == null) {
                throw null;
            } else if (i2 == 108) {
                gVar.j();
                a aVar = gVar.f3998h;
                if (aVar != null) {
                    aVar.a(false);
                }
            } else if (i2 == 0) {
                j d2 = gVar.d(i2);
                if (d2.o) {
                    gVar.a(d2, false);
                }
            }
        }

        public boolean onPreparePanel(int i2, View view, Menu menu) {
            d.b.o.i.g gVar = menu instanceof d.b.o.i.g ? (d.b.o.i.g) menu : null;
            if (i2 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.y = true;
            }
            boolean onPreparePanel = this.f4140a.onPreparePanel(i2, view, menu);
            if (gVar != null) {
                gVar.y = false;
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            j d2 = g.this.d(0);
            if (d2 != null) {
                d.b.o.i.g gVar = d2.f4025j;
                if (gVar != null) {
                    this.f4140a.onProvideKeyboardShortcuts(list, gVar, i2);
                    return;
                }
            }
            this.f4140a.onProvideKeyboardShortcuts(list, menu, i2);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (!g.this.s || i2 != 0) {
                return this.f4140a.onWindowStartingActionMode(callback, i2);
            }
            return a(callback);
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    public class f extends C0023g {

        /* renamed from: c reason: collision with root package name */
        public final PowerManager f4008c;

        public f(Context context) {
            super();
            this.f4008c = (PowerManager) context.getSystemService("power");
        }

        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            return this.f4008c.isPowerSaveMode() ? 2 : 1;
        }

        public void d() {
            g.this.d();
        }
    }

    /* renamed from: d.b.k.g$g reason: collision with other inner class name */
    /* compiled from: AppCompatDelegateImpl */
    public abstract class C0023g {

        /* renamed from: a reason: collision with root package name */
        public BroadcastReceiver f4010a;

        /* renamed from: d.b.k.g$g$a */
        /* compiled from: AppCompatDelegateImpl */
        public class a extends BroadcastReceiver {
            public a() {
            }

            public void onReceive(Context context, Intent intent) {
                C0023g.this.d();
            }
        }

        public C0023g() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f4010a;
            if (broadcastReceiver != null) {
                try {
                    g.this.f3994d.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f4010a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b2 = b();
            if (b2 != null && b2.countActions() != 0) {
                if (this.f4010a == null) {
                    this.f4010a = new a();
                }
                g.this.f3994d.registerReceiver(this.f4010a, b2);
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    public class h extends C0023g {

        /* renamed from: c reason: collision with root package name */
        public final n f4013c;

        public h(n nVar) {
            super();
            this.f4013c = nVar;
        }

        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            boolean z;
            long j2;
            n nVar = this.f4013c;
            d.b.k.n.a aVar = nVar.f4040c;
            if (aVar.f4042b > System.currentTimeMillis()) {
                z = aVar.f4041a;
            } else {
                Location location = null;
                Location a2 = a.a.a.a.b.a.a(nVar.f4038a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? nVar.a("network") : null;
                if (a.a.a.a.b.a.a(nVar.f4038a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    location = nVar.a(ExtraMetadataKey.kGps);
                }
                if (location == null || a2 == null ? location != null : location.getTime() > a2.getTime()) {
                    a2 = location;
                }
                if (a2 != null) {
                    d.b.k.n.a aVar2 = nVar.f4040c;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (m.f4033d == null) {
                        m.f4033d = new m();
                    }
                    m mVar = m.f4033d;
                    mVar.a(currentTimeMillis - LogBuilder.MAX_INTERVAL, a2.getLatitude(), a2.getLongitude());
                    m mVar2 = mVar;
                    mVar.a(currentTimeMillis, a2.getLatitude(), a2.getLongitude());
                    boolean z2 = mVar2.f4036c == 1;
                    long j3 = mVar2.f4035b;
                    long j4 = mVar2.f4034a;
                    mVar2.a(currentTimeMillis + LogBuilder.MAX_INTERVAL, a2.getLatitude(), a2.getLongitude());
                    long j5 = mVar2.f4035b;
                    if (j3 == -1 || j4 == -1) {
                        j2 = currentTimeMillis + 43200000;
                    } else {
                        long j6 = currentTimeMillis > j4 ? j5 + 0 : currentTimeMillis > j3 ? j4 + 0 : j3 + 0;
                        j2 = j6 + 60000;
                    }
                    aVar2.f4041a = z2;
                    aVar2.f4042b = j2;
                    z = aVar.f4041a;
                } else {
                    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                    int i2 = Calendar.getInstance().get(11);
                    z = i2 < 6 || i2 >= 22;
                }
            }
            if (z) {
                return 2;
            }
            return 1;
        }

        public void d() {
            g.this.d();
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    public class i extends ContentFrameLayout {
        public i(Context context) {
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    g gVar = g.this;
                    gVar.a(gVar.d(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(d.b.l.a.a.b(getContext(), i2));
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    public static final class j {

        /* renamed from: a reason: collision with root package name */
        public int f4016a;

        /* renamed from: b reason: collision with root package name */
        public int f4017b;

        /* renamed from: c reason: collision with root package name */
        public int f4018c;

        /* renamed from: d reason: collision with root package name */
        public int f4019d;

        /* renamed from: e reason: collision with root package name */
        public int f4020e;

        /* renamed from: f reason: collision with root package name */
        public int f4021f;

        /* renamed from: g reason: collision with root package name */
        public ViewGroup f4022g;

        /* renamed from: h reason: collision with root package name */
        public View f4023h;

        /* renamed from: i reason: collision with root package name */
        public View f4024i;

        /* renamed from: j reason: collision with root package name */
        public d.b.o.i.g f4025j;
        public d.b.o.i.e k;
        public Context l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q = false;
        public boolean r;
        public Bundle s;

        public j(int i2) {
            this.f4016a = i2;
        }

        public void a(d.b.o.i.g gVar) {
            d.b.o.i.g gVar2 = this.f4025j;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.a((d.b.o.i.m) this.k);
                }
                this.f4025j = gVar;
                if (gVar != null) {
                    d.b.o.i.e eVar = this.k;
                    if (eVar != null) {
                        gVar.a((d.b.o.i.m) eVar, gVar.f4198a);
                    }
                }
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl */
    public final class k implements d.b.o.i.m.a {
        public k() {
        }

        public void a(d.b.o.i.g gVar, boolean z) {
            d.b.o.i.g c2 = gVar.c();
            boolean z2 = c2 != gVar;
            g gVar2 = g.this;
            if (z2) {
                gVar = c2;
            }
            j a2 = gVar2.a((Menu) gVar);
            if (a2 == null) {
                return;
            }
            if (z2) {
                g.this.a(a2.f4016a, a2, c2);
                g.this.a(a2, true);
                return;
            }
            g.this.a(a2, z);
        }

        public boolean a(d.b.o.i.g gVar) {
            if (gVar == null) {
                g gVar2 = g.this;
                if (gVar2.z) {
                    Callback i2 = gVar2.i();
                    if (i2 != null && !g.this.L) {
                        i2.onMenuOpened(108, gVar);
                    }
                }
            }
            return true;
        }
    }

    static {
        int i2 = VERSION.SDK_INT;
        boolean z2 = false;
        if (i2 <= 25) {
            z2 = true;
        }
        e0 = z2;
        if (b0 && !d0) {
            Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    public g(Context context, Window window, e eVar, Object obj) {
        d dVar = null;
        this.f3994d = context;
        this.f3997g = eVar;
        this.f3993c = obj;
        if (this.M == -100 && (obj instanceof Dialog)) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof d)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        }
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        dVar = (d) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (dVar != null) {
                this.M = ((g) dVar.d0()).M;
            }
        }
        if (this.M == -100) {
            Integer num = (Integer) Z.get(this.f3993c.getClass());
            if (num != null) {
                this.M = num.intValue();
                Z.remove(this.f3993c.getClass());
            }
        }
        if (window != null) {
            a(window);
        }
        d.b.p.j.b();
    }

    public void a(Bundle bundle) {
        this.I = true;
        a(false);
        g();
        Object obj = this.f3993c;
        if (obj instanceof Activity) {
            String str = null;
            try {
                Activity activity = (Activity) obj;
                str = a.a.a.a.b.a.b((Context) activity, activity.getComponentName());
            } catch (NameNotFoundException e2) {
                throw new IllegalArgumentException(e2);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a aVar = this.f3998h;
                if (aVar == null) {
                    this.V = true;
                } else {
                    aVar.b(true);
                }
            }
        }
        this.J = true;
    }

    public void b() {
        j();
        a aVar = this.f3998h;
        e(0);
    }

    public void c() {
        this.K = false;
        f.b((f) this);
        j();
        a aVar = this.f3998h;
        if (aVar != null) {
            aVar.c(false);
        }
        if (this.f3993c instanceof Dialog) {
            C0023g gVar = this.Q;
            if (gVar != null) {
                gVar.a();
            }
            C0023g gVar2 = this.R;
            if (gVar2 != null) {
                gVar2.a();
            }
        }
    }

    public j d(int i2) {
        j[] jVarArr = this.F;
        if (jVarArr == null || jVarArr.length <= i2) {
            j[] jVarArr2 = new j[(i2 + 1)];
            if (jVarArr != null) {
                System.arraycopy(jVarArr, 0, jVarArr2, 0, jVarArr.length);
            }
            this.F = jVarArr2;
            jVarArr = jVarArr2;
        }
        j jVar = jVarArr[i2];
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(i2);
        jVarArr[i2] = jVar2;
        return jVar2;
    }

    public void e() {
        r rVar = this.r;
        if (rVar != null) {
            rVar.a();
        }
    }

    public final void f() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.t) {
            TypedArray obtainStyledAttributes = this.f3994d.obtainStyledAttributes(d.b.j.AppCompatTheme);
            if (obtainStyledAttributes.hasValue(d.b.j.AppCompatTheme_windowActionBar)) {
                if (obtainStyledAttributes.getBoolean(d.b.j.AppCompatTheme_windowNoTitle, false)) {
                    a(1);
                } else if (obtainStyledAttributes.getBoolean(d.b.j.AppCompatTheme_windowActionBar, false)) {
                    a(108);
                }
                if (obtainStyledAttributes.getBoolean(d.b.j.AppCompatTheme_windowActionBarOverlay, false)) {
                    a(109);
                }
                if (obtainStyledAttributes.getBoolean(d.b.j.AppCompatTheme_windowActionModeOverlay, false)) {
                    a(10);
                }
                this.C = obtainStyledAttributes.getBoolean(d.b.j.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                g();
                this.f3995e.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.f3994d);
                if (this.D) {
                    if (this.B) {
                        viewGroup = (ViewGroup) from.inflate(d.b.g.abc_screen_simple_overlay_action_mode, null);
                    } else {
                        viewGroup = (ViewGroup) from.inflate(d.b.g.abc_screen_simple, null);
                    }
                    m.a((View) viewGroup, (d.h.k.k) new h(this));
                } else if (this.C) {
                    viewGroup = (ViewGroup) from.inflate(d.b.g.abc_dialog_title_material, null);
                    this.A = false;
                    this.z = false;
                } else if (this.z) {
                    TypedValue typedValue = new TypedValue();
                    this.f3994d.getTheme().resolveAttribute(d.b.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new d.b.o.c(this.f3994d, typedValue.resourceId);
                    } else {
                        context = this.f3994d;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.b.g.abc_screen_toolbar, null);
                    c0 c0Var = (c0) viewGroup.findViewById(d.b.f.decor_content_parent);
                    this.k = c0Var;
                    c0Var.setWindowCallback(i());
                    if (this.A) {
                        this.k.a(109);
                    }
                    if (this.x) {
                        this.k.a(2);
                    }
                    if (this.y) {
                        this.k.a(5);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    if (this.k == null) {
                        this.v = (TextView) viewGroup.findViewById(d.b.f.title);
                    }
                    d1.b(viewGroup);
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(d.b.f.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f3995e.findViewById(16908290);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(16908290);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.f3995e.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new j(this));
                    this.u = viewGroup;
                    Object obj = this.f3993c;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.f4000j;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        c0 c0Var2 = this.k;
                        if (c0Var2 != null) {
                            c0Var2.setWindowTitle(charSequence);
                        } else {
                            a aVar = this.f3998h;
                            if (aVar != null) {
                                aVar.a(charSequence);
                            } else {
                                TextView textView = this.v;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.u.findViewById(16908290);
                    View decorView = this.f3995e.getDecorView();
                    contentFrameLayout2.f770g.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    if (m.z(contentFrameLayout2)) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = this.f3994d.obtainStyledAttributes(d.b.j.AppCompatTheme);
                    obtainStyledAttributes2.getValue(d.b.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(d.b.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                    if (obtainStyledAttributes2.hasValue(d.b.j.AppCompatTheme_windowFixedWidthMajor)) {
                        obtainStyledAttributes2.getValue(d.b.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(d.b.j.AppCompatTheme_windowFixedWidthMinor)) {
                        obtainStyledAttributes2.getValue(d.b.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
                    }
                    if (obtainStyledAttributes2.hasValue(d.b.j.AppCompatTheme_windowFixedHeightMajor)) {
                        obtainStyledAttributes2.getValue(d.b.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(d.b.j.AppCompatTheme_windowFixedHeightMinor)) {
                        obtainStyledAttributes2.getValue(d.b.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.t = true;
                    j d2 = d(0);
                    if (this.L) {
                        return;
                    }
                    if (d2 == null || d2.f4025j == null) {
                        e(108);
                        return;
                    }
                    return;
                }
                StringBuilder a2 = e.a.a.a.a.a("AppCompat does not support the current theme features: { windowActionBar: ");
                a2.append(this.z);
                a2.append(", windowActionBarOverlay: ");
                a2.append(this.A);
                a2.append(", android:windowIsFloating: ");
                a2.append(this.C);
                a2.append(", windowActionModeOverlay: ");
                a2.append(this.B);
                a2.append(", windowNoTitle: ");
                a2.append(this.D);
                a2.append(" }");
                throw new IllegalArgumentException(a2.toString());
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void g() {
        if (this.f3995e == null) {
            Object obj = this.f3993c;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.f3995e == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final C0023g h() {
        if (this.Q == null) {
            Context context = this.f3994d;
            if (n.f4037d == null) {
                Context applicationContext = context.getApplicationContext();
                n.f4037d = new n(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.Q = new h(n.f4037d);
        }
        return this.Q;
    }

    public final Callback i() {
        return this.f3995e.getCallback();
    }

    public final void j() {
        f();
        if (this.z && this.f3998h == null) {
            Object obj = this.f3993c;
            if (obj instanceof Activity) {
                this.f3998h = new o((Activity) this.f3993c, this.A);
            } else if (obj instanceof Dialog) {
                this.f3998h = new o((Dialog) this.f3993c);
            }
            a aVar = this.f3998h;
            if (aVar != null) {
                aVar.b(this.V);
            }
        }
    }

    public final boolean k() {
        if (this.t) {
            ViewGroup viewGroup = this.u;
            if (viewGroup != null && m.z(viewGroup)) {
                return true;
            }
        }
        return false;
    }

    public final void l() {
        if (this.t) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0072, code lost:
        if (((org.xmlpull.v1.XmlPullParser) r14).getDepth() > 1) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.View r11, java.lang.String r12, android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r10 = this;
            androidx.appcompat.app.AppCompatViewInflater r0 = r10.Y
            r1 = 0
            if (r0 != 0) goto L_0x0062
            android.content.Context r0 = r10.f3994d
            int[] r2 = d.b.j.AppCompatTheme
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r2)
            int r2 = d.b.j.AppCompatTheme_viewInflaterClass
            java.lang.String r2 = r0.getString(r2)
            if (r2 == 0) goto L_0x005b
            java.lang.Class<androidx.appcompat.app.AppCompatViewInflater> r0 = androidx.appcompat.app.AppCompatViewInflater.class
            java.lang.String r0 = r0.getName()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0022
            goto L_0x005b
        L_0x0022:
            java.lang.Class r0 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0037 }
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x0037 }
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r3)     // Catch:{ all -> 0x0037 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0037 }
            java.lang.Object r0 = r0.newInstance(r3)     // Catch:{ all -> 0x0037 }
            androidx.appcompat.app.AppCompatViewInflater r0 = (androidx.appcompat.app.AppCompatViewInflater) r0     // Catch:{ all -> 0x0037 }
            r10.Y = r0     // Catch:{ all -> 0x0037 }
            goto L_0x0062
        L_0x0037:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to instantiate custom view inflater "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = ". Falling back to default."
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "AppCompatDelegate"
            android.util.Log.i(r3, r2, r0)
            androidx.appcompat.app.AppCompatViewInflater r0 = new androidx.appcompat.app.AppCompatViewInflater
            r0.<init>()
            r10.Y = r0
            goto L_0x0062
        L_0x005b:
            androidx.appcompat.app.AppCompatViewInflater r0 = new androidx.appcompat.app.AppCompatViewInflater
            r0.<init>()
            r10.Y = r0
        L_0x0062:
            boolean r0 = b0
            if (r0 == 0) goto L_0x009a
            boolean r0 = r14 instanceof org.xmlpull.v1.XmlPullParser
            r2 = 1
            if (r0 == 0) goto L_0x0075
            r0 = r14
            org.xmlpull.v1.XmlPullParser r0 = (org.xmlpull.v1.XmlPullParser) r0
            int r0 = r0.getDepth()
            if (r0 <= r2) goto L_0x009a
            goto L_0x0083
        L_0x0075:
            r0 = r11
            android.view.ViewParent r0 = (android.view.ViewParent) r0
            if (r0 != 0) goto L_0x007b
            goto L_0x009a
        L_0x007b:
            android.view.Window r3 = r10.f3995e
            android.view.View r3 = r3.getDecorView()
        L_0x0081:
            if (r0 != 0) goto L_0x0085
        L_0x0083:
            r6 = r2
            goto L_0x009b
        L_0x0085:
            if (r0 == r3) goto L_0x009a
            boolean r4 = r0 instanceof android.view.View
            if (r4 == 0) goto L_0x009a
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            boolean r4 = d.h.k.m.y(r4)
            if (r4 == 0) goto L_0x0095
            goto L_0x009a
        L_0x0095:
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0081
        L_0x009a:
            r6 = r1
        L_0x009b:
            androidx.appcompat.app.AppCompatViewInflater r1 = r10.Y
            boolean r7 = b0
            r8 = 1
            d.b.p.c1.a()
            r9 = 0
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            android.view.View r0 = r1.createView(r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.k.g.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final void e(int i2) {
        this.T = (1 << i2) | this.T;
        if (!this.S) {
            m.a(this.f3995e.getDecorView(), this.U);
            this.S = true;
        }
    }

    public void b(int i2) {
        f();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f3994d).inflate(i2, viewGroup);
        this.f3996f.f4140a.onContentChanged();
    }

    public boolean d() {
        return a(true);
    }

    public void b(View view, LayoutParams layoutParams) {
        f();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f3996f.f4140a.onContentChanged();
    }

    public void c(int i2) {
        j d2 = d(i2);
        if (d2.f4025j != null) {
            Bundle bundle = new Bundle();
            d2.f4025j.b(bundle);
            if (bundle.size() > 0) {
                d2.s = bundle;
            }
            d2.f4025j.j();
            d2.f4025j.clear();
        }
        d2.r = true;
        d2.q = true;
        if ((i2 == 108 || i2 == 0) && this.k != null) {
            j d3 = d(0);
            if (d3 != null) {
                d3.m = false;
                b(d3, (KeyEvent) null);
            }
        }
    }

    public void a(View view) {
        f();
        ViewGroup viewGroup = (ViewGroup) this.u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f3996f.f4140a.onContentChanged();
    }

    public final boolean b(j jVar, KeyEvent keyEvent) {
        Theme theme;
        if (this.L) {
            return false;
        }
        if (jVar.m) {
            return true;
        }
        j jVar2 = this.G;
        if (!(jVar2 == null || jVar2 == jVar)) {
            a(jVar2, false);
        }
        Callback i2 = i();
        if (i2 != null) {
            jVar.f4024i = i2.onCreatePanelView(jVar.f4016a);
        }
        int i3 = jVar.f4016a;
        boolean z2 = i3 == 0 || i3 == 108;
        if (z2) {
            c0 c0Var = this.k;
            if (c0Var != null) {
                c0Var.b();
            }
        }
        if (jVar.f4024i == null) {
            if (jVar.f4025j == null || jVar.r) {
                if (jVar.f4025j == null) {
                    Context context = this.f3994d;
                    int i4 = jVar.f4016a;
                    if ((i4 == 0 || i4 == 108) && this.k != null) {
                        TypedValue typedValue = new TypedValue();
                        Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(d.b.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(d.b.a.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(d.b.a.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            d.b.o.c cVar = new d.b.o.c(context, 0);
                            cVar.getTheme().setTo(theme);
                            context = cVar;
                        }
                    }
                    d.b.o.i.g gVar = new d.b.o.i.g(context);
                    gVar.f4202e = this;
                    jVar.a(gVar);
                    if (jVar.f4025j == null) {
                        return false;
                    }
                }
                if (z2 && this.k != null) {
                    if (this.l == null) {
                        this.l = new c();
                    }
                    this.k.a(jVar.f4025j, this.l);
                }
                jVar.f4025j.j();
                if (!i2.onCreatePanelMenu(jVar.f4016a, jVar.f4025j)) {
                    jVar.a(null);
                    if (z2) {
                        c0 c0Var2 = this.k;
                        if (c0Var2 != null) {
                            c0Var2.a(null, this.l);
                        }
                    }
                    return false;
                }
                jVar.r = false;
            }
            jVar.f4025j.j();
            Bundle bundle = jVar.s;
            if (bundle != null) {
                jVar.f4025j.a(bundle);
                jVar.s = null;
            }
            if (!i2.onPreparePanel(0, jVar.f4024i, jVar.f4025j)) {
                if (z2) {
                    c0 c0Var3 = this.k;
                    if (c0Var3 != null) {
                        c0Var3.a(null, this.l);
                    }
                }
                jVar.f4025j.i();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            jVar.p = z3;
            jVar.f4025j.setQwertyMode(z3);
            jVar.f4025j.i();
        }
        jVar.m = true;
        jVar.n = false;
        this.G = jVar;
        return true;
    }

    public void a(View view, LayoutParams layoutParams) {
        f();
        ((ViewGroup) this.u.findViewById(16908290)).addView(view, layoutParams);
        this.f3996f.f4140a.onContentChanged();
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public final void a(Window window) {
        String str = "AppCompat has already installed itself into the Window";
        if (this.f3995e == null) {
            Callback callback = window.getCallback();
            if (!(callback instanceof e)) {
                e eVar = new e(callback);
                this.f3996f = eVar;
                window.setCallback(eVar);
                x0 a2 = x0.a(this.f3994d, (AttributeSet) null, c0);
                Drawable c2 = a2.c(0);
                if (c2 != null) {
                    window.setBackgroundDrawable(c2);
                }
                a2.f4485b.recycle();
                this.f3995e = window;
                return;
            }
            throw new IllegalStateException(str);
        }
        throw new IllegalStateException(str);
    }

    public final void a(CharSequence charSequence) {
        this.f4000j = charSequence;
        c0 c0Var = this.k;
        if (c0Var != null) {
            c0Var.setWindowTitle(charSequence);
            return;
        }
        a aVar = this.f3998h;
        if (aVar != null) {
            aVar.a(charSequence);
            return;
        }
        TextView textView = this.v;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean a(d.b.o.i.g gVar, MenuItem menuItem) {
        Callback i2 = i();
        if (i2 != null && !this.L) {
            j a2 = a((Menu) gVar.c());
            if (a2 != null) {
                return i2.onMenuItemSelected(a2.f4016a, menuItem);
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0117, code lost:
        if (r7 == false) goto L_0x0062;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.KeyEvent r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f3993c
            boolean r1 = r0 instanceof d.h.k.c.a
            r2 = 1
            if (r1 != 0) goto L_0x000b
            boolean r0 = r0 instanceof androidx.appcompat.app.AppCompatDialog
            if (r0 == 0) goto L_0x001a
        L_0x000b:
            android.view.Window r0 = r6.f3995e
            android.view.View r0 = r0.getDecorView()
            if (r0 == 0) goto L_0x001a
            boolean r0 = d.h.k.m.b(r0, r7)
            if (r0 == 0) goto L_0x001a
            return r2
        L_0x001a:
            int r0 = r7.getKeyCode()
            r1 = 82
            if (r0 != r1) goto L_0x002d
            d.b.k.g$e r0 = r6.f3996f
            android.view.Window$Callback r0 = r0.f4140a
            boolean r0 = r0.dispatchKeyEvent(r7)
            if (r0 == 0) goto L_0x002d
            return r2
        L_0x002d:
            int r0 = r7.getKeyCode()
            int r3 = r7.getAction()
            r4 = 0
            if (r3 != 0) goto L_0x003a
            r3 = r2
            goto L_0x003b
        L_0x003a:
            r3 = r4
        L_0x003b:
            r5 = 4
            if (r3 == 0) goto L_0x0065
            if (r0 == r5) goto L_0x0056
            if (r0 == r1) goto L_0x0043
            goto L_0x0062
        L_0x0043:
            int r0 = r7.getRepeatCount()
            if (r0 != 0) goto L_0x0119
            d.b.k.g$j r0 = r6.d(r4)
            boolean r1 = r0.o
            if (r1 != 0) goto L_0x0119
            r6.b(r0, r7)
            goto L_0x0119
        L_0x0056:
            int r7 = r7.getFlags()
            r7 = r7 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r2 = r4
        L_0x0060:
            r6.H = r2
        L_0x0062:
            r2 = r4
            goto L_0x0119
        L_0x0065:
            if (r0 == r5) goto L_0x00eb
            if (r0 == r1) goto L_0x006a
            goto L_0x0062
        L_0x006a:
            d.b.o.a r0 = r6.n
            if (r0 == 0) goto L_0x0070
            goto L_0x0119
        L_0x0070:
            d.b.k.g$j r0 = r6.d(r4)
            d.b.p.c0 r1 = r6.k
            if (r1 == 0) goto L_0x00aa
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x00aa
            android.content.Context r1 = r6.f3994d
            android.view.ViewConfiguration r1 = android.view.ViewConfiguration.get(r1)
            boolean r1 = r1.hasPermanentMenuKey()
            if (r1 != 0) goto L_0x00aa
            d.b.p.c0 r1 = r6.k
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x00a3
            boolean r1 = r6.L
            if (r1 != 0) goto L_0x00ca
            boolean r7 = r6.b(r0, r7)
            if (r7 == 0) goto L_0x00ca
            d.b.p.c0 r7 = r6.k
            boolean r7 = r7.f()
            goto L_0x00d1
        L_0x00a3:
            d.b.p.c0 r7 = r6.k
            boolean r7 = r7.e()
            goto L_0x00d1
        L_0x00aa:
            boolean r1 = r0.o
            if (r1 != 0) goto L_0x00cc
            boolean r1 = r0.n
            if (r1 == 0) goto L_0x00b3
            goto L_0x00cc
        L_0x00b3:
            boolean r1 = r0.m
            if (r1 == 0) goto L_0x00ca
            boolean r1 = r0.r
            if (r1 == 0) goto L_0x00c2
            r0.m = r4
            boolean r1 = r6.b(r0, r7)
            goto L_0x00c3
        L_0x00c2:
            r1 = r2
        L_0x00c3:
            if (r1 == 0) goto L_0x00ca
            r6.a(r0, r7)
            r7 = r2
            goto L_0x00d1
        L_0x00ca:
            r7 = r4
            goto L_0x00d1
        L_0x00cc:
            boolean r7 = r0.o
            r6.a(r0, r2)
        L_0x00d1:
            if (r7 == 0) goto L_0x0119
            android.content.Context r7 = r6.f3994d
            java.lang.String r0 = "audio"
            java.lang.Object r7 = r7.getSystemService(r0)
            android.media.AudioManager r7 = (android.media.AudioManager) r7
            if (r7 == 0) goto L_0x00e3
            r7.playSoundEffect(r4)
            goto L_0x0119
        L_0x00e3:
            java.lang.String r7 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r7, r0)
            goto L_0x0119
        L_0x00eb:
            boolean r7 = r6.H
            r6.H = r4
            d.b.k.g$j r0 = r6.d(r4)
            if (r0 == 0) goto L_0x00ff
            boolean r1 = r0.o
            if (r1 == 0) goto L_0x00ff
            if (r7 != 0) goto L_0x0119
            r6.a(r0, r2)
            goto L_0x0119
        L_0x00ff:
            d.b.o.a r7 = r6.n
            if (r7 == 0) goto L_0x0107
            r7.a()
            goto L_0x0114
        L_0x0107:
            r6.j()
            d.b.k.a r7 = r6.f3998h
            if (r7 == 0) goto L_0x0116
            boolean r7 = r7.a()
            if (r7 == 0) goto L_0x0116
        L_0x0114:
            r7 = r2
            goto L_0x0117
        L_0x0116:
            r7 = r4
        L_0x0117:
            if (r7 == 0) goto L_0x0062
        L_0x0119:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.k.g.a(android.view.KeyEvent):boolean");
    }

    public void b(d.b.o.i.g gVar) {
        if (!this.E) {
            this.E = true;
            this.k.g();
            Callback i2 = i();
            if (i2 != null && !this.L) {
                i2.onPanelClosed(108, gVar);
            }
            this.E = false;
        }
    }

    public void a() {
        LayoutInflater from = LayoutInflater.from(this.f3994d);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else if (!(from.getFactory2() instanceof g)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015c, code lost:
        if (r3 != null) goto L_0x015e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(d.b.k.g.j r14, android.view.KeyEvent r15) {
        /*
            r13 = this;
            boolean r0 = r14.o
            if (r0 != 0) goto L_0x01da
            boolean r0 = r13.L
            if (r0 == 0) goto L_0x000a
            goto L_0x01da
        L_0x000a:
            int r0 = r14.f4016a
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0027
            android.content.Context r0 = r13.f3994d
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            r3 = 4
            if (r0 != r3) goto L_0x0023
            r0 = r2
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            if (r0 == 0) goto L_0x0027
            return
        L_0x0027:
            android.view.Window$Callback r0 = r13.i()
            if (r0 == 0) goto L_0x003b
            int r3 = r14.f4016a
            d.b.o.i.g r4 = r14.f4025j
            boolean r0 = r0.onMenuOpened(r3, r4)
            if (r0 != 0) goto L_0x003b
            r13.a(r14, r2)
            return
        L_0x003b:
            android.content.Context r0 = r13.f3994d
            java.lang.String r3 = "window"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            if (r0 != 0) goto L_0x0048
            return
        L_0x0048:
            boolean r15 = r13.b(r14, r15)
            if (r15 != 0) goto L_0x004f
            return
        L_0x004f:
            android.view.ViewGroup r15 = r14.f4022g
            r3 = -1
            r4 = -2
            if (r15 == 0) goto L_0x006b
            boolean r15 = r14.q
            if (r15 == 0) goto L_0x005a
            goto L_0x006b
        L_0x005a:
            android.view.View r15 = r14.f4024i
            if (r15 == 0) goto L_0x01b8
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            if (r15 == 0) goto L_0x01b8
            int r15 = r15.width
            if (r15 != r3) goto L_0x01b8
            r6 = r3
            goto L_0x01b9
        L_0x006b:
            android.view.ViewGroup r15 = r14.f4022g
            r3 = 0
            if (r15 != 0) goto L_0x00e8
            r13.j()
            d.b.k.a r15 = r13.f3998h
            if (r15 == 0) goto L_0x007c
            android.content.Context r15 = r15.c()
            goto L_0x007d
        L_0x007c:
            r15 = r3
        L_0x007d:
            if (r15 != 0) goto L_0x0081
            android.content.Context r15 = r13.f3994d
        L_0x0081:
            android.util.TypedValue r5 = new android.util.TypedValue
            r5.<init>()
            android.content.res.Resources r6 = r15.getResources()
            android.content.res.Resources$Theme r6 = r6.newTheme()
            android.content.res.Resources$Theme r7 = r15.getTheme()
            r6.setTo(r7)
            int r7 = d.b.a.actionBarPopupTheme
            r6.resolveAttribute(r7, r5, r2)
            int r7 = r5.resourceId
            if (r7 == 0) goto L_0x00a1
            r6.applyStyle(r7, r2)
        L_0x00a1:
            int r7 = d.b.a.panelMenuListTheme
            r6.resolveAttribute(r7, r5, r2)
            int r5 = r5.resourceId
            if (r5 == 0) goto L_0x00ae
            r6.applyStyle(r5, r2)
            goto L_0x00b3
        L_0x00ae:
            int r5 = d.b.i.Theme_AppCompat_CompactMenu
            r6.applyStyle(r5, r2)
        L_0x00b3:
            d.b.o.c r5 = new d.b.o.c
            r5.<init>(r15, r1)
            android.content.res.Resources$Theme r15 = r5.getTheme()
            r15.setTo(r6)
            r14.l = r5
            int[] r15 = d.b.j.AppCompatTheme
            android.content.res.TypedArray r15 = r5.obtainStyledAttributes(r15)
            int r5 = d.b.j.AppCompatTheme_panelBackground
            int r5 = r15.getResourceId(r5, r1)
            r14.f4017b = r5
            int r5 = d.b.j.AppCompatTheme_android_windowAnimationStyle
            int r5 = r15.getResourceId(r5, r1)
            r14.f4021f = r5
            r15.recycle()
            d.b.k.g$i r15 = new d.b.k.g$i
            android.content.Context r5 = r14.l
            r15.<init>(r5)
            r14.f4022g = r15
            r15 = 81
            r14.f4018c = r15
            goto L_0x00f7
        L_0x00e8:
            boolean r5 = r14.q
            if (r5 == 0) goto L_0x00f7
            int r15 = r15.getChildCount()
            if (r15 <= 0) goto L_0x00f7
            android.view.ViewGroup r15 = r14.f4022g
            r15.removeAllViews()
        L_0x00f7:
            android.view.View r15 = r14.f4024i
            if (r15 == 0) goto L_0x00fe
            r14.f4023h = r15
            goto L_0x015e
        L_0x00fe:
            d.b.o.i.g r15 = r14.f4025j
            if (r15 != 0) goto L_0x0103
            goto L_0x0160
        L_0x0103:
            d.b.k.g$k r15 = r13.m
            if (r15 != 0) goto L_0x010e
            d.b.k.g$k r15 = new d.b.k.g$k
            r15.<init>()
            r13.m = r15
        L_0x010e:
            d.b.k.g$k r15 = r13.m
            d.b.o.i.g r5 = r14.f4025j
            if (r5 != 0) goto L_0x0115
            goto L_0x015a
        L_0x0115:
            d.b.o.i.e r3 = r14.k
            if (r3 != 0) goto L_0x012d
            d.b.o.i.e r3 = new d.b.o.i.e
            android.content.Context r5 = r14.l
            int r6 = d.b.g.abc_list_menu_item_layout
            r3.<init>(r5, r6)
            r14.k = r3
            r3.f4188h = r15
            d.b.o.i.g r15 = r14.f4025j
            android.content.Context r5 = r15.f4198a
            r15.a(r3, r5)
        L_0x012d:
            d.b.o.i.e r15 = r14.k
            android.view.ViewGroup r3 = r14.f4022g
            androidx.appcompat.view.menu.ExpandedMenuView r5 = r15.f4184d
            if (r5 != 0) goto L_0x0158
            android.view.LayoutInflater r5 = r15.f4182b
            int r6 = d.b.g.abc_expanded_menu_layout
            android.view.View r3 = r5.inflate(r6, r3, r1)
            androidx.appcompat.view.menu.ExpandedMenuView r3 = (androidx.appcompat.view.menu.ExpandedMenuView) r3
            r15.f4184d = r3
            d.b.o.i.e$a r3 = r15.f4189i
            if (r3 != 0) goto L_0x014c
            d.b.o.i.e$a r3 = new d.b.o.i.e$a
            r3.<init>()
            r15.f4189i = r3
        L_0x014c:
            androidx.appcompat.view.menu.ExpandedMenuView r3 = r15.f4184d
            d.b.o.i.e$a r5 = r15.f4189i
            r3.setAdapter(r5)
            androidx.appcompat.view.menu.ExpandedMenuView r3 = r15.f4184d
            r3.setOnItemClickListener(r15)
        L_0x0158:
            androidx.appcompat.view.menu.ExpandedMenuView r3 = r15.f4184d
        L_0x015a:
            r14.f4023h = r3
            if (r3 == 0) goto L_0x0160
        L_0x015e:
            r15 = r2
            goto L_0x0161
        L_0x0160:
            r15 = r1
        L_0x0161:
            if (r15 == 0) goto L_0x01da
            android.view.View r15 = r14.f4023h
            if (r15 != 0) goto L_0x0168
            goto L_0x017b
        L_0x0168:
            android.view.View r15 = r14.f4024i
            if (r15 == 0) goto L_0x016d
            goto L_0x0179
        L_0x016d:
            d.b.o.i.e r15 = r14.k
            android.widget.ListAdapter r15 = r15.a()
            int r15 = r15.getCount()
            if (r15 <= 0) goto L_0x017b
        L_0x0179:
            r15 = r2
            goto L_0x017c
        L_0x017b:
            r15 = r1
        L_0x017c:
            if (r15 != 0) goto L_0x017f
            goto L_0x01da
        L_0x017f:
            android.view.View r15 = r14.f4023h
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            if (r15 != 0) goto L_0x018c
            android.view.ViewGroup$LayoutParams r15 = new android.view.ViewGroup$LayoutParams
            r15.<init>(r4, r4)
        L_0x018c:
            int r3 = r14.f4017b
            android.view.ViewGroup r5 = r14.f4022g
            r5.setBackgroundResource(r3)
            android.view.View r3 = r14.f4023h
            android.view.ViewParent r3 = r3.getParent()
            boolean r5 = r3 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x01a4
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            android.view.View r5 = r14.f4023h
            r3.removeView(r5)
        L_0x01a4:
            android.view.ViewGroup r3 = r14.f4022g
            android.view.View r5 = r14.f4023h
            r3.addView(r5, r15)
            android.view.View r15 = r14.f4023h
            boolean r15 = r15.hasFocus()
            if (r15 != 0) goto L_0x01b8
            android.view.View r15 = r14.f4023h
            r15.requestFocus()
        L_0x01b8:
            r6 = r4
        L_0x01b9:
            r14.n = r1
            android.view.WindowManager$LayoutParams r15 = new android.view.WindowManager$LayoutParams
            r7 = -2
            int r8 = r14.f4019d
            int r9 = r14.f4020e
            r10 = 1002(0x3ea, float:1.404E-42)
            r11 = 8519680(0x820000, float:1.1938615E-38)
            r12 = -3
            r5 = r15
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            int r1 = r14.f4018c
            r15.gravity = r1
            int r1 = r14.f4021f
            r15.windowAnimations = r1
            android.view.ViewGroup r1 = r14.f4022g
            r0.addView(r1, r15)
            r14.o = r2
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.k.g.a(d.b.k.g$j, android.view.KeyEvent):void");
    }

    public int f(int i2) {
        boolean z2;
        boolean z3;
        ActionBarContextView actionBarContextView = this.o;
        int i3 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof MarginLayoutParams)) {
            z2 = false;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.o.getLayoutParams();
            boolean z4 = true;
            if (this.o.isShown()) {
                if (this.W == null) {
                    this.W = new Rect();
                    this.X = new Rect();
                }
                Rect rect = this.W;
                Rect rect2 = this.X;
                rect.set(0, i2, 0, 0);
                d1.a(this.u, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.w;
                    if (view == null) {
                        View view2 = new View(this.f3994d);
                        this.w = view2;
                        view2.setBackgroundColor(this.f3994d.getResources().getColor(d.b.c.abc_input_method_navigation_guard));
                        this.u.addView(this.w, -1, new LayoutParams(-1, i2));
                    } else {
                        LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.w.setLayoutParams(layoutParams);
                        }
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.w == null) {
                    z4 = false;
                }
                if (!this.B && z4) {
                    i2 = 0;
                }
                boolean z5 = z4;
                z4 = z3;
                z2 = z5;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z4 = false;
            }
            if (z4) {
                this.o.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.w;
        if (view3 != null) {
            if (!z2) {
                i3 = 8;
            }
            view3.setVisibility(i3);
        }
        return i2;
    }

    public void a(d.b.o.i.g gVar) {
        c0 c0Var = this.k;
        if (c0Var == null || !c0Var.c() || (ViewConfiguration.get(this.f3994d).hasPermanentMenuKey() && !this.k.d())) {
            j d2 = d(0);
            d2.q = true;
            a(d2, false);
            a(d2, (KeyEvent) null);
            return;
        }
        Callback i2 = i();
        if (this.k.a()) {
            this.k.e();
            if (!this.L) {
                i2.onPanelClosed(108, d(0).f4025j);
            }
        } else if (i2 != null && !this.L) {
            if (this.S && (1 & this.T) != 0) {
                this.f3995e.getDecorView().removeCallbacks(this.U);
                this.U.run();
            }
            j d3 = d(0);
            d.b.o.i.g gVar2 = d3.f4025j;
            if (gVar2 != null && !d3.r && i2.onPreparePanel(0, d3.f4024i, gVar2)) {
                i2.onMenuOpened(108, d3.f4025j);
                this.k.f();
            }
        }
    }

    public void a(j jVar, boolean z2) {
        if (z2 && jVar.f4016a == 0) {
            c0 c0Var = this.k;
            if (c0Var != null && c0Var.a()) {
                b(jVar.f4025j);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f3994d.getSystemService("window");
        if (windowManager != null && jVar.o) {
            ViewGroup viewGroup = jVar.f4022g;
            if (viewGroup != null) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    a(jVar.f4016a, jVar, null);
                }
            }
        }
        jVar.m = false;
        jVar.n = false;
        jVar.o = false;
        jVar.f4023h = null;
        jVar.q = true;
        if (this.G == jVar) {
            this.G = null;
        }
    }

    public void a(int i2, j jVar, Menu menu) {
        if (menu == null) {
            if (jVar == null && i2 >= 0) {
                j[] jVarArr = this.F;
                if (i2 < jVarArr.length) {
                    jVar = jVarArr[i2];
                }
            }
            if (jVar != null) {
                menu = jVar.f4025j;
            }
        }
        if ((jVar == null || jVar.o) && !this.L) {
            this.f3996f.f4140a.onPanelClosed(i2, menu);
        }
    }

    public j a(Menu menu) {
        j[] jVarArr = this.F;
        int length = jVarArr != null ? jVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            j jVar = jVarArr[i2];
            if (jVar != null && jVar.f4025j == menu) {
                return jVar;
            }
        }
        return null;
    }

    public final boolean a(j jVar, int i2, KeyEvent keyEvent, int i3) {
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if (jVar.m || b(jVar, keyEvent)) {
            d.b.o.i.g gVar = jVar.f4025j;
            if (gVar != null) {
                z2 = gVar.performShortcut(i2, keyEvent, i3);
            }
        }
        if (z2 && (i3 & 1) == 0 && this.k == null) {
            a(jVar, true);
        }
        return z2;
    }

    public boolean a(int i2) {
        String str = "AppCompatDelegate";
        if (i2 == 8) {
            Log.i(str, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i2 = 108;
        } else if (i2 == 9) {
            Log.i(str, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i2 = 109;
        }
        if (this.D && i2 == 108) {
            return false;
        }
        if (this.z && i2 == 1) {
            this.z = false;
        }
        if (i2 == 1) {
            l();
            this.D = true;
            return true;
        } else if (i2 == 2) {
            l();
            this.x = true;
            return true;
        } else if (i2 == 5) {
            l();
            this.y = true;
            return true;
        } else if (i2 == 10) {
            l();
            this.B = true;
            return true;
        } else if (i2 == 108) {
            l();
            this.z = true;
            return true;
        } else if (i2 != 109) {
            return this.f3995e.requestFeature(i2);
        } else {
            l();
            this.A = true;
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(boolean r12) {
        /*
            r11 = this;
            boolean r0 = r11.L
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r11.M
            r2 = -100
            if (r0 == r2) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r0 = r2
        L_0x000e:
            r3 = -1
            r4 = 3
            r5 = 2
            r6 = 1
            if (r0 == r2) goto L_0x0055
            if (r0 == r3) goto L_0x0054
            if (r0 == 0) goto L_0x003a
            if (r0 == r6) goto L_0x0054
            if (r0 == r5) goto L_0x0054
            if (r0 != r4) goto L_0x0032
            d.b.k.g$g r2 = r11.R
            if (r2 != 0) goto L_0x002b
            d.b.k.g$f r2 = new d.b.k.g$f
            android.content.Context r3 = r11.f3994d
            r2.<init>(r3)
            r11.R = r2
        L_0x002b:
            d.b.k.g$g r2 = r11.R
            int r3 = r2.c()
            goto L_0x0055
        L_0x0032:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate."
            r12.<init>(r0)
            throw r12
        L_0x003a:
            android.content.Context r2 = r11.f3994d
            java.lang.Class<android.app.UiModeManager> r7 = android.app.UiModeManager.class
            java.lang.Object r2 = r2.getSystemService(r7)
            android.app.UiModeManager r2 = (android.app.UiModeManager) r2
            int r2 = r2.getNightMode()
            if (r2 != 0) goto L_0x004b
            goto L_0x0055
        L_0x004b:
            d.b.k.g$g r2 = r11.h()
            int r3 = r2.c()
            goto L_0x0055
        L_0x0054:
            r3 = r0
        L_0x0055:
            android.content.Context r2 = r11.f3994d
            android.content.Context r2 = r2.getApplicationContext()
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.uiMode
            r2 = r2 & 48
            if (r3 == r6) goto L_0x0070
            if (r3 == r5) goto L_0x006d
            r3 = r2
            goto L_0x0072
        L_0x006d:
            r3 = 32
            goto L_0x0072
        L_0x0070:
            r3 = 16
        L_0x0072:
            boolean r5 = r11.P
            java.lang.String r7 = "AppCompatDelegate"
            if (r5 != 0) goto L_0x00af
            java.lang.Object r5 = r11.f3993c
            boolean r5 = r5 instanceof android.app.Activity
            if (r5 == 0) goto L_0x00af
            android.content.Context r5 = r11.f3994d
            android.content.pm.PackageManager r5 = r5.getPackageManager()
            if (r5 != 0) goto L_0x0088
            r5 = r1
            goto L_0x00b3
        L_0x0088:
            android.content.ComponentName r8 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x00a7 }
            android.content.Context r9 = r11.f3994d     // Catch:{ NameNotFoundException -> 0x00a7 }
            java.lang.Object r10 = r11.f3993c     // Catch:{ NameNotFoundException -> 0x00a7 }
            java.lang.Class r10 = r10.getClass()     // Catch:{ NameNotFoundException -> 0x00a7 }
            r8.<init>(r9, r10)     // Catch:{ NameNotFoundException -> 0x00a7 }
            android.content.pm.ActivityInfo r5 = r5.getActivityInfo(r8, r1)     // Catch:{ NameNotFoundException -> 0x00a7 }
            if (r5 == 0) goto L_0x00a3
            int r5 = r5.configChanges     // Catch:{ NameNotFoundException -> 0x00a7 }
            r5 = r5 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x00a3
            r5 = r6
            goto L_0x00a4
        L_0x00a3:
            r5 = r1
        L_0x00a4:
            r11.O = r5     // Catch:{ NameNotFoundException -> 0x00a7 }
            goto L_0x00af
        L_0x00a7:
            r5 = move-exception
            java.lang.String r8 = "Exception while getting ActivityInfo"
            android.util.Log.d(r7, r8, r5)
            r11.O = r1
        L_0x00af:
            r11.P = r6
            boolean r5 = r11.O
        L_0x00b3:
            boolean r8 = e0
            if (r8 != 0) goto L_0x00b9
            if (r3 == r2) goto L_0x00e0
        L_0x00b9:
            if (r5 != 0) goto L_0x00e0
            boolean r2 = r11.I
            if (r2 != 0) goto L_0x00e0
            java.lang.Object r2 = r11.f3993c
            boolean r2 = r2 instanceof android.view.ContextThemeWrapper
            if (r2 == 0) goto L_0x00e0
            android.content.res.Configuration r2 = new android.content.res.Configuration
            r2.<init>()
            int r8 = r2.uiMode
            r8 = r8 & -49
            r8 = r8 | r3
            r2.uiMode = r8
            java.lang.Object r8 = r11.f3993c     // Catch:{ IllegalStateException -> 0x00da }
            android.view.ContextThemeWrapper r8 = (android.view.ContextThemeWrapper) r8     // Catch:{ IllegalStateException -> 0x00da }
            r8.applyOverrideConfiguration(r2)     // Catch:{ IllegalStateException -> 0x00da }
            r1 = r6
            goto L_0x00e0
        L_0x00da:
            r2 = move-exception
            java.lang.String r8 = "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()"
            android.util.Log.e(r7, r8, r2)
        L_0x00e0:
            android.content.Context r2 = r11.f3994d
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.uiMode
            r2 = r2 & 48
            if (r1 != 0) goto L_0x0106
            if (r2 == r3) goto L_0x0106
            if (r12 == 0) goto L_0x0106
            if (r5 != 0) goto L_0x0106
            boolean r12 = r11.I
            if (r12 == 0) goto L_0x0106
            java.lang.Object r12 = r11.f3993c
            boolean r7 = r12 instanceof android.app.Activity
            if (r7 == 0) goto L_0x0106
            android.app.Activity r12 = (android.app.Activity) r12
            d.h.d.a.b(r12)
            r1 = r6
        L_0x0106:
            r12 = 0
            if (r1 != 0) goto L_0x020a
            if (r2 == r3) goto L_0x020a
            android.content.Context r1 = r11.f3994d
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.Configuration r2 = new android.content.res.Configuration
            android.content.res.Configuration r7 = r1.getConfiguration()
            r2.<init>(r7)
            android.content.res.Configuration r7 = r1.getConfiguration()
            int r7 = r7.uiMode
            r7 = r7 & -49
            r3 = r3 | r7
            r2.uiMode = r3
            r1.updateConfiguration(r2, r12)
            int r3 = android.os.Build.VERSION.SDK_INT
            r7 = 26
            if (r3 >= r7) goto L_0x01c9
            r7 = 28
            if (r3 < r7) goto L_0x0134
            goto L_0x01c9
        L_0x0134:
            r7 = 24
            java.lang.String r8 = "mDrawableCache"
            java.lang.String r9 = "ResourcesFlusher"
            if (r3 < r7) goto L_0x019b
            boolean r3 = a.a.a.a.b.a.f399h
            if (r3 != 0) goto L_0x0156
            java.lang.Class<android.content.res.Resources> r3 = android.content.res.Resources.class
            java.lang.String r7 = "mResourcesImpl"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r7)     // Catch:{ NoSuchFieldException -> 0x014e }
            a.a.a.a.b.a.f398g = r3     // Catch:{ NoSuchFieldException -> 0x014e }
            r3.setAccessible(r6)     // Catch:{ NoSuchFieldException -> 0x014e }
            goto L_0x0154
        L_0x014e:
            r3 = move-exception
            java.lang.String r7 = "Could not retrieve Resources#mResourcesImpl field"
            android.util.Log.e(r9, r7, r3)
        L_0x0154:
            a.a.a.a.b.a.f399h = r6
        L_0x0156:
            java.lang.reflect.Field r3 = a.a.a.a.b.a.f398g
            if (r3 != 0) goto L_0x015c
            goto L_0x01c9
        L_0x015c:
            java.lang.Object r1 = r3.get(r1)     // Catch:{ IllegalAccessException -> 0x0161 }
            goto L_0x0168
        L_0x0161:
            r1 = move-exception
            java.lang.String r3 = "Could not retrieve value from Resources#mResourcesImpl"
            android.util.Log.e(r9, r3, r1)
            r1 = r12
        L_0x0168:
            if (r1 != 0) goto L_0x016b
            goto L_0x01c9
        L_0x016b:
            boolean r3 = a.a.a.a.b.a.f393b
            if (r3 != 0) goto L_0x0185
            java.lang.Class r3 = r1.getClass()     // Catch:{ NoSuchFieldException -> 0x017d }
            java.lang.reflect.Field r3 = r3.getDeclaredField(r8)     // Catch:{ NoSuchFieldException -> 0x017d }
            a.a.a.a.b.a.f392a = r3     // Catch:{ NoSuchFieldException -> 0x017d }
            r3.setAccessible(r6)     // Catch:{ NoSuchFieldException -> 0x017d }
            goto L_0x0183
        L_0x017d:
            r3 = move-exception
            java.lang.String r7 = "Could not retrieve ResourcesImpl#mDrawableCache field"
            android.util.Log.e(r9, r7, r3)
        L_0x0183:
            a.a.a.a.b.a.f393b = r6
        L_0x0185:
            java.lang.reflect.Field r3 = a.a.a.a.b.a.f392a
            if (r3 == 0) goto L_0x0194
            java.lang.Object r1 = r3.get(r1)     // Catch:{ IllegalAccessException -> 0x018e }
            goto L_0x0195
        L_0x018e:
            r1 = move-exception
            java.lang.String r3 = "Could not retrieve value from ResourcesImpl#mDrawableCache"
            android.util.Log.e(r9, r3, r1)
        L_0x0194:
            r1 = r12
        L_0x0195:
            if (r1 == 0) goto L_0x01c9
            a.a.a.a.b.a.b(r1)
            goto L_0x01c9
        L_0x019b:
            boolean r3 = a.a.a.a.b.a.f393b
            if (r3 != 0) goto L_0x01b3
            java.lang.Class<android.content.res.Resources> r3 = android.content.res.Resources.class
            java.lang.reflect.Field r3 = r3.getDeclaredField(r8)     // Catch:{ NoSuchFieldException -> 0x01ab }
            a.a.a.a.b.a.f392a = r3     // Catch:{ NoSuchFieldException -> 0x01ab }
            r3.setAccessible(r6)     // Catch:{ NoSuchFieldException -> 0x01ab }
            goto L_0x01b1
        L_0x01ab:
            r3 = move-exception
            java.lang.String r7 = "Could not retrieve Resources#mDrawableCache field"
            android.util.Log.e(r9, r7, r3)
        L_0x01b1:
            a.a.a.a.b.a.f393b = r6
        L_0x01b3:
            java.lang.reflect.Field r3 = a.a.a.a.b.a.f392a
            if (r3 == 0) goto L_0x01c2
            java.lang.Object r1 = r3.get(r1)     // Catch:{ IllegalAccessException -> 0x01bc }
            goto L_0x01c3
        L_0x01bc:
            r1 = move-exception
            java.lang.String r3 = "Could not retrieve value from Resources#mDrawableCache"
            android.util.Log.e(r9, r3, r1)
        L_0x01c2:
            r1 = r12
        L_0x01c3:
            if (r1 != 0) goto L_0x01c6
            goto L_0x01c9
        L_0x01c6:
            a.a.a.a.b.a.b(r1)
        L_0x01c9:
            int r1 = r11.N
            if (r1 == 0) goto L_0x01dd
            android.content.Context r3 = r11.f3994d
            r3.setTheme(r1)
            android.content.Context r1 = r11.f3994d
            android.content.res.Resources$Theme r1 = r1.getTheme()
            int r3 = r11.N
            r1.applyStyle(r3, r6)
        L_0x01dd:
            if (r5 == 0) goto L_0x020b
            java.lang.Object r1 = r11.f3993c
            boolean r3 = r1 instanceof android.app.Activity
            if (r3 == 0) goto L_0x020b
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r3 = r1 instanceof d.p.h
            if (r3 == 0) goto L_0x0202
            r3 = r1
            d.p.h r3 = (d.p.h) r3
            d.p.e r3 = r3.getLifecycle()
            d.p.i r3 = (d.p.i) r3
            d.p.e$b r3 = r3.f5281b
            d.p.e$b r5 = d.p.e.b.STARTED
            boolean r3 = r3.a(r5)
            if (r3 == 0) goto L_0x020b
            r1.onConfigurationChanged(r2)
            goto L_0x020b
        L_0x0202:
            boolean r3 = r11.K
            if (r3 == 0) goto L_0x020b
            r1.onConfigurationChanged(r2)
            goto L_0x020b
        L_0x020a:
            r6 = r1
        L_0x020b:
            if (r6 == 0) goto L_0x0219
            java.lang.Object r1 = r11.f3993c
            boolean r2 = r1 instanceof d.b.k.d
            if (r2 == 0) goto L_0x0219
            d.b.k.d r1 = (d.b.k.d) r1
            if (r1 == 0) goto L_0x0218
            goto L_0x0219
        L_0x0218:
            throw r12
        L_0x0219:
            if (r0 != 0) goto L_0x0223
            d.b.k.g$g r12 = r11.h()
            r12.e()
            goto L_0x022a
        L_0x0223:
            d.b.k.g$g r12 = r11.Q
            if (r12 == 0) goto L_0x022a
            r12.a()
        L_0x022a:
            if (r0 != r4) goto L_0x023f
            d.b.k.g$g r12 = r11.R
            if (r12 != 0) goto L_0x0239
            d.b.k.g$f r12 = new d.b.k.g$f
            android.content.Context r0 = r11.f3994d
            r12.<init>(r0)
            r11.R = r12
        L_0x0239:
            d.b.k.g$g r12 = r11.R
            r12.e()
            goto L_0x0246
        L_0x023f:
            d.b.k.g$g r12 = r11.R
            if (r12 == 0) goto L_0x0246
            r12.a()
        L_0x0246:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.k.g.a(boolean):boolean");
    }
}
