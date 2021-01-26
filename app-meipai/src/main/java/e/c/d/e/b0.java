package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.hotspot.preview.HotSpotPreviewActivity;
import d.k.e;

/* compiled from: ActivitySpotPreviewBinding */
public abstract class b0 extends ViewDataBinding {
    public final Button n;
    public final View o;
    public final EditText p;
    public final EditText q;
    public final RelativeLayout r;
    public final RelativeLayout s;
    public final ImageView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public HotSpotPreviewActivity y;
    public Boolean z;

    public b0(Object obj, View view, int i2, Button button, View view2, EditText editText, EditText editText2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.n = button;
        this.o = view2;
        this.p = editText;
        this.q = editText2;
        this.r = relativeLayout;
        this.s = relativeLayout2;
        this.t = imageView;
        this.u = textView;
        this.v = textView2;
        this.w = textView3;
        this.x = textView4;
    }

    public static b0 a(LayoutInflater layoutInflater) {
        return (b0) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_spot_preview, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(HotSpotPreviewActivity hotSpotPreviewActivity);

    public abstract void b(Boolean bool);
}
