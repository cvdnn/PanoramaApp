package d.t;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18 */
public class e0 implements f0 {

    /* renamed from: a reason: collision with root package name */
    public final WindowId f5482a;

    public e0(View view) {
        this.f5482a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof e0) && ((e0) obj).f5482a.equals(this.f5482a);
    }

    public int hashCode() {
        return this.f5482a.hashCode();
    }
}
