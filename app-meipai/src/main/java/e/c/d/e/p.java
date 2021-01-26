package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.picapture.ui.spin.capture.SpinCaptureActivity;
import com.baidu.picapture.ui.widget.CircleProgressBar;
import com.baidu.picapture.ui.widget.GuideView;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;
import e.c.d.m.e.a.s;

/* compiled from: ActivitySpinCaptureBindingLandImpl */
public class p extends n implements OnExtClickListener {
    public static final SparseIntArray S;
    public final ConstraintLayout L;
    public final OnClickListener M;
    public final OnClickListener N;
    public final OnClickListener O;
    public final OnClickListener P;
    public final OnClickListener Q;
    public long R = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        S = sparseIntArray;
        sparseIntArray.put(R.id.camera_preview, 11);
        S.put(R.id.focus_rect, 12);
        S.put(R.id.preview_cover, 13);
        S.put(R.id.focus_pop_tips, 14);
        S.put(R.id.focus_pop_tip_bg, 15);
        S.put(R.id.capture_focus_anim, 16);
        S.put(R.id.mid_area, 17);
        S.put(R.id.task_progress, 18);
        S.put(R.id.task_progress_current, 19);
        S.put(R.id.task_progress_total, 20);
    }

    public p(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 21, (c) null, S);
        super(dVar, view, 0, (Button) a2[3], (FrameLayout) a2[11], (LottieAnimationView) a2[16], (DiscreteScrollView) a2[5], null, (TextView) a2[15], (ConstraintLayout) a2[14], (LottieAnimationView) a2[12], (GuideView) a2[1], (RelativeLayout) a2[17], (View) a2[13], (TextView) a2[8], (CircleProgressBar) a2[18], (TextView) a2[19], (LinearLayout) a2[9], (TextView) a2[20], (Button) a2[4], (ImageView) a2[6], (Switch) a2[7], (ImageView) a2[10], (ImageView) a2[2]);
        this.n.setTag(null);
        this.q.setTag(null);
        this.v.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) a2[0];
        this.L = constraintLayout;
        constraintLayout.setTag(null);
        this.tv4.setTag(null);
        this.B.setTag(null);
        this.D.setTag(null);
        this.E.setTag(null);
        this.F.setTag(null);
        this.G.setTag(null);
        this.H.setTag(null);
        view.setTag(a.dataBinding, this);
        this.M = new e.c.d.h.a.a(this, 4);
        this.N = new e.c.d.h.a.a(this, 2);
        this.O = new e.c.d.h.a.a(this, 1);
        this.P = new e.c.d.h.a.a(this, 5);
        this.Q = new e.c.d.h.a.a(this, 3);
        f();
    }

    public void a(SpinCaptureActivity spinCaptureActivity) {
        this.I = spinCaptureActivity;
        synchronized (this) {
            this.R |= 2;
        }
        a(2);
        super.g();
    }

    public void b(Boolean bool) {
        this.J = bool;
        synchronized (this) {
            this.R |= 1;
        }
        a(6);
        super.g();
    }

    public void c(Boolean bool) {
        this.K = bool;
        synchronized (this) {
            this.R |= 4;
        }
        a(12);
        super.g();
    }

    public boolean e() {
        synchronized (this) {
            if (this.R != 0) {
                return true;
            }
            return false;
        }
    }

    public void f() {
        synchronized (this) {
            this.R = 8;
        }
        g();
    }

    public final void onExtClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            SpinCaptureActivity spinCaptureActivity = this.I;
            if (spinCaptureActivity != null) {
                z = true;
            }
            if (z) {
                spinCaptureActivity.userGuide();
            }
        } else if (i2 == 2) {
            SpinCaptureActivity spinCaptureActivity2 = this.I;
            if (spinCaptureActivity2 != null) {
                z = true;
            }
            if (z) {
                ((s) spinCaptureActivity2.s).C();
            }
        } else if (i2 == 3) {
            SpinCaptureActivity spinCaptureActivity3 = this.I;
            if (spinCaptureActivity3 != null) {
                z = true;
            }
            if (z) {
                spinCaptureActivity3.k0();
            }
        } else if (i2 == 4) {
            SpinCaptureActivity spinCaptureActivity4 = this.I;
            if (spinCaptureActivity4 != null) {
                z = true;
            }
            if (z) {
                spinCaptureActivity4.k0();
            }
        } else if (i2 == 5) {
            SpinCaptureActivity spinCaptureActivity5 = this.I;
            if (spinCaptureActivity5 != null) {
                z = true;
            }
            if (z) {
                ((s) spinCaptureActivity5.s).i();
            }
        }
    }

    public void b() {
        long j2;
        boolean z;
        int i2;
        synchronized (this) {
            j2 = this.R;
            this.R = 0;
        }
        Boolean bool = this.J;
        Boolean bool2 = this.K;
        int i3 = 4;
        int i4 = 0;
        if ((j2 & 13) != 0) {
            boolean a2 = ViewDataBinding.a(bool);
            if ((j2 & 9) != 0) {
                j2 |= a2 ? 128 : 64;
            }
            z = !a2;
            if ((j2 & 13) != 0) {
                j2 |= z ? 32 : 16;
            }
            i2 = ((j2 & 9) == 0 || !a2) ? 0 : 4;
        } else {
            i2 = 0;
            z = false;
        }
        int i5 = ((j2 & 13) > 0 ? 1 : ((j2 & 13) == 0 ? 0 : -1));
        if (i5 != 0) {
            boolean a3 = ViewDataBinding.a(Boolean.valueOf(z ? bool2.booleanValue() : false));
            if (i5 != 0) {
                j2 |= a3 ? 512 : 256;
            }
            if (a3) {
                i3 = 0;
            }
            i4 = i3;
        }
        if ((8 & j2) != 0) {
            this.n.setOnClickListener(this.N);
            this.tv4.setOnClickListener(this.Q);
            this.B.setOnClickListener(this.M);
            this.G.setOnClickListener(this.P);
            this.H.setOnClickListener(this.O);
        }
        if ((j2 & 9) != 0) {
            this.q.setVisibility(i2);
            this.D.setVisibility(i2);
            this.E.setVisibility(i2);
            this.F.setVisibility(i2);
            this.G.setVisibility(i2);
            this.H.setVisibility(i2);
        }
        if ((j2 & 13) != 0) {
            this.v.setVisibility(i4);
        }
    }
}
