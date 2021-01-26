package e.g.a.a.z;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* compiled from: VisibilityAwareImageButton */
public class i extends ImageButton {

    /* renamed from: a reason: collision with root package name */
    public int f8466a;

    public final void a(int i2, boolean z) {
        super.setVisibility(i2);
        if (z) {
            this.f8466a = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.f8466a;
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        this.f8466a = i2;
    }
}
