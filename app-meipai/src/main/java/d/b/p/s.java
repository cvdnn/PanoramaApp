package d.b.p;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import d.b.a;

/* compiled from: AppCompatRatingBar */
public class s extends RatingBar {

    /* renamed from: a reason: collision with root package name */
    public final q f4439a;

    public s(Context context, AttributeSet attributeSet) {
        int i2 = a.ratingBarStyle;
        super(context, attributeSet, i2);
        q qVar = new q(this);
        this.f4439a = qVar;
        qVar.a(attributeSet, i2);
    }

    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap bitmap = this.f4439a.f4422b;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }
}
