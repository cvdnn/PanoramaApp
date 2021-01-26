package d.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: AppCompatImageView */
public class n extends ImageView {
    public final e mBackgroundTintHelper;
    public final m mImageHelper;

    public n(Context context) {
        this(context, null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a();
        }
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        m mVar = this.mImageHelper;
        if (mVar != null) {
            v0 v0Var = mVar.f4398b;
            if (v0Var != null) {
                return v0Var.f4456a;
            }
        }
        return null;
    }

    public Mode getSupportImageTintMode() {
        m mVar = this.mImageHelper;
        if (mVar != null) {
            v0 v0Var = mVar.f4398b;
            if (v0Var != null) {
                return v0Var.f4457b;
            }
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        if (!(!(this.mImageHelper.f4397a.getBackground() instanceof RippleDrawable)) || !super.hasOverlappingRendering()) {
            return false;
        }
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setImageResource(int i2) {
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a(i2);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a(colorStateList);
        }
    }

    public void setSupportImageTintMode(Mode mode) {
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a(mode);
        }
    }

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public n(Context context, AttributeSet attributeSet, int i2) {
        u0.a(context);
        super(context, attributeSet, i2);
        e eVar = new e(this);
        this.mBackgroundTintHelper = eVar;
        eVar.a(attributeSet, i2);
        m mVar = new m(this);
        this.mImageHelper = mVar;
        mVar.a(attributeSet, i2);
    }
}
