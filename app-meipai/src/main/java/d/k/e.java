package d.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;

/* compiled from: DataBindingUtil */
public class e {

    /* renamed from: a reason: collision with root package name */
    public static b f5039a = new c();

    /* renamed from: b reason: collision with root package name */
    public static d f5040b = null;

    public static <T extends ViewDataBinding> T a(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, boolean z, d dVar) {
        T t;
        boolean z2 = viewGroup != null && z;
        int childCount = z2 ? viewGroup.getChildCount() : 0;
        View inflate = layoutInflater.inflate(i2, viewGroup, z);
        if (!z2) {
            return a(dVar, inflate, i2);
        }
        int childCount2 = viewGroup.getChildCount();
        int i3 = childCount2 - childCount;
        if (i3 == 1) {
            t = a(dVar, viewGroup.getChildAt(childCount2 - 1), i2);
        } else {
            View[] viewArr = new View[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                viewArr[i4] = viewGroup.getChildAt(i4 + childCount);
            }
            t = f5039a.a(dVar, viewArr, i2);
        }
        return t;
    }

    public static <T extends ViewDataBinding> T a(d dVar, View view, int i2) {
        return f5039a.a(dVar, view, i2);
    }
}
