package d.n.a;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import d.e.a;
import java.util.ArrayList;

/* compiled from: FragmentTransition */
public final class u implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a0 f5223a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ a f5224b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ Object f5225c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ v.a f5226d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ ArrayList f5227e;

    /* renamed from: f reason: collision with root package name */
    public final /* synthetic */ View f5228f;

    /* renamed from: g reason: collision with root package name */
    public final /* synthetic */ Fragment f5229g;

    /* renamed from: h reason: collision with root package name */
    public final /* synthetic */ Fragment f5230h;

    /* renamed from: i reason: collision with root package name */
    public final /* synthetic */ boolean f5231i;

    /* renamed from: j reason: collision with root package name */
    public final /* synthetic */ ArrayList f5232j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Rect l;

    public u(a0 a0Var, a aVar, Object obj, v.a aVar2, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f5223a = a0Var;
        this.f5224b = aVar;
        this.f5225c = obj;
        this.f5226d = aVar2;
        this.f5227e = arrayList;
        this.f5228f = view;
        this.f5229g = fragment;
        this.f5230h = fragment2;
        this.f5231i = z;
        this.f5232j = arrayList2;
        this.k = obj2;
        this.l = rect;
    }

    public void run() {
        a a2 = v.a(this.f5223a, this.f5224b, this.f5225c, this.f5226d);
        if (a2 != null) {
            this.f5227e.addAll(a2.values());
            this.f5227e.add(this.f5228f);
        }
        v.a(this.f5229g, this.f5230h, this.f5231i, a2, false);
        Object obj = this.f5225c;
        if (obj != null) {
            this.f5223a.b(obj, this.f5232j, this.f5227e);
            View a3 = v.a(a2, this.f5226d, this.k, this.f5231i);
            if (a3 != null) {
                this.f5223a.a(a3, this.l);
            }
        }
    }
}
