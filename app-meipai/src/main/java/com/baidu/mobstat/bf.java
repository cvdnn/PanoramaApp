package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class bf {

    /* renamed from: a reason: collision with root package name */
    public static volatile int f1698a;
    public static final bf k = new bf();

    /* renamed from: b reason: collision with root package name */
    public WeakReference<Activity> f1699b;

    /* renamed from: c reason: collision with root package name */
    public int f1700c;

    /* renamed from: d reason: collision with root package name */
    public boolean f1701d;

    /* renamed from: e reason: collision with root package name */
    public JSONObject f1702e;

    /* renamed from: f reason: collision with root package name */
    public boolean f1703f;

    /* renamed from: g reason: collision with root package name */
    public final Handler f1704g = new Handler(Looper.getMainLooper());

    /* renamed from: h reason: collision with root package name */
    public final Handler f1705h;

    /* renamed from: i reason: collision with root package name */
    public a f1706i;

    /* renamed from: j reason: collision with root package name */
    public be f1707j = new be();

    public static class a implements OnGlobalLayoutListener, Runnable {

        /* renamed from: a reason: collision with root package name */
        public volatile boolean f1708a;

        /* renamed from: b reason: collision with root package name */
        public boolean f1709b;

        /* renamed from: c reason: collision with root package name */
        public final WeakReference<View> f1710c;

        /* renamed from: d reason: collision with root package name */
        public final bk f1711d;

        /* renamed from: e reason: collision with root package name */
        public final Handler f1712e;

        /* renamed from: f reason: collision with root package name */
        public final Handler f1713f;

        /* renamed from: g reason: collision with root package name */
        public JSONObject f1714g;

        /* renamed from: h reason: collision with root package name */
        public WeakReference<Activity> f1715h;

        /* renamed from: i reason: collision with root package name */
        public boolean f1716i;

        /* renamed from: j reason: collision with root package name */
        public boolean f1717j;
        public boolean k;
        public Runnable l = null;

        public a(Activity activity, View view, bk bkVar, Handler handler, Handler handler2, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
            this.f1715h = new WeakReference<>(activity);
            this.f1714g = jSONObject;
            this.f1711d = bkVar;
            this.f1710c = new WeakReference<>(view);
            this.f1712e = handler;
            this.f1713f = handler2;
            this.f1709b = true;
            this.f1708a = false;
            this.f1716i = z;
            this.f1717j = z2;
            this.k = z3;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        @SuppressLint({"NewApi"})
        private void b() {
            if (this.f1709b) {
                View view = (View) this.f1710c.get();
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
                a(this.f1711d, this.f1713f);
            }
            this.f1709b = false;
        }

        public void onGlobalLayout() {
            run();
        }

        public void run() {
            if (this.f1709b) {
                if (((View) this.f1710c.get()) == null || this.f1708a) {
                    b();
                    return;
                }
                String str = "onGlobalLayout";
                if (bd.c().b() && this.k) {
                    bd.c().a(str);
                }
                if (bh.c().b()) {
                    bh.c().a(str);
                }
                if (af.b()) {
                    if (az.c()) {
                        Activity activity = (Activity) this.f1715h.get();
                        if (activity != null) {
                            bf.b(activity, this.f1716i, this.k);
                            a(this.f1715h, this.f1714g, this.f1711d, this.f1713f, this.f1717j);
                        }
                    } else {
                        String str2 = "no touch, skip onGlobalLayout";
                        if (bd.c().b() && this.k) {
                            bd.c().a(str2);
                        }
                        if (bh.c().b()) {
                            bh.c().a(str2);
                        }
                    }
                }
                this.f1712e.removeCallbacks(this);
            }
        }

        public void a() {
            if (!this.f1708a) {
                this.f1708a = true;
                this.f1712e.post(this);
            }
        }

        private void a(WeakReference<Activity> weakReference, JSONObject jSONObject, bk bkVar, Handler handler, boolean z) {
            if (bkVar != null && handler != null) {
                final WeakReference<Activity> weakReference2 = weakReference;
                final boolean z2 = z;
                final bk bkVar2 = bkVar;
                final JSONObject jSONObject2 = jSONObject;
                AnonymousClass1 r0 = new Runnable() {
                    public void run() {
                        if (!az.c()) {
                            String str = "no touch, skip doViewVisit";
                            if (bd.c().b() && a.this.k) {
                                bd.c().a(str);
                            }
                            if (bh.c().b()) {
                                bh.c().a(str);
                            }
                            return;
                        }
                        if (bf.c() >= 3) {
                            az.a(false);
                        }
                        Activity activity = (Activity) weakReference2.get();
                        if (activity != null) {
                            ar.c(activity, z2);
                            bkVar2.a(activity, jSONObject2, z2);
                        }
                    }
                };
                Runnable runnable = this.l;
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                this.l = r0;
                handler.postDelayed(r0, 500);
            }
        }

        private void a(final bk bkVar, Handler handler) {
            if (bkVar != null && handler != null) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        bkVar.a();
                    }
                }, 500);
            }
        }
    }

    public bf() {
        HandlerThread handlerThread = new HandlerThread("visitorThread");
        handlerThread.start();
        this.f1705h = new Handler(handlerThread.getLooper());
    }

    public static void b() {
        f1698a = 0;
    }

    public static /* synthetic */ int c() {
        int i2 = f1698a + 1;
        f1698a = i2;
        return i2;
    }

    public static bf a() {
        return k;
    }

    public static void b(Activity activity, boolean z, boolean z2) {
        if (z) {
            b(activity, z2);
        }
    }

    public static void b(Activity activity, boolean z) {
        a(activity, bj.a(activity), z);
    }

    public void a(Activity activity, boolean z, JSONObject jSONObject, boolean z2) {
        ar.a(activity, !z);
        if (!this.f1701d) {
            this.f1701d = z2;
        }
        if (z) {
            this.f1703f = z;
            this.f1702e = jSONObject;
        }
        if (!a(activity, 1)) {
            if (this.f1699b != null) {
                a aVar = this.f1706i;
                if (aVar != null) {
                    aVar.a();
                }
            }
            WeakReference<Activity> weakReference = new WeakReference<>(activity);
            this.f1699b = weakReference;
            this.f1700c = 1;
            Activity activity2 = activity;
            a aVar2 = new a(activity2, bj.a(activity), new com.baidu.mobstat.bk.a(1, weakReference, this.f1707j), this.f1704g, this.f1705h, this.f1702e, this.f1701d, true, this.f1703f);
            this.f1706i = aVar2;
        }
    }

    public void a(Activity activity, boolean z) {
        ar.b(activity, !z);
        if (!a(activity, 2)) {
            this.f1699b = new WeakReference<>(activity);
            this.f1700c = 2;
            a aVar = this.f1706i;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private boolean a(Activity activity, int i2) {
        WeakReference<Activity> weakReference = this.f1699b;
        return weakReference != null && ((Activity) weakReference.get()) == activity && this.f1700c == i2;
    }

    public static void a(Activity activity, View view, boolean z) {
        if (view == null || bj.c(activity, view)) {
            return;
        }
        if (view instanceof WebView) {
            WebView webView = (WebView) view;
            if (webView.getTag(-96001) == null) {
                String str = "webview auto set ";
                if (bd.c().b() && z) {
                    bd c2 = bd.c();
                    StringBuilder a2 = e.a.a.a.a.a(str);
                    a2.append(activity.getClass().getName());
                    c2.a(a2.toString());
                }
                if (bh.c().b()) {
                    bh c3 = bh.c();
                    StringBuilder a3 = e.a.a.a.a.a(str);
                    a3.append(activity.getClass().getName());
                    c3.a(a3.toString());
                }
                StatService.trackWebView(activity.getApplicationContext(), webView, null);
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(activity, viewGroup.getChildAt(i2), z);
            }
        }
    }
}
