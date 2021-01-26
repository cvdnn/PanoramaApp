package e.d.a.o;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;
import e.d.a.b;
import e.d.a.j;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* compiled from: RequestManagerFragment */
public class k extends Fragment {

    /* renamed from: a reason: collision with root package name */
    public final a f7811a;

    /* renamed from: b reason: collision with root package name */
    public final m f7812b = new a();

    /* renamed from: c reason: collision with root package name */
    public final Set<k> f7813c = new HashSet();

    /* renamed from: d reason: collision with root package name */
    public j f7814d;

    /* renamed from: e reason: collision with root package name */
    public k f7815e;

    /* renamed from: f reason: collision with root package name */
    public Fragment f7816f;

    /* compiled from: RequestManagerFragment */
    public class a implements m {
        public a() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{fragment=");
            sb.append(k.this);
            sb.append("}");
            return sb.toString();
        }
    }

    public k() {
        a aVar = new a();
        this.f7811a = aVar;
    }

    public final void a(Activity activity) {
        a();
        l lVar = b.a((Context) activity).f7088f;
        if (lVar != null) {
            k a2 = lVar.a(activity.getFragmentManager(), (Fragment) null, l.d(activity));
            this.f7815e = a2;
            if (!equals(a2)) {
                this.f7815e.f7813c.add(this);
                return;
            }
            return;
        }
        throw null;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e2) {
            String str = "RMFragment";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f7811a.a();
        a();
    }

    public void onDetach() {
        super.onDetach();
        a();
    }

    public void onStart() {
        super.onStart();
        this.f7811a.b();
    }

    public void onStop() {
        super.onStop();
        this.f7811a.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f7816f;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }

    public final void a() {
        k kVar = this.f7815e;
        if (kVar != null) {
            kVar.f7813c.remove(this);
            this.f7815e = null;
        }
    }
}
