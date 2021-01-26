package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import java.util.LinkedHashSet;
import java.util.Set;

public class ActivityLifeObserver {

    /* renamed from: b reason: collision with root package name */
    public static final ActivityLifeObserver f1235b = new ActivityLifeObserver();

    /* renamed from: a reason: collision with root package name */
    public boolean f1236a;

    /* renamed from: c reason: collision with root package name */
    public Set<IActivityLifeCallback> f1237c = new LinkedHashSet();

    public interface IActivityLifeCallback {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle bundle);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);
    }

    public static ActivityLifeObserver instance() {
        return f1235b;
    }

    public void addObserver(IActivityLifeCallback iActivityLifeCallback) {
        synchronized (this.f1237c) {
            this.f1237c.add(iActivityLifeCallback);
        }
    }

    public void clearObservers() {
        synchronized (this.f1237c) {
            this.f1237c.clear();
        }
    }

    @TargetApi(14)
    public void doRegister(Context context) {
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    synchronized (ActivityLifeObserver.this.f1237c) {
                        for (IActivityLifeCallback onActivityCreated : ActivityLifeObserver.this.f1237c) {
                            onActivityCreated.onActivityCreated(activity, bundle);
                        }
                    }
                }

                public void onActivityDestroyed(Activity activity) {
                    synchronized (ActivityLifeObserver.this.f1237c) {
                        for (IActivityLifeCallback onActivityDestroyed : ActivityLifeObserver.this.f1237c) {
                            onActivityDestroyed.onActivityDestroyed(activity);
                        }
                    }
                }

                public void onActivityPaused(Activity activity) {
                    synchronized (ActivityLifeObserver.this.f1237c) {
                        for (IActivityLifeCallback onActivityPaused : ActivityLifeObserver.this.f1237c) {
                            onActivityPaused.onActivityPaused(activity);
                        }
                    }
                }

                public void onActivityResumed(Activity activity) {
                    synchronized (ActivityLifeObserver.this.f1237c) {
                        for (IActivityLifeCallback onActivityResumed : ActivityLifeObserver.this.f1237c) {
                            onActivityResumed.onActivityResumed(activity);
                        }
                    }
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    synchronized (ActivityLifeObserver.this.f1237c) {
                        for (IActivityLifeCallback onActivitySaveInstanceState : ActivityLifeObserver.this.f1237c) {
                            onActivitySaveInstanceState.onActivitySaveInstanceState(activity, bundle);
                        }
                    }
                }

                public void onActivityStarted(Activity activity) {
                    synchronized (ActivityLifeObserver.this.f1237c) {
                        for (IActivityLifeCallback onActivityStarted : ActivityLifeObserver.this.f1237c) {
                            onActivityStarted.onActivityStarted(activity);
                        }
                    }
                }

                public void onActivityStopped(Activity activity) {
                    synchronized (ActivityLifeObserver.this.f1237c) {
                        for (IActivityLifeCallback onActivityStopped : ActivityLifeObserver.this.f1237c) {
                            onActivityStopped.onActivityStopped(activity);
                        }
                    }
                }
            });
        } catch (Exception unused) {
            bc.c().a("registerActivityLifecycleCallbacks encounter exception");
        }
    }

    public void registerActivityLifeCallback(Context context) {
        if (!this.f1236a) {
            doRegister(context);
            this.f1236a = true;
        }
    }

    public void removeObserver(IActivityLifeCallback iActivityLifeCallback) {
        synchronized (this.f1237c) {
            this.f1237c.remove(iActivityLifeCallback);
        }
    }
}
