package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.widget.dialog.AppUpdateDialog;
import d.k.e;

/* compiled from: AppUpdateDialogBinding */
public abstract class g0 extends ViewDataBinding {
    public final TextView n;
    public final ImageView o;
    public final TextView p;
    public AppUpdateDialog q;

    public g0(Object obj, View view, int i2, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, i2);
        this.n = textView;
        this.o = imageView;
        this.p = textView2;
    }

    public static g0 a(LayoutInflater layoutInflater) {
        return (g0) ViewDataBinding.a(layoutInflater, (int) R.layout.app_update_dialog, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(AppUpdateDialog appUpdateDialog);
}
