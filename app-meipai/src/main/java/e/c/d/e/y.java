package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.spin.detail.SpinDetailActivity;
import com.baidu.picapture.ui.widget.CircleProgressBar;
import com.baidu.picapture.ui.widget.HotGridView;
import d.k.e;

/* compiled from: ActivitySpinTaskDetailBinding */
public abstract class y extends ViewDataBinding {
    public final Button n;
    public final ImageView o;
    public final TextView p;
    public final HotGridView q;
    public final k0 r;
    public final LinearLayout s;
    public final FrameLayout t;
    public final CircleProgressBar u;
    public SpinDetailActivity v;
    public Boolean w;
    public Boolean x;
    public Boolean y;
    public Boolean z;

    public y(Object obj, View view, int i2, Button button, ImageView imageView, TextView textView, HotGridView hotGridView, k0 k0Var, LinearLayout linearLayout, FrameLayout frameLayout, CircleProgressBar circleProgressBar) {
        super(obj, view, i2);
        this.n = button;
        this.o = imageView;
        this.p = textView;
        this.q = hotGridView;
        this.r = k0Var;
        if (k0Var != null) {
            k0Var.f931i = this;
        }
        this.s = linearLayout;
        this.t = frameLayout;
        this.u = circleProgressBar;
    }

    public static y a(LayoutInflater layoutInflater) {
        return (y) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_spin_task_detail, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(SpinDetailActivity spinDetailActivity);

    public abstract void b(Boolean bool);

    public abstract void c(Boolean bool);

    public abstract void d(Boolean bool);

    public abstract void e(Boolean bool);
}
