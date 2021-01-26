package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.hotspot.capture.HotSpotCaptureActivity;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;
import e.c.d.m.c.a.e;

/* compiled from: ActivityHotspotCaptureBindingImpl */
public class f extends e implements OnExtClickListener {
    public static final SparseIntArray A;
    public final ConstraintLayout w;
    public final OnClickListener x;
    public final OnClickListener y;
    public long z = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R.id.top, 3);
        A.put(R.id.hotspot_camera_preview, 4);
        A.put(R.id.focus_rect, 5);
        A.put(R.id.top_mask, 6);
        A.put(R.id.bottom_mask, 7);
    }

    public f(d dVar, View view) {
        View view2 = view;
        Object[] a2 = ViewDataBinding.a(dVar, view2, 8, (c) null, A);
        super(dVar, view, 0, (Button) a2[1], (View) a2[7], (LottieAnimationView) a2[5], (FrameLayout) a2[4], (Button) a2[2], (FrameLayout) a2[3], (View) a2[6]);
        this.n.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) a2[0];
        this.w = constraintLayout;
        constraintLayout.setTag(null);
        this.r.setTag(null);
        view2.setTag(a.dataBinding, this);
        this.x = new e.c.d.h.a.a(this, 2);
        this.y = new e.c.d.h.a.a(this, 1);
        f();
    }

    public void a(HotSpotCaptureActivity hotSpotCaptureActivity) {
        this.v = hotSpotCaptureActivity;
        synchronized (this) {
            this.z |= 1;
        }
        a(2);
        super.g();
    }

    public void b(Boolean bool) {
        this.u = bool;
        synchronized (this) {
            this.z |= 2;
        }
        a(3);
        super.g();
    }

    public boolean e() {
        synchronized (this) {
            if (this.z != 0) {
                return true;
            }
            return false;
        }
    }

    public void f() {
        synchronized (this) {
            this.z = 4;
        }
        g();
    }

    public final void onExtClick(int i2, View view) {
        boolean z2 = false;
        if (i2 == 1) {
            HotSpotCaptureActivity hotSpotCaptureActivity = this.v;
            if (hotSpotCaptureActivity != null) {
                z2 = true;
            }
            if (z2) {
                hotSpotCaptureActivity.i0();
            }
        } else if (i2 == 2) {
            HotSpotCaptureActivity hotSpotCaptureActivity2 = this.v;
            if (hotSpotCaptureActivity2 != null) {
                z2 = true;
            }
            if (z2) {
                ((e) hotSpotCaptureActivity2.r).b(Boolean.valueOf(true));
                ((e) hotSpotCaptureActivity2.s).c();
            }
        }
    }

    public void b() {
        long j2;
        synchronized (this) {
            j2 = this.z;
            this.z = 0;
        }
        boolean z2 = false;
        Boolean bool = this.u;
        int i2 = ((6 & j2) > 0 ? 1 : ((6 & j2) == 0 ? 0 : -1));
        if (i2 != 0) {
            z2 = ViewDataBinding.a(Boolean.valueOf(!ViewDataBinding.a(bool)));
        }
        if (i2 != 0) {
            this.n.setEnabled(z2);
            this.r.setEnabled(z2);
        }
        if ((j2 & 4) != 0) {
            this.n.setOnClickListener(this.y);
            this.r.setOnClickListener(this.x);
        }
    }
}
