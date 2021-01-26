package e.c.d.e;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import d.k.e;

/* compiled from: NavigationBarBinding */
public abstract class k0 extends ViewDataBinding {
    public final ImageButton n;
    public final View o;
    public final RelativeLayout p;
    public final TextView q;

    public k0(Object obj, View view, int i2, ImageButton imageButton, View view2, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, i2);
        this.n = imageButton;
        this.o = view2;
        this.p = relativeLayout;
        this.q = textView;
    }

    public static k0 a(View view) {
        return (k0) e.a(ViewDataBinding.a((Object) e.f5040b), view, R.layout.navigation_bar);
    }
}
