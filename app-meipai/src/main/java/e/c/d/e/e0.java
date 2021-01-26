package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.widget.dialog.AppForceUpdateDialog;
import d.k.e;

/* compiled from: AppForceUpdateDialogBinding */
public abstract class e0 extends ViewDataBinding {
    public final TextView n;
    public final TextView o;
    public AppForceUpdateDialog p;

    public e0(Object obj, View view, int i2, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.n = textView;
        this.o = textView2;
    }

    public static e0 a(LayoutInflater layoutInflater) {
        return (e0) ViewDataBinding.a(layoutInflater, (int) R.layout.app_force_update_dialog, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(AppForceUpdateDialog appForceUpdateDialog);
}
