package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import d.n.a.d;
import e.a.a.a.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class BDStatCore {
    public static final int INVOKE_ACT = 1;
    public static final int INVOKE_API = 0;
    public static final int INVOKE_CUSTOME = 3;
    public static final int INVOKE_FRAG = 2;

    /* renamed from: a reason: collision with root package name */
    public static BDStatCore f1245a;

    /* renamed from: b reason: collision with root package name */
    public Handler f1246b;

    /* renamed from: c reason: collision with root package name */
    public volatile boolean f1247c = false;

    /* renamed from: d reason: collision with root package name */
    public SessionAnalysis f1248d;

    /* renamed from: e reason: collision with root package name */
    public EventAnalysis f1249e;

    /* renamed from: f reason: collision with root package name */
    public Runnable f1250f;

    /* renamed from: g reason: collision with root package name */
    public long f1251g = 0;

    /* renamed from: h reason: collision with root package name */
    public volatile boolean f1252h = false;

    /* renamed from: i reason: collision with root package name */
    public Handler f1253i;

    public BDStatCore() {
        HandlerThread handlerThread = new HandlerThread("BDStatCore", 10);
        handlerThread.start();
        this.f1246b = new Handler(handlerThread.getLooper());
        this.f1248d = new SessionAnalysis();
        this.f1249e = new EventAnalysis();
        HandlerThread handlerThread2 = new HandlerThread("dataAnalyzeThread");
        handlerThread2.start();
        handlerThread2.setPriority(10);
        this.f1253i = new Handler(handlerThread2.getLooper());
    }

    public static BDStatCore instance() {
        if (f1245a == null) {
            synchronized (BDStatCore.class) {
                if (f1245a == null) {
                    f1245a = new BDStatCore();
                }
            }
        }
        return f1245a;
    }

    public void autoTrackLaunchInfo(Context context, final LaunchInfo launchInfo, final boolean z) {
        if (launchInfo != null) {
            if (z) {
                this.f1248d.autoTrackLaunchInfo(launchInfo, z);
                return;
            }
            init(context);
            this.f1246b.post(new Runnable() {
                public void run() {
                    BDStatCore.this.f1248d.autoTrackLaunchInfo(launchInfo, z);
                }
            });
        }
    }

    public void autoTrackSessionEndTime(final Context context) {
        if (context != null) {
            init(context);
            final long currentTimeMillis = System.currentTimeMillis();
            this.f1246b.post(new Runnable() {
                public void run() {
                    BDStatCore.this.f1248d.autoTrackSessionEndTime(context, currentTimeMillis);
                }
            });
        }
    }

    public void autoTrackSessionStartTime(final Context context) {
        if (context != null) {
            init(context);
            final long currentTimeMillis = System.currentTimeMillis();
            this.f1246b.post(new Runnable() {
                public void run() {
                    BDStatCore.this.f1248d.autoTrackSessionStartTime(context, currentTimeMillis);
                }
            });
        }
    }

    public void cancelSendLogCheck() {
        Runnable runnable = this.f1250f;
        if (runnable != null) {
            this.f1246b.removeCallbacks(runnable);
        }
        this.f1250f = null;
    }

    public void doSendLogCheck(final Context context) {
        if (context != null) {
            int sessionTimeOut = this.f1248d.getSessionTimeOut();
            AnonymousClass20 r1 = new Runnable() {
                public void run() {
                    BDStatCore.this.f1248d.doSendLogCheck(context, System.currentTimeMillis());
                }
            };
            this.f1250f = r1;
            this.f1246b.postDelayed(r1, (long) sessionTimeOut);
        }
    }

    public JSONObject getPageSessionHead() {
        return this.f1248d.getPageSessionHead();
    }

    public int getSessionSize() {
        return this.f1248d.getSessionSize();
    }

    public long getSessionStartTime() {
        return this.f1248d.getSessionStartTime();
    }

    public void init(final Context context) {
        a(context);
        if (!this.f1247c) {
            ActivityLifeTask.registerActivityLifeCallback(context);
            this.f1246b.post(new Runnable() {
                public void run() {
                    if (!BDStatCore.this.f1247c) {
                        PrefOperate.loadMetaDataConfig(context);
                        BDStatCore.this.f1247c = true;
                    }
                }
            });
        }
    }

    public void onErised(Context context, String str, String str2, String str3) {
        if (!this.f1248d.isSessionStart()) {
            init(context);
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f1246b;
            final Context context2 = context;
            final String str4 = str2;
            final String str5 = str3;
            AnonymousClass15 r0 = new Runnable() {
                public void run() {
                    DataCore.instance().init(context2);
                    EventAnalysis c2 = BDStatCore.this.f1249e;
                    Context context = context2;
                    long j2 = currentTimeMillis;
                    c2.onEvent(context, j2, str4, str5, 1, j2, null, null, false);
                    DataCore.instance().saveLogData(context2, true, false, currentTimeMillis, false);
                    if (currentTimeMillis - BDStatCore.this.f1251g > StatisticConfig.MIN_UPLOAD_INTERVAL && bw.q(context2)) {
                        LogSender.instance().onSend(context2);
                        BDStatCore.this.f1251g = currentTimeMillis;
                    }
                }
            };
            handler.post(r0);
        }
    }

    public void onEvent(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        onEvent(context, str, str2, i2, extraInfo, map, z, false);
    }

    public void onEventDuration(Context context, String str, String str2, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        onEventDuration(context, str, str2, j2, extraInfo, map, z, false);
    }

    public void onEventEnd(Context context, String str, String str2, ExtraInfo extraInfo, Map<String, String> map) {
        onEventEnd(context, str, str2, extraInfo, map, false);
    }

    public void onEventStart(Context context, String str, String str2, boolean z) {
        if (context != null) {
            init(context);
            b(context);
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f1246b;
            final String str3 = str2;
            final Context context2 = context;
            final boolean z2 = z;
            final String str4 = str;
            AnonymousClass10 r0 = new Runnable() {
                public void run() {
                    String str = str3;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    BDStatCore.this.f1248d.onSessionStart(context2, currentTimeMillis, z2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Start event");
                    sb.append(BDStatCore.this.a(str4, str, 1, -1, null, null));
                    bc.c().a(sb.toString());
                    BDStatCore.this.f1249e.onEventStart(context2, str4, str, currentTimeMillis);
                }
            };
            handler.post(r0);
        }
    }

    public void onPageEnd(Context context, String str, ExtraInfo extraInfo) {
        onPageEnd(context, str, extraInfo, false);
    }

    public void onPageStart(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            init(context);
            b(context);
            final int a2 = a();
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f1246b;
            final String str2 = str;
            final Context context2 = context;
            AnonymousClass21 r1 = new Runnable() {
                public void run() {
                    bc c2 = bc.c();
                    StringBuilder a2 = a.a("Start page view ");
                    a2.append(str2);
                    c2.a(a2.toString());
                    BDStatCore.this.f1248d.onPageStart(context2, str2, a2, currentTimeMillis);
                }
            };
            handler.post(r1);
        }
    }

    public void onPause(Activity activity, boolean z, ExtraInfo extraInfo) {
        if (activity != null) {
            final Context applicationContext = activity.getApplicationContext();
            if (applicationContext != null) {
                init(applicationContext);
                final WeakReference weakReference = new WeakReference(activity);
                Handler handler = this.f1246b;
                final boolean z2 = z;
                final ExtraInfo extraInfo2 = extraInfo;
                AnonymousClass4 r0 = new Runnable() {
                    public void run() {
                        String str;
                        Activity activity = (Activity) weakReference.get();
                        if (activity != null) {
                            Class cls = activity.getClass();
                            if (cls != null) {
                                String name = activity.getClass().getName();
                                String simpleName = activity.getClass().getSimpleName();
                                CharSequence title = activity.getTitle();
                                if (title == null) {
                                    str = "";
                                } else {
                                    str = title.toString();
                                }
                                String str2 = str;
                                if (!z2) {
                                    bc c2 = bc.c();
                                    StringBuilder a2 = a.a("End page view ");
                                    a2.append(cls.getSimpleName());
                                    c2.a(a2.toString());
                                }
                                BDStatCore.this.f1248d.onPageEndAct(applicationContext, name, simpleName, str2, System.currentTimeMillis(), z2, extraInfo2);
                            }
                        }
                    }
                };
                handler.post(r0);
            }
        }
    }

    public void onResume(Activity activity, final boolean z) {
        if (activity != null) {
            final Context applicationContext = activity.getApplicationContext();
            if (applicationContext != null) {
                init(applicationContext);
                b(applicationContext);
                final WeakReference weakReference = new WeakReference(activity);
                this.f1246b.post(new Runnable() {
                    public void run() {
                        Activity activity = (Activity) weakReference.get();
                        if (activity != null) {
                            Class cls = activity.getClass();
                            if (cls != null) {
                                String name = activity.getClass().getName();
                                long currentTimeMillis = System.currentTimeMillis();
                                if (!z) {
                                    bc c2 = bc.c();
                                    StringBuilder a2 = a.a("Start page view ");
                                    a2.append(cls.getSimpleName());
                                    c2.a(a2.toString());
                                }
                                BDStatCore.this.f1248d.onPageStartAct(applicationContext, name, currentTimeMillis, z);
                            }
                        }
                    }
                });
            }
        }
    }

    public void onSessionStart(Context context, boolean z) {
        if (context != null) {
            init(context);
            b(context);
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f1246b;
            final Context context2 = context;
            final boolean z2 = z;
            AnonymousClass12 r0 = new Runnable() {
                public void run() {
                    BDStatCore.this.f1248d.onSessionStart(context2, currentTimeMillis, z2);
                }
            };
            handler.post(r0);
        }
    }

    public void onStat(final Context context, final String str) {
        if (!this.f1248d.isSessionStart()) {
            this.f1246b.post(new Runnable() {
                public void run() {
                    LogSender.instance().sendEmptyLogData(context, str);
                }
            });
        }
    }

    public void setAutoSendLog(Context context, boolean z) {
        if (context != null) {
            init(context);
            b(context);
            this.f1248d.setAutoSend(z);
        }
    }

    public void setSessionTimeOut(int i2) {
        this.f1248d.setSessionTimeOut(i2);
    }

    public void onEvent(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map, boolean z, boolean z2) {
        if (context != null) {
            init(context);
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f1246b;
            final String str3 = str2;
            final Context context2 = context;
            final boolean z3 = z;
            final String str4 = str;
            final int i3 = i2;
            final Map<String, String> map2 = map;
            final ExtraInfo extraInfo2 = extraInfo;
            final boolean z4 = z2;
            AnonymousClass7 r0 = new Runnable() {
                public void run() {
                    String str = str3;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    BDStatCore.this.f1248d.onSessionStart(context2, currentTimeMillis, z3);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Put event");
                    sb.append(BDStatCore.this.a(str4, str, i3, 0, map2, extraInfo2));
                    bc.c().a(sb.toString());
                    BDStatCore.this.f1249e.onEvent(context2, BDStatCore.this.f1248d.getSessionStartTime(), str4, str, i3, currentTimeMillis, extraInfo2, map2, z4);
                }
            };
            handler.post(r0);
        }
    }

    public void onEventDuration(Context context, String str, String str2, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z, boolean z2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            init(context);
            b(context);
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f1246b;
            final String str3 = str2;
            final Context context2 = context;
            final boolean z3 = z;
            final String str4 = str;
            final long j3 = j2;
            final Map<String, String> map2 = map;
            final ExtraInfo extraInfo2 = extraInfo;
            final boolean z4 = z2;
            AnonymousClass13 r0 = new Runnable() {
                public void run() {
                    String str = str3;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    BDStatCore.this.f1248d.onSessionStart(context2, currentTimeMillis, z3);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Put event");
                    sb.append(BDStatCore.this.a(str4, str, 1, j3, map2, extraInfo2));
                    bc.c().a(sb.toString());
                    BDStatCore.this.f1249e.onEventDuration(context2, BDStatCore.this.f1248d.getSessionStartTime(), str4, str, currentTimeMillis, j3, extraInfo2, map2, z4);
                }
            };
            handler.post(r0);
        }
    }

    public void onEventEnd(Context context, String str, String str2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        if (context != null) {
            init(context);
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f1246b;
            final String str3 = str2;
            final String str4 = str;
            final Map<String, String> map2 = map;
            final ExtraInfo extraInfo2 = extraInfo;
            final Context context2 = context;
            final boolean z2 = z;
            AnonymousClass11 r0 = new Runnable() {
                public void run() {
                    String str = str3;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    long sessionStartTime = BDStatCore.this.f1248d.getSessionStartTime();
                    StringBuilder a2 = a.a("End event");
                    a2.append(BDStatCore.this.a(str4, str, 1, -1, map2, extraInfo2));
                    bc.c().a(a2.toString());
                    BDStatCore.this.f1249e.onEventEnd(context2, sessionStartTime, str4, str, currentTimeMillis, extraInfo2, map2, z2);
                }
            };
            handler.post(r0);
        }
    }

    public void onPageEnd(Context context, String str, ExtraInfo extraInfo, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            init(context);
            final String b2 = b();
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f1246b;
            final String str2 = str;
            final Context context2 = context;
            final ExtraInfo extraInfo2 = extraInfo;
            final boolean z2 = z;
            AnonymousClass22 r1 = new Runnable() {
                public void run() {
                    bc c2 = bc.c();
                    StringBuilder a2 = a.a("End page view ");
                    a2.append(str2);
                    c2.a(a2.toString());
                    SessionAnalysis b2 = BDStatCore.this.f1248d;
                    Context context = context2;
                    String str = str2;
                    b2.onPageEnd(context, str, str, b2, currentTimeMillis, extraInfo2, z2);
                }
            };
            handler.post(r1);
        }
    }

    private String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement className : stackTrace) {
            String className2 = className.getClassName();
            if (!TextUtils.isEmpty(className2)) {
                Class cls = null;
                try {
                    cls = Class.forName(className2);
                } catch (Throwable unused) {
                }
                if (cls != null && Activity.class.isAssignableFrom(cls)) {
                    return cls.getName();
                }
            }
        }
        return "";
    }

    private void a(Context context) {
        String appKey = CooperService.instance().getAppKey(context);
        if (!TextUtils.isEmpty(appKey)) {
            av.a(appKey);
        }
    }

    public void onEvent(Context context, String str, String str2, int i2, String str3, String str4, int i3, boolean z) {
        if (context != null) {
            init(context);
            b(context);
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f1246b;
            final String str5 = str2;
            final Context context2 = context;
            final String str6 = str;
            final int i4 = i2;
            final String str7 = str3;
            final String str8 = str4;
            final int i5 = i3;
            final boolean z2 = z;
            AnonymousClass8 r0 = new Runnable() {
                public void run() {
                    String str = str5;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    BDStatCore.this.f1248d.onSessionStart(context2, currentTimeMillis, false);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Put event");
                    sb.append(BDStatCore.this.a(str6, str, i4, 0, null, null));
                    bc.c().a(sb.toString());
                    BDStatCore.this.f1249e.onEvent(context2, BDStatCore.this.f1248d.getSessionStartTime(), str6, str, i4, currentTimeMillis, str7, str8, i5, z2);
                }
            };
            handler.post(r0);
        }
    }

    public void onPause(Fragment fragment) {
        if (fragment != null) {
            final d activity = fragment.getActivity();
            if (activity != null) {
                final Context applicationContext = activity.getApplicationContext();
                if (applicationContext != null) {
                    init(applicationContext);
                    final WeakReference weakReference = new WeakReference(fragment);
                    Handler handler = this.f1246b;
                    final Fragment fragment2 = fragment;
                    AnonymousClass5 r0 = new Runnable() {
                        public void run() {
                            String str;
                            Fragment fragment = (Fragment) weakReference.get();
                            if (fragment != null && fragment.getClass() != null) {
                                String name = fragment2.getClass().getName();
                                String simpleName = fragment2.getClass().getSimpleName();
                                CharSequence title = activity.getTitle();
                                if (title == null) {
                                    str = "";
                                } else {
                                    str = title.toString();
                                }
                                String str2 = str;
                                bc c2 = bc.c();
                                StringBuilder sb = new StringBuilder();
                                sb.append("End page view ");
                                sb.append(simpleName);
                                c2.a(sb.toString());
                                BDStatCore.this.f1248d.onPageEndFrag(applicationContext, name, simpleName, str2, System.currentTimeMillis());
                            }
                        }
                    };
                    handler.post(r0);
                }
            }
        }
    }

    public void onResume(Fragment fragment) {
        if (fragment != null) {
            d activity = fragment.getActivity();
            if (activity != null) {
                final Context applicationContext = activity.getApplicationContext();
                if (applicationContext != null) {
                    init(applicationContext);
                    b(applicationContext);
                    final WeakReference weakReference = new WeakReference(fragment);
                    this.f1246b.post(new Runnable() {
                        public void run() {
                            Fragment fragment = (Fragment) weakReference.get();
                            if (fragment != null) {
                                Class cls = fragment.getClass();
                                if (cls != null) {
                                    String name = fragment.getClass().getName();
                                    long currentTimeMillis = System.currentTimeMillis();
                                    bc c2 = bc.c();
                                    StringBuilder a2 = a.a("Start page view ");
                                    a2.append(cls.getSimpleName());
                                    c2.a(a2.toString());
                                    BDStatCore.this.f1248d.onPageStartFrag(applicationContext, name, currentTimeMillis);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    private int a() {
        Class cls;
        Class cls2;
        Class cls3;
        try {
            cls = Class.forName("android.app.Fragment");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        try {
            cls2 = Class.forName("androidx.fragment.app.Fragment");
        } catch (ClassNotFoundException unused2) {
            cls2 = null;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i2 = 0;
        while (stackTrace != null && i2 < stackTrace.length) {
            String className = stackTrace[i2].getClassName();
            if (!TextUtils.isEmpty(className)) {
                if (!"onResume".equals(stackTrace[i2].getMethodName())) {
                    continue;
                } else {
                    try {
                        cls3 = Class.forName(className);
                    } catch (Throwable unused3) {
                        cls3 = null;
                    }
                    if (cls3 == null) {
                        continue;
                    } else if (Activity.class.isAssignableFrom(cls3)) {
                        return 1;
                    } else {
                        if (cls != null && cls.isAssignableFrom(cls3)) {
                            return 2;
                        }
                        if (cls2 != null && cls2.isAssignableFrom(cls3)) {
                            return 2;
                        }
                    }
                }
            }
            i2++;
        }
        return 3;
    }

    public void onEvent(Context context, String str, String str2, int i2, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map) {
        onEvent(context, str, str2, i2, j2, jSONArray, jSONArray2, str3, str4, str5, map, false);
    }

    private void b(final Context context) {
        if (!this.f1252h && context != null) {
            Handler handler = this.f1253i;
            if (handler != null) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        try {
                            if (!t.b(context)) {
                                t.a(2).a(context);
                            }
                        } catch (Throwable unused) {
                        }
                        BDStatCore.this.f1252h = false;
                    }
                }, Config.BPLUS_DELAY_TIME);
                this.f1252h = true;
            }
        }
    }

    public void onEvent(Context context, String str, String str2, int i2, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        if (context != null) {
            init(context);
            b(context);
            final String str6 = str2;
            final Context context2 = context;
            final long j3 = j2;
            final String str7 = str;
            final int i3 = i2;
            final Map<String, String> map2 = map;
            final JSONArray jSONArray3 = jSONArray;
            final JSONArray jSONArray4 = jSONArray2;
            final String str8 = str3;
            final String str9 = str4;
            final String str10 = str5;
            AnonymousClass9 r17 = r0;
            Handler handler = this.f1246b;
            final boolean z2 = z;
            AnonymousClass9 r0 = new Runnable() {
                public void run() {
                    String str = str6;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    BDStatCore.this.f1248d.onSessionStart(context2, j3, false);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Put event");
                    sb.append(BDStatCore.this.a(str7, str, i3, 0, map2, null));
                    bc.c().a(sb.toString());
                    long sessionStartTime = BDStatCore.this.f1248d.getSessionStartTime();
                    EventAnalysis c2 = BDStatCore.this.f1249e;
                    Context context = context2;
                    String str2 = str7;
                    int i2 = i3;
                    long j2 = j3;
                    JSONArray jSONArray = jSONArray3;
                    JSONArray jSONArray2 = jSONArray4;
                    String str3 = str8;
                    String str4 = str9;
                    String str5 = str10;
                    Map map = map2;
                    String str6 = str;
                    c2.onEvent(context, sessionStartTime, str2, str6, i2, j2, jSONArray, jSONArray2, str3, str4, str5, map, z2);
                }
            };
            handler.post(r17);
        }
    }

    @SuppressLint({"NewApi"})
    public void onPause(android.app.Fragment fragment) {
        if (fragment != null) {
            final Activity activity = fragment.getActivity();
            if (activity != null) {
                final Context applicationContext = activity.getApplicationContext();
                if (applicationContext != null) {
                    init(applicationContext);
                    final WeakReference weakReference = new WeakReference(fragment);
                    Handler handler = this.f1246b;
                    final android.app.Fragment fragment2 = fragment;
                    AnonymousClass6 r0 = new Runnable() {
                        public void run() {
                            String str;
                            android.app.Fragment fragment = (android.app.Fragment) weakReference.get();
                            if (fragment != null && fragment.getClass() != null) {
                                String name = fragment2.getClass().getName();
                                String simpleName = fragment2.getClass().getSimpleName();
                                CharSequence title = activity.getTitle();
                                if (title == null) {
                                    str = "";
                                } else {
                                    str = title.toString();
                                }
                                String str2 = str;
                                bc c2 = bc.c();
                                StringBuilder sb = new StringBuilder();
                                sb.append("End page view ");
                                sb.append(simpleName);
                                c2.a(sb.toString());
                                BDStatCore.this.f1248d.onPageEndFrag(applicationContext, name, simpleName, str2, System.currentTimeMillis());
                            }
                        }
                    };
                    handler.post(r0);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void onResume(android.app.Fragment fragment) {
        if (fragment != null) {
            Activity activity = fragment.getActivity();
            if (activity != null) {
                final Context applicationContext = activity.getApplicationContext();
                if (applicationContext != null) {
                    init(applicationContext);
                    b(applicationContext);
                    final WeakReference weakReference = new WeakReference(fragment);
                    this.f1246b.post(new Runnable() {
                        public void run() {
                            android.app.Fragment fragment = (android.app.Fragment) weakReference.get();
                            if (fragment != null) {
                                Class cls = fragment.getClass();
                                if (cls != null) {
                                    String name = fragment.getClass().getName();
                                    long currentTimeMillis = System.currentTimeMillis();
                                    bc c2 = bc.c();
                                    StringBuilder a2 = a.a("Start page view ");
                                    a2.append(cls.getSimpleName());
                                    c2.a(a2.toString());
                                    BDStatCore.this.f1248d.onPageStartFrag(applicationContext, name, currentTimeMillis);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r4, java.lang.String r5, int r6, long r7, java.util.Map<java.lang.String, java.lang.String> r9, com.baidu.mobstat.ExtraInfo r10) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            if (r9 == 0) goto L_0x0018
            int r2 = r9.size()
            if (r2 == 0) goto L_0x0018
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0018 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0018 }
            r2.<init>(r9)     // Catch:{ Exception -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r2 = r1
        L_0x0019:
            if (r10 == 0) goto L_0x001f
            org.json.JSONObject r1 = r10.dumpToJson()
        L_0x001f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = " eventId "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r4 = ", with eventLabel "
            r9.append(r4)
            r9.append(r5)
            java.lang.String r4 = ", with acc "
            r9.append(r4)
            r9.append(r6)
            java.lang.String r4 = r9.toString()
            r0.append(r4)
            r4 = 0
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x005d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = ", with duration "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
        L_0x005d:
            if (r2 == 0) goto L_0x0079
            int r4 = r2.length()
            if (r4 == 0) goto L_0x0079
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = ", with attributes "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
        L_0x0079:
            if (r1 == 0) goto L_0x0095
            int r4 = r1.length()
            if (r4 == 0) goto L_0x0095
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = ", with extraInfo "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
        L_0x0095:
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.BDStatCore.a(java.lang.String, java.lang.String, int, long, java.util.Map, com.baidu.mobstat.ExtraInfo):java.lang.String");
    }
}
