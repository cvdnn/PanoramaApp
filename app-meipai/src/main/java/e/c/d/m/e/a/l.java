package e.c.d.m.e.a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.baidu.picapture.ui.spin.capture.SpinCaptureActivity;

/* compiled from: lambda */
public final /* synthetic */ class l implements OnCheckedChangeListener {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ SpinCaptureActivity f6672a;

    public /* synthetic */ l(SpinCaptureActivity spinCaptureActivity) {
        this.f6672a = spinCaptureActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f6672a.a(compoundButton, z);
    }
}
