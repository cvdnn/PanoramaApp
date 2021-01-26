package com.baidu.sapi2;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Stack;

/* renamed from: com.baidu.sapi2.b reason: case insensitive filesystem */
/* compiled from: ActivityStackManager */
public class C0164b implements ActivityLifecycleCallbacks {

    /* renamed from: a reason: collision with root package name */
    public Stack<Activity> f2693a;

    /* renamed from: com.baidu.sapi2.b$a */
    /* compiled from: ActivityStackManager */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public static C0164b f2694a = new C0164b();
    }

    public static C0164b b() {
        return a.f2694a;
    }

    public void a(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public boolean c(Activity activity) {
        return this.f2693a.remove(activity);
    }

    public int d(Activity activity) {
        return this.f2693a.search(activity);
    }

    public Activity e() {
        if (!this.f2693a.isEmpty()) {
            return (Activity) this.f2693a.lastElement();
        }
        return null;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        c(activity);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public C0164b() {
        this.f2693a = new Stack<>();
    }

    public void a(Activity activity) {
        this.f2693a.add(activity);
    }

    public void b(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public Activity c() {
        if (this.f2693a.isEmpty() || this.f2693a.size() < 2) {
            return null;
        }
        Stack<Activity> stack = this.f2693a;
        return (Activity) stack.get(stack.size() - 2);
    }

    public Activity d() {
        int size = this.f2693a.size();
        if (size < 2) {
            return e();
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Activity activity = (Activity) this.f2693a.get(i2);
            if (activity != null && !activity.isFinishing()) {
                return activity;
            }
        }
        return null;
    }

    public void a(Class<Activity> cls) {
        if (cls != null) {
            Iterator it = this.f2693a.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                if (activity.getClass().equals(cls)) {
                    it.remove();
                    b(activity);
                }
            }
        }
    }

    public void b(Activity activity) {
        ((Activity) this.f2693a.pop()).finish();
    }

    public void a() {
        while (!this.f2693a.isEmpty()) {
            ((Activity) this.f2693a.pop()).finish();
        }
    }
}
