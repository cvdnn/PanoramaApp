package d.t;

import android.view.View;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues */
public class q {

    /* renamed from: a reason: collision with root package name */
    public final Map<String, Object> f5511a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    public View f5512b;

    /* renamed from: c reason: collision with root package name */
    public final ArrayList<i> f5513c = new ArrayList<>();

    @Deprecated
    public q() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f5512b == qVar.f5512b && this.f5511a.equals(qVar.f5511a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f5511a.hashCode() + (this.f5512b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder a2 = a.a("TransitionValues@");
        a2.append(Integer.toHexString(hashCode()));
        a2.append(":\n");
        StringBuilder b2 = a.b(a2.toString(), "    view = ");
        b2.append(this.f5512b);
        String str = "\n";
        b2.append(str);
        String a3 = a.a(b2.toString(), "    values:");
        for (String str2 : this.f5511a.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(a3);
            sb.append("    ");
            sb.append(str2);
            sb.append(": ");
            sb.append(this.f5511a.get(str2));
            sb.append(str);
            a3 = sb.toString();
        }
        return a3;
    }

    public q(View view) {
        this.f5512b = view;
    }
}
