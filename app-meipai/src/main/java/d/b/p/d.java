package d.b.p;

import a.a.a.a.b.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

/* compiled from: AppCompatAutoCompleteTextView */
public class d extends AutoCompleteTextView {

    /* renamed from: c reason: collision with root package name */
    public static final int[] f4307c = {16843126};

    /* renamed from: a reason: collision with root package name */
    public final e f4308a;

    /* renamed from: b reason: collision with root package name */
    public final y f4309b;

    public d(Context context) {
        this(context, null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f4308a;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.f4309b;
        if (yVar != null) {
            yVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f4308a;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        e eVar = this.f4308a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        a.a(onCreateInputConnection, editorInfo, (View) this);
        return onCreateInputConnection;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f4308a;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f4308a;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(a.a((TextView) this, callback));
    }

    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(d.b.l.a.a.b(getContext(), i2));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f4308a;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        e eVar = this.f4308a;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        y yVar = this.f4309b;
        if (yVar != null) {
            yVar.a(context, i2);
        }
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.b.a.autoCompleteTextViewStyle);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        u0.a(context);
        super(context, attributeSet, i2);
        x0 a2 = x0.a(getContext(), attributeSet, f4307c, i2, 0);
        if (a2.f(0)) {
            setDropDownBackgroundDrawable(a2.b(0));
        }
        a2.f4485b.recycle();
        e eVar = new e(this);
        this.f4308a = eVar;
        eVar.a(attributeSet, i2);
        y yVar = new y(this);
        this.f4309b = yVar;
        yVar.a(attributeSet, i2);
        this.f4309b.a();
    }
}
