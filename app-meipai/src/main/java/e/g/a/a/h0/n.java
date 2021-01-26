package e.g.a.a.h0;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: EndIconDelegate */
public abstract class n {

    /* renamed from: a reason: collision with root package name */
    public TextInputLayout f8189a;

    /* renamed from: b reason: collision with root package name */
    public Context f8190b;

    /* renamed from: c reason: collision with root package name */
    public CheckableImageButton f8191c;

    public n(TextInputLayout textInputLayout) {
        this.f8189a = textInputLayout;
        this.f8190b = textInputLayout.getContext();
        this.f8191c = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public boolean a(int i2) {
        return true;
    }

    public boolean b() {
        return false;
    }
}
