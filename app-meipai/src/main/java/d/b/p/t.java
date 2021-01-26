package d.b.p;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import d.b.a;

/* compiled from: AppCompatSeekBar */
public class t extends SeekBar {

    /* renamed from: a reason: collision with root package name */
    public final u f4447a;

    public t(Context context, AttributeSet attributeSet) {
        int i2 = a.seekBarStyle;
        super(context, attributeSet, i2);
        u uVar = new u(this);
        this.f4447a = uVar;
        uVar.a(attributeSet, i2);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        u uVar = this.f4447a;
        Drawable drawable = uVar.f4449e;
        if (drawable != null && drawable.isStateful() && drawable.setState(uVar.f4448d.getDrawableState())) {
            uVar.f4448d.invalidateDrawable(drawable);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f4447a.f4449e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4447a.a(canvas);
    }
}
