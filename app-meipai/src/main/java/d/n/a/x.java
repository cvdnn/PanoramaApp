package d.n.a;

import android.view.View;
import d.h.k.m;
import java.util.ArrayList;

/* compiled from: FragmentTransitionImpl */
public class x implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ int f5253a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ ArrayList f5254b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ ArrayList f5255c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ ArrayList f5256d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ ArrayList f5257e;

    public x(a0 a0Var, int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f5253a = i2;
        this.f5254b = arrayList;
        this.f5255c = arrayList2;
        this.f5256d = arrayList3;
        this.f5257e = arrayList4;
    }

    public void run() {
        for (int i2 = 0; i2 < this.f5253a; i2++) {
            m.a((View) this.f5254b.get(i2), (String) this.f5255c.get(i2));
            ((View) this.f5256d.get(i2)).setTransitionName((String) this.f5257e.get(i2));
        }
    }
}
