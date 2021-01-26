package com.youth.banner.util;

import android.content.res.Resources;
import android.graphics.Outline;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;

public class BannerUtils {
    public static float dp2px(float f2) {
        return TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    public static int getRealPosition(boolean z, int i2, int i3) {
        if (!z) {
            return i2;
        }
        r2 = i2 == 0 ? i3 - 1 : i2 == i3 + 1 ? 0 : i2 - 1;
        return r2;
    }

    public static View getView(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        LayoutParams layoutParams = inflate.getLayoutParams();
        if (!(layoutParams.height == -1 && layoutParams.width == -1)) {
            layoutParams.height = -1;
            layoutParams.width = -1;
            inflate.setLayoutParams(layoutParams);
        }
        return inflate;
    }

    public static void setBannerRound(View view, final float f2) {
        view.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f2);
            }
        });
        view.setClipToOutline(true);
    }
}
