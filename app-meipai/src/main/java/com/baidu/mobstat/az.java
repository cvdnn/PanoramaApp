package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.Window.Callback;
import android.webkit.WebView;
import com.baidu.mobstat.al.a;
import org.json.JSONObject;

public class az {
    public static final az k = new az();
    public static volatile boolean l = true;

    /* renamed from: a reason: collision with root package name */
    public Context f1679a;

    /* renamed from: b reason: collision with root package name */
    public Activity f1680b;

    /* renamed from: c reason: collision with root package name */
    public volatile boolean f1681c;

    /* renamed from: d reason: collision with root package name */
    public volatile boolean f1682d;

    /* renamed from: e reason: collision with root package name */
    public volatile String f1683e;

    /* renamed from: f reason: collision with root package name */
    public long f1684f;

    /* renamed from: g reason: collision with root package name */
    public long f1685g;

    /* renamed from: h reason: collision with root package name */
    public String f1686h;

    /* renamed from: i reason: collision with root package name */
    public PointF f1687i;

    /* renamed from: j reason: collision with root package name */
    public bf f1688j = bf.a();

    private void e() {
        if (bw.s(this.f1679a) && !this.f1681c) {
            if (!this.f1682d) {
                this.f1683e = bo.a(this.f1679a, "mtj_autoTracker.js");
                this.f1682d = true;
            }
            if (this.f1684f == 0) {
                this.f1684f = bq.a().n(this.f1679a);
                this.f1685g = bq.a().o(this.f1679a);
            }
            if ((this.f1682d && TextUtils.isEmpty(this.f1683e)) || System.currentTimeMillis() - this.f1684f > this.f1685g) {
                f();
            }
        }
    }

    private void f() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                if (!az.this.f1681c) {
                    boolean a2 = bg.a(az.this.f1679a, az.this.f1686h, 1, false);
                    az.this.f1681c = true;
                    if (a2) {
                        az azVar = az.this;
                        azVar.f1683e = bo.a(azVar.f1679a, "mtj_autoTracker.js");
                    }
                }
            }
        });
        thread.setName("downloadThread");
        thread.start();
    }

    public static boolean c() {
        return l;
    }

    private void d(Activity activity) {
        if (activity != null) {
            Window window = activity.getWindow();
            if (window != null) {
                window.setCallback(a(window.getCallback()));
            }
        }
    }

    public void b(String str) {
        this.f1686h = str;
    }

    private void c(Activity activity) {
        if (activity != null) {
            Window window = activity.getWindow();
            if (window != null) {
                Callback callback = window.getCallback();
                if (callback != null) {
                    window.setCallback(new al(callback, new a() {
                        public void a(MotionEvent motionEvent) {
                            if (motionEvent.getActionMasked() == 1) {
                                az.a(true);
                                if (az.this.f1687i == null) {
                                    az.this.f1687i = new PointF();
                                }
                                az.this.f1687i.set(motionEvent.getRawX(), motionEvent.getRawY());
                            }
                        }

                        public void a(KeyEvent keyEvent) {
                            ar.a(keyEvent);
                        }
                    }));
                }
            }
        }
    }

    public PointF b() {
        return this.f1687i;
    }

    public void b(Activity activity) {
        if (d()) {
            d(this.f1680b);
            this.f1680b = null;
            a(activity, false);
        }
    }

    public static az a() {
        return k;
    }

    private boolean d() {
        return !TextUtils.isEmpty(this.f1686h);
    }

    public void a(String str) {
        ax.a().a(str);
    }

    public static void a(boolean z) {
        if (z) {
            bf.b();
        }
        l = z;
    }

    private void b(WebView webView, String str, bl blVar) {
        if (blVar != null) {
            blVar.a(this.f1680b, webView, str, (JSONObject) null, false);
        }
    }

    public void a(Activity activity) {
        if (d()) {
            a(true);
            this.f1679a = activity.getApplicationContext();
            this.f1680b = activity;
            e();
            c(activity);
            a(activity, true);
        }
    }

    public void a(Activity activity, boolean z) {
        if (!(activity instanceof IIgnoreAutoEvent)) {
            if (z) {
                this.f1688j.a(activity, false, null, false);
            } else {
                this.f1688j.a(activity, false);
            }
        }
    }

    private Callback a(Callback callback) {
        while (callback != null && (callback instanceof al)) {
            callback = ((al) callback).a();
        }
        return callback;
    }

    public void a(WebView webView, String str, bl blVar) {
        if (TextUtils.isEmpty(this.f1683e)) {
            this.f1683e = bo.a(this.f1679a, "mtj_autoTracker.js");
        }
        b(webView, this.f1683e, blVar);
    }
}
