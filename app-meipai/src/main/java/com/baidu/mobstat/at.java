package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.WebView;
import android.widget.ScrollView;
import com.baidu.mobstat.MtjConfig.FeedTrackStrategy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;

public class at {
    public static final at u = new at();
    public Object A = new Object();

    /* renamed from: a reason: collision with root package name */
    public Context f1592a;

    /* renamed from: b reason: collision with root package name */
    public WeakReference<Activity> f1593b;

    /* renamed from: c reason: collision with root package name */
    public Handler f1594c;

    /* renamed from: d reason: collision with root package name */
    public boolean f1595d = true;

    /* renamed from: e reason: collision with root package name */
    public ArrayList<WeakReference<View>> f1596e = new ArrayList<>();

    /* renamed from: f reason: collision with root package name */
    public volatile FeedTrackStrategy f1597f = FeedTrackStrategy.TRACK_ALL;

    /* renamed from: g reason: collision with root package name */
    public long f1598g;

    /* renamed from: h reason: collision with root package name */
    public long f1599h;

    /* renamed from: i reason: collision with root package name */
    public long f1600i;

    /* renamed from: j reason: collision with root package name */
    public String f1601j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public String o;
    public boolean p;
    public boolean q;
    public List<WeakReference<View>> r = new ArrayList();
    public HashMap<WeakReference<View>, ArrayList<ap>> s = new HashMap<>();
    public HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> t = new HashMap<>();
    public a v;
    public OnScrollChangedListener w = new OnScrollChangedListener() {
        public void onScrollChanged() {
            at atVar = at.this;
            atVar.a(atVar.f1593b);
        }
    };
    public Runnable x = null;
    public float y = 0.0f;
    public float z = 0.0f;

    public interface a {
        void a(ao aoVar);

        void a(ArrayList<ap> arrayList);

        void b(ArrayList<aq> arrayList);
    }

    public at() {
        HandlerThread handlerThread = new HandlerThread("feedViewCrawlerThread");
        handlerThread.start();
        this.f1594c = new Handler(handlerThread.getLooper());
    }

    private boolean a(long j2, long j3) {
        long j4 = j3 - j2;
        return j4 > 0 && j4 > 50;
    }

    private void e(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap) {
        g(hashMap);
    }

    private void f(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap) {
        for (Entry value : hashMap.entrySet()) {
            HashMap hashMap2 = (HashMap) value.getValue();
            if (hashMap2 != null) {
                for (Entry value2 : hashMap2.entrySet()) {
                    ((ArrayList) value2.getValue()).clear();
                }
                hashMap2.clear();
            }
        }
        hashMap.clear();
    }

