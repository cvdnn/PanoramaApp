package e.c.d.m.i.i;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.baidu.picapture.ui.widget.dialog.CaptureGuideDialog;

/* compiled from: lambda */
public final /* synthetic */ class a implements OnCheckedChangeListener {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ CaptureGuideDialog f6820a;

    public /* synthetic */ a(CaptureGuideDialog captureGuideDialog) {
        this.f6820a = captureGuideDialog;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f6820a.a(compoundButton, z);
    }
}
