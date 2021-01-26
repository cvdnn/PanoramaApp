package com.youth.banner.itemdecoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.n;

public class MarginDecoration extends n {
    public int mMarginPx;

    public MarginDecoration(int i2) {
        this.mMarginPx = i2;
    }

    private LinearLayoutManager requireLinearLayoutManager(RecyclerView recyclerView) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        throw new IllegalStateException("The layoutManager must be LinearLayoutManager");
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, a0 a0Var) {
        if (requireLinearLayoutManager(recyclerView).getOrientation() == 1) {
            int i2 = this.mMarginPx;
            rect.top = i2;
            rect.bottom = i2;
            return;
        }
        int i3 = this.mMarginPx;
        rect.left = i3;
        rect.right = i3;
    }
}
