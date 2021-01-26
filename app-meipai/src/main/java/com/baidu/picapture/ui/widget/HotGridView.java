package com.baidu.picapture.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;

public class HotGridView extends GridView {
    public HotGridView(Context context) {
        super(context);
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public HotGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HotGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
