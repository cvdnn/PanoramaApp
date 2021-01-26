package d.h.k.w;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: AccessibilityClickableSpanCompat */
public final class a extends ClickableSpan {

    /* renamed from: a reason: collision with root package name */
    public final int f4949a;

    /* renamed from: b reason: collision with root package name */
    public final b f4950b;

    /* renamed from: c reason: collision with root package name */
    public final int f4951c;

    public a(int i2, b bVar, int i3) {
        this.f4949a = i2;
        this.f4950b = bVar;
        this.f4951c = i3;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f4949a);
        b bVar = this.f4950b;
        bVar.f4953a.performAction(this.f4951c, bundle);
    }
}
