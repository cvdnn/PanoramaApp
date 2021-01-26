package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.arashivision.sdkmedia.player.capture.InstaCapturePlayerView;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.panorama.capture.PanoramaCaptureActivity;
import com.jaygoo.widget.RangeSeekBar;
import d.k.e;

/* compiled from: ActivityPanoramaCaptureBinding */
public abstract class g extends ViewDataBinding {
    public final RangeSeekBar A;
    public final LinearLayout B;
    public final ImageView C;
    public final RecyclerView D;
    public final RecyclerView E;
    public final InstaCapturePlayerView F;
    public final ImageView G;
    public final View H;
    public final LinearLayout I;
    public final ImageView J;
    public final RecyclerView K;
    public final Button L;
    public final LinearLayout M;
    public final ImageView N;
    public final RecyclerView O;
    public PanoramaCaptureActivity P;
    public Boolean Q;
    public Boolean R;
    public Boolean S;
    public Boolean T;
    public Boolean U;
    public Boolean V;
    public Boolean W;
    public Boolean X;
    public Boolean Y;
    public Boolean Z;
    public Boolean a0;
    public Boolean b0;
    public Boolean c0;
    public final Button n;
    public final View o;
    public final ImageView p;
    public final TextView q;
    public final LinearLayout r;
    public final ImageView s;
    public final RecyclerView t;
    public final LinearLayout u;
    public final ImageView v;
    public final RecyclerView w;
    public final ConstraintLayout x;
    public final ImageView y;
    public final TextView z;

    public g(Object obj, View view, int i2, Button button, View view2, ImageView imageView, TextView textView, LinearLayout linearLayout, ImageView imageView2, RecyclerView recyclerView, LinearLayout linearLayout2, ImageView imageView3, RecyclerView recyclerView2, ConstraintLayout constraintLayout, ImageView imageView4, TextView textView2, RangeSeekBar rangeSeekBar, LinearLayout linearLayout3, ImageView imageView5, RecyclerView recyclerView3, RecyclerView recyclerView4, InstaCapturePlayerView instaCapturePlayerView, ImageView imageView6, View view3, LinearLayout linearLayout4, ImageView imageView7, RecyclerView recyclerView5, Button button2, LinearLayout linearLayout5, ImageView imageView8, RecyclerView recyclerView6) {
        super(obj, view, i2);
        this.n = button;
        this.o = view2;
        this.p = imageView;
        this.q = textView;
        this.r = linearLayout;
        this.s = imageView2;
        this.t = recyclerView;
        this.u = linearLayout2;
        this.v = imageView3;
        this.w = recyclerView2;
        this.x = constraintLayout;
        this.y = imageView4;
        this.z = textView2;
        this.A = rangeSeekBar;
        this.B = linearLayout3;
        this.C = imageView5;
        this.D = recyclerView3;
        this.E = recyclerView4;
        this.F = instaCapturePlayerView;
        this.G = imageView6;
        this.H = view3;
        this.I = linearLayout4;
        this.J = imageView7;
        this.K = recyclerView5;
        this.L = button2;
        this.M = linearLayout5;
        this.N = imageView8;
        this.O = recyclerView6;
    }

    public static g a(LayoutInflater layoutInflater) {
        return (g) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_panorama_capture, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(PanoramaCaptureActivity panoramaCaptureActivity);

    public abstract void b(Boolean bool);

    public abstract void c(Boolean bool);

    public abstract void d(Boolean bool);

    public abstract void e(Boolean bool);

    public abstract void f(Boolean bool);

    public abstract void g(Boolean bool);

    public abstract void h(Boolean bool);

    public abstract void i(Boolean bool);

    public abstract void j(Boolean bool);

    public abstract void k(Boolean bool);

    public abstract void l(Boolean bool);

    public abstract void m(Boolean bool);

    public abstract void n(Boolean bool);
}
