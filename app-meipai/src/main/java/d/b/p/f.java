package d.b.p;

import a.a.a.a.b.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import d.h.l.b;

/* compiled from: AppCompatButton */
public class f extends Button implements b {

    /* renamed from: a reason: collision with root package name */
    public final e f4319a;

    /* renamed from: b reason: collision with root package name */
    public final y f4320b;

    public f(Context context) {
        this(context, null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f4319a;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.f4320b;
        if (yVar != null) {
            yVar.a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.a0) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f4320b;
        if (yVar != null) {
            return Math.round(yVar.f4495i.f4272e);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.a0) {
            return super.getAutoSizeMinTextSize();
        }
        y yVar = this.f4320b;
        if (yVar != null) {
            return Math.round(yVar.f4495i.f4271d);
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.a0) {
            return super.getAutoSizeStepGranularity();
        }
        y yVar = this.f4320b;
        if (yVar != null) {
            return Math.round(yVar.f4495i.f4270c);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.a0) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y yVar = this.f4320b;
        return yVar != null ? yVar.f4495i.f4273f : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        int i2 = 0;
        if (b.a0) {
            if (super.getAutoSizeTextType() == 1) {
                i2 = 1;
            }
            return i2;
        }
        y yVar = this.f4320b;
        if (yVar != null) {
            return yVar.f4495i.f4268a;
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f4319a;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        e eVar = this.f4319a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        y yVar = this.f4320b;
        if (yVar != null && !b.a0) {
            yVar.f4495i.a();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        y yVar = this.f4320b;
        if (yVar != null && !b.a0 && yVar.b()) {
            this.f4320b.f4495i.a();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (b.a0) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        y yVar = this.f4320b;
        if (yVar != null) {
            yVar.a(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (b.a0) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        y yVar = this.f4320b;
        if (yVar != null) {
            yVar.a(iArr, i2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (b.a0) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        y yVar = this.f4320b;
        if (yVar != null) {
            yVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f4319a;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f4319a;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(a.a((TextView) this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        y yVar = this.f4320b;
        if (yVar != null) {
            yVar.f4487a.setAllCaps(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f4319a;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        e eVar = this.f4319a;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        y yVar = this.f4320b;
        if (yVar != null) {
            yVar.a(context, i2);
        }
    }

    public void setTextSize(int i2, float f2) {
        boolean z = b.a0;
        if (z) {
            super.setTextSize(i2, f2);
            return;
        }
        y yVar = this.f4320b;
        if (yVar != null && !z && !yVar.b()) {
            yVar.f4495i.a(i2, f2);
        }
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.b.a.buttonStyle);
    }

    public f(Context context, AttributeSet attributeSet, int i2) {
        u0.a(context);
        super(context, attributeSet, i2);
        e eVar = new e(this);
        this.f4319a = eVar;
        eVar.a(attributeSet, i2);
        y yVar = new y(this);
        this.f4320b = yVar;
        yVar.a(attributeSet, i2);
        this.f4320b.a();
    }
}
