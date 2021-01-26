package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.widget.dialog.CaptureGuideDialog;
import d.k.e;

/* compiled from: CaptureGuideDialogBinding */
public abstract class i0 extends ViewDataBinding {
    public final Button n;
    public final CheckBox o;
    public CaptureGuideDialog p;

    public i0(Object obj, View view, int i2, Button button, CheckBox checkBox) {
        super(obj, view, i2);
        this.n = button;
        this.o = checkBox;
    }

    public static i0 a(LayoutInflater layoutInflater) {
        return (i0) ViewDataBinding.a(layoutInflater, (int) R.layout.capture_guide_dialog, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(CaptureGuideDialog captureGuideDialog);
}