    private void g(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Entry value : hashMap.entrySet()) {
            arrayList.addAll(h((HashMap) value.getValue()));
        }
        Collections.sort(arrayList, new Comparator<aq>() {
            /* renamed from: a */
            public int compare(aq aqVar, aq aqVar2) {
                int i2 = ((aqVar.i() - aqVar2.i()) > 0 ? 1 : ((aqVar.i() - aqVar2.i()) == 0 ? 0 : -1));
                if (i2 > 0) {
                    return 1;
                }
                return i2 < 0 ? -1 : 0;
            }
        });
        a aVar = this.v;
        if (aVar != null) {
            aVar.b(arrayList);
        }
        aw.a().b(this.f1592a, arrayList);
    }

    private ArrayList<aq> h(HashMap<String, ArrayList<aq>> hashMap) {
        ArrayList<aq> arrayList = new ArrayList<>();
        for (Entry value : hashMap.entrySet()) {
            aq b2 = b((ArrayList) value.getValue());
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        return arrayList;
    }

    private void d(HashMap<WeakReference<View>, ArrayList<ap>> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Entry value : this.s.entrySet()) {
            ArrayList arrayList2 = (ArrayList) value.getValue();
            if (!(arrayList2 == null || arrayList2.size() == 0)) {
                arrayList.addAll(arrayList2);
            }
        }
        Collections.sort(arrayList, new Comparator<ap>() {
            /* renamed from: a */
            public int compare(ap apVar, ap apVar2) {
                int i2 = ((apVar.b() - apVar2.b()) > 0 ? 1 : ((apVar.b() - apVar2.b()) == 0 ? 0 : -1));
                if (i2 > 0) {
                    return 1;
                }
                return i2 < 0 ? -1 : 0;
            }
        });
        a aVar = this.v;
        if (aVar != null) {
            aVar.a(arrayList);
        }
        aw.a().a(this.f1592a, arrayList);
    }

    public void c(Activity activity) {
        if (activity != null) {
            final WeakReference weakReference = new WeakReference(activity);
            final long currentTimeMillis = System.currentTimeMillis();
            this.f1594c.post(new Runnable() {
                public void run() {
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null) {
                        at.this.c(activity, currentTimeMillis);
                    }
                }
            });
        }
    }

    public boolean b() {
        return this.f1597f == FeedTrackStrategy.TRACK_NONE;
    }

    public void b(Activity activity) {
        if (activity != null) {
            final WeakReference weakReference = new WeakReference(activity);
            final long currentTimeMillis = System.currentTimeMillis();
            this.f1594c.post(new Runnable() {
                public void run() {
                    at.this.f1595d = false;
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null) {
                        at.this.b(activity, currentTimeMillis);
                    }
                }
            });
        }
    }

    public static at a() {
        return u;
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f1600i = 0;
        String str = "";
        this.k = str;
        this.l = str;
        this.m = str;
        this.n = false;
        this.o = str;
    }

    public void a(FeedTrackStrategy feedTrackStrategy) {
        this.f1597f = feedTrackStrategy;
    }

    private boolean a(View view) {
        if (this.f1597f == FeedTrackStrategy.TRACK_ALL) {
            return false;
        }
        if (this.f1597f != FeedTrackStrategy.TRACK_SINGLE || !bj.v(view)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void b(Activity activity, long j2) {
        this.f1599h = j2;
        String e2 = bj.e(activity);
        this.f1601j = e2;
        if (!TextUtils.isEmpty(this.k) && !this.k.equals(e2)) {
            this.f1600i = 0;
        }
        if (this.p) {
            a(activity, this.f1598g, j2, this.r);
            this.r.clear();
            this.q = false;
        }
        a(this.s, this.t, j2);
        b(this.s);
        c(this.s);
        e(this.t);
        f(this.t);
        a(this.f1596e, this.w);
    }

    public void a(Activity activity) {
        if (activity != null) {
            final WeakReference weakReference = new WeakReference(activity);
            final long currentTimeMillis = System.currentTimeMillis();
            this.f1594c.post(new Runnable() {
                public void run() {
                    at.this.f1595d = true;
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null) {
                        at.this.a(activity, currentTimeMillis);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void c(Activity activity, long j2) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        View a2 = bj.a(activity);
        a(activity, a2, hashMap, arrayList, arrayList2);
        if (this.p && !this.q && a(this.f1598g, j2)) {
            ArrayList a3 = a(hashMap);
            a3.add(new WeakReference(a2));
            this.r = a3;
            this.q = true;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            a((View) it.next(), this.w, this.f1596e);
        }
        a(this.f1596e);
        if (this.f1595d) {
            a(this.f1593b, j2);
            this.f1595d = false;
        }
        a(this.s, j2);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            b((View) it2.next(), activity, j2);
        }
    }

    /* access modifiers changed from: private */
    public void a(Activity activity, long j2) {
        this.f1592a = activity.getApplicationContext();
        this.f1593b = new WeakReference<>(activity);
        this.f1598g = j2;
        String e2 = bj.e(activity);
        if (bj.a(e2, this.f1601j)) {
            this.p = false;
            if (a(e2, this.k, this.f1601j, this.f1600i, this.f1598g, activity)) {
                this.p = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(Activity activity, long j2) {
        b(this.t, j2);
        Iterator it = this.f1596e.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null) {
                View view = (View) weakReference.get();
                if (view != null && bj.d(view) && !a(view) && (view instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt != null && bj.d(childAt)) {
                            a(view, childAt, activity, j2);
                        }
                    }
                }
            }
        }
    }

    public void a(View view, Activity activity) {
        if (view != null && activity != null) {
            final WeakReference weakReference = new WeakReference(activity);
            final WeakReference weakReference2 = new WeakReference(view);
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f1594c;
            final View view2 = view;
            AnonymousClass8 r0 = new Runnable() {
                public void run() {
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null && ((View) weakReference2.get()) != null) {
                        at.this.a(view2, activity, currentTimeMillis);
                    }
                }
            };
            handler.post(r0);
        }
    }

    private void b(View view, Activity activity, long j2) {
        if (view != null && bj.d(view)) {
            ap apVar = new ap(bj.c(view, bj.e(activity)), j2, j2, j2, bj.r(view));
            a(this.s, view, apVar);
        }
    }

    public void a(KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.f1594c.post(new Runnable() {
                public void run() {
                    if (at.this.f1593b != null) {
                        Activity activity = (Activity) at.this.f1593b.get();
                        if (activity != null) {
                            String e2 = bj.e(activity);
                            if (!TextUtils.isEmpty(at.this.k) && at.this.k.equals(e2)) {
                                at.this.c();
                            }
                        }
                    }
                }
            });
        }
    }

    private void b(HashMap<WeakReference<View>, ArrayList<ap>> hashMap) {
        d(hashMap);
    }

    /* access modifiers changed from: private */
    public void a(View view, Activity activity, long j2) {
        View a2 = bj.a(view, activity);
        View n2 = bj.n(a2);
        if (n2 == null) {
            if (!this.p) {
                c();
            }
        } else if (a(n2)) {
            if (!this.p) {
                c();
            }
        } else {
            this.f1600i = j2;
            this.k = bj.e(activity);
            this.l = bj.s(a2);
            this.m = bj.c(n2, this.k);
            this.n = bj.r(n2);
            this.o = a(activity, a2, n2);
        }
    }

    private void b(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap, long j2) {
        if (hashMap != null && hashMap.size() != 0) {
            for (Entry value : hashMap.entrySet()) {
                HashMap hashMap2 = (HashMap) value.getValue();
                if (hashMap2 != null) {
                    for (Entry value2 : hashMap2.entrySet()) {
                        ArrayList arrayList = (ArrayList) value2.getValue();
                        if (!(arrayList == null || arrayList.size() == 0)) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                aq aqVar = (aq) it.next();
                                if (aqVar.k() == aqVar.j()) {
                                    aqVar.a(j2);
                                    aqVar.a(String.valueOf(aqVar.j() - aqVar.i()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void c(HashMap<WeakReference<View>, ArrayList<ap>> hashMap) {
        for (Entry value : hashMap.entrySet()) {
            ArrayList arrayList = (ArrayList) value.getValue();
            if (arrayList != null) {
                arrayList.clear();
            }
        }
        hashMap.clear();
    }

    public String a(Activity activity, View view, View view2) {
        String s2 = bj.s(view);
        String t2 = bj.t(view);
        String e2 = bj.e(activity);
        boolean r2 = bj.r(view2);
        return aq.a(t2, e2, bj.a(activity, view), s2, bj.a(view, bj.b(view2)), bj.c(view2, bj.e(activity)), r2);
    }

    private LinkedHashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> b(HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap, View view) {
        for (Entry entry : hashMap.entrySet()) {
            WeakReference weakReference = (WeakReference) entry.getKey();
            if (weakReference != null) {
                View view2 = (View) weakReference.get();
                if (view2 != null && view2 == view) {
                    LinkedHashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> linkedHashMap = new LinkedHashMap<>();
                    linkedHashMap.put(weakReference, (HashMap) entry.getValue());
                    return linkedHashMap;
                }
            }
        }
        return null;
    }

    public void a(final String str) {
        this.f1594c.post(new Runnable() {
            public void run() {
                as.a().a(str);
            }
        });
    }

    public void a(final WeakReference<Activity> weakReference) {
        if (weakReference != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            AnonymousClass12 r2 = new Runnable() {
                public void run() {
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null) {
                        at.this.d(activity, currentTimeMillis);
                    }
                }
            };
            Runnable runnable = this.x;
            if (runnable != null) {
                this.f1594c.removeCallbacks(runnable);
            }
            this.x = r2;
            this.f1594c.postDelayed(r2, 350);
        }
    }

    private aq b(ArrayList<aq> arrayList) {
        ArrayList<aq> arrayList2 = arrayList;
        aq aqVar = null;
        if (arrayList2 == null || arrayList.size() == 0) {
            return null;
        }
        Collections.sort(arrayList2, new Comparator<aq>() {
            /* renamed from: a */
            public int compare(aq aqVar, aq aqVar2) {
                int i2 = ((aqVar.i() - aqVar2.i()) > 0 ? 1 : ((aqVar.i() - aqVar2.i()) == 0 ? 0 : -1));
                if (i2 > 0) {
                    return 1;
                }
                return i2 < 0 ? -1 : 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i2 = 0;
        Iterator it = arrayList.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            aq aqVar2 = (aq) it.next();
            long i3 = aqVar2.i();
            String l2 = aqVar2.l();
            try {
                if (Long.valueOf(l2).longValue() < as.a().d()) {
                }
            } catch (Exception unused) {
            }
            if (j2 == 0) {
                aqVar = aqVar2;
                j2 = i3;
            }
            long j3 = i3 - j2;
            if (j3 < 0) {
                j3 = 0;
            }
            String str = "|";
            if (TextUtils.isEmpty(sb2.toString())) {
                sb2.append(l2);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(l2);
                sb2.append(sb3.toString());
            }
            if (TextUtils.isEmpty(sb.toString())) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(j3);
                sb.append(sb4.toString());
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(j3);
                sb.append(sb5.toString());
            }
            i2 += aqVar2.h();
        }
        if (aqVar != null) {
            aqVar.a(sb2.toString());
            aqVar.b(sb.toString());
            aqVar.a(i2);
        }
        return aqVar;
    }

    private void a(ArrayList<WeakReference<View>> arrayList, OnScrollChangedListener onScrollChangedListener) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            WeakReference weakReference = (WeakReference) arrayList.get(i2);
            if (weakReference != null) {
                a((View) weakReference.get(), onScrollChangedListener);
            }
        }
        arrayList.clear();
    }

    private void a(View view, OnScrollChangedListener onScrollChangedListener) {
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnScrollChangedListener(onScrollChangedListener);
            }
        }
    }

    private void a(ArrayList<WeakReference<View>> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference == null) {
                    arrayList2.add(weakReference);
                } else {
                    View view = (View) weakReference.get();
                    if (view == null) {
                        arrayList2.add(weakReference);
                    } else {
                        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                            arrayList2.add(weakReference);
                        }
                    }
                }
            }
            arrayList.removeAll(arrayList2);
        }
    }

    private void a(View view, OnScrollChangedListener onScrollChangedListener, ArrayList<WeakReference<View>> arrayList) {
        if (view != null && !a(arrayList, view) && !a(view)) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                try {
                    viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener);
                    arrayList.add(new WeakReference(view));
                } catch (Exception unused) {
                }
            }
        }
    }

    private boolean a(ArrayList<WeakReference<View>> arrayList, View view) {
        boolean z2 = false;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            } else if (view == ((WeakReference) arrayList.get(i2)).get()) {
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        return z2;
    }

    private boolean a(String str, String str2, String str3, long j2, long j3, Activity activity) {
        boolean z2 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !str.equals(str2) && str2.equals(str3)) {
            if (activity instanceof IIgnoreAutoTrace) {
                return false;
            }
            long j4 = j3 - j2;
            if (j4 > 0 && j4 < Config.BPLUS_DELAY_TIME) {
                z2 = true;
            }
        }
        return z2;
    }

    private void a(Activity activity, View view, HashMap<View, Integer> hashMap, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (view != null && !bj.c(activity, view)) {
            boolean m2 = bj.m(view);
            if (m2 && !a(view) && bj.d(view)) {
                arrayList.add(view);
            }
            if (m2) {
                arrayList2.add(view);
            }
            if (m2 || (view instanceof WebView) || (view instanceof ScrollView)) {
                int height = view.getHeight() * view.getWidth();
                if (height != 0) {
                    hashMap.put(view, Integer.valueOf(height));
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    a(activity, viewGroup.getChildAt(i2), hashMap, arrayList, arrayList2);
                }
            }
        }
    }

    private ArrayList<WeakReference<View>> a(HashMap<View, Integer> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new Comparator<Entry<View, Integer>>() {
            /* renamed from: a */
            public int compare(Entry<View, Integer> entry, Entry<View, Integer> entry2) {
                return ((Integer) entry2.getValue()).compareTo((Integer) entry.getValue());
            }
        });
        ArrayList<WeakReference<View>> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new WeakReference(((Entry) it.next()).getKey()));
        }
        return arrayList2;
    }

    private void a(Activity activity, long j2, long j3, List<WeakReference<View>> list) {
        Activity activity2 = activity;
        List<WeakReference<View>> list2 = list;
        if (list2 != null) {
            if (list.size() == 0) {
                list2.add(new WeakReference(bj.a(activity)));
            }
            View view = null;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null) {
                    View view2 = (View) weakReference.get();
                    if (view2 != null) {
                        view = view2;
                        break;
                    }
                }
            }
            if (!TextUtils.isEmpty(this.l)) {
                String str = this.m;
                if (!TextUtils.isEmpty(str)) {
                    String e2 = bj.e(activity);
                    String f2 = bj.f(activity);
                    ArrayList a2 = a(activity2, view);
                    int a3 = ah.a(this.f1592a, (float) ((Integer) a2.get(0)).intValue());
                    int a4 = ah.a(this.f1592a, (float) ((Integer) a2.get(1)).intValue());
                    ArrayList b2 = bj.b(activity2, view);
                    int a5 = ah.a(this.f1592a, (float) ((Integer) b2.get(0)).intValue());
                    int a6 = ah.a(this.f1592a, (float) ((Integer) b2.get(1)).intValue());
                    if (a5 > a3) {
                        a3 = a5;
                    }
                    if (a6 > a4) {
                        a4 = a6;
                    }
                    if (!(a3 == 0 || a4 == 0)) {
                        long j4 = j3 - j2;
                        float f3 = (float) a4;
                        long j5 = j2;
                        ao aoVar = r4;
                        ao aoVar2 = new ao(e2, f2, this.l, j4, j5, (float) a5, (float) a6, (float) a3, f3, str, this.n, this.o);
                        a(this.f1592a, aoVar);
                    }
                }
            }
        }
    }

    private void a(Context context, ao aoVar) {
        if (aoVar != null) {
            a aVar = this.v;
            if (aVar != null) {
                aVar.a(aoVar);
            }
            aw.a().a(context, aoVar);
        }
    }

    private void a(HashMap<WeakReference<View>, ArrayList<ap>> hashMap, long j2) {
        if (hashMap != null && hashMap.size() != 0) {
            for (Entry value : hashMap.entrySet()) {
                ArrayList arrayList = (ArrayList) value.getValue();
                if (!(arrayList == null || arrayList.size() == 0)) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ap apVar = (ap) it.next();
                        if (apVar.e() == apVar.c()) {
                            apVar.a(j2);
                        }
                    }
                }
            }
        }
    }

    private LinkedHashMap<WeakReference<View>, ArrayList<ap>> a(HashMap<WeakReference<View>, ArrayList<ap>> hashMap, View view) {
        for (Entry entry : hashMap.entrySet()) {
            WeakReference weakReference = (WeakReference) entry.getKey();
            if (weakReference != null) {
                View view2 = (View) weakReference.get();
                if (view2 != null && view2 == view) {
                    ArrayList arrayList = (ArrayList) entry.getValue();
                    LinkedHashMap<WeakReference<View>, ArrayList<ap>> linkedHashMap = new LinkedHashMap<>(1);
                    linkedHashMap.put(weakReference, arrayList);
                    return linkedHashMap;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.HashMap<java.lang.ref.WeakReference<android.view.View>, java.util.ArrayList<com.baidu.mobstat.ap>> r17, android.view.View r18, com.baidu.mobstat.ap r19) {
        /*
            r16 = this;
            java.lang.String r0 = r19.a()
            long r1 = r19.c()
            long r3 = r19.e()
            boolean r5 = r19.d()
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 == 0) goto L_0x0017
            return
        L_0x0017:
            java.util.LinkedHashMap r6 = r16.a(r17, r18)
            if (r6 == 0) goto L_0x0044
            int r8 = r6.size()
            if (r8 <= 0) goto L_0x0044
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0044
            java.lang.Object r6 = r6.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r8 = r6.getKey()
            java.lang.ref.WeakReference r8 = (java.lang.ref.WeakReference) r8
            java.lang.Object r6 = r6.getValue()
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            goto L_0x0046
        L_0x0044:
            r6 = 0
            r8 = 0
        L_0x0046:
            if (r6 == 0) goto L_0x007d
            java.util.Iterator r9 = r6.iterator()
        L_0x004c:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x007d
            java.lang.Object r10 = r9.next()
            com.baidu.mobstat.ap r10 = (com.baidu.mobstat.ap) r10
            java.lang.String r11 = r10.a()
            long r12 = r10.c()
            long r14 = r10.e()
            boolean r7 = r10.d()
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L_0x006f
            goto L_0x004c
        L_0x006f:
            if (r5 == r7) goto L_0x0072
            goto L_0x004c
        L_0x0072:
            int r7 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x007b
            int r7 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r7 == 0) goto L_0x007b
            goto L_0x004c
        L_0x007b:
            r7 = r10
            goto L_0x007e
        L_0x007d:
            r7 = 0
        L_0x007e:
            if (r7 != 0) goto L_0x009b
            if (r6 != 0) goto L_0x0087
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0087:
            r0 = r19
            r6.add(r0)
            if (r8 != 0) goto L_0x0095
            java.lang.ref.WeakReference r8 = new java.lang.ref.WeakReference
            r0 = r18
            r8.<init>(r0)
        L_0x0095:
            r0 = r17
            r0.put(r8, r6)
            goto L_0x00a1
        L_0x009b:
            r7.a(r1)
            r7.b(r3)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.at.a(java.util.HashMap, android.view.View, com.baidu.mobstat.ap):void");
    }

    private void a(View view, View view2, Activity activity, long j2) {
        View view3 = view;
        View view4 = view2;
        if (view3 != null && view4 != null && bj.a(view4, as.a().c())) {
            String s2 = bj.s(view2);
            String t2 = bj.t(view2);
            String e2 = bj.e(activity);
            boolean r2 = bj.r(view);
            aq aqVar = new aq(t2, e2, bj.a(activity, view4), s2, bj.a(view4, bj.b(view)), bj.c(view3, bj.e(activity)), r2, 1, j2, j2, j2, String.valueOf(j2 - j2), "");
            a(this.t, view3, aqVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.HashMap<java.lang.ref.WeakReference<android.view.View>, java.util.HashMap<java.lang.String, java.util.ArrayList<com.baidu.mobstat.aq>>> r19, android.view.View r20, com.baidu.mobstat.aq r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r21
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            long r3 = r21.k()
            long r5 = r21.j()
            java.lang.String r7 = r21.d()
            java.lang.String r8 = r21.f()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0104
            boolean r7 = android.text.TextUtils.isEmpty(r8)
            if (r7 == 0) goto L_0x0027
            goto L_0x0104
        L_0x0027:
            java.util.LinkedHashMap r7 = r18.b(r19, r20)
            r8 = 0
            if (r7 == 0) goto L_0x0055
            int r9 = r7.size()
            if (r9 <= 0) goto L_0x0055
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0055
            java.lang.Object r7 = r7.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r9 = r7.getKey()
            java.lang.ref.WeakReference r9 = (java.lang.ref.WeakReference) r9
            java.lang.Object r7 = r7.getValue()
            java.util.HashMap r7 = (java.util.HashMap) r7
            goto L_0x0057
        L_0x0055:
            r7 = r8
            r9 = r7
        L_0x0057:
            if (r7 == 0) goto L_0x00aa
            java.util.Set r10 = r7.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0061:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00aa
            java.lang.Object r11 = r10.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r11 = r11.getValue()
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            if (r11 == 0) goto L_0x0061
            int r12 = r11.size()
            if (r12 != 0) goto L_0x007c
            goto L_0x0061
        L_0x007c:
            java.util.Iterator r11 = r11.iterator()
        L_0x0080:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0061
            java.lang.Object r12 = r11.next()
            com.baidu.mobstat.aq r12 = (com.baidu.mobstat.aq) r12
            long r13 = r12.k()
            long r15 = r12.j()
            boolean r17 = r0.a(r12, r2)
            if (r17 != 0) goto L_0x009b
            goto L_0x0080
        L_0x009b:
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L_0x00a8
            long r13 = r21.j()
            int r13 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r13 == 0) goto L_0x00a8
            goto L_0x0080
        L_0x00a8:
            r8 = r12
            goto L_0x0061
        L_0x00aa:
            if (r8 != 0) goto L_0x00ee
            java.lang.String r3 = r0.a(r2)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x00b7
            return
        L_0x00b7:
            if (r7 != 0) goto L_0x00d6
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r5.add(r2)
            r4.put(r3, r5)
            if (r9 != 0) goto L_0x00d0
            java.lang.ref.WeakReference r9 = new java.lang.ref.WeakReference
            r9.<init>(r1)
        L_0x00d0:
            r1 = r19
            r1.put(r9, r4)
            goto L_0x0104
        L_0x00d6:
            java.lang.Object r1 = r7.get(r3)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            if (r1 != 0) goto L_0x00ea
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r2)
            r7.put(r3, r1)
            goto L_0x0104
        L_0x00ea:
            r1.add(r2)
            goto L_0x0104
        L_0x00ee:
            r8.a(r5)
            r8.b(r3)
            long r1 = r8.j()
            long r3 = r8.i()
            long r1 = r1 - r3
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r8.a(r1)
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.at.a(java.util.HashMap, android.view.View, com.baidu.mobstat.aq):void");
    }

    private boolean a(aq aqVar, aq aqVar2) {
        String a2 = aqVar2.a();
        String b2 = aqVar2.b();
        JSONArray c2 = aqVar2.c();
        String d2 = aqVar2.d();
        String e2 = aqVar2.e();
        String f2 = aqVar2.f();
        boolean g2 = aqVar2.g();
        String a3 = aqVar.a();
        String b3 = aqVar.b();
        JSONArray c3 = aqVar.c();
        String d3 = aqVar.d();
        String e3 = aqVar.e();
        String f3 = aqVar.f();
        boolean g3 = aqVar.g();
        if (a(a3, a2) && a(b3, b2) && a(c3, c2) && a(d3, d2) && a(e3, e2) && a(f3, f2) && g3 == g2) {
            return true;
        }
        return false;
    }

    private boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2);
    }

    private boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null || jSONArray2 == null) {
            return false;
        }
        return a(jSONArray.toString(), jSONArray2.toString());
    }

    private String a(aq aqVar) {
        return aq.a(aqVar.a(), aqVar.b(), aqVar.c(), aqVar.d(), aqVar.e(), aqVar.f(), aqVar.g());
    }

    private void a(WeakReference<Activity> weakReference, long j2) {
        if (weakReference != null) {
            Activity activity = (Activity) weakReference.get();
            if (activity != null) {
                d(activity, j2);
            }
        }
    }

    private void a(HashMap<WeakReference<View>, ArrayList<ap>> hashMap, HashMap<WeakReference<View>, HashMap<String, ArrayList<aq>>> hashMap2, long j2) {
        for (Entry value : hashMap.entrySet()) {
            ArrayList arrayList = (ArrayList) value.getValue();
            if (!(arrayList == null || arrayList.size() == 0)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ap apVar = (ap) it.next();
                    if (apVar.e() == apVar.c()) {
                        apVar.a(j2);
                    }
                }
            }
        }
        for (Entry value2 : hashMap2.entrySet()) {
            HashMap hashMap3 = (HashMap) value2.getValue();
            if (!(hashMap3 == null || hashMap3.size() == 0)) {
                for (Entry value3 : hashMap3.entrySet()) {
                    ArrayList arrayList2 = (ArrayList) value3.getValue();
                    if (!(arrayList2 == null || arrayList2.size() == 0)) {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            aq aqVar = (aq) it2.next();
                            if (aqVar.k() == aqVar.j()) {
                                aqVar.a(j2);
                                aqVar.a(String.valueOf(aqVar.j() - aqVar.i()));
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(Activity activity, final WebView webView) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                synchronized (at.this.A) {
                    at.this.y = (float) webView.getContentHeight();
                    at.this.z = webView.getScale();
                    at.this.A.notifyAll();
                }
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.Integer> a(android.app.Activity r8, android.view.View r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            if (r9 == 0) goto L_0x009f
            if (r8 != 0) goto L_0x0010
            goto L_0x009f
        L_0x0010:
            int r2 = r9.getWidth()
            int r3 = r9.getHeight()
            boolean r4 = r9 instanceof android.webkit.WebView
            if (r4 == 0) goto L_0x0036
            java.lang.Object r4 = r7.A
            monitor-enter(r4)
            android.webkit.WebView r9 = (android.webkit.WebView) r9     // Catch:{ all -> 0x0033 }
            r7.a(r8, r9)     // Catch:{ all -> 0x0033 }
            java.lang.Object r8 = r7.A     // Catch:{ Exception -> 0x002b }
            r5 = 5000(0x1388, double:2.4703E-320)
            r8.wait(r5)     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            float r8 = r7.y     // Catch:{ all -> 0x0033 }
            float r9 = r7.z     // Catch:{ all -> 0x0033 }
            float r8 = r8 * r9
            int r8 = (int) r8     // Catch:{ all -> 0x0033 }
            monitor-exit(r4)     // Catch:{ all -> 0x0033 }
            goto L_0x005d
        L_0x0033:
            r8 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0033 }
            throw r8
        L_0x0036:
            boolean r8 = r9 instanceof android.widget.ScrollView
            if (r8 == 0) goto L_0x0053
            android.widget.ScrollView r9 = (android.widget.ScrollView) r9
            int r8 = r9.getChildCount()
            if (r8 <= 0) goto L_0x007f
            android.view.View r8 = r9.getChildAt(r1)
            int r8 = r8.getWidth()
            android.view.View r9 = r9.getChildAt(r1)
            int r9 = r9.getHeight()
            goto L_0x0081
        L_0x0053:
            boolean r8 = r9 instanceof android.widget.ListView
            if (r8 == 0) goto L_0x0060
            android.widget.ListView r9 = (android.widget.ListView) r9
            int r8 = com.baidu.mobstat.bj.a(r9)
        L_0x005d:
            r9 = r8
            r8 = r1
            goto L_0x0081
        L_0x0060:
            boolean r8 = r9 instanceof android.widget.GridView
            if (r8 == 0) goto L_0x006b
            android.widget.GridView r9 = (android.widget.GridView) r9
            int r8 = com.baidu.mobstat.bj.a(r9)
            goto L_0x005d
        L_0x006b:
            boolean r8 = com.baidu.mobstat.bj.q(r9)
            if (r8 == 0) goto L_0x007f
            androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9     // Catch:{ Exception -> 0x007c }
            int r8 = r9.computeHorizontalScrollRange()     // Catch:{ Exception -> 0x007c }
            int r9 = r9.computeVerticalScrollRange()     // Catch:{ Exception -> 0x007d }
            goto L_0x0081
        L_0x007c:
            r8 = r1
        L_0x007d:
            r9 = r1
            goto L_0x0081
        L_0x007f:
            r8 = r1
            r9 = r8
        L_0x0081:
            if (r8 != 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r2 = r8
        L_0x0085:
            if (r9 != 0) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            r3 = r9
        L_0x0089:
            if (r2 <= 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r2 = r1
        L_0x008d:
            if (r3 <= 0) goto L_0x0090
            r1 = r3
        L_0x0090:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            r0.add(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            r0.add(r8)
            return r0
        L_0x009f:
            r0.add(r2)
            r0.add(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.at.a(android.app.Activity, android.view.View):java.util.ArrayList");
    }
}
