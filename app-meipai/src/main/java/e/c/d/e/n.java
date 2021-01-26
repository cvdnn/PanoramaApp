package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.spin.capture.SpinCaptureActivity;
import com.baidu.picapture.ui.widget.CircleProgressBar;
import com.baidu.picapture.ui.widget.GuideView;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import d.k.e;

/* compiled from: ActivitySpinCaptureBinding */
public abstract class n extends ViewDataBinding {
    public final TextView tv1;
    public final LinearLayout B;
    public final TextView tv2;
    public final Button D;
    public final ImageView E;
    public final Switch F;
    public final ImageView G;
    public final ImageView H;
    public SpinCaptureActivity I;
    public Boolean J;
    public Boolean K;
    public final Button n;
    public final FrameLayout o;
    public final LottieAnimationView p;
    public final DiscreteScrollView q;
    public final FrameLayout r;
    public final TextView tv3;
    public final ConstraintLayout t;
    public final LottieAnimationView u;
    public final GuideView v;
    public final RelativeLayout w;
    public final View x;
    public final TextView tv4;
    public final CircleProgressBar mCircleProgressBar;

    public n(Object obj, View view, int i2, Button button, FrameLayout frameLayout, LottieAnimationView lottieAnimationView, DiscreteScrollView discreteScrollView, FrameLayout frameLayout2, TextView textView, ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView2, GuideView guideView, RelativeLayout relativeLayout, View view2, TextView textView2, CircleProgressBar circleProgressBar, TextView textView3, LinearLayout linearLayout, TextView textView4, Button button2, ImageView imageView, Switch switchR, ImageView imageView2, ImageView imageView3) {
        super(obj, view, i2);
        this.n = button;
        this.o = frameLayout;
        this.p = lottieAnimationView;
        this.q = discreteScrollView;
        this.r = frameLayout2;
        this.tv3 = textView;
        this.t = constraintLayout;
        this.u = lottieAnimationView2;
        this.v = guideView;
        this.w = relativeLayout;
        this.x = view2;
        this.tv4 = textView2;
        this.mCircleProgressBar = circleProgressBar;
        this.tv1 = textView3;
        this.B = linearLayout;
        this.tv2 = textView4;
        this.D = button2;
        this.E = imageView;
        this.F = switchR;
        this.G = imageView2;
        this.H = imageView3;
    }

    public static n a(LayoutInflater layoutInflater) {
        return (n) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_spin_capture, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(SpinCaptureActivity spinCaptureActivity);

    public abstract void b(Boolean bool);

    public abstract void c(Boolean bool);
}
