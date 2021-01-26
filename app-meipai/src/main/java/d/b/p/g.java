package d.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import d.b.a;

/* compiled from: AppCompatCheckBox */
public class g extends CheckBox {

    /* renamed from: a reason: collision with root package name */
    public final i f4333a;

    /* renamed from: b reason: collision with root package name */
    public final e f4334b;

    /* renamed from: c reason: collision with root package name */
    public final y f4335c;

    public g(Context context) {
        this(context, null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f4334b;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.f4335c;
        if (yVar != null) {
            yVar.a();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        i iVar = this.f4333a;
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f4334b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        e eVar = this.f4334b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        i iVar = this.f4333a;
        if (iVar != null) {
            return iVar.f4350b;
        }
        return null;
    }

    public Mode getSupportButtonTintMode() {
        i iVar = this.f4333a;
        if (iVar != null) {
            return iVar.f4351c;
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f4334b;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f4334b;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.f4333a;
        if (iVar == null) {
            return;
        }
        if (iVar.f4354f) {
            iVar.f4354f = false;
            return;
        }
        iVar.f4354f = true;
        iVar.a();
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f4334b;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        e eVar = this.f4334b;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.f4333a;
        if (iVar != null) {
            iVar.f4350b = colorStateList;
            iVar.f4352d = true;
            iVar.a();
        }
    }

    public void setSupportButtonTintMode(Mode mode) {
        i iVar = this.f4333a;
        if (iVar != null) {
            iVar.f4351c = mode;
            iVar.f4353e = true;
            iVar.a();
        }
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.checkboxStyle);
    }

    public g(Context context, AttributeSet attributeSet, int i2) {
        u0.a(context);
        super(context, attributeSet, i2);
        i iVar = new i(this);
        this.f4333a = iVar;
        iVar.a(attributeSet, i2);
        e eVar = new e(this);
        this.f4334b = eVar;
        eVar.a(attributeSet, i2);
        y yVar = new y(this);
        this.f4335c = yVar;
        yVar.a(attributeSet, i2);
    }

    public void setButtonDrawable(int i2) {
        setButtonDrawable(d.b.l.a.a.b(getContext(), i2));
    }
}
