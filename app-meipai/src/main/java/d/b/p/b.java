package d.b.p;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

/* compiled from: ActionBarBackgroundDrawable */
public class b extends Drawable {

    /* renamed from: a reason: collision with root package name */
    public final ActionBarContainer f4290a;

    public b(ActionBarContainer actionBarContainer) {
        this.f4290a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f4290a;
        if (actionBarContainer.f733h) {
            Drawable drawable = actionBarContainer.f732g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f730e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f4290a;
        Drawable drawable3 = actionBarContainer2.f731f;
        if (drawable3 != null && actionBarContainer2.f734i) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f4290a;
        if (actionBarContainer.f733h) {
            Drawable drawable = actionBarContainer.f732g;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f730e;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
