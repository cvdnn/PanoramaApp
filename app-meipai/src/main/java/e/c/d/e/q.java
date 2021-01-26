package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.spin.device.SpinDeviceActivity;
import d.k.e;

/* compiled from: ActivitySpinDeviceBinding */
public abstract class q extends ViewDataBinding {
    public SpinDeviceActivity A;
    public final TextView n;
    public final LinearLayout o;
    public final ListView p;
    public final LinearLayout q;
    public final LinearLayout r;
    public final LinearLayout s;
    public final k0 t;
    public final TextView u;
    public final Button v;
    public final LinearLayout w;
    public final ConstraintLayout x;
    public final ImageView y;
    public final TextView z;

    public q(Object obj, View view, int i2, TextView textView, LinearLayout linearLayout, ListView listView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, k0 k0Var, TextView textView2, Button button, LinearLayout linearLayout5, ConstraintLayout constraintLayout, ImageView imageView, TextView textView3) {
        k0 k0Var2 = k0Var;
        super(obj, view, i2);
        this.n = textView;
        this.o = linearLayout;
        this.p = listView;
        this.q = linearLayout2;
        this.r = linearLayout3;
        this.s = linearLayout4;
        this.t = k0Var2;
        if (k0Var2 != null) {
            k0Var2.f931i = this;
        }
        this.u = textView2;
        this.v = button;
        this.w = linearLayout5;
        this.x = constraintLayout;
        this.y = imageView;
        this.z = textView3;
    }

    public static q a(LayoutInflater layoutInflater) {
        return (q) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_spin_device, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(SpinDeviceActivity spinDeviceActivity);
}
