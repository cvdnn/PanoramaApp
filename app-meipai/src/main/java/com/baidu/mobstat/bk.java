package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import java.lang.ref.WeakReference;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import org.json.JSONObject;

public abstract class bk implements com.baidu.mobstat.bi.a {

    /* renamed from: a reason: collision with root package name */
    public bi f1743a;

    @TargetApi(14)
    public static class a extends bk {

        /* renamed from: a reason: collision with root package name */
        public WeakReference<Activity> f1744a;

        /* renamed from: b reason: collision with root package name */
        public b f1745b;

        /* renamed from: c reason: collision with root package name */
        public final WeakHashMap<View, C0010a> f1746c = new WeakHashMap<>();

        /* renamed from: com.baidu.mobstat.bk$a$a reason: collision with other inner class name */
        public class C0010a extends AccessibilityDelegate {

            /* renamed from: b reason: collision with root package name */
            public AccessibilityDelegate f1748b;

            /* renamed from: c reason: collision with root package name */
            public View f1749c;

            /* renamed from: d reason: collision with root package name */
            public volatile boolean f1750d;

            public C0010a(WeakReference<Activity> weakReference, View view, String str, AccessibilityDelegate accessibilityDelegate, boolean z) {
                this.f1748b = accessibilityDelegate;
                a.this.f1744a = weakReference;
                this.f1749c = view;
                this.f1750d = z;
            }

            public void a(boolean z) {
                this.f1750d = z;
            }

            public void sendAccessibilityEvent(View view, int i2) {
                if (view == this.f1749c && i2 == 1) {
                    String str = "watch view  OnEvent:";
                    if (bd.c().b() && this.f1750d) {
                        bd c2 = bd.c();
                        StringBuilder a2 = e.a.a.a.a.a(str);
                        a2.append(view.getClass().getName());
                        c2.a(a2.toString());
                    }
                    if (bh.c().b()) {
                        bh c3 = bh.c();
                        StringBuilder a3 = e.a.a.a.a.a(str);
                        a3.append(view.getClass().getName());
                        c3.a(a3.toString());
                    }
                    if (a.this.f1744a != null) {
                        Activity activity = (Activity) a.this.f1744a.get();
                        if (activity != null) {
                            a.this.f1745b.a(view, this.f1750d, activity);
                        }
                    }
                }
                AccessibilityDelegate accessibilityDelegate = this.f1748b;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.sendAccessibilityEvent(view, i2);
                } else {
                    super.sendAccessibilityEvent(view, i2);
                }
            }

            public AccessibilityDelegate a() {
                return this.f1748b;
            }
        }

        public a(int i2, WeakReference<Activity> weakReference, b bVar) {
            this.f1744a = weakReference;
            this.f1745b = bVar;
        }

        public void a(WeakReference<Activity> weakReference, View view, String str, boolean z) {
            AccessibilityDelegate a2 = a(view);
            if (!(a2 instanceof C0010a)) {
                C0010a aVar = new C0010a(weakReference, view, str, a2, z);
                view.setAccessibilityDelegate(aVar);
                this.f1746c.put(view, aVar);
                return;
            }
            ((C0010a) a2).a(z);
        }

        private AccessibilityDelegate a(View view) {
            try {
                return (AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }

        public void a(View view, boolean z) {
            a(this.f1744a, view, bj.a(view), z);
        }

        public void a() {
            WeakHashMap<View, C0010a> weakHashMap = this.f1746c;
            if (weakHashMap != null) {
                for (Entry entry : weakHashMap.entrySet()) {
                    ((View) entry.getKey()).setAccessibilityDelegate(((C0010a) entry.getValue()).a());
                }
                this.f1746c.clear();
            }
        }
    }

    public interface b {
        void a(View view, boolean z, Activity activity);
    }

    public abstract void a();

    public void a(Activity activity, JSONObject jSONObject, boolean z) {
        if (this.f1743a == null) {
            bi biVar = new bi(activity, this, z);
            this.f1743a = biVar;
            biVar.a(jSONObject);
        }
        this.f1743a.a(activity);
    }
}
