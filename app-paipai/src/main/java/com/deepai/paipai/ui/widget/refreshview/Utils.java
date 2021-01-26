package com.deepai.paipai.ui.widget.refreshview;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public class Utils {
    public static double mapValueFromRangeToRange(double value, double fromLow, double fromHigh, double toLow, double toHigh) {
        return (((value - fromLow) / (fromHigh - fromLow)) * (toHigh - toLow)) + toLow;
    }

    public static void setMargin(View target, int l, int t, int r, int b) {
        if (target.getLayoutParams() instanceof MarginLayoutParams) {
            ((MarginLayoutParams) target.getLayoutParams()).setMargins(l, t, r, b);
            target.requestLayout();
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }
}
