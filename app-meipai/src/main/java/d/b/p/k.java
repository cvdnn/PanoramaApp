package d.b.p;

import a.a.a.a.b.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;

/* compiled from: AppCompatEditText */
public class k extends EditText {

    /* renamed from: a reason: collision with root package name */
    public final e f4377a;

    /* renamed from: b reason: collision with root package name */
    public final y f4378b;

    /* renamed from: c reason: collision with root package name */
    public final x f4379c;

    public k(Context context) {
        this(context, null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f4377a;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.f4378b;
        if (yVar != null) {
            yVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f4377a;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        e eVar = this.f4377a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public TextClassifier getTextClassifier() {
        if (VERSION.SDK_INT < 28) {
            x xVar = this.f4379c;
            if (xVar != null) {
                return xVar.a();
            }
        }
        return super.getTextClassifier();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        a.a(onCreateInputConnection, editorInfo, (View) this);
        return onCreateInputConnection;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f4377a;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f4377a;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(a.a((TextView) this, callback));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f4377a;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        e eVar = this.f4377a;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        y yVar = this.f4378b;
        if (yVar != null) {
            yVar.a(context, i2);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        if (VERSION.SDK_INT < 28) {
            x xVar = this.f4379c;
            if (xVar != null) {
                xVar.f4483b = textClassifier;
                return;
            }
        }
        super.setTextClassifier(textClassifier);
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.b.a.editTextStyle);
    }

    public Editable getText() {
        if (VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    public k(Context context, AttributeSet attributeSet, int i2) {
        u0.a(context);
        super(context, attributeSet, i2);
        e eVar = new e(this);
        this.f4377a = eVar;
        eVar.a(attributeSet, i2);
        y yVar = new y(this);
        this.f4378b = yVar;
        yVar.a(attributeSet, i2);
        this.f4378b.a();
        this.f4379c = new x(this);
    }
}
