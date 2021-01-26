package e.g.a.a.h0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import e.g.a.a.e0.j;

/* compiled from: CutoutDrawable */
public class g extends e.g.a.a.e0.g {
    public final Paint w;
    public final RectF x;
    public int y;

    public g() {
        this(null);
    }

    public void a(float f2, float f3, float f4, float f5) {
        RectF rectF = this.x;
        if (f2 != rectF.left || f3 != rectF.top || f4 != rectF.right || f5 != rectF.bottom) {
            this.x.set(f2, f3, f4, f5);
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        } else {
            this.y = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null);
        }
        super.draw(canvas);
        canvas.drawRect(this.x, this.w);
        if (!(getCallback() instanceof View)) {
            canvas.restoreToCount(this.y);
        }
    }

    public g(j jVar) {
        if (jVar == null) {
            jVar = new j();
        }
        super(jVar);
        Paint paint = new Paint(1);
        this.w = paint;
        paint.setStyle(Style.FILL_AND_STROKE);
        this.w.setColor(-1);
        this.w.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        this.x = new RectF();
    }
}
