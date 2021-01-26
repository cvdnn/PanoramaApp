package d.k.g.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import d.k.b;
import d.k.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DataBinderMapperImpl */
public class a extends b {

    /* renamed from: a reason: collision with root package name */
    public static final SparseIntArray f5042a = new SparseIntArray(0);

    public ViewDataBinding a(d dVar, View view, int i2) {
        if (f5042a.get(i2) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding a(d dVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f5042a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public List<b> a() {
        return new ArrayList(0);
    }
}
