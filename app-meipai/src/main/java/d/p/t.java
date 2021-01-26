package d.p;

import java.util.HashMap;

/* compiled from: ViewModelStore */
public class t {

    /* renamed from: a reason: collision with root package name */
    public final HashMap<String, q> f5293a = new HashMap<>();

    public final void a() {
        for (q a2 : this.f5293a.values()) {
            a2.a();
        }
        this.f5293a.clear();
    }
}
