package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.spin.preview.SpinPreviewActivity;
import com.baidu.picapture.ui.widget.SpinView;
import d.k.e;

/* compiled from: ActivitySpinPreviewBinding */
public abstract class v extends ViewDataBinding {
    public final View n;
    public final RelativeLayout o;
    public final TextView p;
    public final TextView q;
    public final LinearLayout r;
    public final Button s;
    public final SpinView t;
    public final FrameLayout u;
    public SpinPreviewActivity v;

    public v(Object obj, View view, int i2, View view2, RelativeLayout relativeLayout, TextView textView, TextView textView2, LinearLayout linearLayout, Button button, SpinView spinView, FrameLayout frameLayout) {
        super(obj, view, i2);
        this.n = view2;
        this.o = relativeLayout;
        this.p = textView;
        this.q = textView2;
        this.r = linearLayout;
        this.s = button;
        this.t = spinView;
        this.u = frameLayout;
    }

    public static v a(LayoutInflater layoutInflater) {
        return (v) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_spin_preview, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(SpinPreviewActivity spinPreviewActivity);
}
