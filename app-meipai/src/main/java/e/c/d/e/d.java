package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.hotspot.simplepreview.HotSpotSimplePreviewActivity;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;
import e.c.d.m.c.c.b;

/* compiled from: ActivityHotSpotSimplePreviewBindingImpl */
public class d extends c implements OnExtClickListener {
    public static final SparseIntArray v;
    public final ConstraintLayout q;
    public final ImageButton r;
    public final OnClickListener s;
    public final OnClickListener t;
    public long u = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R.id.image, 3);
    }

    public d(d.k.d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 4, (c) null, v);
        super(dVar, view, 0, (Button) a2[1], (ImageView) a2[3]);
        this.n.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) a2[0];
        this.q = constraintLayout;
        constraintLayout.setTag(null);
        ImageButton imageButton = (ImageButton) a2[2];
        this.r = imageButton;
        imageButton.setTag(null);
        view.setTag(a.dataBinding, this);
        this.s = new e.c.d.h.a.a(this, 2);
        this.t = new e.c.d.h.a.a(this, 1);
        f();
    }

    public void a(HotSpotSimplePreviewActivity hotSpotSimplePreviewActivity) {
        this.p = hotSpotSimplePreviewActivity;
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
            this.n.setOnClickListener(this.t);
            this.r.setOnClickListener(this.s);
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
            HotSpotSimplePreviewActivity hotSpotSimplePreviewActivity = this.p;
            if (hotSpotSimplePreviewActivity != null) {
                z = true;
            }
            if (z) {
                hotSpotSimplePreviewActivity.finish();
            }
        } else if (i2 == 2) {
            HotSpotSimplePreviewActivity hotSpotSimplePreviewActivity2 = this.p;
            if (hotSpotSimplePreviewActivity2 != null) {
                z = true;
            }
            if (z) {
                ((b) hotSpotSimplePreviewActivity2.s).w();
            }
        }
    }
}
