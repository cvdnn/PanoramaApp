package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.spin.preview.SpinPreviewActivity;
import com.baidu.picapture.ui.widget.SpinView;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;
import e.c.d.m.e.d.g;
import e.c.d.m.i.e;

/* compiled from: ActivitySpinPreviewBindingLandImpl */
public class x extends v implements OnExtClickListener {
    public static final SparseIntArray B;
    public long A = -1;
    public final ConstraintLayout w;
    public final OnClickListener x;
    public final OnClickListener y;
    public final OnClickListener z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        B = sparseIntArray;
        sparseIntArray.put(R.id.spin_view, 4);
        B.put(R.id.preview_rotate_tip, 5);
        B.put(R.id.divider, 6);
        B.put(R.id.fl_bottom, 7);
    }

    public x(d dVar, View view) {
        View view2 = view;
        Object[] a2 = ViewDataBinding.a(dVar, view2, 8, (c) null, B);
        super(dVar, view, 0, (View) a2[6], (RelativeLayout) a2[7], (TextView) a2[2], (TextView) a2[3], (LinearLayout) a2[5], (Button) a2[1], (SpinView) a2[4], null);
        this.p.setTag(null);
        this.q.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) a2[0];
        this.w = constraintLayout;
        constraintLayout.setTag(null);
        this.s.setTag(null);
        view2.setTag(a.dataBinding, this);
        this.x = new e.c.d.h.a.a(this, 2);
        this.y = new e.c.d.h.a.a(this, 3);
        this.z = new e.c.d.h.a.a(this, 1);
        f();
    }

    public void a(SpinPreviewActivity spinPreviewActivity) {
        this.v = spinPreviewActivity;
        synchronized (this) {
            this.A |= 1;
        }
        a(2);
        super.g();
    }

    public void b() {
        long j2;
        synchronized (this) {
            j2 = this.A;
            this.A = 0;
        }
        if ((j2 & 2) != 0) {
            this.p.setOnClickListener(this.x);
            this.q.setOnClickListener(this.y);
            this.s.setOnClickListener(this.z);
        }
    }

    public boolean e() {
        synchronized (this) {
            if (this.A != 0) {
                return true;
            }
            return false;
        }
    }

    public void f() {
        synchronized (this) {
            this.A = 2;
        }
        g();
    }

    public final void onExtClick(int i2, View view) {
        boolean z2 = false;
        if (i2 == 1) {
            SpinPreviewActivity spinPreviewActivity = this.v;
            if (spinPreviewActivity != null) {
                z2 = true;
            }
            if (z2) {
                SpinView spinView = ((v) spinPreviewActivity.r).t;
                spinView.f6844a.f();
                spinView.f2008c.c(e.f6796a);
            }
        } else if (i2 == 2) {
            SpinPreviewActivity spinPreviewActivity2 = this.v;
            if (spinPreviewActivity2 != null) {
                z2 = true;
            }
            if (z2) {
                ((g) spinPreviewActivity2.s).b();
            }
        } else if (i2 == 3) {
            SpinPreviewActivity spinPreviewActivity3 = this.v;
            if (spinPreviewActivity3 != null) {
                z2 = true;
            }
            if (z2) {
                spinPreviewActivity3.j0();
            }
        }
    }
}
