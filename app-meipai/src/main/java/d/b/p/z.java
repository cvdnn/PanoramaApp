package d.b.p;

import a.a.a.a.b.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import d.h.f.c;
import d.h.l.b;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: AppCompatTextView */
public class z extends TextView implements b {

    /* renamed from: a reason: collision with root package name */
    public final e f4504a;

    /* renamed from: b reason: collision with root package name */
    public final y f4505b;

    /* renamed from: c reason: collision with root package name */
    public final x f4506c;

    /* renamed from: d reason: collision with root package name */
    public Future<d.h.i.b> f4507d;

    public z(Context context) {
        this(context, null);
    }

    public final void d() {
        Future<d.h.i.b> future = this.f4507d;
        if (future != null) {
            try {
                this.f4507d = null;
                d.h.i.b bVar = (d.h.i.b) future.get();
                a.a((TextView) this);
                if (bVar != null) {
                    throw null;
                }
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f4504a;
        if (eVar != null) {
            eVar.a();
        }
        y yVar = this.f4505b;
        if (yVar != null) {
            yVar.a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.a0) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f4505b;
        if (yVar != null) {
            return Math.round(yVar.f4495i.f4272e);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.a0) {
            return super.getAutoSizeMinTextSize();
        }
        y yVar = this.f4505b;
        if (yVar != null) {
            return Math.round(yVar.f4495i.f4271d);
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.a0) {
            return super.getAutoSizeStepGranularity();
        }
        y yVar = this.f4505b;
        if (yVar != null) {
            return Math.round(yVar.f4495i.f4270c);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.a0) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y yVar = this.f4505b;
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
        y yVar = this.f4505b;
        if (yVar != null) {
            return yVar.f4495i.f4268a;
        }
        return 0;
    }

    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f4504a;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        e eVar = this.f4504a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        v0 v0Var = this.f4505b.f4494h;
        if (v0Var != null) {
            return v0Var.f4456a;
        }
        return null;
    }

    public Mode getSupportCompoundDrawablesTintMode() {
        v0 v0Var = this.f4505b.f4494h;
        if (v0Var != null) {
            return v0Var.f4457b;
        }
        return null;
    }

    public CharSequence getText() {
        d();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        if (VERSION.SDK_INT < 28) {
            x xVar = this.f4506c;
            if (xVar != null) {
                return xVar.a();
            }
        }
        return super.getTextClassifier();
    }

    public d.h.i.b.a getTextMetricsParamsCompat() {
        return a.a((TextView) this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        a.a(onCreateInputConnection, editorInfo, (View) this);
        return onCreateInputConnection;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        y yVar = this.f4505b;
        if (yVar != null && !b.a0) {
            yVar.f4495i.a();
        }
    }

    public void onMeasure(int i2, int i3) {
        d();
        super.onMeasure(i2, i3);
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        y yVar = this.f4505b;
        if (yVar != null && !b.a0 && yVar.b()) {
            this.f4505b.f4495i.a();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (b.a0) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        y yVar = this.f4505b;
        if (yVar != null) {
            yVar.a(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (b.a0) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        y yVar = this.f4505b;
        if (yVar != null) {
            yVar.a(iArr, i2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (b.a0) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        y yVar = this.f4505b;
        if (yVar != null) {
            yVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f4504a;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f4504a;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f4505b;
        if (yVar != null) {
            yVar.a();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f4505b;
        if (yVar != null) {
            yVar.a();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f4505b;
        if (yVar != null) {
            yVar.a();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f4505b;
        if (yVar != null) {
            yVar.a();
        }
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(a.a((TextView) this, callback));
    }

    public void setFirstBaselineToTopHeight(int i2) {
        if (VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            a.a((TextView) this, i2);
        }
    }

    public void setLastBaselineToBottomHeight(int i2) {
        if (VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            a.b((TextView) this, i2);
        }
    }

    public void setLineHeight(int i2) {
        a.c((TextView) this, i2);
    }

    public void setPrecomputedText(d.h.i.b bVar) {
        a.a((TextView) this);
        if (bVar != null) {
            throw null;
        }
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f4504a;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        e eVar = this.f4504a;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        y yVar = this.f4505b;
        if (yVar.f4494h == null) {
            yVar.f4494h = new v0();
        }
        v0 v0Var = yVar.f4494h;
        v0Var.f4456a = colorStateList;
        v0Var.f4459d = colorStateList != null;
        v0 v0Var2 = yVar.f4494h;
        yVar.f4488b = v0Var2;
        yVar.f4489c = v0Var2;
        yVar.f4490d = v0Var2;
        yVar.f4491e = v0Var2;
        yVar.f4492f = v0Var2;
        yVar.f4493g = v0Var2;
        this.f4505b.a();
    }

    public void setSupportCompoundDrawablesTintMode(Mode mode) {
        y yVar = this.f4505b;
        if (yVar.f4494h == null) {
            yVar.f4494h = new v0();
        }
        v0 v0Var = yVar.f4494h;
        v0Var.f4457b = mode;
        v0Var.f4458c = mode != null;
        v0 v0Var2 = yVar.f4494h;
        yVar.f4488b = v0Var2;
        yVar.f4489c = v0Var2;
        yVar.f4490d = v0Var2;
        yVar.f4491e = v0Var2;
        yVar.f4492f = v0Var2;
        yVar.f4493g = v0Var2;
        this.f4505b.a();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        y yVar = this.f4505b;
        if (yVar != null) {
            yVar.a(context, i2);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        if (VERSION.SDK_INT < 28) {
            x xVar = this.f4506c;
            if (xVar != null) {
                xVar.f4483b = textClassifier;
                return;
            }
        }
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future<d.h.i.b> future) {
        this.f4507d = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(d.h.i.b.a aVar) {
        TextDirectionHeuristic textDirectionHeuristic = aVar.f4887b;
        int i2 = 1;
        if (!(textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                i2 = 2;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                i2 = 3;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                i2 = 4;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                i2 = 5;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                i2 = 6;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                i2 = 7;
            }
        }
        setTextDirection(i2);
        getPaint().set(aVar.f4886a);
        setBreakStrategy(aVar.f4888c);
        setHyphenationFrequency(aVar.f4889d);
    }

    public void setTextSize(int i2, float f2) {
        boolean z = b.a0;
        if (z) {
            super.setTextSize(i2, f2);
            return;
        }
        y yVar = this.f4505b;
        if (yVar != null && !z && !yVar.b()) {
            yVar.f4495i.a(i2, f2);
        }
    }

    public void setTypeface(Typeface typeface, int i2) {
        Typeface a2 = (typeface == null || i2 <= 0) ? null : c.a(getContext(), typeface, i2);
        if (a2 != null) {
            typeface = a2;
        }
        super.setTypeface(typeface, i2);
    }

    public z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public z(Context context, AttributeSet attributeSet, int i2) {
        u0.a(context);
        super(context, attributeSet, i2);
        e eVar = new e(this);
        this.f4504a = eVar;
        eVar.a(attributeSet, i2);
        y yVar = new y(this);
        this.f4505b = yVar;
        yVar.a(attributeSet, i2);
        this.f4505b.a();
        this.f4506c = new x(this);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i2 != 0 ? d.b.l.a.a.b(context, i2) : null;
        Drawable b3 = i3 != 0 ? d.b.l.a.a.b(context, i3) : null;
        Drawable b4 = i4 != 0 ? d.b.l.a.a.b(context, i4) : null;
        if (i5 != 0) {
            drawable = d.b.l.a.a.b(context, i5);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b2, b3, b4, drawable);
        y yVar = this.f4505b;
        if (yVar != null) {
            yVar.a();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i2 != 0 ? d.b.l.a.a.b(context, i2) : null;
        Drawable b3 = i3 != 0 ? d.b.l.a.a.b(context, i3) : null;
        Drawable b4 = i4 != 0 ? d.b.l.a.a.b(context, i4) : null;
        if (i5 != 0) {
            drawable = d.b.l.a.a.b(context, i5);
        }
        setCompoundDrawablesWithIntrinsicBounds(b2, b3, b4, drawable);
        y yVar = this.f4505b;
        if (yVar != null) {
            yVar.a();
        }
    }
}
