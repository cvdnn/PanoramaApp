package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.widget.bdwebview.BDWebView;
import d.k.d;
import d.k.g.a;

/* compiled from: ActivityHomeBindingImpl */
public class b extends a {
    public static final SparseIntArray t;
    public final ConstraintLayout q;
    public final ConstraintLayout r;
    public long s = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.webView, 2);
        t.put(R.id.loading_text, 3);
    }

    public b(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 4, (c) null, t);
        super(dVar, view, 0, (TextView) a2[3], (BDWebView) a2[2]);
        ConstraintLayout constraintLayout = (ConstraintLayout) a2[0];
        this.q = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a2[1];
        this.r = constraintLayout2;
        constraintLayout2.setTag(null);
        view.setTag(a.dataBinding, this);
        f();
    }

    public void b(Boolean bool) {
        this.p = bool;
        synchronized (this) {
            this.s |= 1;
        }
        a(14);
        super.g();
    }

    public boolean e() {
        synchronized (this) {
            if (this.s != 0) {
                return true;
            }
            return false;
        }
    }

    public void f() {
        synchronized (this) {
            this.s = 2;
        }
        g();
    }

    public void b() {
        long j2;
        synchronized (this) {
            j2 = this.s;
            this.s = 0;
        }
        Boolean bool = this.p;
        int i2 = ((j2 & 3) > 0 ? 1 : ((j2 & 3) == 0 ? 0 : -1));
        int i3 = 0;
        if (i2 != 0) {
            boolean a2 = ViewDataBinding.a(bool);
            if (i2 != 0) {
                j2 |= a2 ? 8 : 4;
            }
            if (!a2) {
                i3 = 4;
            }
        }
        if ((j2 & 3) != 0) {
            this.r.setVisibility(i3);
        }
    }
}
