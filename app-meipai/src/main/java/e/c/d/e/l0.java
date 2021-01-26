package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.baidu.picapture.R;
import d.k.d;
import d.k.g.a;

/* compiled from: NavigationBarBindingImpl */
public class l0 extends k0 {
    public static final SparseIntArray s;
    public long r = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        s = sparseIntArray;
        sparseIntArray.put(R.id.btn_back, 1);
        s.put(R.id.navigation_bar_title, 2);
        s.put(R.id.divider, 3);
    }

    public l0(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 4, (c) null, s);
        super(dVar, view, 0, (ImageButton) a2[1], (View) a2[3], (RelativeLayout) a2[0], (TextView) a2[2]);
        this.p.setTag(null);
        view.setTag(a.dataBinding, this);
        f();
    }

    public void b() {
        synchronized (this) {
            this.r = 0;
        }
    }

    public boolean e() {
        synchronized (this) {
            if (this.r != 0) {
                return true;
            }
            return false;
        }
    }

    public void f() {
        synchronized (this) {
            this.r = 1;
        }
        g();
    }
}
