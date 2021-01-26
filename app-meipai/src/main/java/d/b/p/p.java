package d.b.p;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import d.b.j;
import d.b.l.a.a;

/* compiled from: AppCompatPopupWindow */
public class p extends PopupWindow {
    public p(Context context, AttributeSet attributeSet, int i2, int i3) {
        Drawable drawable;
        super(context, attributeSet, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.PopupWindow, i2, i3);
        if (obtainStyledAttributes.hasValue(j.PopupWindow_overlapAnchor)) {
            setOverlapAnchor(obtainStyledAttributes.getBoolean(j.PopupWindow_overlapAnchor, false));
        }
        int i4 = j.PopupWindow_android_popupBackground;
        if (obtainStyledAttributes.hasValue(i4)) {
            int resourceId = obtainStyledAttributes.getResourceId(i4, 0);
            if (resourceId != 0) {
                drawable = a.b(context, resourceId);
                setBackgroundDrawable(drawable);
                obtainStyledAttributes.recycle();
            }
        }
        drawable = obtainStyledAttributes.getDrawable(i4);
        setBackgroundDrawable(drawable);
        obtainStyledAttributes.recycle();
    }

    public void showAsDropDown(View view, int i2, int i3) {
        super.showAsDropDown(view, i2, i3);
    }

    public void update(View view, int i2, int i3, int i4, int i5) {
        super.update(view, i2, i3, i4, i5);
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        super.showAsDropDown(view, i2, i3, i4);
    }
}
