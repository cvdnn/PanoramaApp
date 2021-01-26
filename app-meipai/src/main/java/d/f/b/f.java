package d.f.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout.a;

/* compiled from: Placeholder */
public class f extends View {

    /* renamed from: a reason: collision with root package name */
    public int f4760a;

    /* renamed from: b reason: collision with root package name */
    public View f4761b;

    /* renamed from: c reason: collision with root package name */
    public int f4762c;

    public View getContent() {
        return this.f4761b;
    }

    public int getEmptyVisibility() {
        return this.f4762c;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Align.LEFT);
            String str = "?";
            paint.getTextBounds(str, 0, 1, rect);
            canvas.drawText(str, ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) rect.height()) / 2.0f) + (((float) height) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i2) {
        if (this.f4760a != i2) {
            View view = this.f4761b;
            if (view != null) {
                view.setVisibility(0);
                ((a) this.f4761b.getLayoutParams()).Z = false;
                this.f4761b = null;
            }
            this.f4760a = i2;
            if (i2 != -1) {
                View findViewById = ((View) getParent()).findViewById(i2);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
        }
    }

    public void setEmptyVisibility(int i2) {
        this.f4762c = i2;
    }
}
