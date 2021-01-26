package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.spinphoto.SpinPhotoActivity;
import com.baidu.picapture.ui.widget.SpinView;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;
import e.c.d.m.i.e;

/* compiled from: ActivitySpinPhotoBindingImpl */
public class t extends s implements OnExtClickListener {
    public static final SparseIntArray v;
    public final ConstraintLayout r;
    public final OnClickListener s;
    public final OnClickListener t;
    public long u = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R.id.spin_view, 3);
    }

    public t(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 4, (c) null, v);
        super(dVar, view, 0, (Button) a2[1], (Button) a2[2], (SpinView) a2[3]);
        this.n.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) a2[0];
        this.r = constraintLayout;
        constraintLayout.setTag(null);
        this.o.setTag(null);
        view.setTag(a.dataBinding, this);
        this.s = new e.c.d.h.a.a(this, 1);
        this.t = new e.c.d.h.a.a(this, 2);
        f();
    }

    public void a(SpinPhotoActivity spinPhotoActivity) {
        this.q = spinPhotoActivity;
        synchronized (this) {
            this.u |= 1;
        }
        a(2);
        super.g();
    }

    public void b() {
        long j2;
        synchronized (this) {
            j2 = this.u;
            this.u = 0;
        }
        if ((j2 & 2) != 0) {
            this.n.setOnClickListener(this.s);
            this.o.setOnClickListener(this.t);
        }
    }

    public boolean e() {
        synchronized (this) {
            if (this.u != 0) {
                return true;
            }
            return false;
        }
    }

    public void f() {
        synchronized (this) {
            this.u = 2;
        }
        g();
    }

    public final void onExtClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            SpinPhotoActivity spinPhotoActivity = this.q;
            if (spinPhotoActivity != null) {
                z = true;
            }
            if (z) {
                spinPhotoActivity.finish();
            }
        } else if (i2 == 2) {
            SpinPhotoActivity spinPhotoActivity2 = this.q;
            if (spinPhotoActivity2 != null) {
                z = true;
            }
            if (z) {
                SpinView spinView = ((s) spinPhotoActivity2.r).p;
                spinView.f6844a.f();
                spinView.f2008c.c(e.f6796a);
            }
        }
    }
}
