package d.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import d.b.a;

/* compiled from: AppCompatImageButton */
public class l extends ImageButton {

    /* renamed from: a reason: collision with root package name */
    public final e f4395a;

    /* renamed from: b reason: collision with root package name */
    public final m f4396b;

    public l(Context context) {
        this(context, null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f4395a;
        if (eVar != null) {
            eVar.a();
        }
        m mVar = this.f4396b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f4395a;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        e eVar = this.f4395a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        m mVar = this.f4396b;
        if (mVar != null) {
            v0 v0Var = mVar.f4398b;
            if (v0Var != null) {
                return v0Var.f4456a;
            }
        }
        return null;
    }

    public Mode getSupportImageTintMode() {
        m mVar = this.f4396b;
        if (mVar != null) {
            v0 v0Var = mVar.f4398b;
            if (v0Var != null) {
                return v0Var.f4457b;
            }
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        if (!(!(this.f4396b.f4397a.getBackground() instanceof RippleDrawable)) || !super.hasOverlappingRendering()) {
            return false;
        }
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f4395a;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f4395a;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m mVar = this.f4396b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m mVar = this.f4396b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setImageResource(int i2) {
        this.f4396b.a(i2);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m mVar = this.f4396b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f4395a;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        e eVar = this.f4395a;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        m mVar = this.f4396b;
        if (mVar != null) {
            mVar.a(colorStateList);
        }
    }

    public void setSupportImageTintMode(Mode mode) {
        m mVar = this.f4396b;
        if (mVar != null) {
            mVar.a(mode);
        }
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.imageButtonStyle);
    }

    public l(Context context, AttributeSet attributeSet, int i2) {
        u0.a(context);
        super(context, attributeSet, i2);
        e eVar = new e(this);
        this.f4395a = eVar;
        eVar.a(attributeSet, i2);
        m mVar = new m(this);
        this.f4396b = mVar;
        mVar.a(attributeSet, i2);
    }
}
