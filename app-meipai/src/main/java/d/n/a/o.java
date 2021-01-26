package d.n.a;

import android.util.Log;
import androidx.fragment.app.Fragment;
import d.p.q;
import d.p.r;
import d.p.t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: FragmentManagerViewModel */
public class o extends q {

    /* renamed from: h reason: collision with root package name */
    public static final r f5172h = new a();

    /* renamed from: b reason: collision with root package name */
    public final HashSet<Fragment> f5173b = new HashSet<>();

    /* renamed from: c reason: collision with root package name */
    public final HashMap<String, o> f5174c = new HashMap<>();

    /* renamed from: d reason: collision with root package name */
    public final HashMap<String, t> f5175d = new HashMap<>();

    /* renamed from: e reason: collision with root package name */
    public final boolean f5176e;

    /* renamed from: f reason: collision with root package name */
    public boolean f5177f = false;

    /* renamed from: g reason: collision with root package name */
    public boolean f5178g = false;

    /* compiled from: FragmentManagerViewModel */
    public static class a implements r {
        public <T extends q> T a(Class<T> cls) {
            return new o(true);
        }
    }

    public o(boolean z) {
        this.f5176e = z;
    }

    public boolean a(Fragment fragment) {
        if (!this.f5173b.contains(fragment)) {
            return true;
        }
        if (this.f5176e) {
            return this.f5177f;
        }
        return !this.f5178g;
    }

    public void b() {
        if (j.G) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCleared called for ");
            sb.append(this);
            Log.d("FragmentManager", sb.toString());
        }
        this.f5177f = true;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (!this.f5173b.equals(oVar.f5173b) || !this.f5174c.equals(oVar.f5174c) || !this.f5175d.equals(oVar.f5175d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f5175d.hashCode() + ((this.f5174c.hashCode() + (this.f5173b.hashCode() * 31)) * 31);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f5173b.iterator();
        while (true) {
            str = ", ";
            if (!it.hasNext()) {
                break;
            }
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f5174c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(str);
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f5175d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(str);
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
