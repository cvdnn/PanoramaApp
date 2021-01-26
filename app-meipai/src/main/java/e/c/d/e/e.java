package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.hotspot.capture.HotSpotCaptureActivity;

/* compiled from: ActivityHotspotCaptureBinding */
public abstract class e extends ViewDataBinding {
    public final Button n;
    public final View o;
    public final LottieAnimationView p;
    public final FrameLayout q;
    public final Button r;
    public final FrameLayout s;
    public final View t;
    public Boolean u;
    public HotSpotCaptureActivity v;

    public e(Object obj, View view, int i2, Button button, View view2, LottieAnimationView lottieAnimationView, FrameLayout frameLayout, Button button2, FrameLayout frameLayout2, View view3) {
        super(obj, view, i2);
        this.n = button;
        this.o = view2;
        this.p = lottieAnimationView;
        this.q = frameLayout;
        this.r = button2;
        this.s = frameLayout2;
        this.t = view3;
    }

    public static e a(LayoutInflater layoutInflater) {
        return (e) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_hotspot_capture, (ViewGroup) null, false, (Object) d.k.e.f5040b);
    }

    public abstract void a(HotSpotCaptureActivity hotSpotCaptureActivity);

    public abstract void b(Boolean bool);
}
