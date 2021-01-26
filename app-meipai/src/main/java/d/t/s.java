package d.t;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils */
public class s {

    /* renamed from: a reason: collision with root package name */
    public static boolean f5518a = true;

    public static void a(ViewGroup viewGroup, boolean z) {
        if (VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (f5518a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f5518a = false;
            }
        }
    }
}
