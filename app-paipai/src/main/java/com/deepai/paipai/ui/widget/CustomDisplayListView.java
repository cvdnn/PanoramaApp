package com.deepai.paipai.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class CustomDisplayListView extends ListView {
    public CustomDisplayListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CustomDisplayListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomDisplayListView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
