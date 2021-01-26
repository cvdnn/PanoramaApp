package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.widget.bdwebview.BDWebView;
import d.k.e;

/* compiled from: ActivityHomeBinding */
public abstract class a extends ViewDataBinding {
    public final TextView n;
    public final BDWebView o;
    public Boolean p;

    public a(Object obj, View view, int i2, TextView textView, BDWebView bDWebView) {
        super(obj, view, i2);
        this.n = textView;
        this.o = bDWebView;
    }

    public static a a(LayoutInflater layoutInflater) {
        return (a) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_home, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void b(Boolean bool);
}
