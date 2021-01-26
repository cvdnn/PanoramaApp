package d.b.p;

import a.a.a.a.b.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;

/* compiled from: AppCompatCheckedTextView */
public class h extends CheckedTextView {

    /* renamed from: b reason: collision with root package name */
    public static final int[] f4336b = {16843016};

    /* renamed from: a reason: collision with root package name */
    public final y f4337a;

    public h(Context context, AttributeSet attributeSet) {
        u0.a(context);
        super(context, attributeSet, 16843720);
        y yVar = new y(this);
        this.f4337a = yVar;
        yVar.a(attributeSet, 16843720);
        this.f4337a.a();
        x0 a2 = x0.a(getContext(), attributeSet, f4336b, 16843720, 0);
        setCheckMarkDrawable(a2.b(0));
        a2.f4485b.recycle();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        y yVar = this.f4337a;
        if (yVar != null) {
            yVar.a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        a.a(onCreateInputConnection, editorInfo, (View) this);
        return onCreateInputConnection;
    }

    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(d.b.l.a.a.b(getContext(), i2));
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(a.a((TextView) this, callback));
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        y yVar = this.f4337a;
        if (yVar != null) {
            yVar.a(context, i2);
        }
    }
}
