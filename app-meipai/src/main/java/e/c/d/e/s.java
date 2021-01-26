package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.spinphoto.SpinPhotoActivity;
import com.baidu.picapture.ui.widget.SpinView;
import d.k.e;

/* compiled from: ActivitySpinPhotoBinding */
public abstract class s extends ViewDataBinding {
    public final Button n;
    public final Button o;
    public final SpinView p;
    public SpinPhotoActivity q;

    public s(Object obj, View view, int i2, Button button, Button button2, SpinView spinView) {
        super(obj, view, i2);
        this.n = button;
        this.o = button2;
        this.p = spinView;
    }

    public static s a(LayoutInflater layoutInflater) {
        return (s) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_spin_photo, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(SpinPhotoActivity spinPhotoActivity);
}
