package e.d.a.o;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import d.n.a.i;
import e.d.a.b;
import e.d.a.j;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SupportRequestManagerFragment */
public class o extends Fragment {

    /* renamed from: a reason: collision with root package name */
    public final a f7830a;

    /* renamed from: b reason: collision with root package name */
    public final m f7831b = new a();

    /* renamed from: c reason: collision with root package name */
    public final Set<o> f7832c = new HashSet();

    /* renamed from: d reason: collision with root package name */
    public o f7833d;

    /* renamed from: e reason: collision with root package name */
    public j f7834e;

    /* renamed from: f reason: collision with root package name */
    public Fragment f7835f;

    /* compiled from: SupportRequestManagerFragment */
    public class a implements m {
        public a() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{fragment=");
            sb.append(o.this);
            sb.append("}");
            return sb.toString();
        }
    }

    public o() {
        a aVar = new a();
        this.f7830a = aVar;
    }

    public final Fragment a() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f7835f;
    }

    public final void b() {
        o oVar = this.f7833d;
        if (oVar != null) {
            oVar.f7832c.remove(this);
            this.f7833d = null;
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        i fragmentManager = fragment.getFragmentManager();
        String str = "SupportRMFragment";
        if (fragmentManager == null) {
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Unable to register fragment with root, ancestor detached");
            }
            return;
        }
        try {
            a(getContext(), fragmentManager);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f7830a.a();
        b();
    }

    public void onDetach() {
        super.onDetach();
        this.f7835f = null;
        b();
    }

    public void onStart() {
        super.onStart();
        this.f7830a.b();
    }

    public void onStop() {
        super.onStop();
        this.f7830a.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        sb.append(a());
        sb.append("}");
        return sb.toString();
    }

    public final void a(Context context, i iVar) {
        b();
        l lVar = b.a(context).f7088f;
        if (lVar != null) {
            o a2 = lVar.a(iVar, (Fragment) null, l.d(context));
            this.f7833d = a2;
            if (!equals(a2)) {
                this.f7833d.f7832c.add(this);
                return;
            }
            return;
        }
        throw null;
    }
}
