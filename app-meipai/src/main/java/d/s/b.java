package d.s;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry$1;
import d.c.a.b.b.d;
import d.p.e;
import d.p.i;
import java.util.Map.Entry;

/* compiled from: SavedStateRegistryController */
public final class b {

    /* renamed from: a reason: collision with root package name */
    public final c f5428a;

    /* renamed from: b reason: collision with root package name */
    public final a f5429b = new a();

    public b(c cVar) {
        this.f5428a = cVar;
    }

    public void a(Bundle bundle) {
        e lifecycle = this.f5428a.getLifecycle();
        if (((i) lifecycle).f5281b == d.p.e.b.INITIALIZED) {
            lifecycle.a(new Recreator(this.f5428a));
            a aVar = this.f5429b;
            if (!aVar.f5426c) {
                if (bundle != null) {
                    aVar.f5425b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                lifecycle.a(new SavedStateRegistry$1(aVar));
                aVar.f5426c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void b(Bundle bundle) {
        a aVar = this.f5429b;
        if (aVar != null) {
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = aVar.f5425b;
            if (bundle3 != null) {
                bundle2.putAll(bundle3);
            }
            d a2 = aVar.f5424a.a();
            while (a2.hasNext()) {
                Entry entry = (Entry) a2.next();
                bundle2.putBundle((String) entry.getKey(), ((d.s.a.b) entry.getValue()).saveState());
            }
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
            return;
        }
        throw null;
    }
}
