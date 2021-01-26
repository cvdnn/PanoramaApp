package e.d.a.o;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import d.n.a.d;
import d.n.a.i;
import e.d.a.j;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever */
public class l implements Callback {

    /* renamed from: i reason: collision with root package name */
    public static final b f7818i = new a();

    /* renamed from: a reason: collision with root package name */
    public volatile j f7819a;

    /* renamed from: b reason: collision with root package name */
    public final Map<FragmentManager, k> f7820b = new HashMap();

    /* renamed from: c reason: collision with root package name */
    public final Map<i, o> f7821c = new HashMap();

    /* renamed from: d reason: collision with root package name */
    public final Handler f7822d;

    /* renamed from: e reason: collision with root package name */
    public final b f7823e;

    /* renamed from: f reason: collision with root package name */
    public final d.e.a<View, Fragment> f7824f = new d.e.a<>();

    /* renamed from: g reason: collision with root package name */
    public final d.e.a<View, android.app.Fragment> f7825g = new d.e.a<>();

    /* renamed from: h reason: collision with root package name */
    public final Bundle f7826h = new Bundle();

    /* compiled from: RequestManagerRetriever */
    public class a implements b {
    }

    /* compiled from: RequestManagerRetriever */
    public interface b {
    }

    public l(b bVar) {
        if (bVar == null) {
            bVar = f7818i;
        }
        this.f7823e = bVar;
        this.f7822d = new Handler(Looper.getMainLooper(), this);
    }

    public static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean d(Context context) {
        Activity c2 = c(context);
        return c2 == null || !c2.isFinishing();
    }

