package e.c.d.h.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: OnClickListener */
public final class a implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public final OnExtClickListener f6099a;

    /* renamed from: b reason: collision with root package name */
    public final int f6100b;

    /* renamed from: e.c.d.h.a.a$a reason: collision with other inner class name */
    /* compiled from: OnClickListener */
    public interface OnExtClickListener {
        void onExtClick(int i2, View view);
    }

    public a(OnExtClickListener aVar, int i2) {
        this.f6099a = aVar;
        this.f6100b = i2;
    }

    public void onClick(View view) {
        this.f6099a.onExtClick(this.f6100b, view);
    }
}
