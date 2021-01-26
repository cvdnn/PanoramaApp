package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.hotspot.simplepreview.HotSpotSimplePreviewActivity;
import d.k.e;

/* compiled from: ActivityHotSpotSimplePreviewBinding */
public abstract class c extends ViewDataBinding {
    public final Button n;
    public final ImageView o;
    public HotSpotSimplePreviewActivity p;

    public c(Object obj, View view, int i2, Button button, ImageView imageView) {
        super(obj, view, i2);
        this.n = button;
        this.o = imageView;
    }

    public static c a(LayoutInflater layoutInflater) {
        return (c) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_hot_spot_simple_preview, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(HotSpotSimplePreviewActivity hotSpotSimplePreviewActivity);
}