    public j a(Context context) {
        if (context != null) {
            if (e.d.a.t.j.c() && !(context instanceof Application)) {
                if (context instanceof d) {
                    return a((d) context);
                }
                if (context instanceof Activity) {
                    return a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return a(contextWrapper.getBaseContext());
                    }
                }
            }
            return b(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public final j b(Context context) {
        if (this.f7819a == null) {
            synchronized (this) {
                if (this.f7819a == null) {
                    e.d.a.b a2 = e.d.a.b.a(context.getApplicationContext());
                    b bVar = this.f7823e;
                    b bVar2 = new b();
                    g gVar = new g();
                    Context applicationContext = context.getApplicationContext();
                    if (((a) bVar) != null) {
                        this.f7819a = new j(a2, bVar2, gVar, applicationContext);
                    } else {
                        throw null;
                    }
                }
            }
        }
        return this.f7819a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r6) {
        /*
            r5 = this;
            int r0 = r6.what
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0018
            r3 = 2
            if (r0 == r3) goto L_0x000c
            r2 = 0
            r6 = r1
            goto L_0x0026
        L_0x000c:
            java.lang.Object r6 = r6.obj
            r1 = r6
            d.n.a.i r1 = (d.n.a.i) r1
            java.util.Map<d.n.a.i, e.d.a.o.o> r6 = r5.f7821c
            java.lang.Object r6 = r6.remove(r1)
            goto L_0x0023
        L_0x0018:
            java.lang.Object r6 = r6.obj
            r1 = r6
            android.app.FragmentManager r1 = (android.app.FragmentManager) r1
            java.util.Map<android.app.FragmentManager, e.d.a.o.k> r6 = r5.f7820b
            java.lang.Object r6 = r6.remove(r1)
        L_0x0023:
            r4 = r1
            r1 = r6
            r6 = r4
        L_0x0026:
            if (r2 == 0) goto L_0x0047
            if (r1 != 0) goto L_0x0047
            r0 = 5
            java.lang.String r1 = "RMRetriever"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L_0x0047
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Failed to remove expected request manager fragment, manager: "
            r0.append(r3)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            android.util.Log.w(r1, r6)
        L_0x0047:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.o.l.handleMessage(android.os.Message):boolean");
    }

    public j a(d dVar) {
        if (e.d.a.t.j.b()) {
            return a(dVar.getApplicationContext());
        }
        if (!dVar.isDestroyed()) {
            return a((Context) dVar, dVar.b0(), (Fragment) null, d(dVar));
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    public j a(Activity activity) {
        if (e.d.a.t.j.b()) {
            return a(activity.getApplicationContext());
        }
        if (!activity.isDestroyed()) {
            return a((Context) activity, activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    public static void a(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment fragment : collection) {
                if (!(fragment == null || fragment.getView() == null)) {
                    map.put(fragment.getView(), fragment);
                    a((Collection<Fragment>) fragment.getChildFragmentManager().a(), map);
                }
            }
        }
    }

    @TargetApi(26)
    @Deprecated
    public final void a(FragmentManager fragmentManager, d.e.a<View, android.app.Fragment> aVar) {
        if (VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    aVar.put(fragment.getView(), fragment);
                    a(fragment.getChildFragmentManager(), aVar);
                }
            }
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            String str = "key";
            this.f7826h.putInt(str, i2);
            android.app.Fragment fragment2 = null;
            try {
                fragment2 = fragmentManager.getFragment(this.f7826h, str);
            } catch (Exception unused) {
            }
            if (fragment2 != null) {
                if (fragment2.getView() != null) {
                    aVar.put(fragment2.getView(), fragment2);
                    a(fragment2.getChildFragmentManager(), aVar);
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    public final k a(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        String str = "com.bumptech.glide.manager";
        k kVar = (k) fragmentManager.findFragmentByTag(str);
        if (kVar == null) {
            kVar = (k) this.f7820b.get(fragmentManager);
            if (kVar == null) {
                kVar = new k();
                kVar.f7816f = fragment;
                if (!(fragment == null || fragment.getActivity() == null)) {
                    kVar.a(fragment.getActivity());
                }
                if (z) {
                    kVar.f7811a.b();
                }
                this.f7820b.put(fragmentManager, kVar);
                fragmentManager.beginTransaction().add(kVar, str).commitAllowingStateLoss();
                this.f7822d.obtainMessage(1, fragmentManager).sendToTarget();
            }
        }
        return kVar;
    }

    @Deprecated
    public final j a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        k a2 = a(fragmentManager, fragment, z);
        j jVar = a2.f7814d;
        if (jVar != null) {
            return jVar;
        }
        e.d.a.b a3 = e.d.a.b.a(context);
        b bVar = this.f7823e;
        a aVar = a2.f7811a;
        m mVar = a2.f7812b;
        if (((a) bVar) != null) {
            j jVar2 = new j(a3, aVar, mVar, context);
            a2.f7814d = jVar2;
            return jVar2;
        }
        throw null;
    }

    public final o a(i iVar, Fragment fragment, boolean z) {
        String str = "com.bumptech.glide.manager";
        o oVar = (o) iVar.a(str);
        if (oVar == null) {
            oVar = (o) this.f7821c.get(iVar);
            if (oVar == null) {
                oVar = new o();
                oVar.f7835f = fragment;
                if (!(fragment == null || fragment.getContext() == null)) {
                    Fragment fragment2 = fragment;
                    while (fragment2.getParentFragment() != null) {
                        fragment2 = fragment2.getParentFragment();
                    }
                    i fragmentManager = fragment2.getFragmentManager();
                    if (fragmentManager != null) {
                        oVar.a(fragment.getContext(), fragmentManager);
                    }
                }
                if (z) {
                    oVar.f7830a.b();
                }
                this.f7821c.put(iVar, oVar);
                d.n.a.a aVar = new d.n.a.a((d.n.a.j) iVar);
                aVar.a(0, oVar, str, 1);
                aVar.a();
                this.f7822d.obtainMessage(2, iVar).sendToTarget();
            }
        }
        return oVar;
    }

    public final j a(Context context, i iVar, Fragment fragment, boolean z) {
        o a2 = a(iVar, fragment, z);
        j jVar = a2.f7834e;
        if (jVar != null) {
            return jVar;
        }
        e.d.a.b a3 = e.d.a.b.a(context);
        b bVar = this.f7823e;
        a aVar = a2.f7830a;
        m mVar = a2.f7831b;
        if (((a) bVar) != null) {
            j jVar2 = new j(a3, aVar, mVar, context);
            a2.f7834e = jVar2;
            return jVar2;
        }
        throw null;
    }
}
