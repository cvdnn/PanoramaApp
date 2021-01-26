package com.baidu.mobstat;

import android.content.Context;
import com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback;
import com.baidu.mobstat.AutoTrack.MyActivityLifeCallback;
import com.baidu.mobstat.af.a;

public class ActivityLifeTask {

    /* renamed from: a reason: collision with root package name */
    public static boolean f1239a = false;

    /* renamed from: b reason: collision with root package name */
    public static IActivityLifeCallback f1240b;

    /* renamed from: c reason: collision with root package name */
    public static IActivityLifeCallback f1241c;

    /* renamed from: d reason: collision with root package name */
    public static IActivityLifeCallback f1242d;

    /* renamed from: e reason: collision with root package name */
    public static IActivityLifeCallback f1243e;

    public static synchronized void a(Context context) {
        synchronized (ActivityLifeTask.class) {
            f1240b = new MyActivityLifeCallback(1);
            f1242d = new a();
            f1241c = new av.a();
            f1243e = new MyActivityLifeCallback(2);
        }
    }

    public static synchronized void registerActivityLifeCallback(Context context) {
        synchronized (ActivityLifeTask.class) {
            if (!f1239a) {
                a(context);
                ActivityLifeObserver.instance().clearObservers();
                ActivityLifeObserver.instance().addObserver(f1240b);
                ActivityLifeObserver.instance().addObserver(f1242d);
                ActivityLifeObserver.instance().addObserver(f1241c);
                ActivityLifeObserver.instance().addObserver(f1243e);
                ActivityLifeObserver.instance().registerActivityLifeCallback(context);
                f1239a = true;
            }
        }
    }
}
