package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.panorama.guide.PanoramaGuideActivity;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import d.k.e;

/* compiled from: ActivityPanoramaGuideBinding */
public abstract class i extends ViewDataBinding {
    public final Banner n;
    public final Button o;
    public final k0 p;
    public final CircleIndicator q;
    public PanoramaGuideActivity r;

    public i(Object obj, View view, int i2, Banner banner, Button button, k0 k0Var, CircleIndicator circleIndicator) {
        super(obj, view, i2);
        this.n = banner;
        this.o = button;
        this.p = k0Var;
        if (k0Var != null) {
            k0Var.f931i = this;
        }
        this.q = circleIndicator;
    }

    public static i a(LayoutInflater layoutInflater) {
        return (i) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_panorama_guide, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(PanoramaGuideActivity panoramaGuideActivity);
}
