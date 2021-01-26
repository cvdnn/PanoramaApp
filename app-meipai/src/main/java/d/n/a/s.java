package d.n.a;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* compiled from: FragmentTransition */
public final class s implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Object f5208a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ a0 f5209b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ View f5210c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ Fragment f5211d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ ArrayList f5212e;

    /* renamed from: f reason: collision with root package name */
    public final /* synthetic */ ArrayList f5213f;

    /* renamed from: g reason: collision with root package name */
    public final /* synthetic */ ArrayList f5214g;

    /* renamed from: h reason: collision with root package name */
    public final /* synthetic */ Object f5215h;

    public s(Object obj, a0 a0Var, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f5208a = obj;
        this.f5209b = a0Var;
        this.f5210c = view;
        this.f5211d = fragment;
        this.f5212e = arrayList;
        this.f5213f = arrayList2;
        this.f5214g = arrayList3;
        this.f5215h = obj2;
    }

    public void run() {
        Object obj = this.f5208a;
        if (obj != null) {
            this.f5209b.b(obj, this.f5210c);
            this.f5213f.addAll(v.a(this.f5209b, this.f5208a, this.f5211d, this.f5212e, this.f5210c));
        }
        if (this.f5214g != null) {
            if (this.f5215h != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f5210c);
                this.f5209b.a(this.f5215h, this.f5214g, arrayList);
            }
            this.f5214g.clear();
            this.f5214g.add(this.f5210c);
        }
    }
}
